package com.warehouse.entity;

import java.io.Serializable;

/**
 * 匹印加工情况实体
 * 
 * @author admin
 *
 */
public class PrintingProcessCase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8476386756503281119L;

	private Integer id;// 编号

	private String wave;// 波次号

	private String productCode;// 商品编号

	private String designer;// 设计师

	private String referencePrinting;// 参考印花

	private String designImg;// 设计图

	private String sampleImg;// 工艺单

	private String patternCraftsOrder;// 图样工艺单

	private String orderDetails;// 订单详情

	private Integer orders;// 订单数

	private String printingFactory;// 印花工厂

	private String printingFabricArrangeOut;// 匹印领料时间

	private String printingFabricArrangeIn;// 匹印回料时间

	private String require;// 片印要求

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

	public String getPrintingFactory() {
		return printingFactory;
	}

	public void setPrintingFactory(String printingFactory) {
		this.printingFactory = printingFactory == null ? null : printingFactory.trim();
	}

	public String getPrintingFabricArrangeOut() {
		return printingFabricArrangeOut;
	}

	public void setPrintingFabricArrangeOut(String printingFabricArrangeOut) {
		this.printingFabricArrangeOut = printingFabricArrangeOut == null ? null : printingFabricArrangeOut.trim();
	}

	public String getPrintingFabricArrangeIn() {
		return printingFabricArrangeIn;
	}

	public void setPrintingFabricArrangeIn(String printingFabricArrangeIn) {
		this.printingFabricArrangeIn = printingFabricArrangeIn == null ? null : printingFabricArrangeIn.trim();
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require == null ? null : require.trim();
	}

	@Override
	public String toString() {
		return "PrintingProcessCase [id=" + id + ", wave=" + wave + ", productCode=" + productCode + ", designer="
				+ designer + ", referencePrinting=" + referencePrinting + ", designImg=" + designImg + ", sampleImg="
				+ sampleImg + ", patternCraftsOrder=" + patternCraftsOrder + ", orderDetails=" + orderDetails
				+ ", orders=" + orders + ", printingFactory=" + printingFactory + ", printingFabricArrangeOut="
				+ printingFabricArrangeOut + ", printingFabricArrangeIn=" + printingFabricArrangeIn + ", require="
				+ require + "]";
	}

	public PrintingProcessCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrintingProcessCase(int begin, int end, PrintingProcessCase printingProcessCase) {
		super();
		this.wave = printingProcessCase.getWave();// 波次号
		this.productCode = printingProcessCase.getProductCode();// 商品编号
		this.designer = printingProcessCase.getDesigner();// 设计师
		this.referencePrinting = printingProcessCase.getReferencePrinting();// 参考印花
		this.printingFactory = printingProcessCase.getPrintingFactory();// 匹印工厂
		this.printingFabricArrangeOut = printingProcessCase.getPrintingFabricArrangeOut();// 领料时间
		this.printingFabricArrangeIn = printingProcessCase.getPrintingFabricArrangeIn();// 回料时间
		this.require = printingProcessCase.getRequire();// 匹印要求
		this.begin = begin;
		this.end = end;
	}

}