package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ProductOnlineProgress;


public interface ProductOnlineProgressService {
	// 添加
	int insertSelective(ProductOnlineProgress record);

	// 修改
	int updateByPrimaryKeySelective(ProductOnlineProgress record);

	// 分页
	int selectCountByPrimaryKey(ProductOnlineProgress record);

	List<ProductOnlineProgress> selectByPrimaryKey(ProductOnlineProgress record);
}
