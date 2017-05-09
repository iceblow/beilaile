package com.warehouse.entity;

public class SewingPickingOrder {
	private Integer orderId;

	private String sewingFactory;

	private String orderTime;

	private String deliveryTime;

	private String orderRemark;

	private String orderStatus;

	private String addTime;

	private String revokedTime;

	private int begin;

	private int end;

	/**
	 * @return
	 */

	public Integer getOrderId() {
		return orderId;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getSewingFactory() {
		return sewingFactory;
	}

	public void setSewingFactory(String sewingFactory) {
		this.sewingFactory = sewingFactory == null ? null : sewingFactory.trim();
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime == null ? null : orderTime.trim();
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
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

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getRevokedTime() {
		return revokedTime;
	}

	public void setRevokedTime(String revokedTime) {
		this.revokedTime = revokedTime;
	}

	public SewingPickingOrder() {
		super();
	}

	public SewingPickingOrder(int begin, int end, String sewingFactory) {
		super();
		this.begin = begin;
		this.end = end;
		this.sewingFactory = sewingFactory;
	}

}