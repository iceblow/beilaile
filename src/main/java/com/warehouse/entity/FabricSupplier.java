package com.warehouse.entity;

public class FabricSupplier {
    private Integer id;

    private String addNumber;

    private String supplierCode;

    private String supplierName;

    private String supplierAbbreviation;

    private String foreman;

    private String mobile;

    private String supplierAddress;

    private String createTime;

    private String founder;

    private String modifyTime;

    private String modifyOperator;

    private String deleteTime;

    private String deleteOperator;

    private Integer supplierStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(String addNumber) {
        this.addNumber = addNumber == null ? null : addNumber.trim();
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierAbbreviation() {
        return supplierAbbreviation;
    }

    public void setSupplierAbbreviation(String supplierAbbreviation) {
        this.supplierAbbreviation = supplierAbbreviation == null ? null : supplierAbbreviation.trim();
    }

    public String getForeman() {
        return foreman;
    }

    public void setForeman(String foreman) {
        this.foreman = foreman == null ? null : foreman.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
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

    public String getModifyOperator() {
        return modifyOperator;
    }

    public void setModifyOperator(String modifyOperator) {
        this.modifyOperator = modifyOperator == null ? null : modifyOperator.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getDeleteOperator() {
        return deleteOperator;
    }

    public void setDeleteOperator(String deleteOperator) {
        this.deleteOperator = deleteOperator == null ? null : deleteOperator.trim();
    }

    public Integer getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(Integer supplierStatus) {
        this.supplierStatus = supplierStatus;
    }
}