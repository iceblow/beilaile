package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.TaisanAccesOutflow;
import com.warehouse.service.TaisanAccesOutflowService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("taisanAccesOutflow")
public class TaisanAccesOutflowController {

	@Resource
	private TaisanAccesOutflowService taisanAccesOutflowService;

	/**
	 * 分页查询控制器
	 * @param pageUtil(分页信息)
	 * @param taisanAccesOutflow(条件信息)
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanAccesOutflow taisanAccesOutflow) {
		return this.taisanAccesOutflowService.getDataByPage(pageUtil,taisanAccesOutflow);
	}
	
	/**
	 * 辅料准备就绪控制器
	 * @param wave(波次号)
	 * @return
	 */
	@RequestMapping("assistMaterialReady")
	@ResponseBody
	public int assistMaterialReady(String wave){
		return this.taisanAccesOutflowService.assistMaterialReady(wave);
	}
	
	/**
	 * 辅料外发控制器
	 * @param wave
	 * @return
	 */
	@RequestMapping("assistOut")
	@ResponseBody
	public int assistOut(String wave){
		return this.taisanAccesOutflowService.assistOut(wave);
	}

	
	
	/**
	 * 重新安排订单
	 * @param wave
	 * @return
	 */
	@RequestMapping("rowOfSingleAgain")
	@ResponseBody
	public int rowOfSingleAgain(String wave){
		return this.taisanAccesOutflowService.rowOfSingleAgain(wave);
	}

	
	
	
}
