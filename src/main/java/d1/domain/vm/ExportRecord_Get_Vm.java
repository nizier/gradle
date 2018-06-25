package d1.domain.vm;

public class ExportRecord_Get_Vm {
    private Integer Page;

    private  Integer PageSize;

    //导出开始时间
    private String CreateStartTime;

    //导出截止时间
    private String CreateEndTime;

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
}
