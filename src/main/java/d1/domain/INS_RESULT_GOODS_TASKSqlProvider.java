package d1.domain;

import d1.domain.INS_RESULT_GOODS_TASK;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;

public class INS_RESULT_GOODS_TASKSqlProvider {

    //批量删除
    public String batchDelete(@Param("lists") List<INS_RESULT_GOODS_TASK> lists) {
        //RESULT_GOODS_ID为主键
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM INS_RESULT_GOODS_TASK WHERE RESULT_GOODS_ID in (");
        MessageFormat messageFormat = new MessageFormat("#'{'lists[{0}].RESULT_GOODS_ID}");
        for(int i = 0 ;i<lists.size();i++) {
            sb.append(messageFormat.format(new Integer[]{i}));
            if (i < lists.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    //批量添加
    public String batchInsert(List<INS_RESULT_GOODS_TASK> lists) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<lists.size();i++) {
            INS_RESULT_GOODS_TASK record = lists.get(i);
            sb.append(insertSelective(record));
            sb.append(";");
        }
        return sb.toString();
    }

    public String insertSelective(INS_RESULT_GOODS_TASK record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("INS_RESULT_GOODS_TASK");
        
        if (record.getResultGoodsId() != null) {
            sql.VALUES("RESULT_GOODS_ID", "#{resultGoodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclNo() != null) {
            sql.VALUES("DECL_NO", "#{declNo,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNo() != null) {
            sql.VALUES("GOODS_NO", "#{goodsNo,jdbcType=DECIMAL}");
        }
        
        if (record.getProdHsCode() != null) {
            sql.VALUES("PROD_HS_CODE", "#{prodHsCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStatKindCode() != null) {
            sql.VALUES("STAT_KIND_CODE", "#{statKindCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSpec() != null) {
            sql.VALUES("SPEC", "#{spec,jdbcType=VARCHAR}");
        }
        
        if (record.getMesuUnTypCode() != null) {
            sql.VALUES("MESU_UN_TYP_CODE", "#{mesuUnTypCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWeightNet() != null) {
            sql.VALUES("WEIGHT_NET", "#{weightNet,jdbcType=DECIMAL}");
        }
        
        if (record.getWeightGross() != null) {
            sql.VALUES("WEIGHT_GROSS", "#{weightGross,jdbcType=DECIMAL}");
        }
        
        if (record.getWtUnitCode() != null) {
            sql.VALUES("WT_UNIT_CODE", "#{wtUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStdWt() != null) {
            sql.VALUES("STD_WT", "#{stdWt,jdbcType=DECIMAL}");
        }
        
        if (record.getStdWtUnitCode() != null) {
            sql.VALUES("STD_WT_UNIT_CODE", "#{stdWtUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStatclWtValue() != null) {
            sql.VALUES("STATCL_WT_VALUE", "#{statclWtValue,jdbcType=DECIMAL}");
        }
        
        if (record.getStatWtUnitCode() != null) {
            sql.VALUES("STAT_WT_UNIT_CODE", "#{statWtUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getQty() != null) {
            sql.VALUES("QTY", "#{qty,jdbcType=DECIMAL}");
        }
        
        if (record.getQtyUnitCode() != null) {
            sql.VALUES("QTY_UNIT_CODE", "#{qtyUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStdQty() != null) {
            sql.VALUES("STD_QTY", "#{stdQty,jdbcType=DECIMAL}");
        }
        
        if (record.getStdQtyUnitCode() != null) {
            sql.VALUES("STD_QTY_UNIT_CODE", "#{stdQtyUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStatclQtyValue() != null) {
            sql.VALUES("STATCL_QTY_VALUE", "#{statclQtyValue,jdbcType=DECIMAL}");
        }
        
        if (record.getStatQuatyUnCo() != null) {
            sql.VALUES("STAT_QUATY_UN_CO", "#{statQuatyUnCo,jdbcType=VARCHAR}");
        }
        
        if (record.getPackQty() != null) {
            sql.VALUES("PACK_QTY", "#{packQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPackTypeCode() != null) {
            sql.VALUES("PACK_TYPE_CODE", "#{packTypeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            sql.VALUES("CURRENCY", "#{currency,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsTotalVal() != null) {
            sql.VALUES("GOODS_TOTAL_VAL", "#{goodsTotalVal,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalValUs() != null) {
            sql.VALUES("TOTAL_VAL_US", "#{totalValUs,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalValCn() != null) {
            sql.VALUES("TOTAL_VAL_CN", "#{totalValCn,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsPlace() != null) {
            sql.VALUES("GOODS_PLACE", "#{goodsPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryDate() != null) {
            sql.VALUES("ENTRY_DATE", "#{entryDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCmplDschrgDt() != null) {
            sql.VALUES("CMPL_DSCHRG_DT", "#{cmplDschrgDt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUnquaWt() != null) {
            sql.VALUES("UNQUA_WT", "#{unquaWt,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqualQty() != null) {
            sql.VALUES("UNQUAL_QTY", "#{unqualQty,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqualAmt() != null) {
            sql.VALUES("UNQUAL_AMT", "#{unqualAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getUnquAmntUsd() != null) {
            sql.VALUES("UNQU_AMNT_USD", "#{unquAmntUsd,jdbcType=DECIMAL}");
        }
        
        if (record.getDisquaAmtRmb() != null) {
            sql.VALUES("DISQUA_AMT_RMB", "#{disquaAmtRmb,jdbcType=DECIMAL}");
        }
        
        if (record.getClaimAmt() != null) {
            sql.VALUES("CLAIM_AMT", "#{claimAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getClaimAmtUsd() != null) {
            sql.VALUES("CLAIM_AMT_USD", "#{claimAmtUsd,jdbcType=DECIMAL}");
        }
        
        if (record.getClaimAmtRmb() != null) {
            sql.VALUES("CLAIM_AMT_RMB", "#{claimAmtRmb,jdbcType=DECIMAL}");
        }
        
        if (record.getDisquaContCodes() != null) {
            sql.VALUES("DISQUA_CONT_CODES", "#{disquaContCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getInspUnqResn() != null) {
            sql.VALUES("INSP_UNQ_RESN", "#{inspUnqResn,jdbcType=VARCHAR}");
        }
        
        if (record.getInpUnqualHaCode() != null) {
            sql.VALUES("INP_UNQUAL_HA_CODE", "#{inpUnqualHaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspPatternCode() != null) {
            sql.VALUES("INSP_PATTERN_CODE", "#{inspPatternCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWtDetModeCode() != null) {
            sql.VALUES("WT_DET_MODE_CODE", "#{wtDetModeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWtDetWorkModeC() != null) {
            sql.VALUES("WT_DET_WORK_MODE_C", "#{wtDetWorkModeC,jdbcType=VARCHAR}");
        }
        
        if (record.getDamagIdProCode() != null) {
            sql.VALUES("DAMAG_ID_PRO_CODE", "#{damagIdProCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDamgedResnCode() != null) {
            sql.VALUES("DAMGED_RESN_CODE", "#{damgedResnCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDamagedAmt() != null) {
            sql.VALUES("DAMAGED_AMT", "#{damagedAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getDamageAmtUsd() != null) {
            sql.VALUES("DAMAGE_AMT_USD", "#{damageAmtUsd,jdbcType=DECIMAL}");
        }
        
        if (record.getDamageAmtRmb() != null) {
            sql.VALUES("DAMAGE_AMT_RMB", "#{damageAmtRmb,jdbcType=DECIMAL}");
        }
        
        if (record.getQurUnqulRsnCode() != null) {
            sql.VALUES("QUR_UNQUL_RSN_CODE", "#{qurUnqulRsnCode,jdbcType=VARCHAR}");
        }
        
        if (record.getQurUnqProcCode() != null) {
            sql.VALUES("QUR_UNQ_PROC_CODE", "#{qurUnqProcCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeQuarTrmtMecC() != null) {
            sql.VALUES("SPE_QUAR_TRMT_MEC_C", "#{speQuarTrmtMecC,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarTrtOrgCode() != null) {
            sql.VALUES("QUAR_TRT_ORG_CODE", "#{quarTrtOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarTrtDeptCode() != null) {
            sql.VALUES("QUAR_TRT_DEPT_CODE", "#{quarTrtDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStatUnitName() != null) {
            sql.VALUES("STAT_UNIT_NAME", "#{statUnitName,jdbcType=VARCHAR}");
        }
        
        if (record.getInspContCodes() != null) {
            sql.VALUES("INSP_CONT_CODES", "#{inspContCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNameCn() != null) {
            sql.VALUES("GOODS_NAME_CN", "#{goodsNameCn,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNameEn() != null) {
            sql.VALUES("GOODS_NAME_EN", "#{goodsNameEn,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsflag() != null) {
            sql.VALUES("GOODSFLAG", "#{goodsflag,jdbcType=VARCHAR}");
        }
        
        if (record.getInspResEval() != null) {
            sql.VALUES("INSP_RES_EVAL", "#{inspResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getInspOrgCode() != null) {
            sql.VALUES("INSP_ORG_CODE", "#{inspOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspDeptCode() != null) {
            sql.VALUES("INSP_DEPT_CODE", "#{inspDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspUnquafWt() != null) {
            sql.VALUES("INSP_UNQUAF_WT", "#{inspUnquafWt,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqulCommInsQty() != null) {
            sql.VALUES("UNQUL_COMM_INS_QTY", "#{unqulCommInsQty,jdbcType=DECIMAL}");
        }
        
        if (record.getInspUnquaAmt() != null) {
            sql.VALUES("INSP_UNQUA_AMT", "#{inspUnquaAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getInspUnquAmntUs() != null) {
            sql.VALUES("INSP_UNQU_AMNT_US", "#{inspUnquAmntUs,jdbcType=DECIMAL}");
        }
        
        if (record.getInspDisquaAmtRmb() != null) {
            sql.VALUES("INSP_DISQUA_AMT_RMB", "#{inspDisquaAmtRmb,jdbcType=DECIMAL}");
        }
        
        if (record.getQuarResEval() != null) {
            sql.VALUES("QUAR_RES_EVAL", "#{quarResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getQuaraOrgCode() != null) {
            sql.VALUES("QUARA_ORG_CODE", "#{quaraOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarDeptCode() != null) {
            sql.VALUES("QUAR_DEPT_CODE", "#{quarDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getQuaranUnquaWt() != null) {
            sql.VALUES("QUARAN_UNQUA_WT", "#{quaranUnquaWt,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqulfdQuarQty() != null) {
            sql.VALUES("UNQULFD_QUAR_QTY", "#{unqulfdQuarQty,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqualQuarAmt() != null) {
            sql.VALUES("UNQUAL_QUAR_AMT", "#{unqualQuarAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqulQuarAmtUs() != null) {
            sql.VALUES("UNQUL_QUAR_AMT_US", "#{unqulQuarAmtUs,jdbcType=DECIMAL}");
        }
        
        if (record.getUnqulQuarAmtCn() != null) {
            sql.VALUES("UNQUL_QUAR_AMT_CN", "#{unqulQuarAmtCn,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsWtValue() != null) {
            sql.VALUES("RELS_WT_VALUE", "#{relsWtValue,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsQtyValue() != null) {
            sql.VALUES("RELS_QTY_VALUE", "#{relsQtyValue,jdbcType=DECIMAL}");
        }
        
        if (record.getReleaseAmt() != null) {
            sql.VALUES("RELEASE_AMT", "#{releaseAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsAmountUsd() != null) {
            sql.VALUES("RELS_AMOUNT_USD", "#{relsAmountUsd,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsAmountRmb() != null) {
            sql.VALUES("RELS_AMOUNT_RMB", "#{relsAmountRmb,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsPackQty() != null) {
            sql.VALUES("RELS_PACK_QTY", "#{relsPackQty,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsStdWt() != null) {
            sql.VALUES("RELS_STD_WT", "#{relsStdWt,jdbcType=DECIMAL}");
        }
        
        if (record.getRelsStdQty() != null) {
            sql.VALUES("RELS_STD_QTY", "#{relsStdQty,jdbcType=DECIMAL}");
        }
        
        if (record.getApprslOrgCode() != null) {
            sql.VALUES("APPRSL_ORG_CODE", "#{apprslOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getApprtDeptCode() != null) {
            sql.VALUES("APPRT_DEPT_CODE", "#{apprtDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspContStr() != null) {
            sql.VALUES("INSP_CONT_STR", "#{inspContStr,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarContStr() != null) {
            sql.VALUES("QUAR_CONT_STR", "#{quarContStr,jdbcType=VARCHAR}");
        }
        
        if (record.getInspDisquaContCodes() != null) {
            sql.VALUES("INSP_DISQUA_CONT_CODES", "#{inspDisquaContCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarDisquaContCodes() != null) {
            sql.VALUES("QUAR_DISQUA_CONT_CODES", "#{quarDisquaContCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevtivTreatmt() != null) {
            sql.VALUES("PREVTIV_TREATMT", "#{prevtivTreatmt,jdbcType=VARCHAR}");
        }
        
        if (record.getMnufctrCode() != null) {
            sql.VALUES("MNUFCTR_CODE", "#{mnufctrCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProdBatchNo() != null) {
            sql.VALUES("PROD_BATCH_NO", "#{prodBatchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInspOperCode() != null) {
            sql.VALUES("INSP_OPER_CODE", "#{inspOperCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInsOpertDate() != null) {
            sql.VALUES("INS_OPERT_DATE", "#{insOpertDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQuarOperCode() != null) {
            sql.VALUES("QUAR_OPER_CODE", "#{quarOperCode,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarCondtTime() != null) {
            sql.VALUES("QUAR_CONDT_TIME", "#{quarCondtTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIdenOperCode() != null) {
            sql.VALUES("IDEN_OPER_CODE", "#{idenOperCode,jdbcType=VARCHAR}");
        }
        
        if (record.getApprCondtTime() != null) {
            sql.VALUES("APPR_CONDT_TIME", "#{apprCondtTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSntTrtOperCode() != null) {
            sql.VALUES("SNT_TRT_OPER_CODE", "#{sntTrtOperCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatOperateDate() != null) {
            sql.VALUES("TREAT_OPERATE_DATE", "#{treatOperateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTreatUnit() != null) {
            sql.VALUES("TREAT_UNIT", "#{treatUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatTime() != null) {
            sql.VALUES("TREAT_TIME", "#{treatTime,jdbcType=DECIMAL}");
        }
        
        if (record.getTreatTimeUnit() != null) {
            sql.VALUES("TREAT_TIME_UNIT", "#{treatTimeUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatTemper() != null) {
            sql.VALUES("TREAT_TEMPER", "#{treatTemper,jdbcType=DECIMAL}");
        }
        
        if (record.getMedicName() != null) {
            sql.VALUES("MEDIC_NAME", "#{medicName,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevTreatTm() != null) {
            sql.VALUES("PREV_TREAT_TM", "#{prevTreatTm,jdbcType=DECIMAL}");
        }
        
        if (record.getPreTreatTmUnit() != null) {
            sql.VALUES("PRE_TREAT_TM_UNIT", "#{preTreatTmUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getPrvntTreatTemp() != null) {
            sql.VALUES("PRVNT_TREAT_TEMP", "#{prvntTreatTemp,jdbcType=DECIMAL}");
        }
        
        if (record.getPrevMedicName() != null) {
            sql.VALUES("PREV_MEDIC_NAME", "#{prevMedicName,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatMedicDens() != null) {
            sql.VALUES("TREAT_MEDIC_DENS", "#{treatMedicDens,jdbcType=DECIMAL}");
        }
        
        if (record.getMedicConcen() != null) {
            sql.VALUES("MEDIC_CONCEN", "#{medicConcen,jdbcType=DECIMAL}");
        }
        
        if (record.getActualQty() != null) {
            sql.VALUES("ACTUAL_QTY", "#{actualQty,jdbcType=DECIMAL}");
        }
        
        if (record.getRealWeight() != null) {
            sql.VALUES("REAL_WEIGHT", "#{realWeight,jdbcType=DECIMAL}");
        }
        
        if (record.getActSmplNum() != null) {
            sql.VALUES("ACT_SMPL_NUM", "#{actSmplNum,jdbcType=DECIMAL}");
        }
        
        if (record.getSuggSmplNum() != null) {
            sql.VALUES("SUGG_SMPL_NUM", "#{suggSmplNum,jdbcType=DECIMAL}");
        }
        
        if (record.getInspQty() != null) {
            sql.VALUES("INSP_QTY", "#{inspQty,jdbcType=DECIMAL}");
        }
        
        if (record.getDeclWt() != null) {
            sql.VALUES("DECL_WT", "#{declWt,jdbcType=DECIMAL}");
        }
        
        if (record.getDeclGoodsValues() != null) {
            sql.VALUES("DECL_GOODS_VALUES", "#{declGoodsValues,jdbcType=DECIMAL}");
        }
        
        if (record.getDeclValuesUsd() != null) {
            sql.VALUES("DECL_VALUES_USD", "#{declValuesUsd,jdbcType=DECIMAL}");
        }
        
        if (record.getDeclValuesRmb() != null) {
            sql.VALUES("DECL_VALUES_RMB", "#{declValuesRmb,jdbcType=DECIMAL}");
        }
        
        if (record.getProduceDate() != null) {
            sql.VALUES("PRODUCE_DATE", "#{produceDate,jdbcType=VARCHAR}");
        }
        
        if (record.getExtDisquaCauseCode() != null) {
            sql.VALUES("EXT_DISQUA_CAUSE_CODE", "#{extDisquaCauseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtDisquaCauseDesc() != null) {
            sql.VALUES("EXT_DISQUA_CAUSE_DESC", "#{extDisquaCauseDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getExtDisquCauseCode() != null) {
            sql.VALUES("EXT_DISQU_CAUSE_CODE", "#{extDisquCauseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtDisquCauseDesc() != null) {
            sql.VALUES("EXT_DISQU_CAUSE_DESC", "#{extDisquCauseDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStandardNo() != null) {
            sql.VALUES("STANDARD_NO", "#{standardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDisDetailInfo() != null) {
            sql.VALUES("DIS_DETAIL_INFO", "#{disDetailInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRiskInfoLevelCode() != null) {
            sql.VALUES("RISK_INFO_LEVEL_CODE", "#{riskInfoLevelCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReportOrgCode() != null) {
            sql.VALUES("REPORT_ORG_CODE", "#{reportOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDisquaTypeCode() != null) {
            sql.VALUES("DISQUA_TYPE_CODE", "#{disquaTypeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getFalgArchive() != null) {
            sql.VALUES("FALG_ARCHIVE", "#{falgArchive,jdbcType=CHAR}");
        }
        
        if (record.getOperTime() != null) {
            sql.VALUES("OPER_TIME", "#{operTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContNo() != null) {
            sql.VALUES("CONT_NO", "#{contNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPreMeasBasisCode() != null) {
            sql.VALUES("PRE_MEAS_BASIS_CODE", "#{preMeasBasisCode,jdbcType=VARCHAR}");
        }
        
        if (record.getArchiveTime() != null) {
            sql.VALUES("ARCHIVE_TIME", "#{archiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInspResSpot() != null) {
            sql.VALUES("INSP_RES_SPOT", "#{inspResSpot,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarResSpot() != null) {
            sql.VALUES("QUAR_RES_SPOT", "#{quarResSpot,jdbcType=VARCHAR}");
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
        
        if (record.getIscheck() != null) {
            sql.VALUES("IsCheck", "#{ischeck,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }
}