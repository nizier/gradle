package d1.domain;

import d1.domain.UNIT_PRICE_RANGE;
import d1.domain.vm.UNIT_PRICE_RANGE_Get_Vm;
import d1.domain.vm.UNIT_PRICE_RANGE_Put_Vm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UNIT_PRICE_RANGEMapper {

    @Delete({"DELETE FROM UNIT_PRICE_RANGE"})
    int deleteAll();

    @Delete({"DELETE FROM UNIT_PRICE_RANGE WHERE IF_MODIFY='0'"})
    int deleteModify();

    @Delete({"DELETE FROM UNIT_PRICE_RANGE WHERE ID = #{id,jdbcType=VARCHAR}"})
    int deleteById(@Param("id") String id);

    @Insert({
        "insert into UNIT_PRICE_RANGE (ID, HS_CODE,PROD_NAME, ",
        "EXPORT_OR_IMPORT, HS_UNIT_CODE, ",
        "TRADE_MODE, TOP_VALUE, ",
        "LOWER_VALUE, IF_MODIFY, ",
        "BATCH, CREATE_USER, ",
        "CREATE_TIME)",
        "values (UNIT_PRICE_RANGE_QUE.nextval, #{hsCode,jdbcType=VARCHAR},#{prodName,jdbcType=VARCHAR}, ",
        "#{exportOrImport,jdbcType=VARCHAR}, #{hsUnitCode,jdbcType=VARCHAR}, ",
        "#{tradeMode,jdbcType=VARCHAR}, #{topValue,jdbcType=DECIMAL}, ",
        "#{lowerValue,jdbcType=DECIMAL},0 , ",
        "#{batch,jdbcType=DECIMAL}, #{createUser,jdbcType=VARCHAR}, ",
        "SYSDATE ) "
    })
    int insert(UNIT_PRICE_RANGE record);

    @InsertProvider(type=UNIT_PRICE_RANGESqlProvider.class, method="insertSelective")
    int insertSelective(UNIT_PRICE_RANGE record);

    //查询已经修改过的数据
    @Select("SELECT * FROM UNIT_PRICE_RANGE WHERE IF_MODIFY='1'")
    @Results({
            @Result(column = "HS_CODE",property = "hsCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "PROD_NAME", property = "prodName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "EXPORT_OR_IMPORT",property = "exportOrImport",jdbcType = JdbcType.VARCHAR),
            @Result(column = "HS_UNIT_CODE",property = "hsUnitCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TRADE_MODE",property = "tradeMode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TOP_VALUE",property = "topValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "LOWER_VALUE",property = "lowerValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "IF_MODIFY",property = "ifModify",jdbcType = JdbcType.VARCHAR),
            @Result(column = "BATCH",property = "batch",jdbcType = JdbcType.DECIMAL),
            @Result(column = "CREATE_USER",property = "createUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME",property = "createTime",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "UPDATE_USER",property = "updateUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_TIME",property = "updateTime",jdbcType = JdbcType.TIMESTAMP)
    })
    List<UNIT_PRICE_RANGE> listUnitPriceRange();

    //根据hscode，获取最大，最小边界值
    @Select("SELECT * FROM UNIT_PRICE_RANGE WHERE HS_CODE=#{HsCode,jdbcType=VARCHAR} AND EXPORT_OR_IMPORT=#{ExportOrImport,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "HS_CODE",property = "hsCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "PROD_NAME", property = "prodName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "EXPORT_OR_IMPORT",property = "exportOrImport",jdbcType = JdbcType.VARCHAR),
            @Result(column = "HS_UNIT_CODE",property = "hsUnitCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TRADE_MODE",property = "tradeMode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TOP_VALUE",property = "topValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "LOWER_VALUE",property = "lowerValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "IF_MODIFY",property = "ifModify",jdbcType = JdbcType.VARCHAR),
            @Result(column = "BATCH",property = "batch",jdbcType = JdbcType.DECIMAL),
            @Result(column = "CREATE_USER",property = "createUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME",property = "createTime",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "UPDATE_USER",property = "updateUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_TIME",property = "updateTime",jdbcType = JdbcType.TIMESTAMP)
    })
    List<UNIT_PRICE_RANGE> listUnitPriceRangeData(@Param("HsCode")String HsCode,@Param("ExportOrImport")String ExportOrImport);

    @SelectProvider(type = UNIT_PRICE_RANGESqlProvider.class, method = "getList")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "PROD_NAME", property = "prodName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HS_CODE",property = "hsCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "EXPORT_OR_IMPORT",property = "exportOrImport",jdbcType = JdbcType.VARCHAR),
            @Result(column = "HS_UNIT_CODE",property = "hsUnitCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TRADE_MODE",property = "tradeMode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TOP_VALUE",property = "topValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "LOWER_VALUE",property = "lowerValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "IF_MODIFY",property = "ifModify",jdbcType = JdbcType.VARCHAR),
            @Result(column = "BATCH",property = "batch",jdbcType = JdbcType.DECIMAL),
            @Result(column = "CREATE_USER",property = "createUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME",property = "createTime",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "UPDATE_USER",property = "updateUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_TIME",property = "updateTime",jdbcType = JdbcType.TIMESTAMP)
    })
    List<UNIT_PRICE_RANGE> getList(UNIT_PRICE_RANGE_Get_Vm model);

    @SelectProvider(type = UNIT_PRICE_RANGESqlProvider.class, method = "getListCount")
    int getListCount(UNIT_PRICE_RANGE_Get_Vm model);

    @Select("SELECT * FROM UNIT_PRICE_RANGE WHERE ID=#{id,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HS_CODE",property = "hsCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "PROD_NAME", property = "prodName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "EXPORT_OR_IMPORT",property = "exportOrImport",jdbcType = JdbcType.VARCHAR),
            @Result(column = "HS_UNIT_CODE",property = "hsUnitCode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TRADE_MODE",property = "tradeMode",jdbcType = JdbcType.VARCHAR),
            @Result(column = "TOP_VALUE",property = "topValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "LOWER_VALUE",property = "lowerValue",jdbcType = JdbcType.DECIMAL),
            @Result(column = "IF_MODIFY",property = "ifModify",jdbcType = JdbcType.VARCHAR),
            @Result(column = "BATCH",property = "batch",jdbcType = JdbcType.DECIMAL),
            @Result(column = "CREATE_USER",property = "createUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME",property = "createTime",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "UPDATE_USER",property = "updateUser",jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_TIME",property = "updateTime",jdbcType = JdbcType.TIMESTAMP)
    })
    UNIT_PRICE_RANGE getDetail(@Param("id") String id);

    @UpdateProvider(type = UNIT_PRICE_RANGESqlProvider.class, method = "putById")
    int put(UNIT_PRICE_RANGE_Put_Vm model);
}