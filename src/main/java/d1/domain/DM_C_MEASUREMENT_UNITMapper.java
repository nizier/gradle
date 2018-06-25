package d1.domain;

import d1.domain.DM_C_MEASUREMENT_UNIT;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DM_C_MEASUREMENT_UNITMapper {
    @Insert({
        "insert into DM_C_MEASUREMENT_UNIT (MEASUREMENT_ID, CODE, ",
        "CNAME, ENAME, SEQ_NO, ",
        "ALIAS1, ALIAS2, ",
        "ALIAS3, FLAG, LASTUPDATE, ",
        "VERSION, FMK_ARCHIVE_FLAG, ",
        "OTHER_FLAG, BGDATE, ",
        "ENDDATE, TRANS_TYPE_TJ, ",
        "OPER_TIME_TJ)",
        "values (#{measurementId,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{cname,jdbcType=VARCHAR}, #{ename,jdbcType=VARCHAR}, #{seqNo,jdbcType=VARCHAR}, ",
        "#{alias1,jdbcType=VARCHAR}, #{alias2,jdbcType=VARCHAR}, ",
        "#{alias3,jdbcType=VARCHAR}, #{flag,jdbcType=CHAR}, #{lastupdate,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=VARCHAR}, #{fmkArchiveFlag,jdbcType=VARCHAR}, ",
        "#{otherFlag,jdbcType=VARCHAR}, #{bgdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP}, #{transTypeTj,jdbcType=VARCHAR}, ",
        "#{operTimeTj,jdbcType=TIMESTAMP})"
    })
    int insert(DM_C_MEASUREMENT_UNIT record);

    @InsertProvider(type=DM_C_MEASUREMENT_UNITSqlProvider.class, method="insertSelective")
    int insertSelective(DM_C_MEASUREMENT_UNIT record);

    @Select({"SELECT CODE,CNAME,ALIAS1 FROM DM_C_MEASUREMENT_UNIT WHERE CODE=#{Code,jdbcType=VARCHAR} AND ROWNUM=1 "})
    @Results({
            @Result(column ="CODE",property = "code",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CNAME",property = "cname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ALIAS1",property = "alias1",jdbcType = JdbcType.VARCHAR)
    })
    DM_C_MEASUREMENT_UNIT dm_C_MEASUREMENT_UNITData(@Param("Code") String Code);
}