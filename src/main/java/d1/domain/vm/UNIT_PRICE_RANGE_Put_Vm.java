package d1.domain.vm;

import java.math.BigDecimal;
import java.util.Date;

public class UNIT_PRICE_RANGE_Put_Vm {
    private String id;

    private BigDecimal topValue;

    private BigDecimal lowerValue;

    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTopValue() {
        return topValue;
    }

    public void setTopValue(BigDecimal topValue) {
        this.topValue = topValue;
    }

    public BigDecimal getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(BigDecimal lowerValue) {
        this.lowerValue = lowerValue;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
