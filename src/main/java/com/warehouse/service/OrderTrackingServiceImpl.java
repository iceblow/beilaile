package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.warehouse.dao.OrderTrackingMapper;
import com.warehouse.entity.OrderTracking;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

	@Resource
	private OrderTrackingMapper OrderTrackingMapper;

	@Override
	//查询综调数
	public int selectAllcount(OrderTracking orderTracking) {
		
		return OrderTrackingMapper.selectAllcount(orderTracking);
	}

	@Override
	//返回的结果
	public List<OrderTracking> getOrderTrackingPage(OrderTracking orderTracking) {
		
		return OrderTrackingMapper.getOrderTrackingPage(orderTracking);
	}

	@Override
	public int deleteOrderTrackingById(OrderTracking orderTracking) {
		
		return OrderTrackingMapper.deleteOrderTrackingById(orderTracking);
	}

	@Override
	public int updateByText(OrderTracking orderTracking) {
		
		return OrderTrackingMapper.updateByText(orderTracking);
	}
	
}
