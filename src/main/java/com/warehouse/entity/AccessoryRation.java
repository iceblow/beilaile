package com.warehouse.entity;

/**
 * Created by admin on 2017/1/10.
 */
public class AccessoryRation {
    private Integer id;// 编号

    private String addDate;// 添加时间

    private String wave;// 波次号

    private String oriAccessoriesName;//辅料名称

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

    private String accessoriesName;//辅料名称

    private String accessories;//辅料名称

    private Double accessoriesQuantity;//辅料数量

    private Double accessoriesSingleUse;//辅料单耗

    private Integer accessoriesActualConsumption;//辅料实际用量

    private Double accessoriesScrapRate;//辅料损耗率

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

    public String getAccessoriesName() {
        return accessoriesName;
    }

    public void setAccessoriesName(String accessoriesName) {
        this.accessoriesName = accessoriesName;
    }

    public Double getAccessoriesQuantity() {
        return accessoriesQuantity;
    }

    public void setAccessoriesQuantity(Double accessoriesQuantity) {
        this.accessoriesQuantity = accessoriesQuantity;
    }

    public Double getAccessoriesSingleUse() {
        return accessoriesSingleUse;
    }

    public void setAccessoriesSingleUse(Double accessoriesSingleUse) {
        this.accessoriesSingleUse = accessoriesSingleUse;
    }

    public Integer getAccessoriesActualConsumption() {
        return accessoriesActualConsumption;
    }

    public void setAccessoriesActualConsumption(Integer accessoriesActualConsumption) {
        this.accessoriesActualConsumption = accessoriesActualConsumption;
    }

    public Double getAccessoriesScrapRate() {
        return accessoriesScrapRate;
    }

    public void setAccessoriesScrapRate(Double accessoriesScrapRate) {
        this.accessoriesScrapRate = accessoriesScrapRate;
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
    public String getOriAccessoriesName() {
        return oriAccessoriesName;
    }

    public void setOriAccessoriesName(String oriAccessoriesName) {
        this.oriAccessoriesName = oriAccessoriesName;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }
}
