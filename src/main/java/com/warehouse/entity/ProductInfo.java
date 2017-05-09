package com.warehouse.entity;

public class ProductInfo {

	private Integer id;// 序号
	private String wave;// 波次
	private String productCodes;// 商品编号
	private String productName;// 商品名称
	private String productShortName;// 商品简称
	private String excleFile;// excle文件
	private String productImg;// 商品图片

	private String processImg;// 工艺单
	private String sizeImg;// 尺码表

	private Integer deleteType;// 删除标识
	private String productOldName;// 老的商品名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(String productCodes) {
		this.productCodes = productCodes;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public String getExcleFile() {
		return excleFile;
	}

	public void setExcleFile(String excleFile) {
		this.excleFile = excleFile;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public Integer getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(Integer deleteType) {
		this.deleteType = deleteType;
	}

	public String getProductOldName() {
		return productOldName;
	}

	public void setProductOldName(String productOldName) {
		this.productOldName = productOldName;
	}

	public String getProcessImg() {
		return processImg;
	}

	public void setProcessImg(String processImg) {
		this.processImg = processImg;
	}

	public String getSizeImg() {
		return sizeImg;
	}

	public void setSizeImg(String sizeImg) {
		this.sizeImg = sizeImg;
	}

	private Integer begin;
	private Integer end;

	public ProductInfo(Integer begin, Integer end, ProductInfo productInfo) {
		super();
		this.id = productInfo.getId();
		this.wave = productInfo.getWave();
		this.productCodes = productInfo.getProductCodes();
		this.productName = productInfo.getProductName();
		this.excleFile = productInfo.getExcleFile();
		this.productImg = productInfo.getProductImg();
		this.productOldName = productInfo.getProductOldName();
		this.begin = begin;
		this.end = end;
	}

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", wave=" + wave + ", productCodes=" + productCodes + ", productName="
				+ productName + ", productShortName=" + productShortName + ", excleFile=" + excleFile + ", productImg="
				+ productImg + ", processImg=" + processImg + ", sizeImg=" + sizeImg + ", deleteType=" + deleteType
				+ ", productOldName=" + productOldName + "]";
	}

}
