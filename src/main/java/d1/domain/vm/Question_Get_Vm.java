package d1.domain.vm;

import java.math.BigDecimal;

public class Question_Get_Vm {

    private Integer Page;

    private  Integer PageSize;

    //类型（error 错误、suspected 疑似）
    private String Type;

    //核查项
    private String CheckName;

    //机构
    private String Organization;

    //机构名称
    private String organizationName;

    //报检单号
    private String DeclNo;

    //货物序号
    private BigDecimal GoodsNo;

    //出入境（出境、入境、出入境）
    private String ExitEntry;

    //创建开始时间
    private String CreateStartTime;

    //创建截止时间
    private String CreateEndTime;

    //核查时间
    private String CheckTime;

    //状态（1）未修改（默认），2）修改后仍错（系统自动），3）已解决，4）无需解决，5）无法解决 6）需确认
    private String State;

    //是否归我管理 0：归我查询     1：归我管理
    private String IsBelongMeManage;

    //当前登陆的用户名
    private String getuserId;

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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCheckName() {
        return CheckName;
    }

    public void setCheckName(String checkName) {
        CheckName = checkName;
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

    public String getDeclNo() {
        return DeclNo;
    }

    public void setDeclNo(String declNo) {
        DeclNo = declNo;
    }

    public BigDecimal getGoodsNo() {
        return GoodsNo;
    }

    public void setGoodsNo(BigDecimal goodsNo) {
        GoodsNo = goodsNo;
    }

    public String getExitEntry() {
        return ExitEntry;
    }

    public void setExitEntry(String exitEntry) {
        ExitEntry = exitEntry;
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

    public String getCheckTime() {
        return CheckTime;
    }

    public void setCheckTime(String checkTime) {
        CheckTime = checkTime;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getIsBelongMeManage() {
        return IsBelongMeManage;
    }

    public void setIsBelongMeManage(String isBelongMeManage) {
        IsBelongMeManage = isBelongMeManage;
    }

    public String getGetuserId() {
        return getuserId;
    }

    public void setGetuserId(String getuserId) {
        this.getuserId = getuserId;
    }
}
