package d1.domain;

import java.util.Date;

public class DM_C_CHINA_DISTRIC_LEVEL {
    private String itemcode;

    private String cname;

    private String classifyCode;

    private String flag;

    private String version;

    private String level1;

    private String level2;

    private String level3;

    private String l1Cname;

    private String l2Cname;

    private String l3Cname;

    private Date insertDate;

    private String datasource;

    private String eciqUuid;

    private String transTypeTj;

    private Date operTimeTj;

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode == null ? null : classifyCode.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1 == null ? null : level1.trim();
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2 == null ? null : level2.trim();
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3 == null ? null : level3.trim();
    }

    public String getL1Cname() {
        return l1Cname;
    }

    public void setL1Cname(String l1Cname) {
        this.l1Cname = l1Cname == null ? null : l1Cname.trim();
    }

    public String getL2Cname() {
        return l2Cname;
    }

    public void setL2Cname(String l2Cname) {
        this.l2Cname = l2Cname == null ? null : l2Cname.trim();
    }

    public String getL3Cname() {
        return l3Cname;
    }

    public void setL3Cname(String l3Cname) {
        this.l3Cname = l3Cname == null ? null : l3Cname.trim();
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public String getEciqUuid() {
        return eciqUuid;
    }

    public void setEciqUuid(String eciqUuid) {
        this.eciqUuid = eciqUuid == null ? null : eciqUuid.trim();
    }

    public String getTransTypeTj() {
        return transTypeTj;
    }

    public void setTransTypeTj(String transTypeTj) {
        this.transTypeTj = transTypeTj == null ? null : transTypeTj.trim();
    }

    public Date getOperTimeTj() {
        return operTimeTj;
    }

    public void setOperTimeTj(Date operTimeTj) {
        this.operTimeTj = operTimeTj;
    }
}