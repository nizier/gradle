package d1.domain.UnitPriceRange;

import d1.domain.vm.UNIT_PRICE_RANGE_TEMP_INSERT_VM;
import org.apache.ibatis.jdbc.SQL;

public class UNIT_PRICE_RANGE_TEMPSqlProvider {

    public String insertSql(UNIT_PRICE_RANGE_TEMP_INSERT_VM model)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO \"UNIT_PRICE_RANGE_TEMP\"(\"ID\",PROD_HS_CODE,PROD_NAME,TRADE_MODE_CODE,EXPORT_OR_IMPORT,");
        sb.append("HS_UNIT_CODE,UNIT_PRICE,COUNT_UNIT_PRICE) ");
        sb.append("SELECT UNIT_PRICE_RANGE_TEMP_SEQ.nextval,\"A\".* FROM ");
        sb.append("(SELECT INS.PROD_HS_CODE,HSCODE.HS_CNAME,DCL.TRADE_MODE_CODE,");
        sb.append("CASE WHEN substr(INS.DECL_NO, 0,1)='1' THEN '入境' ELSE '出境' END AS EXPORT_OR_IMPORT,CUNIT.CNAME,");
        sb.append("CASE WHEN CUNIT.ALIAS1='2' THEN round(DECODE(INS.STD_WT, 0, 0,INS.TOTAL_VAL_US/INS.STD_WT),6)");
        sb.append("ELSE round(DECODE(INS.STD_QTY,0,0, INS.TOTAL_VAL_US/INS.STD_QTY),6) END AS UNIT_PRICE,");
        sb.append("COUNT(1) AS COUNTNUM FROM ");
        if(model.getUnitPriceDataTable()!=null&& model.getUnitPriceDataTable().length() > 0)
        {
            sb.append(model.getUnitPriceDataTable()+".INS_RESULT_GOODS INS INNER JOIN ");
            sb.append(model.getUnitPriceDataTable()+".DCL_IO_DECL DCL ON INS.DECL_NO=DCL.DECL_NO ");
        }
        sb.append("LEFT JOIN DM_C_Z_BBD_HS_CODE HSCODE ON INS.PROD_HS_CODE=HSCODE.HS_CODE ");
        sb.append("LEFT JOIN DM_C_MEASUREMENT_UNIT CUNIT ON HSCODE.STD_MEASURE_CODE=CUNIT.CODE ");
        if(model.getStrBeforeDate()!=null&&model.getStrBeforeDate().length()>0)
        {
            sb.append(" WHERE INS.\"OPER_TIME_TJ\">=to_date('"+model.getStrBeforeDate()+"', 'yyyy-mm-dd') ");
        }
        sb.append("GROUP BY INS.PROD_HS_CODE,HSCODE.HS_CNAME,DCL.TRADE_MODE_CODE,");
        sb.append("CASE WHEN substr(INS.DECL_NO, 0,1)='1' THEN '入境' ELSE '出境' END,CUNIT.CNAME,");
        sb.append("CASE WHEN CUNIT.ALIAS1='2' THEN round(DECODE(INS.STD_WT, 0, 0,INS.TOTAL_VAL_US/INS.STD_WT),6)");
        sb.append("ELSE round(DECODE(INS.STD_QTY,0,0, INS.TOTAL_VAL_US/INS.STD_QTY),6) END )\"A\"");
        return sb.toString();
    }

    public String insert(UNIT_PRICE_RANGE_TEMP_INSERT_VM model)
    {
        SQL sql=new SQL();
        sql.INSERT_INTO("UNIT_PRICE_RANGE_TEMP");
        sql.INTO_COLUMNS("\"ID\",PROD_HS_CODE,PROD_NAME,TRADE_MODE_CODE,EXPORT_OR_IMPORT,HS_UNIT_CODE,UNIT_PRICE,COUNT_UNIT_PRICE");

//        sb.append("INSERT INTO \"UNIT_PRICE_RANGE_TEMP\"(\"ID\",PROD_HS_CODE,PROD_NAME,TRADE_MODE_CODE,EXPORT_OR_IMPORT,");
//        sb.append("HS_UNIT_CODE,UNIT_PRICE,COUNT_UNIT_PRICE)");
//        sb.append("SELECT UNIT_PRICE_RANGE_TEMP_SEQ.nextval,\"A\".* FROM ");
//        sb.append("(SELECT INS.PROD_HS_CODE,HSCODE.HS_CNAME,DCL.TRADE_MODE_CODE,");
//        sb.append("CASE WHEN substr(INS.DECL_NO, 0,1)='1' THEN '入境' ELSE '出境' END AS EXPORT_OR_IMPORT,CUNIT.CNAME,");
//        sb.append("CASE WHEN CUNIT.ALIAS1='2' THEN round(DECODE(INS.STD_WT, 0, 0,INS.TOTAL_VAL_US/INS.STD_WT),6)");
//        sb.append("ELSE round(DECODE(INS.STD_QTY,0,0, INS.TOTAL_VAL_US/INS.STD_QTY),6) END AS UNIT_PRICE,");
//        sb.append("COUNT(1) AS COUNTNUM FROM");
//        if(model.getUnitPriceDataTable()!=null&& model.getUnitPriceDataTable().length() > 0)
//        {
//            sb.append(model.getUnitPriceDataTable()+".INS_RESULT_GOODS INS INNER JOIN ");
//            sb.append(model.getUnitPriceDataTable()+".DCL_IO_DECL DCL ON INS.DECL_NO=DCL.DECL_NO");
//        }
//        sb.append("LEFT JOIN DM_C_Z_BBD_HS_CODE HSCODE ON INS.PROD_HS_CODE=HSCODE.HS_CODE");
//        sb.append("LEFT JOIN DM_C_MEASUREMENT_UNIT CUNIT ON HSCODE.STD_MEASURE_CODE=CUNIT.CODE");
//        if(model.getStrBeforeDate()!=null&&model.getStrBeforeDate().length()>0)
//        {
//            sb.append("WHERE \"OPER_TIME_TJ\">=to_date('"+model.getStrBeforeDate()+"', 'yyyy-mm-dd')");
//        }
//        sb.append("GROUP BY INS.PROD_HS_CODE,HSCODE.HS_CNAME,DCL.TRADE_MODE_CODE,");
//        sb.append("CASE WHEN substr(INS.DECL_NO, 0,1)='1' THEN '入境' ELSE '出境' END,CUNIT.CNAME,");
//        sb.append("CASE WHEN CUNIT.ALIAS1='2' THEN round(DECODE(INS.STD_WT, 0, 0,INS.TOTAL_VAL_US/INS.STD_WT),6)");
//        sb.append("ELSE round(DECODE(INS.STD_QTY,0,0, INS.TOTAL_VAL_US/INS.STD_QTY),6) END )\"A\"");
        return sql.toString();
    }

}
