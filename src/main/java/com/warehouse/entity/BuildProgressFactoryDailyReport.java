package com.warehouse.entity;

public class BuildProgressFactoryDailyReport {

	private String Name;
	private int[] data;

	private String report_date;
	private Integer report_number;
	private String factory;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public Integer getReport_number() {
		return report_number;
	}

	public void setReport_number(Integer report_number) {
		this.report_number = report_number;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	@Override
	public String toString() {
		return "report_date=" + report_date + ", report_number=" + report_number + ", factory=" + factory + "]";
	}

	public BuildProgressFactoryDailyReport() {
		super();
		// TODO Auto-generated constructor stub
	}

}
