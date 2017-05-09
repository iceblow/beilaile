package com.warehouse.entity;

import java.math.BigDecimal;

public class AccessoryInfo {
    /**
     * 辅料信息表 id
     */
    private Integer id;

    /**
     * //辅料名称
     */
    private String accesNameAi;

    /**
     * //辅料序列号
     */
    private String accesSerialNumAi;

    /**
     * //辅料条码
     */
    private String accesBarcodeAi;

    /**
     * //辅料缩略表示
     */
    private String accesAcronymAi;

    /**
     * //辅料原始记录方式
     */
    private String accesHistoryCodeAi;

    /**
     * //辅料颜色
     */
    private String accesColorAi;

    /**
     * //辅料长度
     */
    private String accesLengthAi;

    /**
     * //辅料宽度
     */
    private String accesWidthAi;

    /**
     * //辅料重量
     */
    private String accesWeightAi;

    /**
     * //辅料单位
     */
    private String accesUnitAi;

    /**
     * //辅料存储方式
     */
    private String accesStoreMethodAi;

    /**
     * //辅料存储单位
     */
    private String accesStoreUnitAi;

    /**
     * //辅料规格
     */
    private String accesEtalonAi;

    /**
     * //辅料供应商名称
     */
    private String accesSupplierNameAi;

    /**
     * //辅料供应商联系方式
     */
    private String accesSupplierContactAi;

    /**
     * //辅料供应商联系地址
     */
    private String accesSupplierAddressAi;

    /**
     * //辅料供应商供应方式
     */
    private String accesSupplyModeAi;

    /**
     * 辅料图片
     */
    private String accesImgAi;

    /**
     * 历史使用波次
     */
    private String accesHitoryWaveAi;

    /**
     * 参考价格
     */
    private BigDecimal accesReferencePriceAi;

    /**
     * 使用反馈
     */
    private String accesUsingFeedbackAi;

    /**
     * 质量评估
     */
    private Integer accesQualityEvalRefAi;

    /**
     * 合作满意度
     */
    private Integer accesCooperSatisfactionAi;

    /**
     * 备用字段
     */
    private String accesSupplyDegreeAi;

    /**
     * 备用字段
     */
    private String standbyFir;

    /**
     * 备用字段
     */
    private String standbySec;

    /**
     * 备用字段
     */
    private String standbyThr;

    /**
     * 状态
     */
    private String markStatus;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 创建人
     */
    private String founder;

    /**
     * 修改时间
     */
    private String modifyTime;

    /**
     * 删除时间
     */
    private String deleteTime;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作ip
     */
    private String operatorIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccesNameAi() {
        return accesNameAi;
    }

    public void setAccesNameAi(String accesNameAi) {
        this.accesNameAi = accesNameAi == null ? null : accesNameAi.trim();
    }

    public String getAccesSerialNumAi() {
        return accesSerialNumAi;
    }

    public void setAccesSerialNumAi(String accesSerialNumAi) {
        this.accesSerialNumAi = accesSerialNumAi == null ? null : accesSerialNumAi.trim();
    }

    public String getAccesBarcodeAi() {
        return accesBarcodeAi;
    }

    public void setAccesBarcodeAi(String accesBarcodeAi) {
        this.accesBarcodeAi = accesBarcodeAi == null ? null : accesBarcodeAi.trim();
    }

    public String getAccesAcronymAi() {
        return accesAcronymAi;
    }

    public void setAccesAcronymAi(String accesAcronymAi) {
        this.accesAcronymAi = accesAcronymAi == null ? null : accesAcronymAi.trim();
    }

    public String getAccesHistoryCodeAi() {
        return accesHistoryCodeAi;
    }

    public void setAccesHistoryCodeAi(String accesHistoryCodeAi) {
        this.accesHistoryCodeAi = accesHistoryCodeAi == null ? null : accesHistoryCodeAi.trim();
    }

    public String getAccesColorAi() {
        return accesColorAi;
    }

    public void setAccesColorAi(String accesColorAi) {
        this.accesColorAi = accesColorAi == null ? null : accesColorAi.trim();
    }

    public String getAccesLengthAi() {
        return accesLengthAi;
    }

    public void setAccesLengthAi(String accesLengthAi) {
        this.accesLengthAi = accesLengthAi == null ? null : accesLengthAi.trim();
    }

    public String getAccesWidthAi() {
        return accesWidthAi;
    }

    public void setAccesWidthAi(String accesWidthAi) {
        this.accesWidthAi = accesWidthAi == null ? null : accesWidthAi.trim();
    }

    public String getAccesWeightAi() {
        return accesWeightAi;
    }

    public void setAccesWeightAi(String accesWeightAi) {
        this.accesWeightAi = accesWeightAi == null ? null : accesWeightAi.trim();
    }

    public String getAccesUnitAi() {
        return accesUnitAi;
    }

    public void setAccesUnitAi(String accesUnitAi) {
        this.accesUnitAi = accesUnitAi == null ? null : accesUnitAi.trim();
    }

    public String getAccesStoreMethodAi() {
        return accesStoreMethodAi;
    }

    public void setAccesStoreMethodAi(String accesStoreMethodAi) {
        this.accesStoreMethodAi = accesStoreMethodAi == null ? null : accesStoreMethodAi.trim();
    }

    public String getAccesStoreUnitAi() {
        return accesStoreUnitAi;
    }

    public void setAccesStoreUnitAi(String accesStoreUnitAi) {
        this.accesStoreUnitAi = accesStoreUnitAi == null ? null : accesStoreUnitAi.trim();
    }

    public String getAccesEtalonAi() {
        return accesEtalonAi;
    }

    public void setAccesEtalonAi(String accesEtalonAi) {
        this.accesEtalonAi = accesEtalonAi == null ? null : accesEtalonAi.trim();
    }

    public String getAccesSupplierNameAi() {
        return accesSupplierNameAi;
    }

    public void setAccesSupplierNameAi(String accesSupplierNameAi) {
        this.accesSupplierNameAi = accesSupplierNameAi == null ? null : accesSupplierNameAi.trim();
    }

    public String getAccesSupplierContactAi() {
        return accesSupplierContactAi;
    }

    public void setAccesSupplierContactAi(String accesSupplierContactAi) {
        this.accesSupplierContactAi = accesSupplierContactAi == null ? null : accesSupplierContactAi.trim();
    }

    public String getAccesSupplierAddressAi() {
        return accesSupplierAddressAi;
    }

    public void setAccesSupplierAddressAi(String accesSupplierAddressAi) {
        this.accesSupplierAddressAi = accesSupplierAddressAi == null ? null : accesSupplierAddressAi.trim();
    }

    public String getAccesSupplyModeAi() {
        return accesSupplyModeAi;
    }

    public void setAccesSupplyModeAi(String accesSupplyModeAi) {
        this.accesSupplyModeAi = accesSupplyModeAi == null ? null : accesSupplyModeAi.trim();
    }

    public String getAccesImgAi() {
        return accesImgAi;
    }

    public void setAccesImgAi(String accesImgAi) {
        this.accesImgAi = accesImgAi == null ? null : accesImgAi.trim();
    }

    public String getAccesHitoryWaveAi() {
        return accesHitoryWaveAi;
    }

    public void setAccesHitoryWaveAi(String accesHitoryWaveAi) {
        this.accesHitoryWaveAi = accesHitoryWaveAi == null ? null : accesHitoryWaveAi.trim();
    }

    public BigDecimal getAccesReferencePriceAi() {
        return accesReferencePriceAi;
    }

    public void setAccesReferencePriceAi(BigDecimal accesReferencePriceAi) {
        this.accesReferencePriceAi = accesReferencePriceAi;
    }

    public String getAccesUsingFeedbackAi() {
        return accesUsingFeedbackAi;
    }

    public void setAccesUsingFeedbackAi(String accesUsingFeedbackAi) {
        this.accesUsingFeedbackAi = accesUsingFeedbackAi == null ? null : accesUsingFeedbackAi.trim();
    }

    public Integer getAccesQualityEvalRefAi() {
        return accesQualityEvalRefAi;
    }

    public void setAccesQualityEvalRefAi(Integer accesQualityEvalRefAi) {
        this.accesQualityEvalRefAi = accesQualityEvalRefAi;
    }

    public Integer getAccesCooperSatisfactionAi() {
        return accesCooperSatisfactionAi;
    }

    public void setAccesCooperSatisfactionAi(Integer accesCooperSatisfactionAi) {
        this.accesCooperSatisfactionAi = accesCooperSatisfactionAi;
    }

    public String getAccesSupplyDegreeAi() {
        return accesSupplyDegreeAi;
    }

    public void setAccesSupplyDegreeAi(String accesSupplyDegreeAi) {
        this.accesSupplyDegreeAi = accesSupplyDegreeAi == null ? null : accesSupplyDegreeAi.trim();
    }

    public String getStandbyFir() {
        return standbyFir;
    }

    public void setStandbyFir(String standbyFir) {
        this.standbyFir = standbyFir == null ? null : standbyFir.trim();
    }

    public String getStandbySec() {
        return standbySec;
    }

    public void setStandbySec(String standbySec) {
        this.standbySec = standbySec == null ? null : standbySec.trim();
    }

    public String getStandbyThr() {
        return standbyThr;
    }

    public void setStandbyThr(String standbyThr) {
        this.standbyThr = standbyThr == null ? null : standbyThr.trim();
    }

    public String getMarkStatus() {
        return markStatus;
    }

    public void setMarkStatus(String markStatus) {
        this.markStatus = markStatus == null ? null : markStatus.trim();
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
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

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp == null ? null : operatorIp.trim();
    }
}