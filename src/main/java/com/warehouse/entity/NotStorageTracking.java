package com.warehouse.entity;

public class NotStorageTracking {
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

    private String wave;//波次号

    private String factory;  //工厂名

    private String designImg;   //照片

    public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg;
	}

	private String orderType;		//订单类型

    private String releaseTime;    //发版时间

    private String timeDifferece; //发版时间和当前日期的差值
    
    private String clouthName; //商品名称
    
    private String productCode;


    private String updateTime;

    private String insertTime;

    private String deleteTime;

    private String dataState;

    private String deletePeople;
   
    private String storageTime;		 //入库时间
    private String estimatedDeliveryTime;	//预计入库时间
    public String getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
	}

	public String getProblemFeedBack() {
		return problemFeedBack;
	}

	public void setProblemFeedBack(String problemFeedBack) {
		this.problemFeedBack = problemFeedBack;
	}

	public String getReasonForDelay() {
		return reasonForDelay;
	}

	public void setReasonForDelay(String reasonForDelay) {
		this.reasonForDelay = reasonForDelay;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProblemSolving() {
		return problemSolving;
	}

	public void setProblemSolving(String problemSolving) {
		this.problemSolving = problemSolving;
	}

	public String getProblemSolvingTime() {
		return problemSolvingTime;
	}

	public void setProblemSolvingTime(String problemSolvingTime) {
		this.problemSolvingTime = problemSolvingTime;
	}

	private String problemFeedBack;	//问题反馈
    private String reasonForDelay;	//延期原因
    private String personInCharge;	//负责人
    private String memo;		//备注
    private String problemSolving;		//问题解决
    private String problemSolvingTime;		//问题解决时间

    
	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
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

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    

    public String getClouthName() {
		return clouthName;
	}

	public void setClouthName(String clouthName) {
		this.clouthName = clouthName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime == null ? null : releaseTime.trim();
    }

    public String getTimeDifferece() {
        return timeDifferece;
    }

    public void setTimeDifferece(String timeDifferece) {
        this.timeDifferece = timeDifferece == null ? null : timeDifferece.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime == null ? null : insertTime.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState == null ? null : dataState.trim();
    }

    public String getDeletePeople() {
        return deletePeople;
    }

    public void setDeletePeople(String deletePeople) {
        this.deletePeople = deletePeople == null ? null : deletePeople.trim();
    }

	@Override
	public String toString() {
		return "NotStorageTracking [ id=" + id + ", wave=" + wave + ",storageTime=" + storageTime + ",designImg=" + designImg + ", productCode=" + productCode + ",factory="
				+ factory + ", clouthName=" + clouthName + ", orderType=" + orderType + ", releaseTime="
				+ releaseTime + ", timeDifferece=" + timeDifferece + ", storageTime=" + storageTime + ", estimatedDeliveryTime=" + estimatedDeliveryTime + ", problemFeedBack=" + problemFeedBack + ", reasonForDelay=" + reasonForDelay + ", personInCharge=" + personInCharge + ", memo=" + memo + ", problemSolving=" + problemSolving + ", problemSolvingTime=" + problemSolvingTime + ",updateTime=" + updateTime + ", insertTime="
				+ insertTime + ", deleteTime=" + deleteTime + ", dataState=" + dataState + ", deletePeople="
				+ deletePeople + "]";
	}

	public NotStorageTracking() {
		super();
	}

	public NotStorageTracking(int begin, int end,NotStorageTracking notStorageTracking) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = notStorageTracking.id;
		this.storageTime = notStorageTracking.storageTime;
		this.designImg = notStorageTracking.designImg;
		this.wave = notStorageTracking.wave;
		this.factory = notStorageTracking.factory;
		this.clouthName = notStorageTracking.clouthName;
		this.productCode = notStorageTracking.productCode;
		this.orderType = notStorageTracking.orderType;
		this.releaseTime = notStorageTracking.releaseTime;
		this.timeDifferece = notStorageTracking.timeDifferece;
		this.updateTime = notStorageTracking.updateTime;
		this.insertTime = notStorageTracking.insertTime;
		this.deleteTime = notStorageTracking.deleteTime;
		this.dataState = notStorageTracking.dataState;
		this.deletePeople = notStorageTracking.deletePeople;

		this.storageTime = notStorageTracking.storageTime;
		this.estimatedDeliveryTime = notStorageTracking.estimatedDeliveryTime;
		this.problemFeedBack = notStorageTracking.problemFeedBack;
		this.reasonForDelay = notStorageTracking.reasonForDelay;
		this.personInCharge = notStorageTracking.personInCharge;
		this.memo = notStorageTracking.memo;
		this.problemSolving = notStorageTracking.problemSolving;
		this.problemSolvingTime = notStorageTracking.problemSolvingTime;
	}
    
    
}