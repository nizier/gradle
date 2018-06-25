package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Hashtable;
import java.util.List;

public class CheckRule6 extends AbstractCheckRule {
    private static CheckRule6 instance=null;
    private DM_C_COUNTRYMapper dm_c_countryMapper;

    public static CheckRule6 Instance(){
        if(instance==null)
            instance = new CheckRule6();
        return instance;
    }
    private CheckRule6(){
    }
    public void initMappers(Hashtable<String, Object> mappers) {
        super.initMappers(mappers);
        dm_c_countryMapper=(DM_C_COUNTRYMapper)mappers.get("DM_C_COUNTRY");
    }

    @Override
    public void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception {
        if(obj.getDcl_io_decl_task()==null) return;

        CheckRule rule=new CheckRule();
        // 出境输往国
        String DeclNo=obj.getDcl_io_decl_task().getDeclNo();
        String  eixtEntry= getEixtEntryByDeclNo(obj.getDcl_io_decl_task().getDeclNo());

        //组织机构
        String orgCode=obj.getDcl_io_decl_task().getOrgCode();
        String OrgName= GetOrgNameByOrgCode(orgCode);

        if(eixtEntry.equals("出境")) {
            List<QUESTION> questions = listQuestion(DeclNo);

            String TradeCountryCode = obj.getDcl_io_decl_task().getTradeCountryCode();

            if(obj.getDcl_io_decl_task().getTradeCountryCode()==null)
            {
                TradeCountryCode="";
            }

            //根据dataId获取所有问题信息
            rule.setCheckName("国别代码核查");
            rule.setDataId(DeclNo);
            JSONObject json = new JSONObject();
            json.put("报检单", DeclNo);
            json.put("货物序号", "");
            json.put("HS编码", "");
            json.put("货物名称", "");
            json.put("出境输往国", TradeCountryCode);
            rule.setObj(json.toJSONString());
            rule.setDeclNo(DeclNo);
            rule.setGoodsNo(BigDecimal.valueOf(0));
            rule.setExitEntry(eixtEntry);
            rule.setOrganization(orgCode);
            rule.setOrganizationName(OrgName);
            rule.setState("未处理");
            rule.setRemark("");
            rule.setType("error");
            rule.setUpdateNum(BigDecimal.valueOf(0));

            //输往国为空

            rule.setCheckInfo("输往国为空");
            rule.setRules(TradeCountryCode.equals(""));
            validate(rule, questions);

            //输往国在国别代码中不存在
            if (!TradeCountryCode.equals(""))
            {
                List<DM_C_COUNTRY> listDM_c_countryData=dm_c_countryMapper.getListDM_C_COUNTRYData(TradeCountryCode);
                rule.setCheckInfo("输往国在国别代码中不存在");
                rule.setRules(listDM_c_countryData.isEmpty());
                validate(rule,questions);
            }
        }

        if(obj.getDcl_io_decl_goods_taskHashtable()==null) return;
        if(obj.getDcl_io_decl_goods_taskHashtable().values()==null) return;

        for (DCL_IO_DECL_GOODS_TASK dcl_io_decl_goods_task:
        obj.getDcl_io_decl_goods_taskHashtable().values()) {

            String  eixtEntry1= getEixtEntryByDeclNo(dcl_io_decl_goods_task.getDeclNo());

            if (eixtEntry1.equals("出境")) return;

            //  入境原产地
            String OriCtryCode = dcl_io_decl_goods_task.getOriCtryCode();

            if(dcl_io_decl_goods_task.getOriCtryCode()==null)
            {
                OriCtryCode="";
            }

            List<QUESTION> questions= listQuestion(dcl_io_decl_goods_task.getDeclNo()+"__"+dcl_io_decl_goods_task.getGoodsNo());

            rule.setCheckName("国别代码核查");
            rule.setDataId(dcl_io_decl_goods_task.getDeclNo()+"__"+dcl_io_decl_goods_task.getGoodsNo());
            JSONObject json=new JSONObject();
            json.put("报检单",DeclNo);
            json.put("货物序号",dcl_io_decl_goods_task.getGoodsNo());
            json.put("HS编码",dcl_io_decl_goods_task.getProdHsCode());
            json.put("货物名称",dcl_io_decl_goods_task.getDeclGoodsCname());
            json.put("入境原产地",OriCtryCode);
            rule.setObj(json.toJSONString());
            rule.setDeclNo(dcl_io_decl_goods_task.getDeclNo());
            rule.setGoodsNo(dcl_io_decl_goods_task.getGoodsNo());
            rule.setExitEntry(eixtEntry);
            rule.setOrganization(orgCode);
            rule.setOrganizationName(OrgName);
            rule.setState("未处理");
            rule.setRemark("");
            rule.setType("error");
            rule.setUpdateNum(BigDecimal.valueOf(0));

            //原产国或贸易国为空
            rule.setCheckInfo("原产国或贸易国为空");
            rule.setRules(OriCtryCode.equals(""));
            validate(rule,questions);

            //原产国或贸易国在国别代码中不存在
            if(!OriCtryCode.equals(""))
            {
                List<DM_C_COUNTRY> listDM_c_countryData=dm_c_countryMapper.getListDM_C_COUNTRYData(OriCtryCode);
                rule.setCheckInfo("原产国或贸易国在国别代码中不存在");
                rule.setRules(listDM_c_countryData.isEmpty());
                validate(rule,questions);
            }
        }
    }

    @Override
    public void CheckINS_RESULT(INS_RESULT obj) throws Exception {

    }

    @Override
    protected String getCheckType() {
        return "国别代码";
    }

    @Override
    protected String getDataTable() {
        return "DCL_IO_DECLAndDCL_IO_DECL_GOODS";
    }


}
