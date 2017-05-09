package com.warehouse.entity;

import java.io.Serializable;

public class OrderMemoDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String date;
	private String consigneeMan;
	private String b_id;
	private String color;
	private String g0;
	private String g1;
	private String g2;
	private String g3;
	private String g4;
	private String g5;
	private String g6;
	private String g7;
	private String g8;
	private String g9;
	private String g10;
	private String g11;
	private String g_num;
	private String horse;
	private int delType;
	private String delTime;

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

	public String getConsigneeMan() {
		return consigneeMan;
	}

	public void setConsigneeMan(String consigneeMan) {
		this.consigneeMan = consigneeMan;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getG0() {
		return g0;
	}

	public void setG0(String g0) {
		this.g0 = g0;
	}

	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}

	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}

	public String getG3() {
		return g3;
	}

	public void setG3(String g3) {
		this.g3 = g3;
	}

	public String getG4() {
		return g4;
	}

	public void setG4(String g4) {
		this.g4 = g4;
	}

	public String getG5() {
		return g5;
	}

	public void setG5(String g5) {
		this.g5 = g5;
	}

	public String getG6() {
		return g6;
	}

	public void setG6(String g6) {
		this.g6 = g6;
	}

	public String getG7() {
		return g7;
	}

	public void setG7(String g7) {
		this.g7 = g7;
	}

	public String getG8() {
		return g8;
	}

	public void setG8(String g8) {
		this.g8 = g8;
	}

	public String getG9() {
		return g9;
	}

	public void setG9(String g9) {
		this.g9 = g9;
	}

	public String getG10() {
		return g10;
	}

	public void setG10(String g10) {
		this.g10 = g10;
	}

	public String getG11() {
		return g11;
	}

	public void setG11(String g11) {
		this.g11 = g11;
	}

	public String getG_num() {
		return g_num;
	}

	public void setG_num(String g_num) {
		this.g_num = g_num;
	}

	public String getHorse() {
		return horse;
	}

	public void setHorse(String horse) {
		this.horse = horse;
	}

	public int getDelType() {
		return delType;
	}

	public void setDelType(int delType) {
		this.delType = delType;
	}

	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	@Override
	public String toString() {
		return "OrderMemoDemo [id=" + id + ", date=" + date + ", consigneeMan=" + consigneeMan + ", b_id=" + b_id
				+ ", color=" + color + ", g0=" + g0 + ", g1=" + g1 + ", g2=" + g2 + ", g3=" + g3 + ", g4=" + g4
				+ ", g5=" + g5 + ", g6=" + g6 + ", g7=" + g7 + ", g8=" + g8 + ", g9=" + g9 + ", g10=" + g10 + ", g11="
				+ g11 + ", g_num=" + g_num + ", horse=" + horse + ", delType=" + delType + ", delTime=" + delTime + "]";
	}

}
