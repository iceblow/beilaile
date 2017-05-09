package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.DistributionConfirmOrder;

public interface DistributionConfirmOrderMapper {
	//查询总条数
	int selectAllcount(DistributionConfirmOrder distributionConfirmOrder);
			
	//返回的结果
	List<DistributionConfirmOrder> getDistributionConfirmOrderPage(DistributionConfirmOrder distributionConfirmOrder);
			
	//确认下单
	int sureDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder);
	
	//放弃下单
	int giveUpDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder);
	
	//查询总条数
	int updateDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder);
}