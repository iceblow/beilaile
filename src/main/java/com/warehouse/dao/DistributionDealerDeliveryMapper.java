package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.DistributionDealerDelivery;

public interface DistributionDealerDeliveryMapper {
	
	

	DistributionDealerDelivery selectByPrimaryKey (int id);
	
	int updateByPrimaryKeySelective (DistributionDealerDelivery distributionDealerDelivery);	

	int getDistributionInfoBpcnt(Map<String, Object> param);

	List<DistributionDealerDelivery> findDistributionInfoCndbp(Map<String, Object> param);

	int confirmShipment(Integer id);

	int modifyDistributionInfo(Map<String, Object> param);

	DistributionDealerDelivery selectById(Map<String, Object> param);

	int updateReportAndReal(Integer id,Integer actual, Integer report);

	
	
	
	

}