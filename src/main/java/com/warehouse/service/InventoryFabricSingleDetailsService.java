package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.InventoryFabricSingleDetails;

public interface InventoryFabricSingleDetailsService {
	// 添加对象
	int addInventoryFabricSingleDetails(InventoryFabricSingleDetails inventoryFabricSingleDetails,
			HttpServletRequest request);

	// 带条件查询总条数
	int getInventoryFabricSingleDetailsByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<InventoryFabricSingleDetails> findConditionInventoryFabricSingleDetailsByPage(Map<String, Object> anyVal);
}
