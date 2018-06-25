package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;
import d1.domain.mgr.DCL_IO_DECLMgr;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class CheckRule2 extends AbstractCheckRule {
    private static CheckRule2 instance=null;
    public static CheckRule2 Instance(){
        if(instance==null)
            instance = new CheckRule2();
        return instance;
    }

    //检验检疫货物明细----数重量/金额基本查核
    private CheckRule2(){

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
        for (INS_RESULT_GOODS_TASK ins_result_goods_task:
                obj.getResult_goods_taskHashtable().values())
        {
            //例外情况
          boolean IsExceptionCondiTion=  ExceptionCondiTion(ins_result_goods_task.getDeclNo(),ins_result_goods_task.getGoodsNo());
          if(IsExceptionCondiTion) continue;

            BigDecimal StdQty=ins_result_goods_task.getStdQty();
            BigDecimal StdWt=ins_result_goods_task.getStdWt();
            BigDecimal GoodsValUS=ins_result_goods_task.getTotalValUs();

            ////根据产品HS编码，判断取数量还是重量的字段值
            String prodHsCode=  ins_result_goods_task.getProdHsCode();
            String result=  GetQtyOrWt(prodHsCode);

            //出入境
            String eixtEntry= getEixtEntryByDeclNo(ins_result_goods_task.getDeclNo());

            //根据dataId获取所有问题信息
            List<QUESTION> questions= listQuestion(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());


            rule.setCheckName("数重量/金额基本核查");
            rule.setDataId(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("标准重量",ins_result_goods_task.getStdWt()==null?"":ins_result_goods_task.getStdWt());
            json.put("标准数量",ins_result_goods_task.getStdQty()==null?"":ins_result_goods_task.getStdQty());
            json.put("货物总值(美元)",ins_result_goods_task.getTotalValUs()==null?"":ins_result_goods_task.getTotalValUs());
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

            // 金额基本核查
            rule.setCheckInfo("货物总值不合法，值为空");
            rule.setRules(ins_result_goods_task.getTotalValUs()==null);
            validate(rule,questions);

            rule.setCheckInfo("计量单位不一致，货物总值==0,数重量!=0");
            rule.setRules(result.equals("ALL"),(IsEqualZero(GoodsValUS)&&!IsEqualZero(StdWt))
                    ||(IsEqualZero(GoodsValUS)&&!IsEqualZero(StdQty)));
            validate(rule,questions);

            rule.setCheckInfo("货物总值==0,重量!=0");
            rule.setRules(result.equals("2"),IsEqualZero(GoodsValUS),!IsEqualZero(StdWt));
            validate(rule,questions);

            rule.setCheckInfo("货物总值==0,数量!=0");
            rule.setRules(!result.equals("2"),!result.equals("ALL"),IsEqualZero(GoodsValUS),!IsEqualZero(StdQty));
            validate(rule,questions);

            // 数重量基本核查

            rule.setCheckInfo("计量单位不一致,货物数重量不合法，值为空或零");
            rule.setRules(result.equals("ALL"),ins_result_goods_task.getStdQty()==null||ins_result_goods_task.getStdWt()==null);
            validate(rule,questions);

            rule.setCheckInfo("货物重量不合法，值为空或零");
            rule.setRules(result.equals("2"),ins_result_goods_task.getStdWt()==null);
            validate(rule,questions);

            rule.setCheckInfo("货物数量不合法，值为空或零");
            rule.setRules(!result.equals("2"),!result.equals("ALL"),ins_result_goods_task.getStdQty()==null);
            validate(rule,questions);

            rule.setCheckInfo("计量单位不一致,数重量==0,货物总值!=0");
            rule.setRules(result.equals("ALL"),(IsEqualZero(StdQty)&&!IsEqualZero(GoodsValUS))
                    ||(IsEqualZero(StdWt)&&!IsEqualZero(GoodsValUS)));
            validate(rule,questions);

            rule.setCheckInfo("重量==0,货物总值!=0");
            rule.setRules(result.equals("2"),IsEqualZero(StdWt),!IsEqualZero(GoodsValUS));
            validate(rule,questions);

            rule.setCheckInfo("数量==0,货物总值!=0");
            rule.setRules(!result.equals("2"),!result.equals("ALL"),IsEqualZero(StdQty),!IsEqualZero(GoodsValUS));
            validate(rule,questions);

            // 金额与数重量核查
            rule.setCheckInfo("计量单位不一致,数重量==0，货物总值==0");
            rule.setRules(result.equals("ALL"),(IsEqualZero(StdQty)&&IsEqualZero(GoodsValUS))
                    ||(IsEqualZero(StdWt)&&IsEqualZero(GoodsValUS)));
            validate(rule,questions);

            rule.setCheckInfo("重量==0，货物总值==0");
            rule.setRules(result.equals("2"),IsEqualZero(StdWt)&&IsEqualZero(GoodsValUS));
            validate(rule,questions);

            rule.setCheckInfo("数量==0，货物总值==0");
            rule.setRules(!result.equals("ALL"),!result.equals("2"),IsEqualZero(StdQty)&IsEqualZero(GoodsValUS));
            validate(rule,questions);

            // 货物数重量可能录在了小数点后面
            rule.setCheckInfo("计量单位不一致,货物数重量(数量)可能录在了小数点后面");
            rule.setRules(result.equals("ALL"),ZeroAndOne(StdQty),!IsEqualZero(StdQty),IsLengthEqualFive(StdQty));
            validate(rule,questions);

            rule.setCheckInfo("计量单位不一致,货物数重量(重量)可能录在了小数点后面");
            rule.setRules(result.equals("ALL"),ZeroAndOne(StdWt),!IsEqualZero(StdWt),IsLengthEqualFive(StdWt));
            validate(rule,questions);

            rule.setCheckInfo("货物重量可能录在了小数点后面");
            rule.setRules(result.equals("2"),ZeroAndOne(StdWt),!IsEqualZero(StdWt),IsLengthEqualFive(StdWt));
            validate(rule,questions);

            rule.setCheckInfo("货物数量可能录在了小数点后面");
            rule.setRules(!result.equals("ALL"),!result.equals("2"),ZeroAndOne(StdQty),!IsEqualZero(StdQty),IsLengthEqualFive(StdQty));
            validate(rule,questions);

            // 货物总值可能录在了小数点后面
            rule.setCheckInfo("货物总值可能录在了小数点后面");
            rule.setRules(ZeroAndOne(GoodsValUS),!IsEqualZero(GoodsValUS),IsLengthEqualFive(GoodsValUS));
            validate(rule,questions);
        }
    }

    @Override
    protected String getCheckType() {
        return "结果登记";
    }

    @Override
    protected String getDataTable() { return "INS_RESULT_GOODS"; }

}
