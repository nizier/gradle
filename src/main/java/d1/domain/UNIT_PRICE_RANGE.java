package d1.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UNIT_PRICE_RANGE {
    private String id;

    private String hsCode;

    private String prodName;

    private String exportOrImport;

    private String hsUnitCode;

    private String tradeMode;

    private BigDecimal topValue;

    private BigDecimal lowerValue;

    private String ifModify;

    private int batch;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode == null ? null : hsCode.trim();
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
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

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode;
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

    public String getIfModify() {
        return ifModify;
    }

    public void setIfModify(String ifModify) {
        this.ifModify = ifModify;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}