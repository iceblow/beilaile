package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.PrintingCuttingCompleted;
import com.warehouse.util.PageUtil;

public interface PrintingCuttingCompletedService {
	/**
	 * 分页查询(可以携带条件进行模糊查询)
	 * 
	 * @param pageUtil
	 *            分页信息
	 * @param printingCuttingCompleted
	 *            查询条件
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingCuttingCompleted printingCuttingCompleted);

	/**
	 * 双击修改(每次只能修改一个字段)
	 * 
	 * @param printingCuttingCompleted
	 * @return
	 */
	int updateDataByWave(PrintingCuttingCompleted printingCuttingCompleted);

}
