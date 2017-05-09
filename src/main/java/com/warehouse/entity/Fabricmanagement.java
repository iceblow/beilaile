package com.warehouse.entity;

public class Fabricmanagement {

	private Integer begin;
	private Integer end;

	private Integer inputId;
	private String inputDate;// 入库时间
	private String wave;// 波次
	private String fabricMaterial;// 面料品名
	private String inputAmount;// 入库总条数
	private String outputAmount;// 出库总条数
	private String gapAmount;// 相差条数
	private String totalPurchases;// 采购条数
	private String inputGapAmount;// 未入库条数

	public String getTotalPurchases() {
		return totalPurchases;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public void setTotalPurchases(String totalPurchases) {
		this.totalPurchases = totalPurchases;
	}

	public String getInputGapAmount() {
		return inputGapAmount;
	}

	public void setInputGapAmount(String inputGapAmount) {
		this.inputGapAmount = inputGapAmount;
	}

	public Integer getInputId() {
		return inputId;
	}

	public void setInputId(Integer inputId) {
		this.inputId = inputId;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getFabricMaterial() {
		return fabricMaterial;
	}

	public void setFabricMaterial(String fabricMaterial) {
		this.fabricMaterial = fabricMaterial;
	}

	public String getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(String inputAmount) {
		this.inputAmount = inputAmount;
	}

	public String getOutputAmount() {
		return outputAmount;
	}

	public void setOutputAmount(String outputAmount) {
		this.outputAmount = outputAmount;
	}

	public String getGapAmount() {
		return gapAmount;
	}

	public void setGapAmount(String gapAmount) {
		this.gapAmount = gapAmount;
	}

	public Fabricmanagement(Integer begin, Integer end, String wave) {
		super();
		this.begin = begin;
		this.end = end;
		this.wave = wave;
	}

	public Fabricmanagement() {
		super();
		// TODO Auto-generated constructor stub
	}

}
