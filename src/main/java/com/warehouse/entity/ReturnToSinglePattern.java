package com.warehouse.entity;

import java.io.Serializable;

public class ReturnToSinglePattern implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3987825777951647168L;

	private Integer id;// 序号

	private String returnTime;// 返单时间

	private String wave;// 波次号

	private String oringinalWave;// 原波次

	private String productCode;// 商品编号

	private String clothName;// 服装名

	private String designImg;// 设计图

	private String sampleImg;// 工艺单

	private String sizeImg;// 尺码图

	private String needToBeSampleCloth;// 需要样衣

	private String needToBeSampleClothTime;// 需要样衣时间

	private String pieceSampleComplete;// 纸样完成

	private String pieceSampleCompleteTime;// 纸样完成时间

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

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime == null ? null : returnTime.trim();
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave == null ? null : oringinalWave.trim();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
	}

	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName == null ? null : clothName.trim();
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg == null ? null : designImg.trim();
	}

	public String getSampleImg() {
		return sampleImg;
	}

	public void setSampleImg(String sampleImg) {
		this.sampleImg = sampleImg == null ? null : sampleImg.trim();
	}

	public String getSizeImg() {
		return sizeImg;
	}

	public void setSizeImg(String sizeImg) {
		this.sizeImg = sizeImg == null ? null : sizeImg.trim();
	}

	public String getNeedToBeSampleCloth() {
		return needToBeSampleCloth;
	}

	public void setNeedToBeSampleCloth(String needToBeSampleCloth) {
		this.needToBeSampleCloth = needToBeSampleCloth == null ? null : needToBeSampleCloth.trim();
	}

	public String getNeedToBeSampleClothTime() {
		return needToBeSampleClothTime;
	}

	public void setNeedToBeSampleClothTime(String needToBeSampleClothTime) {
		this.needToBeSampleClothTime = needToBeSampleClothTime == null ? null : needToBeSampleClothTime.trim();
	}

	public String getPieceSampleComplete() {
		return pieceSampleComplete;
	}

	public void setPieceSampleComplete(String pieceSampleComplete) {
		this.pieceSampleComplete = pieceSampleComplete == null ? null : pieceSampleComplete.trim();
	}

	public String getPieceSampleCompleteTime() {
		return pieceSampleCompleteTime;
	}

	public void setPieceSampleCompleteTime(String pieceSampleCompleteTime) {
		this.pieceSampleCompleteTime = pieceSampleCompleteTime == null ? null : pieceSampleCompleteTime.trim();
	}

	@Override
	public String toString() {
		return "ReturnToSinglePattern [id=" + id + ", returnTime=" + returnTime + ", wave=" + wave + ", oringinalWave="
				+ oringinalWave + ", productCode=" + productCode + ", clothName=" + clothName + ", designImg="
				+ designImg + ", sampleImg=" + sampleImg + ", sizeImg=" + sizeImg + ", needToBeSampleCloth="
				+ needToBeSampleCloth + ", needToBeSampleClothTime=" + needToBeSampleClothTime
				+ ", pieceSampleComplete=" + pieceSampleComplete + ", pieceSampleCompleteTime="
				+ pieceSampleCompleteTime + "]";
	}

	/**
	 * @作者:Earl
	 * @作用:传入模糊查询条件
	 * @param begin
	 *            起始条数
	 * @param end
	 *            末尾条数
	 * @param returnToSinglePattern
	 *            不同的模糊查询条件
	 */
	public ReturnToSinglePattern(int begin, int end, ReturnToSinglePattern returnToSinglePattern) {
		super();
		this.id = returnToSinglePattern.getId();
		this.returnTime = returnToSinglePattern.getReturnTime();
		this.wave = returnToSinglePattern.getWave();
		this.oringinalWave = returnToSinglePattern.getOringinalWave();
		this.productCode = returnToSinglePattern.getProductCode();
		this.clothName = returnToSinglePattern.getClothName();
		this.designImg = returnToSinglePattern.getDesignImg();
		this.sampleImg = returnToSinglePattern.getSampleImg();
		this.sizeImg = returnToSinglePattern.getSizeImg();
		this.needToBeSampleCloth = returnToSinglePattern.getNeedToBeSampleCloth();
		this.needToBeSampleClothTime = returnToSinglePattern.getNeedToBeSampleClothTime();
		this.pieceSampleComplete = returnToSinglePattern.getPieceSampleComplete();
		this.pieceSampleCompleteTime = returnToSinglePattern.getPieceSampleCompleteTime();
		this.begin = begin;
		this.end = end;
	}

	public ReturnToSinglePattern() {
		super();
		// TODO Auto-generated constructor stub
	}

}