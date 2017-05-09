package com.warehouse.entity;

public class PurchaseOrdersDetail {

	private String ORDER_CODE;// 订单编码
	private String BUYER;// 采购人
	private String SUPPLIER;// 供应商
	private String PURCHASE_DATE;// 采购时间
	private String ALIAS_CODE;// 商家编码
	private String PRODUCT_CODE;// 产品编码
	private String PRODUCT_NAME;// 产品名称
	private String PUCHASE_AMOUNT;// 采购总数
	private String WAVE;// 波次

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

	public String getORDER_CODE() {
		return ORDER_CODE;
	}

	public void setORDER_CODE(String oRDER_CODE) {
		ORDER_CODE = oRDER_CODE;
	}

	public String getBUYER() {
		return BUYER;
	}

	public void setBUYER(String bUYER) {
		BUYER = bUYER;
	}

	public String getSUPPLIER() {
		return SUPPLIER;
	}

	public void setSUPPLIER(String sUPPLIER) {
		SUPPLIER = sUPPLIER;
	}


	public String getPURCHASE_DATE() {
		return PURCHASE_DATE;
	}

	public void setPURCHASE_DATE(String pURCHASE_DATE) {
		PURCHASE_DATE = pURCHASE_DATE;
	}

	public String getALIAS_CODE() {
		return ALIAS_CODE;
	}

	public void setALIAS_CODE(String aLIAS_CODE) {
		ALIAS_CODE = aLIAS_CODE;
	}

	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}

	public void setPRODUCT_CODE(String pRODUCT_CODE) {
		PRODUCT_CODE = pRODUCT_CODE;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getPUCHASE_AMOUNT() {
		return PUCHASE_AMOUNT;
	}

	public void setPUCHASE_AMOUNT(String pUCHASE_AMOUNT) {
		PUCHASE_AMOUNT = pUCHASE_AMOUNT;
	}

	public String getWAVE() {
		return WAVE;
	}

	public void setWAVE(String wAVE) {
		WAVE = wAVE;
	}


	public PurchaseOrdersDetail(int begin, int end, PurchaseOrdersDetail purchaseOrdersDetail) {
		super();
		this.begin = begin;
		this.end = end;
		// ORDER_CODE = oRDER_CODE;
		// BUYER = bUYER;
		// SUPPLIER = sUPPLIER;
		// PUCHASE_DATE = pUCHASE_DATE;
		// ALIAS_CODE = aLIAS_CODE;
		PRODUCT_CODE = purchaseOrdersDetail.getPRODUCT_CODE();
		// PRODUCT_NAME = pRODUCT_NAME;
		// PUCHASE_AMOUNT = pUCHASE_AMOUNT;
		WAVE = purchaseOrdersDetail.getWAVE();
	}

	public PurchaseOrdersDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

}
