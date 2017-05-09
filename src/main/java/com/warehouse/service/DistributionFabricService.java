package com.warehouse.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.DistributionFabric;

public interface DistributionFabricService {

	// 查询分页
	List<DistributionFabric> findDistributionFabricPageByVal(Map<String, Object> anyVal);

	// 总条数
	int getDistributionFabricTotalPageByVal(Map<String, Object> anyval);

	// 添加
	int addDistributionFabric(DistributionFabric distributionFabric);

	// 修改
	int modifyDistributionFabric(DistributionFabric distributionFabric);

	// 刪除
	int delByDistributionFabric(int id);

	// 修改获取数据根据id
	DistributionFabric getDistributionFabricById(@Param("id") Integer id);

	// 修改获取数据根据id
	int modifyDistributionFabricIssuedStatus(DistributionFabric distributionFabric);

}
