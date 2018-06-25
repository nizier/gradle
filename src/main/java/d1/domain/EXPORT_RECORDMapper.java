package d1.domain;

import d1.domain.vm.ExportRecord_Get_Vm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface EXPORT_RECORDMapper {

    @Insert({
            "insert into EXPORT_RECORD (ID, FILE_NAME, ",
            "CREATE_TIME, CREATE_BY_ID, ",
            "CREATE_BY_NAME, REMARK)",
            "values (EXPORT_RECORD_SEQ.nextval, #{fileName,jdbcType=VARCHAR}, ",
            "SYSDATE, #{createById,jdbcType=VARCHAR}, ",
            "#{createByName,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(EXPORT_RECORD record);

    @SelectProvider(type = EXPORT_RECORDSqlProvider.class, method = "getList")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "FILE_NAME", property = "fileName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "CREATE_BY_ID", property = "createById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_BY_NAME", property = "createByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR)
    })
    List<EXPORT_RECORD> getList(ExportRecord_Get_Vm model);

    @SelectProvider(type = EXPORT_RECORDSqlProvider.class, method = "getListCount")
    int getListCount(ExportRecord_Get_Vm model);

    @Select("SELECT * FROM EXPORT_RECORD WHERE ID=#{id}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "FILE_NAME", property = "fileName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "CREATE_BY_ID", property = "createById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_BY_NAME", property = "createByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR)
    })
    EXPORT_RECORD getDetail(@Param("id") String id);

    @Delete({
            "DELETE FROM EXPORT_RECORD",
            "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("id") String id);
}
