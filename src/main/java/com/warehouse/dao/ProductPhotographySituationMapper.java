package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.ProductPhotographySituation;

public interface ProductPhotographySituationMapper {
  

  
	int getPhotographyInfoBpcnt(Map<String, Object> param);

	List<ProductPhotographySituation> findPhotographyInfoCndbp(Map<String, Object> param);

	int confirmShipmentPhotography(Integer id);

	int modifyPhotographyInfo(Map<String, Object> param);

	int addproductPhotographySituationInfo(ProductPhotographySituation productPhotographySituation);

	ProductPhotographySituation queryById(Integer id);

	
}