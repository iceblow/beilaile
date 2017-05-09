package com.warehouse.entity;

public class DistributionMakSample {

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

    private String orderType;

    private String distributtionFactory;

    private String toMakeTheSample;

    private String toMakeTheSampleComplete;

    private String state;

    private String delState;

    private String addTime;

    private String addPersion;

    private String modifyTime;

    private String modifyPersion;

    private String delTime;

    private String delPersion;
    
    
    
    private String remark;		//备注
    
    
    private String modelSendTime;		//纸样发送时间
    
    private String addProofingFactory;		//添加打样工厂
    
    private String modelState;		//纸样状态
    
    private String trackingOfficer;		//跟单人
    
    private String releaseTime;			//下单时间
    
    private String orderId;			//打样单号
    
    private String tacheStartTime;		//环节开始时间
    
    public String getTrackingOfficer() {
		return trackingOfficer;
	}

	public void setTrackingOfficer(String trackingOfficer) {
		this.trackingOfficer = trackingOfficer;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTacheStartTime() {
		return tacheStartTime;
	}

	public void setTacheStartTime(String tacheStartTime) {
		this.tacheStartTime = tacheStartTime;
	}

	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public String getModelSendTime() {
		return modelSendTime;
	}

	public void setModelSendTime(String modelSendTime) {
		this.modelSendTime = modelSendTime;
	}

	public String getAddProofingFactory() {
		return addProofingFactory;
	}

	public void setAddProofingFactory(String addProofingFactory) {
		this.addProofingFactory = addProofingFactory;
	}

	public String getModelState() {
		return modelState;
	}

	public void setModelState(String modelState) {
		this.modelState = modelState;
	}

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getDistributtionFactory() {
        return distributtionFactory;
    }

    public void setDistributtionFactory(String distributtionFactory) {
        this.distributtionFactory = distributtionFactory == null ? null : distributtionFactory.trim();
    }

    public String getToMakeTheSample() {
        return toMakeTheSample;
    }

    public void setToMakeTheSample(String toMakeTheSample) {
        this.toMakeTheSample = toMakeTheSample == null ? null : toMakeTheSample.trim();
    }

    public String getToMakeTheSampleComplete() {
        return toMakeTheSampleComplete;
    }

    public void setToMakeTheSampleComplete(String toMakeTheSampleComplete) {
        this.toMakeTheSampleComplete = toMakeTheSampleComplete == null ? null : toMakeTheSampleComplete.trim();
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

	public DistributionMakSample() {
		super();
	}
	



	public DistributionMakSample(Integer begin, Integer end,DistributionMakSample distributionMakSample) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = distributionMakSample.id;
		
		this.productCode = distributionMakSample.productCode;
		this.clothName = distributionMakSample.clothName;
		this.oringinalWave = distributionMakSample.oringinalWave;
		this.wave = distributionMakSample.wave;
		this.productImg = distributionMakSample.productImg;
		this.sampleImg = distributionMakSample.sampleImg;
		this.sizeImg = distributionMakSample.sizeImg;
		this.orderDetails = distributionMakSample.orderDetails;
		this.orderNum = distributionMakSample.orderNum;
		this.planInWarehouseTime = distributionMakSample.planInWarehouseTime;
		this.orderGrade = distributionMakSample.orderGrade;
		this.orderType = distributionMakSample.orderType;
		this.distributtionFactory = distributionMakSample.distributtionFactory;
		this.toMakeTheSample = distributionMakSample.toMakeTheSample;
		this.toMakeTheSampleComplete = distributionMakSample.toMakeTheSampleComplete;
		this.state = distributionMakSample.state;
		this.delState = distributionMakSample.delState;
		this.addTime = distributionMakSample.addTime;
		this.addPersion = distributionMakSample.addPersion;
		this.modifyTime = distributionMakSample.modifyTime;
		this.modifyPersion = distributionMakSample.modifyPersion;
		this.delTime = distributionMakSample.delTime;
		this.delPersion = distributionMakSample.delPersion;
		this.trackingOfficer = distributionMakSample.trackingOfficer;
		this.releaseTime = distributionMakSample.releaseTime;
		this.remark = distributionMakSample.remark;
		this.tacheStartTime = distributionMakSample.tacheStartTime;
		this.orderId = distributionMakSample.orderId;
		this.modelSendTime = distributionMakSample.modelSendTime;
		this.addProofingFactory = distributionMakSample.addProofingFactory;
		this.modelState = distributionMakSample.modelState;
		
		
		
		 
	} 

	
	
}