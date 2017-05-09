package com.warehouse.entity;

/**
 * Created by admin on 2017/1/10.
 */
public class AccessoryPurchase {
    private Integer id;// 编号

    private String addDate;// 添加时间

    private String wave;// 波次号

    private Integer numberOrder;// 订单数量

    private String orderDetails;// 订单详情

    private String cropDetails;// 裁剪详情

    private Integer cropNumber;// 裁剪数数量

    private String designChart;// 设计图

    private String craftsOrder;// 工艺单

    private String sizeChart;// 尺码表

    private String editionType;// 版型

    private Integer code52;// 尺码

    private Integer code59;

    private Integer code66;

    private Integer code73;

    private Integer code80;

    private Integer code90;

    private Integer totalCode;// 尺码总数

    private Integer packingBagQuantity;// 包装袋数量

    private Double loss;// 损耗

    private String packingBagSpecification;// 包装袋规格

    private String ingredient;// 成分

    private String popperColor;// 五爪扣色号

    private Integer popperQuantity;// 五爪扣色号

    private Integer popperSingleUse;// 五爪扣色号

    private Integer popperActualConsumption;// 五爪扣色号

    private Double popperScrapRate;//五爪扣损耗率

    private String accessoriesA;// 辅料a

    private Double accessoriesAQuantity;// 辅料a数量

    private Double accessoriesASingleUse;// 辅料a单耗

    private Integer accessoriesAActualConsumption;// 辅料a

    private Double accessoriesScrapRateA;//辅料A损耗率

    private String accessoriesB;

    private Double accessoriesBQuantity;

    private Double accessoriesBSingleUse;

    private Integer accessoriesBActualConsumption;

    private Double accessoriesScrapRateB;//辅料B损耗率

    private String accessoriesC;

    private Double accessoriesCQuantity;

    private Double accessoriesCSingleUse;

    private Integer accessoriesCActualConsumption;

    private Double accessoriesScrapRateC;//辅料C损耗率

    private String remarksRichard;// 理单备注

    private String remarks;// 备注

    private String issuedStatus;// 发放状态（准备就绪/拒绝/已发放）

    private String markStatus;// 删除状态

    private String createdTime;// 创建时间

    private String founder;// 创建人

    private String modifyTime;

    private String deleteTime;

    private String operator;// 操作人

    private String operatorIp;

    private String fabricWarehousDate;// 面料入仓日期
    private String cropDate;// 裁剪日期

    private String specifiesFactory;// 指定工厂

    private String specifiesFactoryDate;// :指定工厂时间

    private Double tagLoss;// 吊牌损耗率

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getCropDetails() {
        return cropDetails;
    }

    public void setCropDetails(String cropDetails) {
        this.cropDetails = cropDetails;
    }

    public Integer getCropNumber() {
        return cropNumber;
    }

    public void setCropNumber(Integer cropNumber) {
        this.cropNumber = cropNumber;
    }

    public String getDesignChart() {
        return designChart;
    }

    public void setDesignChart(String designChart) {
        this.designChart = designChart;
    }

    public String getCraftsOrder() {
        return craftsOrder;
    }

    public void setCraftsOrder(String craftsOrder) {
        this.craftsOrder = craftsOrder;
    }

    public String getSizeChart() {
        return sizeChart;
    }

    public void setSizeChart(String sizeChart) {
        this.sizeChart = sizeChart;
    }

    public String getEditionType() {
        return editionType;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    public Integer getCode52() {
        return code52;
    }

    public void setCode52(Integer code52) {
        this.code52 = code52;
    }

    public Integer getCode59() {
        return code59;
    }

    public void setCode59(Integer code59) {
        this.code59 = code59;
    }

    public Integer getCode66() {
        return code66;
    }

    public void setCode66(Integer code66) {
        this.code66 = code66;
    }

    public Integer getCode73() {
        return code73;
    }

    public void setCode73(Integer code73) {
        this.code73 = code73;
    }

    public Integer getCode80() {
        return code80;
    }

    public void setCode80(Integer code80) {
        this.code80 = code80;
    }

    public Integer getCode90() {
        return code90;
    }

    public void setCode90(Integer code90) {
        this.code90 = code90;
    }

    public Integer getTotalCode() {
        return totalCode;
    }

    public void setTotalCode(Integer totalCode) {
        this.totalCode = totalCode;
    }

    public Integer getPackingBagQuantity() {
        return packingBagQuantity;
    }

    public void setPackingBagQuantity(Integer packingBagQuantity) {
        this.packingBagQuantity = packingBagQuantity;
    }

    public Double getLoss() {
        return loss;
    }

    public void setLoss(Double loss) {
        this.loss = loss;
    }

    public String getPackingBagSpecification() {
        return packingBagSpecification;
    }

    public void setPackingBagSpecification(String packingBagSpecification) {
        this.packingBagSpecification = packingBagSpecification;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPopperColor() {
        return popperColor;
    }

    public void setPopperColor(String popperColor) {
        this.popperColor = popperColor;
    }

    public Integer getPopperQuantity() {
        return popperQuantity;
    }

    public void setPopperQuantity(Integer popperQuantity) {
        this.popperQuantity = popperQuantity;
    }

    public Integer getPopperSingleUse() {
        return popperSingleUse;
    }

    public void setPopperSingleUse(Integer popperSingleUse) {
        this.popperSingleUse = popperSingleUse;
    }

    public Integer getPopperActualConsumption() {
        return popperActualConsumption;
    }

    public void setPopperActualConsumption(Integer popperActualConsumption) {
        this.popperActualConsumption = popperActualConsumption;
    }

    public Double getPopperScrapRate() {
        return popperScrapRate;
    }

    public void setPopperScrapRate(Double popperScrapRate) {
        this.popperScrapRate = popperScrapRate;
    }

    public String getAccessoriesA() {
        return accessoriesA;
    }

    public void setAccessoriesA(String accessoriesA) {
        this.accessoriesA = accessoriesA;
    }

    public Double getAccessoriesAQuantity() {
        return accessoriesAQuantity;
    }

    public void setAccessoriesAQuantity(Double accessoriesAQuantity) {
        this.accessoriesAQuantity = accessoriesAQuantity;
    }

    public Double getAccessoriesASingleUse() {
        return accessoriesASingleUse;
    }

    public void setAccessoriesASingleUse(Double accessoriesASingleUse) {
        this.accessoriesASingleUse = accessoriesASingleUse;
    }

    public Integer getAccessoriesAActualConsumption() {
        return accessoriesAActualConsumption;
    }

    public void setAccessoriesAActualConsumption(Integer accessoriesAActualConsumption) {
        this.accessoriesAActualConsumption = accessoriesAActualConsumption;
    }

    public Double getAccessoriesScrapRateA() {
        return accessoriesScrapRateA;
    }

    public void setAccessoriesScrapRateA(Double accessoriesScrapRateA) {
        this.accessoriesScrapRateA = accessoriesScrapRateA;
    }

    public String getAccessoriesB() {
        return accessoriesB;
    }

    public void setAccessoriesB(String accessoriesB) {
        this.accessoriesB = accessoriesB;
    }

    public Double getAccessoriesBQuantity() {
        return accessoriesBQuantity;
    }

    public void setAccessoriesBQuantity(Double accessoriesBQuantity) {
        this.accessoriesBQuantity = accessoriesBQuantity;
    }

    public Double getAccessoriesBSingleUse() {
        return accessoriesBSingleUse;
    }

    public void setAccessoriesBSingleUse(Double accessoriesBSingleUse) {
        this.accessoriesBSingleUse = accessoriesBSingleUse;
    }

    public Integer getAccessoriesBActualConsumption() {
        return accessoriesBActualConsumption;
    }

    public void setAccessoriesBActualConsumption(Integer accessoriesBActualConsumption) {
        this.accessoriesBActualConsumption = accessoriesBActualConsumption;
    }

    public Double getAccessoriesScrapRateB() {
        return accessoriesScrapRateB;
    }

    public void setAccessoriesScrapRateB(Double accessoriesScrapRateB) {
        this.accessoriesScrapRateB = accessoriesScrapRateB;
    }

    public String getAccessoriesC() {
        return accessoriesC;
    }

    public void setAccessoriesC(String accessoriesC) {
        this.accessoriesC = accessoriesC;
    }

    public Double getAccessoriesCQuantity() {
        return accessoriesCQuantity;
    }

    public void setAccessoriesCQuantity(Double accessoriesCQuantity) {
        this.accessoriesCQuantity = accessoriesCQuantity;
    }

    public Double getAccessoriesCSingleUse() {
        return accessoriesCSingleUse;
    }

    public void setAccessoriesCSingleUse(Double accessoriesCSingleUse) {
        this.accessoriesCSingleUse = accessoriesCSingleUse;
    }

    public Integer getAccessoriesCActualConsumption() {
        return accessoriesCActualConsumption;
    }

    public void setAccessoriesCActualConsumption(Integer accessoriesCActualConsumption) {
        this.accessoriesCActualConsumption = accessoriesCActualConsumption;
    }

    public Double getAccessoriesScrapRateC() {
        return accessoriesScrapRateC;
    }

    public void setAccessoriesScrapRateC(Double accessoriesScrapRateC) {
        this.accessoriesScrapRateC = accessoriesScrapRateC;
    }

    public String getRemarksRichard() {
        return remarksRichard;
    }

    public void setRemarksRichard(String remarksRichard) {
        this.remarksRichard = remarksRichard;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(String issuedStatus) {
        this.issuedStatus = issuedStatus;
    }

    public String getMarkStatus() {
        return markStatus;
    }

    public void setMarkStatus(String markStatus) {
        this.markStatus = markStatus;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp;
    }

    public String getFabricWarehousDate() {
        return fabricWarehousDate;
    }

    public void setFabricWarehousDate(String fabricWarehousDate) {
        this.fabricWarehousDate = fabricWarehousDate;
    }

    public String getCropDate() {
        return cropDate;
    }

    public void setCropDate(String cropDate) {
        this.cropDate = cropDate;
    }

    public String getSpecifiesFactory() {
        return specifiesFactory;
    }

    public void setSpecifiesFactory(String specifiesFactory) {
        this.specifiesFactory = specifiesFactory;
    }

    public String getSpecifiesFactoryDate() {
        return specifiesFactoryDate;
    }

    public void setSpecifiesFactoryDate(String specifiesFactoryDate) {
        this.specifiesFactoryDate = specifiesFactoryDate;
    }

    public Double getTagLoss() {
        return tagLoss;
    }

    public void setTagLoss(Double tagLoss) {
        this.tagLoss = tagLoss;
    }
}
