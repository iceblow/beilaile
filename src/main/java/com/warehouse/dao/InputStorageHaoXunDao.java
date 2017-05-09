package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.InputStorageHaoXun;

public interface InputStorageHaoXunDao {
	/**
	 * 得到分压查询数据量
	 * 
	 * @param inputStorageHaoXun
	 * @return
	 */
	int getCountByPage(InputStorageHaoXun inputStorageHaoXun);

	/**
	 * 分页查询信息
	 * 
	 * @param inputStorageHaoXun
	 * @return
	 */
	List<InputStorageHaoXun> getDataByPage(InputStorageHaoXun inputStorageHaoXun);

	/**
	 * 根据波次号查询入库信息
	 * 
	 * @param wave
	 * @return
	 */
	InputStorageHaoXun getOneByWave(String wave);

	/**
	 * 修改信息
	 */
	int updateData(InputStorageHaoXun inputStorageHaoXun);
	
	/**
	 * 添加信息
	 * @param inputStorageHaoXun
	 * @return
	 */
	int addData(InputStorageHaoXun inputStorageHaoXun);

}
