package com.warehouse.entity;

public class WeekProductionPlan {
	
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
	
	private Integer id;

	private String factory;

	private String targer;

	private String monday;

	private String tuesday;

	private String wednesday;

	private String thursday;

	private String firday;

	private String saturday;

	private String sunday;

	private String date;

	private String dataState;

	public String getDateState() {
		return dataState;
	}

	public void setDateState(String dateState) {
		this.dataState = dateState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory == null ? null : factory.trim();
	}

	public String getTarger() {
		return targer;
	}

	public void setTarger(String targer) {
		this.targer = targer == null ? null : targer.trim();
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday == null ? null : monday.trim();
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday == null ? null : tuesday.trim();
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday == null ? null : wednesday.trim();
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday == null ? null : thursday.trim();
	}

	public String getFirday() {
		return firday;
	}

	public void setFirday(String firday) {
		this.firday = firday == null ? null : firday.trim();
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday == null ? null : saturday.trim();
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday == null ? null : sunday.trim();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date == null ? null : date.trim();
	}

	public WeekProductionPlan() {
		super();
	}

	public WeekProductionPlan(int begin, int end,WeekProductionPlan weekProductionPlan) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = weekProductionPlan.id;
		this.factory = weekProductionPlan.factory;
		this.targer = weekProductionPlan.targer;
		this.monday = weekProductionPlan.monday;
		this.tuesday = weekProductionPlan.tuesday;
		this.wednesday = weekProductionPlan.wednesday;
		this.thursday = weekProductionPlan.thursday;
		this.firday = weekProductionPlan.firday;
		this.saturday = weekProductionPlan.saturday;
		this.sunday = weekProductionPlan.sunday;
		this.date = weekProductionPlan.date;
		this.dataState = weekProductionPlan.dataState;
	}
	
	
	
	
}