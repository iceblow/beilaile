package com.warehouse.util;

import com.warehouse.entity.QCTrack;

/**
 * 分页工具类
 * 
 * @author Administrator
 *
 */
public class CaoUtil {
	private Integer begin;
	private Integer end;

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

	// -----------------------查询的数据-------------------------
	private String factory;// 工厂
	private String qc;// QC
	private String b_id;// 波次号
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

	public String getb_id() {
		return b_id;
	}

	public void setb_id(String b_id) {
		this.b_id = b_id;
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

	// -----------------------qc查询结束--------------------------
	public CaoUtil(QCTrack qcTrack, Integer begin, Integer end) {
		super();

		this.factory = qcTrack.getFactory();
		this.qc = qcTrack.getQc();
		this.b_id = qcTrack.getB_id();
		this.outTime = qcTrack.getOutTime();
		this.orderType = qcTrack.getOrderType();
		this.fabricToPlantTime = qcTrack.getFabricToPlantTime();
		this.accessoriesToPlantTime = qcTrack.getAccessoriesToPlantTime();
		this.printtingTime = qcTrack.getPrinttingTime();
		this.backToTheFactoryTime = qcTrack.getBackToTheFactoryTime();
		this.cdPrintingTime = qcTrack.getCdPrintingTime();
		this.embroideryAndPrintingBackToTheFactoryTime = qcTrack.getEmbroideryAndPrintingBackToTheFactoryTime();
		this.piecePickingTime = qcTrack.getPiecePickingTime();
		this.cuttingTime = qcTrack.getCuttingTime();
		this.cuttingDetail = qcTrack.getCuttingDetail();
		this.workshopProductionTime = qcTrack.getWorkshopProductionTime();
		this.afterTheWholeTime = qcTrack.getAfterTheWholeTime();
		this.deliveryTime = qcTrack.getDeliveryTime();
		this.outNum = qcTrack.getOutNum();
		this.quality = qcTrack.getQuality();

		this.begin = begin;
		this.end = end;
	}

}
