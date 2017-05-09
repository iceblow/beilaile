package com.warehouse.entity;

public class FabricTotalPrice {
	
	
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

    private String wave;

    private String fabricMaterial;

    private String designImg;

    private String colour;

    private String fabricOutWeight;

    private String fabricReturnWeight;

    private String price;

    private String deleteTime;

    private String dataState;
    
    
    private String fabricOutPrice;
    private String fabricReturnPrice;
    private String userFabricWeight;
    private String userFabricPrice;
    private String cutNumber;
    private String aWeight;
    private String aPrice;
    private String kgM;
    

    public String getKgM() {
		return kgM;
	}

	public void setKaM(String kgM) {
		this.kgM = kgM;
	}

	public String getFabricOutPrice() {
		return fabricOutPrice;
	}

	public void setFabricOutPrice(String fabricOutPrice) {
		this.fabricOutPrice = fabricOutPrice;
	}

	public String getFabricReturnPrice() {
		return fabricReturnPrice;
	}

	public void setFabricReturnPrice(String fabricReturnPrice) {
		this.fabricReturnPrice = fabricReturnPrice;
	}

	public String getUserFabricWeight() {
		return userFabricWeight;
	}

	public void setUserFabricWeight(String userFabricWeight) {
		this.userFabricWeight = userFabricWeight;
	}

	public String getUserFabricPrice() {
		return userFabricPrice;
	}

	public void setUserFabricPrice(String userFabricPrice) {
		this.userFabricPrice = userFabricPrice;
	}

	public String getCutNumber() {
		return cutNumber;
	}

	public void setCutNumber(String cutNumber) {
		this.cutNumber = cutNumber;
	}

	public String getaWeight() {
		return aWeight;
	}

	public void setaWeight(String aWeight) {
		this.aWeight = aWeight;
	}

	public String getaPrice() {
		return aPrice;
	}

	public void setaPrice(String aPrice) {
		this.aPrice = aPrice;
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

    public String getFabricMaterial() {
        return fabricMaterial;
    }

    public void setFabricMaterial(String fabricMaterial) {
        this.fabricMaterial = fabricMaterial == null ? null : fabricMaterial.trim();
    }

    public String getDesignImg() {
        return designImg;
    }

    public void setDesignImg(String designImg) {
        this.designImg = designImg == null ? null : designImg.trim();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    public String getFabricOutWeight() {
        return fabricOutWeight;
    }

    public void setFabricOutWeight(String fabricOutWeight) {
        this.fabricOutWeight = fabricOutWeight == null ? null : fabricOutWeight.trim();
    }

    public String getFabricReturnWeight() {
        return fabricReturnWeight;
    }

    public void setFabricReturnWeight(String fabricReturnWeight) {
        this.fabricReturnWeight = fabricReturnWeight == null ? null : fabricReturnWeight.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState == null ? null : dataState.trim();
    }

	public FabricTotalPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FabricTotalPrice(int begin, int end,FabricTotalPrice fabricTotalPrice) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = fabricTotalPrice.id;
		this.wave =fabricTotalPrice.wave;
		this.fabricMaterial =fabricTotalPrice.fabricMaterial;
		this.designImg =fabricTotalPrice.designImg;
		this.colour =fabricTotalPrice.colour;
		this.fabricOutWeight =fabricTotalPrice.fabricOutWeight;
		this.fabricReturnWeight =fabricTotalPrice.fabricReturnWeight;
		this.price =fabricTotalPrice.price;
		this.deleteTime =fabricTotalPrice.deleteTime;
		this.dataState =fabricTotalPrice.dataState;
	    this.fabricOutPrice =fabricTotalPrice.fabricOutPrice;
		this.fabricReturnPrice =fabricTotalPrice.fabricReturnPrice;
		this.userFabricWeight =fabricTotalPrice.userFabricWeight;
		this.userFabricPrice =fabricTotalPrice.userFabricPrice;
		this.cutNumber =fabricTotalPrice.cutNumber;
		this.aWeight =fabricTotalPrice.aWeight;
		this.aPrice =fabricTotalPrice.aPrice;
		this.kgM =fabricTotalPrice.kgM;
		
	}
    
    
}