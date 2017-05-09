package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.DistributionFabric;

public interface DistributionFabricMapper {
	// 查询对象
	List<DistributionFabric> findDistributionFabricPageByVal(Map<String, Object> anyVal);

	// 条件查询总数据
	int getDistributionFabricTotalPageByVal(Map<String, Object> anyval);

	// 修改
	int modifyDistributionFabric(DistributionFabric distributionFabric);

	// 添加
	int addDistributionFabric(DistributionFabric distributionFabric);

	// 刪除
	int delByDistributionFabric(@Param("id") int id, @Param("delTime") String delTime);

	// 修改获取数据根据id
	DistributionFabric getDistributionFabricById(@Param("id") Integer id);

	// 修改状态
	int modifyDistributionFabricIssuedStatus(DistributionFabric distributionFabric);
	
	//添加修改时间
	int addDistributionFabricIssuedTime(DistributionFabric distributionFabric);

}