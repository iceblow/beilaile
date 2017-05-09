package com.warehouse.entity;

import java.io.Serializable;

public class PrintingAndEmbroideredOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4314073537337958669L;

	private Integer id;// 序号

	private String wave;// 波次号

	private String productCoed;// 商品编号

	private String designer;// 设计师

	private String referencePrinting;// 参考印花

	private String designImg;// 设计图

	private String sampleImg;// 工艺单

	private String patternCraftsOrder;// 图样工艺单

	private String orderDetails;// 订单明细(尺码详情)

	private Integer orders;// 订单数量

	private String printingOrEmbroidered;// 是否有印绣花

	private String ifPrinting;// 是匹印

	private String fabricA;// 面料A匹印

	private String fabricB;// 面料B匹印

	private String fabricC;// 面料C匹印

	private String fabricD;// 面料D匹印

	private String fabricE;// 面料E匹印

	private String requirePrinting;// 匹印要求

	private String ifSlice;// 是否片印

	private String sliceAddress;// 片印位置

	private String requireSlice;// 片印要求

	private String ifEmbroider;// 是否绣花

	private String embroiderAddress;// 绣花位置

	private String requireEmbroider;// 绣花要求

	private String completeOrder;// 理单完成

	private String completeOrderTime;// 理单完成时间

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
		this.wave = wave == null ? null : wave.trim();
	}

	public String getProductCoed() {
		return productCoed;
	}

	public void setProductCoed(String productCoed) {
		this.productCoed = productCoed == null ? null : productCoed.trim();
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer == null ? null : designer.trim();
	}

	public String getReferencePrinting() {
		return referencePrinting;
	}

	public void setReferencePrinting(String referencePrinting) {
		this.referencePrinting = referencePrinting == null ? null : referencePrinting.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getSampleImg() {
		return sampleImg;
	}

	public void setSampleImg(String sampleImg) {
		this.sampleImg = sampleImg == null ? null : sampleImg.trim();
	}

	public String getPatternCraftsOrder() {
		return patternCraftsOrder;
	}

	public void setPatternCraftsOrder(String patternCraftsOrder) {
		this.patternCraftsOrder = patternCraftsOrder == null ? null : patternCraftsOrder.trim();
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails == null ? null : orderDetails.trim();
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getPrintingOrEmbroidered() {
		return printingOrEmbroidered;
	}

	public void setPrintingOrEmbroidered(String printingOrEmbroidered) {
		this.printingOrEmbroidered = printingOrEmbroidered == null ? null : printingOrEmbroidered.trim();
	}

	public String getIfPrinting() {
		return ifPrinting;
	}

	public void setIfPrinting(String ifPrinting) {
		this.ifPrinting = ifPrinting == null ? null : ifPrinting.trim();
	}

	public String getFabricA() {
		return fabricA;
	}

	public void setFabricA(String fabricA) {
		this.fabricA = fabricA == null ? null : fabricA.trim();
	}

	public String getFabricB() {
		return fabricB;
	}

	public void setFabricB(String fabricB) {
		this.fabricB = fabricB == null ? null : fabricB.trim();
	}

	public String getFabricC() {
		return fabricC;
	}

	public void setFabricC(String fabricC) {
		this.fabricC = fabricC == null ? null : fabricC.trim();
	}

	public String getFabricD() {
		return fabricD;
	}

	public void setFabricD(String fabricD) {
		this.fabricD = fabricD == null ? null : fabricD.trim();
	}

	public String getFabricE() {
		return fabricE;
	}

	public void setFabricE(String fabricE) {
		this.fabricE = fabricE == null ? null : fabricE.trim();
	}

	public String getRequirePrinting() {
		return requirePrinting;
	}

	public void setRequirePrinting(String requirePrinting) {
		this.requirePrinting = requirePrinting == null ? null : requirePrinting.trim();
	}

	public String getIfSlice() {
		return ifSlice;
	}

	public void setIfSlice(String ifSlice) {
		this.ifSlice = ifSlice == null ? null : ifSlice.trim();
	}

	public String getSliceAddress() {
		return sliceAddress;
	}

	public void setSliceAddress(String sliceAddress) {
		this.sliceAddress = sliceAddress == null ? null : sliceAddress.trim();
	}

	public String getRequireSlice() {
		return requireSlice;
	}

	public void setRequireSlice(String requireSlice) {
		this.requireSlice = requireSlice == null ? null : requireSlice.trim();
	}

	public String getIfEmbroider() {
		return ifEmbroider;
	}

	public void setIfEmbroider(String ifEmbroider) {
		this.ifEmbroider = ifEmbroider == null ? null : ifEmbroider.trim();
	}

	public String getEmbroiderAddress() {
		return embroiderAddress;
	}

	public void setEmbroiderAddress(String embroiderAddress) {
		this.embroiderAddress = embroiderAddress == null ? null : embroiderAddress.trim();
	}

	public String getRequireEmbroider() {
		return requireEmbroider;
	}

	public void setRequireEmbroider(String requireEmbroider) {
		this.requireEmbroider = requireEmbroider == null ? null : requireEmbroider.trim();
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder == null ? null : completeOrder.trim();
	}

	public String getCompleteOrderTime() {
		return completeOrderTime;
	}

	public void setCompleteOrderTime(String completeOrderTime) {
		this.completeOrderTime = completeOrderTime == null ? null : completeOrderTime.trim();
	}

	@Override
	public String toString() {
		return "PrintingAndEmbroideredOrder [id=" + id + ", wave=" + wave + ", productCoed=" + productCoed
				+ ", designer=" + designer + ", referencePrinting=" + referencePrinting + ", designImg=" + designImg
				+ ", sampleImg=" + sampleImg + ", patternCraftsOrder=" + patternCraftsOrder + ", orderDetails="
				+ orderDetails + ", orders=" + orders + ", printingOrEmbroidered=" + printingOrEmbroidered
				+ ", ifPrinting=" + ifPrinting + ", fabricA=" + fabricA + ", fabricB=" + fabricB + ", fabricC="
				+ fabricC + ", fabricD=" + fabricD + ", fabricE=" + fabricE + ", requirePrinting=" + requirePrinting
				+ ", ifSlice=" + ifSlice + ", sliceAddress=" + sliceAddress + ", requireSlice=" + requireSlice
				+ ", ifEmbroider=" + ifEmbroider + ", embroiderAddress=" + embroiderAddress + ", requireEmbroider="
				+ requireEmbroider + ", completeOrder=" + completeOrder + ", completeOrderTime=" + completeOrderTime
				+ "]";
	}

	public PrintingAndEmbroideredOrder(int begin, int end, PrintingAndEmbroideredOrder printingAndEmbroideredOrder) {
		super();
		this.wave=printingAndEmbroideredOrder.getWave();
		this.productCoed=printingAndEmbroideredOrder.getProductCoed();
		this.ifPrinting=printingAndEmbroideredOrder.getIfPrinting();//需要匹印
		this.ifSlice=printingAndEmbroideredOrder.getIfSlice();//需要片印
		this.ifEmbroider=printingAndEmbroideredOrder.getIfEmbroider();//需要绣花
		this.begin = begin;
		this.end = end;
	}

	public PrintingAndEmbroideredOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

}