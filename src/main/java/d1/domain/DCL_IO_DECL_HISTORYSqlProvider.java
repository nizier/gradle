package d1.domain;

import d1.domain.DCL_IO_DECL_HISTORY;
import org.apache.ibatis.jdbc.SQL;

public class DCL_IO_DECL_HISTORYSqlProvider {

    public String insertSelective(DCL_IO_DECL_HISTORY record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DCL_IO_DECL_HISTORY");
        
        if (record.getDeclNo() != null) {
            sql.VALUES("DECL_NO", "#{declNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeModeCode() != null) {
            sql.VALUES("TRADE_MODE_CODE", "#{tradeModeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getContractNo() != null) {
            sql.VALUES("CONTRACT_NO", "#{contractNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMarkNo() != null) {
            sql.VALUES("MARK_NO", "#{markNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeCountryCode() != null) {
            sql.VALUES("TRADE_COUNTRY_CODE", "#{tradeCountryCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDespCtryCode() != null) {
            sql.VALUES("DESP_CTRY_CODE", "#{despCtryCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTransModeCode() != null) {
            sql.VALUES("TRANS_MODE_CODE", "#{transModeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getConvynceName() != null) {
            sql.VALUES("CONVYNCE_NAME", "#{convynceName,jdbcType=VARCHAR}");
        }
        
        if (record.getTransMeanNo() != null) {
            sql.VALUES("TRANS_MEAN_NO", "#{transMeanNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDespPortCode() != null) {
            sql.VALUES("DESP_PORT_CODE", "#{despPortCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPortStopCode() != null) {
            sql.VALUES("PORT_STOP_CODE", "#{portStopCode,jdbcType=VARCHAR}");
        }
        
        if (record.getEntyPortCode() != null) {
            sql.VALUES("ENTY_PORT_CODE", "#{entyPortCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGdsArvlDate() != null) {
            sql.VALUES("GDS_ARVL_DATE", "#{gdsArvlDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCmplDschrgDt() != null) {
            sql.VALUES("CMPL_DSCHRG_DT", "#{cmplDschrgDt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGoodsPlace() != null) {
            sql.VALUES("GOODS_PLACE", "#{goodsPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getDestCode() != null) {
            sql.VALUES("DEST_CODE", "#{destCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCounterClaim() != null) {
            sql.VALUES("COUNTER_CLAIM", "#{counterClaim,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillLadNo() != null) {
            sql.VALUES("BILL_LAD_NO", "#{billLadNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDeliveryOrder() != null) {
            sql.VALUES("DELIVERY_ORDER", "#{deliveryOrder,jdbcType=VARCHAR}");
        }
        
        if (record.getInspOrgCode() != null) {
            sql.VALUES("INSP_ORG_CODE", "#{inspOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExcInspDeptCode() != null) {
            sql.VALUES("EXC_INSP_DEPT_CODE", "#{excInspDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclCustm() != null) {
            sql.VALUES("DECL_CUSTM", "#{declCustm,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecDeclFlag() != null) {
            sql.VALUES("SPEC_DECL_FLAG", "#{specDeclFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getPurpOrgCode() != null) {
            sql.VALUES("PURP_ORG_CODE", "#{purpOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCorrelationDeclNo() != null) {
            sql.VALUES("CORRELATION_DECL_NO", "#{correlationDeclNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCorrelationReasonFlag() != null) {
            sql.VALUES("CORRELATION_REASON_FLAG", "#{correlationReasonFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeclInspQuraRe() != null) {
            sql.VALUES("SPECL_INSP_QURA_RE", "#{speclInspQuraRe,jdbcType=VARCHAR}");
        }
        
        if (record.getAppCertCode() != null) {
            sql.VALUES("APP_CERT_CODE", "#{appCertCode,jdbcType=VARCHAR}");
        }
        
        if (record.getApplOri() != null) {
            sql.VALUES("APPL_ORI", "#{applOri,jdbcType=VARCHAR}");
        }
        
        if (record.getApplCopyQuan() != null) {
            sql.VALUES("APPL_COPY_QUAN", "#{applCopyQuan,jdbcType=VARCHAR}");
        }
        
        if (record.getCustmRegNo() != null) {
            sql.VALUES("CUSTM_REG_NO", "#{custmRegNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclPersnCertNo() != null) {
            sql.VALUES("DECL_PERSN_CERT_NO", "#{declPersnCertNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclPersonName() != null) {
            sql.VALUES("DECL_PERSON_NAME", "#{declPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclRegName() != null) {
            sql.VALUES("DECL_REG_NAME", "#{declRegName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactperson() != null) {
            sql.VALUES("CONTACTPERSON", "#{contactperson,jdbcType=VARCHAR}");
        }
        
        if (record.getContTel() != null) {
            sql.VALUES("CONT_TEL", "#{contTel,jdbcType=VARCHAR}");
        }
        
        if (record.getConsigneeCode() != null) {
            sql.VALUES("CONSIGNEE_CODE", "#{consigneeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getConsigneeCname() != null) {
            sql.VALUES("CONSIGNEE_CNAME", "#{consigneeCname,jdbcType=VARCHAR}");
        }
        
        if (record.getConsigneeEname() != null) {
            sql.VALUES("CONSIGNEE_ENAME", "#{consigneeEname,jdbcType=VARCHAR}");
        }
        
        if (record.getConsignorCname() != null) {
            sql.VALUES("CONSIGNOR_CNAME", "#{consignorCname,jdbcType=VARCHAR}");
        }
        
        if (record.getConsignorAddr() != null) {
            sql.VALUES("CONSIGNOR_ADDR", "#{consignorAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclCode() != null) {
            sql.VALUES("DECL_CODE", "#{declCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclDate() != null) {
            sql.VALUES("DECL_DATE", "#{declDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeclGetNo() != null) {
            sql.VALUES("DECL_GET_NO", "#{declGetNo,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecPassFlag() != null) {
            sql.VALUES("SPEC_PASS_FLAG", "#{specPassFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getDespDate() != null) {
            sql.VALUES("DESP_DATE", "#{despDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getArrivPortCode() != null) {
            sql.VALUES("ARRIV_PORT_CODE", "#{arrivPortCode,jdbcType=VARCHAR}");
        }
        
        if (record.getConsigneeAddr() != null) {
            sql.VALUES("CONSIGNEE_ADDR", "#{consigneeAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getConsignorCode() != null) {
            sql.VALUES("CONSIGNOR_CODE", "#{consignorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAttaCollectName() != null) {
            sql.VALUES("ATTA_COLLECT_NAME", "#{attaCollectName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsListGood() != null) {
            sql.VALUES("IS_LIST_GOOD", "#{isListGood,jdbcType=CHAR}");
        }
        
        if (record.getIsCont() != null) {
            sql.VALUES("IS_CONT", "#{isCont,jdbcType=CHAR}");
        }
        
        if (record.getFfjFlag() != null) {
            sql.VALUES("FFJ_FLAG", "#{ffjFlag,jdbcType=CHAR}");
        }
        
        if (record.getFfjStatus() != null) {
            sql.VALUES("FFJ_STATUS", "#{ffjStatus,jdbcType=CHAR}");
        }
        
        if (record.getResendNum() != null) {
            sql.VALUES("RESEND_NUM", "#{resendNum,jdbcType=CHAR}");
        }
        
        if (record.getIsDraw() != null) {
            sql.VALUES("IS_DRAW", "#{isDraw,jdbcType=CHAR}");
        }
        
        if (record.getTotalValUs() != null) {
            sql.VALUES("TOTAL_VAL_US", "#{totalValUs,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalValCn() != null) {
            sql.VALUES("TOTAL_VAL_CN", "#{totalValCn,jdbcType=DECIMAL}");
        }
        
        if (record.getContCancelFlag() != null) {
            sql.VALUES("CONT_CANCEL_FLAG", "#{contCancelFlag,jdbcType=CHAR}");
        }
        
        if (record.getFeeHandleState() != null) {
            sql.VALUES("FEE_HANDLE_STATE", "#{feeHandleState,jdbcType=VARCHAR}");
        }
        
        if (record.getRelsState() != null) {
            sql.VALUES("RELS_STATE", "#{relsState,jdbcType=VARCHAR}");
        }
        
        if (record.getFlgPortInland() != null) {
            sql.VALUES("FLG_PORT_INLAND", "#{flgPortInland,jdbcType=CHAR}");
        }
        
        if (record.getEnableTransFlag() != null) {
            sql.VALUES("ENABLE_TRANS_FLAG", "#{enableTransFlag,jdbcType=CHAR}");
        }
        
        if (record.getFalgArchive() != null) {
            sql.VALUES("FALG_ARCHIVE", "#{falgArchive,jdbcType=CHAR}");
        }
        
        if (record.getSituationCode() != null) {
            sql.VALUES("SITUATION_CODE", "#{situationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSituationLevel() != null) {
            sql.VALUES("SITUATION_LEVEL", "#{situationLevel,jdbcType=CHAR}");
        }
        
        if (record.getProcessStatus() != null) {
            sql.VALUES("PROCESS_STATUS", "#{processStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getOperCode() != null) {
            sql.VALUES("OPER_CODE", "#{operCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTime() != null) {
            sql.VALUES("OPER_TIME", "#{operTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppCertName() != null) {
            sql.VALUES("APP_CERT_NAME", "#{appCertName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclRegNo() != null) {
            sql.VALUES("DECL_REG_NO", "#{declRegNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEntDeclNo() != null) {
            sql.VALUES("ENT_DECL_NO", "#{entDeclNo,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessLink() != null) {
            sql.VALUES("PROCESS_LINK", "#{processLink,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.VALUES("ORG_CODE", "#{orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCertCancelFlag() != null) {
            sql.VALUES("CERT_CANCEL_FLAG", "#{certCancelFlag,jdbcType=CHAR}");
        }
        
        if (record.getConsignorEname() != null) {
            sql.VALUES("CONSIGNOR_ENAME", "#{consignorEname,jdbcType=VARCHAR}");
        }
        
        if (record.getArchiveTime() != null) {
            sql.VALUES("ARCHIVE_TIME", "#{archiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTransFlag() != null) {
            sql.VALUES("TRANS_FLAG", "#{transFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getSplitBillLadNo() != null) {
            sql.VALUES("SPLIT_BILL_LAD_NO", "#{splitBillLadNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEntUuid() != null) {
            sql.VALUES("ENT_UUID", "#{entUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclType() != null) {
            sql.VALUES("DECL_TYPE", "#{declType,jdbcType=CHAR}");
        }
        
        if (record.getOrgCodePath() != null) {
            sql.VALUES("ORG_CODE_PATH", "#{orgCodePath,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclStatus() != null) {
            sql.VALUES("DECL_STATUS", "#{declStatus,jdbcType=CHAR}");
        }
        
        if (record.getIsFee() != null) {
            sql.VALUES("IS_FEE", "#{isFee,jdbcType=CHAR}");
        }
        
        if (record.getDeclWorkNo() != null) {
            sql.VALUES("DECL_WORK_NO", "#{declWorkNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPurpDeptCode() != null) {
            sql.VALUES("PURP_DEPT_CODE", "#{purpDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDclIoDeclId() != null) {
            sql.VALUES("DCL_IO_DECL_ID", "#{dclIoDeclId,jdbcType=VARCHAR}");
        }
        
        if (record.getVsaOrgCode() != null) {
            sql.VALUES("VSA_ORG_CODE", "#{vsaOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPortOrgCode() != null) {
            sql.VALUES("PORT_ORG_CODE", "#{portOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPortDeptCode() != null) {
            sql.VALUES("PORT_DEPT_CODE", "#{portDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInteFlag() != null) {
            sql.VALUES("INTE_FLAG", "#{inteFlag,jdbcType=CHAR}");
        }
        
        if (record.getBriFlag() != null) {
            sql.VALUES("BRI_FLAG", "#{briFlag,jdbcType=CHAR}");
        }
        
        if (record.getCheckOkFlag() != null) {
            sql.VALUES("CHECK_OK_FLAG", "#{checkOkFlag,jdbcType=CHAR}");
        }
        
        if (record.getDisChargeFlag() != null) {
            sql.VALUES("DIS_CHARGE_FLAG", "#{disChargeFlag,jdbcType=CHAR}");
        }
        
        if (record.getOrigBoxFlag() != null) {
            sql.VALUES("ORIG_BOX_FLAG", "#{origBoxFlag,jdbcType=CHAR}");
        }
        
        if (record.getVsaOrgCodePath() != null) {
            sql.VALUES("VSA_ORG_CODE_PATH", "#{vsaOrgCodePath,jdbcType=VARCHAR}");
        }
        
        if (record.getInspOrgCodePath() != null) {
            sql.VALUES("INSP_ORG_CODE_PATH", "#{inspOrgCodePath,jdbcType=VARCHAR}");
        }
        
        if (record.getPurpOrgCodePath() != null) {
            sql.VALUES("PURP_ORG_CODE_PATH", "#{purpOrgCodePath,jdbcType=VARCHAR}");
        }
        
        if (record.getPortOrgCodePath() != null) {
            sql.VALUES("PORT_ORG_CODE_PATH", "#{portOrgCodePath,jdbcType=VARCHAR}");
        }
        
        if (record.getPriKey() != null) {
            sql.VALUES("PRI_KEY", "#{priKey,jdbcType=VARCHAR}");
        }
        
        if (record.getTransTypeTj() != null) {
            sql.VALUES("TRANS_TYPE_TJ", "#{transTypeTj,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTimeTj() != null) {
            sql.VALUES("OPER_TIME_TJ", "#{operTimeTj,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEntDate() != null) {
            sql.VALUES("ENT_DATE", "#{entDate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }
}