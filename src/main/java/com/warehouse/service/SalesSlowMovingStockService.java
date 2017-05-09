package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.SalesSlowMovingStock;
import com.warehouse.util.PageUtil;

public interface SalesSlowMovingStockService {
	/**
	 * 带条件的分页查询
	 * @param page 前台传入的分页信息
	 * @param salesSlowMovingStock 传入的查询条件
	 * @return
	 */
	public Map<String, Object> getAllByPage(PageUtil page, SalesSlowMovingStock salesSlowMovingStock);

}
