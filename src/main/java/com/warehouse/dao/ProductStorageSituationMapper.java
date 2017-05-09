package com.warehouse.dao;

import java.util.List;
import com.warehouse.entity.ProductStorageSituation;

public interface ProductStorageSituationMapper {
    
	//查询总条数
	int selectAllcount(ProductStorageSituation productStorageSituation);
			
	//返回的结果
	List<ProductStorageSituation> getProductStorageSituationPage(ProductStorageSituation productStorageSituation);
			
	//假删除数据
	int deleteProductStorageSituationById(ProductStorageSituation productStorageSituation);
		
	//双击修改
	int updateProductStorageSituationById(ProductStorageSituation productStorageSituation);
	
	//双击修改
	int updateDataStateById(ProductStorageSituation productStorageSituation);
	
	//双击修改
	ProductStorageSituation findDataStateById(Integer id);
	
}