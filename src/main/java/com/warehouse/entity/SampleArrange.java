package com.warehouse.entity;

import java.io.Serializable;

public class SampleArrange implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4916391194421464658L;

	private String wave;// 不排除哦

	private String designImg;// 产品图片

	private String productCode;// 商品编号

	private String ifGiveOut;// 是否发放

	private String consignee;// 收货人

	private String shippingAddress;// 收货地址

	private int begin;

	private int end;

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
	}

	public String getIfGiveOut() {
		return ifGiveOut;
	}

	public void setIfGiveOut(String ifGiveOut) {
		this.ifGiveOut = ifGiveOut == null ? null : ifGiveOut.trim();
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee == null ? null : consignee.trim();
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
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
		return "SampleArrange [wave=" + wave + ", designImg=" + designImg + ", productCode=" + productCode
				+ ", ifGiveOut=" + ifGiveOut + ", consignee=" + consignee + ", shippingAddress=" + shippingAddress
				+ ", begin=" + begin + ", end=" + end + "]";
	}

	public SampleArrange(int begin, int end,SampleArrange sampleArrange) {
		super();
		this.wave = sampleArrange.getWave();
		this.designImg = sampleArrange.getDesignImg();
		this.productCode = sampleArrange.getProductCode();
		this.ifGiveOut = sampleArrange.getIfGiveOut();
		this.consignee = sampleArrange.getConsignee();
		this.shippingAddress = sampleArrange.getShippingAddress();
		this.begin = begin;
		this.end = end;
	}

	public SampleArrange() {
		super();
		// TODO Auto-generated constructor stub
	}

}