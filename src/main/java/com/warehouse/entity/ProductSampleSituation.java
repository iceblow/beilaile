package com.warehouse.entity;

public class ProductSampleSituation {
	private Integer begin;
	 
	private Integer end;
	 
    private Integer id;

    private String sid;

    private String wave;

    private String productCode;
    
    private String productName;

    private String designImg;

    private String orderGrade;

    private String dataStatus;

    private String remarks;

    private String sampleTime;

    private String createTime;

    private String modifyTime;

    private String modifiedBy;

    private String deleteTime;

    private String deletePeople;

    private String delStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave == null ? null : wave.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getDesignImg() {
        return designImg;
    }

    public void setDesignImg(String designImg) {
        this.designImg = designImg == null ? null : designImg.trim();
    }

    public String getOrderGrade() {
        return orderGrade;
    }

    public void setOrderGrade(String orderGrade) {
        this.orderGrade = orderGrade == null ? null : orderGrade.trim();
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime == null ? null : sampleTime.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getDeletePeople() {
        return deletePeople;
    }

    public void setDeletePeople(String deletePeople) {
        this.deletePeople = deletePeople == null ? null : deletePeople.trim();
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus == null ? null : delStatus.trim();
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
	
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductSampleSituation() {
		super();
	}

	public ProductSampleSituation(Integer begin, Integer end, String sid, String wave, String productCode,String productName) {
		super();
		this.begin = begin;
		this.end = end;
		this.sid = sid;
		this.wave = wave;
		this.productCode = productCode;
		this.productName = productName;
	}
    
}