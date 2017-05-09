package com.warehouse.entity;

import java.math.BigDecimal;

public class FabricCodeProcessInformation {
	private Integer id;

	private String productCode;

	private String generateBarcode;

	private String supplierGoodsCode;

	private String wave;

	private String designImg;

	private String craftsOrder;

	private String fabricCode;

	private String fabricMaterial;

	private String colorCardCode;

	private String colorCardName;

	private String colorCode;

	private String fabricColour;

	private String numberOrder;

	private String fabricType;

	private Double parameter;

	private BigDecimal fabricPrices;

	private BigDecimal purchaseDiscount;

	private BigDecimal taxRate;

	private BigDecimal afterTaxPrice;

	private String minimumPurchaseAmount;

	private String scheduledNumber;

	private String kgM;

	private Double actualDosage;

	private String materials;

	private String combinedWave;

	private Double difference;

	private BigDecimal totalMoney;

	private String piecesApproved;

	private String supplierCode;

	private String supplier;

	private String recipient;

	private String recipientAddress;

	private BigDecimal fabricFreight;

	private String remarks;

	private String additionTime;

	private String purchasingOrderTime;

	private String purchasingPaymentTime;

	private String purchasingReceiptTime;

	private String purchasingGiveoutTime;

	private String addTime;

	private String updateTime;

	private String delTime;

	private String delState;

	private String purchasingStatus;

	private int totalCount;

	private double meter;

	private double weight;

	private double totalWeight;

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getMeter() {
		return meter;
	}

	public void setMeter(double meter) {
		this.meter = meter;
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

	public String getGenerateBarcode() {
		return generateBarcode;
	}

	public void setGenerateBarcode(String generateBarcode) {
		this.generateBarcode = generateBarcode == null ? null : generateBarcode
				.trim();
	}

	public String getSupplierGoodsCode() {
		return supplierGoodsCode;
	}

	public void setSupplierGoodsCode(String supplierGoodsCode) {
		this.supplierGoodsCode = supplierGoodsCode == null ? null
				: supplierGoodsCode.trim();
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getCraftsOrder() {
		return craftsOrder;
	}

	public void setCraftsOrder(String craftsOrder) {
		this.craftsOrder = craftsOrder == null ? null : craftsOrder.trim();
	}

	public String getFabricCode() {
		return fabricCode;
	}

	public void setFabricCode(String fabricCode) {
		this.fabricCode = fabricCode == null ? null : fabricCode.trim();
	}

	public String getFabricMaterial() {
		return fabricMaterial;
	}

	public void setFabricMaterial(String fabricMaterial) {
		this.fabricMaterial = fabricMaterial == null ? null : fabricMaterial
				.trim();
	}

	public String getColorCardCode() {
		return colorCardCode;
	}

	public void setColorCardCode(String colorCardCode) {
		this.colorCardCode = colorCardCode == null ? null : colorCardCode
				.trim();
	}

	public String getColorCardName() {
		return colorCardName;
	}

	public void setColorCardName(String colorCardName) {
		this.colorCardName = colorCardName == null ? null : colorCardName
				.trim();
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode == null ? null : colorCode.trim();
	}

	public String getFabricColour() {
		return fabricColour;
	}

	public void setFabricColour(String fabricColour) {
		this.fabricColour = fabricColour == null ? null : fabricColour.trim();
	}

	public String getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(String numberOrder) {
		this.numberOrder = numberOrder == null ? null : numberOrder.trim();
	}

	public String getFabricType() {
		return fabricType;
	}

	public void setFabricType(String fabricType) {
		this.fabricType = fabricType == null ? null : fabricType.trim();
	}

	public Double getParameter() {
		return parameter;
	}

	public void setParameter(Double parameter) {
		this.parameter = parameter;
	}

	public BigDecimal getFabricPrices() {
		return fabricPrices;
	}

	public void setFabricPrices(BigDecimal fabricPrices) {
		this.fabricPrices = fabricPrices;
	}

	public BigDecimal getPurchaseDiscount() {
		return purchaseDiscount;
	}

	public void setPurchaseDiscount(BigDecimal purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getAfterTaxPrice() {
		return afterTaxPrice;
	}

	public void setAfterTaxPrice(BigDecimal afterTaxPrice) {
		this.afterTaxPrice = afterTaxPrice;
	}

	public String getMinimumPurchaseAmount() {
		return minimumPurchaseAmount;
	}

	public void setMinimumPurchaseAmount(String minimumPurchaseAmount) {
		this.minimumPurchaseAmount = minimumPurchaseAmount == null ? null
				: minimumPurchaseAmount.trim();
	}

	public String getScheduledNumber() {
		return scheduledNumber;
	}

	public void setScheduledNumber(String scheduledNumber) {
		this.scheduledNumber = scheduledNumber == null ? null : scheduledNumber
				.trim();
	}

	public String getKgM() {
		return kgM;
	}

	public void setKgM(String kgM) {
		this.kgM = kgM == null ? null : kgM.trim();
	}

	public Double getActualDosage() {
		return actualDosage;
	}

	public void setActualDosage(Double actualDosage) {
		this.actualDosage = actualDosage;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials == null ? null : materials.trim();
	}

	public String getCombinedWave() {
		return combinedWave;
	}

	public void setCombinedWave(String combinedWave) {
		this.combinedWave = combinedWave == null ? null : combinedWave.trim();
	}

	public Double getDifference() {
		return difference;
	}

	public void setDifference(Double difference) {
		this.difference = difference;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getPiecesApproved() {
		return piecesApproved;
	}

	public void setPiecesApproved(String piecesApproved) {
		this.piecesApproved = piecesApproved == null ? null : piecesApproved
				.trim();
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode == null ? null : supplierCode.trim();
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier == null ? null : supplier.trim();
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient == null ? null : recipient.trim();
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress == null ? null
				: recipientAddress.trim();
	}

	public BigDecimal getFabricFreight() {
		return fabricFreight;
	}

	public void setFabricFreight(BigDecimal fabricFreight) {
		this.fabricFreight = fabricFreight;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public String getAdditionTime() {
		return additionTime;
	}

	public void setAdditionTime(String additionTime) {
		this.additionTime = additionTime == null ? null : additionTime.trim();
	}

	public String getPurchasingOrderTime() {
		return purchasingOrderTime;
	}

	public void setPurchasingOrderTime(String purchasingOrderTime) {
		this.purchasingOrderTime = purchasingOrderTime;
	}

	public String getPurchasingPaymentTime() {
		return purchasingPaymentTime;
	}

	public void setPurchasingPaymentTime(String purchasingPaymentTime) {
		this.purchasingPaymentTime = purchasingPaymentTime;
	}

	public String getPurchasingReceiptTime() {
		return purchasingReceiptTime;
	}

	public void setPurchasingReceiptTime(String purchasingReceiptTime) {
		this.purchasingReceiptTime = purchasingReceiptTime;
	}

	public String getPurchasingGiveoutTime() {
		return purchasingGiveoutTime;
	}

	public void setPurchasingGiveoutTime(String purchasingGiveoutTime) {
		this.purchasingGiveoutTime = purchasingGiveoutTime;
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

	public String getDelState() {
		return delState;
	}

	public void setDelState(String delState) {
		this.delState = delState == null ? null : delState.trim();
	}

	public String getPurchasingStatus() {
		return purchasingStatus;
	}

	public void setPurchasingStatus(String purchasingStatus) {
		this.purchasingStatus = purchasingStatus == null ? null
				: purchasingStatus.trim();
	}
}