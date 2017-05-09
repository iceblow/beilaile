package com.warehouse.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.warehouse.entity.DistributionReceiveFabric;

public interface DistributionReceiveFabricMapper {
	// 添加
	int addDistributionReceiveFabric(DistributionReceiveFabric distributionReceiveFabric);

	// 修改
	int modifyDistributionReceiveFabric(DistributionReceiveFabric distributionReceiveFabric);

	// 删除（修改状态）
	int delDistributionReceiveFabricById(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getDistributionReceiveFabricByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<DistributionReceiveFabric> findConditionDistributionReceiveFabricByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	DistributionReceiveFabric getDistributionReceiveFabricById(@Param("id") Integer id);

	int updateDistributionReceiveFabricByCompleteStatus(DistributionReceiveFabric distributionReceiveFabric);

}