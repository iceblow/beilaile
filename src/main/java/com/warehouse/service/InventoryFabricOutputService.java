package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.InventoryFabricOutput;

public interface InventoryFabricOutputService {

	InventoryFabricOutput findInventoryFabricOutputById(Integer id);

	int updateInventoryFabricOutputDataStatusById(Integer id, HttpServletRequest request);

	List<InventoryFabricOutput> findInventoryFabricOutputByFabricCode(String fabricCode);

	int addInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request);

	int modifyInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request);

	int delInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request);

	int getInventoryFabricOutputByPageCount(Map<String, Object> anyVal);

	List<InventoryFabricOutput> findConditionInventoryFabricOutputByPage(Map<String, Object> anyVal);

}
