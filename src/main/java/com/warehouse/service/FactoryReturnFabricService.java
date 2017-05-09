package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FactoryReturnFabric;

public interface FactoryReturnFabricService {
	// 添加
	int addFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request);

	// 修改
	int modifyFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request);

	// 删除（修改状态）
	int delFactoryReturnFabricById(Integer id, HttpServletRequest request);

	// 带条件查询总条数
	int getFactoryReturnFabricByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FactoryReturnFabric> findConditionFactoryReturnFabricByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FactoryReturnFabric getFactoryReturnFabricById(@Param("id") Integer id);

	// 修改
	int updateFactoryReturnFabricByCompleteStatus(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request);
}
