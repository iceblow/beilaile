package com.warehouse.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductionProblem;
import com.warehouse.service.ProductionProblemService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("productionProblem")
public class ProductionProblemController {

	@Resource
	private ProductionProblemService productionProblemService;

	/**
	 * 添加问题
	 * @param productionProblem
	 * @return
	 */
	@RequestMapping("insert")
	@ResponseBody
	public int insert(ProductionProblem productionProblem) {
		return this.productionProblemService.insert(productionProblem);
	}
	
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String,Object> getDataByPage(PageUtil pageUtil,ProductionProblem productionProblem){
		return this.productionProblemService.getDataByPage(pageUtil, productionProblem);
	}

	@RequestMapping("complete")
	@ResponseBody
	public int complete(int id){
		return this.productionProblemService.complete(id);
	}
	
}
