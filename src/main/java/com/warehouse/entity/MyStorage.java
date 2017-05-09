package com.warehouse.entity;

import java.util.Arrays;

public class MyStorage {

	private String Name;
	private int[] data;

	private String sdate;
	private Integer total_delivery;
	private String factory;

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public Integer getTotal_delivery() {
		return total_delivery;
	}

	public void setTotal_delivery(Integer total_delivery) {
		this.total_delivery = total_delivery;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MyStorage [Name=" + Name + ", data=" + Arrays.toString(data) + ", sdate=" + sdate + ", total_delivery="
				+ total_delivery + ", factory=" + factory + "]";
	}

}
