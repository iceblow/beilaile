package com.warehouse.entity;

import java.io.Serializable;

public class TaisanTrackingOutflow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5190457031797962015L;

	private String wave;// 波次号

	private String productCode;// 商品编号

	private String craftsOrder;// 工艺单

	private String oringinalWave;// 原波次

	private String versionReferenceWave;// 版型参考波次

	private String printingReferenceWave;// 印花参考波次

	private String designImg;// 商品图片

	private String cuttingDate;// 裁剪日期

	private Integer cuttingNum;// 裁剪数

	private String cuttingMan;// 裁剪人

	private String flowerType;// 印花类型

	private String cutLargeReceiveDate;// 片印领料日期

	private String cutLargeReturnDate;// 片印回料日期

	private String flowerFactory;// 印花工厂

	private String factory;// 车缝工厂--

	private String arrangeFabricAndAssistMaterial;// 安排裁片和辅料--

	private String arrangeFabricAndAssistMaterialTime;// 安排裁片和辅料时间

	private String assistMaterialReady;// 辅料就绪--

	private String assistMaterialReadyTime;// 辅料就绪时间

	private String cuttingPieceReady;// 裁片就绪--

	private String cuttingPieceReadyTime;// 裁片就绪时间

	private String informFactory;// 通知工厂--

	private String informFactoryTime;// 通知工厂时间--

	private String assistOut;// 辅料外发--

	private String assistOutTime;// 辅料外发时间

	private String cuttingPieceOut;// 裁片外发--

	private String cuttingPieceOutTime;// 裁片外发时间

	private String rowOfSingleAgain;// 重新排单

	private int begin;

	private int end;

	public TaisanTrackingOutflow(int begin, int end, TaisanTrackingOutflow taisanTrackingOutflow) {
		super();
		this.wave = taisanTrackingOutflow.getWave();
		this.productCode = taisanTrackingOutflow.getProductCode();
		this.craftsOrder = taisanTrackingOutflow.getCraftsOrder();
		this.oringinalWave = taisanTrackingOutflow.getOringinalWave();
		this.versionReferenceWave = taisanTrackingOutflow.getVersionReferenceWave();
		this.printingReferenceWave = taisanTrackingOutflow.getPrintingReferenceWave();
		this.designImg = taisanTrackingOutflow.getDesignImg();
		this.cuttingDate = taisanTrackingOutflow.getCuttingDate();
		this.cuttingNum = taisanTrackingOutflow.getCuttingNum();
		this.cuttingMan = taisanTrackingOutflow.getCuttingMan();
		this.flowerType = taisanTrackingOutflow.getFlowerType();
		this.cutLargeReceiveDate = taisanTrackingOutflow.getCutLargeReceiveDate();
		this.cutLargeReturnDate = taisanTrackingOutflow.getCutLargeReturnDate();
		this.flowerFactory = taisanTrackingOutflow.getFlowerFactory();
		this.factory = taisanTrackingOutflow.getFactory();
		this.arrangeFabricAndAssistMaterial = taisanTrackingOutflow.getArrangeFabricAndAssistMaterial();
		this.arrangeFabricAndAssistMaterialTime = taisanTrackingOutflow.getArrangeFabricAndAssistMaterialTime();
		this.assistMaterialReady = taisanTrackingOutflow.getAssistMaterialReady();
		this.assistMaterialReadyTime = taisanTrackingOutflow.getAssistMaterialReadyTime();
		this.cuttingPieceReady = taisanTrackingOutflow.getCuttingPieceReady();
		this.cuttingPieceReadyTime = taisanTrackingOutflow.getCuttingPieceReadyTime();
		this.informFactory = taisanTrackingOutflow.getInformFactory();
		this.informFactoryTime = taisanTrackingOutflow.getInformFactoryTime();
		this.assistOut = taisanTrackingOutflow.getAssistOut();
		this.assistOutTime = taisanTrackingOutflow.getAssistOutTime();
		this.cuttingPieceOut = taisanTrackingOutflow.getCuttingPieceOut();
		this.cuttingPieceOutTime = taisanTrackingOutflow.getCuttingPieceOutTime();
		this.rowOfSingleAgain = taisanTrackingOutflow.getRowOfSingleAgain();
		this.begin = begin;
		this.end = end;
	}

	public String getRowOfSingleAgain() {
		return rowOfSingleAgain;
	}

	public void setRowOfSingleAgain(String rowOfSingleAgain) {
		this.rowOfSingleAgain = rowOfSingleAgain;
	}

	public TaisanTrackingOutflow() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAssistMaterialReady() {
		return assistMaterialReady;
	}

	public void setAssistMaterialReady(String assistMaterialReady) {
		this.assistMaterialReady = assistMaterialReady == null ? null : assistMaterialReady.trim();
	}

	public String getAssistMaterialReadyTime() {
		return assistMaterialReadyTime;
	}

	public void setAssistMaterialReadyTime(String assistMaterialReadyTime) {
		this.assistMaterialReadyTime = assistMaterialReadyTime == null ? null : assistMaterialReadyTime.trim();
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

	public String getInformFactory() {
		return informFactory;
	}

	public void setInformFactory(String informFactory) {
		this.informFactory = informFactory == null ? null : informFactory.trim();
	}

	public String getInformFactoryTime() {
		return informFactoryTime;
	}

	public void setInformFactoryTime(String informFactoryTime) {
		this.informFactoryTime = informFactoryTime == null ? null : informFactoryTime.trim();
	}

	public String getAssistOut() {
		return assistOut;
	}

	public void setAssistOut(String assistOut) {
		this.assistOut = assistOut == null ? null : assistOut.trim();
	}

	public String getAssistOutTime() {
		return assistOutTime;
	}

	public void setAssistOutTime(String assistOutTime) {
		this.assistOutTime = assistOutTime == null ? null : assistOutTime.trim();
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

	@Override
	public String toString() {
		return "TaisanTrackingOutflow [wave=" + wave + ", productCode=" + productCode + ", craftsOrder=" + craftsOrder
				+ ", oringinalWave=" + oringinalWave + ", versionReferenceWave=" + versionReferenceWave
				+ ", printingReferenceWave=" + printingReferenceWave + ", designImg=" + designImg + ", cuttingDate="
				+ cuttingDate + ", cuttingNum=" + cuttingNum + ", cuttingMan=" + cuttingMan + ", flowerType="
				+ flowerType + ", cutLargeReceiveDate=" + cutLargeReceiveDate + ", cutLargeReturnDate="
				+ cutLargeReturnDate + ", flowerFactory=" + flowerFactory + ", factory=" + factory
				+ ", arrangeFabricAndAssistMaterial=" + arrangeFabricAndAssistMaterial
				+ ", arrangeFabricAndAssistMaterialTime=" + arrangeFabricAndAssistMaterialTime
				+ ", assistMaterialReady=" + assistMaterialReady + ", assistMaterialReadyTime="
				+ assistMaterialReadyTime + ", cuttingPieceReady=" + cuttingPieceReady + ", cuttingPieceReadyTime="
				+ cuttingPieceReadyTime + ", informFactory=" + informFactory + ", informFactoryTime="
				+ informFactoryTime + ", assistOut=" + assistOut + ", assistOutTime=" + assistOutTime
				+ ", cuttingPieceOut=" + cuttingPieceOut + ", cuttingPieceOutTime=" + cuttingPieceOutTime
				+ ", rowOfSingleAgain=" + rowOfSingleAgain + "]";
	}

}