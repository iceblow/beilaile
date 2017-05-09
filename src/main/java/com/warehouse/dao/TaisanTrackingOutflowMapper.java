package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.TaisanTrackingOutflow;

public interface TaisanTrackingOutflowMapper {
	
	/**
	 * 得到数据量
	 * @return
	 */
	int getCount(TaisanTrackingOutflow taisanTrackingOutflow);
	
	/**
	 * 得到分页查询的数据
	 * @return
	 */
	List<TaisanTrackingOutflow> getDataByPage(TaisanTrackingOutflow taisanTrackingOutflow);
	
	/**
	 * 安排裁片辅料 
	 * @return
	 */
	int arrangeFabricAndAssistMaterial(String wave);
	
	/**
	 * 通知车缝工厂
	 * @return
	 */
	int informFactory(String wave);
	
	int insert(TaisanTrackingOutflow record);

	int insertSelective(TaisanTrackingOutflow record);
	
	/**
	 * 根据波次号查询单条数据
	 * @param wave
	 * @return
	 */
	TaisanTrackingOutflow getOneByWave(String wave);
	
	/**
	 * 修改车缝厂
	 * @param trackingOutflow
	 * @return
	 */
	int updateFactory(TaisanTrackingOutflow trackingOutflow);
	
	/**
	 * 申请重新排单
	 * @param wave
	 * @return
	 */
	int updateRowOfSingleAgain(String wave);
}