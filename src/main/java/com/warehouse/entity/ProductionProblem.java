package com.warehouse.entity;

import java.io.Serializable;

public class ProductionProblem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5501328571464033646L;

	private Integer id;// 编号

	private String wave;// 波次

	private String oringinalWave;// 原波次

	private String designImg;// 产品图

	private String craftsOrder;// 工艺单

	private String sizeChart;// 尺码图

	private String orderDetails;// 订单明细

	private Integer orders;// 订单数量

	private String cuttingMan;// 裁剪人

	private Integer cuttingNum;// 裁剪数量

	private String fabricGivingOutMan;// 发料人

	private String trackingMan;// 跟踪员

	private String problem;// 产生问题

	private String addTime;// 数据添加时间

	private String problemTime;// 问题产生时间
	
	private String completeType;//解决状态
	
	private String completeTime;//解决时间

	private int begin;

	private int end;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave == null ? null : oringinalWave.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getCraftsOrder() {
		return craftsOrder;
	}

	public void setCraftsOrder(String craftsOrder) {
		this.craftsOrder = craftsOrder == null ? null : craftsOrder.trim();
	}

	public String getSizeChart() {
		return sizeChart;
	}

	public void setSizeChart(String sizeChart) {
		this.sizeChart = sizeChart == null ? null : sizeChart.trim();
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails == null ? null : orderDetails.trim();
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getCuttingMan() {
		return cuttingMan;
	}

	public void setCuttingMan(String cuttingMan) {
		this.cuttingMan = cuttingMan == null ? null : cuttingMan.trim();
	}

	public Integer getCuttingNum() {
		return cuttingNum;
	}

	public void setCuttingNum(Integer cuttingNum) {
		this.cuttingNum = cuttingNum;
	}

	public String getFabricGivingOutMan() {
		return fabricGivingOutMan;
	}

	public void setFabricGivingOutMan(String fabricGivingOutMan) {
		this.fabricGivingOutMan = fabricGivingOutMan == null ? null : fabricGivingOutMan.trim();
	}

	public String getTrackingMan() {
		return trackingMan;
	}

	public void setTrackingMan(String trackingMan) {
		this.trackingMan = trackingMan == null ? null : trackingMan.trim();
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem == null ? null : problem.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getProblemTime() {
		return problemTime;
	}

	public void setProblemTime(String problemTime) {
		this.problemTime = problemTime == null ? null : problemTime.trim();
	}

	public String getCompleteType() {
		return completeType;
	}

	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}

	@Override
	public String toString() {
		return "ProductionFroblem [id=" + id + ", wave=" + wave + ", oringinalWave=" + oringinalWave + ", designImg="
				+ designImg + ", craftsOrder=" + craftsOrder + ", sizeChart=" + sizeChart + ", orderDetails="
				+ orderDetails + ", orders=" + orders + ", cuttingMan=" + cuttingMan + ", cuttingNum=" + cuttingNum
				+ ", fabricGivingOutMan=" + fabricGivingOutMan + ", trackingMan=" + trackingMan + ", problem=" + problem
				+ ", addTime=" + addTime + ", problemTime=" + problemTime + "]";
	}

	public ProductionProblem(int begin, int end, ProductionProblem productionProblem) {
		super();
		this.id = productionProblem.getId();//编号
		this.wave = productionProblem.getWave();//波次
		this.oringinalWave = productionProblem.getOringinalWave();//原波次
		this.designImg = productionProblem.getDesignImg();//产品图
		this.craftsOrder = productionProblem.getCraftsOrder();//工艺单
		this.sizeChart = productionProblem.getSizeChart();//尺码图
		this.orderDetails = productionProblem.getOrderDetails();//订单明细
		this.orders = productionProblem.getOrders();//订单数量
		this.cuttingMan = productionProblem.getCuttingMan();//裁剪人
		this.cuttingNum = productionProblem.getCuttingNum();//裁剪数量
		this.fabricGivingOutMan = productionProblem.getFabricGivingOutMan();//发料人
		this.trackingMan = productionProblem.getTrackingMan();//跟踪员
		this.problem = productionProblem.getProblem();//问题
		this.problemTime = productionProblem.getProblemTime();//问题产生时间
		this.completeType=productionProblem.getCompleteType();
		this.completeTime=productionProblem.getCompleteTime();
		this.begin = begin;
		this.end = end;
	}

	public ProductionProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

}