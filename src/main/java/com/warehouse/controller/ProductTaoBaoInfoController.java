package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductTaoBaoInfo;
import com.warehouse.service.ProductTaoBaoInfoService;
import com.warehouse.util.PageUtil;

/**
 * 淘宝平台库存
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("productTaoBaoInfo")
public class ProductTaoBaoInfoController {

	@Resource
	private ProductTaoBaoInfoService productTaoBaoInfoService;

	/**
	 * 查看淘宝平台库存(分页)
	 * @param page
	 * @param taoBaoInfo
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil page, ProductTaoBaoInfo taoBaoInfo) {
		return this.productTaoBaoInfoService.getDataByPage(page, taoBaoInfo);
	}

}
