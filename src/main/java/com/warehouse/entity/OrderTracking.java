package com.warehouse.entity;

public class OrderTracking {
	
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

    private String wave;

    private String clouthName;
    private String productCode;

    private String orderType;

    private String factory;

    private String releaseTime;

    private String piecesApproved;

    private String designImg;   //照片
    
    private String cropCompletionTime;

    private String cutLargeReceiveTime;

    private String cutLargeReturnTime;

    private String timeDifferece;

    private String updateTime;

    private String insertTime;

    private String deleteTime;

    private String dataState;

    private String deletePeople;
    
    private String storageTime;		 //入库时间
    private String estimatedDeliveryTime;	//预计入库时间
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

  

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg;
	}

	public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime == null ? null : releaseTime.trim();
    }

    public String getPiecesApproved() {
        return piecesApproved;
    }

    public void setPiecesApproved(String piecesApproved) {
        this.piecesApproved = piecesApproved == null ? null : piecesApproved.trim();
    }

    public String getCropCompletionTime() {
        return cropCompletionTime;
    }

    public void setCropCompletionTime(String cropCompletionTime) {
        this.cropCompletionTime = cropCompletionTime == null ? null : cropCompletionTime.trim();
    }

    public String getCutLargeReceiveTime() {
        return cutLargeReceiveTime;
    }

    public void setCutLargeReceiveTime(String cutLargeReceiveTime) {
        this.cutLargeReceiveTime = cutLargeReceiveTime == null ? null : cutLargeReceiveTime.trim();
    }

    public String getCutLargeReturnTime() {
        return cutLargeReturnTime;
    }

    public void setCutLargeReturnTime(String cutLargeReturnTime) {
        this.cutLargeReturnTime = cutLargeReturnTime == null ? null : cutLargeReturnTime.trim();
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
		return "OrderTracking [id=" + id + ", wave=" + wave + ",designImg=" + designImg + ", productCode=" + productCode + " , clouthName=" + clouthName + ", orderType="
				+ orderType + ", factory=" + factory + ", releaseTime=" + releaseTime + ", piecesApproved="
				+ piecesApproved + ", cropCompletionTime=" + cropCompletionTime + ", cutLargeReceiveTime="
				+ cutLargeReceiveTime + ", cutLargeReturnTime=" + cutLargeReturnTime + ", timeDifferece="
				+ timeDifferece + ", storageTime=" + storageTime + ", estimatedDeliveryTime=" + estimatedDeliveryTime + ", problemFeedBack=" + problemFeedBack + ", reasonForDelay=" + reasonForDelay + ", personInCharge=" + personInCharge + ", memo=" + memo + ", problemSolving=" + problemSolving + ", problemSolvingTime=" + problemSolvingTime + ",updateTime=" + updateTime + ",   insertTime=" + insertTime + ", deleteTime="
				+ deleteTime + ", dataState=" + dataState + ", deletePeople=" + deletePeople + "]";
	}

	public OrderTracking() {
		super();
	}

	public OrderTracking( int  begin, int end,OrderTracking orderTracking) {
		super();
		this.begin =begin;
		this.end =end;
		this.id = orderTracking.id;
		this.wave = orderTracking.wave;
		this.designImg = orderTracking.designImg;
		this.clouthName = orderTracking.clouthName;
		this.productCode = orderTracking.productCode;
		this.orderType = orderTracking.orderType;
		this.factory = orderTracking.factory;
		this.releaseTime = orderTracking.releaseTime;
		this.piecesApproved = orderTracking.piecesApproved;
		this.cropCompletionTime = orderTracking.cropCompletionTime;
		this.cutLargeReceiveTime = orderTracking.cutLargeReceiveTime;
		this.cutLargeReturnTime = orderTracking.cutLargeReturnTime;
		this.timeDifferece = orderTracking.timeDifferece;
		this.updateTime = orderTracking.updateTime;
		this.insertTime = orderTracking.insertTime;
		this.deleteTime = orderTracking.deleteTime;
		this.dataState = orderTracking.dataState;
		this.deletePeople = orderTracking.deletePeople;
		
		this.storageTime = orderTracking.storageTime;
		this.estimatedDeliveryTime = orderTracking.estimatedDeliveryTime;
		this.problemFeedBack = orderTracking.problemFeedBack;
		this.reasonForDelay = orderTracking.reasonForDelay;
		this.personInCharge = orderTracking.personInCharge;
		this.memo = orderTracking.memo;
		this.problemSolving = orderTracking.problemSolving;
		this.problemSolvingTime = orderTracking.problemSolvingTime;
		
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
    
    
    
}