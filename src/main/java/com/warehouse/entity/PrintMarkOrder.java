package com.warehouse.entity;

public class PrintMarkOrder {
	private Integer orderId;

	private String printingFactory;

	private String orderTime;

	private String addTime;

	private String deliveryTime;

	private String revokedTime;

	private String orderRemark;

	private String orderStatus;

	private int begin;

	private int end;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getPrintingFactory() {
		return printingFactory;
	}

	public void setPrintingFactory(String printingFactory) {
		this.printingFactory = printingFactory == null ? null : printingFactory.trim();
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime == null ? null : orderTime.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
	}

	public String getRevokedTime() {
		return revokedTime;
	}

	public void setRevokedTime(String revokedTime) {
		this.revokedTime = revokedTime;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark == null ? null : orderRemark.trim();
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus == null ? null : orderStatus.trim();
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

	public PrintMarkOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrintMarkOrder(int begin, int end, String printingFactory) {
		super();
		this.begin = begin;
		this.end = end;
		this.printingFactory = printingFactory;
	}

}