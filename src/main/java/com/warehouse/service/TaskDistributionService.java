package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.TaskDistribution;

public interface TaskDistributionService {

	int getAllCount(TaskDistribution taskDistribution);

	List<TaskDistribution> getDataByPage(TaskDistribution taskDistribution);

	TaskDistribution getOneByid(Integer id);

	int update(TaskDistribution taskDistribution);

	int dbUpdateTask(TaskDistribution taskDistribution);
	
}
