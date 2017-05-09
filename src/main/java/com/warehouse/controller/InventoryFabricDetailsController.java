package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.InventoryFabricDetails;
import com.warehouse.service.FabricLibraryService;
import com.warehouse.service.InventoryFabricDetailsService;
import com.warehouse.util.Page;

/**
 * Created by Beilaile on 2017/4/3.
 */
@Controller
public class InventoryFabricDetailsController {
	@Resource
	public InventoryFabricDetailsService inventoryFabricDetailsService;
	@Resource
	public FabricLibraryService fabricLibraryService;

	@RequestMapping("addInventoryFabricDetails.do")
	@ResponseBody
	public Integer addInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails,
			HttpServletRequest request) {
		FabricLibrary fabricLibrary = fabricLibraryService
				.findFabricLibraryByFabricLibraryCode(inventoryFabricDetails.getFabricCode());
		inventoryFabricDetails.setFabricName(fabricLibrary.getFabricName());
		inventoryFabricDetails.setSupplierName(fabricLibrary.getSupplierName());
		inventoryFabricDetails.setFabricColor(fabricLibrary.getColorName());
		return inventoryFabricDetailsService.addInventoryFabricDetails(inventoryFabricDetails, request);
	}

	@RequestMapping("modifyInventoryFabricDetails.do")
	@ResponseBody
	public Integer modifyInventoryFabricDetails(InventoryFabricDetails InventoryFabricDetails,
			HttpServletRequest request) {
		return inventoryFabricDetailsService.modifyInventoryFabricDetails(InventoryFabricDetails, request);
	}

	@RequestMapping("delInventoryFabricDetails.do")
	@ResponseBody
	public Integer delInventoryFabricDetails(InventoryFabricDetails InventoryFabricDetails,
			HttpServletRequest request) {
		return inventoryFabricDetailsService.delInventoryFabricDetails(InventoryFabricDetails, request);
	}

	@RequestMapping("getInventoryFabricDetailsByPageCount.do")
	@ResponseBody
	public Page<InventoryFabricDetails> getFabricLibraryByPageCount(@RequestParam Map<String, Object> anyVal) {
		int reslut = inventoryFabricDetailsService.getInventoryFabricDetailsByPageCount(anyVal);
		Page<InventoryFabricDetails> page = new Page<InventoryFabricDetails>(reslut, 1);
		return page;
	}

	@RequestMapping("findConditionInventoryFabricDetailsByPage.do")
	@ResponseBody
	public List<InventoryFabricDetails> findConditionInventoryFabricDetailsByPage(
			@RequestParam Map<String, Object> anyVal) {
		// 当前页
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		// 每页条数
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		return inventoryFabricDetailsService.findConditionInventoryFabricDetailsByPage(anyVal);
	}

	@RequestMapping("findInventoryFabricDetailsById.do")
	@ResponseBody
	public InventoryFabricDetails findInventoryFabricDetailsById(Integer id) {
		return inventoryFabricDetailsService.findInventoryFabricDetailsById(id);
	}

	/**
	 * 根据面料编号查重量/个数
	 * @param fabricCode
	 * @return
	 */
	@RequestMapping("findInventoryFabricDetailsByFabricCode.do")
	@ResponseBody
	public InventoryFabricDetails findInventoryFabricDetailsByFabricCode(String fabricCode) {
		return inventoryFabricDetailsService.findInventoryFabricDetailsByFabricCode(fabricCode);
	}
}
