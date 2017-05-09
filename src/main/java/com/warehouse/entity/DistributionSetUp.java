package com.warehouse.entity;

public class DistributionSetUp {
	private Integer begin;

	private Integer end;

	private Integer id;

	private String productCode;

	private String clothName;

	private String oringinalWave;

	private String wave;

	private String productImg;

	private String sampleImg;

	private String sizeImg;

	private String orderDetails;

	private Integer orderNum;

	private String planInWarehouseTime;

	private String orderGrade;

	private String setUpDistribution;

	private String setUpDistributionTime;

	private String state;

	private String delState;

	private String addTime;

	private String addPersion;

	private String modifyTime;

	private String modifyPersion;

	private String delTime;

	private String delPersion;

	private String releaseTime;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
	}

	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName == null ? null : clothName.trim();
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave == null ? null : oringinalWave.trim();
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg == null ? null : productImg.trim();
	}

	public String getSampleImg() {
		return sampleImg;
	}

	public void setSampleImg(String sampleImg) {
		this.sampleImg = sampleImg == null ? null : sampleImg.trim();
	}

	public String getSizeImg() {
		return sizeImg;
	}

	public void setSizeImg(String sizeImg) {
		this.sizeImg = sizeImg == null ? null : sizeImg.trim();
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails == null ? null : orderDetails.trim();
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getPlanInWarehouseTime() {
		return planInWarehouseTime;
	}

	public void setPlanInWarehouseTime(String planInWarehouseTime) {
		this.planInWarehouseTime = planInWarehouseTime == null ? null : planInWarehouseTime.trim();
	}

	public String getOrderGrade() {
		return orderGrade;
	}

	public void setOrderGrade(String orderGrade) {
		this.orderGrade = orderGrade == null ? null : orderGrade.trim();
	}

	public String getSetUpDistribution() {
		return setUpDistribution;
	}

	public void setSetUpDistribution(String setUpDistribution) {
		this.setUpDistribution = setUpDistribution == null ? null : setUpDistribution.trim();
	}

	public String getSetUpDistributionTime() {
		return setUpDistributionTime;
	}

	public void setSetUpDistributionTime(String setUpDistributionTime) {
		this.setUpDistributionTime = setUpDistributionTime == null ? null : setUpDistributionTime.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getDelState() {
		return delState;
	}

	public void setDelState(String delState) {
		this.delState = delState == null ? null : delState.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getAddPersion() {
		return addPersion;
	}

	public void setAddPersion(String addPersion) {
		this.addPersion = addPersion == null ? null : addPersion.trim();
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime == null ? null : modifyTime.trim();
	}

	public String getModifyPersion() {
		return modifyPersion;
	}

	public void setModifyPersion(String modifyPersion) {
		this.modifyPersion = modifyPersion == null ? null : modifyPersion.trim();
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime == null ? null : delTime.trim();
	}

	public String getDelPersion() {
		return delPersion;
	}

	public void setDelPersion(String delPersion) {
		this.delPersion = delPersion == null ? null : delPersion.trim();
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public DistributionSetUp() {
		super();
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public DistributionSetUp(Integer begin, Integer end, String clothName, String oringinalWave, String wave) {
		super();
		this.begin = begin;
		this.end = end;
		this.clothName = clothName;
		this.oringinalWave = oringinalWave;
		this.wave = wave;
	}

}