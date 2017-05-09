package com.warehouse.entity;

public class DistributionBuyMaterial {
	private Integer id;

	private String productCode;

	private String clothName;

	private String oringinalWave;

	private String wave;

	private String productImg;

	private String sampleImg;

	private String sizeImg;

	private String orderDetails;

	private Integer orderNum;

	private String orderGrade;

	private String orderType;

	private String distributtionFactory;

	private String fabricArriveFactory;

	private String fabricArriveFactoryTime;

	private String accesArriveFactory;

	private String accesArriveFactoryTime;

	private Integer localStatus = 0;

	private String planInWarehouseTime;
	
	private String releaseTime;//下单(发版)时间
    private String remark;//备注
    private String trackingOfficer;//跟踪人
    private String orderId;//下单号
    private String tacheStartTime;//环节开始时间

	public Integer getLocalStatus() {
		return localStatus;
	}

	public void setLocalStatus(Integer localStatus) {
		this.localStatus = localStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
	}

	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName == null ? null : clothName.trim();
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave == null ? null : oringinalWave.trim();
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg == null ? null : productImg.trim();
	}

	public String getSampleImg() {
		return sampleImg;
	}

	public void setSampleImg(String sampleImg) {
		this.sampleImg = sampleImg == null ? null : sampleImg.trim();
	}

	public String getSizeImg() {
		return sizeImg;
	}

	public void setSizeImg(String sizeImg) {
		this.sizeImg = sizeImg == null ? null : sizeImg.trim();
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails == null ? null : orderDetails.trim();
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderGrade() {
		return orderGrade;
	}

	public void setOrderGrade(String orderGrade) {
		this.orderGrade = orderGrade == null ? null : orderGrade.trim();
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType == null ? null : orderType.trim();
	}

	public String getDistributtionFactory() {
		return distributtionFactory;
	}

	public void setDistributtionFactory(String distributtionFactory) {
		this.distributtionFactory = distributtionFactory == null ? null : distributtionFactory.trim();
	}

	public String getFabricArriveFactory() {
		return fabricArriveFactory;
	}

	public void setFabricArriveFactory(String fabricArriveFactory) {
		this.fabricArriveFactory = fabricArriveFactory == null ? null : fabricArriveFactory.trim();
	}

	public String getFabricArriveFactoryTime() {
		return fabricArriveFactoryTime;
	}

	public void setFabricArriveFactoryTime(String fabricArriveFactoryTime) {
		this.fabricArriveFactoryTime = fabricArriveFactoryTime == null ? null : fabricArriveFactoryTime.trim();
	}

	public String getAccesArriveFactory() {
		return accesArriveFactory;
	}

	public void setAccesArriveFactory(String accesArriveFactory) {
		this.accesArriveFactory = accesArriveFactory == null ? null : accesArriveFactory.trim();
	}

	public String getAccesArriveFactoryTime() {
		return accesArriveFactoryTime;
	}

	public void setAccesArriveFactoryTime(String accesArriveFactoryTime) {
		this.accesArriveFactoryTime = accesArriveFactoryTime == null ? null : accesArriveFactoryTime.trim();
	}

	public String getPlanInWarehouseTime() {
		return planInWarehouseTime;
	}

	public void setPlanInWarehouseTime(String planInWarehouseTime) {
		this.planInWarehouseTime = planInWarehouseTime;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTrackingOfficer() {
		return trackingOfficer;
	}

	public void setTrackingOfficer(String trackingOfficer) {
		this.trackingOfficer = trackingOfficer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTacheStartTime() {
		return tacheStartTime;
	}

	public void setTacheStartTime(String tacheStartTime) {
		this.tacheStartTime = tacheStartTime;
	}

}