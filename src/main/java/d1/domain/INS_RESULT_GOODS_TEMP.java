package d1.domain;

import java.math.BigDecimal;
import java.util.Date;

public class INS_RESULT_GOODS_TEMP {
    private String DECL_NO;

    private BigDecimal GOODS_NO;

    private Date OPER_TIME_TJ;

    public String getDECL_NO() {
        return DECL_NO;
    }

    public void setDECL_NO(String DECL_NO) {
        this.DECL_NO = DECL_NO;
    }

    public BigDecimal getGOODS_NO() {
        return GOODS_NO;
    }

    public void setGOODS_ID(BigDecimal GOODS_NO) {
        this.GOODS_NO = GOODS_NO;
    }

    public Date getOPER_TIME_TJ() {
        return OPER_TIME_TJ;
    }

    public void setOPER_TIME_TJ(Date OPER_TIME_TJ) {
        this.OPER_TIME_TJ = OPER_TIME_TJ;
    }
}
