package d1.domain.Report;

public class CheckResultReport_Get_Vm {
    private Integer Page;

    private  Integer PageSize;

    //查询类型 0 汇总 1列表
    private String queryType;
    //机构
    private String Organization;
    //机构名称
    private String organizationName;
    //创建开始时间
    private String CreateStartTime;

    //创建截止时间
    private String CreateEndTime;
    //当前登陆的用户名
    private String getuserId;
    //出入境（出境、入境、出入境）
    private String ExitEntry;
    //核查项
    private String CheckName;
    //状态（1）未修改（默认），2）修改后仍错（系统自动），3）已解决，4）无需解决，5）无法解决
    private String State;

    public Integer getPage() {
        return Page;
    }

    public void setPage(Integer page) {
        Page = page;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

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

    public String getGetuserId() {
        return getuserId;
    }

    public void setGetuserId(String getuserId) {
        this.getuserId = getuserId;
    }

    public String getExitEntry() {
        return ExitEntry;
    }

    public void setExitEntry(String exitEntry) {
        ExitEntry = exitEntry;
    }

    public String getCheckName() {
        return CheckName;
    }

    public void setCheckName(String checkName) {
        CheckName = checkName;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
