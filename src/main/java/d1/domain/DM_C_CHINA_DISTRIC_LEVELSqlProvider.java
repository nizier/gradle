package d1.domain;

import d1.domain.DM_C_CHINA_DISTRIC_LEVEL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

@Component
@Mapper
public class DM_C_CHINA_DISTRIC_LEVELSqlProvider {

    public String insertSelective(DM_C_CHINA_DISTRIC_LEVEL record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DM_C_CHINA_DISTRIC_LEVEL");
        
        if (record.getItemcode() != null) {
            sql.VALUES("ITEMCODE", "#{itemcode,jdbcType=VARCHAR}");
        }
        
        if (record.getCname() != null) {
            sql.VALUES("CNAME", "#{cname,jdbcType=VARCHAR}");
        }
        
        if (record.getClassifyCode() != null) {
            sql.VALUES("CLASSIFY_CODE", "#{classifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            sql.VALUES("FLAG", "#{flag,jdbcType=CHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel1() != null) {
            sql.VALUES("LEVEL1", "#{level1,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel2() != null) {
            sql.VALUES("LEVEL2", "#{level2,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel3() != null) {
            sql.VALUES("LEVEL3", "#{level3,jdbcType=VARCHAR}");
        }
        
        if (record.getL1Cname() != null) {
            sql.VALUES("L1_CNAME", "#{l1Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getL2Cname() != null) {
            sql.VALUES("L2_CNAME", "#{l2Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getL3Cname() != null) {
            sql.VALUES("L3_CNAME", "#{l3Cname,jdbcType=VARCHAR}");
        }
        
        if (record.getInsertDate() != null) {
            sql.VALUES("INSERT_DATE", "#{insertDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDatasource() != null) {
            sql.VALUES("DATASOURCE", "#{datasource,jdbcType=VARCHAR}");
        }
        
        if (record.getEciqUuid() != null) {
            sql.VALUES("ECIQ_UUID", "#{eciqUuid,jdbcType=VARCHAR}");
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