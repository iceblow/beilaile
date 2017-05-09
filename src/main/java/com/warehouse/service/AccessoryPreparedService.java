package com.warehouse.service;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.AccessoryPrepared;

public interface AccessoryPreparedService {

	
		// 新增 辅料就绪
		int addAccessoryPrepared(AccessoryPrepared accessoryPrepared);

		// 修改辅料就绪
		int modifyAccessoryPrepared(AccessoryPrepared accessoryPrepared);

		// 逻辑删除 辅料就绪
		int delAccessoryPrepared(Integer id);

		// 带条件分页查询查询
		List<AccessoryPrepared> findConditionAccessoryPreparedByPage(Map<String, Object> anyVal);

		// 修改获取数据根据id
		AccessoryPrepared getAccessoryPreparedById(Integer id);

		// 带条件查询总条数
		int getAccessoryPreparedByPageCount(Map<String, Object> anyval);
}
