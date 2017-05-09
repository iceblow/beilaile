package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PrintingCuttingCompleted;
import com.warehouse.service.PrintingCuttingCompletedService;
import com.warehouse.util.PageUtil;

/**
 * 裁剪完成控制器
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("printingCuttingCompleted")
public class PrintingCuttingCompletedController {

	@Resource
	private PrintingCuttingCompletedService printingCuttingCompletedService;

	/**
	 * 分页/模糊 查询控制器
	 * 
	 * @param pageUtil
	 *            分页信息
	 * @param printingCuttingCompleted
	 *            查询条件
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingCuttingCompleted printingCuttingCompleted) {
		
		System.err.println(printingCuttingCompleted.toString()+"-------------------------------------");
		
		return printingCuttingCompletedService.getDataByPage(pageUtil, printingCuttingCompleted);
	}

	/**
	 * 双击修改控制器
	 * 
	 * @param printingCuttingCompleted
	 * @return
	 */
	@RequestMapping("updateDataByWave")
	@ResponseBody
	public int updateDataByWave(PrintingCuttingCompleted printingCuttingCompleted) {
		
		return this.printingCuttingCompletedService.updateDataByWave(printingCuttingCompleted);
	}
}
