package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PrintingQuote;

public interface PrintingQuoteMapper {

	/**
	 * 得到总的数据量
	 * 
	 * @param printingQuote
	 * @return
	 */
	int getCount(PrintingQuote printingQuote);

	/**
	 * 分页查询数据
	 * 
	 * @param printingQuote
	 * @return
	 */
	List<PrintingQuote> getDataByPage(PrintingQuote printingQuote);

	/**
	 * 根据id查询单个
	 * 
	 * @param id
	 * @return
	 */
	PrintingQuote selectByPrimaryKey(Integer id);

	/**
	 * 根据传入的参数修改
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(PrintingQuote record);

	/**
	 * 修改所有字段
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(PrintingQuote record);

	/**
	 * 确认报价
	 * @param id
	 * @return
	 */
	int confirmPiece(int id);
	/**
	 * 删除信息
	 * @param wave
	 */
	void delDataByWave(String wave);
}