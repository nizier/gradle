package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;
import org.aspectj.weaver.ast.Var;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.expression.spel.ast.NullLiteral;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CheckRule4 extends AbstractCheckRule {
    private static CheckRule4 instance=null;
    public static CheckRule4 Instance(){
        if(instance==null)
            instance = new CheckRule4();
        return instance;
    }
    private CheckRule4(){
    }

    @Override
    public void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception {

    }

    @Override
    public void CheckINS_RESULT(INS_RESULT obj) throws Exception {
        if(obj.getResult_goods_taskHashtable()==null||obj.getResult_goods_taskHashtable().values()==null) return;

        //组织机构Code
        String exeInspOrgCode=obj.getIns_result_sum_task().getExeInspOrgCode();
        String OrgName= GetOrgNameByOrgCode(exeInspOrgCode);

        //核查规则4金额min阈值
        double checkRule4MoneyLower=new BigDecimal(GetByIdConfigInfo("CheckRule4MoneyLower")).doubleValue() ;

        //核查规则4金额max阈值
        double checkRule4MoneyTop= new BigDecimal(GetByIdConfigInfo("CheckRule4MoneyTop")).doubleValue();

        //核查规则4数重量min阈值
        double checkRule4WtAndQtyLower=new BigDecimal(GetByIdConfigInfo("CheckRule4WtAndQtyLower")).doubleValue();

        //核查规则4数重量max阈值
        double checkRule4WtAndQtyTop= new BigDecimal(GetByIdConfigInfo("CheckRule4WtAndQtyTop")).doubleValue();

        CheckRule rule=new CheckRule();
        JSONObject json=new JSONObject();
        for (INS_RESULT_GOODS_TASK ins_result_goods_task :
             obj.getResult_goods_taskHashtable().values()) {
            //例外情况
            boolean IsExceptionCondiTion=  ExceptionCondiTion(ins_result_goods_task.getDeclNo(),ins_result_goods_task.getGoodsNo());
            if(IsExceptionCondiTion) continue;

            //结果登记重量
            BigDecimal StdWt=ins_result_goods_task.getStdWt()==null?BigDecimal.valueOf(0):ins_result_goods_task.getStdWt();
            //结果登记金额
            BigDecimal TotalValUS=ins_result_goods_task.getTotalValUs()==null?BigDecimal.valueOf(0):ins_result_goods_task.getTotalValUs();
            //结果登记数量
            BigDecimal StdQty=ins_result_goods_task.getStdQty()==null?BigDecimal.valueOf(0):ins_result_goods_task.getStdQty();

            DCL_IO_DECL_GOODS_TASK dcl_io_decl_goods_task=  getDclIoDeclGoodsTaskHistoryDetailInfo(ins_result_goods_task.getDeclNo(),ins_result_goods_task.getGoodsNo());
            if(dcl_io_decl_goods_task==null) continue;
            //报检重量
            BigDecimal StdWeight=dcl_io_decl_goods_task.getStdWeight()==null?BigDecimal.valueOf(0):dcl_io_decl_goods_task.getStdWeight();
            //报检金额
            BigDecimal TotalValUSGoods=dcl_io_decl_goods_task.getTotalValUs()==null?BigDecimal.valueOf(0):dcl_io_decl_goods_task.getTotalValUs();
            //报检数量
            BigDecimal StdQtyGoods=dcl_io_decl_goods_task.getStdQty()==null?BigDecimal.valueOf(0):dcl_io_decl_goods_task.getStdQty();

            BigDecimal TotalValUSQuotient=BigDecimal.valueOf(0);
            BigDecimal StdWtQuotient=BigDecimal.valueOf(0);
            BigDecimal StdQtyQuotient=BigDecimal.valueOf(0);

            if(!IsEqualZero(TotalValUS)&&!IsEqualZero(TotalValUSGoods)) {
                TotalValUSQuotient = TotalValUS.divide(TotalValUSGoods,4,BigDecimal.ROUND_HALF_UP);
            }
            if(!IsEqualZero(StdWt)&&!IsEqualZero(StdWeight))
            {
                StdWtQuotient = StdWt.divide(StdWeight,4,BigDecimal.ROUND_HALF_UP);
            }
            if(!IsEqualZero(StdQty)&&!IsEqualZero(StdQtyGoods))
            {
                StdQtyQuotient = StdQty.divide(StdQtyGoods,4,BigDecimal.ROUND_HALF_UP);
            }

            ////根据产品HS编码，判断取数量还是重量的字段值
            String prodHsCode=  ins_result_goods_task.getProdHsCode();
            String result=  GetQtyOrWt(prodHsCode);

            //根据dataId获取所有问题信息
            List<QUESTION> questions= listQuestion(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());

            //出入境
            String eixtEntry= getEixtEntryByDeclNo(ins_result_goods_task.getDeclNo());

            rule.setCheckName("报检与结果登记数重量");
            rule.setDataId(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());

//            rule.setObj();
            rule.setDeclNo(ins_result_goods_task.getDeclNo());
            rule.setGoodsNo(ins_result_goods_task.getGoodsNo());
            rule.setExitEntry(eixtEntry);
            rule.setOrganization(exeInspOrgCode);
            rule.setOrganizationName(OrgName);
            rule.setState("未处理");
            rule.setRemark("");
            rule.setType("suspected");
            rule.setUpdateNum(BigDecimal.valueOf(0));

            // 金额核查,X = 结果登记金额/报检金额

            String checkInfo="金额核查,X>"+checkRule4MoneyTop+",X<"+checkRule4MoneyLower+",检验检疫金额与报检金额相比差异过大";
            rule.setCheckInfo(checkInfo);
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("金额核查,X = 结果登记金额/报检金额的值",TotalValUSQuotient);
            json.put("结果登记金额",TotalValUS);
            json.put("报检金额",TotalValUSGoods);
            rule.setObj(json.toJSONString());
            rule.setRules(TotalValUSQuotient.compareTo(BigDecimal.valueOf(checkRule4MoneyTop))>=0 || TotalValUSQuotient.compareTo(BigDecimal.valueOf(checkRule4MoneyLower))<=0);
            validate(rule,questions);

            // 数重量核查，X = 结果登记数重量/报检数重量
            checkInfo="计量单位不一致,数重量(重量)核查,X>"+checkRule4WtAndQtyLower+",X<"+checkRule4WtAndQtyLower+",检验检疫数重量(重量)与报检数重量(重量)相比差异过大";
            rule.setCheckInfo(checkInfo);
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("重量核查,X = 结果登记重量/报检重量的值",StdWtQuotient);
            json.put("结果登记重量",StdWt);
            json.put("报检重量",StdWeight);
            rule.setObj(json.toJSONString());
            rule.setRules(result.equals("ALL"), StdWtQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyTop))>=0 || StdWtQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyLower))<=0);
            validate(rule,questions);

            checkInfo="计量单位不一致,数重量(数量)核查,X >"+checkRule4WtAndQtyTop+"X<"+checkRule4WtAndQtyLower+",检验检疫数重量(数量)与报检数重量(数量)相比差异过大";
            rule.setCheckInfo(checkInfo);
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("数量核查,X=结果登记数量/报检数量的值",StdQtyQuotient);
            json.put("结果登记数量",StdQty);
            json.put("报检数量",StdQtyGoods);
            rule.setObj(json.toJSONString());
            rule.setRules(result.equals("ALL"),StdQtyQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyTop))>=0 || StdWtQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyLower))<=0);
            validate(rule,questions);

            checkInfo="重量核查,X>"+checkRule4WtAndQtyLower+",X<"+checkRule4WtAndQtyLower+",检验检疫重量与报检重量相比差异过大";
            rule.setCheckInfo(checkInfo);
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("重量核查,X = 结果登记重量/报检重量的值",StdWtQuotient);
            json.put("结果登记重量",StdWt);
            json.put("报检重量",StdWeight);
            rule.setObj(json.toJSONString());
            rule.setRules(result.equals("2"),StdWtQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyTop))>=0 || StdWtQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyLower))<=0);
            validate(rule,questions);

            checkInfo="数量核查,X >"+checkRule4WtAndQtyTop+"X<"+checkRule4WtAndQtyLower+",检验检疫数量与报检数量相比差异过大";;
            rule.setCheckInfo(checkInfo);
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("数量核查,X=结果登记数量/报检数量的值",StdQtyQuotient);
            json.put("结果登记数量",StdQty);
            json.put("报检数量",StdQtyGoods);
            rule.setObj(json.toJSONString());
            rule.setRules(!result.equals("ALL"),!result.equals("2"),StdQtyQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyTop))>=0 || StdWtQuotient.compareTo(BigDecimal.valueOf(checkRule4WtAndQtyLower))<=0);
            validate(rule,questions);

            // 检验检疫金额不为空/零，报检金额却为空/零
            rule.setCheckInfo("检验检疫金额不为空/零，报检金额却为空/零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验检疫金额",TotalValUS);
            json.put("报检金额",TotalValUSGoods);
            rule.setObj(json.toJSONString());
            rule.setRules(!IsEqualZero(TotalValUS)||ins_result_goods_task.getTotalValUs()!=null,
                    IsEqualZero(TotalValUSGoods)||dcl_io_decl_goods_task.getTotalValUs()==null);
            validate(rule,questions);

            // 检验检疫数重量不为空/零，报检数重量却为空/零
            rule.setCheckInfo("计量单位不一致,检验检疫数重量(重量)不为空/零，报检数重量(重量)却为空/零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验检疫重量",StdWt);
            json.put("报检重量",StdWeight);
            rule.setObj(json.toJSONString());
            rule.setRules(result.equals("ALL"),!IsEqualZero(StdWt)||ins_result_goods_task.getStdWt()!=null,
                    IsEqualZero(StdWeight)||dcl_io_decl_goods_task.getStdWeight()==null);
            validate(rule,questions);

            rule.setCheckInfo("计量单位不一致,检验检疫数重量(数量)不为空/零，报检数重量(数量)却为空/零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验检疫数量",StdQty);
            json.put("报检数量",StdQtyGoods);
            rule.setObj(json.toJSONString());
            rule.setRules(result.equals("ALL"),!IsEqualZero(StdQty)||ins_result_goods_task.getStdQty()!=null,
                    IsEqualZero(StdQtyGoods)||dcl_io_decl_goods_task.getStdQty()==null);
            validate(rule,questions);

            rule.setCheckInfo("检验检疫重量不为空/零，报检重量却为空/零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验检疫重量",StdWt);
            json.put("报检重量",StdWeight);
            rule.setObj(json.toJSONString());
            rule.setRules(result.equals("2"),!IsEqualZero(StdWt)||ins_result_goods_task.getStdWt()!=null,
                    IsEqualZero(StdWeight)||dcl_io_decl_goods_task.getStdWeight()==null);
            validate(rule,questions);

            rule.setCheckInfo("检验检疫数量不为空/零，报检数量却为空/零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验检疫数量",StdQty);
            json.put("报检数量",StdQtyGoods);
            rule.setObj(json.toJSONString());
            rule.setRules(!result.equals("ALL"),!result.equals("2"),
                    !IsEqualZero(StdQty)||ins_result_goods_task.getStdQty()!=null,
                    IsEqualZero(StdQtyGoods)||dcl_io_decl_goods_task.getStdQty()==null);
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
