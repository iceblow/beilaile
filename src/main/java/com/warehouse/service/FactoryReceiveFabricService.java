package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FactoryReceiveFabric;

public interface FactoryReceiveFabricService {
	// 添加
	int addFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric,HttpServletRequest request);

	// 修改
	int modifyFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric,HttpServletRequest request);

	// 删除（修改状态）
	int delFactoryReceiveFabricById(Integer id,HttpServletRequest request);

	// 带条件查询总条数
	int getFactoryReceiveFabricByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FactoryReceiveFabric> findConditionFactoryReceiveFabricByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FactoryReceiveFabric getFactoryReceiveFabricById(@Param("id") Integer id);

	// 修改状态
	int updateFactoryReceiveFabricByCompleteStatus(FactoryReceiveFabric factoryReceiveFabric, HttpServletRequest request);
}
