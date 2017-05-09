package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.DistributionProduction;

public interface DistributionProductionMapper {


	
	//查询总条数
	int selectAllCount(DistributionProduction distributionProduction);
	
	//分页返回结果
	List<DistributionProduction> getDistributionProductionPage(DistributionProduction distributionProduction);
	
    
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
    DistributionProduction selectById(Integer id);
    
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int addDistributionProduction(DistributionProduction distributionProduction);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateDistributionProduction(DistributionProduction distributionProduction);
    
    
    int toExcelNum(DistributionProduction distributionProduction);
   
    List<DistributionProduction> toExcel(DistributionProduction distributionProduction);

}