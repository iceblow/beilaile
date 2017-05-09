package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.ProductArtworkSituation;


public interface ProductArtworkSituationMapper {
	int getArtworkInfoBpcnt(Map<String, Object> param);

	List<ProductArtworkSituation> findArtworkInfoCndbp(Map<String, Object> param);

	int confirmShipmentArtwork(Integer id);

	int modifyArtworkInfo(Map<String, Object> param);


	int addproductArtworkSituationInfo(ProductArtworkSituation productArtworkSituation);

	ProductArtworkSituation queryById(Integer id);
}