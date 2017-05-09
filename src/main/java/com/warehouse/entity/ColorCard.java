package com.warehouse.entity;

public class ColorCard {
	private Integer id;

	private String addColorCard;

	private String colorCardCode;

	private String colorCardName;

	private String supplierCode;
	private String supplierName;

	private String createTime;

	private String founder;

	private String modifyTime;

	private String modifyOperator;

	private String deleteTime;

	private String deleteOperator;

	private Integer colorCardStatus;
	private double fabricLength;
	private double gramWeight;
	private double kilogramMeter;
	private String cardCode;

	public double getGramWeight() {
		return gramWeight;
	}

	public void setGramWeight(double gramWeight) {
		this.gramWeight = gramWeight;
	}

	public double getKilogramMeter() {
		return kilogramMeter;
	}

	public void setKilogramMeter(double kilogramMeter) {
		this.kilogramMeter = kilogramMeter;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public double getFabricLength() {
		return fabricLength;
	}

	public void setFabricLength(double fabricLength) {
		this.fabricLength = fabricLength;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddColorCard() {
		return addColorCard;
	}

	public void setAddColorCard(String addColorCard) {
		this.addColorCard = addColorCard;
	}

	public String getColorCardCode() {
		return colorCardCode;
	}

	public void setColorCardCode(String colorCardCode) {
		this.colorCardCode = colorCardCode;
	}

	public String getColorCardName() {
		return colorCardName;
	}

	public void setColorCardName(String colorCardName) {
		this.colorCardName = colorCardName;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getModifyOperator() {
		return modifyOperator;
	}

	public void setModifyOperator(String modifyOperator) {
		this.modifyOperator = modifyOperator;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeleteOperator() {
		return deleteOperator;
	}

	public void setDeleteOperator(String deleteOperator) {
		this.deleteOperator = deleteOperator;
	}

	public Integer getColorCardStatus() {
		return colorCardStatus;
	}

	public void setColorCardStatus(Integer colorCardStatus) {
		this.colorCardStatus = colorCardStatus;
	}

}