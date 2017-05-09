package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.TaisanCuttingOutflow;

public interface TaisanCuttingOutflowMapper {
	
	/**
	 * 得到数据量
	 * @param taisanCuttingOutflow
	 * @return
	 */
	int getCount(TaisanCuttingOutflow taisanCuttingOutflow);
	
	/**
	 * 查询数据
	 * @param taisanCuttingOutflow
	 * @return
	 */
	List<TaisanCuttingOutflow> getDataByPage(TaisanCuttingOutflow taisanCuttingOutflow);
	
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
	
	//修改字段RowOfSingleAgain
	int updateRowOfSingleAgainByWave(String wave);
	
}