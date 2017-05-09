package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.PrintingQuote;
import com.warehouse.util.PageUtil;

public interface PrintingQuoteService {

	/**
	 * 分页查询
	 * @param pageUtil 分页信息
	 * @param printingQuote 查询条件
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingQuote printingQuote);

	/**
	 * 双击修改
	 * @param printingQuote
	 * @return
	 */
	int mydblClick(PrintingQuote printingQuote);

	/**
	 * 确认报价
	 * @param id
	 * @return
	 */
	int confirmPiece(int id);
	
	/**
	 * 根据波次号真删除数据
	 * @param wave
	 */
	void delDataByWave(String wave);

}
