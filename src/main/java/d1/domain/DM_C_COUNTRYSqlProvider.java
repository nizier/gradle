package d1.domain;

import d1.domain.DM_C_COUNTRY;
import org.apache.ibatis.jdbc.SQL;

public class DM_C_COUNTRYSqlProvider {

    public String insertSelective(DM_C_COUNTRY record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DM_C_COUNTRY");
        
        if (record.getCcmUuid() != null) {
            sql.VALUES("CCM_UUID", "#{ccmUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getItemcode() != null) {
            sql.VALUES("ITEMCODE", "#{itemcode,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias2() != null) {
            sql.VALUES("ALIAS2", "#{alias2,jdbcType=VARCHAR}");
        }
        
        if (record.getCname() != null) {
            sql.VALUES("CNAME", "#{cname,jdbcType=VARCHAR}");
        }
        
        if (record.getEname() != null) {
            sql.VALUES("ENAME", "#{ename,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            sql.VALUES("FLAG", "#{flag,jdbcType=CHAR}");
        }
        
        if (record.getOldcode() != null) {
            sql.VALUES("OLDCODE", "#{oldcode,jdbcType=VARCHAR}");
        }
        
        if (record.getCldcname() != null) {
            sql.VALUES("CLDCNAME", "#{cldcname,jdbcType=VARCHAR}");
        }
        
        if (record.getLastupdate() != null) {
            sql.VALUES("LASTUPDATE", "#{lastupdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getFmkArchiveFlag() != null) {
            sql.VALUES("FMK_ARCHIVE_FLAG", "#{fmkArchiveFlag,jdbcType=CHAR}");
        }
        
        if (record.getAlias3() != null) {
            sql.VALUES("ALIAS3", "#{alias3,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqCode() != null) {
            sql.VALUES("CIQ_CODE", "#{ciqCode,jdbcType=VARCHAR}");
        }
        
        if (record.getContinentCode() != null) {
            sql.VALUES("CONTINENT_CODE", "#{continentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getParentcode() != null) {
            sql.VALUES("PARENTCODE", "#{parentcode,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherFlag() != null) {
            sql.VALUES("OTHER_FLAG", "#{otherFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getStatecname() != null) {
            sql.VALUES("STATECNAME", "#{statecname,jdbcType=VARCHAR}");
        }
        
        if (record.getIndexid() != null) {
            sql.VALUES("INDEXID", "#{indexid,jdbcType=VARCHAR}");
        }
        
        if (record.getInsertDate() != null) {
            sql.VALUES("INSERT_DATE", "#{insertDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDatasource() != null) {
            sql.VALUES("DATASOURCE", "#{datasource,jdbcType=VARCHAR}");
        }
        
        if (record.getTransTypeTj() != null) {
            sql.VALUES("TRANS_TYPE_TJ", "#{transTypeTj,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTimeTj() != null) {
            sql.VALUES("OPER_TIME_TJ", "#{operTimeTj,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStateename() != null) {
            sql.VALUES("STATEENAME", "#{stateename,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}