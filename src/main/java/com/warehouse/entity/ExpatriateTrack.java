package com.warehouse.entity;

import java.math.BigDecimal;

public class ExpatriateTrack {
    private Integer id;
    private String date;

    private String orderId;

    private String buyerName;

    private String supplierName;

    private String goodName;

    private String fabricWidth;

    private Integer quantity;

    private String unit;

    private String grossWeight;

    private String netWeight;

    private BigDecimal price;

    private BigDecimal totalValue;

    private String type;

    private BigDecimal otherExpenses;

    private String numberLeft;

    private String usageDetail;

    private String remark;

    private String recoedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getFabricWidth() {
        return fabricWidth;
    }

    public void setFabricWidth(String fabricWidth) {
        this.fabricWidth = fabricWidth == null ? null : fabricWidth.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight == null ? null : grossWeight.trim();
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight == null ? null : netWeight.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(BigDecimal otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public String getNumberLeft() {
        return numberLeft;
    }

    public void setNumberLeft(String numberLeft) {
        this.numberLeft = numberLeft == null ? null : numberLeft.trim();
    }

    public String getUsageDetail() {
        return usageDetail;
    }

    public void setUsageDetail(String usageDetail) {
        this.usageDetail = usageDetail == null ? null : usageDetail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRecoedTime() {
        return recoedTime;
    }

    public void setRecoedTime(String recoedTime) {
        this.recoedTime = recoedTime == null ? null : recoedTime.trim();
    }
}