package com.warehouse.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.service.PutInStorageReportService;

//入库日报总表
@Controller
@RequestMapping("putInStorageReport")
public class PutInStorageReportController {

	@Autowired
	private PutInStorageReportService putInStorageReportService;

	@RequestMapping("getPutInStorageReport")
	@ResponseBody
	public Map<String, Object> getPutInStorageReport() {
		Map<String, Object> map = this.putInStorageReportService.getDate(30, 30, "put_in_storage_report");
		return map;
	}

}
