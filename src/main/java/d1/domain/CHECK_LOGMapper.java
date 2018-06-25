package d1.domain;

import d1.domain.CHECK_LOG;
import d1.domain.vm.CheckLog_Get_Vm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface CHECK_LOGMapper {

    @SelectProvider(type = CHECK_LOGSqlProvider.class, method = "getList")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CONTENT", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TIME", property = "time", jdbcType = JdbcType.VARCHAR)
    })
    List<CHECK_LOG> getList(CheckLog_Get_Vm model);


    @SelectProvider(type = CHECK_LOGSqlProvider.class, method = "getListCount")
    int getListCount(CheckLog_Get_Vm model);

    @Select("SELECT * FROM CHECK_LOG WHERE ID = #{id,jdbcType=VARCHAR}")
    CHECK_LOG getDetail(@Param("id") String id);


    @Insert({
            "insert into CHECK_LOG (ID, TYPE, ",
            "CONTENT, TIME)",
            "values (CHECK_LOG_ID_SEQ.nextval, #{type,jdbcType=VARCHAR}, ",
            "#{content,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR})"
    })
    int insert(CHECK_LOG record);

    @InsertProvider(type = CHECK_LOGSqlProvider.class, method = "insertSelective")
    int insertSelective(CHECK_LOG record);


    @UpdateProvider(type = CHECK_LOGSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CHECK_LOG record);

    @Update({
            "update CHECK_LOG",
            "set TYPE = #{type,jdbcType=VARCHAR},",
            "CONTENT = #{content,jdbcType=VARCHAR},",
            "TIME = #{time,jdbcType=VARCHAR}",
            "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CHECK_LOG record);

    
    @Delete({
            "delete from CHECK_LOG",
            "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);
}