package com.warehouse.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 面料到齐实体
 * 
 * @author admin
 *
 */
public class CuttingFabricCompleted implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 807431792269792410L;

	private String wave;// 波次号

	private String productCode;// 商品编号

	private Integer kindsOfFabric;// 面料种类数

	private String image;// 图片

	private String sampleImg;// 工艺单

	private Integer orders;// 订单数

	private String piecesApproved;// 印绣花类型

	private String orderType;// 订单种类

	private String largeCargoTime;// 匹印领料日期

	private String largeCargoCompletionTime;// 匹印完成送回日期

	private String factory;// 车缝工厂

	private String folwerFactory;// 印花工厂

	private String remark;// 备注

	private String fabricFeedback;// 面料反馈

	private String planToGetFabricTime;// 面料安排时间

	private String fabricIsReadyStatus;// 面料准备状态

	private String fabricIsCuttingStatus;// 裁剪状态

	private String fabricIssueStatues;// 面料发放状态
	
	private String cuttingMan;
	
	private String fabricCuttingTime;

	private int begin;

	private int end;
	
	private String existPaperPattern;	//是否有纸样
	

	public String getExistPaperPattern() {
		return existPaperPattern;
	}

	public void setExistPaperPattern(String existPaperPattern) {
		this.existPaperPattern = existPaperPattern;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFabricCuttingTime() {
		return fabricCuttingTime;
	}

	public void setFabricCuttingTime(String fabricCuttingTime) {
		this.fabricCuttingTime = fabricCuttingTime;
	}

	public String getFabricIsCuttingStatus() {
		return fabricIsCuttingStatus;
	}

	public void setFabricIsCuttingStatus(String fabricIsCuttingStatus) {
		this.fabricIsCuttingStatus = fabricIsCuttingStatus;
	}

	public String getFabricIssueStatues() {
		return fabricIssueStatues;
	}

	public void setFabricIssueStatues(String fabricIssueStatues) {
		this.fabricIssueStatues = fabricIssueStatues;
	}

	public String getFabricIsReadyStatus() {
		return fabricIsReadyStatus;
	}

	public void setFabricIsReadyStatus(String fabricIsReadyStatus) {
		this.fabricIsReadyStatus = fabricIsReadyStatus;
	}

	public String getPlanToGetFabricTime() {
		return planToGetFabricTime;
	}

	public void setPlanToGetFabricTime(String planToGetFabricTime) {
		this.planToGetFabricTime = planToGetFabricTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public Integer getKindsOfFabric() {
		return kindsOfFabric;
	}

	public void setKindsOfFabric(Integer kindsOfFabric) {
		this.kindsOfFabric = kindsOfFabric;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getPiecesApproved() {
		return piecesApproved;
	}

	public void setPiecesApproved(String piecesApproved) {
		this.piecesApproved = piecesApproved == null ? null : piecesApproved.trim();
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType == null ? null : orderType.trim();
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

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public String getFolwerFactory() {
		return folwerFactory;
	}

	public void setFolwerFactory(String folwerFactory) {
		this.folwerFactory = folwerFactory == null ? null : folwerFactory.trim();
	}

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

	public String getFabricFeedback() {
		return fabricFeedback;
	}

	public void setFabricFeedback(String fabricFeedback) {
		this.fabricFeedback = fabricFeedback;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSampleImg() {
		return sampleImg;
	}

	public void setSampleImg(String sampleImg) {
		this.sampleImg = sampleImg;
	}
	

	public String getCuttingMan() {
		return cuttingMan;
	}

	public void setCuttingMan(String cuttingMan) {
		this.cuttingMan = cuttingMan;
	}

	@Override
	public String toString() {
		return "CuttingFabricCompleted [wave=" + wave + ", productCode=" + productCode + ", kindsOfFabric="
				+ kindsOfFabric + ", image=" + image + ", sampleImg=" + sampleImg + ", orders=" + orders
				+ ", piecesApproved=" + piecesApproved + ", orderType=" + orderType + ", largeCargoTime="
				+ largeCargoTime + ", largeCargoCompletionTime=" + largeCargoCompletionTime + ", factory=" + factory
				+ ", folwerFactory=" + folwerFactory + ", remark=" + remark + ", fabricFeedback=" + fabricFeedback
				+ ", planToGetFabricTime=" + planToGetFabricTime + ", fabricIsReadyStatus=" + fabricIsReadyStatus
				+ ", fabricIsCuttingStatus=" + fabricIsCuttingStatus + ", fabricIssueStatues=" + fabricIssueStatues
				+ ",cuttingMan=" + cuttingMan + "]";
	}

	public CuttingFabricCompleted(int begin, int end, CuttingFabricCompleted cuttingFabricCompleted) {
		super();
		this.wave = cuttingFabricCompleted.getWave();
		this.kindsOfFabric = cuttingFabricCompleted.getKindsOfFabric();
		this.image = cuttingFabricCompleted.getImage();
		this.orders = cuttingFabricCompleted.getOrders();
		this.piecesApproved = cuttingFabricCompleted.getPiecesApproved();
		this.orderType = cuttingFabricCompleted.getOrderType();
		this.largeCargoTime = cuttingFabricCompleted.getLargeCargoTime();
		this.largeCargoCompletionTime = cuttingFabricCompleted.getLargeCargoCompletionTime();
		this.factory = cuttingFabricCompleted.getFactory();
		this.folwerFactory = cuttingFabricCompleted.getFolwerFactory();
		this.remark = cuttingFabricCompleted.getRemark();
		this.fabricFeedback = cuttingFabricCompleted.getFabricFeedback();
		this.fabricIsReadyStatus = cuttingFabricCompleted.getFabricIsReadyStatus();
		this.fabricIsCuttingStatus = cuttingFabricCompleted.getFabricIsCuttingStatus();// 面料裁剪状态
		this.fabricIssueStatues = cuttingFabricCompleted.getFabricIssueStatues();// 面料发放状态
		this.cuttingMan = cuttingFabricCompleted.getCuttingMan();// 面料发放状态
		this.begin = begin;
		this.end = end;
		this.existPaperPattern=cuttingFabricCompleted.getExistPaperPattern();
	}

	public CuttingFabricCompleted() {
		super();
		// TODO Auto-generated constructor stub
	}

}