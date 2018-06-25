package d1.service.rules;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.domain.*;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.List;

public class CheckRule7 extends AbstractCheckRule {
    private static CheckRule7 instance=null;
    private DM_C_CHINA_DISTRIC_LEVELMapper dm_c_china_distric_levelMapper;

    public static CheckRule7 Instance(){
        if(instance==null)
            instance = new CheckRule7();
        return instance;
    }
    private CheckRule7(){

    }

    public void initMappers(Hashtable<String, Object> mappers)
    {
        super.initMappers(mappers);
        dm_c_china_distric_levelMapper=(DM_C_CHINA_DISTRIC_LEVELMapper)mappers.get("DM_C_CHINA_DISTRIC_LEVEL");
    }

    @Override
    public void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception {
        if(obj.getDcl_io_decl_task()==null) return;

        CheckRule rule=new CheckRule();

        // 入境目的地
        String DeclNo=obj.getDcl_io_decl_task().getDeclNo();

        //组织机构
        String orgCode=obj.getDcl_io_decl_task().getOrgCode();
        String OrgName= GetOrgNameByOrgCode(orgCode);

        //出入境
        String  eixtEntry= getEixtEntryByDeclNo(obj.getDcl_io_decl_task().getDeclNo());

        if(eixtEntry.equals("入境"))
        {
            List<QUESTION> questions= listQuestion(DeclNo);

            String DestCode=obj.getDcl_io_decl_task().getDestCode();

            if(obj.getDcl_io_decl_task().getDestCode()==null)
            {
                DestCode="";
            }

            rule.setCheckName("行政区划核查");
            rule.setDataId(DeclNo);
            JSONObject json=new JSONObject();
            json.put("报检单",DeclNo);
            json.put("货物序号","");
            json.put("HS编码","");
            json.put("货物名称","");
            json.put("入境目的地",DestCode);
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


            //目的地为空
            rule.setCheckInfo("目的地为空");
            rule.setRules(DestCode.equals(""));
            validate(rule,questions);

            //目的地在行政区划代码中不存在
            if(!DestCode.equals(""))
            {
                List<DM_C_CHINA_DISTRIC_LEVEL> listDM_c_china_distric_levelData=dm_c_china_distric_levelMapper.getListDM_C_CHINA_DISTRIC_LEVELData(DestCode);
                rule.setCheckInfo("目的地在行政区划代码中不存在");
                rule.setRules(listDM_c_china_distric_levelData.isEmpty());
                validate(rule,questions);
            }
        }

        if(obj.getDcl_io_decl_goods_taskHashtable()==null) return;
        if(obj.getDcl_io_decl_goods_taskHashtable().values()==null) return;

        for (DCL_IO_DECL_GOODS_TASK dcl_io_decl_goods_task:
                obj.getDcl_io_decl_goods_taskHashtable().values()) {

            String  eixtEntry1= getEixtEntryByDeclNo(dcl_io_decl_goods_task.getDeclNo());

            if (eixtEntry1.equals("入境")) return;

            List<QUESTION> questions= listQuestion(dcl_io_decl_goods_task.getDeclNo()+"__"+dcl_io_decl_goods_task.getGoodsNo());

            //  出境产地
            String OrigPlaceCode = dcl_io_decl_goods_task.getOrigPlaceCode();

            if(dcl_io_decl_goods_task.getOrigPlaceCode()==null)
            {
                OrigPlaceCode="";
            }

            rule.setCheckName("行政区划核查");
            rule.setDataId(dcl_io_decl_goods_task.getDeclNo()+"__"+dcl_io_decl_goods_task.getGoodsNo());
            JSONObject json=new JSONObject();
            json.put("报检单",DeclNo);
            json.put("货物序号",dcl_io_decl_goods_task.getGoodsNo());
            json.put("HS编码",dcl_io_decl_goods_task.getProdHsCode());
            json.put("货物名称",dcl_io_decl_goods_task.getDeclGoodsCname());
            json.put("出境产地",OrigPlaceCode);
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


            rule.setCheckInfo("产地为空");
            rule.setRules(OrigPlaceCode.equals(""));
            validate(rule,questions);

            if(!OrigPlaceCode.equals(""))
            {
                List<DM_C_CHINA_DISTRIC_LEVEL> listDM_c_china_distric_levelData=dm_c_china_distric_levelMapper.getListDM_C_CHINA_DISTRIC_LEVELData(OrigPlaceCode);
                rule.setCheckInfo("产地在行政区划代码中不存在");
                rule.setRules(listDM_c_china_distric_levelData.isEmpty());
                validate(rule,questions);
            }
        }
    }

    @Override
    public void CheckINS_RESULT(INS_RESULT obj) throws Exception {

    }

    @Override
    protected String getCheckType() {
        return "行政区划";
    }

    @Override
    protected String getDataTable() {
        return "DCL_IO_DECLAndDCL_IO_DECL_GOODS";
    }

}
