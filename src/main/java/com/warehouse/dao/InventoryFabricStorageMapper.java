package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.InventoryFabricStorage;

public interface InventoryFabricStorageMapper {
	InventoryFabricStorage findInventoryFabricStorageById(Integer id);

	int updateInventoryFabricStorageDataStatusById(Integer id);

	List<InventoryFabricStorage> findInventoryFabricStorageByFabricCode(String fabricCode);

	int addInventoryFabricStorage(InventoryFabricStorage InventoryFabricStorage);

	int modifyInventoryFabricStorage(InventoryFabricStorage InventoryFabricStorage);

	int delInventoryFabricStorage(InventoryFabricStorage InventoryFabricStorage);

	int getInventoryFabricStorageByPageCount(Map<String, Object> anyVal);

	List<InventoryFabricStorage> findConditionInventoryFabricStorageByPage(Map<String, Object> anyVal);
}