package com.warehouse.entity;

public class ProductOnlineProgress {

	private Integer id;

	private String sid;

	private String wave;

	private String productCode;

	private String productName;

	private String designImg;

	private String orderGrade;// 等级

	private String storageStatus;// 入库

	private String storageTime;

	private String sampleStatus;// 样衣

	private String sampleTime;

	private String photographyStatus;// 拍照

	private String photographyTime;

	private String artworkStatus;// 美工

	private String artworkTime;

	private String operationStatus;// 运营上架

	private String operationTime;

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

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
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
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getOrderGrade() {
		return orderGrade;
	}

	public void setOrderGrade(String orderGrade) {
		this.orderGrade = orderGrade == null ? null : orderGrade.trim();
	}

	public String getStorageStatus() {
		return storageStatus;
	}

	public void setStorageStatus(String storageStatus) {
		this.storageStatus = storageStatus == null ? null : storageStatus.trim();
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime == null ? null : storageTime.trim();
	}

	public String getSampleStatus() {
		return sampleStatus;
	}

	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus == null ? null : sampleStatus.trim();
	}

	public String getSampleTime() {
		return sampleTime;
	}

	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime == null ? null : sampleTime.trim();
	}

	public String getPhotographyStatus() {
		return photographyStatus;
	}

	public void setPhotographyStatus(String photographyStatus) {
		this.photographyStatus = photographyStatus == null ? null : photographyStatus.trim();
	}

	public String getPhotographyTime() {
		return photographyTime;
	}

	public void setPhotographyTime(String photographyTime) {
		this.photographyTime = photographyTime == null ? null : photographyTime.trim();
	}

	public String getArtworkStatus() {
		return artworkStatus;
	}

	public void setArtworkStatus(String artworkStatus) {
		this.artworkStatus = artworkStatus == null ? null : artworkStatus.trim();
	}

	public String getArtworkTime() {
		return artworkTime;
	}

	public void setArtworkTime(String artworkTime) {
		this.artworkTime = artworkTime == null ? null : artworkTime.trim();
	}

	public String getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus == null ? null : operationStatus.trim();
	}

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime == null ? null : operationTime.trim();
	}

	public ProductOnlineProgress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductOnlineProgress(int begin, int end, String wave, String productName, String productCode) {
		super();
		this.begin = begin;
		this.end = end;
		this.wave = wave;
		this.productName = productName;
		this.productCode = productCode;
	}

}