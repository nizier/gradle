package d1.domain.vm;

public class UNIT_PRICE_RANGE_Get_Vm {
    private Integer Page;

    private  Integer PageSize;

    private String HsCode;

    private String exportOrImport;
    public String getExportOrImport() {
        return exportOrImport;
    }

    public void setExportOrImport(String exportOrImport) {
        this.exportOrImport = exportOrImport;
    }
    //当前登陆的用户名
    private String getuserId;

    public String getHsCode() {
        return HsCode;
    }

    public void setHsCode(String hsCode) {
        HsCode = hsCode;
    }

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

    public String getGetuserId() {
        return getuserId;
    }

    public void setGetuserId(String getuserId) {
        this.getuserId = getuserId;
    }
}
