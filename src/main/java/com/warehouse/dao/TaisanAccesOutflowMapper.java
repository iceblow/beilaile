package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.TaisanAccesOutflow;

public interface TaisanAccesOutflowMapper {
	
	/**
	 * 得到数据量
	 * @param taisanAccesOutflow
	 * @return
	 */
	int getCount(TaisanAccesOutflow taisanAccesOutflow);
	
	/**
	 * 查询数据
	 * @param taisanAccesOutflow
	 * @return
	 */
	List<TaisanAccesOutflow> getDataByPage(TaisanAccesOutflow taisanAccesOutflow);
	
	
	/**
	 * 重新安排订单
	 * @param wave
	 * @return
	 */
	int rowOfSingleAgain(String wave);
	
	

	
	/**
	 * 辅料准备就绪
	 * @param wave
	 * @return
	 */
	int assistMaterialReady(String wave);
	
	
	
	
	/**
	 * 辅料发放
	 * @param wave
	 * @return
	 */
	int assistOut(String wave);
}