package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.CuttingFabricCompleted;
import com.warehouse.util.PageUtil;

public interface CuttingFabricCompletedService {
	/**
	 * 页面分页查询(可以带条件进行模糊查询)
	 * @param pageUtil 分页信息
	 * @param cuttingFabricCompleted 传入的条件信息(值可以为空)
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, CuttingFabricCompleted cuttingFabricCompleted);
	
	/**
	 * 双击操作修改信息的方法
	 * 每次只能修改单个字段
	 * @param cuttingFabricCompleted
	 * @return
	 */
	int updateDateByWave(CuttingFabricCompleted cuttingFabricCompleted);

	/**
	 * 安排面料按钮点击事件
	 * @param wave
	 * @return
	 */
	int remarkUpdate(String wave);
	
	/**
	 * 裁剪完成按钮点击事件
	 * @param wave
	 * @return
	 */
	int planCut(CuttingFabricCompleted cuttingFabricCompleted);

}
