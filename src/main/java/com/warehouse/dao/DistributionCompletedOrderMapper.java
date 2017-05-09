package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.DistributionCompletedOrder;

public interface DistributionCompletedOrderMapper {

	// 添加对象
	Integer addDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder);

	// 修改对象
	Integer modifyDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder);

	// 删除对象
	Integer delDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder);

	// 带条件查询总条数
	Integer getDistributionCompletedOrderByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<DistributionCompletedOrder> findConditionDistributionCompletedOrderByPage(Map<String, Object> anyVal);

	// 根据id查询
	DistributionCompletedOrder findDistributionCompletedOrderById(@Param("id") Integer id);

	// 确认入库
	Integer updateDistributionCompletedOrderByStorage(DistributionCompletedOrder distributionCompletedOrder);
}