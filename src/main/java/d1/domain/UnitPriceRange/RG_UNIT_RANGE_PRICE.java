package d1.domain.UnitPriceRange;

import java.math.BigDecimal;

public class RG_UNIT_RANGE_PRICE {
    private String prodHsCode;
    private String prodName;
    private String tradeModeCode;
    private String exportOrImport;
    private String hsUnitCode;
    private int  num;
    private BigDecimal sumUnitPrice;
    private int countBathNo;

    public String getProdHsCode() {
        return prodHsCode;
    }

    public void setProdHsCode(String prodHsCode) {
        this.prodHsCode = prodHsCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getTradeModeCode() {
        return tradeModeCode;
    }

    public void setTradeModeCode(String tradeModeCode) {
        this.tradeModeCode = tradeModeCode;
    }

    public String getExportOrImport() {
        return exportOrImport;
    }

    public void setExportOrImport(String exportOrImport) {
        this.exportOrImport = exportOrImport;
    }

    public String getHsUnitCode() {
        return hsUnitCode;
    }

    public void setHsUnitCode(String hsUnitCode) {
        this.hsUnitCode = hsUnitCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getSumUnitPrice() {
        return sumUnitPrice;
    }

    public void setSumUnitPrice(BigDecimal sumUnitPrice) {
        this.sumUnitPrice = sumUnitPrice;
    }

    public int getCountBathNo() {
        return countBathNo;
    }

    public void setCountBathNo(int countBathNo) {
        this.countBathNo = countBathNo;
    }
}
