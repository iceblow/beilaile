package com.warehouse.entity;

public class Outsideproces {

	private Integer bid;// 编号
	private String girard;// 款号
	private Integer bnumber;// 件数
	private String category;// 类别
	private double workprice;// 外加工
	private double cpprice;// 裁片加工
	private String remark;// 备注
	private String hejia;// 核价人

	// 获取系统当前时间
	private String bdate;

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	// 设置删除的标识
	private int delb;

	public int getDelb() {
		return delb;
	}

	public void setDelb(int delb) {
		this.delb = delb;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard;
	}

	public Integer getBnumber() {
		return bnumber;
	}

	public void setBnumber(Integer bnumber) {
		this.bnumber = bnumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getWorkprice() {
		return workprice;
	}

	public void setWorkprice(double workprice) {
		this.workprice = workprice;
	}

	public double getCpprice() {
		return cpprice;
	}

	public void setCpprice(double cpprice) {
		this.cpprice = cpprice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHejia() {
		return hejia;
	}

	public void setHejia(String hejia) {
		this.hejia = hejia;
	}

	public Outsideproces(Integer bid, String girard, Integer bnumber, String category, double workprice, double cpprice,
			String remark, String hejia, int delb) {
		super();
		this.bid = bid;
		this.girard = girard;
		this.bnumber = bnumber;
		this.category = category;
		this.workprice = workprice;
		this.cpprice = cpprice;
		this.remark = remark;
		this.hejia = hejia;
		this.delb = delb;
	}

	public Outsideproces() {
		super();
		// TODO Auto-generated constructor stub
	}

}
