package d1.service.rules;

import d1.domain.*;
import d1.domain.mgr.DCL_IO_DECLMgr;
import d1.service.CheckConfigService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public abstract class AbstractCheckRule {
    protected  Hashtable<String,Object> mappers;

    public abstract void CheckDCL_IO_DECL(DCL_IO_DECL obj) throws Exception;
    public abstract void CheckINS_RESULT(INS_RESULT obj) throws Exception;
    protected abstract String getCheckType();
    protected abstract String getDataTable();
    protected DM_C_MEASUREMENT_UNITMapper dm_c_measurement_unitMapper;
    protected QUESTIONMapper questionMapper;
    protected DCL_IO_DECL_HISTORYMapper dcl_io_decl_historyMapper;
    protected DCL_IO_DECL_GOODS_HISTORYMapper dcl_io_decl_goods_historyMapper;
    protected DM_C_Z_BBD_HS_CODEMapper dm_c_z_bbd_hs_codeMapper;
    protected CHECK_CONFIGMapper check_configMapper;
    protected DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;
    protected UNIT_PRICE_RANGEMapper unit_price_rangeMapper;

    public void initMappers(Hashtable<String, Object> mappers) {
        this.mappers =  mappers;
        dm_c_measurement_unitMapper=(DM_C_MEASUREMENT_UNITMapper)mappers.get("DM_C_MEASUREMENT_UNIT");
        questionMapper=(QUESTIONMapper)mappers.get("QUESTION");
        dcl_io_decl_historyMapper=(DCL_IO_DECL_HISTORYMapper)mappers.get("DCL_IO_DECL_HISTORY");
        dcl_io_decl_goods_historyMapper=(DCL_IO_DECL_GOODS_HISTORYMapper)mappers.get("DCL_IO_DECL_GOODS_HISTORY");
        dm_c_z_bbd_hs_codeMapper=(DM_C_Z_BBD_HS_CODEMapper)mappers.get("DM_C_Z_BBD_HS_CODE");
        check_configMapper=(CHECK_CONFIGMapper) mappers.get("CHECK_CONFIG");
        dm_ts_cl_orgMapper=(DM_TS_CL_ORGMapper)mappers.get("DM_TS_CL_ORG");
        unit_price_rangeMapper=(UNIT_PRICE_RANGEMapper)mappers.get("UNIT_PRICE_RANGE");
    }

    //根据产品HS编码，判断取数量还是重量的字段值
    public String GetQtyOrWt(String prodHsCode)
    {
        //根据HSCODE查询第一计量单位 第二计量单位
        DM_C_Z_BBD_HS_CODE dm_c_z_bbd_hs_code=dm_c_z_bbd_hs_codeMapper.DM_C_Z_BBD_HS_CODE(prodHsCode);
        String Code=dm_c_z_bbd_hs_code.getStdMeasureCode();
        String CIQCode=dm_c_z_bbd_hs_code.getCiqStdMeasure();
        if(Code.equals(CIQCode))
        {
            //根据第一计量单位查询计量单位类别
            DM_C_MEASUREMENT_UNIT dm_c_measurement_unit= dm_c_measurement_unitMapper.dm_C_MEASUREMENT_UNITData(Code);
            //TODO 后期修改  现在return 2
            if(dm_c_measurement_unit==null) return "2";
            return dm_c_measurement_unit.getAlias1();
        }
        else
        {
            return "ALL";
        }
    }

    //插入Question表中
    public void AddQuestion(String type, String checkName,String checkInfo,String organization,String organizationName,
                             String dataId, String obj,String declNo,BigDecimal goodsNo,String exitEntry,
//                             String checkById,String checkByName,Date checkTime,
//                             String updateById,String updateByName,Date updateTime,
                            BigDecimal updateNum,
                             String state,String remark) throws Exception
    {

          QUESTION qError=new QUESTION();
          qError.setType(type);
          qError.setCheckType(this.getCheckType());
          qError.setCheckName(checkName);
          qError.setCheckInfor(checkInfo);
          qError.setOrganization(organization);
          qError.setOrganizationName(organizationName);
          qError.setDataTable(this.getDataTable());
          qError.setDataId(dataId);
          qError.setData(obj);
          qError.setDeclNo(declNo);
          qError.setGoodsNo(goodsNo);
          qError.setExitEntry(exitEntry);
//        qError.setCheckById(checkById);
//        qError.setCheckByName(checkByName);
//        qError.setUpdateById(updateById);
//        qError.setUpdateByName(updateByName);
//        qError.setUpdateTime(updateTime);
          qError.setUpdatNum(updateNum);
          qError.setState(state);
          qError.setRemark(remark);
          questionMapper.insert(qError);
    }

    //根据报检单号获取出入境
    public String getEixtEntryByDeclNo(String DeclNo)
    {
        String EixtEntry="出境";
        String substr=DeclNo.substring(0,1);
        if(substr.equals("1")) {
            EixtEntry="入境";
        }
        return EixtEntry;
    }

    public List<QUESTION> listQuestion(String dataId)
    {
       return questionMapper.getQuestionInfo(dataId);
    }

    protected void validate(CheckRule cr,List<QUESTION> questionList) throws Exception {
        boolean b = true;
        boolean[] list = cr.getRules();
        for(boolean l :list){
            b = b&&l;
        }

         QUESTION questionData=null;
            for (QUESTION question:
                    questionList) {
                if (question.getCheckName().equals(cr.checkName) && question.getCheckInfor().equals(cr.checkInfo) &&
                        question.getType().equals(cr.getType())) {
                    questionData = question;
                    break;
                }
            }

        if(b)
        {
            if(questionData==null)
            {
                AddQuestion(cr.getType(),cr.checkName,cr.checkInfo,cr.getOrganization(),cr.getOrganizationName(),
                        cr.dataId,cr.obj,cr.declNo,cr.goodsNo,cr.exitEntry,
                        cr.getUpdateNum(),cr.getState(),cr.getRemark());
            }
            else
            {
                //修改现有数据状态及更新复查次数
                if(!questionData.getState().equals("无需解决")&&!questionData.getState().equals("无法解决")&&!questionData.getState().equals("已删除")) {
                    QUESTION question2 = new QUESTION();
                    question2.setId(questionData.getId());
                    question2.setState("修改仍错误");
                    question2.setUpdateTime(new Date());
                    question2.setUpdatNum(questionData.getUpdateNum().add(BigDecimal.valueOf(1)));
                    questionMapper.put(question2);
                }
            }
        }
        else
        {
            //修改现有数据状态
            if(questionData!=null)
            {
                if(!questionData.getState().equals("无需解决")&&!questionData.getState().equals("无法解决")&&!questionData.getState().equals("已删除")) {
                    QUESTION question2 = new QUESTION();
                    question2.setId(questionData.getId());
                    question2.setState("已解决");
                    question2.setUpdateTime(new Date());
                    questionMapper.put(question2);
                }
            }
        }
    }

    protected  class CheckRule{
        private String checkName;
        private String checkInfo;
        private String dataId;
        private String obj;
        private String declNo;
        private BigDecimal goodsNo;
        private String exitEntry;
        private String type;
        private String organization;
        private String organizationName;
        private BigDecimal updateNum;
        private String state;
        private String remark;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public BigDecimal getUpdateNum() {
            return updateNum;
        }

        public void setUpdateNum(BigDecimal updateNum) {
            this.updateNum = updateNum;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getObj() {
            return obj;
        }

        public void setObj(String obj) {
            this.obj = obj;
        }

        public String getDeclNo() {
            return declNo;
        }

        public void setDeclNo(String declNo) {
            this.declNo = declNo;
        }

        public BigDecimal getGoodsNo() {
            return goodsNo;
        }

        public void setGoodsNo(BigDecimal goodsNo) {
            this.goodsNo = goodsNo;
        }

        public String getExitEntry() {
            return exitEntry;
        }

        public void setExitEntry(String exitEntry) {
            this.exitEntry = exitEntry;
        }

        private boolean[] rules;

        public String getCheckName() {
            return checkName;
        }

        public void setCheckName(String checkName) {
            this.checkName = checkName;
        }

        public String getCheckInfo() {
            return checkInfo;
        }

        public void setCheckInfo(String checkInfo) {
            this.checkInfo = checkInfo;
        }

        public boolean[] getRules() {
            return rules;
        }

        public void setRules(boolean ... rules) {
            this.rules = rules;
        }
    }

    //数值是否大于0小于1
    public boolean ZeroAndOne(BigDecimal qty)
    {
        return NumberCompare(qty,0,1);
    }

    public boolean NumberCompare(BigDecimal qty,double x,double y)
    {
        if(qty==null) return false;
        if( qty.compareTo(BigDecimal.valueOf(x))>0&&qty.compareTo(BigDecimal.valueOf(y))<0){return true;}
        return false;
    }
    //数值等于0
    public boolean IsEqualZero(BigDecimal qty)
    {
        if(qty==null) return false;
        if( qty.compareTo(BigDecimal.valueOf(0))==0){return true;}
        return false;
    }

    //判断小数点后的位数是否大于5
    public boolean IsLengthEqualFive(BigDecimal  qty)
    {
        if(qty==null) return false;
        if(qty.toString().contains("."))
        {
            String strQty=qty.toString();
            if(strQty.substring( strQty.indexOf(".")+1,strQty.length()).length()>5)  return true;
        }
        return false;
    }

    //出境/入境例外情况
    public boolean ExceptionCondiTion(String DeclNo, BigDecimal GoodsNo)
    {
        DCL_IO_DECL_TASK dcl_io_decl_task;
        DCL_IO_DECL_GOODS_TASK dcl_io_decl_goods_task;
        DCL_IO_DECL dcl_io_decl=  DCL_IO_DECLMgr.Instance().getDCL_IO_DECLFromCache(DeclNo);
        if(dcl_io_decl!=null)
        {
            dcl_io_decl_task=dcl_io_decl.getDcl_io_decl_task();
            if(dcl_io_decl_task==null) return true;
            Hashtable<String,DCL_IO_DECL_GOODS_TASK> dcl_io_decl_goods_taskHashtable=dcl_io_decl.getDcl_io_decl_goods_taskHashtable();
            if(dcl_io_decl_goods_taskHashtable==null) return true;
            dcl_io_decl_goods_task=dcl_io_decl_goods_taskHashtable.get(DeclNo+"__"+GoodsNo);
            if(dcl_io_decl_goods_task==null) return true;
        }
        else
        {
            dcl_io_decl_task=  dcl_io_decl_historyMapper.getDclIoDeclTaskHistoryByDeclNo(DeclNo);
            if(dcl_io_decl_task==null) return true;
            dcl_io_decl_goods_task=  dcl_io_decl_goods_historyMapper.getDclIoDeclGoodsTaskHistoryDetailInfo(GoodsNo,DeclNo);
            if(dcl_io_decl_goods_task==null) return true;
        }

        String ExitOrEntry= getEixtEntryByDeclNo(DeclNo);
        if(dcl_io_decl_task.getDeclCode()!=null)
        {
            if(ExitOrEntry.equals("出境"))
            {

                if(dcl_io_decl_task.getDeclCode().equals("25")||dcl_io_decl_task.getDeclCode().equals("28")) return true;
            }
            else
            {
                if(dcl_io_decl_task.getDeclCode().equals("14")||dcl_io_decl_task.getDeclCode().equals("15")) return true;
            }
        }

        if(dcl_io_decl_task.getTradeModeCode()!=null)
        {
            if(dcl_io_decl_task.getTradeModeCode().equals("7")||dcl_io_decl_task.getTradeModeCode().equals("10")||
                    dcl_io_decl_task.getTradeModeCode().equals("17")||dcl_io_decl_task.getTradeModeCode().equals("18")||
                    dcl_io_decl_task.getTradeModeCode().equals("19")||dcl_io_decl_task.getTradeModeCode().equals("20")||
                    dcl_io_decl_task.getTradeModeCode().equals("21")) return true;
        }

        if(dcl_io_decl_goods_task.getInspType()!=null)
        {
            if(dcl_io_decl_goods_task.getInspType().equals("81")) return true;
        }

        return false;
    }

    //根据报检单号和货物号获取报检单明细信息
    public DCL_IO_DECL_GOODS_TASK getDclIoDeclGoodsTaskHistoryDetailInfo(String DeclNo,BigDecimal GoodsNo) {
        DCL_IO_DECL_GOODS_TASK  dcl_io_decl_goods_task;
        DCL_IO_DECL dcl_io_decl=  DCL_IO_DECLMgr.Instance().getDCL_IO_DECLFromCache(DeclNo);
        if(dcl_io_decl!=null)
        {
            Hashtable<String,DCL_IO_DECL_GOODS_TASK> dcl_io_decl_goods_taskHashtable=dcl_io_decl.getDcl_io_decl_goods_taskHashtable();
            dcl_io_decl_goods_task=dcl_io_decl_goods_taskHashtable.get(DeclNo+"__"+GoodsNo);
        }
        else
        {
            dcl_io_decl_goods_task=  dcl_io_decl_goods_historyMapper.getDclIoDeclGoodsTaskHistoryDetailInfo(GoodsNo,DeclNo);
        }
        return dcl_io_decl_goods_task;
    }

    //根据Id获取配置信息
    public String GetByIdConfigInfo(String id)
    {
        CHECK_CONFIG check_config= CheckConfigService.Instance().getConfigObj(check_configMapper,id);
        return check_config.getValue();
    }

    //根据机构代码查找机构名称
    public String GetOrgNameByOrgCode(String OrgCode) {
        List<DM_TS_CL_ORG> dm_ts_cl_orgList = dm_ts_cl_orgMapper.getOrgNameByOrgCode(OrgCode);
        if(dm_ts_cl_orgList.isEmpty()) return "";
        return dm_ts_cl_orgList.get(0).getOrgName();
    }

}
