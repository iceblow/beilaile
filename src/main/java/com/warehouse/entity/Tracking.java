package com.warehouse.entity;

import java.io.Serializable;

/**
 * 理单跟踪表
 * 
 * @author admin
 *
 */
public class Tracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// 1编号
	private String fabricReserve;// 2面料储备
	private String clippingReserve;// 3裁剪储备
	private String designer;// 4设计师
	private String trackingOfficer;// 5跟踪员
	private String supplier;// 6供货商
	private String b_id;// 7波次号
	private String img;// 8图片
	private String image;// 设计图
	private String color;// 9订单详情
	private String type;// 10类目
	private String publishedTime;// 11板房出版时间
	private String versionTime;// 12发版时间
	private String prenatalSample;// 13产前样时间
	private String orderNum;// 14订单数量
	private String sizeImg;// 15尺码表
	private String printingQuotation;// 16印花报价
	private String estimatedPrice;// 17预估价
	private String costPrice;// 18成本价
	private String component;// 19成分
	private String productionSchedule;// 20业务员校对的目前工厂生产进度
	private String orderType;// 21订单类型
	private String cutNum;// 22裁剪数量
	private String arrivalNumbe;// 23到货数量
	private String delivaTime;// 24交货日期
	private String deliveryConfirmation;// 25货期确认
	private String returnDate;// 26样衣归还日期
	private String releaseTime;// 27发布时间
	private String printingCompleteTime;// 28印绣花完成时间
	private String fabricAndAuxiliaryCompleteTime;// 29面辅料完成时间
	private Integer urgent_state;//加急状态
	private String primaryWave;//原波次
	private String reportShipment;//报告出货量

	private Integer deleteType;// 30删除标识

	private int begin;
	private int end;

	

	public String getReportShipment() {
		return reportShipment;
	}

	public void setReportShipment(String reportShipment) {
		this.reportShipment = reportShipment;
	}

	public String getPrimaryWave() {
		return primaryWave;
	}

	public void setPrimaryWave(String primaryWave) {
		this.primaryWave = primaryWave;
	}

	public Integer getUrgent_state() {
		return urgent_state;
	}

	public void setUrgent_state(Integer urgent_state) {
		this.urgent_state = urgent_state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFabricReserve() {
		return fabricReserve;
	}

	public void setFabricReserve(String fabricReserve) {
		this.fabricReserve = fabricReserve;
	}

	public String getClippingReserve() {
		return clippingReserve;
	}

	public void setClippingReserve(String clippingReserve) {
		this.clippingReserve = clippingReserve;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getTrackingOfficer() {
		return trackingOfficer;
	}

	public void setTrackingOfficer(String trackingOfficer) {
		this.trackingOfficer = trackingOfficer;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getVersionTime() {
		return versionTime;
	}

	public void setVersionTime(String versionTime) {
		this.versionTime = versionTime;
	}

	public String getPrenatalSample() {
		return prenatalSample;
	}

	public void setPrenatalSample(String prenatalSample) {
		this.prenatalSample = prenatalSample;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getSizeImg() {
		return sizeImg;
	}

	public void setSizeImg(String sizeImg) {
		this.sizeImg = sizeImg;
	}

	public String getPrintingQuotation() {
		return printingQuotation;
	}

	public void setPrintingQuotation(String printingQuotation) {
		this.printingQuotation = printingQuotation;
	}

	public String getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(String estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getProductionSchedule() {
		return productionSchedule;
	}

	public void setProductionSchedule(String productionSchedule) {
		this.productionSchedule = productionSchedule;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getCutNum() {
		return cutNum;
	}

	public void setCutNum(String cutNum) {
		this.cutNum = cutNum;
	}

	public String getArrivalNumbe() {
		return arrivalNumbe;
	}

	public void setArrivalNumbe(String arrivalNumbe) {
		this.arrivalNumbe = arrivalNumbe;
	}

	public String getDelivaTime() {
		return delivaTime;
	}

	public void setDelivaTime(String delivaTime) {
		this.delivaTime = delivaTime;
	}

	public String getDeliveryConfirmation() {
		return deliveryConfirmation;
	}

	public void setDeliveryConfirmation(String deliveryConfirmation) {
		this.deliveryConfirmation = deliveryConfirmation;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
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

	public String getPrintingCompleteTime() {
		return printingCompleteTime;
	}

	public void setPrintingCompleteTime(String printingCompleteTime) {
		this.printingCompleteTime = printingCompleteTime;
	}

	public String getFabricAndAuxiliaryCompleteTime() {
		return fabricAndAuxiliaryCompleteTime;
	}

	public void setFabricAndAuxiliaryCompleteTime(String fabricAndAuxiliaryCompleteTime) {
		this.fabricAndAuxiliaryCompleteTime = fabricAndAuxiliaryCompleteTime;
	}

	public Integer getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(Integer deleteType) {
		this.deleteType = deleteType;
	}

	public Tracking(int begin, int end, Tracking tracking) {
		super();
		this.begin = begin;
		this.end = end;
		this.fabricReserve = tracking.getFabricReserve();// 2面料储备
		this.clippingReserve = tracking.getClippingReserve();// 3裁剪储备
		this.trackingOfficer = tracking.getTrackingOfficer();// 5跟踪员
		this.supplier = tracking.getSupplier();// 6供货商
		this.b_id = tracking.getB_id();// 7波次号
		this.type = tracking.getType();// 10类目
		this.publishedTime = tracking.getPublishedTime();// 11板房出版时间
		this.versionTime = tracking.getVersionTime();// 12发版时间
		this.prenatalSample = tracking.getPrenatalSample();// 13产前样时间
		this.estimatedPrice = tracking.getEstimatedPrice();// 17预估价
		this.costPrice = tracking.getCostPrice();// 18成本价(*)
		this.productionSchedule = tracking.getProductionSchedule();// 20业务员校对的目前工厂生产进度(*)
		this.orderType = tracking.getOrderType();// 21订单类型(*)
		this.cutNum = tracking.getCutNum();// 22裁剪数量(*)
		this.arrivalNumbe = tracking.getArrivalNumbe();// 23到货数量(*)
		this.delivaTime = tracking.getDelivaTime();// 24交货日期(*)
		this.deliveryConfirmation = tracking.getDeliveryConfirmation();// 25货期确认(*)
		this.returnDate = tracking.getReturnDate();// 26产前样归还日期(*)
		this.deleteType=tracking.getDeleteType();
		this.primaryWave=tracking.getPrimaryWave();//原波次
	}

	@Override
	public String toString() {
		return "Tracking [id=" + id + ", fabricReserve=" + fabricReserve + ", clippingReserve=" + clippingReserve
				+ ", designer=" + designer + ", trackingOfficer=" + trackingOfficer + ", supplier=" + supplier
				+ ", b_id=" + b_id + ", img=" + img + ", image=" + image + ", color=" + color + ", type=" + type
				+ ", publishedTime=" + publishedTime + ", versionTime=" + versionTime + ", prenatalSample="
				+ prenatalSample + ", orderNum=" + orderNum + ", sizeImg=" + sizeImg + ", printingQuotation="
				+ printingQuotation + ", estimatedPrice=" + estimatedPrice + ", costPrice=" + costPrice + ", component="
				+ component + ", productionSchedule=" + productionSchedule + ", orderType=" + orderType + ", cutNum="
				+ cutNum + ", arrivalNumbe=" + arrivalNumbe + ", delivaTime=" + delivaTime + ", deliveryConfirmation="
				+ deliveryConfirmation + ", returnDate=" + returnDate + ", releaseTime=" + releaseTime
				+ ", printingCompleteTime=" + printingCompleteTime + ", fabricAndAuxiliaryCompleteTime="
				+ fabricAndAuxiliaryCompleteTime + "]";
	}

	public Tracking() {
		super();
		// TODO Auto-generated constructor stub
	}

}
