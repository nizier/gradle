package d1.domain;

import d1.domain.DM_C_MEASUREMENT_UNIT;
import org.apache.ibatis.jdbc.SQL;

public class DM_C_MEASUREMENT_UNITSqlProvider {

    public String insertSelective(DM_C_MEASUREMENT_UNIT record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DM_C_MEASUREMENT_UNIT");
        
        if (record.getMeasurementId() != null) {
            sql.VALUES("MEASUREMENT_ID", "#{measurementId,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("CODE", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCname() != null) {
            sql.VALUES("CNAME", "#{cname,jdbcType=VARCHAR}");
        }
        
        if (record.getEname() != null) {
            sql.VALUES("ENAME", "#{ename,jdbcType=VARCHAR}");
        }
        
        if (record.getSeqNo() != null) {
            sql.VALUES("SEQ_NO", "#{seqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias1() != null) {
            sql.VALUES("ALIAS1", "#{alias1,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias2() != null) {
            sql.VALUES("ALIAS2", "#{alias2,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias3() != null) {
            sql.VALUES("ALIAS3", "#{alias3,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            sql.VALUES("FLAG", "#{flag,jdbcType=CHAR}");
        }
        
        if (record.getLastupdate() != null) {
            sql.VALUES("LASTUPDATE", "#{lastupdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getFmkArchiveFlag() != null) {
            sql.VALUES("FMK_ARCHIVE_FLAG", "#{fmkArchiveFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherFlag() != null) {
            sql.VALUES("OTHER_FLAG", "#{otherFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getBgdate() != null) {
            sql.VALUES("BGDATE", "#{bgdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnddate() != null) {
            sql.VALUES("ENDDATE", "#{enddate,jdbcType=TIMESTAMP}");
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