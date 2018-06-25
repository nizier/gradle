package d1.domain.vm;

import d1.domain.UNIT_PRICE_RANGE;

import java.util.List;

public class UNIT_PRICE_RANGE_Res_Get_Vm {
    private Integer count;

    private List<UNIT_PRICE_RANGE> result;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UNIT_PRICE_RANGE> getResult() {
        return result;
    }

    public void setResult(List<UNIT_PRICE_RANGE> result) {
        this.result = result;
    }
}
