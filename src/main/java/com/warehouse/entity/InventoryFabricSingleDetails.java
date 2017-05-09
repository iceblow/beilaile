package com.warehouse.entity;

public class InventoryFabricSingleDetails {

	private Integer id;

	private String sid;

	private String fabricBarcode;

	private String fabricCode;

	private String fabricName;

	private String supplierName;

	private String fabricUnit;

	private String fabricColor;

	private String fabricStorageTime;

	private String fabricOutTime;

	private Integer fabricAmount;

	private Double fabricWeight;

	private Integer dataStatus;

	private String createTime;

	private String founder;

	private String modifyTime;

	private String modifiedBy;

	private String deleteTime;

	private String deletePeople;

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
		this.sid = sid == null ? null : sid.trim();
	}

	public String getFabricBarcode() {
		return fabricBarcode;
	}

	public void setFabricBarcode(String fabricBarcode) {
		this.fabricBarcode = fabricBarcode == null ? null : fabricBarcode.trim();
	}

	public String getFabricCode() {
		return fabricCode;
	}

	public void setFabricCode(String fabricCode) {
		this.fabricCode = fabricCode == null ? null : fabricCode.trim();
	}

	public String getFabricName() {
		return fabricName;
	}

	public void setFabricName(String fabricName) {
		this.fabricName = fabricName == null ? null : fabricName.trim();
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName == null ? null : supplierName.trim();
	}

	public String getFabricUnit() {
		return fabricUnit;
	}

	public void setFabricUnit(String fabricUnit) {
		this.fabricUnit = fabricUnit == null ? null : fabricUnit.trim();
	}

	public String getFabricColor() {
		return fabricColor;
	}

	public void setFabricColor(String fabricColor) {
		this.fabricColor = fabricColor == null ? null : fabricColor.trim();
	}

	public String getFabricStorageTime() {
		return fabricStorageTime;
	}

	public void setFabricStorageTime(String fabricStorageTime) {
		this.fabricStorageTime = fabricStorageTime == null ? null : fabricStorageTime.trim();
	}

	public String getFabricOutTime() {
		return fabricOutTime;
	}

	public void setFabricOutTime(String fabricOutTime) {
		this.fabricOutTime = fabricOutTime == null ? null : fabricOutTime.trim();
	}

	public Integer getFabricAmount() {
		return fabricAmount;
	}

	public void setFabricAmount(Integer fabricAmount) {
		this.fabricAmount = fabricAmount;
	}

	public Double getFabricWeight() {
		return fabricWeight;
	}

	public void setFabricWeight(Double fabricWeight) {
		this.fabricWeight = fabricWeight;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder == null ? null : founder.trim();
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime == null ? null : modifyTime.trim();
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime == null ? null : deleteTime.trim();
	}

	public String getDeletePeople() {
		return deletePeople;
	}

	public void setDeletePeople(String deletePeople) {
		this.deletePeople = deletePeople == null ? null : deletePeople.trim();
	}

}