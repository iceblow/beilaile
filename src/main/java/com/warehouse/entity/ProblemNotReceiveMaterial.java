package com.warehouse.entity;

public class ProblemNotReceiveMaterial {
	

	private Integer begin;

	private Integer end;
	
    private Integer id;

    private String wave;

    private String image;
	
	private String clouthName;
    
    private String productCode;
    
    private String factory;

    private String orderType;

    private String fabricStorageTime;

    private String releaseTime;

    private String timeDifferece;

    private String addTime;

    private String addPersion;

    private String modifyTime;

    private String modifyPersion;

    private String delTime;

    private String delPersion;

    private String state;

    private String delState;
	public String getProblemState() {
		return problemState;
	}

	public void setProblemState(String problemState) {
		this.problemState = problemState;
	}

	public String getProblemFeedback() {
		return problemFeedback;
	}

	public void setProblemFeedback(String problemFeedback) {
		this.problemFeedback = problemFeedback;
	}

	public String getReasonForDelay() {
		return reasonForDelay;
	}

	public void setReasonForDelay(String reasonForDelay) {
		this.reasonForDelay = reasonForDelay;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProblemSolving() {
		return problemSolving;
	}

	public void setProblemSolving(String problemSolving) {
		this.problemSolving = problemSolving;
	}

	public String getProblemSolvingTime() {
		return problemSolvingTime;
	}

	public void setProblemSolvingTime(String problemSolvingTime) {
		this.problemSolvingTime = problemSolvingTime;
	}

	private String problemState;

	private String problemFeedback;

	private String reasonForDelay;

	private String personInCharge;

	private String memo;

	private String problemSolving;

	private String problemSolvingTime;

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

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getFabricStorageTime() {
        return fabricStorageTime;
    }

    public void setFabricStorageTime(String fabricStorageTime) {
        this.fabricStorageTime = fabricStorageTime == null ? null : fabricStorageTime.trim();
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime == null ? null : releaseTime.trim();
    }

    public String getTimeDifferece() {
        return timeDifferece;
    }

    public void setTimeDifferece(String timeDifferece) {
        this.timeDifferece = timeDifferece;
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

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getModifyPersion() {
        return modifyPersion;
    }

    public void setModifyPersion(String modifyPersion) {
        this.modifyPersion = modifyPersion == null ? null : modifyPersion.trim();
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime == null ? null : delTime.trim();
    }

    public String getDelPersion() {
        return delPersion;
    }

    public void setDelPersion(String delPersion) {
        this.delPersion = delPersion == null ? null : delPersion.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDelState() {
        return delState;
    }

    public void setDelState(String delState) {
        this.delState = delState == null ? null : delState.trim();
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
	public String getClouthName() {
		return clouthName;
	}

	public void setClouthName(String clouthName) {
		this.clouthName = clouthName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProblemNotReceiveMaterial(Integer begin,Integer end, String wave, String clouthName,String productCode, String factory, String orderType) {
		super();
		this.begin = begin;
		this.end = end;
		this.wave = wave;
		this.clouthName = clouthName;
		this.productCode = productCode;
		this.factory = factory;
		this.orderType = orderType;
	}

	public ProblemNotReceiveMaterial() {
		super();
	}
	
}