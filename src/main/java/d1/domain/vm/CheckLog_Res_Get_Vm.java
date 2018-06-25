package d1.domain.vm;

import d1.domain.CHECK_LOG;
import d1.domain.QUESTION;

import java.util.List;

public class CheckLog_Res_Get_Vm {

    private Integer count;

    private List<CHECK_LOG> result;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<CHECK_LOG> getResult() {
        return result;
    }

    public void setResult(List<CHECK_LOG> result) {
        this.result = result;
    }
}
