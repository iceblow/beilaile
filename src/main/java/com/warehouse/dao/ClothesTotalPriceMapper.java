package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ClothesTotalPrice;

public interface ClothesTotalPriceMapper {
    
	//查询总条数
	Integer selectClothes1(ClothesTotalPrice clothesTotalPrice);
	
	//分页查询返回的结果
	List<ClothesTotalPrice> getClothesPage(ClothesTotalPrice clothesTotalPrice);
}