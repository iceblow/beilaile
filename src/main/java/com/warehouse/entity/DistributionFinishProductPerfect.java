package com.warehouse.entity;

import java.io.Serializable;

public class DistributionFinishProductPerfect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7910861203089751293L;

	private Integer id;// 序号

	private String productCode;// 商品编号

	private String clothName;// 服装名

	private String oringinalWave;// 原波次

	private String wave;// 波次号

	private String productImg;// 产品图

	private String sampleImg;// 工艺单

	private String sizeImg;// 尺码图

	private String orderDetails;// 订单明细

	private Integer orderNum;// 订单数量

	private String orderGrade;// 订单数量

	private String orderType;// 订单类型

	private String distributtionFactory;// 经销工厂

	private String planInWarehouseTime;// 计划入库时间

	private String factoryReportDeliver;// 工厂报告出货日期

	private String startDeliver;// 开始出货

	private String startDeliverTime;// 开始出货日期

	private String releaseTime;// 下单(发版)时间
	private String remark;// 备注
	private String trackingOfficer;// 跟踪人
	private String orderId;// 下单号
	private String tacheStartTime;// 环节开始时间

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

	public String getPlanInWarehouseTime() {
		return planInWarehouseTime;
	}

	public void setPlanInWarehouseTime(String planInWarehouseTime) {
		this.planInWarehouseTime = planInWarehouseTime == null ? null : planInWarehouseTime.trim();
	}

	public String getFactoryReportDeliver() {
		return factoryReportDeliver;
	}

	public void setFactoryReportDeliver(String factoryReportDeliver) {
		this.factoryReportDeliver = factoryReportDeliver == null ? null : factoryReportDeliver.trim();
	}

	public String getStartDeliver() {
		return startDeliver;
	}

	public void setStartDeliver(String startDeliver) {
		this.startDeliver = startDeliver == null ? null : startDeliver.trim();
	}

	public String getStartDeliverTime() {
		return startDeliverTime;
	}

	public void setStartDeliverTime(String startDeliverTime) {
		this.startDeliverTime = startDeliverTime == null ? null : startDeliverTime.trim();
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

	@Override
	public String toString() {
		return "DistributionFinishProductPerfect [id=" + id + ", productCode=" + productCode + ", clothName="
				+ clothName + ", oringinalWave=" + oringinalWave + ", wave=" + wave + ", productImg=" + productImg
				+ ", sampleImg=" + sampleImg + ", sizeImg=" + sizeImg + ", orderDetails=" + orderDetails + ", orderNum="
				+ orderNum + ", orderGrade=" + orderGrade + ", orderType=" + orderType + ", distributtionFactory="
				+ distributtionFactory + ", planInWarehouseTime=" + planInWarehouseTime + ", factoryReportDeliver="
				+ factoryReportDeliver + ", startDeliver=" + startDeliver + ", startDeliverTime=" + startDeliverTime
				+ "]";
	}

	public DistributionFinishProductPerfect(int begin, int end,
			DistributionFinishProductPerfect distributionFinishProductPerfect) {
		super();
		this.id = distributionFinishProductPerfect.getId();
		this.productCode = distributionFinishProductPerfect.getProductCode();
		this.clothName = distributionFinishProductPerfect.getClothName();
		this.oringinalWave = distributionFinishProductPerfect.getOringinalWave();
		this.wave = distributionFinishProductPerfect.getWave();
		this.productImg = distributionFinishProductPerfect.getProductImg();
		this.sampleImg = distributionFinishProductPerfect.getSampleImg();
		this.sizeImg = distributionFinishProductPerfect.getSizeImg();
		this.orderDetails = distributionFinishProductPerfect.getOrderDetails();
		this.orderNum = distributionFinishProductPerfect.getOrderNum();
		this.orderGrade = distributionFinishProductPerfect.getOrderGrade();
		this.orderType = distributionFinishProductPerfect.getOrderType();
		this.distributtionFactory = distributionFinishProductPerfect.getDistributtionFactory();
		this.planInWarehouseTime = distributionFinishProductPerfect.getPlanInWarehouseTime();
		this.factoryReportDeliver = distributionFinishProductPerfect.getFactoryReportDeliver();
		this.startDeliver = distributionFinishProductPerfect.getStartDeliver();
		this.startDeliverTime = distributionFinishProductPerfect.getStartDeliverTime();
		this.trackingOfficer = distributionFinishProductPerfect.getTrackingOfficer();
		this.begin = begin;
		this.end = end;
	}

	public DistributionFinishProductPerfect() {
		super();
		// TODO Auto-generated constructor stub
	}

}