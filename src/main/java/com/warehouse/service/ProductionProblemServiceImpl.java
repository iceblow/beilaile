package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProductionProblemMapper;
import com.warehouse.entity.ProductionProblem;
import com.warehouse.util.PageUtil;

@Service
public class ProductionProblemServiceImpl implements ProductionProblemService {

	@Resource
	private ProductionProblemMapper mapper;

	@Override
	public int insert(ProductionProblem productionProblem) {
		return this.mapper.insert(productionProblem);
	}

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, ProductionProblem productionProblem) {

		pageUtil.setPageSize(15);
		pageUtil.setTotolCount(this.mapper.getCountByPage(productionProblem));
		List<ProductionProblem> dataList = this.mapper.getDataByPage(
				new ProductionProblem(pageUtil.getReqult()[0], pageUtil.getReqult()[1], productionProblem));
		Map<String, Object> map = new HashMap<>();
		map.put("dataList", dataList);
		map.put("pageUtil", pageUtil);
		return map;
	}

	@Override
	public int update(ProductionProblem productionProblem) {
		return 0;
	}

	@Override
	public int complete(int id) {
		return this.mapper.complete(id);
	}

}
