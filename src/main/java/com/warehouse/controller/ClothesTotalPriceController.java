package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ClothesTotalPrice;
import com.warehouse.entity.FabricTotalPrice;
import com.warehouse.service.ClothesTotalPriceService;
import com.warehouse.service.FabricTotalPriceService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("clothesTotalPrice")
public class ClothesTotalPriceController {

	@Resource
	private ClothesTotalPriceService clothesTotalPriceService;

	// 分页查询
	@RequestMapping("getClothesPage.do")
	@ResponseBody
	public Map<String, Object> selectPageFabric(PageUtil page, ClothesTotalPrice clothesTotalPrice)
			throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(10);// 每页显示数据量
		page.setTotolCount(clothesTotalPriceService.selectClothes1(clothesTotalPrice));// 总数据条数
		List<ClothesTotalPrice> myList = this.clothesTotalPriceService.getClothesPage(new ClothesTotalPrice(page.getReqult()[0], page.getReqult()[1], clothesTotalPrice));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}
}
