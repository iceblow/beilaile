package com.warehouse.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.warehouse.entity.DistributionConfirmOrder;

public interface DistributionConfirmOrderService {

	// 分页查询总条数
	int selectAllcount(DistributionConfirmOrder distributionConfirmOrder);

	// 查询返回的list
	List<DistributionConfirmOrder> getDistributionConfirmOrderPage(DistributionConfirmOrder distributionConfirmOrder);

	// 确认下单
	int sureDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder);

	// 放弃下单
	int giveUpDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder);

	//修改数据状态
	int updateDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder,HttpServletRequest request);
}
