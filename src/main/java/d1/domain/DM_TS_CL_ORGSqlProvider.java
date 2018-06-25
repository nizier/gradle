package d1.domain;

import d1.domain.DM_TS_CL_ORG;
import org.apache.ibatis.jdbc.SQL;

public class DM_TS_CL_ORGSqlProvider {

    public String insertSelective(DM_TS_CL_ORG record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DM_TS_CL_ORG");
        
        if (record.getLevel1Code() != null) {
            sql.VALUES("LEVEL1_CODE", "#{level1Code,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel1Name() != null) {
            sql.VALUES("LEVEL1_NAME", "#{level1Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel2Code() != null) {
            sql.VALUES("LEVEL2_CODE", "#{level2Code,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel2Name() != null) {
            sql.VALUES("LEVEL2_NAME", "#{level2Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel3Code() != null) {
            sql.VALUES("LEVEL3_CODE", "#{level3Code,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel3Name() != null) {
            sql.VALUES("LEVEL3_NAME", "#{level3Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel4Code() != null) {
            sql.VALUES("LEVEL4_CODE", "#{level4Code,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel4Name() != null) {
            sql.VALUES("LEVEL4_NAME", "#{level4Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel5Code() != null) {
            sql.VALUES("LEVEL5_CODE", "#{level5Code,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel5Name() != null) {
            sql.VALUES("LEVEL5_NAME", "#{level5Name,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.VALUES("ORG_CODE", "#{orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgName() != null) {
            sql.VALUES("ORG_NAME", "#{orgName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    //根据部门编码、等级，查找组织机构
    public String getOrgCodeByDeptNumber(String abbReviation,String deptNumber)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT * FROM DM_TS_CL_ORG WHERE 1=1 ");
        switch (abbReviation)
        {
            case "1":
                sb.append("AND LEVEL1_CODE="+deptNumber);
                break;
            case "2":
                sb.append("AND LEVEL2_CODE="+deptNumber);
                break;
            case "3":
                sb.append("AND LEVEL3_CODE="+deptNumber);
                break;
            case "4":
                sb.append("AND LEVEL4_CODE="+deptNumber);
                break;
            case "5":
                sb.append("AND LEVEL5_CODE="+deptNumber);
                break;
            default:break;
        }

        return sb.toString();
    }
}