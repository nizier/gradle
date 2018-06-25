package d1.domain;

import d1.domain.Report.*;
import d1.domain.vm.QuestionExportReport_Get_Vm;
import d1.domain.vm.QuestionExportReport_Res_Vm;
import d1.domain.vm.Question_Get_Vm;
import d1.domain.vm.Question_Res_Get_Vm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QUESTIONMapper {

    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getList")
    @Results({

            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_INFOR", property = "checkInfor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION_NAME", property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_TABLE", property = "dataTable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_ID", property = "dataId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA", property = "data", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DECL_NO", property = "declNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GOODS_NO", property = "goodsNo", jdbcType = JdbcType.NUMERIC),
            @Result(column = "EXIT_ENTRY", property = "exitEntry", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime"),
            @Result(column = "CHECK_BY_ID", property = "checkById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_BY_NAME", property = "checkByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TIME", property = "checkTime"),
            @Result(column = "UPDATE_BY_ID", property = "updateById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_BY_NAME", property = "updateByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_NUM", property = "updateNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "UPDATE_TIME", property = "updateTime"),
            @Result(column = "STATE", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HANDLE_REMARK", property = "handleRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    List<QUESTION> getList(Question_Get_Vm model);

    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getListCount")
    int getListCount(Question_Get_Vm model);

    @Select("SELECT * FROM QUESTION WHERE ID=#{id}")
    @Results({

            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_INFOR", property = "checkInfor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION_NAME", property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_TABLE", property = "dataTable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_ID", property = "dataId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA", property = "data", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DECL_NO", property = "declNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GOODS_NO", property = "goodsNo", jdbcType = JdbcType.NUMERIC),
            @Result(column = "EXIT_ENTRY", property = "exitEntry", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime"),
            @Result(column = "CHECK_BY_ID", property = "checkById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_BY_NAME", property = "checkByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TIME", property = "checkTime"),
            @Result(column = "UPDATE_BY_ID", property = "updateById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_BY_NAME", property = "updateByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_NUM", property = "updateNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "UPDATE_TIME", property = "updateTime"),
            @Result(column = "STATE", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HANDLE_REMARK", property = "handleRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    QUESTION getDetail(@Param("id") String id);

    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getListOrganization")
    @Results({
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
    })
    List<String> getListOrganization(Question_Get_Vm model);

    //核查情况报表查询
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getCheckResultReport")
    @Results({
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IMPORT", property = "Import", jdbcType = JdbcType.INTEGER),
            @Result(column = "EXPORT", property = "Export", jdbcType = JdbcType.INTEGER)
    })
    List<CheckResultReport_Res_Vm> getCheckResultReport(CheckResultReport_Get_Vm model);

    //核查情况报表列表信息
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getCheckResultReport")
    @Results({

            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_INFOR", property = "checkInfor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION_NAME", property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_TABLE", property = "dataTable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_ID", property = "dataId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA", property = "data", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DECL_NO", property = "declNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GOODS_NO", property = "goodsNo", jdbcType = JdbcType.NUMERIC),
            @Result(column = "EXIT_ENTRY", property = "exitEntry", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime"),
            @Result(column = "CHECK_BY_ID", property = "checkById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_BY_NAME", property = "checkByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TIME", property = "checkTime"),
            @Result(column = "UPDATE_BY_ID", property = "updateById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_BY_NAME", property = "updateByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_NUM", property = "updateNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "UPDATE_TIME", property = "updateTime"),
            @Result(column = "STATE", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HANDLE_REMARK", property = "handleRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    List<QUESTION> getheckResultReportList(CheckResultReport_Get_Vm model);

    //核查情况报表列表信息总条数
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getcheckResultReportListCount")
    int getcheckResultReportListCount(CheckResultReport_Get_Vm model);

    //问题解决汇总信息
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getQuestionStateReport")
    @Results({
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Untreated", property = "untreated", jdbcType = JdbcType.INTEGER),
            @Result(column = "EditError", property = "editError", jdbcType = JdbcType.INTEGER),
            @Result(column = "Solve", property = "solve", jdbcType = JdbcType.INTEGER),
            @Result(column = "CannotSolve", property = "cannotSolve", jdbcType = JdbcType.INTEGER),
            @Result(column = "NoNeedToSolve", property = "noNeedToSolve", jdbcType = JdbcType.INTEGER)
    })
    List<QuestionStateReport_Res_Vm> getQuestionStateReport(QuestionStateReport_Get_Vm model);

    //问题解决情况列表信息
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getQuestionStateReport")
    @Results({

            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_INFOR", property = "checkInfor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION_NAME", property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_TABLE", property = "dataTable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_ID", property = "dataId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA", property = "data", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DECL_NO", property = "declNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GOODS_NO", property = "goodsNo", jdbcType = JdbcType.NUMERIC),
            @Result(column = "EXIT_ENTRY", property = "exitEntry", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime"),
            @Result(column = "CHECK_BY_ID", property = "checkById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_BY_NAME", property = "checkByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TIME", property = "checkTime"),
            @Result(column = "UPDATE_BY_ID", property = "updateById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_BY_NAME", property = "updateByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_NUM", property = "updateNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "UPDATE_TIME", property = "updateTime"),
            @Result(column = "STATE", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HANDLE_REMARK", property = "handleRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    List<QUESTION> getQuestionStateReportList(QuestionStateReport_Get_Vm model);

    //问题解决情况列表信息总条数
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getQuestionStateReportListCount")
    int getQuestionStateReportListCount(QuestionStateReport_Get_Vm model);

    //问题导出情况统计
    @SelectProvider(type = QUESTIONSqlProvider.class, method = "getQuestionExportReport")
    @Results({
            @Result(column = "CHECK_ORG_CODE", property = "checkOrgCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_ORG_NAME", property = "checkOrgName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    List<QuestionExportReport_Res_Vm> getgetQuestionExportReport(QuestionExportReport_Get_Vm model);

    @UpdateProvider(type = QUESTIONSqlProvider.class, method = "putById")
    int put(QUESTION model);

    @UpdateProvider(type = QUESTIONSqlProvider.class, method = "putIsExportById")
    int putIsExportById(String Id);

    @UpdateProvider(type = QUESTIONSqlProvider.class, method = "putByDataId")
    int putByDataId(QUESTION model);

//    @Insert({
//            "insert into QUESTION (ID, TYPE, ",
//            "CHECK_TYPE, CHECK_NAME, ",
//            "CHECK_INFOR, ORGANIZATION, ",
//            "DATA_TABLE, DATA_ID, ",
//            "DATA, DECL_NO, GOODS_NO, ",
//            "EXIT_ENTRY, CREATE_TIME, ",
//            "CHECK_BY_ID, CHECK_BY_NAME, ",
//            "CHECK_TIME, UPDATE_BY_ID, ",
//            "UPDATE_BY_NAME, UPDATE_NUM, ",
//            "UPDATE_TIME, STATE, ",
//            "REMARK)",
//            "values (QUESTION_ID_SEQ.nextval, #{type,jdbcType=VARCHAR}, ",
//            "#{checkType,jdbcType=VARCHAR}, #{checkName,jdbcType=VARCHAR}, ",
//            "#{checkInfor,jdbcType=VARCHAR}, #{organization,jdbcType=VARCHAR}, ",
//            "#{dataTable,jdbcType=VARCHAR}, #{dataId,jdbcType=VARCHAR}, ",
//            "#{data,jdbcType=VARCHAR}, #{declNo,jdbcType=VARCHAR}, #{goodsNo,jdbcType=DECIMAL}, ",
//            "#{exitEntry,jdbcType=VARCHAR}, SYSDATE, ",
//            "#{checkById,jdbcType=VARCHAR}, #{checkByName,jdbcType=VARCHAR}, ",
//            "#{checkTime,jdbcType=TIMESTAMP}, #{updateById,jdbcType=VARCHAR}, ",
//            "#{updateByName,jdbcType=VARCHAR}, #{updatNum,jdbcType=DECIMAL}, ",
//            "#{updateTime,jdbcType=TIMESTAMP}, #{state,jdbcType=VARCHAR}, ",
//            "#{remark,jdbcType=VARCHAR})"
//    })
//    int insert(QUESTION record);

    @Insert({
            "insert into QUESTION (ID, TYPE, ",
            "CHECK_TYPE, CHECK_NAME, ",
            "CHECK_INFOR, ORGANIZATION, ORGANIZATION_NAME,",
            "DATA_TABLE, DATA_ID, ",
            "DATA, DECL_NO, GOODS_NO, ",
            "EXIT_ENTRY, CREATE_TIME, ",
            "UPDATE_NUM, ",
            "STATE, ",
            "REMARK,IS_EXPORT)",
            "values (QUESTION_ID_SEQ.nextval, #{type,jdbcType=VARCHAR}, ",
            "#{checkType,jdbcType=VARCHAR}, #{checkName,jdbcType=VARCHAR}, ",
            "#{checkInfor,jdbcType=VARCHAR}, #{organization,jdbcType=VARCHAR}, #{organizationName,jdbcType=VARCHAR},",
            "#{dataTable,jdbcType=VARCHAR}, #{dataId,jdbcType=VARCHAR}, ",
            "#{data,jdbcType=VARCHAR}, #{declNo,jdbcType=VARCHAR}, #{goodsNo,jdbcType=DECIMAL}, ",
            "#{exitEntry,jdbcType=VARCHAR}, SYSDATE, ",
            "#{updateNum,jdbcType=DECIMAL}, ",
            " #{state,jdbcType=VARCHAR}, ",
            "#{remark,jdbcType=VARCHAR},0)"
    })
    int insert(QUESTION record);

//    @InsertProvider(type = QUESTIONSqlProvider.class, method = "insertSelective")
//    int insertSelective(QUESTION record);


    //查询问题表中是否存在此数据 maoyy
    @Select("SELECT * FROM QUESTION WHERE DATA_ID=#{dataId,jdbcType=VARCHAR} ")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_INFOR", property = "checkInfor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION_NAME", property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_TABLE", property = "dataTable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_ID", property = "dataId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA", property = "data", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DECL_NO", property = "declNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GOODS_NO", property = "goodsNo", jdbcType = JdbcType.NUMERIC),
            @Result(column = "EXIT_ENTRY", property = "exitEntry", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime"),
            @Result(column = "CHECK_BY_ID", property = "checkById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_BY_NAME", property = "checkByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TIME", property = "checkTime"),
            @Result(column = "UPDATE_BY_ID", property = "updateById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_BY_NAME", property = "updateByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_NUM", property = "updateNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "UPDATE_TIME", property = "updateTime"),
            @Result(column = "STATE", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HANDLE_REMARK", property = "handleRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    List<QUESTION> getQuestionInfo(@Param("dataId") String dataId);

    //根据组织机构查询问题表信息
    @Select("SELECT * FROM QUESTION WHERE \"ORGANIZATION\"=#{organization,jdbcType=VARCHAR} AND \"TYPE\"=#{type,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TYPE", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TYPE", property = "checkType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_NAME", property = "checkName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_INFOR", property = "checkInfor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION", property = "organization", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ORGANIZATION_NAME", property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_TABLE", property = "dataTable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA_ID", property = "dataId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DATA", property = "data", jdbcType = JdbcType.VARCHAR),
            @Result(column = "DECL_NO", property = "declNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "GOODS_NO", property = "goodsNo", jdbcType = JdbcType.NUMERIC),
            @Result(column = "EXIT_ENTRY", property = "exitEntry", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CREATE_TIME", property = "createTime"),
            @Result(column = "CHECK_BY_ID", property = "checkById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_BY_NAME", property = "checkByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CHECK_TIME", property = "checkTime"),
            @Result(column = "UPDATE_BY_ID", property = "updateById", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_BY_NAME", property = "updateByName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UPDATE_NUM", property = "updateNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "UPDATE_TIME", property = "updateTime"),
            @Result(column = "STATE", property = "state", jdbcType = JdbcType.VARCHAR),
            @Result(column = "REMARK", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "HANDLE_REMARK", property = "handleRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "IS_EXPORT", property = "isExport", jdbcType = JdbcType.VARCHAR)
    })
    List<QUESTION> getQuestionInfoByOrgCode(@Param("organization") String organization,@Param("type")String type);

}