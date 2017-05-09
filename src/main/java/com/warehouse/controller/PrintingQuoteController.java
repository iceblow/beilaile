package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PrintingQuote;
import com.warehouse.service.PrintingQuoteService;
import com.warehouse.util.PageUtil;

/**
 * 印花报价控制器
 * @author admin
 *
 */
@Controller
@RequestMapping("printingQuote")
public class PrintingQuoteController {
	
	@Resource
	private PrintingQuoteService printingQuoteService;
	
	/**
	 * 分页查询控制器
	 * @param pageUtil
	 * @param printingQuote
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,PrintingQuote printingQuote){
		return this.printingQuoteService.getDataByPage(pageUtil,printingQuote);
	}
	
	/**
	 * 双击修改控制器
	 * @param printingQuote 修改的信息
	 * @return
	 */
	@RequestMapping("mydblClick")
	@ResponseBody
	public int mydblClick(PrintingQuote printingQuote){
		return this.printingQuoteService.mydblClick(printingQuote);
	}
	
	/**
	 * 确认报价按钮
	 * @param id
	 * @return
	 */
	@RequestMapping("confirmPiece")
	@ResponseBody
	public int confirmPiece(int id){
		return this.printingQuoteService.confirmPiece(id);
	}
	
}
