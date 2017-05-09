package com.warehouse.entity;

import java.io.Serializable;

public class PrintingQuote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3770414783748367774L;

	private Integer id;// 编号

	private String wave;// 波次

	private String productCode;// 商品编号

	private String designer;// 设计师

	private String referencePrinting;// 参考印花

	private String designImg;// 设计图

	private String sampleImg;// 工艺单

	private String patternCraftsOrder;// 图样工艺单

	private String orderDetails;// 订单详情

	private Integer orders;// 订单数

	private String printingType;// 印花类型

	private String printingAddress;// 印花位置

	private String printingRequire;// 印花要求

	private String printingFactory;// 印花工厂

	private String printingUnitPrice;// 印花单价

	private String outSampleDate;// 给样时间

	private String inSampleDate;// 回样时间

	private String confirmPiece;// 确认报价

	private String confirmPieceTime;// 确认报价时间

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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
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

	public String getPrintingType() {
		return printingType;
	}

	public void setPrintingType(String printingType) {
		this.printingType = printingType == null ? null : printingType.trim();
	}

	public String getPrintingAddress() {
		return printingAddress;
	}

	public void setPrintingAddress(String printingAddress) {
		this.printingAddress = printingAddress == null ? null : printingAddress.trim();
	}

	public String getPrintingRequire() {
		return printingRequire;
	}

	public void setPrintingRequire(String printingRequire) {
		this.printingRequire = printingRequire == null ? null : printingRequire.trim();
	}

	public String getPrintingFactory() {
		return printingFactory;
	}

	public void setPrintingFactory(String printingFactory) {
		this.printingFactory = printingFactory == null ? null : printingFactory.trim();
	}

	public String getPrintingUnitPrice() {
		return printingUnitPrice;
	}

	public void setPrintingUnitPrice(String printingUnitPrice) {
		this.printingUnitPrice = printingUnitPrice == null ? null : printingUnitPrice.trim();
	}

	public String getOutSampleDate() {
		return outSampleDate;
	}

	public void setOutSampleDate(String outSampleDate) {
		this.outSampleDate = outSampleDate == null ? null : outSampleDate.trim();
	}

	public String getInSampleDate() {
		return inSampleDate;
	}

	public void setInSampleDate(String inSampleDate) {
		this.inSampleDate = inSampleDate == null ? null : inSampleDate.trim();
	}

	public String getConfirmPiece() {
		return confirmPiece;
	}

	public void setConfirmPiece(String confirmPiece) {
		this.confirmPiece = confirmPiece == null ? null : confirmPiece.trim();
	}

	public String getConfirmPieceTime() {
		return confirmPieceTime;
	}

	public void setConfirmPieceTime(String confirmPieceTime) {
		this.confirmPieceTime = confirmPieceTime == null ? null : confirmPieceTime.trim();
	}

	@Override
	public String toString() {
		return "PrintingQuote [id=" + id + ", wave=" + wave + ", productCode=" + productCode + ", designer=" + designer
				+ ", referencePrinting=" + referencePrinting + ", designImg=" + designImg + ", sampleImg=" + sampleImg
				+ ", patternCraftsOrder=" + patternCraftsOrder + ", orderDetails=" + orderDetails + ", orders=" + orders
				+ ", printingType=" + printingType + ", printingAddress=" + printingAddress + ", printingRequire="
				+ printingRequire + ", printingFactory=" + printingFactory + ", printingUnitPrice=" + printingUnitPrice
				+ ", outSampleDate=" + outSampleDate + ", inSampleDate=" + inSampleDate + ", confirmPiece="
				+ confirmPiece + ", confirmPieceTime=" + confirmPieceTime + "]";
	}

	public PrintingQuote(int begin, int end,PrintingQuote printingQuote) {
		super();
		this.id = printingQuote.getId();
		this.wave = printingQuote.getWave();
		this.productCode = printingQuote.getProductCode();
		this.designer = printingQuote.getDesigner();
		this.referencePrinting = printingQuote.getReferencePrinting();
		this.orderDetails = printingQuote.getOrderDetails();
		this.printingType = printingQuote.getPrintingType();
		this.printingAddress = printingQuote.getPrintingAddress();
		this.printingRequire = printingQuote.getPrintingRequire();
		this.printingFactory = printingQuote.getPrintingFactory();
		this.printingUnitPrice = printingQuote.getPrintingUnitPrice();
		this.outSampleDate = printingQuote.getOutSampleDate();
		this.inSampleDate = printingQuote.getInSampleDate();
		this.confirmPiece = printingQuote.getConfirmPiece();
		this.confirmPieceTime = printingQuote.getConfirmPieceTime();
		this.begin = begin;
		this.end = end;
	}

	public PrintingQuote() {
		super();
		// TODO Auto-generated constructor stub
	}

}