package d1.domain.vm;

import d1.domain.CHECK_CONFIG;
import d1.domain.QUESTION;

import java.util.List;

public class CheckConfig_Res_Get_Vm {

    private Integer count;

    private List<CHECK_CONFIG> result;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<CHECK_CONFIG> getResult() {
        return result;
    }

    public void setResult(List<CHECK_CONFIG> result) {
        this.result = result;
    }
}
