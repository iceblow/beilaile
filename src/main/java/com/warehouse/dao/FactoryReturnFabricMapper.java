package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FactoryReturnFabric;

public interface FactoryReturnFabricMapper {
	// 添加
	int addFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric);

	// 修改
	int modifyFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric);

	// 删除（修改状态）
	int delFactoryReturnFabricById(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getFactoryReturnFabricByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FactoryReturnFabric> findConditionFactoryReturnFabricByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FactoryReturnFabric getFactoryReturnFabricById(@Param("id") Integer id);

	// 修改
	int updateFactoryReturnFabricByCompleteStatus(FactoryReturnFabric factoryReturnFabric);

}