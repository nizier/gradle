package d1.domain;

import d1.domain.DM_C_Z_BBD_HS_CODE;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DM_C_Z_BBD_HS_CODEMapper {
    @Insert({
        "insert into DM_C_Z_BBD_HS_CODE (HS_CODE, HS_CNAME, ",
        "HS_ENAME, MONITOR_CONDITION, ",
        "DANGER_FLAG, ENTRY_IMPORTANCE_FLAG, ",
        "EXIT_IMPORTANCE_FLAG, ENTRY_STAPLE_FLAG, ",
        "EXIT_STAPLE_FLAG, ENTRY_INSP_FLAG, ",
        "EXIT_INSP_FLAG, ENTRY_LICENSE_FLAG, ",
        "EXIT_LICENSE_FLAG, RUBBISH_FLAG_CODE, ",
        "GOODS_FLAG_CODE, CIVIL_FLAG, ",
        "STD_MEASURE_CODE, MEASURE_TYPE_CODE, ",
        "INSP_ITEM_CODES, OPERATOR_CODE, ",
        "OPERATE_DATE, FEE_ITEM_CODES, ",
        "LIMIT_CONDITION, INSP_MONITOR_COND, ",
        "GOODS_FLAG_CODE_2, VALID_TERM, ",
        "INSP_TERM, INSP_CYC, ",
        "MONITOR_COND_NEW, VER_RCD, ",
        "CHECK_FLAG, CERT_CYC, ",
        "AUTO_PASS_FLAG, WASTE_OLD_CODE, ",
        "IMPORT_CHECK_FLAG, PACK_TYPE_CODE, ",
        "ANTI_HS_CODE, ROTTABLE, ",
        "MODEL, WOOD, FOOD, ",
        "FOOD_FACILITY, FEE_ITEM_CODES_NEW, ",
        "OIL, RADIO, DANGER_NEW, ",
        "TEXTILE, CANCEL_FLAG, ",
        "CHG_FLAG, SPECIFIC_FEE_FLAG, ",
        "OTHER_FLAG, FLAG, CIQ_MEASURE_TYPE, ",
        "CIQ_STD_MEASURE, FEE_ITEM_CODES_2013, ",
        "INSERT_DATE, DATASOURCE, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ, ",
        "CON_HS_CODE)",
        "values (#{hsCode,jdbcType=VARCHAR}, #{hsCname,jdbcType=VARCHAR}, ",
        "#{hsEname,jdbcType=VARCHAR}, #{monitorCondition,jdbcType=VARCHAR}, ",
        "#{dangerFlag,jdbcType=VARCHAR}, #{entryImportanceFlag,jdbcType=VARCHAR}, ",
        "#{exitImportanceFlag,jdbcType=VARCHAR}, #{entryStapleFlag,jdbcType=VARCHAR}, ",
        "#{exitStapleFlag,jdbcType=VARCHAR}, #{entryInspFlag,jdbcType=VARCHAR}, ",
        "#{exitInspFlag,jdbcType=VARCHAR}, #{entryLicenseFlag,jdbcType=VARCHAR}, ",
        "#{exitLicenseFlag,jdbcType=VARCHAR}, #{rubbishFlagCode,jdbcType=VARCHAR}, ",
        "#{goodsFlagCode,jdbcType=VARCHAR}, #{civilFlag,jdbcType=VARCHAR}, ",
        "#{stdMeasureCode,jdbcType=VARCHAR}, #{measureTypeCode,jdbcType=VARCHAR}, ",
        "#{inspItemCodes,jdbcType=VARCHAR}, #{operatorCode,jdbcType=VARCHAR}, ",
        "#{operateDate,jdbcType=TIMESTAMP}, #{feeItemCodes,jdbcType=VARCHAR}, ",
        "#{limitCondition,jdbcType=VARCHAR}, #{inspMonitorCond,jdbcType=VARCHAR}, ",
        "#{goodsFlagCode2,jdbcType=VARCHAR}, #{validTerm,jdbcType=DECIMAL}, ",
        "#{inspTerm,jdbcType=DECIMAL}, #{inspCyc,jdbcType=DECIMAL}, ",
        "#{monitorCondNew,jdbcType=VARCHAR}, #{verRcd,jdbcType=VARCHAR}, ",
        "#{checkFlag,jdbcType=VARCHAR}, #{certCyc,jdbcType=DECIMAL}, ",
        "#{autoPassFlag,jdbcType=VARCHAR}, #{wasteOldCode,jdbcType=VARCHAR}, ",
        "#{importCheckFlag,jdbcType=VARCHAR}, #{packTypeCode,jdbcType=VARCHAR}, ",
        "#{antiHsCode,jdbcType=VARCHAR}, #{rottable,jdbcType=VARCHAR}, ",
        "#{model,jdbcType=VARCHAR}, #{wood,jdbcType=VARCHAR}, #{food,jdbcType=VARCHAR}, ",
        "#{foodFacility,jdbcType=VARCHAR}, #{feeItemCodesNew,jdbcType=VARCHAR}, ",
        "#{oil,jdbcType=VARCHAR}, #{radio,jdbcType=VARCHAR}, #{dangerNew,jdbcType=VARCHAR}, ",
        "#{textile,jdbcType=VARCHAR}, #{cancelFlag,jdbcType=VARCHAR}, ",
        "#{chgFlag,jdbcType=VARCHAR}, #{specificFeeFlag,jdbcType=VARCHAR}, ",
        "#{otherFlag,jdbcType=VARCHAR}, #{flag,jdbcType=CHAR}, #{ciqMeasureType,jdbcType=VARCHAR}, ",
        "#{ciqStdMeasure,jdbcType=VARCHAR}, #{feeItemCodes2013,jdbcType=VARCHAR}, ",
        "#{insertDate,jdbcType=TIMESTAMP}, #{datasource,jdbcType=VARCHAR}, ",
        "#{transTypeTj,jdbcType=VARCHAR}, #{operTimeTj,jdbcType=TIMESTAMP}, ",
        "#{conHsCode,jdbcType=VARCHAR})"
    })
    int insert(DM_C_Z_BBD_HS_CODE record);

    @InsertProvider(type=DM_C_Z_BBD_HS_CODESqlProvider.class, method="insertSelective")
    int insertSelective(DM_C_Z_BBD_HS_CODE record);

    @Select({"SELECT HS_CODE,CIQ_STD_MEASURE,STD_MEASURE_CODE FROM DM_C_Z_BBD_HS_CODE WHERE HS_CODE=#{prodHsCode,jdbcType=VARCHAR}"})
    @Results({
            @Result(column ="HS_CODE",property = "hsCode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CIQ_STD_MEASURE",property = "ciqStdMeasure",jdbcType = JdbcType.VARCHAR),
            @Result(column ="STD_MEASURE_CODE",property = "stdMeasureCode",jdbcType = JdbcType.VARCHAR)
    })
    DM_C_Z_BBD_HS_CODE DM_C_Z_BBD_HS_CODE(@Param("prodHsCode") String prodHsCode);
}