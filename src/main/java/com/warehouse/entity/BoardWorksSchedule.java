package com.warehouse.entity;

public class BoardWorksSchedule {

	private Integer id;
	private String wave;
	private String originalWave;
	private String image;
	private String orders;
	private String orderType;
	private String fabricStorageTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public String getOriginalWave() {
		return originalWave;
	}

	public void setOriginalWave(String originalWave) {
		this.originalWave = originalWave;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getFabricStorageTime() {
		return fabricStorageTime;
	}

	public void setFabricStorageTime(String fabricStorageTime) {
		this.fabricStorageTime = fabricStorageTime;
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
		return "BoardWorksSchedule [id=" + id + ", wave=" + wave + ", originalWave=" + originalWave + ", image=" + image
				+ ", orders=" + orders + ", orderType=" + orderType + ", fabricStorageTime=" + fabricStorageTime + "]";
	}

	public BoardWorksSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

}
