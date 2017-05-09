package com.warehouse.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.service.WeeklyServices;

//成品七日均值日报表
@Controller
@RequestMapping("weeklyReport")
public class WeeklyReportController {

	@Autowired
	private WeeklyServices weeklyService;

	@RequestMapping("myGetWeekly")
	@ResponseBody
	public Map<String, Object> myGetWeekly() {
		Map<String, Object> map = this.weeklyService.getDate(30, 30, "inputstorage_weekly_average_report");
		return map;
	}

}
