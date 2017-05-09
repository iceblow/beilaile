package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.InputStorageHaoXun;
import com.warehouse.util.PageUtil;

/**
 * 浩讯入库详情接口
 * 
 * @author admin
 *
 */
public interface InputStorageHaoXunService {
	/**
	 * 入库数据分页查询(可以携带条件模糊查询)
	 * 
	 * @param page
	 * @param inputStorageHaoXun
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil page, InputStorageHaoXun inputStorageHaoXun);

	/**
	 * 添加浩讯入库信息
	 * 
	 * @param haoXun
	 */
	void addData(InputStorageHaoXun haoXun);

}
