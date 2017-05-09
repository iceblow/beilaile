package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.DistributionSummaryMapper;

import com.warehouse.entity.DistributionSummary;
@Service
public class DistributionSummaryServiceImpl implements DistributionSummaryService {
	@Resource
	DistributionSummaryMapper distributionSummaryMapper;
	
	@Override
	public int getDistributionSummaryInfoBpcnt(Map<String, Object> param) {
		
		return distributionSummaryMapper.getDistributionSummaryInfoBpcnt(param);
	}

	@Override
	public List<DistributionSummary> findDistributionSummaryInfoCndbp(Map<String, Object> param) {
		int pageNow = Integer.parseInt(param.get("pageNow").toString());
		int pageSize = Integer.parseInt(param.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		param.put("pageNow", pageNow);
		param.put("pageSize", pageSize);
		return distributionSummaryMapper.findDistributionSummaryInfoCndbp(param);
	}

}
