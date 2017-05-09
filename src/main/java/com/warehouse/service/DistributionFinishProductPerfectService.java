package com.warehouse.service;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.DistributionFinishProductPerfect;
import com.warehouse.util.PageUtil;

public interface DistributionFinishProductPerfectService {

	/**
	 * 分页查询
	 * @param pageUtil
	 * @param record
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, DistributionFinishProductPerfect record);

	/**
	 * 条件修改
	 * @param record
	 * @return
	 */
	int dblUpdate(DistributionFinishProductPerfect record);
	/**
	 * 
	 * 查询后导出excel表格
	 * @param anyVal
	 * @return
	 */
	List<DistributionFinishProductPerfect> exportCurrentDistributionFinishData(
			Map<String, Object> anyVal);

}
