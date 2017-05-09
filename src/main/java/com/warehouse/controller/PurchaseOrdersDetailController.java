package com.warehouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PurchaseOrdersDetail;
import com.warehouse.service.PurchaseOrdersDetailService;
import com.warehouse.util.PageUtil;
/**
 * 订单详情
 * @author admin
 *
 */
@Controller
@RequestMapping("purchaseOrdersDetail")
public class PurchaseOrdersDetailController {

	@Resource
	private PurchaseOrdersDetailService purchaseOrdersDetailService;

	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page, PurchaseOrdersDetail purchaseOrdersDetail) {
		
		return this.purchaseOrdersDetailService.getAllByPage(page,purchaseOrdersDetail);
	}

}
