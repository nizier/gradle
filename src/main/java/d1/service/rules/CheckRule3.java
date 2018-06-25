package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.List;

public class CheckRule3 extends AbstractCheckRule {
    private static CheckRule3 instance=null;
    protected UNIT_PRICE_RANGEMapper unit_price_rangeMapper;

    public static CheckRule3 Instance(){
        if(instance==null)
            instance = new CheckRule3();
        return instance;
    }
    private CheckRule3(){
    }
    //

    public void initMappers(Hashtable<String, Object> mappers) {
        super.initMappers(mappers);
        unit_price_rangeMapper=(UNIT_PRICE_RANGEMapper)mappers.get("UNIT_PRICE_RANGE");
    }

    @Override
    public void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception {

    }

    @Override
    public void CheckINS_RESULT(INS_RESULT obj) throws Exception {
        if(obj.getResult_goods_taskHashtable()==null||obj.getResult_goods_taskHashtable().values()==null) return;

        //组织结构
        String exeInspOrgCode=obj.getIns_result_sum_task().getExeInspOrgCode();
        String OrgName= GetOrgNameByOrgCode(exeInspOrgCode);

        CheckRule rule=new CheckRule();
        JSONObject json=new JSONObject();
        for (INS_RESULT_GOODS_TASK ins_result_goods_task :
             obj.getResult_goods_taskHashtable().values()) {

            //例外情况
            boolean IsExceptionCondiTion=  ExceptionCondiTion(ins_result_goods_task.getDeclNo(),ins_result_goods_task.getGoodsNo());
            if(IsExceptionCondiTion) continue;

            //出入境
            String ExportOrImport= getEixtEntryByDeclNo(ins_result_goods_task.getDeclNo());

            //TODO   后期看需不需要修改表名
            List<UNIT_PRICE_RANGE> unit_price_rangeList=  unit_price_rangeMapper.listUnitPriceRangeData(ins_result_goods_task.getProdHsCode(),ExportOrImport);
            if(unit_price_rangeList==null|| unit_price_rangeList.isEmpty()) continue;

            //单位货值边界值
            UNIT_PRICE_RANGE unit_price_range=unit_price_rangeList.get(0);

            //配置I和II的最大最小的倍数
            BigDecimal ConfigImin= new BigDecimal(GetByIdConfigInfo("IThresholdLower"));
            BigDecimal ConfigImax= new BigDecimal(GetByIdConfigInfo("IThresholdTop"));
            BigDecimal ConfigIImin=new BigDecimal(GetByIdConfigInfo("IIThresholdLower"));
            BigDecimal ConfigIImax=new BigDecimal(GetByIdConfigInfo("IIThresholdTop"));

            //单位货值的I和II的最大，最小值
            double Imin=unit_price_range.getLowerValue().multiply(ConfigImin).doubleValue();
            double Imax=unit_price_range.getTopValue().multiply(ConfigImax).doubleValue();
            double IImin=unit_price_range.getLowerValue().multiply(ConfigIImin).doubleValue();
            double IImax=unit_price_range.getTopValue().multiply(ConfigIImax).doubleValue();

            //数量
            BigDecimal stdQty=ins_result_goods_task.getStdQty()==null?BigDecimal.valueOf(0):ins_result_goods_task.getStdQty();
            //重量
            BigDecimal stdWt=ins_result_goods_task.getStdWt()==null?BigDecimal.valueOf(0):ins_result_goods_task.getStdWt();
            //货物总值(美元)
            BigDecimal TotalValUS=ins_result_goods_task.getTotalValUs()==null?BigDecimal.valueOf(0):ins_result_goods_task.getTotalValUs();

            BigDecimal TotalValUSStdWtQuotient=BigDecimal.valueOf(0);
            BigDecimal TotalValUSStdQtyQuotient=BigDecimal.valueOf(0);
            if(!IsEqualZero(TotalValUS)&&!IsEqualZero(stdWt)) {
                //货物总值/重量
                TotalValUSStdWtQuotient = TotalValUS.divide(stdWt,4,BigDecimal.ROUND_HALF_UP);
            }

            if(!IsEqualZero(TotalValUS)&&!IsEqualZero(stdQty)) {
                //货物总值/数量
                TotalValUSStdQtyQuotient = TotalValUS.divide(stdQty,4,BigDecimal.ROUND_HALF_UP);
            }

            //根据产品HS编码，判断取数量还是重量的字段值
            String prodHsCode=  ins_result_goods_task.getProdHsCode();
            String result=  GetQtyOrWt(prodHsCode);

            //根据dataId获取所有问题信息
            List<QUESTION> questions= listQuestion(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());

            rule.setCheckName("单价核查");
            rule.setDataId(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("标准重量",ins_result_goods_task.getStdWt());
            json.put("标准数量",ins_result_goods_task.getStdQty());
            json.put("货物总值(美元)",ins_result_goods_task.getTotalValUs());
            json.put("货物总值/重量",TotalValUSStdWtQuotient);
            json.put("货物总值/数量",TotalValUSStdQtyQuotient);
            json.put("I级比值上限",Imin);
            json.put("I级比值下限",Imax);
            json.put("II级比值上限",IImin);
            json.put("II级比值下限",IImax);
            rule.setObj(json.toJSONString());
            rule.setDeclNo(ins_result_goods_task.getDeclNo());
            rule.setGoodsNo(ins_result_goods_task.getGoodsNo());
            rule.setExitEntry(ExportOrImport);
            rule.setOrganization(exeInspOrgCode);
            rule.setOrganizationName(OrgName);
            rule.setState("未处理");
            rule.setRemark("");
            rule.setType("suspected");
            rule.setUpdateNum(BigDecimal.valueOf(0));

            //货物的货值或数重量可能存在异常
//            rule.setCheckName("货物的货值或数重量可能存在异常");
//            rule.setCheckInfo("货物的货值或数重量可能存在异常");
//            rule.setRules(IsEqualZero(stdQty)||IsEqualZero(stdWt)||IsEqualZero(TotalValUS));
//            validate(rule,questions);

            // TODO I>X<II 黄色预警提示 货物总值/数重量

            String checkInfo="警告,计量单位不一致,货物总值/数重量(数量)，单价在Ⅰ级最小阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(result.equals("ALL"),NumberCompare(TotalValUSStdWtQuotient,IImin,Imin)||
                    NumberCompare(TotalValUSStdQtyQuotient,IImin,Imin));
            validate(rule,questions);

            // TODO I>X<II 黄色预警提示 货物总值/数重量
            checkInfo="警告,计量单位不一致,货物总值/数重量(重量)，单价在Ⅰ级最大阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(result.equals("ALL"),NumberCompare(TotalValUSStdWtQuotient,Imax,IImax)
                    ||NumberCompare(TotalValUSStdQtyQuotient,Imax,IImax));
            validate(rule,questions);

            //TODO I>X<II 黄色预警提示 货物总值/重量
            checkInfo="警告,计量单位一致,货物总值/重量，单价在Ⅰ级阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(result.equals("2"),NumberCompare(TotalValUSStdWtQuotient,IImin,Imin)||
                    NumberCompare(TotalValUSStdWtQuotient,Imax,IImax));
            validate(rule,questions);

            //TODO I>X<II 黄色预警提示 货物总值/数量
            checkInfo="警告,计量单位一致,货物总值/数量，单价在Ⅰ级阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(!result.equals("2"),!result.equals("ALL"),
                    NumberCompare(TotalValUSStdQtyQuotient,IImin,Imin)||
                            NumberCompare(TotalValUSStdQtyQuotient,Imax,IImax));
            validate(rule,questions);

            // TODO X>II 红色警告，货物的货值或数重量极可能存在异常 货物总值/数重量
            checkInfo="异常,计量单位不一致,货物总值/数重量，单价在II级最小阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(result.equals("ALL"),TotalValUSStdWtQuotient.compareTo(BigDecimal.valueOf(IImin))<0||
                    TotalValUSStdQtyQuotient.compareTo(BigDecimal.valueOf(IImin))>0);
            validate(rule,questions);

            // TODO X>II 红色警告，货物的货值或数重量极可能存在异常 货物总值/数重量
            checkInfo="异常,计量单位不一致,货物总值/数重量，单价在II级最大阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(result.equals("ALL"),TotalValUSStdWtQuotient.compareTo(BigDecimal.valueOf(IImax))>0||
                    TotalValUSStdQtyQuotient.compareTo(BigDecimal.valueOf(IImax))>0);
            validate(rule,questions);

            // TODO X>II 红色警告，货物的货值或重量极可能存在异常 货物总值/数重量
            checkInfo="异常,计量单位一致,货物总值/重量，单价在II级阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(result.equals("2"),TotalValUSStdWtQuotient.compareTo(BigDecimal.valueOf(IImin))<0||
                    TotalValUSStdWtQuotient.compareTo(BigDecimal.valueOf(IImax))>0);
            validate(rule,questions);

            // TODO X>II 红色警告，货物的货值或数量极可能存在异常 货物总值/数重量
            checkInfo="异常,计量单位一致,货物总值/数量，单价在II级阈值之外("+IImin+"<单价<"+Imin+","+Imax+"<单价<"+IImax+")";
            rule.setCheckInfo(checkInfo);
            rule.setRules(!result.equals("2"),!result.equals("ALL"),
                    TotalValUSStdQtyQuotient.compareTo(BigDecimal.valueOf(IImin))<0||
                            TotalValUSStdQtyQuotient.compareTo(BigDecimal.valueOf(IImax))>0);
            validate(rule,questions);
        }
    }

    @Override
    protected String getCheckType() {
        return "结果登记";
    }

    @Override
    protected String getDataTable() {
        return "INS_RESULT_GOODS";
    }
}
