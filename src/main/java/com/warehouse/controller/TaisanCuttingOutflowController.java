package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.TaisanCuttingOutflow;
import com.warehouse.service.TaisanCuttingOutflowService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("taisanCuttingOutflow")
public class TaisanCuttingOutflowController {

	@Resource
	private TaisanCuttingOutflowService taisanCuttingOutflowService;

	/**
	 * 分页查询控制器
	 * @param pageUtil
	 * @param taisanCuttingOutflow
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanCuttingOutflow taisanCuttingOutflow) {
		return this.taisanCuttingOutflowService.getDataByPage(pageUtil,taisanCuttingOutflow);
	}
	
	/**
	 * 裁片就绪
	 * @param wave
	 * @return
	 */
	@RequestMapping("cuttingPieceReady")
	@ResponseBody
	public int cuttingPieceReady(String wave){
		return this.taisanCuttingOutflowService.cuttingPieceReady(wave);
	}
	
	/**
	 * 裁片外发
	 * @param wave
	 * @return
	 */
	@RequestMapping("cuttingPieceOut")
	@ResponseBody
	public int cuttingPieceOut(String wave){
		return this.taisanCuttingOutflowService.cuttingPieceOut(wave);
	}
	
	/**
	 * 裁片外发
	 * @param wave
	 * @return
	 */
	@RequestMapping("updateRowOfSingleAgainByWave")
	@ResponseBody
	public int updateRowOfSingleAgainByWave(String wave){
		return this.taisanCuttingOutflowService.updateRowOfSingleAgainByWave(wave);
	}

}
