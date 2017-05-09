package com.warehouse.entity;

public class ApparelDevelopmentReturn {

	private int id;

	private String returnTime;// 返单时间

	private String designer;// 设计师

	private String girard;// 波次

	private String originalWave;// 原波次

	private String referWave;// 原版波次

	private String printWave;// 印花波次

	private String model;// 款号

	private String productId;// 商品编号

	private String vendorCode;// 供应商编号

	private String clothName;// 服装名

	private String designImg;// 设计图

	private String sampleImg;// 头样图

	private String sizeChart;// 尺码表

	private String paperpatternEmfFile;// 样EMF

	private String paperpatternPrjFile;// 样PRJ

	private int code52;

	private int code59;

	private int code66;

	private int code73;

	private int code80;

	private int code90;

	private int code100;

	private int code110;

	private int code120;

	private int code130;

	private int code160;

	private int code170;

	private int count;// 总件数

	private String expectTime;// 预计出库时间

	private String remark;// 备注

	private int delb;

	private String pcIp;// IP地址

	private String operation;

	private String operator;

	private String addTime;

	private String updateTime;

	private String delTime;

	private Integer urgentState;// 加急状态

	private String storageTime;

	private String storageNumber;

	private String goodsId;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}

	public String getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(String storageNumber) {
		this.storageNumber = storageNumber;
	}

	/**
	 * 分页
	 * 
	 * @return
	 */
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime == null ? null : returnTime.trim();
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer == null ? null : designer.trim();
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard == null ? null : girard.trim();
	}

	public String getOriginalWave() {
		return originalWave;
	}

	public void setOriginalWave(String originalWave) {
		this.originalWave = originalWave == null ? null : originalWave.trim();
	}

	public String getReferWave() {
		return referWave;
	}

	public void setReferWave(String referWave) {
		this.referWave = referWave == null ? null : referWave.trim();
	}

	public String getPrintWave() {
		return printWave;
	}

	public void setPrintWave(String printWave) {
		this.printWave = printWave == null ? null : printWave.trim();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model == null ? null : model.trim();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId == null ? null : productId.trim();
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode == null ? null : vendorCode.trim();
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

	public String getSizeChart() {
		return sizeChart;
	}

	public void setSizeChart(String sizeChart) {
		this.sizeChart = sizeChart == null ? null : sizeChart.trim();
	}

	public String getPaperpatternEmfFile() {
		return paperpatternEmfFile;
	}

	public void setPaperpatternEmfFile(String paperpatternEmfFile) {
		this.paperpatternEmfFile = paperpatternEmfFile == null ? null : paperpatternEmfFile.trim();
	}

	public String getPaperpatternPrjFile() {
		return paperpatternPrjFile;
	}

	public void setPaperpatternPrjFile(String paperpatternPrjFile) {
		this.paperpatternPrjFile = paperpatternPrjFile == null ? null : paperpatternPrjFile.trim();
	}

	public int getCode52() {
		return code52;
	}

	public void setCode52(int code52) {
		this.code52 = code52;
	}

	public int getCode59() {
		return code59;
	}

	public void setCode59(int code59) {
		this.code59 = code59;
	}

	public int getCode66() {
		return code66;
	}

	public void setCode66(int code66) {
		this.code66 = code66;
	}

	public int getCode73() {
		return code73;
	}

	public void setCode73(int code73) {
		this.code73 = code73;
	}

	public int getCode80() {
		return code80;
	}

	public void setCode80(int code80) {
		this.code80 = code80;
	}

	public int getCode90() {
		return code90;
	}

	public void setCode90(int code90) {
		this.code90 = code90;
	}

	public int getCode100() {
		return code100;
	}

	public int getCode110() {
		return code110;
	}

	public int getCode120() {
		return code120;
	}

	public int getCode130() {
		return code130;
	}

	public int getCode160() {
		return code160;
	}

	public void setCode100(int code100) {
		this.code100 = code100;
	}

	public void setCode110(int code110) {
		this.code110 = code110;
	}

	public void setCode120(int code120) {
		this.code120 = code120;
	}

	public void setCode130(int code130) {
		this.code130 = code130;
	}

	public void setCode160(int code160) {
		this.code160 = code160;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getUrgentState() {
		return urgentState;
	}

	public void setUrgentState(Integer urgentState) {
		this.urgentState = urgentState;
	}

	public int getDelb() {
		return delb;
	}

	public void setDelb(int delb) {
		this.delb = delb;
	}

	public String getPcIp() {
		return pcIp;
	}

	public void setPcIp(String pcIp) {
		this.pcIp = pcIp == null ? null : pcIp.trim();
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation == null ? null : operation.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime == null ? null : delTime.trim();
	}

	public ApparelDevelopmentReturn(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public ApparelDevelopmentReturn() {
		super();
		// TODO 空
	}

	public ApparelDevelopmentReturn(String girard, String designer, String originalWave, String referWave,
			String printWave, String model, String productId, String vendorCode, String clothName, String sizeChart,
			int begin, int end) {
		super();
		this.girard = girard;
		this.designer = designer;
		this.originalWave = originalWave;
		this.referWave = referWave;
		this.printWave = printWave;
		this.model = model;
		this.productId = productId;
		this.vendorCode = vendorCode;
		this.clothName = clothName;
		this.sizeChart = sizeChart;
		this.begin = begin;
		this.end = end;
	}

	@Override
	public String toString() {
		return "ApparelDevelopmentReturn [id=" + id + ", returnTime=" + returnTime + ", designer=" + designer
				+ ", girard=" + girard + ", originalWave=" + originalWave + ", referWave=" + referWave + ", printWave="
				+ printWave + ", model=" + model + ", productId=" + productId + ", vendorCode=" + vendorCode
				+ ", clothName=" + clothName + ", designImg=" + designImg + ", sampleImg=" + sampleImg + ", sizeChart="
				+ sizeChart + ", paperpatternEmfFile=" + paperpatternEmfFile + ", paperpatternPrjFile="
				+ paperpatternPrjFile + ", code52=" + code52 + ", code59=" + code59 + ", code66=" + code66 + ", code73="
				+ code73 + ", code80=" + code80 + ", code90=" + code90 + ", count=" + count + ", expectTime="
				+ expectTime + ", remark=" + remark + ", delb=" + delb + ", pcIp=" + pcIp + ", operation=" + operation
				+ ", operator=" + operator + ", addTime=" + addTime + ", updateTime=" + updateTime + ", delTime="
				+ delTime + ", begin=" + begin + ", end=" + end + "]";
	}

	public int getCode170() {
		return code170;
	}

	public void setCode170(int code170) {
		this.code170 = code170;
	}

}