package d1.domain;

import java.math.BigDecimal;
import java.util.Date;

public class QUESTION {
    private String id;

	//类型（error 错误、suspected疑似）
    private String type;

	//核查类型
    private String checkType;

	//核查名称
    private String checkName;

	//核查说明
    private String checkInfor;

	//机构Code
    private String organization;

    //机构名称
    private String organizationName;

    //表名（DCL_IO_DECL 报检-主、DCL_IO_DECL_GOODS 报检-从、INS_RESULT_SUM 检验检疫-主、INS_RESULT_GOODS 检验检疫-从）
    private String dataTable;

	//表Id
    private String dataId;

	//表数据
    private String data;

	//报检单号
    private String declNo;

	//货物序号
    private BigDecimal goodsNo;

	//出入境（出境、入境、出入境）
    private String exitEntry;

	//创建时间(核查时间)
    private Date createTime;

	//核查人Id
    private String checkById;

	//核查人名称
    private String checkByName;

	//人工操作时间
    private Date checkTime;

	//复核次数
    private BigDecimal updateNum;

	//最后复核时间
    private Date updateTime;

	//状态（1）未修改（默认），2）修改后仍错（系统自动），3）已解决，4）无需解决，5）无法解决
    private String state;

	//备注
    private String remark;

    //处理问题备注
    private String handleRemark;

    //是否导出，默认0 未导出  1导出
    private String isExport;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
    }

    public String getCheckInfor() {
        return checkInfor;
    }

    public void setCheckInfor(String checkInfor) {
        this.checkInfor = checkInfor == null ? null : checkInfor.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable == null ? null : dataTable.trim();
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getDeclNo() {
        return declNo;
    }

    public void setDeclNo(String declNo) {
        this.declNo = declNo == null ? null : declNo.trim();
    }

    public BigDecimal getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(BigDecimal goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getExitEntry() {
        return exitEntry;
    }

    public void setExitEntry(String exitEntry) {
        this.exitEntry = exitEntry == null ? null : exitEntry.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCheckById() {
        return checkById;
    }

    public void setCheckById(String checkById) {
        this.checkById = checkById == null ? null : checkById.trim();
    }

    public String getCheckByName() {
        return checkByName;
    }

    public void setCheckByName(String checkByName) {
        this.checkByName = checkByName == null ? null : checkByName.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public BigDecimal getUpdateNum() {
        return updateNum;
    }

    public void setUpdatNum(BigDecimal updateNum) {
        this.updateNum = updateNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
    }

    public String getIsExport() {
        return isExport;
    }

    public void setIsExport(String isExport) {
        this.isExport = isExport;
    }
}