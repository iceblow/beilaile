package com.warehouse.entity;

public class SewingFactoryPickingOrder {
	private Integer id;

	private Integer sewingId;

	private Integer orderId;

	private String sewingFactory;

	private String wave;

	private Integer code52;

	private Integer code59;

	private Integer code66;

	private Integer code73;

	private Integer code80;

	private Integer code90;

	private Integer code100;

	private Integer code110;

	private Integer code120;

	private Integer code130;

	private Integer code160;

	private Integer code170;

	private Integer total;

	private String designImg;

	private String sewingStatus;

	private String remark;

	private String addTime;

	private String updateTime;

	private String delTime;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSewingId() {
		return sewingId;
	}

	public void setSewingId(Integer sewingId) {
		this.sewingId = sewingId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getSewingFactory() {
		return sewingFactory;
	}

	public void setSewingFactory(String sewingFactory) {
		this.sewingFactory = sewingFactory;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public Integer getCode52() {
		return code52;
	}

	public void setCode52(Integer code52) {
		this.code52 = code52;
	}

	public Integer getCode59() {
		return code59;
	}

	public void setCode59(Integer code59) {
		this.code59 = code59;
	}

	public Integer getCode66() {
		return code66;
	}

	public void setCode66(Integer code66) {
		this.code66 = code66;
	}

	public Integer getCode73() {
		return code73;
	}

	public void setCode73(Integer code73) {
		this.code73 = code73;
	}

	public Integer getCode80() {
		return code80;
	}

	public void setCode80(Integer code80) {
		this.code80 = code80;
	}

	public Integer getCode90() {
		return code90;
	}

	public void setCode90(Integer code90) {
		this.code90 = code90;
	}

	public Integer getCode100() {
		return code100;
	}

	public void setCode100(Integer code100) {
		this.code100 = code100;
	}

	public Integer getCode110() {
		return code110;
	}

	public void setCode110(Integer code110) {
		this.code110 = code110;
	}

	public Integer getCode120() {
		return code120;
	}

	public void setCode120(Integer code120) {
		this.code120 = code120;
	}

	public Integer getCode130() {
		return code130;
	}

	public void setCode130(Integer code130) {
		this.code130 = code130;
	}

	public Integer getCode160() {
		return code160;
	}

	public void setCode160(Integer code160) {
		this.code160 = code160;
	}

	public Integer getCode170() {
		return code170;
	}

	public void setCode170(Integer code170) {
		this.code170 = code170;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getSewingStatus() {
		return sewingStatus;
	}

	public void setSewingStatus(String sewingStatus) {
		this.sewingStatus = sewingStatus == null ? null : sewingStatus.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime == null ? null : delTime.trim();
	}

	public SewingFactoryPickingOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SewingFactoryPickingOrder(Integer orderId, int begin, int end) {
		super();
		this.orderId = orderId;
		this.begin = begin;
		this.end = end;
	}

}