package com.warehouse.entity;

public class ProblemFeedback {
	private Integer id;// 编号

	private String wave;// 波次号

	private String link;// 环节

	private String reason;// 原因

	private String createdate;// 产生日期

	private String solution;// 解决办法

	private String resolveTime;// 解决时间

	private String solveDept;// 解决部门

	private String isResolved;// 是否解决

	private String delayedShipDate;// 延迟出货日期

	private String remarks;// 备注

	private String status;// 是否删除

	private String createdTime;// 创建时间
	private String delTime;// 删除时间
	private Integer countNumber;// 个数

	private int[] data;
	private String Name;// 环节

	private String founder;// 创建人

	private String modifyTime;// 修改时间

	private String operator;// 操作人

	private String operatorIp;// 操作人IP地址

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
		this.wave = wave;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getSolveDept() {
		return solveDept;
	}

	public void setSolveDept(String solveDept) {
		this.solveDept = solveDept;
	}

	public String getIsResolved() {
		return isResolved;
	}

	public void setIsResolved(String isResolved) {
		this.isResolved = isResolved;
	}

	public String getDelayedShipDate() {
		return delayedShipDate;
	}

	public void setDelayedShipDate(String delayedShipDate) {
		this.delayedShipDate = delayedShipDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	public Integer getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(Integer countNumber) {
		this.countNumber = countNumber;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

}