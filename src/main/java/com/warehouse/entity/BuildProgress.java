package com.warehouse.entity;

import java.math.BigDecimal;

public class BuildProgress {
	private Integer id;// 序号 DATEDIFF(CURDATE(),RELEASE_TIME) pelease

	private String designers;// 设计师

	private String referenceWave;// 参照版波

	private String referencePrinting;// 参照印花

	private String craftsOrder;// 工艺单

	private String patternCraftsOrder;// 图样工艺单

	private String sizeChart;// 尺码表

	private String oringinalWave;// 原波次

	private String wave;// 波次

	private String image;// 图片

	private String orders;// 订单

	private String orderDetails;// 订单详情

	private String colour;// 颜色

	private String releaseTime;// 发版时间

	private String piecesApproved;// 印花或裁片

	private String folwerFactory;// 印绣花厂

	private String proofingTime;// 打样时间

	private String proofingCompletionTime;// 打样完成时间

	private String largeCargoTime;// 匹印领料

	private String largeCargoCompletionTime;// 匹印出货

	private String cutLargeReceiveTime;// 片印领料日期

	private String cutLargeReturnTime;// 片印回料日期

	private BigDecimal quot;// 参考价

	private BigDecimal printingPrice;// printingPrice

	private BigDecimal piecesPrice;// 裁片印单价

	private BigDecimal flowerPrice;// 绣花单价

	private String accessoriesPurchasingTime;// 印绣花回样时间

	private String fabricStorageTime;// 面料入库时间

	private String fabricReleaseTime;// 面料发放时间

	private String cuttingTime;// 制单->裁床日期

	private String cropCompletionTime;// 裁剪完成日期

	private String cropNumber;// 裁剪数

	private String factoryPickingTime;// 车缝领料日期

	private String factory;// 车缝工厂

	private String orderType;// 订单类型

	private BigDecimal orderPrice;// 订单价格

	private String plannedShippingTime;// 计划入仓日期

	private String storageTime;// 大货入仓时间

	private String storageNumber;// 大货入库数量

	private String remarks;// 备注

	private String state;// 状态

	private String addTime;// 添加时间

	private String modifyTime;// 修改时间

	private String delTime;// 删除时间

	private Integer sumOrderNumber;// 用来保存总数据的

	private Integer urgentState;// 加急状态
	private String patternCompletionTime;// 纸样完成时间
	private String productCode;//
	private String plateMakingTime; // 制版日期
	private String planFactoryPickingTime;// 安排车缝领料日期

	public String getPlanFactoryPickingTime() {
		return planFactoryPickingTime;
	}

	public void setPlanFactoryPickingTime(String planFactoryPickingTime) {
		this.planFactoryPickingTime = planFactoryPickingTime;
	}

	public String getPlateMakingTime() {
		return plateMakingTime;
	}

	public void setPlateMakingTime(String plateMakingTime) {
		this.plateMakingTime = plateMakingTime;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesigners() {
		return designers;
	}

	public void setDesigners(String designers) {
		this.designers = designers;
	}

	public String getReferenceWave() {
		return referenceWave;
	}

	public void setReferenceWave(String referenceWave) {
		this.referenceWave = referenceWave;
	}

	public String getReferencePrinting() {
		return referencePrinting;
	}

	public void setReferencePrinting(String referencePrinting) {
		this.referencePrinting = referencePrinting;
	}

	public String getCraftsOrder() {
		return craftsOrder;
	}

	public void setCraftsOrder(String craftsOrder) {
		this.craftsOrder = craftsOrder;
	}

	public String getPatternCraftsOrder() {
		return patternCraftsOrder;
	}

	public void setPatternCraftsOrder(String patternCraftsOrder) {
		this.patternCraftsOrder = patternCraftsOrder;
	}

	public String getSizeChart() {
		return sizeChart;
	}

	public void setSizeChart(String sizeChart) {
		this.sizeChart = sizeChart;
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getPiecesApproved() {
		return piecesApproved;
	}

	public void setPiecesApproved(String piecesApproved) {
		this.piecesApproved = piecesApproved;
	}

	public String getFolwerFactory() {
		return folwerFactory;
	}

	public void setFolwerFactory(String folwerFactory) {
		this.folwerFactory = folwerFactory;
	}

	public String getProofingTime() {
		return proofingTime;
	}

	public void setProofingTime(String proofingTime) {
		this.proofingTime = proofingTime;
	}

	public String getProofingCompletionTime() {
		return proofingCompletionTime;
	}

	public void setProofingCompletionTime(String proofingCompletionTime) {
		this.proofingCompletionTime = proofingCompletionTime;
	}

	public String getLargeCargoTime() {
		return largeCargoTime;
	}

	public void setLargeCargoTime(String largeCargoTime) {
		this.largeCargoTime = largeCargoTime;
	}

	public String getLargeCargoCompletionTime() {
		return largeCargoCompletionTime;
	}

	public void setLargeCargoCompletionTime(String largeCargoCompletionTime) {
		this.largeCargoCompletionTime = largeCargoCompletionTime;
	}

	public String getCutLargeReceiveTime() {
		return cutLargeReceiveTime;
	}

	public void setCutLargeReceiveTime(String cutLargeReceiveTime) {
		this.cutLargeReceiveTime = cutLargeReceiveTime;
	}

	public String getCutLargeReturnTime() {
		return cutLargeReturnTime;
	}

	public void setCutLargeReturnTime(String cutLargeReturnTime) {
		this.cutLargeReturnTime = cutLargeReturnTime;
	}

	public BigDecimal getQuot() {
		return quot;
	}

	public void setQuot(BigDecimal quot) {
		this.quot = quot;
	}

	public BigDecimal getPrintingPrice() {
		return printingPrice;
	}

	public void setPrintingPrice(BigDecimal printingPrice) {
		this.printingPrice = printingPrice;
	}

	public BigDecimal getPiecesPrice() {
		return piecesPrice;
	}

	public void setPiecesPrice(BigDecimal piecesPrice) {
		this.piecesPrice = piecesPrice;
	}

	public BigDecimal getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerPrice(BigDecimal flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public String getAccessoriesPurchasingTime() {
		return accessoriesPurchasingTime;
	}

	public void setAccessoriesPurchasingTime(String accessoriesPurchasingTime) {
		this.accessoriesPurchasingTime = accessoriesPurchasingTime;
	}

	public String getFabricStorageTime() {
		return fabricStorageTime;
	}

	public void setFabricStorageTime(String fabricStorageTime) {
		this.fabricStorageTime = fabricStorageTime;
	}

	public String getFabricReleaseTime() {
		return fabricReleaseTime;
	}

	public void setFabricReleaseTime(String fabricReleaseTime) {
		this.fabricReleaseTime = fabricReleaseTime;
	}

	public String getCuttingTime() {
		return cuttingTime;
	}

	public void setCuttingTime(String cuttingTime) {
		this.cuttingTime = cuttingTime;
	}

	public String getCropCompletionTime() {
		return cropCompletionTime;
	}

	public void setCropCompletionTime(String cropCompletionTime) {
		this.cropCompletionTime = cropCompletionTime;
	}

	public String getCropNumber() {
		return cropNumber;
	}

	public void setCropNumber(String cropNumber) {
		this.cropNumber = cropNumber;
	}

	public String getFactoryPickingTime() {
		return factoryPickingTime;
	}

	public void setFactoryPickingTime(String factoryPickingTime) {
		this.factoryPickingTime = factoryPickingTime;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getPlannedShippingTime() {
		return plannedShippingTime;
	}

	public void setPlannedShippingTime(String plannedShippingTime) {
		this.plannedShippingTime = plannedShippingTime;
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}

	public String getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(String storageNumber) {
		this.storageNumber = storageNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	public Integer getSumOrderNumber() {
		return sumOrderNumber;
	}

	public void setSumOrderNumber(Integer sumOrderNumber) {
		this.sumOrderNumber = sumOrderNumber;
	}

	public Integer getUrgentState() {
		return urgentState;
	}

	public void setUrgentState(Integer urgentState) {
		this.urgentState = urgentState;
	}

	public String getPatternCompletionTime() {
		return patternCompletionTime;
	}

	public void setPatternCompletionTime(String patternCompletionTime) {
		this.patternCompletionTime = patternCompletionTime;
	}

}