package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricReturnBack;


public interface FabricReturnBackMapper {
	// 添加
	int addFabricOutflow(FabricReturnBack fabricReturnBack);

	// 修改
	int modifyFabricOutflow(FabricReturnBack fabricReturnBack);

	// 删除（修改状态）
	int delFabricOutflow(@Param("id") Integer id, @Param("deleteTime") String deleteTime);

	// 带条件查询总条数
	int getFabricOutflowByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricReturnBack> findConditionFabricOutflowByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricReturnBack getFabricOutflowById(@Param("id") Integer id);

	// 修改状态
	int updateFabricOutflowByCompleteStatus(FabricReturnBack fabricOutflow);
	
	// 修改状态
	int updateColourById(FabricReturnBack fabricOutflow);

}