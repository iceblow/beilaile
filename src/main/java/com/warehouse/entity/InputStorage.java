package com.warehouse.entity;

public class InputStorage {

	private Integer begin;

	private Integer end;

	private Integer sid;

	private String sdate;

	private String girard;

	private String factory;

	private String designImg;

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

	private Integer delb;

	private String remarks;

	private String pcIp;

	private String operation;

	private String operator;

	private String addTime;

	private String updateTime;

	private String delTime;

	private String commoditycCode;

	private String tempBar;

	private String vendorCode;

	private String productShortName;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getCommoditycCode() {
		return commoditycCode;
	}

	public void setCommoditycCode(String commoditycCode) {
		this.commoditycCode = commoditycCode == null ? null : commoditycCode.trim();
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard == null ? null : girard.trim();
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getDelb() {
		return delb;
	}

	public void setDelb(Integer delb) {
		this.delb = delb;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
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

	public Integer getBegin() {
		return begin;
	}

	public Integer getEnd() {
		return end;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public InputStorage(Integer begin, Integer end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public InputStorage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InputStorage(Integer begin, Integer end, String girard, String factory, String commoditycCode) {
		super();
		this.begin = begin;
		this.end = end;
		this.girard = girard;
		this.factory = factory;
		this.commoditycCode = commoditycCode;
	}

	public String getTempBar() {
		return tempBar;
	}

	public void setTempBar(String tempBar) {
		this.tempBar = tempBar;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public Integer getCode120() {
		return code120;
	}

	public Integer getCode130() {
		return code130;
	}

	public Integer getCode160() {
		return code160;
	}

	public Integer getCode170() {
		return code170;
	}

	public void setCode120(Integer code120) {
		this.code120 = code120;
	}

	public void setCode130(Integer code130) {
		this.code130 = code130;
	}

	public void setCode160(Integer code160) {
		this.code160 = code160;
	}

	public void setCode170(Integer code170) {
		this.code170 = code170;
	}
}