package d1.domain.vm;

public class QuestionExportReport_Get_Vm {
    //创建开始时间
    private String CreateStartTime;

    //创建截止时间
    private String CreateEndTime;

    //机构
    private String Organization;

    //当前登陆的用户名
    private String getuserId;

    public String getCreateStartTime() {
        return CreateStartTime;
    }

    public void setCreateStartTime(String createStartTime) {
        CreateStartTime = createStartTime;
    }

    public String getCreateEndTime() {
        return CreateEndTime;
    }

    public void setCreateEndTime(String createEndTime) {
        CreateEndTime = createEndTime;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
    }

    public String getGetuserId() {
        return getuserId;
    }

    public void setGetuserId(String getuserId) {
        this.getuserId = getuserId;
    }
}
