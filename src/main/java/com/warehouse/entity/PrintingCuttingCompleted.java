package com.warehouse.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 裁剪完成实体
 * 
 * @author admin
 *
 */
public class PrintingCuttingCompleted implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8480485749647411545L;

	private String wave;// 波次号

	private String cropCompletionDate;// 裁剪完成日期

	private Integer cropNumber;// 裁剪数

	private String piecesApproved;// 印绣类型

	private String image;// 产品图

	private String cutLargeReceiveDate;// 片印领料日期

	private String cutLargeReturnDate;// 片印回料日期

	private String printingFactory;// 印花工厂

	private String factory;// 车缝工厂

	private String factoryPickingDate;// 车缝领料日期

	private String remark;// 备注

	private int begin;
	private int end;

	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave == null ? null : wave.trim();
	}

	public String getCropCompletionDate() {
		return cropCompletionDate;
	}

	public void setCropCompletionDate(String cropCompletionDate) {
		this.cropCompletionDate = cropCompletionDate;
	}

	public Integer getCropNumber() {
		return cropNumber;
	}

	public void setCropNumber(Integer cropNumber) {
		this.cropNumber = cropNumber;
	}

	public String getPiecesApproved() {
		return piecesApproved;
	}

	public void setPiecesApproved(String piecesApproved) {
		this.piecesApproved = piecesApproved == null ? null : piecesApproved.trim();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	public String getCutLargeReceiveDate() {
		return cutLargeReceiveDate;
	}

	public void setCutLargeReceiveDate(String cutLargeReceiveDate) {
		this.cutLargeReceiveDate = cutLargeReceiveDate;
	}

	public String getCutLargeReturnDate() {
		return cutLargeReturnDate;
	}

	public void setCutLargeReturnDate(String cutLargeReturnDate) {
		this.cutLargeReturnDate = cutLargeReturnDate;
	}

	public String getPrintingFactory() {
		return printingFactory;
	}

	public void setPrintingFactory(String printingFactory) {
		this.printingFactory = printingFactory == null ? null : printingFactory.trim();
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public String getFactoryPickingDate() {
		return factoryPickingDate;
	}

	public void setFactoryPickingDate(String factoryPickingDate) {
		this.factoryPickingDate = factoryPickingDate;
	}

	@Override
	public String toString() {
		return "PrintingCuttingCompleted [wave=" + wave + ", cropCompletionDate=" + cropCompletionDate + ", cropNumber="
				+ cropNumber + ", piecesApproved=" + piecesApproved + ", image=" + image + ", cutLargeReceiveDate="
				+ cutLargeReceiveDate + ", cutLargeReturnDate=" + cutLargeReturnDate + ", printingFactory="
				+ printingFactory + ", factory=" + factory + ", factoryPickingDate=" + factoryPickingDate + ", remark="
				+ remark + "]";
	}

	public PrintingCuttingCompleted(int begin, int end, PrintingCuttingCompleted printingCuttingCompleted) {
		super();
		this.wave = printingCuttingCompleted.getWave();
		this.cropCompletionDate = printingCuttingCompleted.getCropCompletionDate();
		this.cropNumber = printingCuttingCompleted.getCropNumber();
		this.piecesApproved = printingCuttingCompleted.getPiecesApproved();
		this.image = printingCuttingCompleted.getImage();
		this.cutLargeReceiveDate = printingCuttingCompleted.getCutLargeReceiveDate();
		this.cutLargeReturnDate = printingCuttingCompleted.getCutLargeReturnDate();
		this.printingFactory = printingCuttingCompleted.getPrintingFactory();
		this.factory = printingCuttingCompleted.getFactory();
		this.factoryPickingDate = printingCuttingCompleted.getFactoryPickingDate();
		this.remark=printingCuttingCompleted.getRemark();
		this.begin = begin;
		this.end = end;
	}

	public PrintingCuttingCompleted() {
		super();
		// TODO Auto-generated constructor stub
	}

}