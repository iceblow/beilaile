package com.warehouse.dao;

import com.warehouse.entity.AccessoryRation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccessoryRationMapper {


	// 带条件查询总条数
	int getAccessoryRationByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<AccessoryRation> findConditionAccessoryRationByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	AccessoryRation getAccessoryRationById(@Param("id") Integer id);


	int updateRationIssuedStatus(AccessoryRation accessoryRation);
}