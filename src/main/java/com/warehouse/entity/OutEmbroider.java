package com.warehouse.entity;

public class OutEmbroider {

	private Integer begin;

	private Integer end;

	private Integer oid;

	private String company;

	private String odate;

	private String girard;

	private String designImg;

	private String fabric;

	private Integer code52;

	private Integer code1;

	private Integer code2;

	private Integer code3;

	private Integer code4;

	private Integer code5;

	private Integer code6;

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

	private String status;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard == null ? null : girard.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric == null ? null : fabric.trim();
	}

	public Integer getCode52() {
		return code52;
	}

	public void setCode52(Integer code52) {
		this.code52 = code52;
	}

	public Integer getCode1() {
		return code1;
	}

	public void setCode1(Integer code1) {
		this.code1 = code1;
	}

	public Integer getCode2() {
		return code2;
	}

	public void setCode2(Integer code2) {
		this.code2 = code2;
	}

	public Integer getCode3() {
		return code3;
	}

	public void setCode3(Integer code3) {
		this.code3 = code3;
	}

	public Integer getCode4() {
		return code4;
	}

	public void setCode4(Integer code4) {
		this.code4 = code4;
	}

	public Integer getCode5() {
		return code5;
	}

	public void setCode5(Integer code5) {
		this.code5 = code5;
	}

	public Integer getCode6() {
		return code6;
	}

	public void setCode6(Integer code6) {
		this.code6 = code6;
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

	public OutEmbroider(Integer begin, Integer end, String girard) {
		super();
		this.begin = begin;
		this.end = end;
		this.girard = girard;
	}

	public OutEmbroider(Integer begin, Integer end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public OutEmbroider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}