package com.warehouse.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FactoryReceiveFabric;
import com.warehouse.service.FactoryReceiveFabricService;
import com.warehouse.util.Page;

@Controller
public class FactoryReceiveFabricController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public FactoryReceiveFabricService factoryReceiveFabricService;

	/**
	 * 添加对象
	 * 
	 * @param factoryReceiveFabric
	 * @return
	 */
	@RequestMapping(value = "addFactoryReceiveFabric.do", method = RequestMethod.POST)
	public String addFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric, HttpServletRequest request) {

		factoryReceiveFabricService.addFactoryReceiveFabric(factoryReceiveFabric, request);
		return "redirect:" + "/factoryReceiveFabric.html";// 返回添加成功页面
	}

	/**
	 * 修改对象
	 * 
	 * @param factoryReceiveFabric
	 * @return
	 */

	@RequestMapping(value = "modifyFactoryReceiveFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric, HttpServletRequest request) {

		int reslut = factoryReceiveFabricService.modifyFactoryReceiveFabric(factoryReceiveFabric, request);
		logger.info("成功修改了id:" + factoryReceiveFabric.getId() + "波茨号：" + factoryReceiveFabric.getWave());
		return reslut;
	}

	/**
	 * 删除对象
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delFactoryReceiveFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int delFactoryReceiveFabric(Integer id, HttpServletRequest request) {
		int reslut = factoryReceiveFabricService.delFactoryReceiveFabricById(id, request);
		return reslut;
	}

	@RequestMapping(value = "getFactoryReceiveFabricByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FactoryReceiveFabric> getFactoryReceiveFabricByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = factoryReceiveFabricService.getFactoryReceiveFabricByPageCount(anyval);
		Page<FactoryReceiveFabric> page = new Page<FactoryReceiveFabric>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionFactoryReceiveFabricByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FactoryReceiveFabric> findConditionFactoryReceiveFabricByPage(
			@RequestParam Map<String, Object> anyVal) {

		List<FactoryReceiveFabric> list = factoryReceiveFabricService.findConditionFactoryReceiveFabricByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getFactoryReceiveFabricById.do", method = RequestMethod.POST)
	@ResponseBody
	public FactoryReceiveFabric getFabricSourcingById(Integer id) {
		FactoryReceiveFabric factoryReceiveFabric = factoryReceiveFabricService.getFactoryReceiveFabricById(id);
		return factoryReceiveFabric;
	}

	@RequestMapping(value = "updateFactoryReceiveFabricByCompleteStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateFactoryReceiveFabricByCompleteStatus(FactoryReceiveFabric factoryReceiveFabric,
			HttpServletRequest request) {
		int rslut = factoryReceiveFabricService.updateFactoryReceiveFabricByCompleteStatus(factoryReceiveFabric,
				request);
		return rslut;
	}

}
