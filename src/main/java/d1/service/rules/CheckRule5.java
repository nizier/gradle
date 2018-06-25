package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CheckRule5 extends AbstractCheckRule {
    private static CheckRule5 instance=null;
    public static CheckRule5 Instance(){
        if(instance==null)
            instance = new CheckRule5();
        return instance;
    }
    private CheckRule5(){
    }

    @Override
    public void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception {

    }

    @Override
    public void CheckINS_RESULT(INS_RESULT obj) throws Exception {
        if(obj.getResult_goods_taskHashtable()==null||obj.getResult_goods_taskHashtable().values()==null) return;

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
            String  eixtEntry= getEixtEntryByDeclNo(ins_result_goods_task.getDeclNo());
            ////根据产品HS编码，判断取数量还是重量的字段值
            String prodHsCode=  ins_result_goods_task.getProdHsCode();
            String result=  GetQtyOrWt(prodHsCode);
            //数量
            BigDecimal Qty=ins_result_goods_task.getQty();

            //重量(净重)
            BigDecimal WeightNet=ins_result_goods_task.getWeightNet();

            //根据dataId获取所有问题信息
            List<QUESTION> questions= listQuestion(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());

            rule.setCheckName("数重量及其单位核查");
            rule.setDataId(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("标准重量",ins_result_goods_task.getWeightNet()==null?"":ins_result_goods_task.getWeightNet());
            json.put("标准数量",ins_result_goods_task.getQty()==null?"":ins_result_goods_task.getQty());
            rule.setObj(json.toJSONString());
            rule.setDeclNo(ins_result_goods_task.getDeclNo());
            rule.setGoodsNo(ins_result_goods_task.getGoodsNo());
            rule.setExitEntry(eixtEntry);
            rule.setOrganization(exeInspOrgCode);
            rule.setOrganizationName(OrgName);
            rule.setState("未处理");
            rule.setRemark("");
            rule.setType("error");
            rule.setUpdateNum(BigDecimal.valueOf(0));

            // 如果一致，则数量为重量两个字段有一个值大于 0 即可

            rule.setCheckInfo("计量单位一致,数重量都为空/零");
            rule.setRules(!result.equals("ALL"),IsEqualZero(WeightNet)||ins_result_goods_task.getWeightNet()==null
                    ,IsEqualZero(Qty)||ins_result_goods_task.getQty()==null);
            validate(rule,questions);

            // 如果不一致，则数量和重量均应大于 0
            rule.setCheckInfo("货物编码第一计量单位与第二计量单位不一致，但数重量为空/零");
            rule.setRules(result.equals("ALL"),IsEqualZero(Qty)||ins_result_goods_task.getQty()==null||
                    IsEqualZero(WeightNet)||ins_result_goods_task.getWeightNet()==null);
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
