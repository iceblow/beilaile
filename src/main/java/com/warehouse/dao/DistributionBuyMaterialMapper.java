package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.DistributionBuyMaterial;

public interface DistributionBuyMaterialMapper {

    /**
     * 根据条件查询
     * @param params
     * @return
     */
    List<DistributionBuyMaterial> select(Map<String, Object> params);
    
	/**
	 *  查询总条数
	 * @param order
	 * @return
	 */
	int getPageCount(Map<String, Object> param);
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Integer selectById(Integer id);
    
	

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int addDistributionBuyMaterial(DistributionBuyMaterial DistributionBuyMaterial);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateDistributionBuyMaterial(DistributionBuyMaterial DistributionBuyMaterial);
}