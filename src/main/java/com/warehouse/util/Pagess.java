package com.warehouse.util;

public class Pagess {

	private Integer begin;

	private Integer end;

	private Integer id;

	private String bid;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	private String name;
	private Integer year;
	private Integer types;

	public Pagess() {
	}

	private Integer money1;

	private Integer money2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getTypes() {
		return types;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	public Integer getMoney1() {
		return money1;
	}

	public void setMoney1(Integer money1) {
		this.money1 = money1;
	}

	public Integer getMoney2() {
		return money2;
	}

	public void setMoney2(Integer money2) {
		this.money2 = money2;
	}

	public Integer getId() {
		return id;
	}

	public Pagess(Integer begin, Integer end, Integer id) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = id;
	}

	public Pagess(Integer begin, Integer end, String bid) {
		super();
		this.begin = begin;
		this.end = end;
		this.bid = bid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pagess(Integer begin, Integer end) {
		super();
		this.begin = begin;
		this.end = end;
	}

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

	private Integer pid;
	private Integer xid;

	private Integer flag;
	private String xname;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getXid() {
		return xid;
	}

	public void setXid(Integer xid) {
		this.xid = xid;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getXname() {
		return xname;
	}

	public void setXname(String xname) {
		this.xname = xname;
	}

	// qc跟踪表的模糊查询
	private String qc;
	private String factory;

	public String getQc() {
		return qc;
	}

	public void setQc(String qc) {
		this.qc = qc;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Pagess(Integer begin, Integer end, String factory, String qc, String bid) {
		super();
		this.begin = begin;
		this.end = end;
		this.factory = factory;
		this.qc = qc;
		this.bid = bid;
	}

	// 面料进度模糊
	private String wave;
	private String fabricMaterial;
	private String inputAmount;
	private String outputAmount;

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getFabricMaterial() {
		return fabricMaterial;
	}

	public void setFabricMaterial(String fabricMaterial) {
		this.fabricMaterial = fabricMaterial;
	}

	public String getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(String inputAmount) {
		this.inputAmount = inputAmount;
	}

	public String getOutputAmount() {
		return outputAmount;
	}

	public void setOutputAmount(String outputAmount) {
		this.outputAmount = outputAmount;
	}

	public Pagess(Integer begin, Integer end, String wave, String fabricMaterial, String inputAmount,
			String outputAmount) {
		super();
		this.begin = begin;
		this.end = end;
		this.wave = wave;
		this.fabricMaterial = fabricMaterial;
		this.inputAmount = inputAmount;
		this.outputAmount = outputAmount;
	}

	// 加工领片日报
	private String girard;
	private String company;

	public String getGirard() {
		return girard;
	}

	public void setGirard(String girard) {
		this.girard = girard;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Pagess(Integer begin, Integer end, String girard, String company) {
		super();
		this.begin = begin;
		this.end = end;
		this.girard = girard;
		this.company = company;
	}
}
