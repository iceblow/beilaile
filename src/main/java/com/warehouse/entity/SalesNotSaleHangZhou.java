package com.warehouse.entity;

import java.io.Serializable;

/**
 * 未售杭州实体
 * 
 * @author admin
 *
 */
public class SalesNotSaleHangZhou implements Serializable {

	private Integer sid;//ID

	private String sdate;//日期

	private String commodityc_code;//商品编码

	private String girard;//波次号

	private String factory;//工厂

	private String design_img;//工艺单

	private Integer code59;//尺码59

	private Integer code66;//尺码66

	private Integer code73;//尺码73

	private Integer code80;//尺码80

	private Integer code90;//尺码90

	private Integer code100;//尺码100

	private Integer code110;//尺码110

	private Integer total;//合计

	private Integer delb;//删除标识

	private String remarks;//备注

	private String pc_ip;

	private String operation;

	private String operator;

	private String add_time;

	private String update_time;

	private String del_time;

	private String temp_bar;

	private String vendor_code;

	private String productShortName;

	private Integer code120;

	private Integer code130;

	private Integer code160;

	private Integer code170;

	private int begin;

	private int end;

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

	public String getCommodityc_code() {
		return commodityc_code;
	}

	public void setCommodityc_code(String commodityc_code) {
		this.commodityc_code = commodityc_code;
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getDesign_img() {
		return design_img;
	}

	public void setDesign_img(String design_img) {
		this.design_img = design_img;
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
		this.remarks = remarks;
	}

	public String getPc_ip() {
		return pc_ip;
	}

	public void setPc_ip(String pc_ip) {
		this.pc_ip = pc_ip;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getDel_time() {
		return del_time;
	}

	public void setDel_time(String del_time) {
		this.del_time = del_time;
	}

	public String getTemp_bar() {
		return temp_bar;
	}

	public void setTemp_bar(String temp_bar) {
		this.temp_bar = temp_bar;
	}

	public String getVendor_code() {
		return vendor_code;
	}

	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
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

	@Override
	public String toString() {
		return "SalesNotSaleHangzhou [sid=" + sid + ", sdate=" + sdate + ", commodityc_code=" + commodityc_code
				+ ", girard=" + girard + ", factory=" + factory + ", design_img=" + design_img + ", code59=" + code59
				+ ", code66=" + code66 + ", code73=" + code73 + ", code80=" + code80 + ", code90=" + code90
				+ ", code100=" + code100 + ", code110=" + code110 + ", total=" + total + ", delb=" + delb + ", remarks="
				+ remarks + ", pc_ip=" + pc_ip + ", operation=" + operation + ", operator=" + operator + ", add_time="
				+ add_time + ", update_time=" + update_time + ", del_time=" + del_time + ", temp_bar=" + temp_bar
				+ ", vendor_code=" + vendor_code + ", productShortName=" + productShortName + ", code120=" + code120
				+ ", code130=" + code130 + ", code160=" + code160 + ", code170=" + code170 + "]";
	}

	public SalesNotSaleHangZhou(int begin, int end, SalesNotSaleHangZhou notSaleHangzhou) {
		super();
		this.sid = notSaleHangzhou.getSid();
		this.sdate = notSaleHangzhou.getSdate();
		this.commodityc_code = notSaleHangzhou.getCommodityc_code();
		this.girard = notSaleHangzhou.getGirard();
		this.factory = notSaleHangzhou.getFactory();
		this.design_img = notSaleHangzhou.getDesign_img();
		this.code59 = notSaleHangzhou.getCode59();
		this.code66 = notSaleHangzhou.getCode66();
		this.code73 = notSaleHangzhou.getCode73();
		this.code80 = notSaleHangzhou.getCode80();
		this.code90 = notSaleHangzhou.getCode90();
		this.code100 = notSaleHangzhou.getCode100();
		this.code110 = notSaleHangzhou.getCode110();
		this.total = notSaleHangzhou.getTotal();
		this.delb = notSaleHangzhou.getDelb();
		this.remarks = notSaleHangzhou.getRemarks();
		this.pc_ip = notSaleHangzhou.getPc_ip();
		this.operation = notSaleHangzhou.getOperation();
		this.operator = notSaleHangzhou.getOperator();
		this.add_time = notSaleHangzhou.getAdd_time();
		this.update_time = notSaleHangzhou.getUpdate_time();
		this.del_time = notSaleHangzhou.getDel_time();
		this.temp_bar = notSaleHangzhou.getTemp_bar();
		this.vendor_code = notSaleHangzhou.getVendor_code();
		this.productShortName = notSaleHangzhou.getProductShortName();
		this.code120 = notSaleHangzhou.getCode120();
		this.code130 = notSaleHangzhou.getCode130();
		this.code160 = notSaleHangzhou.getCode160();
		this.code170 = notSaleHangzhou.getCode170();
		this.begin = begin;
		this.end = end;
	}

	public SalesNotSaleHangZhou() {
		super();
		// TODO Auto-generated constructor stub
	}

}
