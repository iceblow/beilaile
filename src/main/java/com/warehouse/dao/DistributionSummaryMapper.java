package com.warehouse.dao;

import java.util.List;
import java.util.Map;


import com.warehouse.entity.DistributionSummary;

public interface DistributionSummaryMapper {
	int getDistributionSummaryInfoBpcnt(Map<String, Object> param);

	List<DistributionSummary> findDistributionSummaryInfoCndbp(Map<String, Object> param);


}