package com.warehouse.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PrintingFabricArrange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2556570430394484138L;

	private Integer id;

	private String additionTime;// 添加日期

	private String wave;// 波次

	private String designImg;// 产品图

	private String fabricMaterial;// 面料材质

	private String colour;// 颜色

	private Double parameter1;// 面料1

	private Double parameter2;// 面料2

	private Double parameter3;// 面料3

	private Double parameter4;// 面料4

	private Double parameter5;// 面料5

	private Double parameter6;// 面料6

	private Double parameter7;// 面料7

	private Double parameter8;// 面料8

	private Double parameter9;// 面料9

	private Double parameter10;// 面料10

	private Double parameter11;// 面料11

	private Double parameter12;// 面料12

	private Double parameter13;// 面料13

	private Double parameter14;// 面料14

	private Double parameter15;// 面料15

	private Double parameter16;// 面料16

	private Double parameter17;// 面料17

	private Double parameter18;// 面料18

	private String kgM;// 单位

	private Integer totalCount;// 面料总条数

	private String state;// 删除状态

	private String remarks;// 备注

	private String addTime;// 记录添加时间

	private String updateTime;// 记录更新时间

	private String delTime;// 记录删除时间

	private String materials;// 单件用料

	private String numberOrder;// 订单采购件数

	private String supplier;// 面料供应商

	private String scheduledNumber;// 预定条数

	private String recipient;// 收件人

	private String recipientAddress;// 收货地址

	private String fabricType;// 用料位置

	private String purchasingStatus;// 采购状态

	private Double actualdosage;// 用料总米数

	private BigDecimal fabricprices;// 面料单价

	private Double weight;// 面料总重量

	private String combinedwave;// 面料合用波次

	private Double difference;// 面料空差

	private Double totalweight;// 求和

	private BigDecimal totalmount;// 总金额

	private String purchasingOrderTime;// 下订单时间

	private String purchasingPaymentTime;// 付款时间

	private String purchasingReceiptTime;// 收货时间

	private String purchasingGiveoutTime;// 发出时间

	private String craftsOrder;// 工艺单

	private String piecesApproved;// 裁片类型

	private BigDecimal fabricfreight;// 面料运费

	private String kindsOfFabric;// 面料种类数--ABC料数

	private String orderType;// 订单类型

	private String factory;// 车缝工厂

	private String folwerFactory;// 印绣工厂

	private String fabricIsReadyStatus;// 面料已准备就绪状态

	private String fabricIsReadyTime;// 面料已准备就绪时间

	private String fabricFeedback;// 面料反馈
	
	private String fabrciIssueState;//面料发放状态

	private int begin;
	
	private int end;
	
	public String getFabrciIssueState() {
		return fabrciIssueState;
	}

	public void setFabrciIssueState(String fabrciIssueState) {
		this.fabrciIssueState = fabrciIssueState;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdditionTime() {
		return additionTime;
	}

	public void setAdditionTime(String additionTime) {
		this.additionTime = additionTime;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getDesignImg() {
		return designImg;
	}

	public void setDesignImg(String designImg) {
		this.designImg = designImg;
	}

	public String getFabricMaterial() {
		return fabricMaterial;
	}

	public void setFabricMaterial(String fabricMaterial) {
		this.fabricMaterial = fabricMaterial;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getParameter1() {
		return parameter1;
	}

	public void setParameter1(Double parameter1) {
		this.parameter1 = parameter1;
	}

	public Double getParameter2() {
		return parameter2;
	}

	public void setParameter2(Double parameter2) {
		this.parameter2 = parameter2;
	}

	public Double getParameter3() {
		return parameter3;
	}

	public void setParameter3(Double parameter3) {
		this.parameter3 = parameter3;
	}

	public Double getParameter4() {
		return parameter4;
	}

	public void setParameter4(Double parameter4) {
		this.parameter4 = parameter4;
	}

	public Double getParameter5() {
		return parameter5;
	}

	public void setParameter5(Double parameter5) {
		this.parameter5 = parameter5;
	}

	public Double getParameter6() {
		return parameter6;
	}

	public void setParameter6(Double parameter6) {
		this.parameter6 = parameter6;
	}

	public Double getParameter7() {
		return parameter7;
	}

	public void setParameter7(Double parameter7) {
		this.parameter7 = parameter7;
	}

	public Double getParameter8() {
		return parameter8;
	}

	public void setParameter8(Double parameter8) {
		this.parameter8 = parameter8;
	}

	public Double getParameter9() {
		return parameter9;
	}

	public void setParameter9(Double parameter9) {
		this.parameter9 = parameter9;
	}

	public Double getParameter10() {
		return parameter10;
	}

	public void setParameter10(Double parameter10) {
		this.parameter10 = parameter10;
	}

	public Double getParameter11() {
		return parameter11;
	}

	public void setParameter11(Double parameter11) {
		this.parameter11 = parameter11;
	}

	public Double getParameter12() {
		return parameter12;
	}

	public void setParameter12(Double parameter12) {
		this.parameter12 = parameter12;
	}

	public Double getParameter13() {
		return parameter13;
	}

	public void setParameter13(Double parameter13) {
		this.parameter13 = parameter13;
	}

	public Double getParameter14() {
		return parameter14;
	}

	public void setParameter14(Double parameter14) {
		this.parameter14 = parameter14;
	}

	public Double getParameter15() {
		return parameter15;
	}

	public void setParameter15(Double parameter15) {
		this.parameter15 = parameter15;
	}

	public Double getParameter16() {
		return parameter16;
	}

	public void setParameter16(Double parameter16) {
		this.parameter16 = parameter16;
	}

	public Double getParameter17() {
		return parameter17;
	}

	public void setParameter17(Double parameter17) {
		this.parameter17 = parameter17;
	}

	public Double getParameter18() {
		return parameter18;
	}

	public void setParameter18(Double parameter18) {
		this.parameter18 = parameter18;
	}

	public String getKgM() {
		return kgM;
	}

	public void setKgM(String kgM) {
		this.kgM = kgM;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(String numberOrder) {
		this.numberOrder = numberOrder;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getScheduledNumber() {
		return scheduledNumber;
	}

	public void setScheduledNumber(String scheduledNumber) {
		this.scheduledNumber = scheduledNumber;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getFabricType() {
		return fabricType;
	}

	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}

	public String getPurchasingStatus() {
		return purchasingStatus;
	}

	public void setPurchasingStatus(String purchasingStatus) {
		this.purchasingStatus = purchasingStatus;
	}

	public Double getActualdosage() {
		return actualdosage;
	}

	public void setActualdosage(Double actualdosage) {
		this.actualdosage = actualdosage;
	}

	public BigDecimal getFabricprices() {
		return fabricprices;
	}

	public void setFabricprices(BigDecimal fabricprices) {
		this.fabricprices = fabricprices;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getCombinedwave() {
		return combinedwave;
	}

	public void setCombinedwave(String combinedwave) {
		this.combinedwave = combinedwave;
	}

	public Double getDifference() {
		return difference;
	}

	public void setDifference(Double difference) {
		this.difference = difference;
	}

	public Double getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}

	public BigDecimal getTotalmount() {
		return totalmount;
	}

	public void setTotalmount(BigDecimal totalmount) {
		this.totalmount = totalmount;
	}

	public String getPurchasingOrderTime() {
		return purchasingOrderTime;
	}

	public void setPurchasingOrderTime(String purchasingOrderTime) {
		this.purchasingOrderTime = purchasingOrderTime;
	}

	public String getPurchasingPaymentTime() {
		return purchasingPaymentTime;
	}

	public void setPurchasingPaymentTime(String purchasingPaymentTime) {
		this.purchasingPaymentTime = purchasingPaymentTime;
	}

	public String getPurchasingReceiptTime() {
		return purchasingReceiptTime;
	}

	public void setPurchasingReceiptTime(String purchasingReceiptTime) {
		this.purchasingReceiptTime = purchasingReceiptTime;
	}

	public String getPurchasingGiveoutTime() {
		return purchasingGiveoutTime;
	}

	public void setPurchasingGiveoutTime(String purchasingGiveoutTime) {
		this.purchasingGiveoutTime = purchasingGiveoutTime;
	}

	public String getCraftsOrder() {
		return craftsOrder;
	}

	public void setCraftsOrder(String craftsOrder) {
		this.craftsOrder = craftsOrder;
	}

	public String getPiecesApproved() {
		return piecesApproved;
	}

	public void setPiecesApproved(String piecesApproved) {
		this.piecesApproved = piecesApproved;
	}

	public BigDecimal getFabricfreight() {
		return fabricfreight;
	}

	public void setFabricfreight(BigDecimal fabricfreight) {
		this.fabricfreight = fabricfreight;
	}

	public String getKindsOfFabric() {
		return kindsOfFabric;
	}

	public void setKindsOfFabric(String kindsOfFabric) {
		this.kindsOfFabric = kindsOfFabric;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getFolwerFactory() {
		return folwerFactory;
	}

	public void setFolwerFactory(String folwerFactory) {
		this.folwerFactory = folwerFactory;
	}

	public String getFabricIsReadyStatus() {
		return fabricIsReadyStatus;
	}

	public void setFabricIsReadyStatus(String fabricIsReadyStatus) {
		this.fabricIsReadyStatus = fabricIsReadyStatus;
	}

	public String getFabricIsReadyTime() {
		return fabricIsReadyTime;
	}

	public void setFabricIsReadyTime(String fabricIsReadyTime) {
		this.fabricIsReadyTime = fabricIsReadyTime;
	}

	public String getFabricFeedback() {
		return fabricFeedback;
	}

	public void setFabricFeedback(String fabricFeedback) {
		this.fabricFeedback = fabricFeedback;
	}

	@Override
	public String toString() {
		return "FabricOutflowReady [id=" + id + ", additionTime=" + additionTime + ", wave=" + wave + ", designImg="
				+ designImg + ", fabricMaterial=" + fabricMaterial + ", colour=" + colour + ", parameter1=" + parameter1
				+ ", parameter2=" + parameter2 + ", parameter3=" + parameter3 + ", parameter4=" + parameter4
				+ ", parameter5=" + parameter5 + ", parameter6=" + parameter6 + ", parameter7=" + parameter7
				+ ", parameter8=" + parameter8 + ", parameter9=" + parameter9 + ", parameter10=" + parameter10
				+ ", parameter11=" + parameter11 + ", parameter12=" + parameter12 + ", parameter13=" + parameter13
				+ ", parameter14=" + parameter14 + ", parameter15=" + parameter15 + ", parameter16=" + parameter16
				+ ", parameter17=" + parameter17 + ", parameter18=" + parameter18 + ", kgM=" + kgM + ", totalCount="
				+ totalCount + ", state=" + state + ", remarks=" + remarks + ", addTime=" + addTime + ", updateTime="
				+ updateTime + ", delTime=" + delTime + ", materials=" + materials + ", numberOrder=" + numberOrder
				+ ", supplier=" + supplier + ", scheduledNumber=" + scheduledNumber + ", recipient=" + recipient
				+ ", recipientAddress=" + recipientAddress + ", fabricType=" + fabricType + ", purchasingStatus="
				+ purchasingStatus + ", actualdosage=" + actualdosage + ",fabricprices=" + fabricprices + ", weight="
				+ weight + ", combinedwave=" + combinedwave + ", difference=" + difference + ", totalweight="
				+ totalweight + ", totalmount=" + totalmount + ",purchasingOrderTime=" + purchasingOrderTime
				+ ", purchasingPaymentTime=" + purchasingPaymentTime + ", purchasingReceiptTime="
				+ purchasingReceiptTime + ", purchasingGiveoutTime=" + purchasingGiveoutTime + ", craftsOrder="
				+ craftsOrder + ", piecesApproved=" + piecesApproved + ",fabricfreight=" + fabricfreight
				+ ", kindsOfFabric=" + kindsOfFabric + ", orderType=" + orderType + ", factory=" + factory
				+ ", folwerFactory=" + folwerFactory + ",fabricIsReadyStatus=" + fabricIsReadyStatus
				+ ", fabricIsReadyTime=" + fabricIsReadyTime + ",fabricFeedback=" + fabricFeedback + "]";
	}

	public PrintingFabricArrange(int begin, int end, PrintingFabricArrange fabricOutflowReady) {
		super();
		this.id = fabricOutflowReady.getId();
		this.additionTime = fabricOutflowReady.getAdditionTime();// 添加日期
		this.wave = fabricOutflowReady.getWave();// 波次号
		this.designImg = fabricOutflowReady.getDesignImg();// 产品图
		this.fabricMaterial = fabricOutflowReady.getFabricMaterial();// 面料材质
		this.colour = fabricOutflowReady.getColour();// 颜色
		this.kgM = fabricOutflowReady.getKgM();// 单位
		this.totalCount = fabricOutflowReady.getTotalCount();// 面料总条数
		this.state = fabricOutflowReady.getState();// 删除状态
		this.remarks = fabricOutflowReady.getRemarks();// 备注
		this.materials = fabricOutflowReady.getMaterials();// 单间用料
		this.numberOrder = fabricOutflowReady.getNumberOrder();// 订单采购件数
		this.supplier = fabricOutflowReady.getSupplier();// 面料供应商
		this.scheduledNumber = fabricOutflowReady.getScheduledNumber();// 预定条数
		this.recipient = fabricOutflowReady.getRecipient();// 收件人
		this.recipientAddress = fabricOutflowReady.getRecipientAddress();// 收货地址
		this.fabricType = fabricOutflowReady.getFabricType();// 用料位置
		this.purchasingStatus = fabricOutflowReady.getPurchasingStatus();// 采购状态
		this.actualdosage = fabricOutflowReady.getActualdosage();// 实际用量总米数
		this.fabricprices = fabricOutflowReady.getFabricprices();// 面料单价
		this.weight = fabricOutflowReady.getWeight();// 面料总重量
		this.combinedwave = fabricOutflowReady.getCombinedwave();// 面料合用波次
		this.difference = fabricOutflowReady.getDifference();// 面料空差
		this.totalweight = fabricOutflowReady.getTotalweight();// 求和
		this.totalmount = fabricOutflowReady.getTotalmount();// 总金额
		this.purchasingOrderTime = fabricOutflowReady.getPurchasingOrderTime();// 下单时间
		this.purchasingPaymentTime = fabricOutflowReady.getPurchasingPaymentTime();// 付款时间
		this.purchasingReceiptTime = fabricOutflowReady.getPurchasingReceiptTime();// 收货时间
		this.purchasingGiveoutTime = fabricOutflowReady.getPurchasingGiveoutTime();// 发出时间
		this.craftsOrder = fabricOutflowReady.getCraftsOrder();// 工艺单
		this.piecesApproved = fabricOutflowReady.getPiecesApproved();// 裁片类型
		this.fabricfreight = fabricOutflowReady.getFabricfreight();//
		this.kindsOfFabric = fabricOutflowReady.getKindsOfFabric();// 面料种类数--ABC料数
		this.orderType = fabricOutflowReady.getOrderType();// 订单类型
		this.factory = fabricOutflowReady.getFactory();// 车缝工厂
		this.folwerFactory = fabricOutflowReady.getFolwerFactory();// 印绣工厂
		this.fabricIsReadyStatus = fabricOutflowReady.getFabricIsReadyStatus();// 面料已准备就绪
		this.fabricIsReadyTime = fabricOutflowReady.getFabricIsReadyTime();// 面料就绪时间
		this.fabricFeedback = fabricOutflowReady.getFabricFeedback();// 面料反馈
		this.fabrciIssueState=fabricOutflowReady.getFabrciIssueState();//面料发放状态
		this.begin = begin;
		this.end = end;
	}

	public PrintingFabricArrange() {
		super();
		// TODO Auto-generated constructor stub
	}

}