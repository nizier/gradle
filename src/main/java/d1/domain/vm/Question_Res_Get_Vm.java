package d1.domain.vm;

import d1.domain.QUESTION;

import java.util.List;

public class Question_Res_Get_Vm {

    private Integer total;

    private List<QUESTION> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<QUESTION> getRows() {
        return rows;
    }

    public void setRows(List<QUESTION> rows) {
        this.rows = rows;
    }
}
