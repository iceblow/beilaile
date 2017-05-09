package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.FabricSupplier;

public interface FabricSupplierMapper {
	// 添加
	int addFabricSupplier(FabricSupplier fabricSupplier);

	// 查询所有
	List<FabricSupplier> findFabricSupplierByAll();

	// 查询所有
	Integer findFabricSupplierByMaxCode();

	// 查询名称
	List<FabricSupplier> findFabricSupplierBySupplierName(FabricSupplier fabricSupplier);

	// 修改对象
	int modifyFabricSupplier(FabricSupplier fabricSupplier);

	// 带条件查询总条数
	int getFabricSupplierByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<FabricSupplier> findConditionFabricSupplierByPage(Map<String, Object> anyVal);

	FabricSupplier findFabricSupplierById(Integer id);

	FabricSupplier findFabricSupplierBySupplierCode(String supplierCode);
}