package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductInfo;
import com.warehouse.service.ProductOrderService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("productToBack")
public class ProductToBackController {

	private Logger log = LoggerFactory.getLogger(ApparelDevelopmentManagementCollectController.class);
	@Resource
	private ProductOrderService orderService;

	/***
	 * 查看所有的商品信息
	 * 
	 * @param productInfo
	 * @param page
	 * @return
	 */
	@RequestMapping("selProductToBack")
	@ResponseBody
	public Map<String, Object> selProductBack(ProductInfo productInfo, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示数量
		page.setTotolCount(this.orderService.getCountByPage(productInfo));// 获取总数据数量
		List<ProductInfo> ar = this.orderService
				.getDataByPage(new ProductInfo(page.getReqult()[0], page.getReqult()[1], productInfo));
		map.put("dataList", ar);
		map.put("pageUtil", page);
		log.info("查询所有的商品信息！");
		return map;
	}

	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getById")
	@ResponseBody
	public ProductInfo getById(int id) {
		ProductInfo info = orderService.getOne(id);
		return info;
	}

	
}
