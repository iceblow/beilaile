package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ReturnToSinglePattern;

public interface ReturnToSinglePatternService {

	/**
	 * @作用 查询数据量
	 * @param returnToSinglePattern 查询条件
	 * @return
	 */
	int getCount(ReturnToSinglePattern returnToSinglePattern);

	/**
	 * @作用 分页查询数据
	 * @param returnToSinglePattern 查询条件
	 * @return
	 */
	List<ReturnToSinglePattern> getDataByPage(ReturnToSinglePattern returnToSinglePattern);

	/**
	 * @作用 需要样衣
	 * @param id 编号
	 * @return
	 */
	int needToBeSampleCloth(int id);

	/**
	 * @作用 纸样完成
	 * @param id 编号
	 * @return
	 */
	int pieceSampleComplete(int id);

}
