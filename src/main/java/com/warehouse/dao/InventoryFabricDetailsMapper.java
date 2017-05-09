package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.InventoryFabricDetails;

public interface InventoryFabricDetailsMapper {
	// 添加
	Integer addInventoryFabricDetails(InventoryFabricDetails InventoryFabricDetails);

	// 修改对象
	Integer modifyInventoryFabricDetails(InventoryFabricDetails InventoryFabricDetails);

	// 删除对象
	Integer delInventoryFabricDetails(InventoryFabricDetails InventoryFabricDetails);

	// 带条件查询总条数
	Integer getInventoryFabricDetailsByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<InventoryFabricDetails> findConditionInventoryFabricDetailsByPage(Map<String, Object> anyVal);

	// 根据id查询
	InventoryFabricDetails findInventoryFabricDetailsById(Integer id);

	// 根据id查询
	InventoryFabricDetails findInventoryFabricDetailsByFabricCode(String fabricCode);

}