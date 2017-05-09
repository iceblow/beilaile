package com.warehouse.entity;
/**
 * Created by admin on 2017/1/17.
 */

public class FactoryBacklog {

    private Integer id;//代办事务id
    private String  factoryName;//工厂名称
    private String  factoryPhone;//工厂电话
    private String  factoryTel;//工厂固话
    private Integer factoryId;//工厂id
    private String affairName;//事务名称
    private String affairType;//事物类型
    private String processibleTime;//可处理时间
    private String deadlineTime;//截至时间
    private String handoverInventory;//交接清单
    private String inventoryCode;//清单编码
    private String inventoryWave;//清单波次
    private String completionTime;//完成时间
    private String completionState;//完成状态
    private String contactPersonName;//接洽人姓名
    private String contactPersonPhone;//接洽人电话
    private String standbyFir;//备用字段1
    private String standbySec;//备用字段2
    private String standbyThr;//备用字段3
    private String markStatus;//删除状态
    private String createTime;//创建时间
    private String founder;//创建人
    private String modifyTime;//修改时间
    private String deleteTime;//删除时间
    private String operator;// 操作人
    private String operatorIp;//操作人ip

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryPhone() {
        return factoryPhone;
    }

    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone;
    }

    public String getFactoryTel() {
        return factoryTel;
    }

    public void setFactoryTel(String factoryTel) {
        this.factoryTel = factoryTel;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getAffairName() {
        return affairName;
    }

    public void setAffairName(String affairName) {
        this.affairName = affairName;
    }

    public String getAffairType() {
        return affairType;
    }

    public void setAffairType(String affairType) {
        this.affairType = affairType;
    }

    public String getProcessibleTime() {
        return processibleTime;
    }

    public void setProcessibleTime(String processibleTime) {
        this.processibleTime = processibleTime;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public String getHandoverInventory() {
        return handoverInventory;
    }

    public void setHandoverInventory(String handoverInventory) {
        this.handoverInventory = handoverInventory;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryWave() {
        return inventoryWave;
    }

    public void setInventoryWave(String inventoryWave) {
        this.inventoryWave = inventoryWave;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getCompletionState() {
        return completionState;
    }

    public void setCompletionState(String completionState) {
        this.completionState = completionState;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getStandbyFir() {
        return standbyFir;
    }

    public void setStandbyFir(String standbyFir) {
        this.standbyFir = standbyFir;
    }

    public String getStandbySec() {
        return standbySec;
    }

    public void setStandbySec(String standbySec) {
        this.standbySec = standbySec;
    }

    public String getStandbyThr() {
        return standbyThr;
    }

    public void setStandbyThr(String standbyThr) {
        this.standbyThr = standbyThr;
    }

    public String getMarkStatus() {
        return markStatus;
    }

    public void setMarkStatus(String markStatus) {
        this.markStatus = markStatus;
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

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp;
    }

    @Override
    public String toString() {
        return "FactoryBacklog{" +
                "id=" + id +
                ", factoryName='" + factoryName + '\'' +
                ", factoryPhone='" + factoryPhone + '\'' +
                ", factoryTel='" + factoryTel + '\'' +
                ", factoryId=" + factoryId +
                ", affairName='" + affairName + '\'' +
                ", affairType='" + affairType + '\'' +
                ", processibleTime='" + processibleTime + '\'' +
                ", deadlineTime='" + deadlineTime + '\'' +
                ", handoverInventory='" + handoverInventory + '\'' +
                ", inventoryCode='" + inventoryCode + '\'' +
                ", inventoryWave='" + inventoryWave + '\'' +
                ", completionTime='" + completionTime + '\'' +
                ", completionState='" + completionState + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", contactPersonPhone='" + contactPersonPhone + '\'' +
                ", standbyFir='" + standbyFir + '\'' +
                ", standbySec='" + standbySec + '\'' +
                ", standbyThr='" + standbyThr + '\'' +
                ", markStatus='" + markStatus + '\'' +
                ", createTime='" + createTime + '\'' +
                ", founder='" + founder + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                ", operator='" + operator + '\'' +
                ", operatorIp='" + operatorIp + '\'' +
                '}';
    }
}
