package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.OrderTracking;

public interface OrderTrackingMapper {
	//查询总条数
	int selectAllcount(OrderTracking orderTracking);
	
	//返回的结果
	List<OrderTracking> getOrderTrackingPage(OrderTracking orderTracking);
	
	//查询总条数
	int deleteOrderTrackingById(OrderTracking orderTracking);
	
	//查询总条数
	int updateByText(OrderTracking orderTracking);
   
}