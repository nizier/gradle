package d1.domain;

import d1.domain.vm.CheckConfig_Get_Vm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CHECK_CONFIGMapper {

    @SelectProvider(type = CHECK_CONFIGSqlProvider.class, method = "getList")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GROUP_ID", property = "groupId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GROUP_NAME", property = "groupName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "VALUE", property = "value", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR)
    })
    List<CHECK_CONFIG> getList(CheckConfig_Get_Vm model);


    @SelectProvider(type = CHECK_CONFIGSqlProvider.class, method = "getListCount")
    int getListCount(CheckConfig_Get_Vm model);


    @Select("SELECT * FROM CHECK_CONFIG WHERE ID = #{id,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GROUP_ID", property = "groupId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GROUP_NAME", property = "groupName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "VALUE", property = "value", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR)
    })
    CHECK_CONFIG getDetail(@Param("id") String id);


    @UpdateProvider(type = CHECK_CONFIGSqlProvider.class, method = "putById")
    int put(CHECK_CONFIG model);
}