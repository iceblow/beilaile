package com.warehouse.entity;

public class AccesOrderSpec {
    /**
     * 指定工厂货架id
     */
    private Integer id;

    /**
     * 订单添加时间
     */
    private String addTime;

    /**
     * 波次
     */
    private String wave;

    /**
     * 原始波次
     */
    private String oriwave;

    /**
     * 订单数
     */
    private Integer orderNum;

    /**
     * 订单详情
     */
    private String orderDetails;

    /**
     * 裁剪详情
     */
    private String cropDetails;

    /**
     * 裁剪数
     */
    private Integer cropNum;

    /**
     * 裁剪日期
     */
    private String cropDate;

    /**
     * 裁剪信息更新日期
     */
    private Integer cropInfoUptt;

    /**
     * 指定工厂
     */
    private String specFctry;

    /**
     * 指定工厂ID
     */
    private String specFctryId;

    /**
     * 指定工厂日期
     */
    private String specFctryDate;

    /**
     * 指定工厂信息更新日期
     */
    private String specFctryInfoUptt;

    /**
     * 辅料1
     */
    private String accesOne;

    /**
     * 辅料1序列号
     */
    private String accesOneSerialNum;

    /**
     * 辅料1数量
     */
    private Double accesOneQuantity;

    /**
     * 辅料1单耗
     */
    private Double accesOneSingleUse;

    /**
     * 辅料1实际消耗数量
     */
    private Integer accesOneActualCspt;

    /**
     * 辅料1损耗率
     */
    private Double accesOneScrapRate;

    /**
     * 辅料1规格描述
     */
    private String accesOneEtalonDescription;

    /**
     * 辅料2
     */
    private String accesTwo;

    /**
     * 辅料2序列号
     */
    private String accesTwoSerialNum;

    /**
     * 辅料2数量
     */
    private Double accesTwoQuantity;

    /**
     * 辅料2单耗
     */
    private Double accesTwoSingleUse;

    /**
     * 辅料2实际消耗
     */
    private Integer accesTwoActualCspt;

    /**
     * 辅料2损耗率
     */
    private Double accesTwoScrapRate;

    /**
     * 辅料2规格描述
     */
    private String accesTwoEtalonDescription;

    /**
     * 辅料3
     */
    private String accesThree;

    /**
     * 辅料3序列号
     */
    private String accesThreeSerialNum;

    /**
     * 辅料3数量
     */
    private Double accesThreeQuantity;

    /**
     * 辅料3单耗
     */
    private Double accesThreeSingleUse;

    /**
     * 辅料3实际消耗量
     */
    private Integer accesThreeActualCspt;

    /**
     * 辅料3损耗率
     */
    private Double accesThreeScrapRate;

    /**
     * 辅料3规格描述
     */
    private String accesThreeEtalonDescription;

    /**
     * 辅料4
     */
    private String accesFour;

    /**
     * 辅料4序列号
     */
    private String accesFourSerialNum;

    /**
     * 辅料4数量
     */
    private Double accesFourQuantity;

    /**
     * 辅料4单耗
     */
    private Double accesFourSingleUse;

    /**
     * 辅料4实际消耗
     */
    private Integer accesFourActualCspt;

    /**
     * 辅料4实际损耗率
     */
    private Double accesFourScrapRate;

    /**
     * 辅料4规格描述
     */
    private String accesFourEtalonDescription;

    /**
     * 辅料5
     */
    private String accesFive;

    /**
     * 辅料5序列号
     */
    private String accesFiveSerialNum;

    /**
     * 辅料5数量
     */
    private Double accesFiveQuantity;

    /**
     * 辅料5单耗
     */
    private Double accesFiveSingleUse;

    /**
     * 辅料5实际消耗
     */
    private Integer accesFiveActualCspt;

    /**
     * 辅料5实际损耗率
     */
    private Double accesFiveScrapRate;

    /**
     * 辅料5实际规格描述
     */
    private String accesFiveEtalonDescription;

    /**
     * 辅料6
     */
    private String accesSix;

    /**
     * 辅料6序列号
     */
    private String accesSixSerialNum;

    /**
     * 辅料6数量
     */
    private Double accesSixQuantity;

    /**
     * 辅料6单耗
     */
    private Double accesSixSingleUse;

    /**
     * 辅料6实际消耗量
     */
    private Integer accesSixActualCspt;

    /**
     * 辅料6损耗率
     */
    private Double accesSixScrapRate;

    /**
     * 辅料6规格描述
     */
    private String accesSixEtalonDescription;

    /**
     * 辅料6同步时间
     */
    private String accesOderSynchTime;

    /**
     * 辅料6准备发放时间
     */
    private String accesReadyDistributeTime;

    /**
     * 辅料6发放时间
     */
    private String accesDisposeTimeCspt;

    /**
     * 辅料流转状态
     */
    private String accesStatus;

    /**
     * 指定工厂备注
     */
    private String accesRemarks;

    /**
     * 指定工厂删除标识
     */
    private String accesMarkStatus;

    /**
     * 创建人
     */
    private String founder;

    /**
     * 修改时间
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
     * 操作人
     */
    private String operator;

    /**
     * 操作人IP
     */
    private String operatorIp;

    /**
     * 操作人总数
     */
    private String sumSort;

    /**
     * 就绪总数
     */
    private String readySumSort;

    /**
     * 指定工厂状态
     */
    private String specStatus;

    /**
     * 指定时间
     */
    private String specTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave == null ? null : wave.trim();
    }

    public String getOriwave() {
        return oriwave;
    }

    public void setOriwave(String oriwave) {
        this.oriwave = oriwave == null ? null : oriwave.trim();
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

    public String getCropDetails() {
        return cropDetails;
    }

    public void setCropDetails(String cropDetails) {
        this.cropDetails = cropDetails == null ? null : cropDetails.trim();
    }

    public Integer getCropNum() {
        return cropNum;
    }

    public void setCropNum(Integer cropNum) {
        this.cropNum = cropNum;
    }

    public String getCropDate() {
        return cropDate;
    }

    public void setCropDate(String cropDate) {
        this.cropDate = cropDate == null ? null : cropDate.trim();
    }

    public Integer getCropInfoUptt() {
        return cropInfoUptt;
    }

    public void setCropInfoUptt(Integer cropInfoUptt) {
        this.cropInfoUptt = cropInfoUptt;
    }

    public String getSpecFctry() {
        return specFctry;
    }

    public void setSpecFctry(String specFctry) {
        this.specFctry = specFctry == null ? null : specFctry.trim();
    }

    public String getSpecFctryId() {
        return specFctryId;
    }

    public void setSpecFctryId(String specFctryId) {
        this.specFctryId = specFctryId == null ? null : specFctryId.trim();
    }

    public String getSpecFctryDate() {
        return specFctryDate;
    }

    public void setSpecFctryDate(String specFctryDate) {
        this.specFctryDate = specFctryDate == null ? null : specFctryDate.trim();
    }

    public String getSpecFctryInfoUptt() {
        return specFctryInfoUptt;
    }

    public void setSpecFctryInfoUptt(String specFctryInfoUptt) {
        this.specFctryInfoUptt = specFctryInfoUptt == null ? null : specFctryInfoUptt.trim();
    }

    public String getAccesOne() {
        return accesOne;
    }

    public void setAccesOne(String accesOne) {
        this.accesOne = accesOne == null ? null : accesOne.trim();
    }

    public String getAccesOneSerialNum() {
        return accesOneSerialNum;
    }

    public void setAccesOneSerialNum(String accesOneSerialNum) {
        this.accesOneSerialNum = accesOneSerialNum == null ? null : accesOneSerialNum.trim();
    }

    public Double getAccesOneQuantity() {
        return accesOneQuantity;
    }

    public void setAccesOneQuantity(Double accesOneQuantity) {
        this.accesOneQuantity = accesOneQuantity;
    }

    public Double getAccesOneSingleUse() {
        return accesOneSingleUse;
    }

    public void setAccesOneSingleUse(Double accesOneSingleUse) {
        this.accesOneSingleUse = accesOneSingleUse;
    }

    public Integer getAccesOneActualCspt() {
        return accesOneActualCspt;
    }

    public void setAccesOneActualCspt(Integer accesOneActualCspt) {
        this.accesOneActualCspt = accesOneActualCspt;
    }

    public Double getAccesOneScrapRate() {
        return accesOneScrapRate;
    }

    public void setAccesOneScrapRate(Double accesOneScrapRate) {
        this.accesOneScrapRate = accesOneScrapRate;
    }

    public String getAccesOneEtalonDescription() {
        return accesOneEtalonDescription;
    }

    public void setAccesOneEtalonDescription(String accesOneEtalonDescription) {
        this.accesOneEtalonDescription = accesOneEtalonDescription == null ? null : accesOneEtalonDescription.trim();
    }

    public String getAccesTwo() {
        return accesTwo;
    }

    public void setAccesTwo(String accesTwo) {
        this.accesTwo = accesTwo == null ? null : accesTwo.trim();
    }

    public String getAccesTwoSerialNum() {
        return accesTwoSerialNum;
    }

    public void setAccesTwoSerialNum(String accesTwoSerialNum) {
        this.accesTwoSerialNum = accesTwoSerialNum == null ? null : accesTwoSerialNum.trim();
    }

    public Double getAccesTwoQuantity() {
        return accesTwoQuantity;
    }

    public void setAccesTwoQuantity(Double accesTwoQuantity) {
        this.accesTwoQuantity = accesTwoQuantity;
    }

    public Double getAccesTwoSingleUse() {
        return accesTwoSingleUse;
    }

    public void setAccesTwoSingleUse(Double accesTwoSingleUse) {
        this.accesTwoSingleUse = accesTwoSingleUse;
    }

    public Integer getAccesTwoActualCspt() {
        return accesTwoActualCspt;
    }

    public void setAccesTwoActualCspt(Integer accesTwoActualCspt) {
        this.accesTwoActualCspt = accesTwoActualCspt;
    }

    public Double getAccesTwoScrapRate() {
        return accesTwoScrapRate;
    }

    public void setAccesTwoScrapRate(Double accesTwoScrapRate) {
        this.accesTwoScrapRate = accesTwoScrapRate;
    }

    public String getAccesTwoEtalonDescription() {
        return accesTwoEtalonDescription;
    }

    public void setAccesTwoEtalonDescription(String accesTwoEtalonDescription) {
        this.accesTwoEtalonDescription = accesTwoEtalonDescription == null ? null : accesTwoEtalonDescription.trim();
    }

    public String getAccesThree() {
        return accesThree;
    }

    public void setAccesThree(String accesThree) {
        this.accesThree = accesThree == null ? null : accesThree.trim();
    }

    public String getAccesThreeSerialNum() {
        return accesThreeSerialNum;
    }

    public void setAccesThreeSerialNum(String accesThreeSerialNum) {
        this.accesThreeSerialNum = accesThreeSerialNum == null ? null : accesThreeSerialNum.trim();
    }

    public Double getAccesThreeQuantity() {
        return accesThreeQuantity;
    }

    public void setAccesThreeQuantity(Double accesThreeQuantity) {
        this.accesThreeQuantity = accesThreeQuantity;
    }

    public Double getAccesThreeSingleUse() {
        return accesThreeSingleUse;
    }

    public void setAccesThreeSingleUse(Double accesThreeSingleUse) {
        this.accesThreeSingleUse = accesThreeSingleUse;
    }

    public Integer getAccesThreeActualCspt() {
        return accesThreeActualCspt;
    }

    public void setAccesThreeActualCspt(Integer accesThreeActualCspt) {
        this.accesThreeActualCspt = accesThreeActualCspt;
    }

    public Double getAccesThreeScrapRate() {
        return accesThreeScrapRate;
    }

    public void setAccesThreeScrapRate(Double accesThreeScrapRate) {
        this.accesThreeScrapRate = accesThreeScrapRate;
    }

    public String getAccesThreeEtalonDescription() {
        return accesThreeEtalonDescription;
    }

    public void setAccesThreeEtalonDescription(String accesThreeEtalonDescription) {
        this.accesThreeEtalonDescription = accesThreeEtalonDescription == null ? null : accesThreeEtalonDescription.trim();
    }

    public String getAccesFour() {
        return accesFour;
    }

    public void setAccesFour(String accesFour) {
        this.accesFour = accesFour == null ? null : accesFour.trim();
    }

    public String getAccesFourSerialNum() {
        return accesFourSerialNum;
    }

    public void setAccesFourSerialNum(String accesFourSerialNum) {
        this.accesFourSerialNum = accesFourSerialNum == null ? null : accesFourSerialNum.trim();
    }

    public Double getAccesFourQuantity() {
        return accesFourQuantity;
    }

    public void setAccesFourQuantity(Double accesFourQuantity) {
        this.accesFourQuantity = accesFourQuantity;
    }

    public Double getAccesFourSingleUse() {
        return accesFourSingleUse;
    }

    public void setAccesFourSingleUse(Double accesFourSingleUse) {
        this.accesFourSingleUse = accesFourSingleUse;
    }

    public Integer getAccesFourActualCspt() {
        return accesFourActualCspt;
    }

    public void setAccesFourActualCspt(Integer accesFourActualCspt) {
        this.accesFourActualCspt = accesFourActualCspt;
    }

    public Double getAccesFourScrapRate() {
        return accesFourScrapRate;
    }

    public void setAccesFourScrapRate(Double accesFourScrapRate) {
        this.accesFourScrapRate = accesFourScrapRate;
    }

    public String getAccesFourEtalonDescription() {
        return accesFourEtalonDescription;
    }

    public void setAccesFourEtalonDescription(String accesFourEtalonDescription) {
        this.accesFourEtalonDescription = accesFourEtalonDescription == null ? null : accesFourEtalonDescription.trim();
    }

    public String getAccesFive() {
        return accesFive;
    }

    public void setAccesFive(String accesFive) {
        this.accesFive = accesFive == null ? null : accesFive.trim();
    }

    public String getAccesFiveSerialNum() {
        return accesFiveSerialNum;
    }

    public void setAccesFiveSerialNum(String accesFiveSerialNum) {
        this.accesFiveSerialNum = accesFiveSerialNum == null ? null : accesFiveSerialNum.trim();
    }

    public Double getAccesFiveQuantity() {
        return accesFiveQuantity;
    }

    public void setAccesFiveQuantity(Double accesFiveQuantity) {
        this.accesFiveQuantity = accesFiveQuantity;
    }

    public Double getAccesFiveSingleUse() {
        return accesFiveSingleUse;
    }

    public void setAccesFiveSingleUse(Double accesFiveSingleUse) {
        this.accesFiveSingleUse = accesFiveSingleUse;
    }

    public Integer getAccesFiveActualCspt() {
        return accesFiveActualCspt;
    }

    public void setAccesFiveActualCspt(Integer accesFiveActualCspt) {
        this.accesFiveActualCspt = accesFiveActualCspt;
    }

    public Double getAccesFiveScrapRate() {
        return accesFiveScrapRate;
    }

    public void setAccesFiveScrapRate(Double accesFiveScrapRate) {
        this.accesFiveScrapRate = accesFiveScrapRate;
    }

    public String getAccesFiveEtalonDescription() {
        return accesFiveEtalonDescription;
    }

    public void setAccesFiveEtalonDescription(String accesFiveEtalonDescription) {
        this.accesFiveEtalonDescription = accesFiveEtalonDescription == null ? null : accesFiveEtalonDescription.trim();
    }

    public String getAccesSix() {
        return accesSix;
    }

    public void setAccesSix(String accesSix) {
        this.accesSix = accesSix == null ? null : accesSix.trim();
    }

    public String getAccesSixSerialNum() {
        return accesSixSerialNum;
    }

    public void setAccesSixSerialNum(String accesSixSerialNum) {
        this.accesSixSerialNum = accesSixSerialNum == null ? null : accesSixSerialNum.trim();
    }

    public Double getAccesSixQuantity() {
        return accesSixQuantity;
    }

    public void setAccesSixQuantity(Double accesSixQuantity) {
        this.accesSixQuantity = accesSixQuantity;
    }

    public Double getAccesSixSingleUse() {
        return accesSixSingleUse;
    }

    public void setAccesSixSingleUse(Double accesSixSingleUse) {
        this.accesSixSingleUse = accesSixSingleUse;
    }

    public Integer getAccesSixActualCspt() {
        return accesSixActualCspt;
    }

    public void setAccesSixActualCspt(Integer accesSixActualCspt) {
        this.accesSixActualCspt = accesSixActualCspt;
    }

    public Double getAccesSixScrapRate() {
        return accesSixScrapRate;
    }

    public void setAccesSixScrapRate(Double accesSixScrapRate) {
        this.accesSixScrapRate = accesSixScrapRate;
    }

    public String getAccesSixEtalonDescription() {
        return accesSixEtalonDescription;
    }

    public void setAccesSixEtalonDescription(String accesSixEtalonDescription) {
        this.accesSixEtalonDescription = accesSixEtalonDescription == null ? null : accesSixEtalonDescription.trim();
    }

    public String getAccesOderSynchTime() {
        return accesOderSynchTime;
    }

    public void setAccesOderSynchTime(String accesOderSynchTime) {
        this.accesOderSynchTime = accesOderSynchTime == null ? null : accesOderSynchTime.trim();
    }

    public String getAccesReadyDistributeTime() {
        return accesReadyDistributeTime;
    }

    public void setAccesReadyDistributeTime(String accesReadyDistributeTime) {
        this.accesReadyDistributeTime = accesReadyDistributeTime == null ? null : accesReadyDistributeTime.trim();
    }

    public String getAccesDisposeTimeCspt() {
        return accesDisposeTimeCspt;
    }

    public void setAccesDisposeTimeCspt(String accesDisposeTimeCspt) {
        this.accesDisposeTimeCspt = accesDisposeTimeCspt == null ? null : accesDisposeTimeCspt.trim();
    }

    public String getAccesStatus() {
        return accesStatus;
    }

    public void setAccesStatus(String accesStatus) {
        this.accesStatus = accesStatus == null ? null : accesStatus.trim();
    }

    public String getAccesRemarks() {
        return accesRemarks;
    }

    public void setAccesRemarks(String accesRemarks) {
        this.accesRemarks = accesRemarks == null ? null : accesRemarks.trim();
    }

    public String getAccesMarkStatus() {
        return accesMarkStatus;
    }

    public void setAccesMarkStatus(String accesMarkStatus) {
        this.accesMarkStatus = accesMarkStatus == null ? null : accesMarkStatus.trim();
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

    public String getSumSort() {
        return sumSort;
    }

    public void setSumSort(String sumSort) {
        this.sumSort = sumSort == null ? null : sumSort.trim();
    }

    public String getReadySumSort() {
        return readySumSort;
    }

    public void setReadySumSort(String readySumSort) {
        this.readySumSort = readySumSort == null ? null : readySumSort.trim();
    }

    public String getSpecStatus() {
        return specStatus;
    }

    public void setSpecStatus(String specStatus) {
        this.specStatus = specStatus == null ? null : specStatus.trim();
    }

    public String getSpecTime() {
        return specTime;
    }

    public void setSpecTime(String specTime) {
        this.specTime = specTime == null ? null : specTime.trim();
    }
}