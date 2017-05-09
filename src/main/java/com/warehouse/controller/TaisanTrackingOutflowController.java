package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.TaisanCuttingOutflow;
import com.warehouse.entity.TaisanTrackingOutflow;
import com.warehouse.service.TaisanTrackingOutflowService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("taisanTrackingOutflow")
public class TaisanTrackingOutflowController {

	@Resource
	private TaisanTrackingOutflowService taisanTrackingOutflowService;

	/**
	 * 分页(模糊)查询控制器
	 * 
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanTrackingOutflow taisanTrackingOutflow) {
		return this.taisanTrackingOutflowService.getDataByPage(pageUtil, taisanTrackingOutflow);
	}
	
	/**
	 * 安排面辅料控制器 
	 * @return
	 */
	@RequestMapping("arrangeFabricAndAssistMaterial")
	@ResponseBody
	public int arrangeFabricAndAssistMaterial(String wave){
		return this.taisanTrackingOutflowService.arrangeFabricAndAssistMaterial(wave);
	}
	
	/**
	 * 通知工厂控制器 
	 * @return
	 */
	@RequestMapping("informFactory")
	@ResponseBody
	public int informFactory(String wave){
		return this.taisanTrackingOutflowService.informFactory(wave);
	}
	
	/**
	 * 根绝波次查询单条信息控制器
	 */
	@RequestMapping("getOneByWave")
	@ResponseBody
	public TaisanTrackingOutflow getOneByWave(String wave){
		return this.taisanTrackingOutflowService.getOneByWave(wave);
	}
	
	/**
	 * 修改车缝工厂控制器
	 * @param taisanCuttingOutflow
	 * @return
	 */
	@RequestMapping("updateFactory")
	@ResponseBody
	public int updateFactory(TaisanTrackingOutflow taisanTrackingOutflow){
		return this.taisanTrackingOutflowService.updateFactory(taisanTrackingOutflow);
	}
	
	/**
	 * 申请重新排单
	 * @param id
	 * @return
	 */
	@RequestMapping("updateRowOfSingleAgain")
	@ResponseBody
	public int updateRowOfSingleAgain(String wave){
		return this.taisanTrackingOutflowService.updateRowOfSingleAgain(wave);
	}

}
