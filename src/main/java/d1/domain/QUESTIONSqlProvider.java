package d1.domain;

import d1.commons.TimeHelper;
import d1.domain.Report.CheckResultReport_Get_Vm;
import d1.domain.Report.QuestionStateReport_Get_Vm;
import d1.domain.vm.QuestionExportReport_Get_Vm;
import d1.domain.vm.Question_Get_Vm;
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;

public class QUESTIONSqlProvider {

    public String getList(Question_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");

        sb.append("SELECT * FROM QUESTION WHERE 1=1");

        if (model.getType() != null && model.getType().length()>0) {
            sb.append(" AND TYPE='" + model.getType() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME LIKE '%" + model.getCheckName() + "%'");
        }
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length()>0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getDeclNo() != null && model.getDeclNo().length()>0) {
            sb.append(" AND DECL_NO LIKE '%" + model.getDeclNo() + "%'");
        }
        if (model.getGoodsNo() != null) {
            sb.append(" AND GOODS_NO = " + model.getGoodsNo());
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length()>0&&model.getCreateEndTime() != null && model.getCreateEndTime().length()>0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getCheckTime() != null && model.getCheckTime().length()>0) {
            String checkTime = TimeHelper.getAddDate(model.getCheckTime(), 1);
            sb.append(" AND To_char(CHECK_TIME,'yyyy-MM-dd')>='" + model.getCheckTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + checkTime + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        sb.append(" ORDER BY CREATE_TIME DESC");

        sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
        return sb.toString();
    }

    public String getListCount(Question_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM QUESTION WHERE 1=1");

        if (model.getType() != null && model.getType().length()>0) {
            sb.append(" AND TYPE='" + model.getType() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME LIKE '%" + model.getCheckName() + "%'");
        }
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length()>0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getDeclNo() != null && model.getDeclNo().length()>0) {
            sb.append(" AND DECL_NO LIKE '%" + model.getDeclNo() + "%'");
        }
        if (model.getGoodsNo() != null) {
            sb.append(" AND GOODS_NO = " + model.getGoodsNo());
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length()>0&&model.getCreateEndTime() != null && model.getCreateEndTime().length()>0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getCheckTime() != null && model.getCheckTime().length()>0) {
            String checkTime = TimeHelper.getAddDate(model.getCheckTime(), 1);
            sb.append(" AND To_char(CHECK_TIME,'yyyy-MM-dd')>='" + model.getCheckTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + checkTime + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        sb.append(" ORDER BY CREATE_TIME DESC");

        return sb.toString();
    }

    //按照组织机构分组
    public String getListOrganization(Question_Get_Vm model) throws  Exception
    {
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");

        sb.append("SELECT \"ORGANIZATION\",COUNT(1) FROM QUESTION WHERE 1=1");

        if (model.getType() != null && model.getType().length()>0) {
            sb.append(" AND \"TYPE\"='" + model.getType() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME LIKE '%" + model.getCheckName() + "%'");
        }
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length()>0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getDeclNo() != null && model.getDeclNo().length()>0) {
            sb.append(" AND DECL_NO LIKE '%" + model.getDeclNo() + "%'");
        }
        if (model.getGoodsNo() != null) {
            sb.append(" AND GOODS_NO = " + model.getGoodsNo());
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length()>0&&model.getCreateEndTime() != null && model.getCreateEndTime().length()>0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getCheckTime() != null && model.getCheckTime().length()>0) {
            String checkTime = TimeHelper.getAddDate(model.getCheckTime(), 1);
            sb.append(" AND To_char(CHECK_TIME,'yyyy-MM-dd')>='" + model.getCheckTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + checkTime + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        sb.append("GROUP BY \"ORGANIZATION\"");

        sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
        return sb.toString();
    }

    //核查情况统计
    public String getCheckResultReport(CheckResultReport_Get_Vm model) throws  Exception
    {
        StringBuilder sb = new StringBuilder();
        if(model.getQueryType().equals("0"))
        {
            sb.append("SELECT * FROM (SELECT CHECK_TYPE,CHECK_NAME,");
            sb.append(" CASE WHEN substr(DECL_NO, 0,1)='1' THEN '入境' ELSE '出境' END EXPORT_OR_IMPORT FROM QUESTION");
        }
        else
        {
            sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");
            sb.append("SELECT * FROM QUESTION ");
        }
        sb.append(" WHERE 1=1 ");

        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length() > 0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length() > 0 && model.getCreateEndTime() != null && model.getCreateEndTime().length() > 0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME ='" + model.getCheckName() + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        if(model.getQueryType().equals("0"))
        {
            sb.append(" )pivot (COUNT(1) for EXPORT_OR_IMPORT IN ('入境' \"IMPORT\", '出境' \"EXPORT\"))");
        }
        else
        {
            sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
            sb.append(" ORDER BY CREATE_TIME DESC");
        }

        return sb.toString();
    }

    public String getcheckResultReportListCount(CheckResultReport_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM QUESTION WHERE 1=1");
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length() > 0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length() > 0 && model.getCreateEndTime() != null && model.getCreateEndTime().length() > 0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME ='" + model.getCheckName() + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        sb.append(" ORDER BY CREATE_TIME DESC");

        return sb.toString();
    }

    //问题解决情况
    public String getQuestionStateReport(QuestionStateReport_Get_Vm model)throws  Exception
    {
        StringBuilder sb=new StringBuilder();
        if(model.getQueryType().equals("0"))
        {
            sb.append("SELECT * FROM (SELECT CHECK_TYPE,CHECK_NAME,STATE FROM QUESTION ");
        }
        else
        {
            sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");
            sb.append("SELECT * FROM QUESTION ");
        }
        sb.append("WHERE 1=1 ");
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length() > 0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length() > 0 && model.getCreateEndTime() != null && model.getCreateEndTime().length() > 0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME ='" + model.getCheckName() + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        if(model.getQueryType().equals("0"))
        {
            sb.append(" )pivot (COUNT(1)for \"STATE\" IN ('未处理' \"Untreated\", '修改仍错误' \"EditError\",'已解决' \"Solve\",");
            sb.append(" '无法解决' \"CannotSolve\",'无需解决' \"NoNeedToSolve\"))");
        }
        else
        {
            sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
            sb.append(" ORDER BY CREATE_TIME DESC");
        }
        return sb.toString();
    }

    //问题导出情况统计
    public String getQuestionExportReport(QuestionExportReport_Get_Vm model)throws  Exception
    {
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT \"A\".CHECK_ORG_CODE,\"A\".CHECK_ORG_NAME,\"A\".CREATE_TIME,CASE WHEN \"A\".COUNT_ALL=\"B\".COUNT_EXPORT THEN 1 ELSE 0 END IS_EXPORT ");
        sb.append("FROM ( ");
        sb.append("SELECT substr(\"ORGANIZATION\",0,2) AS \"CHECK_ORG_CODE\", ");
        sb.append("(SELECT LEVEL2_NAME FROM DM_TS_CL_ORG WHERE LEVEL2_CODE=SUBSTR(QUESTION.\"ORGANIZATION\",0,2) AND ROWNUM<2) AS \"CHECK_ORG_NAME\", ");
        sb.append("to_char(CREATE_TIME,'yyyy-MM-dd') AS \"CREATE_TIME\",COUNT(1) \"COUNT_ALL\" FROM QUESTION  ");
        sb.append("WHERE 1=1 ");
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length() > 0 && model.getCreateEndTime() != null && model.getCreateEndTime().length() > 0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        sb.append(" GROUP BY SUBSTR(\"ORGANIZATION\",0,2),to_char(CREATE_TIME,'yyyy-MM-dd')");
        sb.append(" ORDER BY substr(\"ORGANIZATION\",0,2) ");
        sb.append(" ) \"A\"");
        sb.append(" LEFT JOIN ( ");
        sb.append(" SELECT substr(\"ORGANIZATION\",0,2) AS \"CHECK_ORG_CODE\", ");
        sb.append("(SELECT LEVEL2_NAME FROM DM_TS_CL_ORG WHERE LEVEL2_CODE=SUBSTR(QUESTION.\"ORGANIZATION\",0,2) AND ROWNUM<2) AS \"CHECK_ORG_NAME\", ");
        sb.append(" to_char(CREATE_TIME,'yyyy-MM-dd') AS \"CREATE_TIME\",COUNT(1) AS \"COUNT_EXPORT\" FROM QUESTION ");
        sb.append(" WHERE  IS_EXPORT='1' AND 1=1 ");
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length() > 0 && model.getCreateEndTime() != null && model.getCreateEndTime().length() > 0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        sb.append(" GROUP BY SUBSTR(\"ORGANIZATION\",0,2),to_char(CREATE_TIME,'yyyy-MM-dd') ");
        sb.append(" ORDER BY substr(\"ORGANIZATION\",0,2) ");
        sb.append(" ) \"B\" ON \"A\".CHECK_ORG_CODE=\"B\".CHECK_ORG_CODE AND \"A\".CHECK_ORG_NAME=\"B\".CHECK_ORG_NAME AND \"A\".CREATE_TIME=\"B\".CREATE_TIME ");
        return sb.toString();
    }

    public String getQuestionStateReportListCount(QuestionStateReport_Get_Vm model)throws Exception{
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM QUESTION WHERE 1=1");
        if (model.getOrganization() != null && model.getOrganization().length()>0) {
            sb.append(" AND ORGANIZATION IN (" + model.getOrganization() + ")");
        }
        if (model.getOrganizationName() != null && model.getOrganizationName().length() > 0) {
            sb.append(" AND ORGANIZATION_NAME LIKE '%" + model.getOrganizationName() + "%'");
        }
        if (model.getCreateStartTime() != null && model.getCreateStartTime().length() > 0 && model.getCreateEndTime() != null && model.getCreateEndTime().length() > 0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }
        if (model.getExitEntry() != null && model.getExitEntry().length()>0) {
            sb.append(" AND EXIT_ENTRY= '" + model.getExitEntry() + "'");
        }
        if (model.getCheckName()!= null && model.getCheckName().length()>0) {
            sb.append(" AND CHECK_NAME ='" + model.getCheckName() + "'");
        }
        if (model.getState() != null && model.getState().length()>0) {
            sb.append(" AND STATE= '" + model.getState() + "'");
        }
        sb.append(" ORDER BY CREATE_TIME DESC");

        return sb.toString();
    }

    public String insertSelective(QUESTION record) throws Exception {
        SQL sql = new SQL();
        sql.INSERT_INTO("QUESTION");

        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }

        if (record.getType() != null) {
            sql.VALUES("TYPE", "#{type,jdbcType=VARCHAR}");
        }

        if (record.getCheckType() != null) {
            sql.VALUES("CHECK_TYPE", "#{checkType,jdbcType=VARCHAR}");
        }

        if (record.getCheckName() != null) {
            sql.VALUES("CHECK_NAME", "#{checkName,jdbcType=VARCHAR}");
        }

        if (record.getCheckInfor() != null) {
            sql.VALUES("CHECK_INFOR", "#{checkInfor,jdbcType=VARCHAR}");
        }

        if (record.getOrganization() != null) {
            sql.VALUES("ORGANIZATION", "#{organization,jdbcType=VARCHAR}");
        }

        if (record.getDataTable() != null) {
            sql.VALUES("DATA_TABLE", "#{dataTable,jdbcType=VARCHAR}");
        }

        if (record.getDataId() != null) {
            sql.VALUES("DATA_ID", "#{dataId,jdbcType=VARCHAR}");
        }

        if (record.getData() != null) {
            sql.VALUES("DATA", "#{data,jdbcType=VARCHAR}");
        }

        if (record.getDeclNo() != null) {
            sql.VALUES("DECL_NO", "#{declNo,jdbcType=VARCHAR}");
        }

        if (record.getGoodsNo() != null) {
            sql.VALUES("GOODS_NO", "#{goodsNo,jdbcType=DECIMAL}");
        }

        if (record.getExitEntry() != null) {
            sql.VALUES("Exit_Entry", "#{exitEntry,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCheckById() != null) {
            sql.VALUES("CHECK_BY_ID", "#{checkById,jdbcType=VARCHAR}");
        }

        if (record.getCheckByName() != null) {
            sql.VALUES("CHECK_BY_NAME", "#{checkByName,jdbcType=VARCHAR}");
        }

        if (record.getCheckTime() != null) {
            sql.VALUES("CHECK_TIME", "#{checkTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateNum() != null) {
            sql.VALUES("UPDATE_NUM", "#{updateNum,jdbcType=DECIMAL}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getState() != null) {
            sql.VALUES("STATE", "#{state,jdbcType=VARCHAR}");
        }

        if (record.getRemark() != null) {
            sql.VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String putById(QUESTION model) {

        StringBuffer sb = new StringBuffer();

        sb.append("UPDATE QUESTION SET ");

        if (model.getType() != null && model.getType().length()>0) {

            sb.append("\"TYPE\"= '" + model.getType() + "',");
        }

        if (model.getState() != null && model.getState().length()>0) {

            sb.append("\"STATE\"= '" + model.getState() + "',");
        }
        if (model.getCheckById() != null && model.getCheckById().length()>0) {

            sb.append("\"CHECK_BY_ID\"= '" + model.getCheckById() + "',");
        }
        if (model.getCheckByName() != null && model.getCheckByName().length()>0) {

            sb.append("\"CHECK_BY_NAME\"= '" + model.getCheckByName() + "',");
        }
        if (model.getCheckTime() != null) {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            sb.append("\"CHECK_TIME\"= to_date('" + df.format(model.getCheckTime()) + "','yyyy-mm-dd hh24:mi:ss'),");
            sb.append("\"CHECK_TIME\"= SYSDATE,");
        }
        if (model.getUpdateNum() != null) {

            sb.append("\"UPDATE_NUM\"= " + model.getUpdateNum() + ",");
        }
        if (model.getUpdateTime() != null) {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append("\"UPDATE_TIME\"= to_date('" + df.format(model.getUpdateTime()) + "','yyyy-mm-dd hh24:mi:ss'),");
        }
        if (model.getRemark() != null && model.getRemark().length()>0) {

            sb.append("\"REMARK\"= '" + model.getRemark() + "',");
        }

        if (model.getHandleRemark() != null && model.getHandleRemark().length()>0) {

            sb.append("\"HANDLE_REMARK\"= '" + model.getHandleRemark() + "',");
        }

        sb.delete(sb.length() - 1, sb.length());

        sb.append(" WHERE \"ID\"= '" + model.getId() + "'");

        return sb.toString();
    }

    public String putIsExportById(String Id) {

        StringBuffer sb = new StringBuffer();

        sb.append("UPDATE QUESTION SET IS_EXPORT='1' ");
        sb.append(" WHERE " + Id);

        return sb.toString();
    }

    public String putByDataId(QUESTION model) {

        StringBuffer sb = new StringBuffer();

        sb.append("UPDATE QUESTION SET ");

        if (model.getState() != null && model.getState().length()>0) {

            sb.append("\"STATE\"= '" + model.getState() + "',");
        }

        if (model.getUpdateTime() != null) {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append("\"UPDATE_TIME\"= to_date('" + df.format(model.getUpdateTime()) + "','yyyy-mm-dd hh24:mi:ss'),");
        }

        sb.delete(sb.length() - 1, sb.length());

        sb.append(" WHERE \"DATA_ID\"= '" + model.getDataId() + "'");

        return sb.toString();
    }

}