package d1.domain;

import d1.commons.TimeHelper;
import d1.domain.vm.ExportRecord_Get_Vm;

public class EXPORT_RECORDSqlProvider {

    public String getList(ExportRecord_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT * FROM(SELECT A.*, ROWNUM RN FROM (");

        sb.append("SELECT * FROM EXPORT_RECORD WHERE 1=1");

        if (model.getCreateStartTime() != null && model.getCreateStartTime().length()>0&&model.getCreateEndTime() != null && model.getCreateEndTime().length()>0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }

        sb.append(" ORDER BY CREATE_TIME DESC");

        sb.append(" ) A WHERE ROWNUM <=" + model.getPage() * model.getPageSize() + ") WHERE RN > " + (model.getPage() - 1) * model.getPageSize());
        return sb.toString();
    }

    public String getListCount(ExportRecord_Get_Vm model) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("SELECT \"COUNT\"(1) FROM EXPORT_RECORD WHERE 1=1");

        if (model.getCreateStartTime() != null && model.getCreateStartTime().length()>0&&model.getCreateEndTime() != null && model.getCreateEndTime().length()>0) {
            String createEndTime = TimeHelper.getAddDate(model.getCreateEndTime(), 1);
            sb.append(" AND To_char(CREATE_TIME,'yyyy-MM-dd')>='" + model.getCreateStartTime() + "' AND To_char(CREATE_TIME,'yyyy-MM-dd')< '" + createEndTime + "'");
        }

        sb.append(" ORDER BY CREATE_TIME DESC");

        return sb.toString();
    }
}
