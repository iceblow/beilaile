package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.DistributionFinishProductPerfect;

public interface DistributionFinishProductPerfectMapper {
	
	/**
	 * 查询单条数据
	 * @param id
	 * @return
	 */
    DistributionFinishProductPerfect selectByPrimaryKey(Integer id);

    /**
     * 根据传入条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DistributionFinishProductPerfect record);
    
    /**
     * 查询数据量
     * @param record
     * @return
     */
    int getCount(DistributionFinishProductPerfect record);

    /**
     * 分页查询数据
     * @param record
     * @return
     */
    List<DistributionFinishProductPerfect> getDataByPage(DistributionFinishProductPerfect record);

	List<DistributionFinishProductPerfect> exportCurrentDistributionFinishData(
			Map<String, Object> anyVal);
}