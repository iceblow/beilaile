package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.OrderMemoDemo;
import com.warehouse.util.Pagess;

public interface OrderMemoService {
	//得到全部订单的数据量
	int getAllCount();
	//所有数据的分页查询
	List<OrderMemoDemo> getAllByPage(Pagess pagess);
	//数据修改
	void update(OrderMemoDemo order);
	//添加数据
	void add(OrderMemoDemo order);
	//真删除数据
	void trueDel(int id);
	//假删除数据，并写入删除的时间
	void fakeDel(OrderMemoDemo order);
	
}
