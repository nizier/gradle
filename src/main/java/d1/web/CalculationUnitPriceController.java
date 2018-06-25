package d1.web;

import com.alibaba.fastjson.JSONArray;
import d1.domain.*;
import d1.domain.UnitPriceRange.*;
import d1.domain.mgr.UNIT_PRICE_RANGEMgr;
import d1.domain.vm.CalculationUnitPrice_Get_Vm;
import d1.domain.vm.UNIT_PRICE_RANGE_TEMP_INSERT_VM;
import d1.service.CheckConfigService;
import d1.service.LoggerService;
import d1.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CalculationUnitPriceController {
    private Logger logger = LoggerFactory.getLogger(UnitPriceRangeController.class);

    @Autowired
    private CHECK_LOGMapper loggerMapper;
    @Autowired
    private UNIT_PRICE_RANGEMapper unit_price_rangeMapper;
    @Autowired
    private UNIT_PRICE_RANGE_TEMPMapper unit_price_range_tempMapper;
    @Autowired
    private CHECK_CONFIGMapper check_configMapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    //根据货物批次获取置信区间
    private String UnitPriceRangeJson = null;
    private double computeBatchUValue(int batch){
        if(UnitPriceRangeJson==null)
            UnitPriceRangeJson= GetByIdConfigInfo("UnitPriceRangeJson");
        JSONArray jsonArray = JSONArray.parseArray(UnitPriceRangeJson);
        for (int i = 0;i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            int low = -1;
            int top = Integer.MAX_VALUE;
            if(object.containsKey("LowBatch")){
                low = object.getInteger("LowBatch");
            }
            if(object.containsKey("TopBatch")){
                top = object.getInteger(("TopBatch"));
            }
            double v = object.getDoubleValue("Value");
            if(batch>=low&&batch<top){
                return v;
            }
        }
        return 1.96;//缺省值
    }
    private void Compute(CalculationUnitPrice_Get_Vm model){
        try{
            //根据UserId 获取用户的部门及组织机构
            UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

            LoggerService.Instance().setLoggerMapper(loggerMapper);
            //是否替换人工修改的值
            String IsReplaceValue= GetByIdConfigInfo("IsReplaceValue");
            //数据年份
            int days=365;
            int UnitPriceYears=Integer.parseInt(GetByIdConfigInfo("UnitPriceYears"));
            days=UnitPriceYears*days;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date beforeDate= DateUtils.addDays(new Date(),-days);
            String strBeforeDate= df.format(beforeDate);

            //区间值
            if(IsReplaceValue.equals("是"))
            {
                //删除所有的单位货值表数据
                int deleteCount1= unit_price_rangeMapper.deleteAll();

                LoggerService.Instance().info("删除UNIT_PRICE_RANGE表数据成功,总条数="+deleteCount1,logger);
            }
            else
            {
                //查找所有修改字段值等于1的数据 删除所有等于0的数据
                int deleteModify0=unit_price_rangeMapper.deleteModify();
                LoggerService.Instance().info("删除UNIT_PRICE_RANGE表未修改的数据成功,总条数="+deleteModify0,logger);

                List<UNIT_PRICE_RANGE> listModify1= unit_price_rangeMapper.listUnitPriceRange();
                //写入缓存
                for (UNIT_PRICE_RANGE m:
                        listModify1) {
                    UNIT_PRICE_RANGEMgr.Instance().SetUNIT_PRICE_RANGEToCache(m);
                }
            }

            //删除所有temp数据
            int deleteCount=  unit_price_range_tempMapper.deleteAll();
            LoggerService.Instance().info("删除UNIT_PRICE_RANGE_TEMP表数据成功,总条数="+deleteCount,logger);

            //数据表的用户名
            String unitPriceDataTable= GetByIdConfigInfo("UnitPriceDataTable");
            UNIT_PRICE_RANGE_TEMP_INSERT_VM insertVm=new UNIT_PRICE_RANGE_TEMP_INSERT_VM();
            insertVm.setUnitPriceDataTable(unitPriceDataTable);
            insertVm.setStrBeforeDate(strBeforeDate);
            int insertCount= unit_price_range_tempMapper.InsertUnitPriceTemp(insertVm);
            LoggerService.Instance().info("插入UNIT_PRICE_RANGE_TEMP表数据成功,总条数="+insertCount,logger);

            UNIT_PRICE_RANGE unit_price_range=new UNIT_PRICE_RANGE();
            List<RG_UNIT_RANGE_PRICE> listData=unit_price_range_tempMapper.listRgUnitData();
            LoggerService.Instance().info("单位货值表开始计算...",logger);
            for (RG_UNIT_RANGE_PRICE i :
                    listData) {
                // 是否存在else中的数据集中，存在continue
                if(IsReplaceValue.equals("否")) {
                    String key = i.getProdHsCode() + "__" + i.getTradeModeCode() + "__" + i.getExportOrImport();
                    if (UNIT_PRICE_RANGEMgr.Instance().getUNIT_PRICE_RANGEFromCache(key)) continue;
                }

                //平均值及期望值
                BigDecimal avg=BigDecimal.valueOf(0);
                BigDecimal num=new BigDecimal(i.getNum());
                BigDecimal sumUnitPrice=i.getSumUnitPrice()==null?BigDecimal.valueOf(0):i.getSumUnitPrice();
                if(!IsEqualZero(sumUnitPrice))
                {
                    avg=sumUnitPrice.divide(num,6,BigDecimal.ROUND_HALF_UP);
                }

                //方差，根据hs编码，出入境，贸易方式查找此hs编码的单价信息，循环
                List<UNIT_PRICE_RANGE_TEMP> unit_price_range_tempList= unit_price_range_tempMapper.listUnitPriceTemp(i.getProdHsCode(),i.getTradeModeCode(),i.getExportOrImport());
                double sumPow=0;
                for (UNIT_PRICE_RANGE_TEMP j:
                        unit_price_range_tempList) {
                    if(j.getUnitPrice()!=null)
                    {
                        sumPow+= Math.pow(j.getUnitPrice().subtract(avg).doubleValue(),2);
                    }
                }
                //最终的方差值
                BigDecimal bsumPow = new BigDecimal(sumPow);
                BigDecimal fangcha =bsumPow.divide(num,6,BigDecimal.ROUND_HALF_UP);

                //标准差
                double bzc=Math.sqrt(fangcha.doubleValue());
                BigDecimal bigdeBZC= new BigDecimal(bzc);

                //标准差*系数
                BigDecimal xsz=BigDecimal.valueOf(0);
                //以下数字都需要在配置表中读取
                double xsValue=  computeBatchUValue(i.getCountBathNo());
                BigDecimal xs=new BigDecimal(String.valueOf( xsValue));
                xsz=xs.multiply(bigdeBZC);
                BigDecimal lower=avg.subtract(xsz);
                BigDecimal top=avg.add(xsz);

                //修改前
//            if(i.getCountBathNo()>500||i.getCountBathNo()<60) //百分之99
//            {
//                BigDecimal xs=new BigDecimal(2.58);
//                xsz=xs.multiply(bigdeBZC);
//            }
//            if(i.getCountBathNo()>=200&&i.getCountBathNo()<500) //百分之98
//            {
//                BigDecimal xs=new BigDecimal(2.32);
//                xsz=xs.multiply(bigdeBZC);
//            }
//            if(i.getCountBathNo()>=60&&i.getCountBathNo()<200) //百分之95
//            {
//                BigDecimal xs=new BigDecimal(1.96);
//                xsz=xs.multiply(bigdeBZC);
//            }
//            BigDecimal lower=avg.subtract(xsz);
//            BigDecimal top=avg.add(xsz);

                //插入单位货值表中
                unit_price_range.setHsCode(i.getProdHsCode());
                unit_price_range.setProdName(i.getProdName());
                unit_price_range.setExportOrImport(i.getExportOrImport());
                unit_price_range.setTradeMode(i.getTradeModeCode());
                unit_price_range.setHsUnitCode(i.getHsUnitCode());
                unit_price_range.setLowerValue(lower);
                unit_price_range.setTopValue(top);
                unit_price_range.setBatch(i.getCountBathNo());
                unit_price_range.setCreateUser(UserService.Instance().getUserId());

                int count=  unit_price_rangeMapper.insert(unit_price_range);

            };
            LoggerService.Instance().info("单位货值表计算完成！",logger);
        }catch (Exception ex){
            LoggerService.Instance().error("单位货值表计算失败！",ex,logger);
        }
    }
    @RequestMapping(value = "/calculationUnitPrice/get", method = RequestMethod.GET)
    public String Get(CalculationUnitPrice_Get_Vm model) throws Exception {
        new Thread(){
            @Override
            public void run() {
                Compute(model);
            }
        }.start();

        return  "开始处理，需要很长时间，请在日志管理中查询状态";
    }

    //数值等于0
    private boolean IsEqualZero(BigDecimal qty)
    {
        if(qty==null) return false;
        if( qty.compareTo(BigDecimal.valueOf(0))==0){return true;}
        return false;
    }

    //根据Id获取配置信息
    private String GetByIdConfigInfo(String id)
    {
        CHECK_CONFIG check_config= CheckConfigService.Instance().getConfigObj(check_configMapper,id);
        return check_config.getValue();
    }
}
