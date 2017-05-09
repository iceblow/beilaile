package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.SalesNotSaleHaoXun;
import com.warehouse.util.PageUtil;

/**
 * 浩讯入库详情接口
 * 
 * @author admin
 *
 */
public interface SalesNotSaleHaoXunService {
	/**
	 * 入库数据分页查询(可以携带条件模糊查询)
	 * 
	 * @param page
	 * @param SalesNotSaleHaoXun
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil page, SalesNotSaleHaoXun notSaleHaoXun);

	/**
	 * 添加浩讯入库信息
	 * 
	 * @param haoXun
	 */
	void addData(SalesNotSaleHaoXun haoXun);

}
