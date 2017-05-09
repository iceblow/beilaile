package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.OrderTracking;

public interface OrderTrackingService {

	//分页查询总条数
	int selectAllcount(OrderTracking orderTracking);
	
	//查询返回的list
	List<OrderTracking> getOrderTrackingPage(OrderTracking orderTracking);
	
	//修改数据状态
	int deleteOrderTrackingById(OrderTracking orderTracking);
	
	//修改数据状态
	int updateByText(OrderTracking orderTracking);
}
