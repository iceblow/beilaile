package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.Fabricmanagement;
import com.warehouse.util.Pagess;

public interface FabricmanagementService {

	// 分页查询满足条件的数量
	int getCountByFabricmanagement(Fabricmanagement fabricmanagement);

	// 分页查询满足条件的数据
	List<Fabricmanagement> getPageByFabricmanagement(Pagess page);

	// 根据波次精确查询
	List<Fabricmanagement> selFabricManagementBywave(Fabricmanagement fabric);
}
