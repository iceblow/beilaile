package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.DistributeDetailedOrder;

public interface DistributeDetailedOrderMapper {
	// 分页
	 
	int selectByCount(DistributeDetailedOrder record);

	List<DistributeDetailedOrder> selectByPage(DistributeDetailedOrder record);

	// 修改
	
	int updateByPrimaryKeySelective(DistributeDetailedOrder record);

	//添加
	 
	int insertSelective(DistributeDetailedOrder record);

	// 删除
	
	int delDistributeDetailedOrder(DistributeDetailedOrder record);
	
	//查询
	List<DistributeDetailedOrder> selectByorderId(Integer orderId);
}