package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;
import oracle.sql.NUMBER;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckRule1 extends AbstractCheckRule {
    private static CheckRule1 instance=null;
    public static CheckRule1 Instance(){
        if(instance==null)
            instance = new CheckRule1();
        return instance;
    }
    private CheckRule1(){
    }

    //检验检疫货物明细: 登记情况与判定结果一致性核查

    @Override
    public void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception {

    }

    @Override
    public void CheckINS_RESULT(INS_RESULT obj) throws Exception {
        if(obj.getResult_goods_taskHashtable()==null||obj.getResult_goods_taskHashtable().values()==null) return;

        String exeInspOrgCode=obj.getIns_result_sum_task().getExeInspOrgCode();
        String OrgName= GetOrgNameByOrgCode(exeInspOrgCode);

     //循环编译检验检疫明细表数据
        CheckRule rule = new CheckRule();
        JSONObject json=new JSONObject();
        for (INS_RESULT_GOODS_TASK ins_result_goods_task:
        obj.getResult_goods_taskHashtable().values()) {
            //出入境
            String eixtEntry= getEixtEntryByDeclNo(ins_result_goods_task.getDeclNo());

            //检验结果判定
            String InspResEval= ins_result_goods_task.getInspResEval();
            //检验不合格数量
            BigDecimal UnqulCommInsQty=ins_result_goods_task.getUnqulCommInsQty();
            //检验不合格重量
            BigDecimal InspUnquafWt=ins_result_goods_task.getInspUnquafWt();
            //检验不合格金额
            BigDecimal InspUnquaAmt=ins_result_goods_task.getInspUnquaAmt();
            //检验不合格内容代码串
            String InspDisquaContCodes=ins_result_goods_task.getInspDisquaContCodes()==null?"":ins_result_goods_task.getInspDisquaContCodes();

            ////根据产品HS编码，判断取数量还是重量的字段值
            String prodHsCode=  ins_result_goods_task.getProdHsCode();
            String result=  GetQtyOrWt(prodHsCode);

            //根据dataId获取所有问题信息
           List<QUESTION> questions= listQuestion(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());

            //TODO 检验结果评定合格字段值需要修改
            // 检验合格货物一致性核查
            rule.setCheckName("登记情况与判定结果一致性核查");
            rule.setDataId(ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo());
            rule.setDeclNo(ins_result_goods_task.getDeclNo());
            rule.setGoodsNo(ins_result_goods_task.getGoodsNo());
            rule.setExitEntry(eixtEntry);
            rule.setType("error");
            rule.setOrganization(exeInspOrgCode);
            rule.setOrganizationName(OrgName);
            rule.setUpdateNum(BigDecimal.valueOf(0));
            rule.setState("未处理");
            rule.setRemark("");

            rule.setCheckInfo("检验合格货物计量单位不一致,不合格数重量(重量)/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格重量",ins_result_goods_task.getInspUnquafWt()==null?"":ins_result_goods_task.getInspUnquafWt());
            json.put("检验不合格金额",ins_result_goods_task.getInspUnquaAmt()==null?"":ins_result_goods_task.getInspUnquaAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(
                    InspResEval.equals("1"),
                    result.equals("ALL"),
                    (ins_result_goods_task.getInspUnquafWt()!=null&&!IsEqualZero(InspUnquafWt))||
                            (ins_result_goods_task.getInspUnquaAmt()!=null&& !IsEqualZero(InspUnquaAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检验合格货物计量单位不一致,不合格数重量(数量)/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格数量",ins_result_goods_task.getUnqulCommInsQty()==null?"":ins_result_goods_task.getUnqulCommInsQty());
            json.put("检验不合格金额",ins_result_goods_task.getInspUnquaAmt()==null?"":ins_result_goods_task.getInspUnquaAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(
                    InspResEval.equals("1"),
                    result.equals("ALL"),
                    (ins_result_goods_task.getUnqulCommInsQty()!=null&&!IsEqualZero(UnqulCommInsQty))
                            ||(ins_result_goods_task.getInspUnquaAmt()!=null&&!IsEqualZero(InspUnquaAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检验合格货物,不合格重量/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格重量",ins_result_goods_task.getInspUnquafWt()==null?"":ins_result_goods_task.getInspUnquafWt());
            json.put("检验不合格金额",ins_result_goods_task.getInspUnquaAmt()==null?"":ins_result_goods_task.getInspUnquaAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(
                    InspResEval.equals("1"),
                    result.equals("2"),
                    (ins_result_goods_task.getInspUnquafWt()!=null&&!IsEqualZero(InspUnquafWt))
                            ||(ins_result_goods_task.getInspUnquaAmt()!=null&&!IsEqualZero(InspUnquaAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检验合格货物,不合格数量/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格数量",ins_result_goods_task.getUnqulCommInsQty()==null?"":ins_result_goods_task.getUnqulCommInsQty());
            json.put("检验不合格金额",ins_result_goods_task.getInspUnquaAmt()==null?"":ins_result_goods_task.getInspUnquaAmt());
            rule.setRules(
                    InspResEval.equals("1"),
                    !result.equals("2"),
                    !result.equals("ALL"),
                    (ins_result_goods_task.getUnqulCommInsQty()!=null&&!IsEqualZero(UnqulCommInsQty))
                            ||(ins_result_goods_task.getInspUnquaAmt()!=null&&!IsEqualZero(InspUnquaAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检验合格货物,不合格内容不为空的");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格内容代码串",InspDisquaContCodes);
            rule.setRules(InspResEval.equals("1"), !InspDisquaContCodes.equals(""));
            validate(rule,questions);


            // 检验不合格货物-检验不合格金额
            rule.setCheckInfo("货物检验不合格，但检验不合格数金额为空");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格金额",ins_result_goods_task.getInspUnquaAmt()==null?"":ins_result_goods_task.getInspUnquaAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(!InspResEval.equals("1"),ins_result_goods_task.getInspUnquaAmt()== null);
            validate(rule,questions);

            rule.setCheckInfo("货物检验不合格，但检验不合格数金额小于1");
            rule.setRules(!InspResEval.equals("1"),ZeroAndOne(InspUnquaAmt));
            validate(rule,questions);

            rule.setCheckInfo("货物检验不合格，但检验不合格数金额为零");
            rule.setRules(!InspResEval.equals("1"),IsEqualZero(InspUnquaAmt));
            validate(rule,questions);


            // 检验不合格货物-检验不合格数重量
            rule.setCheckInfo("检验不合格货物计量单位不一致,货物检验不合格，但检验不合格数重量为空/零/小于1 不合格数重量为空");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格数量",ins_result_goods_task.getUnqulCommInsQty()==null?"":ins_result_goods_task.getUnqulCommInsQty());
            json.put("检验不合格重量",ins_result_goods_task.getInspUnquafWt()==null?"":ins_result_goods_task.getInspUnquafWt());
            rule.setObj(json.toJSONString());
            rule.setRules(
                    !InspResEval.equals("1"),
                    result.equals("ALL"),
                    ins_result_goods_task.getInspUnquafWt()==null,ins_result_goods_task.getUnqulCommInsQty()==null);
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物计量单位不一致,但检验不合格数重量小于1");
            rule.setRules(
                    !InspResEval.equals("1"),result.equals("ALL"),
                    ZeroAndOne(InspUnquafWt), ZeroAndOne(UnqulCommInsQty));
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物计量单位不一致,但检验不合格数重量为零");
            rule.setRules(
                    !InspResEval.equals("1"),result.equals("ALL"),
                    IsEqualZero(InspUnquafWt),IsEqualZero(UnqulCommInsQty));
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物,但检验不合格重量为空");
            rule.setRules(
                    !InspResEval.equals("1"),result.equals("2"),
                    ins_result_goods_task.getInspUnquafWt()==null);
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物,但检验不合格重量小于1");
            rule.setRules(
                    !InspResEval.equals("1"),result.equals("2"),
                    ZeroAndOne(InspUnquafWt));
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物,但检验不合格重量为零");
            rule.setRules(!InspResEval.equals("1"),result.equals("2"),IsEqualZero(InspUnquafWt));
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物,但检验不合格数量为空");
            rule.setRules(!InspResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),
                    ins_result_goods_task.getUnqulCommInsQty()==null);
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物,但检验不合格数量小于1");
            rule.setRules(!InspResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),
                    ZeroAndOne(UnqulCommInsQty));
            validate(rule,questions);

            rule.setCheckInfo("检验不合格货物,但检验不合格数量为零");
            rule.setRules(!InspResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),
                    IsEqualZero(UnqulCommInsQty));
            validate(rule,questions);


            // 检验不合格货物-检验不合格内容
            rule.setCheckInfo("检验不合格货物,但检验不合格内容为空");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检验不合格内容代码串",InspDisquaContCodes);
            rule.setObj(json.toJSONString());
            rule.setRules(!InspResEval.equals("1"),InspDisquaContCodes.equals(""));
            validate(rule,questions);


            // 检验检疫评定
            //检验检疫结果判定
            String QuarResEval=ins_result_goods_task.getQuarResEval();
            //检疫不合格数量
            BigDecimal UnqulfdQuarQty=ins_result_goods_task.getUnqulfdQuarQty();
            //检疫不合格重量
            BigDecimal QuaranUnquaWt=ins_result_goods_task.getQuaranUnquaWt();
            //检疫不合格金额
            BigDecimal UnqualQuarAmt=ins_result_goods_task.getUnqualQuarAmt();
            //检疫不合格内容代码串
            String QuarDisQuaContCodes=ins_result_goods_task.getQuarDisquaContCodes()==null?"":ins_result_goods_task.getQuarDisquaContCodes();

            //TODO 检疫结果评定字段值需要修改
            // 检疫合格货物一致性核查
            //;
            rule.setCheckInfo("检疫合格货物计量单位不一致,不合格数重量(重量)/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格重量",ins_result_goods_task.getQuaranUnquaWt()==null?"":ins_result_goods_task.getQuaranUnquaWt());
            json.put("检疫不合格金额",ins_result_goods_task.getUnqualQuarAmt()==null?"":ins_result_goods_task.getUnqualQuarAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(QuarResEval.equals("1"),result.equals("ALL"),
                    (ins_result_goods_task.getQuaranUnquaWt()!=null&&!IsEqualZero(QuaranUnquaWt))
                    ||(ins_result_goods_task.getUnqualQuarAmt()!=null&&!IsEqualZero(UnqualQuarAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检疫合格货物计量单位不一致,不合格数重量(数量)/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格数量",ins_result_goods_task.getUnqulfdQuarQty()==null?"":ins_result_goods_task.getUnqulfdQuarQty());
            json.put("检疫不合格金额",ins_result_goods_task.getUnqualQuarAmt()==null?"":ins_result_goods_task.getUnqualQuarAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(QuarResEval.equals("1"),result.equals("ALL"),
                    (ins_result_goods_task.getUnqulfdQuarQty()!=null&&!IsEqualZero(UnqulfdQuarQty))
                    ||(ins_result_goods_task.getUnqualQuarAmt()!=null&&!IsEqualZero(UnqualQuarAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检疫合格货物不合格重量/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格重量",ins_result_goods_task.getQuaranUnquaWt()==null?"":ins_result_goods_task.getQuaranUnquaWt());
            json.put("检疫不合格金额",ins_result_goods_task.getUnqualQuarAmt()==null?"":ins_result_goods_task.getUnqualQuarAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(QuarResEval.equals("1"),result.equals("2"),
                    (ins_result_goods_task.getQuaranUnquaWt()!=null&&!IsEqualZero(QuaranUnquaWt))
                    ||(ins_result_goods_task.getUnqualQuarAmt()!=null&&!IsEqualZero(UnqualQuarAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检疫合格货物不合格数量/不合格金额不为空且不为零");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格数量",ins_result_goods_task.getUnqulfdQuarQty()==null?"":ins_result_goods_task.getUnqulfdQuarQty());
            json.put("检疫不合格金额",ins_result_goods_task.getUnqualQuarAmt()==null?"":ins_result_goods_task.getUnqualQuarAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(QuarResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),
                    (ins_result_goods_task.getUnqulfdQuarQty()!=null&&!IsEqualZero(UnqulfdQuarQty))
                    ||(ins_result_goods_task.getUnqualQuarAmt()!=null&&!IsEqualZero(UnqualQuarAmt)));
            validate(rule,questions);

            rule.setCheckInfo("检疫合格货物,但检疫不合格内容不为空的");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格内容代码串",QuarDisQuaContCodes);
            rule.setObj(json.toJSONString());
            rule.setRules(QuarResEval.equals("1"),!QuarDisQuaContCodes.equals(""));
            validate(rule,questions);

            // 检疫不合格货物-检疫不合格金额
            rule.setCheckInfo("检疫不合格货物,但检疫不合格金额为空");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格金额",ins_result_goods_task.getUnqualQuarAmt()==null?"":ins_result_goods_task.getUnqualQuarAmt());
            rule.setObj(json.toJSONString());
            rule.setRules(!QuarResEval.equals("1"),
                    ins_result_goods_task.getUnqualQuarAmt()== null);
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格金额小于1");
            rule.setRules(!QuarResEval.equals("1"),ZeroAndOne(UnqualQuarAmt));
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格金额为零");
            rule.setRules(!QuarResEval.equals("1"),IsEqualZero(UnqualQuarAmt));
            validate(rule,questions);


            // 检疫不合格货物-检疫不合格数重量
            rule.setCheckInfo("检疫不合格货物计量单位不一致,但检疫不合格数重量为空");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格重量",ins_result_goods_task.getQuaranUnquaWt()==null?"":ins_result_goods_task.getQuaranUnquaWt());
            json.put("检疫不合格数量",ins_result_goods_task.getUnqulfdQuarQty()==null?"":ins_result_goods_task.getUnqulfdQuarQty());
            rule.setObj(json.toJSONString());
            rule.setRules(!QuarResEval.equals("1"),result.equals("ALL"),ins_result_goods_task.getQuaranUnquaWt()==null
                    ,ins_result_goods_task.getUnqulfdQuarQty()==null);
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物计量单位不一致,但检疫不合格数重量小于1");
            rule.setRules(!QuarResEval.equals("1"),result.equals("ALL"),ZeroAndOne(QuaranUnquaWt),ZeroAndOne(UnqulfdQuarQty));
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物计量单位不一致,但检疫不合格数重量为零");
            rule.setRules(!QuarResEval.equals("1"),result.equals("ALL"),IsEqualZero(QuaranUnquaWt),IsEqualZero(UnqulfdQuarQty));
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格重量为空");
            rule.setRules(!QuarResEval.equals("1"),result.equals("2"),ins_result_goods_task.getQuaranUnquaWt()==null);
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格重量小于1");
            rule.setRules(!QuarResEval.equals("1"),result.equals("2"),ZeroAndOne(QuaranUnquaWt));
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格重量为零");
            rule.setRules(!QuarResEval.equals("1"),result.equals("2"),IsEqualZero(QuaranUnquaWt));
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格数量为空");
            rule.setRules(!QuarResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),
                    ins_result_goods_task.getUnqulfdQuarQty()==null);
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格数量小于1");
            rule.setRules(!QuarResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),ZeroAndOne(UnqulfdQuarQty));
            validate(rule,questions);

            rule.setCheckInfo("检疫不合格货物,但检疫不合格数量为零");
            rule.setRules(!QuarResEval.equals("1"),!result.equals("ALL"),!result.equals("2"),IsEqualZero(UnqulfdQuarQty));
            validate(rule,questions);

            // 检疫不合格货物-检疫不合格内容
            rule.setCheckInfo("检疫不合格货物,但检验不合格内容为空");
            json.clear();
            json.put("报检单",ins_result_goods_task.getDeclNo());
            json.put("货物序号",ins_result_goods_task.getGoodsNo());
            json.put("HS编码",ins_result_goods_task.getProdHsCode());
            json.put("货物名称",ins_result_goods_task.getGoodsNameCn());
            json.put("检疫不合格内容代码串",QuarDisQuaContCodes);
            rule.setObj(json.toJSONString());
            rule.setRules(!QuarResEval.equals("1"),QuarDisQuaContCodes.equals(""));
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
