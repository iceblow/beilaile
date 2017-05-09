package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.InventoryFabricSingleDetails;

public interface InventoryFabricSingleDetailsMapper {

	int addInventoryFabricSingleDetails(InventoryFabricSingleDetails inventoryFabricSingleDetails);

	// 带条件查询总条数
	int getInventoryFabricSingleDetailsByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<InventoryFabricSingleDetails> findConditionInventoryFabricSingleDetailsByPage(Map<String, Object> anyVal);
}