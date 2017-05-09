package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ProductBack;

public interface ProductBackService {

	// 删除
	int delProduct(ProductBack record);

	// 添加
	int addProduct(ProductBack record);

	// 根据id查询
	ProductBack getOne(Integer id);

	// 修改
	int uppProduct(ProductBack record);

	// 分页
	int getCountByPage(ProductBack record);

	List<ProductBack> getDataByPage(ProductBack record);

	// 分析
	Integer analysis();

}