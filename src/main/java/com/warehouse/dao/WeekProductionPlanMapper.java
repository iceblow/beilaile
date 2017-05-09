package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.WeekProductionPlan;

public interface WeekProductionPlanMapper {

	// 查询所有本周出货计划
	List<WeekProductionPlan> selectAllDate(WeekProductionPlan weekProductionPlan);

	// 查询所有本周出货计划
	List<WeekProductionPlan> selectAllDateTwo(WeekProductionPlan weekProductionPlan);

	// 添加数据
	int insertData(WeekProductionPlan weekProductionPlan);

	// 添加工厂数据
	int insertFactoryData(WeekProductionPlan weekProductionPlan);

	// 修改数据
	int updateData(WeekProductionPlan weekProductionPlan);

	// 修改本周目标值
	int updateTarger(WeekProductionPlan weekProductionPlan);

	// 修改本周目标值
	int deleteByFactory(WeekProductionPlan weekProductionPlan);

	// 修改工厂名
	int updateFactory(@Param("date") String date, @Param("factory") String factory,@Param("factoryNow") String factoryNow);

	//查看是否有这个工厂名
	List<String> selectFactory(@Param("date") String date, @Param("factory") String factory,@Param("factoryNow") String factoryNow);
	
	// 查询时间
	List<WeekProductionPlan> selectAllSundayDate(WeekProductionPlan weekProductionPlan);
	
	//查询所有的数据
	int selectAllPage(WeekProductionPlan weekProductionPlan);
	
	//查询所有的数据
	int insertNextFactoryData(WeekProductionPlan weekProductionPlan);
}