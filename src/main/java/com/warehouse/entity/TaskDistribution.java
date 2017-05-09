package com.warehouse.entity;

import java.io.Serializable;

/**
 * 印绣花任务分配
 * 
 * @author admin
 *
 */
public class TaskDistribution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9200810513889647898L;

	private int id;// 编号
	private String designer;// 设计师
	private String oringinalWave;// 原波次
	private String img;// 图片
	private String wave;// 波次号
	private String processImg;// 工艺单
	private String printedVersion;// 印花稿
	private String orderSum;// 订单数量
	private String orderDetals;// 订单明细
	private String folwerFactory;// 印绣花工厂**
	private String pieceApproved;// 印花或裁片**
	private String flowerPrice;// 印绣花单价**
	private String printingPrice;// 匹印单价**
	private String piecesPrice;// 裁片印单价**
	private String orderType;// 订单类型**
	private String releaseTime;// 发版时间
	private String proofingTime;// 印绣花给样时间
	private String proofingCompletionTime;// 印绣花回样时间
	private String cuttingTime;// 制单/样衣->给到裁床日期**
	private String fabricStorageTime;// 面料入库时间
	private String fabricReleaseTime;// 面料发放时间
	private String largeCargoTime;// 匹印领料
	private String largeCargoCompletionTime;// 匹印出货
	private String cropCompletionTime;// 裁剪完成时间
	private String cropNumber;// 裁剪数
	private String cutLargeReceiveTime;// 片印领料
	private String cutLargeReturnTime;// 片印回料
	private String remark;// 备注**
	private String deleteType;// 完成状态

	public String getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}

	private int begin;
	private int end;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getOringinalWave() {
		return oringinalWave;
	}

	public void setOringinalWave(String oringinalWave) {
		this.oringinalWave = oringinalWave;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getFolwerFactory() {
		return folwerFactory;
	}

	public void setFolwerFactory(String folwerFactory) {
		this.folwerFactory = folwerFactory;
	}

	public String getPieceApproved() {
		return pieceApproved;
	}

	public void setPieceApproved(String pieceApproved) {
		this.pieceApproved = pieceApproved;
	}

	public String getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerPrice(String flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public String getPrintingPrice() {
		return printingPrice;
	}

	public void setPrintingPrice(String printingPrice) {
		this.printingPrice = printingPrice;
	}

	public String getPiecesPrice() {
		return piecesPrice;
	}

	public void setPiecesPrice(String piecesPrice) {
		this.piecesPrice = piecesPrice;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getProofingTime() {
		return proofingTime;
	}

	public void setProofingTime(String proofingTime) {
		this.proofingTime = proofingTime;
	}

	public String getProofingCompletionTime() {
		return proofingCompletionTime;
	}

	public void setProofingCompletionTime(String proofingCompletionTime) {
		this.proofingCompletionTime = proofingCompletionTime;
	}

	public String getCuttingTime() {
		return cuttingTime;
	}

	public void setCuttingTime(String cuttingTime) {
		this.cuttingTime = cuttingTime;
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

	public String getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(String orderSum) {
		this.orderSum = orderSum;
	}

	public String getOrderDetals() {
		return orderDetals;
	}

	public void setOrderDetals(String orderDetals) {
		this.orderDetals = orderDetals;
	}

	public String getFabricStorageTime() {
		return fabricStorageTime;
	}

	public void setFabricStorageTime(String fabricStorageTime) {
		this.fabricStorageTime = fabricStorageTime;
	}

	public String getFabricReleaseTime() {
		return fabricReleaseTime;
	}

	public void setFabricReleaseTime(String fabricReleaseTime) {
		this.fabricReleaseTime = fabricReleaseTime;
	}

	public String getLargeCargoTime() {
		return largeCargoTime;
	}

	public void setLargeCargoTime(String largeCargoTime) {
		this.largeCargoTime = largeCargoTime;
	}

	public String getLargeCargoCompletionTime() {
		return largeCargoCompletionTime;
	}

	public void setLargeCargoCompletionTime(String largeCargoCompletionTime) {
		this.largeCargoCompletionTime = largeCargoCompletionTime;
	}

	public String getCropCompletionTime() {
		return cropCompletionTime;
	}

	public void setCropCompletionTime(String cropCompletionTime) {
		this.cropCompletionTime = cropCompletionTime;
	}

	public String getCropNumber() {
		return cropNumber;
	}

	public void setCropNumber(String cropNumber) {
		this.cropNumber = cropNumber;
	}

	public String getCutLargeReceiveTime() {
		return cutLargeReceiveTime;
	}

	public void setCutLargeReceiveTime(String cutLargeReceiveTime) {
		this.cutLargeReceiveTime = cutLargeReceiveTime;
	}

	public String getCutLargeReturnTime() {
		return cutLargeReturnTime;
	}

	public void setCutLargeReturnTime(String cutLargeReturnTime) {
		this.cutLargeReturnTime = cutLargeReturnTime;
	}

	public String getProcessImg() {
		return processImg;
	}

	public void setProcessImg(String processImg) {
		this.processImg = processImg;
	}

	public String getPrintedVersion() {
		return printedVersion;
	}

	public void setPrintedVersion(String printedVersion) {
		this.printedVersion = printedVersion;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TaskDistribution [id=" + id + ", designer=" + designer + ", oringinalWave=" + oringinalWave + ", img="
				+ img + ", wave=" + wave + ", processImg=" + processImg + ", printedVersion=" + printedVersion
				+ ", orderSum=" + orderSum + ", orderDetals=" + orderDetals + ", folwerFactory=" + folwerFactory
				+ ", pieceApproved=" + pieceApproved + ", flowerPrice=" + flowerPrice + ", printingPrice="
				+ printingPrice + ", piecesPrice=" + piecesPrice + ", orderType=" + orderType + ", releaseTime="
				+ releaseTime + ", proofingTime=" + proofingTime + ", proofingCompletionTime=" + proofingCompletionTime
				+ ", cuttingTime=" + cuttingTime + ", fabricStorageTime=" + fabricStorageTime + ", fabricReleaseTime="
				+ fabricReleaseTime + ", largeCargoTime=" + largeCargoTime + ", largeCargoCompletionTime="
				+ largeCargoCompletionTime + ", cropCompletionTime=" + cropCompletionTime + ", cropNumber=" + cropNumber
				+ ", cutLargeReceiveTime=" + cutLargeReceiveTime + ", cutLargeReturnTime=" + cutLargeReturnTime + "]";
	}

	public TaskDistribution(int begin, int end, TaskDistribution taskDistribution) {
		super();
		this.designer = taskDistribution.getDesigner();// 设计师**1
		this.wave = taskDistribution.getWave();// 波次号**2
		this.folwerFactory = taskDistribution.getFolwerFactory();// 印绣花工厂**3
		this.pieceApproved = taskDistribution.getPieceApproved();// 印花或裁片**4
		this.flowerPrice = taskDistribution.getFlowerPrice();// 印绣花单价**5
		this.fabricStorageTime = taskDistribution.getFabricStorageTime();// 面料入库时间**6
		this.fabricReleaseTime = taskDistribution.getFabricReleaseTime();// 面料发放时间**7
		this.largeCargoTime = taskDistribution.getLargeCargoTime();// 匹印领料**8
		this.largeCargoCompletionTime = taskDistribution.getLargeCargoCompletionTime();// 匹印出货**9
		this.cropCompletionTime = taskDistribution.getCropCompletionTime();// 裁剪完成时间**0
		this.cropNumber = taskDistribution.getCropNumber();// 裁剪数**11
		this.cutLargeReceiveTime = taskDistribution.getCutLargeReceiveTime();// 片印领料**12
		this.cutLargeReturnTime = taskDistribution.getCutLargeReturnTime();// 片印回料**13
		this.orderType=taskDistribution.getOrderType();//订单类型;
		this.begin = begin;
		this.end = end;
	}

	public TaskDistribution() {
		super();
		// TODO Auto-generated constructor stub
	}

}
