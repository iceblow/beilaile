package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.OrderMemoDemo;
import com.warehouse.util.Pagess;

public interface OrderMemoDAO {
	/**
	 * 得到所有的数据量
	 * 
	 * @return
	 */
	int getAllCount();

	/**
	 * 分页查询所有的数据
	 * 
	 * @param pagess
	 * @return
	 */
	List<OrderMemoDemo> getAllByPage(Pagess pagess);

	/**
	 * 修改数据信息
	 * 
	 * @param order
	 */
	void update(OrderMemoDemo order);

	/**
	 * 添加数据信息
	 * 
	 * @param order
	 */
	void add(OrderMemoDemo order);
	/**
	 * 真删除
	 * @param id
	 */
	void trueDel(int id);
	/**
	 * 假删除数据
	 * @param order
	 */
	void fakeDel(OrderMemoDemo order);

}
