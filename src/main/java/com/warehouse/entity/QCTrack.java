package com.warehouse.entity;

import java.io.Serializable;

public class QCTrack implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4522042780231039813L;

	private int id;// 编号
	private String factory;// 工厂
	private String qc;// QC
	private String b_id;// 波次号
	private String img;// 图片
	private String outTime;// 外发时间
	private String orderType;// 订单类型
	private String fabricToPlantTime;// 面料到厂时间
	private String accessoriesToPlantTime;// 辅料到长时间
	private String printtingTime;// 匹印发出时间
	private String backToTheFactoryTime;// 匹印回收时间
	private String cdPrintingTime;// 印绣裁片发出时间
	private String embroideryAndPrintingBackToTheFactoryTime;// 印绣裁片回收时间
	private String piecePickingTime;// 裁片领料时间
	private String cuttingTime;// 裁剪时间
	private String cuttingDetail;// 裁剪明细
	private String workshopProductionTime;// 车间生产时间
	private String afterTheWholeTime;// 后整时间
	private String deliveryTime;// 出货时间
	private String outNum;// 出货数量
	private String quality;// 品质
	private String order_date;//订单下单时间
	

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getQc() {
		return qc;
	}

	public void setQc(String qc) {
		this.qc = qc;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getFabricToPlantTime() {
		return fabricToPlantTime;
	}

	public void setFabricToPlantTime(String fabricToPlantTime) {
		this.fabricToPlantTime = fabricToPlantTime;
	}

	public String getAccessoriesToPlantTime() {
		return accessoriesToPlantTime;
	}

	public void setAccessoriesToPlantTime(String accessoriesToPlantTime) {
		this.accessoriesToPlantTime = accessoriesToPlantTime;
	}

	public String getPrinttingTime() {
		return printtingTime;
	}

	public void setPrinttingTime(String printtingTime) {
		this.printtingTime = printtingTime;
	}

	public String getBackToTheFactoryTime() {
		return backToTheFactoryTime;
	}

	public void setBackToTheFactoryTime(String backToTheFactoryTime) {
		this.backToTheFactoryTime = backToTheFactoryTime;
	}

	public String getCdPrintingTime() {
		return cdPrintingTime;
	}

	public void setCdPrintingTime(String cdPrintingTime) {
		this.cdPrintingTime = cdPrintingTime;
	}

	public String getEmbroideryAndPrintingBackToTheFactoryTime() {
		return embroideryAndPrintingBackToTheFactoryTime;
	}

	public void setEmbroideryAndPrintingBackToTheFactoryTime(String embroideryAndPrintingBackToTheFactoryTime) {
		this.embroideryAndPrintingBackToTheFactoryTime = embroideryAndPrintingBackToTheFactoryTime;
	}

	public String getPiecePickingTime() {
		return piecePickingTime;
	}

	public void setPiecePickingTime(String piecePickingTime) {
		this.piecePickingTime = piecePickingTime;
	}

	public String getCuttingTime() {
		return cuttingTime;
	}

	public void setCuttingTime(String cuttingTime) {
		this.cuttingTime = cuttingTime;
	}

	public String getCuttingDetail() {
		return cuttingDetail;
	}

	public void setCuttingDetail(String cuttingDetail) {
		this.cuttingDetail = cuttingDetail;
	}

	public String getWorkshopProductionTime() {
		return workshopProductionTime;
	}

	public void setWorkshopProductionTime(String workshopProductionTime) {
		this.workshopProductionTime = workshopProductionTime;
	}

	public String getAfterTheWholeTime() {
		return afterTheWholeTime;
	}

	public void setAfterTheWholeTime(String afterTheWholeTime) {
		this.afterTheWholeTime = afterTheWholeTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public QCTrack(int id, String factory, String qc, String b_id, String img, String outTime, String orderType,
			String fabricToPlantTime, String accessoriesToPlantTime, String printtingTime, String backToTheFactoryTime,
			String cdPrintingTime, String embroideryAndPrintingBackToTheFactoryTime, String piecePickingTime,
			String cuttingTime, String cuttingDetail, String workshopProductionTime, String afterTheWholeTime,
			String deliveryTime, String outNum, String quality) {
		super();
		this.id = id;
		this.factory = factory;
		this.qc = qc;
		this.b_id = b_id;
		this.img = img;
		this.outTime = outTime;
		this.orderType = orderType;
		this.fabricToPlantTime = fabricToPlantTime;
		this.accessoriesToPlantTime = accessoriesToPlantTime;
		this.printtingTime = printtingTime;
		this.backToTheFactoryTime = backToTheFactoryTime;
		this.cdPrintingTime = cdPrintingTime;
		this.embroideryAndPrintingBackToTheFactoryTime = embroideryAndPrintingBackToTheFactoryTime;
		this.piecePickingTime = piecePickingTime;
		this.cuttingTime = cuttingTime;
		this.cuttingDetail = cuttingDetail;
		this.workshopProductionTime = workshopProductionTime;
		this.afterTheWholeTime = afterTheWholeTime;
		this.deliveryTime = deliveryTime;
		this.outNum = outNum;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "QCTrack [id=" + id + ", factory=" + factory + ", qc=" + qc + ", b_id=" + b_id + ", img=" + img
				+ ", outTime=" + outTime + ", orderType=" + orderType + ", fabricToPlantTime=" + fabricToPlantTime
				+ ", accessoriesToPlantTime=" + accessoriesToPlantTime + ", printtingTime=" + printtingTime
				+ ", backToTheFactoryTime=" + backToTheFactoryTime + ", cdPrintingTime=" + cdPrintingTime
				+ ", embroideryAndPrintingBackToTheFactoryTime=" + embroideryAndPrintingBackToTheFactoryTime
				+ ", piecePickingTime=" + piecePickingTime + ", cuttingTime=" + cuttingTime + ", cuttingDetail="
				+ cuttingDetail + ", workshopProductionTime=" + workshopProductionTime + ", afterTheWholeTime="
				+ afterTheWholeTime + ", deliveryTime=" + deliveryTime + ", outNum=" + outNum + ", quality=" + quality
				+ "]";
	}

	public QCTrack() {
		super();
		// TODO Auto-generated constructor stub
	}

}
