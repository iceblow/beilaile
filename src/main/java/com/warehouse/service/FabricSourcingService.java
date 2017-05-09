package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricSourcing;

public interface FabricSourcingService {
	// 添加
	int addFabricSourcing(FabricSourcing fabricSourcing,HttpServletRequest request);

	// 修改
	int modifyFabricSourcing(FabricSourcing fabricSourcing,HttpServletRequest request);

	// 删除（修改状态）
	int delFabricSourcing(Integer id, String delTime,HttpServletRequest request);

	// 带条件查询总条数
	int getFabricSourcingByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricSourcing> findConditionFabricSourcingByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricSourcing getFabricSourcingById(@Param("id") Integer id);

	List<FabricSourcing> exportCurrentFabricData(Map<String, Object> anyval);

	int modifyFabricSourcingPurchasingStatus(FabricSourcing fabricSourcing, HttpServletRequest request);
}
