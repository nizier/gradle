package d1.domain.vm;

public class QuestionExportReport_Res_Vm {
    //组织代码
    private String  checkOrgCode;
    //组织名称
    private String  checkOrgName;
    //时间
    private String createTime;
    //是否导出  0未导出  1导出
    private String isExport;

    public String getCheckOrgCode() {
        return checkOrgCode;
    }

    public void setCheckOrgCode(String checkOrgCode) {
        this.checkOrgCode = checkOrgCode;
    }

    public String getCheckOrgName() {
        return checkOrgName;
    }

    public void setCheckOrgName(String checkOrgName) {
        this.checkOrgName = checkOrgName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsExport() {
        return isExport;
    }

    public void setIsExport(String isExport) {
        this.isExport = isExport;
    }
}
