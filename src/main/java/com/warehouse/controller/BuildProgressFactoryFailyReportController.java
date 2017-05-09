package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.service.BuildProgressFactoryFailyReportService;

@Controller
@RequestMapping("BuildProgressFactoryFailyReport")
public class BuildProgressFactoryFailyReportController {

	@Resource
	private BuildProgressFactoryFailyReportService buildProgressFactoryFailyReportService;

	//得到
	@RequestMapping("getFactoryProduction")
	@ResponseBody
	public Map<String, Object> getCount() {
		Map<String, Object> map = this.buildProgressFactoryFailyReportService.getFactoryProduction();
		return map;
	}

}
