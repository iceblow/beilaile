package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductInfo;
import com.warehouse.entity.SalesReportOfWdt;
import com.warehouse.service.ProductInfoService;
import com.warehouse.service.SalesReportOfWdtService;
import com.warehouse.util.PageUtil;

/**
 * 销售详情记录表
 * @author admin
 *
 */
@Controller
@RequestMapping("salesReportOfWdt")
public class SalesReportOfWdtController {

	@Resource
	private SalesReportOfWdtService salesReportOfWdtService;
	
	@Resource
	private ProductInfoService productInfoService;
	
	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil pageUtil,SalesReportOfWdt salesReportOfWdt){
		return this.salesReportOfWdtService.getAllByPage(pageUtil,salesReportOfWdt);
	}
	
	@RequestMapping("getOneByCodes")
	@ResponseBody
	public ProductInfo getOneByCodes(String codes){
		return this.productInfoService.getOneByCodes(codes);
	}

}
