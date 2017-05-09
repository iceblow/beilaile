package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.DistributionCompletedOrderMapper;
import com.warehouse.entity.DistributionCompletedOrder;
import com.warehouse.util.DateUtils;

@Service
public class DistributionCompletedOrderServiceImpl implements DistributionCompletedOrderService {
	@Resource
	public DistributionCompletedOrderMapper distributionCompletedOrderMapper;

	@Override
	public Integer addDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder) {
		distributionCompletedOrder.setCreateTime(DateUtils.formateDaTime(new Date()));
		return distributionCompletedOrderMapper.addDistributionCompletedOrder(distributionCompletedOrder);
	}

	@Override
	public Integer modifyDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder) {
		distributionCompletedOrder.setModifyTime(DateUtils.formateDaTime(new Date()));
		return distributionCompletedOrderMapper.modifyDistributionCompletedOrder(distributionCompletedOrder);
	}

	@Override
	public Integer delDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder) {
		distributionCompletedOrder.setDeleteTime(DateUtils.formateDaTime(new Date()));
		distributionCompletedOrder.setDataStatus("已删除");
		return distributionCompletedOrderMapper.delDistributionCompletedOrder(distributionCompletedOrder);
	}

	@Override
	public Integer getDistributionCompletedOrderByPageCount(Map<String, Object> anyVal) {
		return distributionCompletedOrderMapper.getDistributionCompletedOrderByPageCount(anyVal);

	}

	@Override
	public List<DistributionCompletedOrder> findConditionDistributionCompletedOrderByPage(Map<String, Object> anyVal) {
		return distributionCompletedOrderMapper.findConditionDistributionCompletedOrderByPage(anyVal);
	}

	@Override
	public DistributionCompletedOrder findDistributionCompletedOrderById(Integer id) {
		return distributionCompletedOrderMapper.findDistributionCompletedOrderById(id);
	}

	@Override
	public Integer updateDistributionCompletedOrderByStorage(Integer id) {
		DistributionCompletedOrder distributionCompletedOrder = distributionCompletedOrderMapper
				.findDistributionCompletedOrderById(id);
		distributionCompletedOrder.setConfirmStorageTime(DateUtils.formateDaTime(new Date()));
		distributionCompletedOrder.setDataStatus("已入库");
		return distributionCompletedOrderMapper.updateDistributionCompletedOrderByStorage(distributionCompletedOrder);
	}

}
