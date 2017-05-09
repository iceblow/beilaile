package com.warehouse.entity;


public class ApparelDevelopmentDesignBuyerOrder {
    private Integer id;

    private String wave;

    private String goodsId;

    private String designImg;

    private String link;

    private String requireDescription;

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

    private String addTime;

    private String addPersion;

    private String updateTime;

    private String updatePersion;

    private String deleteTime;

    private String deletePersion;

    private String orderStatus="1";
    
    private Integer totalPiece;		//总件数
    
    private String buyStatus="n";	//购买状态，是否购买 n-未采购，y-已采购
    
    private String buyTime;			//采购时间
    
    private String cancelTime;		//订单取消时间
    
    public ApparelDevelopmentDesignBuyerOrder(){
    }
    
    public String getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public String getBuyStatus() {
		return buyStatus;
	}

	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}

	public Integer getTotalPiece() {
		return totalPiece;
	}

	public void setTotalPiece(Integer totalPiece) {
		this.totalPiece = totalPiece;
	}

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
        this.wave = wave == null ? null : wave.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getDesignImg() {
        return designImg;
    }

    public void setDesignImg(String designImg) {
        this.designImg = designImg == null ? null : designImg.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getRequireDescription() {
        return requireDescription;
    }

    public void setRequireDescription(String requireDescription) {
        this.requireDescription = requireDescription == null ? null : requireDescription.trim();
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

    public void setCode100(Integer code100) {
        this.code100 = code100;
    }

    public Integer getCode110() {
        return code110;
    }

    public void setCode110(Integer code110) {
        this.code110 = code110;
    }

    public Integer getCode120() {
        return code120;
    }

    public void setCode120(Integer code120) {
        this.code120 = code120;
    }

    public Integer getCode130() {
        return code130;
    }

    public void setCode130(Integer code130) {
        this.code130 = code130;
    }

    public Integer getCode160() {
        return code160;
    }

    public void setCode160(Integer code160) {
        this.code160 = code160;
    }

    public Integer getCode170() {
        return code170;
    }

    public void setCode170(Integer code170) {
        this.code170 = code170;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getAddPersion() {
        return addPersion;
    }

    public void setAddPersion(String addPersion) {
        this.addPersion = addPersion == null ? null : addPersion.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdatePersion() {
        return updatePersion;
    }

    public void setUpdatePersion(String updatePersion) {
        this.updatePersion = updatePersion == null ? null : updatePersion.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getDeletePersion() {
        return deletePersion;
    }

    public void setDeletePersion(String deletePersion) {
        this.deletePersion = deletePersion == null ? null : deletePersion.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

	@Override
	public String toString() {
		return "ApparelDevelopmentDesignBuyerOrder [id=" + id + ", wave="
				+ wave + ", goodsId=" + goodsId + ", designImg=" + designImg
				+ ", link=" + link + ", requireDescription="
				+ requireDescription + ", code52=" + code52 + ", code59="
				+ code59 + ", code66=" + code66 + ", code73=" + code73
				+ ", code80=" + code80 + ", code90=" + code90 + ", code100="
				+ code100 + ", code110=" + code110 + ", code120=" + code120
				+ ", code130=" + code130 + ", code160=" + code160
				+ ", code170=" + code170 + ", addTime=" + addTime
				+ ", addPersion=" + addPersion + ", updateTime=" + updateTime
				+ ", updatePersion=" + updatePersion + ", deleteTime="
				+ deleteTime + ", deletePersion=" + deletePersion
				+ ", orderStatus=" + orderStatus + "]";
	}
    
    
}