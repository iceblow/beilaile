package com.warehouse.entity;

public class PieceProcessCase {

	private Integer id;// 编号

	private String wave;// 波次

	private String productCode;// 商品编号

	private String designer;// 设计师

	private String referencePrinting;// 参考波次

	private String designImg;// 设计图

	private String sampleImg;// 工艺单

	private String patternCraftsOrder;// 图样工艺单

	private String orderDetails;// 订单详情

	private Integer orders;// 订单数

	private String printingFactory;// 印花工厂

	private String pieceOfPrintingOut;// 片印领料

	private String pieceOfPrintingIn;// 片印回料

	private String require;// 片印要求

	private int begin;

	private int end;

	public PieceProcessCase(int begin, int end, PieceProcessCase pieceProcessCase) {
		super();
		this.id = pieceProcessCase.getId();
		this.wave = pieceProcessCase.getWave();
		this.productCode = pieceProcessCase.getProductCode();
		this.designer = pieceProcessCase.getDesigner();
		this.referencePrinting = pieceProcessCase.getReferencePrinting();
		this.orderDetails = pieceProcessCase.getOrderDetails();
		this.orders = pieceProcessCase.getOrders();
		this.printingFactory = pieceProcessCase.getPrintingFactory();
		this.pieceOfPrintingOut = pieceProcessCase.getPieceOfPrintingOut();
		this.pieceOfPrintingIn = pieceProcessCase.getPieceOfPrintingIn();
		this.require = pieceProcessCase.getRequire();
		this.begin = begin;
		this.end = end;
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

	public String getPrintingFactory() {
		return printingFactory;
	}

	public void setPrintingFactory(String printingFactory) {
		this.printingFactory = printingFactory == null ? null : printingFactory.trim();
	}

	public String getPieceOfPrintingOut() {
		return pieceOfPrintingOut;
	}

	public void setPieceOfPrintingOut(String pieceOfPrintingOut) {
		this.pieceOfPrintingOut = pieceOfPrintingOut == null ? null : pieceOfPrintingOut.trim();
	}

	public String getPieceOfPrintingIn() {
		return pieceOfPrintingIn;
	}

	public void setPieceOfPrintingIn(String pieceOfPrintingIn) {
		this.pieceOfPrintingIn = pieceOfPrintingIn == null ? null : pieceOfPrintingIn.trim();
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require == null ? null : require.trim();
	}

	public PieceProcessCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PieceProcessCase [id=" + id + ", wave=" + wave + ", productCode=" + productCode + ", designer="
				+ designer + ", referencePrinting=" + referencePrinting + ", designImg=" + designImg + ", sampleImg="
				+ sampleImg + ", patternCraftsOrder=" + patternCraftsOrder + ", orderDetails=" + orderDetails
				+ ", orders=" + orders + ", printingFactory=" + printingFactory + ", pieceOfPrintingOut="
				+ pieceOfPrintingOut + ", pieceOfPrintingIn=" + pieceOfPrintingIn + ", require=" + require + "]";
	}

}