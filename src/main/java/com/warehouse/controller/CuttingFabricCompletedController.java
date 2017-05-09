package com.warehouse.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.CuttingFabricCompleted;
import com.warehouse.service.CuttingFabricCompletedService;
import com.warehouse.util.PageUtil;

/**
 * 面料到齐控制器
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("cuttingFabricCompleted")
public class CuttingFabricCompletedController {

	@Resource
	private CuttingFabricCompletedService cuttingFabricCompletedService;
	
	/**
	 * 分页查询控制器
	 * @param pageUtil
	 * @param cuttingFabricCompleted
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,CuttingFabricCompleted cuttingFabricCompleted){
		System.out.println(cuttingFabricCompleted.getExistPaperPattern());
		return cuttingFabricCompletedService.getDataByPage(pageUtil,cuttingFabricCompleted);
	}
	
	/**
	 * 双击修改控制器
	 * @param cuttingFabricCompleted
	 * @return
	 */
	@RequestMapping("updateDateByWave")
	@ResponseBody
	public int updateDateByWave(CuttingFabricCompleted cuttingFabricCompleted){
		return this.cuttingFabricCompletedService.updateDateByWave(cuttingFabricCompleted);
	}
	
	/**
	 * 准备按钮点击事件
	 * @param wave
	 * @return
	 */
	@RequestMapping("remarkClick")
	@ResponseBody
	public int remarkClickController(String wave){
		
		return this.cuttingFabricCompletedService.remarkUpdate(wave);
	}
	
	/**
	 * 安排裁剪按钮点击事件
	 * @return
	 */
	@RequestMapping("planCut")
	@ResponseBody
	public int planCut(CuttingFabricCompleted cuttingFabricCompleted){
		
		cuttingFabricCompleted.setFabricIsCuttingStatus("已安排裁剪");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		cuttingFabricCompleted.setFabricCuttingTime(df.format(new Date()));
		return this.cuttingFabricCompletedService.planCut(cuttingFabricCompleted);
	}
}
