package com.warehouse.service;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.ProductOperationSituation;

public interface ProductOperationSituationService {
	int getOperationInfoBpcnt(Map<String, Object> param);

	List<ProductOperationSituation> findOperationInfoCndbp(Map<String, Object> param);

	int confirmShipmentOperation(Integer id);

	int modifyOperationInfo(Map<String, Object> param);


	int addProductOperationSituationInfo(ProductOperationSituation ProductOperationSituation);

	ProductOperationSituation queryById(Integer id);
}
