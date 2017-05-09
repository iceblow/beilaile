package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.service.BuildProgressWeeklyReportService;


//跟单外发的
@Controller
@RequestMapping("buildProgressWeeklyReport")
public class BuildProgressWeeklyReportController {

	@Resource
	private BuildProgressWeeklyReportService buildProgressWeeklyReportService;

	// 得到款式数
	@RequestMapping("getCount")
	@ResponseBody
	public Map<String, Object> getCount() {
		Map<String, Object> map = this.buildProgressWeeklyReportService.getCount();
		return map;
	}

	// 得到生产数
	@RequestMapping("getSum")
	@ResponseBody
	public Map<String, Object> getSum() {
		Map<String, Object> map = this.buildProgressWeeklyReportService.getSum();
		return map;
	}

}
