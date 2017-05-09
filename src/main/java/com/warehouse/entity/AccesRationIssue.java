package com.warehouse.entity;

public class AccesRationIssue {

    /**
     * 配发ID
     */
    private Integer id;

    /**
     * 同步时间
     */
    private String scheTime;

    /**
     * 波次
     */
    private String wave;

    /**
     * 图片
     */
    private String img;

    /**
     * 发放数量
     */
    private Integer issueNum;

    /**
     * 订单详情
     */
    private String orderDetails;

    /**
     * 原始名称
     */
    private String oriName;

    /**
     * 辅料名称
     */
    private String accesName;

    /**
     * 发放总数
     */
    private String sumIssue;

    /**
     * 准备发放数量
     */
    private String readySumIssue;

    /**
     * 辅料序列号
     */
    private String accesSerialNum;

    /**
     * 辅料数量
     */
    private Double accesQuantity;

    /**
     * 辅料单耗
     */
    private Double accesSingleUse;

    /**
     * 辅料实际消耗
     */
    private Integer accesActualCspt;

    /**
     * 辅料损耗率、
     */
    private Double accesScrapRate;

    /**
     * 辅料规格描述
     */
    private String accesEtalonDescription;

    /**
     * 辅料同步时间
     */
    private String synchTime;

    /**
     * 辅料就绪时间
     */
    private String readyTime;

    /**
     * 实际准备就绪时间
     */
    private String disposeTimeCspt;

    /**
     * 发放方式
     */
    private String issueMethod;

    /**
     * 发放状态
     */
    private String issueStatus;

    /**
     * 发放备注
     */
    private String issueRemarks;

    /**
     * 发放删除标识
     */
    private String issueMarkStatus;

    /**
     * 创建人
     */
    private String founder;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 修改时间
     */
    private String modifyTime;

    /**
     * 删除时间
     */
    private String deleteTime;

    /**
     * 操作人员
     */
    private String operator;

    /**
     * 指定工厂状态
     */
    private String operatorIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheTime() {
        return scheTime;
    }

    public void setScheTime(String scheTime) {
        this.scheTime = scheTime == null ? null : scheTime.trim();
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave == null ? null : wave.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(Integer issueNum) {
        this.issueNum = issueNum;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails == null ? null : orderDetails.trim();
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName == null ? null : oriName.trim();
    }

    public String getAccesName() {
        return accesName;
    }

    public void setAccesName(String accesName) {
        this.accesName = accesName == null ? null : accesName.trim();
    }

    public String getSumIssue() {
        return sumIssue;
    }

    public void setSumIssue(String sumIssue) {
        this.sumIssue = sumIssue == null ? null : sumIssue.trim();
    }

    public String getReadySumIssue() {
        return readySumIssue;
    }

    public void setReadySumIssue(String readySumIssue) {
        this.readySumIssue = readySumIssue == null ? null : readySumIssue.trim();
    }

    public String getAccesSerialNum() {
        return accesSerialNum;
    }

    public void setAccesSerialNum(String accesSerialNum) {
        this.accesSerialNum = accesSerialNum == null ? null : accesSerialNum.trim();
    }

    public Double getAccesQuantity() {
        return accesQuantity;
    }

    public void setAccesQuantity(Double accesQuantity) {
        this.accesQuantity = accesQuantity;
    }

    public Double getAccesSingleUse() {
        return accesSingleUse;
    }

    public void setAccesSingleUse(Double accesSingleUse) {
        this.accesSingleUse = accesSingleUse;
    }

    public Integer getAccesActualCspt() {
        return accesActualCspt;
    }

    public void setAccesActualCspt(Integer accesActualCspt) {
        this.accesActualCspt = accesActualCspt;
    }

    public Double getAccesScrapRate() {
        return accesScrapRate;
    }

    public void setAccesScrapRate(Double accesScrapRate) {
        this.accesScrapRate = accesScrapRate;
    }

    public String getAccesEtalonDescription() {
        return accesEtalonDescription;
    }

    public void setAccesEtalonDescription(String accesEtalonDescription) {
        this.accesEtalonDescription = accesEtalonDescription == null ? null : accesEtalonDescription.trim();
    }

    public String getSynchTime() {
        return synchTime;
    }

    public void setSynchTime(String synchTime) {
        this.synchTime = synchTime == null ? null : synchTime.trim();
    }

    public String getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(String readyTime) {
        this.readyTime = readyTime == null ? null : readyTime.trim();
    }

    public String getDisposeTimeCspt() {
        return disposeTimeCspt;
    }

    public void setDisposeTimeCspt(String disposeTimeCspt) {
        this.disposeTimeCspt = disposeTimeCspt == null ? null : disposeTimeCspt.trim();
    }

    public String getIssueMethod() {
        return issueMethod;
    }

    public void setIssueMethod(String issueMethod) {
        this.issueMethod = issueMethod;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus == null ? null : issueStatus.trim();
    }

    public String getIssueRemarks() {
        return issueRemarks;
    }

    public void setIssueRemarks(String issueRemarks) {
        this.issueRemarks = issueRemarks == null ? null : issueRemarks.trim();
    }

    public String getIssueMarkStatus() {
        return issueMarkStatus;
    }

    public void setIssueMarkStatus(String issueMarkStatus) {
        this.issueMarkStatus = issueMarkStatus == null ? null : issueMarkStatus.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp == null ? null : operatorIp.trim();
    }
}