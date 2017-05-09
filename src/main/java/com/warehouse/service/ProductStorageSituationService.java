package com.warehouse.service;

import java.util.List;
import com.warehouse.entity.ProductStorageSituation;

public interface ProductStorageSituationService {

	//分页查询总条数
	int selectAllcount(ProductStorageSituation productStorageSituation);
			
	//查询返回的list
	List<ProductStorageSituation > getProductStorageSituationPage(ProductStorageSituation productStorageSituation);
			
	//修改数据状态
	int deleteProductStorageSituationById(ProductStorageSituation productStorageSituation);
	
	//修改数据状态
	int updateProductStorageSituationById(ProductStorageSituation productStorageSituation);
	
	//修改数据状态
	int updateDataStateById(ProductStorageSituation productStorageSituation);
	
	//根据ID查询
	ProductStorageSituation findDataStateById(Integer id);
}
