package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.SalesSlowMovingStock;
import com.warehouse.service.SalesSlowMovingStockService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("salesSlowMovingStock")
public class SalesSlowMovingStockController {

	@Resource
	private SalesSlowMovingStockService salesSlowMovingStockService;

	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page,SalesSlowMovingStock salesSlowMovingStock) {
		return this.salesSlowMovingStockService.getAllByPage(page, salesSlowMovingStock);
	}

}
