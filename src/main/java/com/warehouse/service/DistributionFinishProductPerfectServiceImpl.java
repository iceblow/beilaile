package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.DistributionFinishProductPerfectMapper;
import com.warehouse.entity.DistributionFinishProductPerfect;
import com.warehouse.util.PageUtil;

@Service
public class DistributionFinishProductPerfectServiceImpl implements DistributionFinishProductPerfectService {

	@Resource
	private DistributionFinishProductPerfectMapper distributionFinishProductPerfectMapper;

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, DistributionFinishProductPerfect record) {
		pageUtil.setPageSize(10);
		pageUtil.setTotolCount(this.distributionFinishProductPerfectMapper.getCount(record));
		
		List<DistributionFinishProductPerfect> dataList = this.distributionFinishProductPerfectMapper.getDataByPage(
				new DistributionFinishProductPerfect(pageUtil.getReqult()[0], pageUtil.getReqult()[1], record));
		
		Map<String, Object> map=new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		return map;
	}

	/**
	 * 条件修改
	 */
	@Override
	public int dblUpdate(DistributionFinishProductPerfect record) {
		return this.distributionFinishProductPerfectMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<DistributionFinishProductPerfect> exportCurrentDistributionFinishData(
			Map<String, Object> anyVal) {
		List<DistributionFinishProductPerfect> list = this.distributionFinishProductPerfectMapper.exportCurrentDistributionFinishData(anyVal);
		return list;
	}

}
