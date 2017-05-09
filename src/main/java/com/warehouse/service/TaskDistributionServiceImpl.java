package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.TaskDistributionDAO;
import com.warehouse.entity.TaskDistribution;

@Service
public class TaskDistributionServiceImpl implements TaskDistributionService {

	@Resource
	private TaskDistributionDAO taskDistributionDAO;
	
	@Override
	public int getAllCount(TaskDistribution taskDistribution) {
		// TODO Auto-generated method stub
		return this.taskDistributionDAO.getAllCount(taskDistribution);
	}

	@Override
	public List<TaskDistribution> getDataByPage(TaskDistribution taskDistribution) {
		return this.taskDistributionDAO.getDataByPage(taskDistribution);
	}

	@Override
	public TaskDistribution getOneByid(Integer id) {
		return this.taskDistributionDAO.getOneById(id);
	}

	@Override
	public int update(TaskDistribution taskDistribution) {
		return this.taskDistributionDAO.updateTaskDistribution(taskDistribution);
	}

	@Override
	public int dbUpdateTask(TaskDistribution taskDistribution) {
		return this.taskDistributionDAO.dbUpdateTask(taskDistribution);
	}

}
