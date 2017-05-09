package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PrintingAndEmbroideredOrder;
import com.warehouse.service.PrintingAndEmbroideredOrderService;
import com.warehouse.service.PrintingQuoteService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("printingAndEmbroideredOrder")
public class PrintingAndEmbroideredOrderController {

	@Resource
	private PrintingAndEmbroideredOrderService printingAndEmbroideredOrderService;
	
	@Resource
	private PrintingQuoteService printingQuoteService;

	/**
	 * 分页查询控制器
	 * @param pageUtil
	 * @param printingAndEmbroideredOrder
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,
			PrintingAndEmbroideredOrder printingAndEmbroideredOrder) {
		return this.printingAndEmbroideredOrderService.getDataByPage(pageUtil,printingAndEmbroideredOrder);
	}
	
	/**
	 * 理单完成控制器
	 * @param printingAndEmbroideredOrder
	 * @return
	 */
	@RequestMapping("completeOrder")
	@ResponseBody
	public int completeOrder(PrintingAndEmbroideredOrder printingAndEmbroideredOrder){
		return this.printingAndEmbroideredOrderService.completeOrder(printingAndEmbroideredOrder);
	}

	/**
	 * 重新理单控制器
	 * @param wave
	 * @return
	 */
	@RequestMapping("orderAgain")
	@ResponseBody
	public String orderAgain(String wave){
		//修改理单表的基本信息
		printingAndEmbroideredOrderService.updateDataByWave(wave);
		//删除印花报价表里面的数据
		printingQuoteService.delDataByWave(wave);
		return "重新理单成功" ;
	}
}
