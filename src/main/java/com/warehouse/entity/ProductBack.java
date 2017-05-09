package com.warehouse.entity;

public class ProductBack {

	private int begin;

	private int end;

	private int id;

	private String girard;// 波次

	private String girardOld;// 原波次

	private String productcodes;// 商品编号

	private String productname;// 商品名

	private String productshortname;// 商品简称

	private String exclefile;// Excel文件

	private String productimg;// 商品图片

	private String productoldname;// 旧商品名

	private Integer code52;

	private Integer code59;

	private Integer code66;

	private Integer code73;

	private Integer code80;

	private Integer code90;

	private Integer code100;

	private Integer code110;

	private Integer code120;

	private Integer code130;

	private Integer code160;

	private Integer code170;

	private Integer stock52;

	private Integer stock59;

	private Integer stock66;

	private Integer stock73;

	private Integer stock80;

	private Integer stock90;

	private Integer stock100;

	private Integer stock110;

	private Integer stock120;

	private Integer stock130;

	private Integer stock160;

	private Integer stock170;

	private Integer sale52;

	private Integer sale59;

	private Integer sale66;

	private Integer sale73;

	private Integer sale80;

	private Integer sale90;

	private Integer sale100;

	private Integer sale110;

	private Integer sale120;

	private Integer sale130;

	private Integer sale160;

	private Integer sale170;

	private Integer total;// 总件数

	private String expectTime;

	private int delb;

	private String remark;// 备注

	private String addTime;

	private String updateTime;

	private String delTime;

	private String operation;

	private String operator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard == null ? null : girard.trim();
	}

	public String getGirardOld() {
		return girardOld;
	}

	public void setGirardOld(String girardOld) {
		this.girardOld = girardOld;
	}

	public String getProductcodes() {
		return productcodes;
	}

	public void setProductcodes(String productcodes) {
		this.productcodes = productcodes == null ? null : productcodes.trim();
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname == null ? null : productname.trim();
	}

	public String getProductshortname() {
		return productshortname;
	}

	public void setProductshortname(String productshortname) {
		this.productshortname = productshortname == null ? null : productshortname.trim();
	}

	public String getExclefile() {
		return exclefile;
	}

	public void setExclefile(String exclefile) {
		this.exclefile = exclefile == null ? null : exclefile.trim();
	}

	public String getProductimg() {
		return productimg;
	}

	public void setProductimg(String productimg) {
		this.productimg = productimg == null ? null : productimg.trim();
	}

	public String getProductoldname() {
		return productoldname;
	}

	public void setProductoldname(String productoldname) {
		this.productoldname = productoldname == null ? null : productoldname.trim();
	}

	public int getDelb() {
		return delb;
	}

	public void setDelb(int delb) {
		this.delb = delb;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
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

	public Integer getCode52() {
		return code52;
	}

	public void setCode52(Integer code52) {
		this.code52 = code52;
	}

	public Integer getCode59() {
		return code59;
	}

	public void setCode59(Integer code59) {
		this.code59 = code59;
	}

	public Integer getCode66() {
		return code66;
	}

	public void setCode66(Integer code66) {
		this.code66 = code66;
	}

	public Integer getCode73() {
		return code73;
	}

	public void setCode73(Integer code73) {
		this.code73 = code73;
	}

	public Integer getCode80() {
		return code80;
	}

	public void setCode80(Integer code80) {
		this.code80 = code80;
	}

	public Integer getCode90() {
		return code90;
	}

	public void setCode90(Integer code90) {
		this.code90 = code90;
	}

	public Integer getCode100() {
		return code100;
	}

	public Integer getCode110() {
		return code110;
	}

	public Integer getCode120() {
		return code120;
	}

	public Integer getCode130() {
		return code130;
	}

	public Integer getCode160() {
		return code160;
	}

	public void setCode100(Integer code100) {
		this.code100 = code100;
	}

	public void setCode110(Integer code110) {
		this.code110 = code110;
	}

	public void setCode120(Integer code120) {
		this.code120 = code120;
	}

	public void setCode130(Integer code130) {
		this.code130 = code130;
	}

	public void setCode160(Integer code160) {
		this.code160 = code160;
	}

	public Integer getStock59() {
		return stock59;
	}

	public Integer getStock66() {
		return stock66;
	}

	public Integer getStock73() {
		return stock73;
	}

	public Integer getStock80() {
		return stock80;
	}

	public Integer getStock90() {
		return stock90;
	}

	public Integer getStock100() {
		return stock100;
	}

	public Integer getStock110() {
		return stock110;
	}

	public Integer getStock120() {
		return stock120;
	}

	public Integer getStock130() {
		return stock130;
	}

	public Integer getStock160() {
		return stock160;
	}

	public Integer getSale59() {
		return sale59;
	}

	public Integer getSale66() {
		return sale66;
	}

	public Integer getSale73() {
		return sale73;
	}

	public Integer getSale80() {
		return sale80;
	}

	public Integer getSale90() {
		return sale90;
	}

	public Integer getSale100() {
		return sale100;
	}

	public Integer getSale110() {
		return sale110;
	}

	public Integer getSale120() {
		return sale120;
	}

	public Integer getSale130() {
		return sale130;
	}

	public Integer getSale160() {
		return sale160;
	}

	public void setStock59(Integer stock59) {
		this.stock59 = stock59;
	}

	public void setStock66(Integer stock66) {
		this.stock66 = stock66;
	}

	public void setStock73(Integer stock73) {
		this.stock73 = stock73;
	}

	public void setStock80(Integer stock80) {
		this.stock80 = stock80;
	}

	public void setStock90(Integer stock90) {
		this.stock90 = stock90;
	}

	public void setStock100(Integer stock100) {
		this.stock100 = stock100;
	}

	public void setStock110(Integer stock110) {
		this.stock110 = stock110;
	}

	public void setStock120(Integer stock120) {
		this.stock120 = stock120;
	}

	public void setStock130(Integer stock130) {
		this.stock130 = stock130;
	}

	public void setStock160(Integer stock160) {
		this.stock160 = stock160;
	}

	public void setSale59(Integer sale59) {
		this.sale59 = sale59;
	}

	public void setSale66(Integer sale66) {
		this.sale66 = sale66;
	}

	public void setSale73(Integer sale73) {
		this.sale73 = sale73;
	}

	public void setSale80(Integer sale80) {
		this.sale80 = sale80;
	}

	public void setSale90(Integer sale90) {
		this.sale90 = sale90;
	}

	public void setSale100(Integer sale100) {
		this.sale100 = sale100;
	}

	public void setSale110(Integer sale110) {
		this.sale110 = sale110;
	}

	public void setSale120(Integer sale120) {
		this.sale120 = sale120;
	}

	public void setSale130(Integer sale130) {
		this.sale130 = sale130;
	}

	public void setSale160(Integer sale160) {
		this.sale160 = sale160;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public ProductBack() {
		super();
	}

	public ProductBack(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public ProductBack(int begin, int end, String girardOld, String productcodes, String productname,
			String productshortname, String exclefile, String productoldname) {
		super();
		this.begin = begin;
		this.end = end;
		this.girardOld = girardOld;
		this.productcodes = productcodes;
		this.productname = productname;
		this.productshortname = productshortname;
		this.exclefile = exclefile;
		this.productoldname = productoldname;
	}

	public Integer getStock52() {
		return stock52;
	}

	public Integer getSale52() {
		return sale52;
	}

	public void setStock52(Integer stock52) {
		this.stock52 = stock52;
	}

	public void setSale52(Integer sale52) {
		this.sale52 = sale52;
	}

	public Integer getCode170() {
		return code170;
	}

	public Integer getStock170() {
		return stock170;
	}

	public Integer getSale170() {
		return sale170;
	}

	public void setCode170(Integer code170) {
		this.code170 = code170;
	}

	public void setStock170(Integer stock170) {
		this.stock170 = stock170;
	}

	public void setSale170(Integer sale170) {
		this.sale170 = sale170;
	}

}