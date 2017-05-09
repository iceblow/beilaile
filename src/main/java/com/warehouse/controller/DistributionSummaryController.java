package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.DistributionDealerDelivery;
import com.warehouse.entity.DistributionSummary;
import com.warehouse.service.DistributionSummaryService;
import com.warehouse.util.Page;

@Controller
public class DistributionSummaryController {
	@Resource
	DistributionSummaryService distributionSummaryService;
	
	
	@RequestMapping(value = "getDistributionSummaryInfoBpcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<DistributionSummary> getDistributionSummaryInfoBpcnt(@RequestParam Map<String, Object> param) {
		
		int result = distributionSummaryService.getDistributionSummaryInfoBpcnt(param);
		Object value=param.get("pageNow");
		String pageNow=value.toString();
		if(pageNow==""){
		Page<DistributionSummary> page = new Page<>(result,1);

		return page;
		}
		
		
		Page<DistributionSummary> page = new Page<>(result,Integer.parseInt(pageNow));
		
		return page;
	}

	
	@RequestMapping(value = "findDistributionSummaryInfoCndbp.do", method = RequestMethod.POST)
	@ResponseBody
	public List<DistributionSummary> findDistributionSummaryInfoCndbp(@RequestParam Map<String, Object> param) {
		
		
		
		List<DistributionSummary> list = distributionSummaryService.findDistributionSummaryInfoCndbp(param);
		
		return list;
	}
}
