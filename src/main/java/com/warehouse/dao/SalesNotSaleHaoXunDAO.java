package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.SalesNotSaleHaoXun;

public interface SalesNotSaleHaoXunDAO {
	/**
	 * 得到分压查询数据量
	 * 
	 * @param inputStorageHaoXun
	 * @return
	 */
	int getCountByPage(SalesNotSaleHaoXun notSaleHaoXun);

	/**
	 * 分页查询信息
	 * 
	 * @param inputStorageHaoXun
	 * @return
	 */
	List<SalesNotSaleHaoXun> getDataByPage(SalesNotSaleHaoXun notSaleHaoXun);

	/**
	 * 根据波次号查询入库信息
	 * 
	 * @param wave
	 * @return
	 */
	SalesNotSaleHaoXun getOneByWave(String wave);

	/**
	 * 修改信息
	 */
	int updateData(SalesNotSaleHaoXun notSaleHaoXun);

	/**
	 * 添加信息
	 * 
	 * @param inputStorageHaoXun
	 * @return
	 */
	int addData(SalesNotSaleHaoXun notSaleHaoXun);

}
