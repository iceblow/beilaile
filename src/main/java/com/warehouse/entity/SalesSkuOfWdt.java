package com.warehouse.entity;

public class SalesSkuOfWdt {

	private String aliaeCode;// 编码

	private Integer totalNum;// 总件数

	public String getAliaeCode() {
		return aliaeCode;
	}

	public void setAliaeCode(String aliaeCode) {
		this.aliaeCode = aliaeCode == null ? null : aliaeCode.trim();
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
}