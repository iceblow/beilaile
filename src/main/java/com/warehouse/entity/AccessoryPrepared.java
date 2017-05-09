package com.warehouse.entity;

public class AccessoryPrepared {
	
	private int id;
	private String wave;//波次号
	private String productCode;//商品编码
	private String designImg;//设计图片
	private String remark;//备注
	private String addTime;//添加时间
	private String updateTime;//更新时间
	private String delTime;//删除时间
	private String state;//删除状态
	private String date;//日期 yyyy/mm/dd
	
	
	/*
	 * setter getter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWave() {
		return wave;
	}
	public void setWave(String wave) {
		this.wave = wave;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDesignImg() {
		return designImg;
	}
	public void setDesignImg(String designImg) {
		this.designImg = designImg;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDelTime() {
		return delTime;
	}
	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	/*
	 * constructor
	 */
	public AccessoryPrepared() {
		super();
	}
	
}
