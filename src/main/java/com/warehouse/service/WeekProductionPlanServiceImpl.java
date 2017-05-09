package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.WeekProductionPlanMapper;
import com.warehouse.entity.NotStorageRecord;
import com.warehouse.entity.WeekProductionPlan;

@Service
public class WeekProductionPlanServiceImpl implements WeekProductionPlanService{

	@Resource
	private WeekProductionPlanMapper weekProductionPlanMapper;
	
	@Override
	public List<WeekProductionPlan> selectAllData(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanMapper.selectAllDate(weekProductionPlan);
	}
	
	@Override
	public List<WeekProductionPlan> selectAllDataTwo(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanMapper.selectAllDateTwo(weekProductionPlan);
	}

	@Override
	public int insertData(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanMapper.insertData(weekProductionPlan);
	}
	
	@Override
	public int insertFactoryData(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanMapper.insertFactoryData(weekProductionPlan);
	}

	@Override
	public int updateData(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanMapper.updateData(weekProductionPlan);
	}
	
	//修改本周出货目标值
	@Override
	public int updateTarger(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanMapper.updateTarger(weekProductionPlan);
	}

	@Override
	public List<WeekProductionPlan> selectAllSundayDate(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanMapper.selectAllSundayDate(weekProductionPlan);
	}

	//删除数据
	@Override
	public int deleteByFactory(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanMapper.deleteByFactory(weekProductionPlan);
	} 

	//修改工厂名
	@Override
	public int updateFactory(String date,String factory,String factoryNow) {
		
		return weekProductionPlanMapper.updateFactory(date,factory, factoryNow);
	}

	//查看是否有这个工厂名
	@Override
	public List<String> selectFactory(String date,String factory,String factoryNow) {
		
		return weekProductionPlanMapper.selectFactory(date,factory, factoryNow);
	}

	//返回总页数
	@Override
	public int selectAllPage(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanMapper.selectAllPage(weekProductionPlan);
	}

	//添加下周出货计划
	@Override
	public int insertNextFactoryData(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanMapper.insertNextFactoryData(weekProductionPlan);
	}

	
	
}
