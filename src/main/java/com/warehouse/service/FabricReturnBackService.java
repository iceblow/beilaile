package com.warehouse.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;

import com.warehouse.entity.FabricReturnBack;

public interface FabricReturnBackService {
	// 添加
	int addFabricReturnBack(FabricReturnBack fabricReturnBack);

	// 修改
	int modifyFabricOutflow(FabricReturnBack fabricReturnBack);
	
	// 修改
	int updateColourById(FabricReturnBack fabricReturnBack);

	// 删除（修改状态）
	int delFabricOutflow(Integer id);

	// 带条件查询总条数
	int getFabricOutflowByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FabricReturnBack> findConditionFabricOutflowByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FabricReturnBack getFabricOutflowById(@Param("id") Integer id);

	// 修改
	int updateFabricOutflowByCompleteStatus(FabricReturnBack fabricReturnBack, HttpRequest httpRequest);

}
