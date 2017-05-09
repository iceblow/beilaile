package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricSourcing;

public interface FabricSourcingMapper {
	// 添加
	int addFabricSourcing(FabricSourcing fabricSourcing);

	// 修改
	int modifyFabricSourcing(FabricSourcing fabricSourcing);

	// 删除（修改状态）
	int delFabricSourcing(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getFabricSourcingByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricSourcing> findConditionFabricSourcingByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricSourcing getFabricSourcingById(@Param("id") Integer id);

	int modifyFabricSourcingPurchasingStatus(FabricSourcing fabricSourcing);

	List<FabricSourcing> exportCurrentFabricData(Map<String, Object> anyval);

}