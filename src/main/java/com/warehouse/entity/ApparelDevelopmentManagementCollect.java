package com.warehouse.entity;

import java.io.Serializable;

/**
 * 设计师数据汇总
 * 
 * @author admin
 *
 */
public class ApparelDevelopmentManagementCollect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String designer;
	private int total_sum;
	private int girard_count;
	private int sample_img_count;
	private String date;

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public int getTotal_sum() {
		return total_sum;
	}

	public void setTotal_sum(int total_sum) {
		this.total_sum = total_sum;
	}

	public int getGirard_count() {
		return girard_count;
	}

	public void setGirard_count(int girard_count) {
		this.girard_count = girard_count;
	}

	public int getSample_img_count() {
		return sample_img_count;
	}

	public void setSample_img_count(int sample_img_count) {
		this.sample_img_count = sample_img_count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ApparelDevelopmentManagementCollect [designer=" + designer + ", total_sum=" + total_sum
				+ ", girard_count=" + girard_count + ", sample_img_count=" + sample_img_count + ", date=" + date + "]";
	}

	public ApparelDevelopmentManagementCollect() {
		super();
		// TODO Auto-generated constructor stub
	}

}
