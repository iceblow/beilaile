package com.warehouse.entity;

public class FinanceAccountReconciliation {

	private Integer id;

	private String wave;

	private String factory;

	private String productCode;

	private String productName;

	private String designImg;

	private String orderType;// 订单类型

	private String reconciliationUtil;// 单位

	private Integer cropNumber;// 裁剪数

	private Integer shipmentNum;// 出货数

	private Double reconciliationUnitPrice;// 价格

	private Double deliveryTotal;// 合计

	private String deviationNum;// 误差数

	private String reconciliationTime;// 对账日期

	private String actualDeliveryNum;// 实际到货数

	private String factoryFeedback;// 工厂反馈

	private String remarks;

	private String addTime;

	private String updateTime;

	private String delTime;

	private String reconciliationStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType == null ? null : orderType.trim();
	}

	public String getReconciliationUtil() {
		return reconciliationUtil;
	}

	public void setReconciliationUtil(String reconciliationUtil) {
		this.reconciliationUtil = reconciliationUtil == null ? null : reconciliationUtil.trim();
	}

	public Integer getCropNumber() {
		return cropNumber;
	}

	public void setCropNumber(Integer cropNumber) {
		this.cropNumber = cropNumber;
	}

	public Integer getShipmentNum() {
		return shipmentNum;
	}

	public void setShipmentNum(Integer shipmentNum) {
		this.shipmentNum = shipmentNum;
	}

	public Double getReconciliationUnitPrice() {
		return reconciliationUnitPrice;
	}

	public void setReconciliationUnitPrice(Double reconciliationUnitPrice) {
		this.reconciliationUnitPrice = reconciliationUnitPrice;
	}

	public Double getDeliveryTotal() {
		return deliveryTotal;
	}

	public void setDeliveryTotal(Double deliveryTotal) {
		this.deliveryTotal = deliveryTotal;
	}

	public String getDeviationNum() {
		return deviationNum;
	}

	public void setDeviationNum(String deviationNum) {
		this.deviationNum = deviationNum == null ? null : deviationNum.trim();
	}

	public String getReconciliationTime() {
		return reconciliationTime;
	}

	public void setReconciliationTime(String reconciliationTime) {
		this.reconciliationTime = reconciliationTime == null ? null : reconciliationTime.trim();
	}

	public String getActualDeliveryNum() {
		return actualDeliveryNum;
	}

	public void setActualDeliveryNum(String actualDeliveryNum) {
		this.actualDeliveryNum = actualDeliveryNum;
	}

	public String getFactoryFeedback() {
		return factoryFeedback;
	}

	public void setFactoryFeedback(String factoryFeedback) {
		this.factoryFeedback = factoryFeedback == null ? null : factoryFeedback.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime == null ? null : delTime.trim();
	}

	public String getReconciliationStatus() {
		return reconciliationStatus;
	}

	public void setReconciliationStatus(String reconciliationStatus) {
		this.reconciliationStatus = reconciliationStatus == null ? null : reconciliationStatus.trim();
	}

	private int begin;

	private int end;

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public FinanceAccountReconciliation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinanceAccountReconciliation(int begin, int end,  String factory,String wave, String productCode,
			String productName, String orderType, String reconciliationTime) {
		super();
		this.begin = begin;
		this.end = end;
		this.wave = wave;
		this.factory = factory;
		this.productCode = productCode;
		this.productName = productName;
		this.orderType = orderType;
		this.reconciliationTime = reconciliationTime;
	}

}