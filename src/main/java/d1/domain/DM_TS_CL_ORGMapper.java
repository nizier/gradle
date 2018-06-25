package d1.domain;

import d1.domain.DM_TS_CL_ORG;
import d1.domain.vm.User_Res_Vm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DM_TS_CL_ORGMapper {
    @Insert({
        "insert into DM_TS_CL_ORG (LEVEL1_CODE, LEVEL1_NAME, ",
        "LEVEL2_CODE, LEVEL2_NAME, ",
        "LEVEL3_CODE, LEVEL3_NAME, ",
        "LEVEL4_CODE, LEVEL4_NAME, ",
        "LEVEL5_CODE, LEVEL5_NAME, ",
        "ORG_CODE, ORG_NAME)",
        "values (#{level1Code,jdbcType=VARCHAR}, #{level1Name,jdbcType=VARCHAR}, ",
        "#{level2Code,jdbcType=VARCHAR}, #{level2Name,jdbcType=VARCHAR}, ",
        "#{level3Code,jdbcType=VARCHAR}, #{level3Name,jdbcType=VARCHAR}, ",
        "#{level4Code,jdbcType=VARCHAR}, #{level4Name,jdbcType=VARCHAR}, ",
        "#{level5Code,jdbcType=VARCHAR}, #{level5Name,jdbcType=VARCHAR}, ",
        "#{orgCode,jdbcType=VARCHAR}, #{orgName,jdbcType=VARCHAR})"
    })
    int insert(DM_TS_CL_ORG record);

    @InsertProvider(type=DM_TS_CL_ORGSqlProvider.class, method="insertSelective")
    int insertSelective(DM_TS_CL_ORG record);

    @Select("SELECT * FROM DM_TS_CL_ORG WHERE ORG_CODE=#{OrgCode,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "LEVEL1_CODE",property = "level1Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL1_NAME",property = "level1Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL2_CODE",property = "level2Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL2_NAME",property = "level2Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL3_CODE",property = "level3Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL3_NAME",property = "level3Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL4_CODE",property = "level4Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL4_NAME",property = "level4Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL5_CODE",property = "level5Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL5_NAME",property = "level5Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "ORG_CODE",property = "orgCode",jdbcType= JdbcType.VARCHAR),
            @Result(column = "ORG_NAME",property = "orgName",jdbcType= JdbcType.VARCHAR)
    })
    List<DM_TS_CL_ORG> getOrgNameByOrgCode(@Param("OrgCode")String OrgCode);

    //根据当前用户ID,查询用户所属的部门信息
    @Select("SELECT SYS_FLOW_USER.USERID,SYS_FLOW_USER.USER_NM,\n" +
            "SYS_FLOW_DEPT.ABBREVIATION,SYS_FLOW_DEPT.DEPTNUMBER,SYS_FLOW_DEPT.DEPTNAME \n" +
            "FROM SYS_FLOW_USER\n" +
            "INNER JOIN SYS_USER_DPRB  ON SYS_FLOW_USER.USERID=SYS_USER_DPRB.USERID\n" +
            "LEFT JOIN  SYS_FLOW_DEPT ON SYS_FLOW_DEPT.DEPTID=SYS_USER_DPRB.DEPTID\n"+
            "WHERE SYS_FLOW_USER.USERID=#{UserId,jdbcType=VARCHAR}")
    @Results({
            @Result(column ="USERID" ,property = "userId",jdbcType = JdbcType.VARCHAR),
            @Result(column ="USER_NM" ,property = "userName",jdbcType = JdbcType.VARCHAR),
            @Result(column ="DEPTNUMBER" ,property = "deptNumber",jdbcType = JdbcType.VARCHAR),
            @Result(column ="DEPTNAME" ,property = "deptName",jdbcType = JdbcType.VARCHAR),
            @Result(column ="ABBREVIATION" ,property = "abbReviation",jdbcType = JdbcType.VARCHAR)
    })
    User_Res_Vm getUserInfoByUserId (@Param("UserId")String UserId);

    //根据部门编码，查找组织机构
    @SelectProvider(type = DM_TS_CL_ORGSqlProvider.class, method = "getOrgCodeByDeptNumber")
    @Results({
            @Result(column = "LEVEL1_CODE",property = "level1Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL1_NAME",property = "level1Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL2_CODE",property = "level2Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL2_NAME",property = "level2Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL3_CODE",property = "level3Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL3_NAME",property = "level3Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL4_CODE",property = "level4Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL4_NAME",property = "level4Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL5_CODE",property = "level5Code",jdbcType= JdbcType.VARCHAR),
            @Result(column = "LEVEL5_NAME",property = "level5Name",jdbcType= JdbcType.VARCHAR),
            @Result(column = "ORG_CODE",property = "orgCode",jdbcType= JdbcType.VARCHAR),
            @Result(column = "ORG_NAME",property = "orgName",jdbcType= JdbcType.VARCHAR)
    })
    List<DM_TS_CL_ORG> getOrgCodeByDeptNumber(String abbReviation,String deptNumber);
}