package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.SampleArrange;
import com.warehouse.service.SampleArrangeService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("sampleArrange")
public class SampleArrangeController {

	@Resource
	private SampleArrangeService sampleArrangeService;
	
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,SampleArrange sampleArrange){
		return this.sampleArrangeService.getDataByPage(pageUtil,sampleArrange);
	}
	
	@RequestMapping("dbUpdate")
	@ResponseBody
	public int dbUpdate(SampleArrange sampleArrange){
		return this.sampleArrangeService.dbUpdate(sampleArrange);
	}
	
	@RequestMapping("out")
	@ResponseBody
	public int out(String wave){
		return this.sampleArrangeService.out(wave);
	}
	
	@RequestMapping("addForModel")
	@ResponseBody
	public int addForModel(SampleArrange sampleArrange){
		return this.sampleArrangeService.addForModel(sampleArrange);
	}
}
