package d1.domain;

import d1.domain.DM_C_CHINA_DISTRIC_LEVEL;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DM_C_CHINA_DISTRIC_LEVELMapper {
    @Insert({
        "insert into DM_C_CHINA_DISTRIC_LEVEL (ITEMCODE, CNAME, ",
        "CLASSIFY_CODE, FLAG, ",
        "VERSION, LEVEL1, ",
        "LEVEL2, LEVEL3, ",
        "L1_CNAME, L2_CNAME, ",
        "L3_CNAME, INSERT_DATE, ",
        "DATASOURCE, ECIQ_UUID, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ)",
        "values (#{itemcode,jdbcType=VARCHAR}, #{cname,jdbcType=VARCHAR}, ",
        "#{classifyCode,jdbcType=VARCHAR}, #{flag,jdbcType=CHAR}, ",
        "#{version,jdbcType=VARCHAR}, #{level1,jdbcType=VARCHAR}, ",
        "#{level2,jdbcType=VARCHAR}, #{level3,jdbcType=VARCHAR}, ",
        "#{l1Cname,jdbcType=VARCHAR}, #{l2Cname,jdbcType=VARCHAR}, ",
        "#{l3Cname,jdbcType=VARCHAR}, #{insertDate,jdbcType=TIMESTAMP}, ",
        "#{datasource,jdbcType=VARCHAR}, #{eciqUuid,jdbcType=VARCHAR}, ",
        "#{transTypeTj,jdbcType=VARCHAR}, #{operTimeTj,jdbcType=TIMESTAMP})"
    })
    int insert(DM_C_CHINA_DISTRIC_LEVEL record);

    @InsertProvider(type=DM_C_CHINA_DISTRIC_LEVELSqlProvider.class, method="insertSelective")
    int insertSelective(DM_C_CHINA_DISTRIC_LEVEL record);

    @Select("SELECT * FROM DM_C_CHINA_DISTRIC_LEVEL  WHERE ITEMCODE=#{ITEMCODE,jdbcType=VARCHAR} ORDER BY INSERT_DATE DESC")
    @Results({
            @Result(column ="ITEMCODE" ,property = "itemcode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CNAME" ,property = "cname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CLASSIFY_CODE" ,property = "classifyCode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="FLAG" ,property = "flag",jdbcType = JdbcType.VARCHAR),
            @Result(column ="VERSION" ,property = "version",jdbcType = JdbcType.VARCHAR),
            @Result(column ="LEVEL1" ,property = "level1",jdbcType = JdbcType.VARCHAR),
            @Result(column ="LEVEL2" ,property = "level2",jdbcType = JdbcType.VARCHAR),
            @Result(column ="LEVEL3" ,property = "level3",jdbcType = JdbcType.TIMESTAMP),
            @Result(column ="L1_CNAME" ,property = "l1Cname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="L2_CNAME" ,property = "l2Cname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="L3_CNAME" ,property = "l3Cname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="INSERT_DATE" ,property = "insertDate",jdbcType = JdbcType.TIMESTAMP),
            @Result(column ="DATASOURCE" ,property = "datasource",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ECIQ_UUID" ,property = "eciqUuid",jdbcType = JdbcType.VARCHAR),
            @Result(column ="TRANS_TYPE_TJ" ,property = "transTypeTj",jdbcType = JdbcType.VARCHAR),
            @Result(column ="OPER_TIME_TJ" ,property = "operTimeTj",jdbcType = JdbcType.TIMESTAMP)
    })
    List<DM_C_CHINA_DISTRIC_LEVEL> getListDM_C_CHINA_DISTRIC_LEVELData(@Param("ITEMCODE") String ITEMCODE);
}