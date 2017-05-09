package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ProductionProblem;

public interface ProductionProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductionProblem record);

    int insertSelective(ProductionProblem record);

    ProductionProblem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductionProblem record);

    int updateByPrimaryKey(ProductionProblem record);
    
    /**
     * 分页查询数据量
     * @param productionProblem
     * @return
     */
	int getCountByPage(ProductionProblem productionProblem);
	
	/**
	 * 得到分页查询的数据
	 * @param productionProblem
	 * @return
	 */
	List<ProductionProblem> getDataByPage(ProductionProblem productionProblem);

	/**
	 * 问题解决
	 * @param id
	 * @return
	 */
	int complete(int id);
}