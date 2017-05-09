package com.warehouse.entity;

import java.io.Serializable;

/**
 * 浩讯入库详情
 * 
 * @author admin
 *
 */
public class InputStorageHaoXun implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1461559404159406265L;
	private String product_code;// 商品编号
	private String product_img;// 商品图片
	private String deliveryDate;// 发货日期
	private String artNo;// 货号
	private String season;// 季节
	private String series;// 系列
	private String wave;// 波次号
	private Integer num;// 数量
	private Integer code52;// 尺码52
	private Integer code59;// 尺码59
	private Integer code66;// 尺码66
	private Integer code73;// 尺码73
	private Integer code80;// 尺码80
	private Integer code90;// 尺码90
	private Integer code100;// 尺码100
	private Integer code110;// 尺码110
	private Integer code120;// 尺码120
	private Integer code130;// 尺码130
	private Integer code160;// 尺码160
	private Integer code170;// 尺码170

	private int begin;// 起始页
	private int end;// 末尾页

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

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getArtNo() {
		return artNo;
	}

	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getCode52() {
		return code52;
	}

	public void setCode52(Integer code52) {
		this.code52 = code52;
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

	/**
	 * 方便打印测试数据
	 */
	@Override
	public String toString() {
		return "InputStorageHaoXun [product_code=" + product_code + ", product_img=" + product_img + ", deliveryDate="
				+ deliveryDate + ", artNo=" + artNo + ", season=" + season + ", series=" + series + ", wave=" + wave
				+ ", num=" + num + ", code52=" + code52 + ", code59=" + code59 + ", code66=" + code66 + ", code73="
				+ code73 + ", code80=" + code80 + ", code90=" + code90 + ", code100=" + code100 + ", code110=" + code110
				+ ", code120=" + code120 + ", code130=" + code130 + ", code160=" + code160 + ", code170=" + code170
				+ "]";
	}

	/**
	 * 模糊查询分页时使用的构造方法 便于参数的整合
	 * 
	 * @param begin
	 * @param end
	 * @param inputStorageHaoXun
	 */
	public InputStorageHaoXun(int begin, int end, InputStorageHaoXun inputStorageHaoXun) {
		super();
		this.product_code = inputStorageHaoXun.getProduct_code();// 商品编码
		this.product_img = inputStorageHaoXun.getProduct_img();// 商品图片
		this.deliveryDate = inputStorageHaoXun.getDeliveryDate();// 发货日期
		this.artNo = inputStorageHaoXun.getArtNo();// 货号
		this.season = inputStorageHaoXun.getSeason();// 季节
		this.series = inputStorageHaoXun.getSeries();// 系列
		this.wave = inputStorageHaoXun.getWave();// 波次
		this.num = inputStorageHaoXun.getNum();// 数量
		this.code52 = inputStorageHaoXun.getCode52();// 尺码52
		this.code59 = inputStorageHaoXun.getCode59();// 尺码59
		this.code66 = inputStorageHaoXun.getCode66();// 尺码66
		this.code73 = inputStorageHaoXun.getCode73();// 尺码73
		this.code80 = inputStorageHaoXun.getCode80();// 尺码80
		this.code90 = inputStorageHaoXun.getCode90();// 尺码90
		this.code100 = inputStorageHaoXun.getCode100();// 尺码100
		this.code110 = inputStorageHaoXun.getCode110();// 尺码110
		this.code120 = inputStorageHaoXun.getCode120();// 尺码120
		this.code130 = inputStorageHaoXun.getCode130();// 尺码130
		this.code160 = inputStorageHaoXun.getCode160();// 尺码160
		this.code170 = inputStorageHaoXun.getCode170();// 尺码170
		this.begin = begin;// 起始页
		this.end = end;// 末尾页
	}

	public InputStorageHaoXun() {
		super();
		// TODO Auto-generated constructor stub
	}

}
