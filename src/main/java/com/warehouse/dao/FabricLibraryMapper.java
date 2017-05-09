package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricLibrary;

public interface FabricLibraryMapper {
	// 添加对象
	int addFabricLibrary(FabricLibrary fabricLibrary);

	// 修改对象
	int modifyFabricLibrary(FabricLibrary fabricLibrary);

	// 删除对象
	int delFabricLibraryById(FabricLibrary fabricLibrary);

	// 带条件查询总条数
	int getFabricLibraryByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<FabricLibrary> findConditionFabricLibraryByPage(Map<String, Object> anyVal);

	// 查询所有
	List<FabricLibrary> findFabricLibraryByAll();

	// 根据id查询
	FabricLibrary findFabricLibraryById(@Param("id") Integer id);

	// 根据供应商编号:0001供应商名称:泰森色卡编号:00301颜色编号:014查询 判断是否存在了的数据
	int findFabricLibraryBySupplierCode(FabricLibrary fabricLibrary);

	// 根据fabricLibraryCode查询
	FabricLibrary findFabricLibraryByFabricLibraryCode(@Param("fabricCode") String fabricCode);

}