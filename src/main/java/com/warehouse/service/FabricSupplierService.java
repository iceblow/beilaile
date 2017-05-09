package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.FabricSupplier;

public interface FabricSupplierService {
	// 添加
	int addFabricSupplier(FabricSupplier fabricSupplier,HttpServletRequest request);

	// 查询所有
	List<FabricSupplier> findFabricSupplierByAll();

	// 查询名称
	List<FabricSupplier> findFabricSupplierBySupplierName(FabricSupplier fabricSupplier);

	// 修改对象
	int modifyFabricSupplier(FabricSupplier fabricSupplier, HttpServletRequest request);

	// 带条件查询总条数
	int getFabricSupplierByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<FabricSupplier> findConditionFabricSupplierByPage(Map<String, Object> anyVal);

	FabricSupplier findFabricSupplierById(Integer id);

	FabricSupplier findFabricSupplierBySupplierCode(String supplierCode);
}
