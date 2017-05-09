package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ReturnToSinglePattern;

public interface ReturnToSinglePatternMapper {
	/**
	 * @作者 Earl
	 * @作用 查询单条数据
	 * @param id
	 * @return
	 */
	ReturnToSinglePattern selectByPrimaryKey(Integer id);

	/**
	 * @作者 Earl
	 * @作用 查询数据量
	 * @param returnToSinglePattern
	 *            查询条件
	 * @return
	 */
	int getCount(ReturnToSinglePattern returnToSinglePattern);

	/**
	 * @作者 Earl
	 * @作用 查询分页数据
	 * @param returnToSinglePattern 查询条件
	 * @return
	 */
	List<ReturnToSinglePattern> getDataByPage(ReturnToSinglePattern returnToSinglePattern);
	
	/**
	 * @作用 需要样衣
	 * @param id
	 * @return
	 */
	int needToBeSampleCloth(int id);
	
	/**
	 * @作用 纸样完成
	 * @param id
	 * @return
	 */
	int pieceSampleComplete(int id);

}