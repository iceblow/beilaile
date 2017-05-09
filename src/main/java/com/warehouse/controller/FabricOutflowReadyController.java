package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricOutflowReady;
import com.warehouse.service.FabricOutflowReadyService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("fabricOutflowReady")
public class FabricOutflowReadyController {

	@Resource
	private FabricOutflowReadyService service;

	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, FabricOutflowReady ready) {
		return this.service.getDataByPage(pageUtil, ready);
	}
	
	@RequestMapping("completeReady")
	@ResponseBody
	public int completeReady(int id){
		return this.service.completeReady(id);
	}
	
	@RequestMapping("dbUpdateData")
	@ResponseBody
	public int dbUpdateData(FabricOutflowReady ready){
		return this.service.dbUpdateData(ready);
	}
	
	@RequestMapping("toExcle")
	@ResponseBody
	public int toExcle(HttpServletRequest request,HttpServletResponse response,String ids){
		this.service.toExcle(request,response,ids);
		return 1;
	}
	
	@RequestMapping("completeSuccess")
	@ResponseBody
	public int completeSuccess(int id){
		return this.service.completeSuccess(id);
	}

}
