package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.ProductionProblem;
import com.warehouse.util.PageUtil;

public interface ProductionProblemService {

	/**
	 * 反馈问题(添加)
	 * 
	 * @param productionProblem(添加的数据)
	 * @return
	 */
	int insert(ProductionProblem productionProblem);

	/**
	 * 分页查询
	 * 
	 * @param pageUtil 分页信息
	 * @param productionProblem 查询条件
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, ProductionProblem productionProblem);

	/**
	 * 修改方法(同样适用双击修改)
	 * 
	 * @param productionProblem(传入ID和修改后的某个字段)
	 * @return
	 */
	int update(ProductionProblem productionProblem);
		
	/**
	 * 问题解决按钮
	 * @param id 问题编号
	 * @return
	 */
	int complete(int id);
}
