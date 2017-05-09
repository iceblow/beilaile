package com.warehouse.entity;

public class ProductStorageSituation {
	
	
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
	
    private Integer id; 		

    private String sid;			//序列号

    private String wave;		//波次

    private String productCode;		//商品编码

    private String designImg;		//图片

    private String orderGrade;		//订单等级

    private String dataStatus;		//数据状态

    private String remarks;		//备注

    private String storageTime;		//入仓时间

    private String createTime;		//创建时间

    private String modifyTime;		//修改时间
    	
    private String modifiedBy;		//修改人

    private String deleteTime;		//删除时间

    private String deletePeople;	//删除人

    private String delStatus;		//删除状态
    
    private String productName;		//商品名称
    
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

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

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime == null ? null : storageTime.trim();
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
    
    

	public ProductStorageSituation() {
		super();
	}

	@Override
	public String toString() {
		return "ProductStorageSituation [id=" + id + ", productName=" + productName + ",sid=" + sid + ", begin=" + begin + ",end=" + end + ",wave=" + wave + ", productCode=" + productCode
				+ ", designImg=" + designImg + ", orderGrade=" + orderGrade + ", dataStatus=" + dataStatus
				+ ", remarks=" + remarks + ", storageTime=" + storageTime + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", modifiedBy=" + modifiedBy + ", deleteTime=" + deleteTime
				+ ", deletePeople=" + deletePeople + ", delStatus=" + delStatus + "]";
	}

	public ProductStorageSituation(int begin,int end,ProductStorageSituation productStorageSituation) {
		super();
		this.begin= begin;
		this.end= end;
		this.productName = productStorageSituation.productName;
		this.id = productStorageSituation.id;
		this.sid = productStorageSituation.sid;
		this.wave = productStorageSituation.wave;
		this.productCode = productStorageSituation.productCode;
		this.designImg = productStorageSituation.designImg;
		this.orderGrade = productStorageSituation.orderGrade;
		this.dataStatus = productStorageSituation.dataStatus;
		this.remarks = productStorageSituation.remarks;
		this.storageTime = productStorageSituation.storageTime;
		this.createTime = productStorageSituation.createTime;
		this.modifyTime = productStorageSituation.modifyTime;
		this.modifiedBy = productStorageSituation.modifiedBy;
		this.deleteTime = productStorageSituation.deleteTime;
		this.deletePeople = productStorageSituation.deletePeople;
		this.delStatus = productStorageSituation.delStatus;
	}
    
    
    
    
    
    
    
    
    
}