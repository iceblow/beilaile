package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.PrintingAndEmbroideredOrder;
import com.warehouse.util.PageUtil;

public interface PrintingAndEmbroideredOrderService {

	/**
	 * 分页查询
	 * @param pageUtil
	 * @param printingAndEmbroideredOrder
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingAndEmbroideredOrder printingAndEmbroideredOrder);

	/**
	 * 理单完成事件
	 * @param printingAndEmbroideredOrder
	 * @return
	 */
	int completeOrder(PrintingAndEmbroideredOrder printingAndEmbroideredOrder);
	
	/**
	 * 根据波次修改信息
	 * @param wave
	 */
	void updateDataByWave(String wave);

}
