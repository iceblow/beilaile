package com.warehouse.entity;

import java.io.Serializable;

public class AuxiliaryFabric implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4478822599620704426L;
	private int id;
	private String cloth_name;// 设计师
	private String design_time;// 时间
	private String girard;// 波次号
	private String model;// 款号
	private String design_img;// 设计图
	private String sample_img;// 工艺单
	private String child_img;// 子码表
	private int total;// 订单数量
	private int code52;// 尺码52
	private int code59;// 尺码59
	private int code66;// 尺码66
	private int code73;// 尺码73
	private int code80;// 尺码80
	private int code90;// 尺码90
	private String popper_color;// 五爪扣颜色
	private int popper_num;// 五爪扣数量
	private String mark_washORdrop;// 洗唛/吊牌
	private String mark_wash_element;// 洗唛成份
	private String accessoryAName;// 辅料A名称
	private String accessoryANum;// 辅料A数量
	private String accessoryBName;// 辅料B名称
	private String accessoryBNum;// 辅料B数量
	private String accessoryCName;// 辅料C名称
	private String accessoryCNum;// 辅料C数量
	private String remark;// 备注

	private String paperpattern_emf_file;// 纸样EMF文件
	private String paperpattern_prj_file;// 纸样PRJ文件

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCloth_name() {
		return cloth_name;
	}

	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
	}

	public String getDesign_time() {
		return design_time;
	}

	public void setDesign_time(String design_time) {
		this.design_time = design_time;
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDesign_img() {
		return design_img;
	}

	public void setDesign_img(String design_img) {
		this.design_img = design_img;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public String getPopper_color() {
		return popper_color;
	}

	public void setPopper_color(String popper_color) {
		this.popper_color = popper_color;
	}

	public int getPopper_num() {
		return popper_num;
	}

	public void setPopper_num(int popper_num) {
		this.popper_num = popper_num;
	}

	public String getMark_washORdrop() {
		return mark_washORdrop;
	}

	public void setMark_washORdrop(String mark_washORdrop) {
		this.mark_washORdrop = mark_washORdrop;
	}

	public String getMark_wash_element() {
		return mark_wash_element;
	}

	public void setMark_wash_element(String mark_wash_element) {
		this.mark_wash_element = mark_wash_element;
	}

	public String getAccessoryAName() {
		return accessoryAName;
	}

	public void setAccessoryAName(String accessoryAName) {
		this.accessoryAName = accessoryAName;
	}

	public String getAccessoryANum() {
		return accessoryANum;
	}

	public void setAccessoryANum(String accessoryANum) {
		this.accessoryANum = accessoryANum;
	}

	public String getAccessoryBName() {
		return accessoryBName;
	}

	public void setAccessoryBName(String accessoryBName) {
		this.accessoryBName = accessoryBName;
	}

	public String getAccessoryBNum() {
		return accessoryBNum;
	}

	public void setAccessoryBNum(String accessoryBNum) {
		this.accessoryBNum = accessoryBNum;
	}

	public String getAccessoryCName() {
		return accessoryCName;
	}

	public void setAccessoryCName(String accessoryCName) {
		this.accessoryCName = accessoryCName;
	}

	public String getAccessoryCNum() {
		return accessoryCNum;
	}

	public void setAccessoryCNum(String accessoryCNum) {
		this.accessoryCNum = accessoryCNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSample_img() {
		return sample_img;
	}

	public void setSample_img(String sample_img) {
		this.sample_img = sample_img;
	}

	public String getChild_img() {
		return child_img;
	}

	public void setChild_img(String child_img) {
		this.child_img = child_img;
	}

	public String getPaperpattern_emf_file() {
		return paperpattern_emf_file;
	}

	public void setPaperpattern_emf_file(String paperpattern_emf_file) {
		this.paperpattern_emf_file = paperpattern_emf_file;
	}

	public String getPaperpattern_prj_file() {
		return paperpattern_prj_file;
	}

	public void setPaperpattern_prj_file(String paperpattern_prj_file) {
		this.paperpattern_prj_file = paperpattern_prj_file;
	}

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

	@Override
	public String toString() {
		return "AuxiliaryFabric [id=" + id + ", cloth_name=" + cloth_name + ", design_time=" + design_time + ", girard="
				+ girard + ", model=" + model + ", design_img=" + design_img + ", sample_img=" + sample_img
				+ ", child_img=" + child_img + ", total=" + total + ", code52=" + code52 + ", code59=" + code59
				+ ", code66=" + code66 + ", code73=" + code73 + ", code80=" + code80 + ", code90=" + code90
				+ ", popper_color=" + popper_color + ", popper_num=" + popper_num + ", mark_washORdrop="
				+ mark_washORdrop + ", mark_wash_element=" + mark_wash_element + ", accessoryAName=" + accessoryAName
				+ ", accessoryANum=" + accessoryANum + ", accessoryBName=" + accessoryBName + ", accessoryBNum="
				+ accessoryBNum + ", accessoryCName=" + accessoryCName + ", accessoryCNum=" + accessoryCNum
				+ ", remark=" + remark + "]";
	}

	public AuxiliaryFabric(int begin, int end, AuxiliaryFabric auxiliaryFabric) {
		super();
		this.begin = begin;
		this.end = end;
		this.cloth_name = auxiliaryFabric.getCloth_name();// 设计师
		this.design_time = auxiliaryFabric.getDesign_time();// 设计时间
		this.girard = auxiliaryFabric.getGirard();// 波次号
		this.model = auxiliaryFabric.getModel();// 款号
		this.design_img = auxiliaryFabric.getDesign_img();// 设计图
		this.sample_img = auxiliaryFabric.getSample_img();// 工艺单
		this.child_img = auxiliaryFabric.getChild_img();// 子码表
		this.popper_color = auxiliaryFabric.getPopper_color();// 五爪扣颜色
		this.mark_washORdrop = auxiliaryFabric.getMark_washORdrop();// 洗唛/吊牌
		this.mark_wash_element = auxiliaryFabric.getMark_wash_element();// 洗唛成份
		this.accessoryAName = auxiliaryFabric.getAccessoryAName();// 辅料A名称
		this.accessoryBName = auxiliaryFabric.getAccessoryBName();// 辅料B名称
		this.accessoryCName = auxiliaryFabric.getAccessoryCName();// 辅料C名称
		this.remark = auxiliaryFabric.getRemark();// 备注
		this.paperpattern_emf_file=auxiliaryFabric.getPaperpattern_emf_file();//纸样emf图片
		this.paperpattern_prj_file=auxiliaryFabric.getPaperpattern_prj_file();//纸样prj文件
	}

	public AuxiliaryFabric() {
		super();
		// TODO Auto-generated constructor stub
	}

}
