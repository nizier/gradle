package d1.domain;

import java.util.Date;

public class DM_C_MEASUREMENT_UNIT {
    private String measurementId;

    private String code;

    private String cname;

    private String ename;

    private String seqNo;

    private String alias1;

    private String alias2;

    private String alias3;

    private String flag;

    private Date lastupdate;

    private String version;

    private String fmkArchiveFlag;

    private String otherFlag;

    private Date bgdate;

    private Date enddate;

    private String transTypeTj;

    private Date operTimeTj;

    public String getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(String measurementId) {
        this.measurementId = measurementId == null ? null : measurementId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    public String getAlias1() {
        return alias1;
    }

    public void setAlias1(String alias1) {
        this.alias1 = alias1 == null ? null : alias1.trim();
    }

    public String getAlias2() {
        return alias2;
    }

    public void setAlias2(String alias2) {
        this.alias2 = alias2 == null ? null : alias2.trim();
    }

    public String getAlias3() {
        return alias3;
    }

    public void setAlias3(String alias3) {
        this.alias3 = alias3 == null ? null : alias3.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getFmkArchiveFlag() {
        return fmkArchiveFlag;
    }

    public void setFmkArchiveFlag(String fmkArchiveFlag) {
        this.fmkArchiveFlag = fmkArchiveFlag == null ? null : fmkArchiveFlag.trim();
    }

    public String getOtherFlag() {
        return otherFlag;
    }

    public void setOtherFlag(String otherFlag) {
        this.otherFlag = otherFlag == null ? null : otherFlag.trim();
    }

    public Date getBgdate() {
        return bgdate;
    }

    public void setBgdate(Date bgdate) {
        this.bgdate = bgdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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