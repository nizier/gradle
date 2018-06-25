package d1.domain;

import d1.commons.TimeHelper;
import d1.domain.UNIT_PRICE_RANGE;
import d1.domain.vm.UNIT_PRICE_RANGE_Get_Vm;
import d1.domain.vm.UNIT_PRICE_RANGE_Put_Vm;
import d1.service.UserService;
import org.apache.ibatis.jdbc.SQL;

public class UNIT_PRICE_RANGESqlProvider {

    public String insertSelective(UNIT_PRICE_RANGE record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("UNIT_PRICE_RANGE");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getHsCode() != null) {
            sql.VALUES("HS_CODE", "#{hsCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExportOrImport() != null) {
            sql.VALUES("EXPORT_OR_IMPORT", "#{exportOrImport,jdbcType=VARCHAR}");
        }
        
        if (record.getHsUnitCode() != null) {
            sql.VALUES("HS_UNIT_CODE", "#{hsUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeMode() != null) {
            sql.VALUES("TRADE_MODE", "#{tradeMode,jdbcType=VARCHAR}");
        }
        
        if (record.getTopValue() != null) {
            sql.VALUES("TOP_VALUE", "#{topValue,jdbcType=DECIMAL}");
        }
        
        if (record.getLowerValue() != null) {
            sql.VALUES("LOWER_VALUE", "#{lowerValue,jdbcType=DECIMAL}");
        }
        
        if (record.getIfModify() != null) {
            sql.VALUES("IF_MODIFY", "#{ifModify,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch() != 0) {
            sql.VALUES("BATCH", "#{batch,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("CREATE_USER", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.VALUES("UPDATE_USER", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String getList(UNIT_PRICE_RANGE_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");

        sb.append("SELECT \"ID\",HS_CODE,PROD_NAME,HS_UNIT_CODE,\"BATCH\",EXPORT_OR_IMPORT,TRADE_MODE,TOP_VALUE,");
        sb.append("LOWER_VALUE,CASE WHEN IF_MODIFY='0' THEN '否' ELSE '是' END AS IF_MODIFY,CREATE_USER,");
        sb.append("CREATE_TIME,UPDATE_USER,UPDATE_TIME FROM UNIT_PRICE_RANGE WHERE 1=1");

        if (model.getHsCode() != null && model.getHsCode().length()>0) {
            sb.append(" AND HS_CODE='" + model.getHsCode() + "'");
        }

        sb.append(" ORDER BY CREATE_TIME DESC");

        sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
        return sb.toString();
    }

    public String getListCount(UNIT_PRICE_RANGE_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM UNIT_PRICE_RANGE WHERE 1=1");

        if (model.getHsCode() != null && model.getHsCode().length()>0) {
            sb.append(" AND HS_CODE='" + model.getHsCode() + "'");
        }

        sb.append(" ORDER BY CREATE_TIME DESC");

        return sb.toString();
    }

    public String putById(UNIT_PRICE_RANGE_Put_Vm model)
    {
        StringBuffer sb = new StringBuffer();

        sb.append("UPDATE UNIT_PRICE_RANGE SET IF_MODIFY=1 ,UPDATE_TIME=SYSDATE,UPDATE_USER='"+ model.getUpdateUser()+"',");

        if (model.getTopValue() != null) {

            sb.append("\"TOP_VALUE\"= " + model.getTopValue() + ",");
        }
        if (model.getLowerValue() != null) {

            sb.append("\"LOWER_VALUE\"= " + model.getLowerValue() + ",");
        }

        sb.delete(sb.length() - 1, sb.length());

        sb.append(" WHERE \"ID\"= '" + model.getId() + "'");

        return sb.toString();
    }
}