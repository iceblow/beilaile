package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.AccessoryPrepared;

public interface AccessoryPreparedMapper {

	// 添加对象
	int addAccessoryPrepared(AccessoryPrepared accessoryPrepared);

	// 修改对象
	int modifyAccessoryPrepared(AccessoryPrepared accessoryPrepared);

	// 删除对象
	int delAccessoryPreparedById(@Param("id") Integer id, @Param("delTime") String delTime);

	// 带条件查询总条数
	int getAccessoryPreparedByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<AccessoryPrepared> findConditionAccessoryPreparedByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	AccessoryPrepared getAccessoryPreparedById(@Param("id") Integer id);
}
