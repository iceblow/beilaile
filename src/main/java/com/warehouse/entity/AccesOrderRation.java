package com.warehouse.entity;

public class AccesOrderRation {

    /**
     *库存准备id
     */
    private Integer id;

    /**
     *同步时间
     */
    private String scheTime;

    /**
     *波次号
     */
    private String wave;

    /**
     *订单数
     */
    private Integer orderNum;

    /**
     *订单详情
     */
    private String orderDetails;

    /**
     *裁剪数
     */
    private Integer cropNum;

    /**
     *裁剪详情
     */
    private String cropNumDetails;

    /**
     *裁定差
     */
    private Integer numDiff;

    /**
     *订单图片
     */
    private String img;

    /**
     *原始名称
     */
    private String oriName;

    /**
     *辅料名称
     */
    private String accesName;

    /**
     *辅料序列号
     */
    private String accesSerialNum;

    /**
     *辅料数量
     */
    private Double accesQuantity;

    /**
     *辅料单耗
     */
    private Double accesSingleUse;

    /**
     *辅料实际消耗
     */
    private Integer accesActualCspt;

    /**
     *辅料损耗率
     */
    private Double accesScrapRate;

    /**
     *辅料规格描述
     */
    private String accesEtalonDescription;

    /**
     *辅料同步时间
     */
    private String rationSynchTime;

    /**
     *辅料就绪时间
     */
    private String rationReadyTime;

    /**
     *辅料发放时间
     */
    private String rationDisposeTimeCspt;

    /**
     *库存准备状态
     */
    private String rationStatus;

    /**
     *库存备注
     */
    private String rationRemarks;

    /**
     *删除标识
     */
    private String rationMarkStatus;

    /**
     *创建人
     */
    private String founder;

    /**
     *创建时间
     */
    private String createdTime;

    /**
     *修改时间
     */
    private String modifyTime;

    /**
     *删除时间
     */
    private String deleteTime;

    /**
     *操作人员
     */
    private String operator;

    /**
     *操作IP
     */
    private String operatorIp;

    /**
     *准备总数
     */
    private String sumRation;

    /**
     *完成准备总数
     */
    private String readySumRation;

    public String getSumRation() {
        return sumRation;
    }

    public void setSumRation(String sumRation) {
        this.sumRation = sumRation;
    }

    public String getReadySumRation() {
        return readySumRation;
    }

    public void setReadySumRation(String readySumRation) {
        this.readySumRation = readySumRation;
    }

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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails == null ? null : orderDetails.trim();
    }

    public Integer getCropNum() {
        return cropNum;
    }

    public void setCropNum(Integer cropNum) {
        this.cropNum = cropNum;
    }

    public String getCropNumDetails() {
        return cropNumDetails;
    }

    public void setCropNumDetails(String cropNumDetails) {
        this.cropNumDetails = cropNumDetails;
    }

    public Integer getNumDiff() {
        return numDiff;
    }

    public void setNumDiff(Integer numDiff) {
        this.numDiff = numDiff;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public String getAccesName() {
        return accesName;
    }

    public void setAccesName(String accesName) {
        this.accesName = accesName == null ? null : accesName.trim();
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

    public String getRationSynchTime() {
        return rationSynchTime;
    }

    public void setRationSynchTime(String rationSynchTime) {
        this.rationSynchTime = rationSynchTime == null ? null : rationSynchTime.trim();
    }

    public String getRationReadyTime() {
        return rationReadyTime;
    }

    public void setRationReadyTime(String rationReadyTime) {
        this.rationReadyTime = rationReadyTime == null ? null : rationReadyTime.trim();
    }

    public String getRationDisposeTimeCspt() {
        return rationDisposeTimeCspt;
    }

    public void setRationDisposeTimeCspt(String rationDisposeTimeCspt) {
        this.rationDisposeTimeCspt = rationDisposeTimeCspt == null ? null : rationDisposeTimeCspt.trim();
    }

    public String getRationStatus() {
        return rationStatus;
    }

    public void setRationStatus(String rationStatus) {
        this.rationStatus = rationStatus == null ? null : rationStatus.trim();
    }

    public String getRationRemarks() {
        return rationRemarks;
    }

    public void setRationRemarks(String rationRemarks) {
        this.rationRemarks = rationRemarks == null ? null : rationRemarks.trim();
    }

    public String getRationMarkStatus() {
        return rationMarkStatus;
    }

    public void setRationMarkStatus(String rationMarkStatus) {
        this.rationMarkStatus = rationMarkStatus == null ? null : rationMarkStatus.trim();
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