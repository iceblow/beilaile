package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FactoryReceiveFabric;

public interface FactoryReceiveFabricMapper {
	// 添加
	int addFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric);

	// 修改
	int modifyFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric);

	// 删除（修改状态）
	int delFactoryReceiveFabricById(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getFactoryReceiveFabricByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<FactoryReceiveFabric> findConditionFactoryReceiveFabricByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	FactoryReceiveFabric getFactoryReceiveFabricById(@Param("id") Integer id);

	int updateFactoryReceiveFabricByCompleteStatus(FactoryReceiveFabric factoryReceiveFabric);

}