package d1.domain;

import d1.domain.DM_C_HS_LEVEL;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DM_C_HS_LEVELMapper {
    @Insert({
        "insert into DM_C_HS_LEVEL (HSCODE_ID, HS_CODE, ",
        "HS_CNAME, HS_ENAME, ",
        "HS_LEVEL1_CODE, HS_LEVEL1_CNAME, ",
        "HS_LEVEL2_CODE, HS_LEVEL2_CNAME, ",
        "MONITOR_CONDITION, DANGER_FLAG, ",
        "ENTRY_IMPORTANCE_FLAG, EXIT_IMPORTANCE_FLAG, ",
        "ENTRY_STAPLE_FLAG, EXIT_STAPLE_FLAG, ",
        "ENTRY_INSP_FLAG, EXIT_INSP_FLAG, ",
        "ENTRY_LICENSE_FLAG, EXIT_LICENSE_FLAG, ",
        "RUBBISH_FLAG_CODE, GOODS_FLAG_CODE, ",
        "CIVIL_FLAG, STD_MEASURE_CODE, ",
        "MEASURE_TYPE_CODE, INSP_ITEM_CODES, ",
        "OPERATOR_CODE, OPERATE_DATE, ",
        "FEE_ITEM_CODES, LIMIT_CONDITION, ",
        "INSP_MONITOR_COND, GOODS_FLAG_CODE_2, ",
        "VALID_TERM, INSP_TERM, ",
        "INSP_CYC, MONITOR_COND_NEW, ",
        "VER_RCD, CHECK_FLAG, ",
        "CERT_CYC, AUTO_PASS_FLAG, ",
        "WASTE_OLD_CODE, IMPORT_CHECK_FLAG, ",
        "PACK_TYPE_CODE, ANTI_HS_CODE, ",
        "ROTTABLE, MODEL, ",
        "WOOD, FOOD, FOOD_FACILITY, ",
        "FEE_ITEM_CODES_NEW, OIL, ",
        "RADIO, DANGER_NEW, ",
        "TEXTILE, CANCEL_FLAG, ",
        "CHG_FLAG, SPECIFIC_FEE_FLAG, ",
        "OTHER_FLAG, FLAG, ",
        "BGDATE, ENDDATE, ",
        "HS_LEVEL3_CODE, HS_LEVEL3_CNAME, ",
        "HS_LEVEL4_CODE, HS_LEVEL4_CNAME, ",
        "HS_LEVEL5_CODE, HS_LEVEL5_CNAME, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ)",
        "values (#{hscodeId,jdbcType=VARCHAR}, #{hsCode,jdbcType=VARCHAR}, ",
        "#{hsCname,jdbcType=VARCHAR}, #{hsEname,jdbcType=VARCHAR}, ",
        "#{hsLevel1Code,jdbcType=VARCHAR}, #{hsLevel1Cname,jdbcType=VARCHAR}, ",
        "#{hsLevel2Code,jdbcType=VARCHAR}, #{hsLevel2Cname,jdbcType=VARCHAR}, ",
        "#{monitorCondition,jdbcType=VARCHAR}, #{dangerFlag,jdbcType=VARCHAR}, ",
        "#{entryImportanceFlag,jdbcType=VARCHAR}, #{exitImportanceFlag,jdbcType=VARCHAR}, ",
        "#{entryStapleFlag,jdbcType=VARCHAR}, #{exitStapleFlag,jdbcType=VARCHAR}, ",
        "#{entryInspFlag,jdbcType=VARCHAR}, #{exitInspFlag,jdbcType=VARCHAR}, ",
        "#{entryLicenseFlag,jdbcType=VARCHAR}, #{exitLicenseFlag,jdbcType=VARCHAR}, ",
        "#{rubbishFlagCode,jdbcType=VARCHAR}, #{goodsFlagCode,jdbcType=VARCHAR}, ",
        "#{civilFlag,jdbcType=VARCHAR}, #{stdMeasureCode,jdbcType=VARCHAR}, ",
        "#{measureTypeCode,jdbcType=VARCHAR}, #{inspItemCodes,jdbcType=VARCHAR}, ",
        "#{operatorCode,jdbcType=VARCHAR}, #{operateDate,jdbcType=TIMESTAMP}, ",
        "#{feeItemCodes,jdbcType=VARCHAR}, #{limitCondition,jdbcType=VARCHAR}, ",
        "#{inspMonitorCond,jdbcType=VARCHAR}, #{goodsFlagCode2,jdbcType=VARCHAR}, ",
        "#{validTerm,jdbcType=DECIMAL}, #{inspTerm,jdbcType=DECIMAL}, ",
        "#{inspCyc,jdbcType=DECIMAL}, #{monitorCondNew,jdbcType=VARCHAR}, ",
        "#{verRcd,jdbcType=VARCHAR}, #{checkFlag,jdbcType=VARCHAR}, ",
        "#{certCyc,jdbcType=DECIMAL}, #{autoPassFlag,jdbcType=VARCHAR}, ",
        "#{wasteOldCode,jdbcType=VARCHAR}, #{importCheckFlag,jdbcType=VARCHAR}, ",
        "#{packTypeCode,jdbcType=VARCHAR}, #{antiHsCode,jdbcType=VARCHAR}, ",
        "#{rottable,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, ",
        "#{wood,jdbcType=VARCHAR}, #{food,jdbcType=VARCHAR}, #{foodFacility,jdbcType=VARCHAR}, ",
        "#{feeItemCodesNew,jdbcType=VARCHAR}, #{oil,jdbcType=VARCHAR}, ",
        "#{radio,jdbcType=VARCHAR}, #{dangerNew,jdbcType=VARCHAR}, ",
        "#{textile,jdbcType=VARCHAR}, #{cancelFlag,jdbcType=VARCHAR}, ",
        "#{chgFlag,jdbcType=VARCHAR}, #{specificFeeFlag,jdbcType=VARCHAR}, ",
        "#{otherFlag,jdbcType=VARCHAR}, #{flag,jdbcType=VARCHAR}, ",
        "#{bgdate,jdbcType=TIMESTAMP}, #{enddate,jdbcType=TIMESTAMP}, ",
        "#{hsLevel3Code,jdbcType=VARCHAR}, #{hsLevel3Cname,jdbcType=VARCHAR}, ",
        "#{hsLevel4Code,jdbcType=VARCHAR}, #{hsLevel4Cname,jdbcType=VARCHAR}, ",
        "#{hsLevel5Code,jdbcType=VARCHAR}, #{hsLevel5Cname,jdbcType=VARCHAR}, ",
        "#{transTypeTj,jdbcType=VARCHAR}, #{operTimeTj,jdbcType=TIMESTAMP})"
    })
    int insert(DM_C_HS_LEVEL record);

    @InsertProvider(type=DM_C_HS_LEVELSqlProvider.class, method="insertSelective")
    int insertSelective(DM_C_HS_LEVEL record);

    @Select({"SELECT HS_CODE,HS_LEVEL1_CODE,HS_LEVEL2_CODE FROM DM_C_HS_LEVEL WHERE HS_CODE=#{HS_CODE,jdbcType=VARCHAR}"})
    @Results({
            @Result(column ="HS_CODE",property = "hsCode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="HS_LEVEL1_CODE",property = "hsLevel1Code",jdbcType = JdbcType.VARCHAR),
            @Result(column ="HS_LEVEL2_CODE",property = "hsLevel2Code",jdbcType = JdbcType.VARCHAR)
    })
    DM_C_HS_LEVEL dm_C_HS_LEVELData(@Param("HS_CODE") String HS_CODE);
}