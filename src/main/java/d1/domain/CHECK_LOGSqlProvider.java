package d1.domain;

import d1.domain.vm.CheckLog_Get_Vm;
import org.apache.ibatis.jdbc.SQL;

public class CHECK_LOGSqlProvider {

    public String getList(CheckLog_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");

        sb.append("SELECT * FROM CHECK_LOG WHERE 1=1");

        if (model.getType() != null && model.getType().length() > 0) {
            sb.append(" AND TYPE ='" + model.getType() + "'");
        }

        sb.append(" ORDER BY TIME DESC");

        sb.append(" ) A WHERE ROWNUM <" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
        return sb.toString();
    }

    public String getListCount(CheckLog_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM CHECK_LOG WHERE 1=1");

        if (model.getType() != null && model.getType().length() > 0) {
            sb.append(" AND TYPE ='" + model.getType() + "'");
        }

        sb.append(" ORDER BY TIME DESC");

        return sb.toString();
    }



    public String insertSelective(CHECK_LOG record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("CHECK_LOG");

        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }

        if (record.getType() != null) {
            sql.VALUES("TYPE", "#{type,jdbcType=VARCHAR}");
        }

        if (record.getContent() != null) {
            sql.VALUES("CONTENT", "#{content,jdbcType=VARCHAR}");
        }

        if (record.getTime() != null) {
            sql.VALUES("TIME", "#{time,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CHECK_LOG record) {
        SQL sql = new SQL();
        sql.UPDATE("CHECK_LOG");

        if (record.getType() != null) {
            sql.SET("TYPE = #{type,jdbcType=VARCHAR}");
        }

        if (record.getContent() != null) {
            sql.SET("CONTENT = #{content,jdbcType=VARCHAR}");
        }

        if (record.getTime() != null) {
            sql.SET("TIME = #{time,jdbcType=VARCHAR}");
        }

        sql.WHERE("ID = #{id,jdbcType=VARCHAR}");

        return sql.toString();
    }
}