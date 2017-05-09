package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricStorage;

public interface FabricStorageService {
	// 添加
	int addFabricStorage(FabricStorage fabricStorage,HttpServletRequest request);

	// 修改
	int modifyFabricStorage(FabricStorage fabricStorage,HttpServletRequest request);

	// 删除（修改状态）
	int delFabricStorage(Integer id,HttpServletRequest request);

	// 带条件查询总条数
	int getFabricStorageByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricStorage> findConditionFabricStorageByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricStorage getFabricStorageById(@Param("id") Integer id);
	
	int updateFabricStorageByTotal(FabricStorage fabricStorage, HttpServletRequest request);
	int updateFabricStorageByCompleteStatus(FabricStorage fabricStorage, HttpServletRequest request);
}
