package com.warehouse.entity;

public class BoardRoom {
	private Integer id;

	private String addDate;

	private String wave;

	private String sizeChart;
	private String graphEmf;
	private String graphPrj;

	private String markDel;

	private String createdTime;

	private String founder;

	private String modifyTime;

	private String delTime;

	private String operator;

	private String operatorIp;

	private String remarks;

	public String getGraphEmf() {
		return graphEmf;
	}

	public void setGraphEmf(String graphEmf) {
		this.graphEmf = graphEmf;
	}

	public String getGraphPrj() {
		return graphPrj;
	}

	public void setGraphPrj(String graphPrj) {
		this.graphPrj = graphPrj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getSizeChart() {
		return sizeChart;
	}

	public void setSizeChart(String sizeChart) {
		this.sizeChart = sizeChart;
	}

	public String getMarkDel() {
		return markDel;
	}

	public void setMarkDel(String markDel) {
		this.markDel = markDel;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorIp() {
		return operatorIp;
	}

	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}