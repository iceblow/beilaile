package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricLibrary;

public interface FabricLibraryService {
	// 添加对象
	int addFabricLibrary(FabricLibrary FabricLibrary, HttpServletRequest request);

	// 修改对象
	int modifyFabricLibrary(FabricLibrary FabricLibrary, HttpServletRequest request);

	// 删除对象
	int delFabricLibraryById(FabricLibrary FabricLibrary, HttpServletRequest request);

	// 带条件查询总条数
	int getFabricLibraryByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<FabricLibrary> findConditionFabricLibraryByPage(Map<String, Object> anyVal);

	// 查询所有
	List<FabricLibrary> findFabricLibraryByAll();

	// 根据id查询
	FabricLibrary findFabricLibraryById(@Param("id") Integer id);

	// 根据fabricLibraryCode查询
	FabricLibrary findFabricLibraryByFabricLibraryCode(String fabricCode);

	// 根据名称.颜色,产地查询
	int findFabricLibraryBySupplierCode(FabricLibrary FabricLibrary);
}
