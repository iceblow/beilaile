package com.warehouse.entity;

import java.io.Serializable;

public class SalesSlowMovingStock implements Serializable {

	private String ALIAE_CODE;// 商品尺码编码
	private String PRODUCT_CODE;// 货品编码
	private Integer STOCK_NUM;// 库存数量
	private Integer SALES_TOTAL;// 历史售量
	private String PRODUCT_IMG;// 货品图片
	private String REPORT_DATE;// 报告日期

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

	public String getALIAE_CODE() {
		return ALIAE_CODE;
	}

	public void setALIAE_CODE(String aLIAE_CODE) {
		ALIAE_CODE = aLIAE_CODE;
	}

	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}

	public void setPRODUCT_CODE(String pRODUCT_CODE) {
		PRODUCT_CODE = pRODUCT_CODE;
	}

	public Integer getSTOCK_NUM() {
		return STOCK_NUM;
	}

	public void setSTOCK_NUM(Integer sTOCK_NUM) {
		STOCK_NUM = sTOCK_NUM;
	}

	public Integer getSALES_TOTAL() {
		return SALES_TOTAL;
	}

	public void setSALES_TOTAL(Integer sALES_TOTAL) {
		SALES_TOTAL = sALES_TOTAL;
	}

	public String getPRODUCT_IMG() {
		return PRODUCT_IMG;
	}

	public void setPRODUCT_IMG(String pRODUCT_IMG) {
		PRODUCT_IMG = pRODUCT_IMG;
	}

	public String getREPORT_DATE() {
		return REPORT_DATE;
	}

	public void setREPORT_DATE(String rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}

	public SalesSlowMovingStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SalesSlowMovingStock [ALIAE_CODE=" + ALIAE_CODE + ", PRODUCT_CODE=" + PRODUCT_CODE + ", STOCK_NUM="
				+ STOCK_NUM + ", SALES_TOTAL=" + SALES_TOTAL + ", PRODUCT_IMG=" + PRODUCT_IMG + ", REPORT_DATE="
				+ REPORT_DATE + "]";
	}

	public SalesSlowMovingStock(int begin, int end, SalesSlowMovingStock salesSlowMovingStock) {
		super();
		ALIAE_CODE = salesSlowMovingStock.getALIAE_CODE();
		PRODUCT_CODE = salesSlowMovingStock.getPRODUCT_CODE();
		STOCK_NUM = salesSlowMovingStock.getSTOCK_NUM();
		SALES_TOTAL = salesSlowMovingStock.getSALES_TOTAL();
		PRODUCT_IMG = salesSlowMovingStock.getPRODUCT_IMG();
		REPORT_DATE = salesSlowMovingStock.getREPORT_DATE();
		this.begin = begin;
		this.end = end;
	}

}
