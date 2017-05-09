package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.SewingPickingOrder;

public interface SewingPickingOrderMapper {

	// 新增
	int insertSelective(SewingPickingOrder record);

	// 分页查询
	int getCountBySewing(SewingPickingOrder record);

	List<SewingPickingOrder> selectByPrimaryKey(SewingPickingOrder record);

	// 修改
	int updateByPrimaryKeySelective(SewingPickingOrder record);

	// 根据订单号查询
	SewingPickingOrder selSewingByOrderId(Integer orderId);

	List<SewingPickingOrder> listSewingPickingOrderAll();

}