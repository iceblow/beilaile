package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricOutflow;

public interface FabricOutflowService {
	// 添加
	int addFabricOutflow(FabricOutflow fabricOutflow, HttpServletRequest request);

	// 修改
	int modifyFabricOutflow(FabricOutflow fabricOutflow, HttpServletRequest request);

	// 删除（修改状态）
	int delFabricOutflow(Integer id, HttpServletRequest request);

	// 带条件查询总条数
	int getFabricOutflowByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricOutflow> findConditionFabricOutflowByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricOutflow getFabricOutflowById(@Param("id") Integer id);

	// 修改
	int updateFabricOutflowByCompleteStatus(FabricOutflow fabricOutflow,HttpServletRequest request);

}
