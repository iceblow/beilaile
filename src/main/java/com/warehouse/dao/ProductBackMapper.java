package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ProductBack;

public interface ProductBackMapper {

	// 删除
	int deleteByPrimaryKey(ProductBack record);

	// 添加
	int insertSelective(ProductBack record);

	// 根据id查询
	ProductBack getOne(Integer id);

	// 修改
	int updateByPrimaryKeySelective(ProductBack record);

	// 分页
	int getCountByPage(ProductBack record);

	List<ProductBack> getDataByPage(ProductBack record);

	// 分析
	Integer analysis();

}