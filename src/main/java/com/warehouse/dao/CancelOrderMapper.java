package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.CancelOrder;

public interface CancelOrderMapper {

	// 撤销订单
	int deleteByPrimaryKey(CancelOrder record);

	// 添加删除订单
	int insertSelective(CancelOrder record);

	// 分页查询
	int selByPrimaryKeyCount(CancelOrder record);

	List<CancelOrder> selByPrimaryKeyPage(CancelOrder record);

}