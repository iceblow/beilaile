package com.warehouse.entity;

import java.io.Serializable;

public class FabricDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8706041676491329211L;

	private String id;// 编号
	private String date;// 添加的日期
	private String b_id;// 波次号
	private String design_img;// 设计图
	private String fabric;// 面料
	private String consumption;// 用量
	private String company;// 单位
	private int delType;// 数据状态 0：未删除，1：已删除
	private String delTime;// 删除的时间
	private String addtime;// 每个产品添加进来的时间(每类产品中每个产品的标识)
	private String mytime;// 某一类产品的操作时间(每类产品的标识)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getDelType() {
		return delType;
	}

	public void setDelType(int delType) {
		this.delType = delType;
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMytime() {
		return mytime;
	}

	public void setMytime(String mytime) {
		this.mytime = mytime;
	}

	public String getDesign_img() {
		return design_img;
	}

	public void setDesign_img(String design_img) {
		this.design_img = design_img;
	}

	@Override
	public String toString() {
		return "FabricDemo [id=" + id + ", date=" + date + ", b_id=" + b_id + ", fabric=" + fabric + ", consumption="
				+ consumption + ", company=" + company + ", delType=" + delType + ", delTime=" + delTime + ", addtime="
				+ addtime + ", mytime=" + mytime + "]";
	}

}
