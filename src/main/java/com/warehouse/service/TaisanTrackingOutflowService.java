package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.TaisanTrackingOutflow;
import com.warehouse.util.PageUtil;

public interface TaisanTrackingOutflowService {

	/**
	 * 分页查询数据(附带模糊查询)
	 * 
	 * @param pageUtil(分页信息)
	 * @param taisanTrackingOutflow(模糊查询信息,没有查询条件传入空实体就行)
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanTrackingOutflow taisanTrackingOutflow);

	/**
	 * 安排面辅料
	 * @param wave 波次
	 * @return
	 */
	int arrangeFabricAndAssistMaterial(String wave);

	/**
	 * 通知工厂
	 * @param wave
	 * @return
	 */
	int informFactory(String wave);

	/**
	 * 根据波次号查询单条数据
	 * @param wave 波次号
	 * @return
	 */
	TaisanTrackingOutflow getOneByWave(String wave);

	/**
	 * 修改车缝厂
	 * @param taisanTrackingOutflow
	 * @return
	 */
	int updateFactory(TaisanTrackingOutflow taisanTrackingOutflow);
	
	/**
	 * 申请重新排单
	 * @param id
	 * @return
	 */
	int updateRowOfSingleAgain(String wave);

}
