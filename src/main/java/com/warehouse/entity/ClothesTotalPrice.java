package com.warehouse.entity;

public class ClothesTotalPrice {
	
	private int begin; 
	private int end;

    private Integer id;

    private String designImg;

    private String wave;

    private String fabricOutPrice;

    private String fabricReturnPrice;

    private String userFabricPrice;

    private String aPrice;

    private String goodsId;
    private String goodsName;
    
    
	
    public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignImg() {
        return designImg;
    }

    public void setDesignImg(String designImg) {
        this.designImg = designImg == null ? null : designImg.trim();
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave == null ? null : wave.trim();
    }

    public String getFabricOutPrice() {
        return fabricOutPrice;
    }

    public void setFabricOutPrice(String fabricOutPrice) {
        this.fabricOutPrice = fabricOutPrice == null ? null : fabricOutPrice.trim();
    }

    public String getFabricReturnPrice() {
        return fabricReturnPrice;
    }

    public void setFabricReturnPrice(String fabricReturnPrice) {
        this.fabricReturnPrice = fabricReturnPrice == null ? null : fabricReturnPrice.trim();
    }

    public String getUserFabricPrice() {
        return userFabricPrice;
    }

    public void setUserFabricPrice(String userFabricPrice) {
        this.userFabricPrice = userFabricPrice == null ? null : userFabricPrice.trim();
    }

    public String getaPrice() {
        return aPrice;
    }

    public void setaPrice(String aPrice) {
        this.aPrice = aPrice == null ? null : aPrice.trim();
    }

	public ClothesTotalPrice() {
		super();
	}

	public ClothesTotalPrice(int begin, int end,ClothesTotalPrice clothesTotalPrice ) {
		super();
		this.begin =begin;
		this.end =end;
		this.id =clothesTotalPrice.id;
		this.designImg =clothesTotalPrice.designImg;
		this.wave =clothesTotalPrice.wave;
		this.fabricOutPrice =clothesTotalPrice.fabricOutPrice;
		this.fabricReturnPrice =clothesTotalPrice.fabricReturnPrice;
		this.userFabricPrice =clothesTotalPrice.userFabricPrice;
		this.aPrice =clothesTotalPrice.aPrice;
	}
    
    
}