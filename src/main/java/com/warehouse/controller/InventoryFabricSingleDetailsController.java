package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.InventoryFabricDetails;
import com.warehouse.entity.InventoryFabricSingleDetails;
import com.warehouse.service.InventoryFabricSingleDetailsService;
import com.warehouse.util.Page;

@Controller
public class InventoryFabricSingleDetailsController {
	@Resource
	private InventoryFabricSingleDetailsService inventoryFabricSingleDetailsService;
	private Logger log = LoggerFactory.getLogger(InputStorageController.class);

	@RequestMapping("addInventoryFabricSingleDetails.do")
	@ResponseBody
	public int getInventoryFabricSingleDetailsByPageCount(InventoryFabricSingleDetails inventoryFabricSingleDetails,
			HttpServletRequest request) {
		int result = inventoryFabricSingleDetailsService.addInventoryFabricSingleDetails(inventoryFabricSingleDetails,
				request);
		return result;
	}

	@RequestMapping("getInventoryFabricSingleDetailsByPageCount.do")
	@ResponseBody
	public Page<InventoryFabricDetails> getInventoryFabricSingleDetailsByPageCount(
			@RequestParam Map<String, Object> anyVal) {
		int reslut = inventoryFabricSingleDetailsService.getInventoryFabricSingleDetailsByPageCount(anyVal);
		Page<InventoryFabricDetails> page = new Page<InventoryFabricDetails>(reslut, 1);
		return page;
	}

	@RequestMapping("findConditionInventoryFabricSingleDetailsByPage.do")
	@ResponseBody
	public List<InventoryFabricSingleDetails> findConditionInventoryFabricSingleDetailsByPage(
			@RequestParam Map<String, Object> anyVal) {
		// 当前页
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		// 每页条数
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		return inventoryFabricSingleDetailsService.findConditionInventoryFabricSingleDetailsByPage(anyVal);
	}
}
