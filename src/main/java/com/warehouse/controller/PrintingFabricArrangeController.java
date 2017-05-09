package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PrintingFabricArrange;
import com.warehouse.service.PrintingFabricArrangeService;
import com.warehouse.util.PageUtil;

/**
 * 匹印面料安排
 * @author admin
 *
 */
@Controller
@RequestMapping("printingFabricArrange")
public class PrintingFabricArrangeController {

	@Resource
	private PrintingFabricArrangeService service;
	
	/**
	 * 分页查询
	 * @param pageUtil
	 * @param ready
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingFabricArrange ready) {
		return this.service.getDataByPage(pageUtil, ready);
	}
	
	/**
	 * 点击完成时间
	 * @param id
	 * @return
	 */
	@RequestMapping("completeReady")
	@ResponseBody
	public int completeReady(int id){
		return this.service.completeReady(id);
	}
	
	/**
	 * 双击修改
	 * @param ready
	 * @return
	 */
	@RequestMapping("dbUpdateData")
	@ResponseBody
	public int dbUpdateData(PrintingFabricArrange ready){
		return this.service.dbUpdateData(ready);
	}
	
	/**
	 * 导出excle
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("toExcle")
	@ResponseBody
	public int toExcle(HttpServletRequest request,HttpServletResponse response,String ids){
		this.service.toExcle(request,response,ids);
		return 1;
	}
	
	/**
	 * 面料发放
	 * @param id
	 * @return
	 */
	@RequestMapping("completeSuccess")
	@ResponseBody
	public int completeSuccess(int id){
		return this.service.completeSuccess(id);
	}

}
