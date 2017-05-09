package com.warehouse.entity;

public class CancelOrder {
	private Integer id;

	private String designer;

	private String girard;

	private String originalWave;

	private String productId;

	private String clothName;

	private String designImg;

	private String sampleImg;

	private String sizeChart;

	private String delOrder;

	private String restoreOrder;

	private String status;

	private String remark;

	private String pcIp;

	private String operation;

	private String operator;

	private String addTime;

	private String restoreTime;

	private int begin;

	private int end;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer == null ? null : designer.trim();
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard == null ? null : girard.trim();
	}

	public String getOriginalWave() {
		return originalWave;
	}

	public void setOriginalWave(String originalWave) {
		this.originalWave = originalWave == null ? null : originalWave.trim();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId == null ? null : productId.trim();
	}

	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName == null ? null : clothName.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getSampleImg() {
		return sampleImg;
	}

	public void setSampleImg(String sampleImg) {
		this.sampleImg = sampleImg == null ? null : sampleImg.trim();
	}

	public String getSizeChart() {
		return sizeChart;
	}

	public void setSizeChart(String sizeChart) {
		this.sizeChart = sizeChart == null ? null : sizeChart.trim();
	}

	public String getDelOrder() {
		return delOrder;
	}

	public void setDelOrder(String delOrder) {
		this.delOrder = delOrder == null ? null : delOrder.trim();
	}

	public String getRestoreOrder() {
		return restoreOrder;
	}

	public void setRestoreOrder(String restoreOrder) {
		this.restoreOrder = restoreOrder == null ? null : restoreOrder.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getPcIp() {
		return pcIp;
	}

	public void setPcIp(String pcIp) {
		this.pcIp = pcIp == null ? null : pcIp.trim();
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation == null ? null : operation.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getRestoreTime() {
		return restoreTime;
	}

	public void setRestoreTime(String restoreTime) {
		this.restoreTime = restoreTime == null ? null : restoreTime.trim();
	}

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

	public CancelOrder(String girard, int begin, int end) {
		super();
		this.girard = girard;
		this.begin = begin;
		this.end = end;
	}

	public CancelOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

}