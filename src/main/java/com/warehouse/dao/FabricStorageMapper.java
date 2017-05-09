package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricStorage;

public interface FabricStorageMapper {
	// 添加
	int addFabricStorage(FabricStorage fabricStorage);

	// 修改
	int modifyFabricStorage(FabricStorage fabricStorage);

	// 删除（修改状态）
	int delFabricStorage(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getFabricStorageByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricStorage> findConditionFabricStorageByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricStorage getFabricStorageById(@Param("id") Integer id);

	// 修改
	int updateFabricStorageByCompleteStatus(FabricStorage fabricStorage);
}