package com.warehouse.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.apache.tools.ant.types.resources.comparators.Date;

public class DistributionQuote implements Serializable{
	
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
    private Integer id;        //id

    private String productCode;   //商品编码

    private String clothName;   //商品名称

    private String oringinalWave;  //原波次

    private String wave;     //波次

    private String productImg;		//设计图

    private String sampleImg; 		//工艺单

    private String sizeImg;		//尺码图

    private String orderDetails;		//订单明细

    private Integer orderNum;		//订单数量

    private String planInWarehouseTime;		//计划入库时间

    private String orderGrade;		//订单等级

    private String orderType;		//订单类型

    private String distributtionFactory;	//经销工厂

    private String toMakeTheSample;		//确定打样

    private String toMakeTheSampleComplete;	  //打样完成

    private String clothPrice;			//经销单价

    private String distributionQuoteTime;			//确认报价时间
    
    private String dataState;
    
    private String addTime;
    
    private String trackingOfficer;		//跟单人
    
    private String releaseTime;			//下单时间
    
    private String remark;			//备注
    
    private String orderId;			//打样单号
    
    private String tacheStartTime;		//环节开始时间
    
	public String getQuoteConsumeTime() {
		return quoteConsumeTime;
	}

	public void setQuoteConsumeTime(String quoteConsumeTime) {
		this.quoteConsumeTime = quoteConsumeTime;
	}
	private String quoteConsumeTime;
    
    public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

    public String getClothPrice() {
        return clothPrice;
    }

    public void setClothPrice(String clothPrice) {
        this.clothPrice = clothPrice == null ? null : clothPrice.trim();
    }

   


	public String getDistributionQuoteTime() {
        return distributionQuoteTime;
    }

    public void setDistributionQuoteTime(String distributionQuoteTime) {
        this.distributionQuoteTime = distributionQuoteTime == null ? null : distributionQuoteTime.trim();
    }
    

	public DistributionQuote() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DistributionQuote [begin=" + begin + ", end=" + end + ", dataState=" + dataState + ", addTime=" + addTime + ",id=" + id + ",productCode=" + productCode
				+ ", clothName=" + clothName + ", trackingOfficer=" + trackingOfficer + ",releaseTime=" + releaseTime + ",remark=" + remark + ",orderId=" + orderId + ",tacheStartTime=" + tacheStartTime + ",oringinalWave=" + oringinalWave + ", wave=" + wave + ", productImg="
				+ productImg + ", sampleImg=" + sampleImg + ", sizeImg=" + sizeImg + ", orderDetails=" + orderDetails
				+ ", orderNum=" + orderNum + ", planInWarehouseTime=" + planInWarehouseTime + ", orderGrade="
				+ orderGrade + ", orderType=" + orderType + ", distributtionFactory=" + distributtionFactory
				+ ", toMakeTheSample=" + toMakeTheSample + ", toMakeTheSampleComplete=" + toMakeTheSampleComplete
				+ ", clothPrice=" + clothPrice + ", distributionQuoteTime="
				+ distributionQuoteTime + "]";
	}

	public DistributionQuote(int begin, int end, DistributionQuote distributionQuote) {
		super();
		this.begin = begin;
		this.end = end;
		this.trackingOfficer = distributionQuote.trackingOfficer;
	    this.releaseTime = distributionQuote.releaseTime;
	    this.remark = distributionQuote.remark;
	    this.orderId = distributionQuote.orderId;
	    this.tacheStartTime = distributionQuote.tacheStartTime;
		this.dataState = distributionQuote.dataState;
		this.addTime = distributionQuote.addTime;
		this.id = distributionQuote.id;
		this.productCode = distributionQuote.productCode;
		this.clothName = distributionQuote.clothName;
		this.oringinalWave = distributionQuote.oringinalWave;
		this.wave = distributionQuote.wave;
		this.productImg = distributionQuote.productImg;
		this.sampleImg = distributionQuote.sampleImg;
		this.sizeImg = distributionQuote.sizeImg;
		this.orderDetails = distributionQuote.orderDetails;
		this.orderNum = distributionQuote.orderNum;
		this.planInWarehouseTime = distributionQuote.planInWarehouseTime;
		this.orderGrade = distributionQuote.orderGrade;
		this.orderType = distributionQuote.orderType;
		this.distributtionFactory = distributionQuote.distributtionFactory;
		this.toMakeTheSample = distributionQuote.toMakeTheSample;
		this.toMakeTheSampleComplete = distributionQuote.toMakeTheSampleComplete;
		this.clothPrice = distributionQuote.clothPrice;
		this.distributionQuoteTime = distributionQuote.distributionQuoteTime;
	}
	
	
    
    
    
}