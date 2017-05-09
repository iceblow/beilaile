package com.warehouse.dao;

import com.warehouse.entity.AccessoryPurchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccessoryPurchaseMapper {


	// 带条件查询总条数
	int getAccessoryPurchaseByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<AccessoryPurchase> findConditionAccessoryPurchaseByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	AccessoryPurchase getAccessoryPurchaseById(@Param("id") Integer id);


	int updatePurchaseIssuedStatus(AccessoryPurchase accessoryPurchase);
}