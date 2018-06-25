package d1.domain;

import d1.domain.DM_C_COUNTRY;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DM_C_COUNTRYMapper {
    @Insert({
        "insert into DM_C_COUNTRY (CCM_UUID, ITEMCODE, ",
        "ALIAS2, CNAME, ENAME, ",
        "FLAG, OLDCODE, CLDCNAME, ",
        "LASTUPDATE, VERSION, ",
        "FMK_ARCHIVE_FLAG, ALIAS3, ",
        "CIQ_CODE, CONTINENT_CODE, ",
        "PARENTCODE, OTHER_FLAG, ",
        "STATECNAME, INDEXID, ",
        "INSERT_DATE, DATASOURCE, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ, ",
        "STATEENAME)",
        "values (#{ccmUuid,jdbcType=VARCHAR}, #{itemcode,jdbcType=VARCHAR}, ",
        "#{alias2,jdbcType=VARCHAR}, #{cname,jdbcType=VARCHAR}, #{ename,jdbcType=VARCHAR}, ",
        "#{flag,jdbcType=CHAR}, #{oldcode,jdbcType=VARCHAR}, #{cldcname,jdbcType=VARCHAR}, ",
        "#{lastupdate,jdbcType=TIMESTAMP}, #{version,jdbcType=VARCHAR}, ",
        "#{fmkArchiveFlag,jdbcType=CHAR}, #{alias3,jdbcType=VARCHAR}, ",
        "#{ciqCode,jdbcType=VARCHAR}, #{continentCode,jdbcType=VARCHAR}, ",
        "#{parentcode,jdbcType=VARCHAR}, #{otherFlag,jdbcType=VARCHAR}, ",
        "#{statecname,jdbcType=VARCHAR}, #{indexid,jdbcType=VARCHAR}, ",
        "#{insertDate,jdbcType=TIMESTAMP}, #{datasource,jdbcType=VARCHAR}, ",
        "#{transTypeTj,jdbcType=VARCHAR}, #{operTimeTj,jdbcType=TIMESTAMP}, ",
        "#{stateename,jdbcType=VARCHAR})"
    })
    int insert(DM_C_COUNTRY record);

    @InsertProvider(type=DM_C_COUNTRYSqlProvider.class, method="insertSelective")
    int insertSelective(DM_C_COUNTRY record);

    @Select("SELECT * FROM DM_C_COUNTRY WHERE ITEMCODE=#{ITEMCODE,jdbcType=VARCHAR} ORDER BY INSERT_DATE DESC")
    @Results({
            @Result(column ="CCM_UUID" ,property = "ccmUuid",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ITEM_CODE" ,property = "itemcode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ALIAS2" ,property = "alias2",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CNAME" ,property = "cname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ENAME" ,property = "ename",jdbcType = JdbcType.VARCHAR),
            @Result(column ="FLAG" ,property = "flag",jdbcType = JdbcType.VARCHAR),
            @Result(column ="OLDCODE" ,property = "oldcode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CLDNAME" ,property = "cldcname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="LASTUPDATE" ,property = "lastupdate",jdbcType = JdbcType.TIMESTAMP),
            @Result(column ="FMARCHIVEFLAG" ,property = "fmkArchiveFlag",jdbcType = JdbcType.VARCHAR),
            @Result(column ="VERSION" ,property = "version",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ALIAS3" ,property = "alias3",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CIQCODE" ,property = "ciqCode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="CONTINENTCODE" ,property = "continentCode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="PARENTCODE" ,property = "parentcode",jdbcType = JdbcType.VARCHAR),
            @Result(column ="OTHERFLAG" ,property = "otherFlag",jdbcType = JdbcType.VARCHAR),
            @Result(column ="STATECNAME" ,property = "statecname",jdbcType = JdbcType.VARCHAR),
            @Result(column ="INDEXID" ,property = "indexid",jdbcType = JdbcType.VARCHAR),
            @Result(column ="INSERTDATE" ,property = "insertDate",jdbcType = JdbcType.VARCHAR),
            @Result(column ="DATASOURCE" ,property = "datasource",jdbcType = JdbcType.VARCHAR),
            @Result(column ="TRANSTYPETJ" ,property = "transTypeTj",jdbcType = JdbcType.VARCHAR),
            @Result(column ="OPERTIMETJ" ,property = "operTimeTj",jdbcType = JdbcType.TIMESTAMP),
            @Result(column ="STATEENAME" ,property = "stateename",jdbcType = JdbcType.VARCHAR)
    })
    List<DM_C_COUNTRY> getListDM_C_COUNTRYData(@Param("ITEMCODE") String ITEMCODE);
}