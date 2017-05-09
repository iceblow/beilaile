package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.SewingFactoryPickingOrder;

public interface SewingFactoryPickingOrderMapper {

	// 分页查询
	int getCountBySewingFactory(SewingFactoryPickingOrder record);

	List<SewingFactoryPickingOrder> selectByPrimaryKey(SewingFactoryPickingOrder record);

	// 修改
	int updateByPrimaryKeySelective(SewingFactoryPickingOrder record);

	// 根据订单号查询
	List<SewingFactoryPickingOrder> selSewingFactory(Integer orderId);

}