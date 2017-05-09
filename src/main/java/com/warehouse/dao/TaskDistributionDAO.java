package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.TaskDistribution;

public interface TaskDistributionDAO {

	// 分页查询---得到总的数据量
	public int getAllCount(TaskDistribution taskDistribution);

	// 分页查询---查询数据
	public List<TaskDistribution> getDataByPage(TaskDistribution taskDistribution);

	// 查询单个---根据编号来查询
	public TaskDistribution getOneById(int id);

	// 添加单条数据
	public int addTaskDistribution(TaskDistribution taskDistribution);

	// 修改
	public int updateTaskDistribution(TaskDistribution taskDistribution);

	// 删除
	public int delData(int id);
	
	//双击修改
	public int dbUpdateTask(TaskDistribution taskDistribution);
}
