package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.TaisanCuttingOutflow;
import com.warehouse.util.PageUtil;

public interface TaisanCuttingOutflowService {
	
	/**
	 * 分页查询
	 * @param pageUtil
	 * @param taisanCuttingOutflow
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanCuttingOutflow taisanCuttingOutflow);

	/**
	 * 裁片就绪
	 * @param wave
	 * @return
	 */
	int cuttingPieceReady(String wave);

	/**
	 * 裁片外发
	 * @param wave
	 * @return
	 */
	int cuttingPieceOut(String wave);
	
	/**
	 * 修改字段
	 * @param wave
	 * @return
	 */
	int updateRowOfSingleAgainByWave(String wave);

}
