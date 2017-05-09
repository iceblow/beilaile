package com.warehouse.entity;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class Cutting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3589568928705500155L;

	private Integer id;// 编号id
	private String date;// 日期
	private String b_id;// 波号
	private String type;// 类别
	private String design_img;// 设计图
	private Integer S52;// 尺码52
	private Integer S59;// 尺码59
	private Integer S66;// 尺码66
	private Integer S73;// 尺码73
	private Integer S80;// 尺码80
	private Integer S90;// 尺码90
	private Integer S100;// 尺码100
	private Integer S110;// 尺码110
	private Integer S120;// 尺码120
	private Integer S130;// 尺码130
	private Integer S160;// 尺码160
	private Integer S170;// 尺码170
	private Integer Num;// 总数量
	private String OneCursumption;// 单件用量A
	private String OneCursumptionB;// 单件用量B
	private String OneCursumptionC;// 单件用量C
	private String OneCursumptionD;// 单件用量D
	private String OneCursumptionE;// 单件用量E
	private String FlowerOutTime;// 印花发外时间
	private String FlowerInTime;// 印花预计回收时间
	private String wages;// 裁剪时间
	private String InTime;// 入库时间
	private String CuttingMan;// 裁剪人
	private String PriceOutingTime;// 裁片外发时间
	private String remark;// 备注
	private String completeType;// 完成状态
	private String packets;// 包数
	private String shelves;// 货架

	private int begin;
	private int end;

	public Integer getS100() {
		return S100;
	}

	public void setS100(Integer s100) {
		S100 = s100;
	}

	public Integer getS110() {
		return S110;
	}

	public void setS110(Integer s110) {
		S110 = s110;
	}

	public Integer getS120() {
		return S120;
	}

	public void setS120(Integer s120) {
		S120 = s120;
	}

	public Integer getS130() {
		return S130;
	}

	public void setS130(Integer s130) {
		S130 = s130;
	}

	public Integer getS160() {
		return S160;
	}

	public void setS160(Integer s160) {
		S160 = s160;
	}

	public Integer getS170() {
		return S170;
	}

	public void setS170(Integer s170) {
		S170 = s170;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getS52() {
		return S52;
	}

	public void setS52(Integer s52) {
		S52 = s52;
	}

	public Integer getS59() {
		return S59;
	}

	public void setS59(Integer s59) {
		S59 = s59;
	}

	public Integer getS66() {
		return S66;
	}

	public void setS66(Integer s66) {
		S66 = s66;
	}

	public Integer getS73() {
		return S73;
	}

	public void setS73(Integer s73) {
		S73 = s73;
	}

	public Integer getS80() {
		return S80;
	}

	public void setS80(Integer s80) {
		S80 = s80;
	}

	public Integer getS90() {
		return S90;
	}

	public void setS90(Integer s90) {
		S90 = s90;
	}

	public Integer getNum() {
		return Num;
	}

	public void setNum(Integer num) {
		Num = num;
	}

	public String getOneCursumption() {
		return OneCursumption;
	}

	public void setOneCursumption(String oneCursumption) {
		OneCursumption = oneCursumption;
	}

	public String getFlowerOutTime() {
		return FlowerOutTime;
	}

	public void setFlowerOutTime(String flowerOutTime) {
		FlowerOutTime = flowerOutTime;
	}

	public String getFlowerInTime() {
		return FlowerInTime;
	}

	public void setFlowerInTime(String flowerInTime) {
		FlowerInTime = flowerInTime;
	}

	public String getInTime() {
		return InTime;
	}

	public void setInTime(String inTime) {
		InTime = inTime;
	}

	public String getCuttingMan() {
		return CuttingMan;
	}

	public void setCuttingMan(String cuttingMan) {
		CuttingMan = cuttingMan;
	}

	public String getPriceOutingTime() {
		return PriceOutingTime;
	}

	public void setPriceOutingTime(String priceOutingTime) {
		PriceOutingTime = priceOutingTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWages() {
		return wages;
	}

	public void setWages(String wages) {
		this.wages = wages;
	}

	public String getDesign_img() {
		return design_img;
	}

	public void setDesign_img(String design_img) {
		this.design_img = design_img;
	}

	public String getOneCursumptionB() {
		return OneCursumptionB;
	}

	public void setOneCursumptionB(String oneCursumptionB) {
		OneCursumptionB = oneCursumptionB;
	}

	public String getOneCursumptionC() {
		return OneCursumptionC;
	}

	public void setOneCursumptionC(String oneCursumptionC) {
		OneCursumptionC = oneCursumptionC;
	}

	public String getOneCursumptionD() {
		return OneCursumptionD;
	}

	public void setOneCursumptionD(String oneCursumptionD) {
		OneCursumptionD = oneCursumptionD;
	}

	public String getOneCursumptionE() {
		return OneCursumptionE;
	}

	public void setOneCursumptionE(String oneCursumptionE) {
		OneCursumptionE = oneCursumptionE;
	}

	public String getCompleteType() {
		return completeType;
	}

	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}

	public Cutting(int begin, int end, Cutting cutting) {
		super();
		this.b_id = cutting.getB_id();
		this.CuttingMan = cutting.getCuttingMan();
		this.begin = begin;
		this.end = end;
	}

	public Cutting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPackets() {
		return packets;
	}

	public void setPackets(String packets) {
		this.packets = packets;
	}

	public String getShelves() {
		return shelves;
	}

	public void setShelves(String shelves) {
		this.shelves = shelves;
	}

	@Override
	public String toString() {
		return "Cutting [id=" + id + ", date=" + date + ", b_id=" + b_id + ", type=" + type + ", design_img="
				+ design_img + ", S52=" + S52 + ", S59=" + S59 + ", S66=" + S66 + ", S73=" + S73 + ", S80=" + S80
				+ ", S90=" + S90 + ", S100=" + S100 + ", S110=" + S110 + ", S120=" + S120 + ", S130=" + S130 + ", S160="
				+ S160 + ", S170=" + S170 + ", Num=" + Num + ", OneCursumption=" + OneCursumption + ", OneCursumptionB="
				+ OneCursumptionB + ", OneCursumptionC=" + OneCursumptionC + ", OneCursumptionD=" + OneCursumptionD
				+ ", OneCursumptionE=" + OneCursumptionE + ", FlowerOutTime=" + FlowerOutTime + ", FlowerInTime="
				+ FlowerInTime + ", wages=" + wages + ", InTime=" + InTime + ", CuttingMan=" + CuttingMan
				+ ", PriceOutingTime=" + PriceOutingTime + ", remark=" + remark + ", completeType=" + completeType
				+ "]";
	}

}
