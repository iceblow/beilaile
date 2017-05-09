package com.warehouse.entity;

/**
 * @author admin
 *
 */
public class BuildProgressReport {
	private String Name;
	private int[] data;

	private String statistics_date;// 日期
	private int total;// 款式数
	private int number;// 数量
	private String name_type;// 名称

	public String getStatistics_date() {
		return statistics_date;
	}

	public void setStatistics_date(String statistics_date) {
		this.statistics_date = statistics_date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName_type() {
		return name_type;
	}

	public void setName_type(String name_type) {
		this.name_type = name_type;
	}

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

	@Override
	public String toString() {
		return "BuildProgressReport [statistics_date=" + statistics_date + ", total=" + total + ", number=" + number
				+ ", name_type=" + name_type + "]";
	}

	public BuildProgressReport() {
		super();
	}

}
