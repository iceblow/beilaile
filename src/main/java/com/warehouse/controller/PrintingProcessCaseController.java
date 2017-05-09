package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PrintingProcessCase;
import com.warehouse.service.PrintingProcessCaseService;
import com.warehouse.util.PageUtil;

/**
 * 匹印加工情况
 * @author admin
 *
 */
@Controller
@RequestMapping("printingProcessCase")
public class PrintingProcessCaseController {

	@Resource
	private PrintingProcessCaseService printingProcessCaseService;
	
	/**
	 * 分页查询控制器
	 * @param pageUtil
	 * @param printingProcessCase
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,PrintingProcessCase printingProcessCase){
		return this.printingProcessCaseService.getDataByPage(pageUtil,printingProcessCase);
	}
	
	@RequestMapping("fabricOut")
	@ResponseBody
	public int fabricOut(int id){
		return this.printingProcessCaseService.fabricOut(id);
	}
	
	@RequestMapping("fabricIn")
	@ResponseBody
	public int fabricIn(int id){
		return this.printingProcessCaseService.fabricIn(id);
	}

}
