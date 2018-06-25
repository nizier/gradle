package d1.domain.UnitPriceRange;

import java.math.BigDecimal;

public class UNIT_PRICE_RANGE_TEMP {
    private String id;
    private String prodHsCode;
    private String prodName;
    private String tradeModeCode;
    private String exportOrImport;
    private String hsUnitCode;
    private BigDecimal unitPrice;
    private int countUnitPirce;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCountUnitPirce() {
        return countUnitPirce;
    }

    public void setCountUnitPirce(int countUnitPirce) {
        this.countUnitPirce = countUnitPirce;
    }
}
