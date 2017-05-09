package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.Fabricmanagement;
import com.warehouse.util.Pagess;

public interface FabricmanagementMapper {

	// 查询满足条件的数据量
	int getCountByFabricmanagement(Fabricmanagement fabricmanagement);

	// 查询所有的数据
	List<Fabricmanagement> getPageByFabricmanagement(Pagess page);

	// 根据波次精确查询
	List<Fabricmanagement> selFabricmanagementByWave(Fabricmanagement fabric);
}
