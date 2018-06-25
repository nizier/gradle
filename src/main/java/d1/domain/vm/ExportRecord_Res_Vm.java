package d1.domain.vm;

import d1.domain.EXPORT_RECORD;

import java.util.List;

public class ExportRecord_Res_Vm {
    private Integer total;

    private List<EXPORT_RECORD> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<EXPORT_RECORD> getRows() {
        return rows;
    }

    public void setRows(List<EXPORT_RECORD> rows) {
        this.rows = rows;
    }
}
