package com.warehouse.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
//经销单生产
@SuppressWarnings("serial")
public class DistributionProduction implements Serializable{
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

    private String productCode;					//商品编号

    private String clothName;					//服装名

    private String oringinalWave;				//原波次

    private String wave;						//波次号

    private String productImg;					//设计图

    private String sampleImg;					//工艺单

    private String sizeImg;						//尺码表

    private String orderDetails;				//订单明细

    private Integer orderNum;					//订单数量

    private String orderGrade;					//订单等级

    private String orderType;					//订单类型

    private String distributtionFactory;		//经销工厂

    private String planStartMakeTime;			//计划上线日期

    private String startMake;				//上线状态, n--未上线  y--上线 

    private String startMakeTime;				//上线时间
    
    
    //4.14添加字段（2017-04-20修改过）
    
    private String planInWarehouseTime;		//计划入库时间1
    
    private String trackingOfficer;			//跟踪人1
    
    private String releaseTime;				//下单日期
    
    private String remark;					//备注1
    
    private String orderId;					//订单号1
    
    private String tacheStartTime;			//环节开始时间1
    
    //--------2017-04-17添加字段
    private Integer S59;// 尺码59
	private Integer S66;// 尺码66
	private Integer S73;// 尺码73
	private Integer S80;// 尺码80
	private Integer S90;// 尺码90
	private Integer S100;// 尺码100
	private Integer S110;// 尺码110
	private Integer S120;// 尺码120
	private Integer S130;// 尺码130
	private Integer S160;// 尺码160
	private Integer S170;// 尺码170
    
    private Integer S52;// 尺码52
	public Integer getS52() {
		return S52;
	}

	public void setS52(Integer s52) {
		S52 = s52;
	}

	public Integer getS59() {
		return S59;
	}

	public void setS59(Integer s59) {
		S59 = s59;
	}

	public Integer getS66() {
		return S66;
	}

	public void setS66(Integer s66) {
		S66 = s66;
	}

	public Integer getS73() {
		return S73;
	}

	public void setS73(Integer s73) {
		S73 = s73;
	}

	public Integer getS80() {
		return S80;
	}

	public void setS80(Integer s80) {
		S80 = s80;
	}

	public Integer getS90() {
		return S90;
	}

	public void setS90(Integer s90) {
		S90 = s90;
	}

	public Integer getS100() {
		return S100;
	}

	public void setS100(Integer s100) {
		S100 = s100;
	}

	public Integer getS110() {
		return S110;
	}

	public void setS110(Integer s110) {
		S110 = s110;
	}

	public Integer getS120() {
		return S120;
	}

	public void setS120(Integer s120) {
		S120 = s120;
	}

	public Integer getS130() {
		return S130;
	}

	public void setS130(Integer s130) {
		S130 = s130;
	}

	public Integer getS160() {
		return S160;
	}

	public void setS160(Integer s160) {
		S160 = s160;
	}

	public Integer getS170() {
		return S170;
	}

	public void setS170(Integer s170) {
		S170 = s170;
	}
	

    
    private String nowTime=getStringTime();
    
    public String getNowTime() {
		return nowTime;
	}

	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}

	public String getPlanInWarehouseTime() {
		return planInWarehouseTime;
	}

	public void setPlanInWarehouseTime(String planInWarehouseTime) {
		this.planInWarehouseTime = planInWarehouseTime;
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

    public String getPlanStartMakeTime() {
        return planStartMakeTime;
    }

    public void setPlanStartMakeTime(String planStartMakeTime) {
        this.planStartMakeTime = planStartMakeTime == null ? null : planStartMakeTime.trim();
    }

    public String getStartMake() {
        return startMake;
    }

    public void setStartMake(String startMake) {
        this.startMake = startMake == null ? null : startMake.trim();
    }

    public String getStartMakeTime() {
        return startMakeTime;
    }

    public void setStartMakeTime(String startMakeTime) {
        this.startMakeTime = startMakeTime == null ? null : startMakeTime.trim();
    }
	public static String getStringTime(){
		//生成当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date(System.currentTimeMillis());
    	return sdf.format(date);
	}

	@Override
	public String toString() {
		return "DistributionProduction [begin=" + begin + ", end=" + end + ", id=" + id + ", productCode=" + productCode
				+ ", clothName=" + clothName + ", oringinalWave=" + oringinalWave + ", wave=" + wave + ", productImg="
				+ productImg + ", sampleImg=" + sampleImg + ", sizeImg=" + sizeImg + ", orderDetails=" + orderDetails
				+ ", orderNum=" + orderNum + ", orderGrade=" + orderGrade + ", orderType=" + orderType
				+ ", distributtionFactory=" + distributtionFactory + ", planStartMakeTime=" + planStartMakeTime
				+ ", startMake=" + startMake + ", startMakeTime=" + startMakeTime + ", planInWarehouseTime="
				+ planInWarehouseTime + ", trackingOfficer=" + trackingOfficer + ", releaseTime=" + releaseTime
				+ ", remark=" + remark + ", orderId=" + orderId + ", tacheStartTime=" + tacheStartTime + ", S59=" + S59
				+ ", S66=" + S66 + ", S73=" + S73 + ", S80=" + S80 + ", S90=" + S90 + ", S100=" + S100 + ", S110="
				+ S110 + ", S120=" + S120 + ", S130=" + S130 + ", S160=" + S160 + ", S170=" + S170 + ", S52=" + S52
				+ ", nowTime=" + nowTime + "]";
	}

	public DistributionProduction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DistributionProduction(int begin, int end, DistributionProduction distributionProduction) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = distributionProduction.id;
		this.productCode = distributionProduction.productCode;
		this.clothName = distributionProduction.clothName;
		this.oringinalWave = distributionProduction.oringinalWave;
		this.wave = distributionProduction.wave;
		this.productImg = distributionProduction.productImg;
		this.sampleImg = distributionProduction.sampleImg;
		this.sizeImg = distributionProduction.sizeImg;
		this.orderDetails = distributionProduction.orderDetails;
		this.orderNum = distributionProduction.orderNum;
		this.orderGrade = distributionProduction.orderGrade;
		this.orderType = distributionProduction.orderType;
		this.distributtionFactory = distributionProduction.distributtionFactory;
		this.planStartMakeTime = distributionProduction.planStartMakeTime;
		this.startMake = distributionProduction.startMake;
		this.startMakeTime = distributionProduction.startMakeTime;
		this.planInWarehouseTime = distributionProduction.planInWarehouseTime;
		this.trackingOfficer = distributionProduction.trackingOfficer;
		this.releaseTime = distributionProduction.releaseTime;
		this.remark = distributionProduction.remark;
		this.orderId = distributionProduction.orderId;
		this.tacheStartTime = distributionProduction.tacheStartTime;
		S59 = distributionProduction.S59;
		S66 = distributionProduction.S66;
		S73 = distributionProduction.S73;
		S80 = distributionProduction.S80;
		S90 = distributionProduction.S90;
		S100 = distributionProduction.S100;
		S110 = distributionProduction.S110;
		S120 = distributionProduction.S120;
		S130 = distributionProduction.S130;
		S160 = distributionProduction.S160;
		S170 = distributionProduction.S170;
		S52 = distributionProduction.S52;
		this.nowTime = distributionProduction.nowTime;
	}
	
	
}