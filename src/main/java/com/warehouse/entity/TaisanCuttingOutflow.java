package com.warehouse.entity;

import java.io.Serializable;

public class TaisanCuttingOutflow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2331300071545062197L;

	private String wave;// 波次号

	private String productCode;// 商品编号

	private String craftsOrder;// 工艺单

	private String oringinalWave;// 原波次

	private String versionReferenceWave;// 版型参考波次

	private String printingReferenceWave;// 印花参考波次

	private String designImg;// 产品图

	private String cuttingDate;// 裁剪日期

	private Integer cuttingNum;// 裁剪数量

	private String cuttingMan;// 裁剪人

	private String flowerType;// 是否片印

	private String cutLargeReceiveDate;// 片印领料日期

	private String cutLargeReturnDate;// 片印回料日期

	private String flowerFactory;// 是否片印

	private String factory;// 车缝工厂

	private String arrangeFabricAndAssistMaterial;// 安排面辅料

	private String arrangeFabricAndAssistMaterialTime;// 安排面辅料时间

	private String cuttingPieceReady;// 裁片就绪

	private String cuttingPieceReadyTime;// 裁片就绪时间

	private String cuttingPieceOut;// 裁片发放

	private String cuttingPieceOutTime;// 裁片发放时间

	private String packets;// 包数

	private String shelves;// 货架
	
	private String rowOfSingleAgain;   //再次排单

	private int begin;

	private int end;

	
	

	@Override
	public String toString() {
		return "TaisanCuttingOutflow [wave=" + wave + ", productCode=" + productCode + ", craftsOrder=" + craftsOrder
				+ ", oringinalWave=" + oringinalWave + ", versionReferenceWave=" + versionReferenceWave
				+ ", printingReferenceWave=" + printingReferenceWave + ", designImg=" + designImg + ", cuttingDate="
				+ cuttingDate + ", cuttingNum=" + cuttingNum + ", cuttingMan=" + cuttingMan + ", flowerType="
				+ flowerType + ", cutLargeReceiveDate=" + cutLargeReceiveDate + ", cutLargeReturnDate="
				+ cutLargeReturnDate + ", flowerFactory=" + flowerFactory + ", factory=" + factory
				+ ", arrangeFabricAndAssistMaterial=" + arrangeFabricAndAssistMaterial
				+ ", arrangeFabricAndAssistMaterialTime=" + arrangeFabricAndAssistMaterialTime + ", cuttingPieceReady="
				+ cuttingPieceReady + ", cuttingPieceReadyTime=" + cuttingPieceReadyTime + ", cuttingPieceOut="
				+ cuttingPieceOut + ", rowOfSingleAgain=" + rowOfSingleAgain + ", cuttingPieceOutTime=" + cuttingPieceOutTime + "]";
	}

	public TaisanCuttingOutflow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaisanCuttingOutflow(int begin, int end, TaisanCuttingOutflow taisanCuttingOutflow) {
		super();
		this.wave = taisanCuttingOutflow.getWave();
		this.factory = taisanCuttingOutflow.getFactory();
		this.arrangeFabricAndAssistMaterialTime = taisanCuttingOutflow.getArrangeFabricAndAssistMaterialTime();
		this.cuttingPieceReady = taisanCuttingOutflow.getCuttingPieceReady();
		this.cuttingPieceOut = taisanCuttingOutflow.getCuttingPieceOut();
		this.rowOfSingleAgain= taisanCuttingOutflow.getRowOfSingleAgain();
		this.begin = begin;
		this.end = end;
	}

	public String getPackets() {
		return packets;
	}

	public void setPackets(String packets) {
		this.packets = packets;
	}

	public String getShelves() {
		return shelves;
	}

	public void setShelves(String shelves) {
		this.shelves = shelves;
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

	public String getCraftsOrder() {
		return craftsOrder;
	}

	public void setCraftsOrder(String craftsOrder) {
		this.craftsOrder = craftsOrder == null ? null : craftsOrder.trim();
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave == null ? null : oringinalWave.trim();
	}

	public String getVersionReferenceWave() {
		return versionReferenceWave;
	}

	public void setVersionReferenceWave(String versionReferenceWave) {
		this.versionReferenceWave = versionReferenceWave == null ? null : versionReferenceWave.trim();
	}

	public String getPrintingReferenceWave() {
		return printingReferenceWave;
	}

	public void setPrintingReferenceWave(String printingReferenceWave) {
		this.printingReferenceWave = printingReferenceWave == null ? null : printingReferenceWave.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getCuttingDate() {
		return cuttingDate;
	}

	public void setCuttingDate(String cuttingDate) {
		this.cuttingDate = cuttingDate == null ? null : cuttingDate.trim();
	}

	public Integer getCuttingNum() {
		return cuttingNum;
	}

	public void setCuttingNum(Integer cuttingNum) {
		this.cuttingNum = cuttingNum;
	}

	public String getCuttingMan() {
		return cuttingMan;
	}

	public void setCuttingMan(String cuttingMan) {
		this.cuttingMan = cuttingMan == null ? null : cuttingMan.trim();
	}

	public String getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType == null ? null : flowerType.trim();
	}

	public String getCutLargeReceiveDate() {
		return cutLargeReceiveDate;
	}

	public void setCutLargeReceiveDate(String cutLargeReceiveDate) {
		this.cutLargeReceiveDate = cutLargeReceiveDate == null ? null : cutLargeReceiveDate.trim();
	}

	public String getCutLargeReturnDate() {
		return cutLargeReturnDate;
	}

	public void setCutLargeReturnDate(String cutLargeReturnDate) {
		this.cutLargeReturnDate = cutLargeReturnDate == null ? null : cutLargeReturnDate.trim();
	}

	public String getFlowerFactory() {
		return flowerFactory;
	}

	public void setFlowerFactory(String flowerFactory) {
		this.flowerFactory = flowerFactory == null ? null : flowerFactory.trim();
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public String getArrangeFabricAndAssistMaterial() {
		return arrangeFabricAndAssistMaterial;
	}

	public void setArrangeFabricAndAssistMaterial(String arrangeFabricAndAssistMaterial) {
		this.arrangeFabricAndAssistMaterial = arrangeFabricAndAssistMaterial == null ? null
				: arrangeFabricAndAssistMaterial.trim();
	}

	public String getArrangeFabricAndAssistMaterialTime() {
		return arrangeFabricAndAssistMaterialTime;
	}

	public void setArrangeFabricAndAssistMaterialTime(String arrangeFabricAndAssistMaterialTime) {
		this.arrangeFabricAndAssistMaterialTime = arrangeFabricAndAssistMaterialTime == null ? null
				: arrangeFabricAndAssistMaterialTime.trim();
	}

	public String getCuttingPieceReady() {
		return cuttingPieceReady;
	}

	public void setCuttingPieceReady(String cuttingPieceReady) {
		this.cuttingPieceReady = cuttingPieceReady == null ? null : cuttingPieceReady.trim();
	}

	public String getCuttingPieceReadyTime() {
		return cuttingPieceReadyTime;
	}

	public void setCuttingPieceReadyTime(String cuttingPieceReadyTime) {
		this.cuttingPieceReadyTime = cuttingPieceReadyTime == null ? null : cuttingPieceReadyTime.trim();
	}

	public String getCuttingPieceOut() {
		return cuttingPieceOut;
	}

	public void setCuttingPieceOut(String cuttingPieceOut) {
		this.cuttingPieceOut = cuttingPieceOut == null ? null : cuttingPieceOut.trim();
	}

	public String getCuttingPieceOutTime() {
		return cuttingPieceOutTime;
	}

	public void setCuttingPieceOutTime(String cuttingPieceOutTime) {
		this.cuttingPieceOutTime = cuttingPieceOutTime == null ? null : cuttingPieceOutTime.trim();
	}
	

	public String getRowOfSingleAgain() {
		return rowOfSingleAgain;
	}

	public void setRowOfSingleAgain(String rowOfSingleAgain) {
		this.rowOfSingleAgain = rowOfSingleAgain;
	}
}