package d1.domain;

import d1.domain.vm.CheckConfig_Get_Vm;
import org.apache.ibatis.jdbc.SQL;

public class CHECK_CONFIGSqlProvider {

    public String getList(CheckConfig_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");

        sb.append("SELECT * FROM CHECK_CONFIG WHERE 1=1");

        if (model.getGroupName() != null && model.getGroupName().length() > 0) {
            sb.append(" AND GROUP_NAME LIKE'%" + model.getGroupName() + "%'");
        }
        if (model.getName() != null && model.getName().length() > 0) {
            sb.append(" AND NAME LIKE '%" + model.getName() + "%'");
        }

        sb.append(" ORDER BY GROUP_ID");

        sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
        return sb.toString();
    }

    public String getListCount(CheckConfig_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM CHECK_CONFIG WHERE 1=1");

        if (model.getGroupName() != null && model.getGroupName().length() > 0) {
            sb.append(" AND GROUP_NAME LIKE'%" + model.getGroupName() + "%'");
        }
        if (model.getName() != null && model.getName().length() > 0) {
            sb.append(" AND NAME LIKE '%" + model.getName() + "%'");
        }

        sb.append(" ORDER BY ID DESC");

        return sb.toString();
    }


    public String putById(CHECK_CONFIG model) {
        StringBuffer sb = new StringBuffer();

        sb.append("UPDATE CHECK_CONFIG SET");

        if (model.getGroupId() != null && model.getGroupId().length() > 0) {

            sb.append("\"GROUP_ID\"= '" + model.getGroupId() + "',");
        }
        if (model.getGroupName() != null && model.getGroupName().length() > 0) {

            sb.append("\"GROUP_NAME\"= '" + model.getGroupName() + "',");
        }
        if (model.getName() != null && model.getName().length() > 0) {

            sb.append("\"NAME\"= '" + model.getName() + "',");
        }
        if (model.getValue() != null && model.getValue().length() > 0) {

            sb.append("\"VALUE\"= '" + model.getValue() + "',");
        }

        sb.delete(sb.length() - 1, sb.length());

        sb.append("WHERE \"ID\"= '" + model.getId() + "'");

        return sb.toString();
    }
}