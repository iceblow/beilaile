package com.warehouse.entity;

public class ReturnRepair {

	private String buildTime;
	
	private String addPersion;
	
	private String changeTime;
	
	private String updatePersion;
	
	private String deleteTime;
	
	private String deletePersion;
	
	private String orderStatus;
	
	private Integer begin;

	private Integer end;

    private Integer sid;

    private String addTime;
    
    private String vendorCode;

    private String commoditycCode;

    private String girard;

    private String factory;

    private String designImg;

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

    private Integer total;

    private String remarks;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode == null ? null : vendorCode.trim();
    }

    public String getCommoditycCode() {
        return commoditycCode;
    }

    public void setCommoditycCode(String commoditycCode) {
        this.commoditycCode = commoditycCode == null ? null : commoditycCode.trim();
    }

    public String getGirard() {
        return girard;
    }

    public void setGirard(String girard) {
        this.girard = girard == null ? null : girard.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getDesignImg() {
        return designImg;
    }

    public void setDesignImg(String designImg) {
        this.designImg = designImg == null ? null : designImg.trim();
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
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
	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public String getAddPersion() {
		return addPersion;
	}

	public void setAddPersion(String addPersion) {
		this.addPersion = addPersion;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String getUpdatePersion() {
		return updatePersion;
	}

	public void setUpdatePersion(String updatePersion) {
		this.updatePersion = updatePersion;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeletePersion() {
		return deletePersion;
	}

	public void setDeletePersion(String deletePersion) {
		this.deletePersion = deletePersion;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public ReturnRepair(){
		super();
	}

	public ReturnRepair(Integer begin, Integer end, String vendorCode, String commoditycCode, String girard,
			String factory) {
		super();
		this.begin = begin;
		this.end = end;
		this.vendorCode = vendorCode;
		this.commoditycCode = commoditycCode;
		this.girard = girard;
		this.factory = factory;
	}
}