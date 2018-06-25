package d1.domain.UnitPriceRange;

import d1.domain.vm.UNIT_PRICE_RANGE_TEMP_INSERT_VM;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UNIT_PRICE_RANGE_TEMPMapper {

    @Delete({"DELETE FROM UNIT_PRICE_RANGE_TEMP"})
    int deleteAll();

    @InsertProvider(type = UNIT_PRICE_RANGE_TEMPSqlProvider.class, method = "insertSql")
    int InsertUnitPriceTemp(UNIT_PRICE_RANGE_TEMP_INSERT_VM model);

    //对临时表进行分组（按照HS编码，商品名称，贸易方式，出入境）
    @Select("SELECT PROD_HS_CODE,PROD_NAME,TRADE_MODE_CODE,EXPORT_OR_IMPORT,HS_UNIT_CODE,\n" +
            "\t\t\tCOUNT(1) AS \"NUM\",SUM(UNIT_PRICE) AS \"SUMUNITPRICE\",SUM(COUNT_UNIT_PRICE) AS \"COUNTBATHNO\"\n" +
            " FROM UNIT_PRICE_RANGE_TEMP\n" +
            " GROUP BY PROD_HS_CODE,PROD_NAME,TRADE_MODE_CODE,EXPORT_OR_IMPORT,HS_UNIT_CODE")
    @Results({
            @Result(column="PROD_HS_CODE", property="prodHsCode", jdbcType= JdbcType.VARCHAR),
            @Result(column="PROD_NAME", property="prodName", jdbcType= JdbcType.VARCHAR),
            @Result(column="TRADE_MODE_CODE", property="tradeModeCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="EXPORT_OR_IMPORT", property="exportOrImport", jdbcType=JdbcType.VARCHAR),
            @Result(column="HS_UNIT_CODE", property="hsUnitCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="NUM", property="num", jdbcType=JdbcType.INTEGER),
            @Result(column="SUMUNITPRICE", property="sumUnitPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="COUNTBATHNO", property="countBathNo", jdbcType=JdbcType.INTEGER)
    })
    List<RG_UNIT_RANGE_PRICE> listRgUnitData();

    //根据HS编码，商品名称，贸易方式，出入境查询单价信息
    @Select("SELECT * FROM UNIT_PRICE_RANGE_TEMP WHERE PROD_HS_CODE=#{prodHsCode,jdbcType=VARCHAR} AND TRADE_MODE_CODE=#{tradeModeCode,jdbcType=VARCHAR} AND EXPORT_OR_IMPORT=#{exportOrImport,jdbcType=VARCHAR}")
    @Results({
            @Result(column="PROD_HS_CODE", property="prodHsCode", jdbcType= JdbcType.VARCHAR),
            @Result(column="PROD_NAME", property="prodName", jdbcType= JdbcType.VARCHAR),
            @Result(column="TRADE_MODE_CODE", property="tradeModeCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="EXPORT_OR_IMPORT", property="exportOrImport", jdbcType=JdbcType.VARCHAR),
            @Result(column="HS_UNIT_CODE", property="hsUnitCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="UNIT_PRICE", property="unitPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="COUNT_UNIT_PRICE", property="countUnitPirce", jdbcType=JdbcType.INTEGER)
    })
    List<UNIT_PRICE_RANGE_TEMP> listUnitPriceTemp(@Param("prodHsCode")String prodHsCode,@Param("tradeModeCode")String tradeModeCode,@Param("exportOrImport")String exportOrImport);
}
