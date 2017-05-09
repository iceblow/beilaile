package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.PrintingProcessCase;
import com.warehouse.util.PageUtil;

public interface PrintingProcessCaseService {

	/**
	 * 分页查询
	 * @param pageUtil 分页信息
	 * @param printingProcessCase 查询条件
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingProcessCase printingProcessCase);
	
	/**
	 * 匹印领料
	 * @param id
	 * @return
	 */
	int fabricOut(int id);

	/**
	 * 匹印回料
	 * @param id
	 * @return
	 */
	int fabricIn(int id);

}
