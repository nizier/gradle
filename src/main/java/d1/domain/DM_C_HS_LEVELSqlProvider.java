package d1.domain;

import d1.domain.DM_C_HS_LEVEL;
import org.apache.ibatis.jdbc.SQL;

public class DM_C_HS_LEVELSqlProvider {

    public String insertSelective(DM_C_HS_LEVEL record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DM_C_HS_LEVEL");
        
        if (record.getHscodeId() != null) {
            sql.VALUES("HSCODE_ID", "#{hscodeId,jdbcType=VARCHAR}");
        }
        
        if (record.getHsCode() != null) {
            sql.VALUES("HS_CODE", "#{hsCode,jdbcType=VARCHAR}");
        }
        
        if (record.getHsCname() != null) {
            sql.VALUES("HS_CNAME", "#{hsCname,jdbcType=VARCHAR}");
        }
        
        if (record.getHsEname() != null) {
            sql.VALUES("HS_ENAME", "#{hsEname,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel1Code() != null) {
            sql.VALUES("HS_LEVEL1_CODE", "#{hsLevel1Code,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel1Cname() != null) {
            sql.VALUES("HS_LEVEL1_CNAME", "#{hsLevel1Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel2Code() != null) {
            sql.VALUES("HS_LEVEL2_CODE", "#{hsLevel2Code,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel2Cname() != null) {
            sql.VALUES("HS_LEVEL2_CNAME", "#{hsLevel2Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getMonitorCondition() != null) {
            sql.VALUES("MONITOR_CONDITION", "#{monitorCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getDangerFlag() != null) {
            sql.VALUES("DANGER_FLAG", "#{dangerFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryImportanceFlag() != null) {
            sql.VALUES("ENTRY_IMPORTANCE_FLAG", "#{entryImportanceFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getExitImportanceFlag() != null) {
            sql.VALUES("EXIT_IMPORTANCE_FLAG", "#{exitImportanceFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryStapleFlag() != null) {
            sql.VALUES("ENTRY_STAPLE_FLAG", "#{entryStapleFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getExitStapleFlag() != null) {
            sql.VALUES("EXIT_STAPLE_FLAG", "#{exitStapleFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryInspFlag() != null) {
            sql.VALUES("ENTRY_INSP_FLAG", "#{entryInspFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getExitInspFlag() != null) {
            sql.VALUES("EXIT_INSP_FLAG", "#{exitInspFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryLicenseFlag() != null) {
            sql.VALUES("ENTRY_LICENSE_FLAG", "#{entryLicenseFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getExitLicenseFlag() != null) {
            sql.VALUES("EXIT_LICENSE_FLAG", "#{exitLicenseFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getRubbishFlagCode() != null) {
            sql.VALUES("RUBBISH_FLAG_CODE", "#{rubbishFlagCode,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsFlagCode() != null) {
            sql.VALUES("GOODS_FLAG_CODE", "#{goodsFlagCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCivilFlag() != null) {
            sql.VALUES("CIVIL_FLAG", "#{civilFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getStdMeasureCode() != null) {
            sql.VALUES("STD_MEASURE_CODE", "#{stdMeasureCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMeasureTypeCode() != null) {
            sql.VALUES("MEASURE_TYPE_CODE", "#{measureTypeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspItemCodes() != null) {
            sql.VALUES("INSP_ITEM_CODES", "#{inspItemCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorCode() != null) {
            sql.VALUES("OPERATOR_CODE", "#{operatorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOperateDate() != null) {
            sql.VALUES("OPERATE_DATE", "#{operateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFeeItemCodes() != null) {
            sql.VALUES("FEE_ITEM_CODES", "#{feeItemCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getLimitCondition() != null) {
            sql.VALUES("LIMIT_CONDITION", "#{limitCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getInspMonitorCond() != null) {
            sql.VALUES("INSP_MONITOR_COND", "#{inspMonitorCond,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsFlagCode2() != null) {
            sql.VALUES("GOODS_FLAG_CODE_2", "#{goodsFlagCode2,jdbcType=VARCHAR}");
        }
        
        if (record.getValidTerm() != null) {
            sql.VALUES("VALID_TERM", "#{validTerm,jdbcType=DECIMAL}");
        }
        
        if (record.getInspTerm() != null) {
            sql.VALUES("INSP_TERM", "#{inspTerm,jdbcType=DECIMAL}");
        }
        
        if (record.getInspCyc() != null) {
            sql.VALUES("INSP_CYC", "#{inspCyc,jdbcType=DECIMAL}");
        }
        
        if (record.getMonitorCondNew() != null) {
            sql.VALUES("MONITOR_COND_NEW", "#{monitorCondNew,jdbcType=VARCHAR}");
        }
        
        if (record.getVerRcd() != null) {
            sql.VALUES("VER_RCD", "#{verRcd,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckFlag() != null) {
            sql.VALUES("CHECK_FLAG", "#{checkFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getCertCyc() != null) {
            sql.VALUES("CERT_CYC", "#{certCyc,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoPassFlag() != null) {
            sql.VALUES("AUTO_PASS_FLAG", "#{autoPassFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getWasteOldCode() != null) {
            sql.VALUES("WASTE_OLD_CODE", "#{wasteOldCode,jdbcType=VARCHAR}");
        }
        
        if (record.getImportCheckFlag() != null) {
            sql.VALUES("IMPORT_CHECK_FLAG", "#{importCheckFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getPackTypeCode() != null) {
            sql.VALUES("PACK_TYPE_CODE", "#{packTypeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAntiHsCode() != null) {
            sql.VALUES("ANTI_HS_CODE", "#{antiHsCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRottable() != null) {
            sql.VALUES("ROTTABLE", "#{rottable,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.VALUES("MODEL", "#{model,jdbcType=VARCHAR}");
        }
        
        if (record.getWood() != null) {
            sql.VALUES("WOOD", "#{wood,jdbcType=VARCHAR}");
        }
        
        if (record.getFood() != null) {
            sql.VALUES("FOOD", "#{food,jdbcType=VARCHAR}");
        }
        
        if (record.getFoodFacility() != null) {
            sql.VALUES("FOOD_FACILITY", "#{foodFacility,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeItemCodesNew() != null) {
            sql.VALUES("FEE_ITEM_CODES_NEW", "#{feeItemCodesNew,jdbcType=VARCHAR}");
        }
        
        if (record.getOil() != null) {
            sql.VALUES("OIL", "#{oil,jdbcType=VARCHAR}");
        }
        
        if (record.getRadio() != null) {
            sql.VALUES("RADIO", "#{radio,jdbcType=VARCHAR}");
        }
        
        if (record.getDangerNew() != null) {
            sql.VALUES("DANGER_NEW", "#{dangerNew,jdbcType=VARCHAR}");
        }
        
        if (record.getTextile() != null) {
            sql.VALUES("TEXTILE", "#{textile,jdbcType=VARCHAR}");
        }
        
        if (record.getCancelFlag() != null) {
            sql.VALUES("CANCEL_FLAG", "#{cancelFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getChgFlag() != null) {
            sql.VALUES("CHG_FLAG", "#{chgFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecificFeeFlag() != null) {
            sql.VALUES("SPECIFIC_FEE_FLAG", "#{specificFeeFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherFlag() != null) {
            sql.VALUES("OTHER_FLAG", "#{otherFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            sql.VALUES("FLAG", "#{flag,jdbcType=VARCHAR}");
        }
        
        if (record.getBgdate() != null) {
            sql.VALUES("BGDATE", "#{bgdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnddate() != null) {
            sql.VALUES("ENDDATE", "#{enddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHsLevel3Code() != null) {
            sql.VALUES("HS_LEVEL3_CODE", "#{hsLevel3Code,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel3Cname() != null) {
            sql.VALUES("HS_LEVEL3_CNAME", "#{hsLevel3Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel4Code() != null) {
            sql.VALUES("HS_LEVEL4_CODE", "#{hsLevel4Code,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel4Cname() != null) {
            sql.VALUES("HS_LEVEL4_CNAME", "#{hsLevel4Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel5Code() != null) {
            sql.VALUES("HS_LEVEL5_CODE", "#{hsLevel5Code,jdbcType=VARCHAR}");
        }
        
        if (record.getHsLevel5Cname() != null) {
            sql.VALUES("HS_LEVEL5_CNAME", "#{hsLevel5Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getTransTypeTj() != null) {
            sql.VALUES("TRANS_TYPE_TJ", "#{transTypeTj,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTimeTj() != null) {
            sql.VALUES("OPER_TIME_TJ", "#{operTimeTj,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }
}