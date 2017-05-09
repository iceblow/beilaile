package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricmanagementMapper;
import com.warehouse.entity.Fabricmanagement;
import com.warehouse.util.Pagess;

@Service
public class FabricmanagementServiceImpl implements FabricmanagementService {

	@Resource
	private FabricmanagementMapper fabricmanagementMapper;

	// 获取数量
	@Override
	public int getCountByFabricmanagement(Fabricmanagement fabricmanagement) {
		Integer count = this.fabricmanagementMapper.getCountByFabricmanagement(fabricmanagement);
		return count;
	}

	// 查询所有的数据
	@Override
	public List<Fabricmanagement> getPageByFabricmanagement(Pagess page) {
		List<Fabricmanagement> fabricmanagementList = this.fabricmanagementMapper.getPageByFabricmanagement(page);
		return fabricmanagementList;
	}

	// 根据波次精确查询
	@Override
	public List<Fabricmanagement> selFabricManagementBywave(Fabricmanagement fabric) {
		List<Fabricmanagement> fabricmanagements = fabricmanagementMapper.selFabricmanagementByWave(fabric);
		return fabricmanagements;
	}

}
