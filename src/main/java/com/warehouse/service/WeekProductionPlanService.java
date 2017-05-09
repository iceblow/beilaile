package com.warehouse.service;

import java.util.List;
import com.warehouse.entity.WeekProductionPlan;

public interface WeekProductionPlanService {

	List<WeekProductionPlan> selectAllData(WeekProductionPlan weekProductionPlan);
	
	List<WeekProductionPlan> selectAllDataTwo(WeekProductionPlan weekProductionPlan);
	
	//查询时间
	List<WeekProductionPlan> selectAllSundayDate(WeekProductionPlan weekProductionPlan);
	
	//返回总页数
	int selectAllPage(WeekProductionPlan weekProductionPlan);
	
	//添加数据
	int insertData(WeekProductionPlan weekProductionPlan);
	
	//添加工厂数据
	int insertFactoryData(WeekProductionPlan weekProductionPlan);
	
	//添加下周工厂数据
	int insertNextFactoryData(WeekProductionPlan weekProductionPlan);
	
	//修改数据
	int updateData(WeekProductionPlan weekProductionPlan);
	
	//修改数据
	int updateTarger(WeekProductionPlan weekProductionPlan);
	
	//修改工厂名
	int updateFactory(String date,String factory,String factoryNow);
	
	//查询是否有这个工厂名
	List<String> selectFactory(String date,String factory,String factoryNow);
	
	//删除数据
	int deleteByFactory(WeekProductionPlan weekProductionPlan);
	
	
	
	
	
}
