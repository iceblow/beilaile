package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricOutflow;

public interface FabricOutflowMapper {
	// 添加
	int addFabricOutflow(FabricOutflow fabricOutflow);

	// 修改
	int modifyFabricOutflow(FabricOutflow fabricOutflow);

	// 删除（修改状态）
	int delFabricOutflow(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getFabricOutflowByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricOutflow> findConditionFabricOutflowByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricOutflow getFabricOutflowById(@Param("id") Integer id);

	// 修改状态
	int updateFabricOutflowByCompleteStatus(FabricOutflow fabricOutflow);

}