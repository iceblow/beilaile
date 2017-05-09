package com.warehouse.entity;

public class SalesReportOfWdt {

	private String ALIAE_CODE;
	private String PRODUCT_CODE;
	private String PRODUCT_NAME;
	private Integer STOCK_NUM;
	private Integer SALES_7DAYS;
	private Integer SALES_14DAYS;
	private Integer SALES_30DAYS;
	private Integer SALES_TATOAL;
	private Integer SALES_7DAYS_AVERAGE;
	private Integer SALES_14DAYS_AVERAGE;
	private Integer SALES_30DAYS_AVERAGE;
	private Integer SALE_DAYS_WITH_7D;
	private Integer SALE_DAYS_WITH_14D;
	private Integer SALE_DAYS_WITH_30D;
	private String PRODUCT_IMG;

	private int begin;
	private int end;

	public String getPRODUCT_IMG() {
		return PRODUCT_IMG;
	}

	public void setPRODUCT_IMG(String pRODUCT_IMG) {
		PRODUCT_IMG = pRODUCT_IMG;
	}

	public String getALIAE_CODE() {
		return ALIAE_CODE;
	}

	public void setALIAE_CODE(String aLIAE_CODE) {
		ALIAE_CODE = aLIAE_CODE;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public Integer getSTOCK_NUM() {
		return STOCK_NUM;
	}

	public void setSTOCK_NUM(Integer sTOCK_NUM) {
		STOCK_NUM = sTOCK_NUM;
	}

	public Integer getSALES_7DAYS() {
		return SALES_7DAYS;
	}

	public void setSALES_7DAYS(Integer sALES_7DAYS) {
		SALES_7DAYS = sALES_7DAYS;
	}

	public Integer getSALES_14DAYS() {
		return SALES_14DAYS;
	}

	public void setSALES_14DAYS(Integer sALES_14DAYS) {
		SALES_14DAYS = sALES_14DAYS;
	}

	public Integer getSALES_30DAYS() {
		return SALES_30DAYS;
	}

	public void setSALES_30DAYS(Integer sALES_30DAYS) {
		SALES_30DAYS = sALES_30DAYS;
	}

	public Integer getSALES_TATOAL() {
		return SALES_TATOAL;
	}

	public void setSALES_TATOAL(Integer sALES_TATOAL) {
		SALES_TATOAL = sALES_TATOAL;
	}

	public Integer getSALES_7DAYS_AVERAGE() {
		return SALES_7DAYS_AVERAGE;
	}

	public void setSALES_7DAYS_AVERAGE(Integer sALES_7DAYS_AVERAGE) {
		SALES_7DAYS_AVERAGE = sALES_7DAYS_AVERAGE;
	}

	public Integer getSALES_14DAYS_AVERAGE() {
		return SALES_14DAYS_AVERAGE;
	}

	public void setSALES_14DAYS_AVERAGE(Integer sALES_14DAYS_AVERAGE) {
		SALES_14DAYS_AVERAGE = sALES_14DAYS_AVERAGE;
	}

	public Integer getSALES_30DAYS_AVERAGE() {
		return SALES_30DAYS_AVERAGE;
	}

	public void setSALES_30DAYS_AVERAGE(Integer sALES_30DAYS_AVERAGE) {
		SALES_30DAYS_AVERAGE = sALES_30DAYS_AVERAGE;
	}

	public Integer getSALE_DAYS_WITH_7D() {
		return SALE_DAYS_WITH_7D;
	}

	public void setSALE_DAYS_WITH_7D(Integer sALE_DAYS_WITH_7D) {
		SALE_DAYS_WITH_7D = sALE_DAYS_WITH_7D;
	}

	public Integer getSALE_DAYS_WITH_14D() {
		return SALE_DAYS_WITH_14D;
	}

	public void setSALE_DAYS_WITH_14D(Integer sALE_DAYS_WITH_14D) {
		SALE_DAYS_WITH_14D = sALE_DAYS_WITH_14D;
	}

	public Integer getSALE_DAYS_WITH_30D() {
		return SALE_DAYS_WITH_30D;
	}

	public void setSALE_DAYS_WITH_30D(Integer sALE_DAYS_WITH_30D) {
		SALE_DAYS_WITH_30D = sALE_DAYS_WITH_30D;
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

	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}

	public void setPRODUCT_CODE(String pRODUCT_CODE) {
		PRODUCT_CODE = pRODUCT_CODE;
	}

	public SalesReportOfWdt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SalesReportOfWdt [ALIAE_CODE=" + ALIAE_CODE + ", PRODUCT_CODE=" + PRODUCT_CODE + ", PRODUCT_NAME="
				+ PRODUCT_NAME + ", STOCK_NUM=" + STOCK_NUM + ", SALES_7DAYS=" + SALES_7DAYS + ", SALES_14DAYS="
				+ SALES_14DAYS + ", SALES_30DAYS=" + SALES_30DAYS + ", SALES_TATOAL=" + SALES_TATOAL
				+ ", SALES_7DAYS_AVERAGE=" + SALES_7DAYS_AVERAGE + ", SALES_14DAYS_AVERAGE=" + SALES_14DAYS_AVERAGE
				+ ", SALES_30DAYS_AVERAGE=" + SALES_30DAYS_AVERAGE + ", SALE_DAYS_WITH_7D=" + SALE_DAYS_WITH_7D
				+ ", SALE_DAYS_WITH_14D=" + SALE_DAYS_WITH_14D + ", SALE_DAYS_WITH_30D=" + SALE_DAYS_WITH_30D
				+ ", PRODUCT_IMG=" + PRODUCT_IMG + "]";
	}

	public SalesReportOfWdt(int begin, int end,SalesReportOfWdt salesReportOfWdt) {
		super();
		this.begin = begin;
		this.end = end;
	}

}
