package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ClothesTotalPrice;

public interface ClothesTotalPriceService {

	//查询总条数
	Integer selectClothes1(ClothesTotalPrice clothesTotalPrice);
	
	//返回分页结果
	List<ClothesTotalPrice> getClothesPage(ClothesTotalPrice clothesTotalPrice);
}
