package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.SewingFactoryPickingOrder;

public interface SewingFactoryPickingOrderService {

	// 分页查询
	int getCountBySewingFactory(SewingFactoryPickingOrder record);

	List<SewingFactoryPickingOrder> selectByPrimaryKey(SewingFactoryPickingOrder record);

	// 修改
	int updateByPrimaryKeySelective(SewingFactoryPickingOrder record);

	// 查询
	List<SewingFactoryPickingOrder> factoryPickingOrders(Integer orderId);

}
