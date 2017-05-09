package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.DistributionDealerDelivery;

public interface DistributionDealerDeliveryService {



	int getDistributionInfoBpcnt(Map<String, Object> param);

	List<DistributionDealerDelivery> findDistributionInfoCndbp(Map<String, Object> param);

	DistributionDealerDelivery getDistributionInfoBid(Integer id);

	int confirmShipment(Integer id);


	int modifyDistributionInfo(Map<String, Object> param,HttpServletRequest request);

	DistributionDealerDelivery selectById(Map<String, Object> param);

	int updateReportAndReal(Integer id,Integer actual, Integer report);

	

}
