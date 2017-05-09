package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.InventoryFabricOutput;

public interface InventoryFabricOutputMapper {
	InventoryFabricOutput findInventoryFabricOutputById(Integer id);

	int updateInventoryFabricOutputDataStatusById(Integer id);

	List<InventoryFabricOutput> findInventoryFabricOutputByFabricCode(String fabricCode);

	int addInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput);

	int modifyInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput);

	int delInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput);

	int getInventoryFabricOutputByPageCount(Map<String, Object> anyVal);

	List<InventoryFabricOutput> findConditionInventoryFabricOutputByPage(Map<String, Object> anyVal);
}