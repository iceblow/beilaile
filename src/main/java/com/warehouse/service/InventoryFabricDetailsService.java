package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.InventoryFabricDetails;

/**
 * Created by Beilaile on 2017/4/3.
 */
public interface InventoryFabricDetailsService {
	// 添加
	Integer addInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails, HttpServletRequest request);

	// 修改对象
	Integer modifyInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails, HttpServletRequest request);

	// 删除对象
	Integer delInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails, HttpServletRequest request);

	// 带条件查询总条数
	Integer getInventoryFabricDetailsByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<InventoryFabricDetails> findConditionInventoryFabricDetailsByPage(Map<String, Object> anyVal);

	// 根据id查询
	InventoryFabricDetails findInventoryFabricDetailsById(Integer id);

	// 根据面料编号查询
	InventoryFabricDetails findInventoryFabricDetailsByFabricCode(String fabricCode);
}
