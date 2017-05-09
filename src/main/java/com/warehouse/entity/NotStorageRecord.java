package com.warehouse.entity;

import java.io.Serializable;

public class NotStorageRecord implements Serializable {

	private static final long serialVersionUID = -9200810513889647898L;

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

	private Integer id;
	
	private String problemState;
	
	private String wave;
	
	private String image;		// 图片

	private String factory;

	private String processingType;

	private String materialTime;

	private Integer materialDays;

	private String estimatedDeliveryTime;

	private String problemFeedback;

	private String reasonForDelay;

	private String personInCharge;

	private String storageTime;

	private String memo;

	private String problemSolving;

	private String problemSolvingTime;

	private String addTime;

	private String updateTime;

	private String modifier;

	private String deleteTime;

	private String deletePeople;

	private String completionTime;

	private String completionPeople;

	private String dataState;
	
	private String productCode;		//商品编码
	
	private String productName;		//商品名称
	
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

	public String getProblemState() {
		return problemState;
	}

	public void setProblemState(String problemState) {
		this.problemState = problemState;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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
		this.wave = wave;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getProcessingType() {
		return processingType;
	}

	public void setProcessingType(String processingType) {
		this.processingType = processingType;
	}

	public String getMaterialTime() {
		return materialTime;
	}

	public void setMaterialTime(String materialTime) {
		this.materialTime = materialTime;
	}

	public Integer getMaterialDays() {
		return materialDays;
	}

	public void setMaterialDays(Integer materialDays) {
		this.materialDays = materialDays;
	}

	public String getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
	}

	public String getProblemFeedback() {
		return problemFeedback;
	}

	public void setProblemFeedback(String problemFeedback) {
		this.problemFeedback = problemFeedback;
	}

	public String getReasonForDelay() {
		return reasonForDelay;
	}

	public void setReasonForDelay(String reasonForDelay) {
		this.reasonForDelay = reasonForDelay;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProblemSolving() {
		return problemSolving;
	}

	public void setProblemSolving(String problemSolving) {
		this.problemSolving = problemSolving;
	}

	public String getProblemSolvingTime() {
		return problemSolvingTime;
	}

	public void setProblemSolvingTime(String problemSolvingTime) {
		this.problemSolvingTime = problemSolvingTime;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeletePeople() {
		return deletePeople;
	}

	public void setDeletePeople(String deletePeople) {
		this.deletePeople = deletePeople;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public String getCompletionPeople() {
		return completionPeople;
	}

	public void setCompletionPeople(String completionPeople) {
		this.completionPeople = completionPeople;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	@Override
	public String toString() {
		return "NotStorageRecord [id=" + id + ", productCode=" + productCode + ",productName=" + productName + ",wave=" + wave + ", factory=" + factory + ", processingType="
				+ processingType + ", materialTime=" + materialTime + ", materialDays=" + materialDays
				+ ", estimatedDeliveryTime=" + estimatedDeliveryTime + ", problemFeedback=" + problemFeedback
				+ ", reasonForDelay=" + reasonForDelay + ", personInCharge=" + personInCharge + ", storageTime="
				+ storageTime + ", memo=" + memo + ", problemSolving=" + problemSolving + ", problemSolvingTime="
				+ problemSolvingTime + ", addTime=" + addTime + ", updateTime=" + updateTime + ", modifier=" + modifier
				+ ", deleteTime=" + deleteTime + ", deletePeople=" + deletePeople + ", completionTime=" + completionTime
				+ ", completionPeople=" + completionPeople + ", dataState=" + dataState + " , problemState=" + problemState + " ]";
	}

	public NotStorageRecord() {
		super();
	}

	public NotStorageRecord(int begin, int end, NotStorageRecord notStorageRecord) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = notStorageRecord.getId();
		this.productCode = notStorageRecord.getProductCode();
		this.productName = notStorageRecord.getProductName();
		this.wave = notStorageRecord.getWave();
		this.factory = notStorageRecord.getFactory();
		this.processingType = notStorageRecord.getProcessingType();
		this.materialTime = notStorageRecord.getMaterialTime();
		this.materialDays = notStorageRecord.getMaterialDays();
		this.estimatedDeliveryTime = notStorageRecord.getEstimatedDeliveryTime();
		this.problemFeedback = notStorageRecord.getProblemFeedback();
		this.reasonForDelay = notStorageRecord.getReasonForDelay();
		this.personInCharge = notStorageRecord.getPersonInCharge();
		this.storageTime = notStorageRecord.getStorageTime();
		this.memo = notStorageRecord.getMemo();
		this.problemSolving = notStorageRecord.getProblemSolving();
		this.problemSolvingTime = notStorageRecord.getProblemSolvingTime();
		this.addTime = notStorageRecord.getAddTime();
		this.updateTime = notStorageRecord.getUpdateTime();
		this.modifier = notStorageRecord.getModifier();
		this.deleteTime = notStorageRecord.getDeleteTime();
		this.deletePeople = notStorageRecord.getDeletePeople();
		this.completionTime = notStorageRecord.getCompletionTime();
		this.completionPeople = notStorageRecord.getCompletionPeople();
		this.dataState = notStorageRecord.getDataState();
		this.problemState = notStorageRecord.getProblemState();
	}

}