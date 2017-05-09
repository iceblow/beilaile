package com.warehouse.entity;

import java.io.Serializable;

public class ProductTaoBaoInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8679533476735105255L;
	private String product_name;// 商品名称
	private String product_img;// 商品图片
	private String product_code;// 商品编号
	private String goodsId;// 货品ID
	private String norms_code;// 规格编号
	private String normsID;// 规格ID
	private Integer taobao_inventory;// 淘宝库存

	private int begin;
	private int end;

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getNorms_code() {
		return norms_code;
	}

	public void setNorms_code(String norms_code) {
		this.norms_code = norms_code;
	}

	public String getNormsID() {
		return normsID;
	}

	public void setNormsID(String normsID) {
		this.normsID = normsID;
	}

	public Integer getTaobao_inventory() {
		return taobao_inventory;
	}

	public void setTaobao_inventory(Integer taobao_inventory) {
		this.taobao_inventory = taobao_inventory;
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

	public ProductTaoBaoInfo(int begin, int end, ProductTaoBaoInfo taoBaoInfo) {
		super();
		this.product_name = taoBaoInfo.getProduct_name();// 商品名称
		this.product_img = taoBaoInfo.getProduct_img();// 商品图片
		this.product_code = taoBaoInfo.getProduct_code();// 商品编号
		this.goodsId = taoBaoInfo.getGoodsId();// 货品ID
		this.norms_code = taoBaoInfo.getNorms_code();// 规格编号
		this.normsID = taoBaoInfo.getNormsID();// 规格ID
		this.taobao_inventory = taoBaoInfo.getTaobao_inventory();// 平台库存数量
		this.begin = begin;
		this.end = end;
	}

	public ProductTaoBaoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductTaoBaoInfo [product_name=" + product_name + ", product_img=" + product_img + ", product_code="
				+ product_code + ", goodsId=" + goodsId + ", norms_code=" + norms_code + ", normsID=" + normsID
				+ ", taobao_inventory=" + taobao_inventory + "]";
	}

}
