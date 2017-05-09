package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.InventoryFabricStorage;

public interface InventoryFabricStorageService {
	InventoryFabricStorage findInventoryFabricStorageById(Integer id);

	int updateInventoryFabricStorageDataStatusById(Integer id, HttpServletRequest request);

	List<InventoryFabricStorage> findInventoryFabricStorageByFabricCode(String fabricCode);

	int addInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request);

	int modifyInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request);

	int delInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request);

	int getInventoryFabricStorageByPageCount(Map<String, Object> anyVal);

	List<InventoryFabricStorage> findConditionInventoryFabricStorageByPage(Map<String, Object> anyVal);

}
