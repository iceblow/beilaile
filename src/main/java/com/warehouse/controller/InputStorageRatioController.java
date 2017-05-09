package com.warehouse.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.service.InputStorageRatioService;

@RequestMapping("/inputstorageratio")
@Controller
public class InputStorageRatioController {

	@Autowired
	private InputStorageRatioService inputStorageRatioService;
	

	// 得到入库比例
	@RequestMapping("/ratioin.do")
	@ResponseBody
	public Map<String, Object> getRatioIn() {
		//入库比例
		Map<String, Object> map = this.inputStorageRatioService.getRatioIn();
		return map;
	}
	
	// 得到未入库比例
	@RequestMapping("/rationot.do")
	@ResponseBody
	public Map<String, Object> getRatioNot() {
		//入库比例
		Map<String, Object> map = this.inputStorageRatioService.getRatioNot();
		return map;
	}
}
