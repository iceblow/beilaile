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

import com.warehouse.entity.FactoryReturnFabric;
import com.warehouse.service.FactoryReturnFabricService;
import com.warehouse.util.Page;

@Controller
public class FactoryReturnFabricController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public FactoryReturnFabricService factoryReturnFabricService;

	/**
	 * 添加对象
	 * 
	 * @param factoryReturnFabric
	 * @return
	 */
	@RequestMapping(value = "addFactoryReturnFabric.do", method = RequestMethod.POST)
	public String addFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request) {

		factoryReturnFabricService.addFactoryReturnFabric(factoryReturnFabric, request);
		return "redirect:" + "/factoryReturnFabric.html";// 返回添加成功页面
	}

	/**
	 * 修改对象
	 * 
	 * @param factoryReturnFabric
	 * @return
	 */
	@RequestMapping(value = "modifyFactoryReturnFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request) {

		int reslut = factoryReturnFabricService.modifyFactoryReturnFabric(factoryReturnFabric, request);
		logger.info("成功修改了id:" + factoryReturnFabric.getId() + "波茨号为：" + factoryReturnFabric.getWave());
		return reslut;
	}

	/**
	 * 删除对象 根据id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delFactoryReturnFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int delFactoryReturnFabric(Integer id, HttpServletRequest request) {
		int reslut = factoryReturnFabricService.delFactoryReturnFabricById(id, request);
		logger.info("成功删除了id：" + id);
		return reslut;
	}

	/**
	 * 带条件查询分页
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getFactoryReturnFabricByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FactoryReturnFabric> getFactoryReturnFabricByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = factoryReturnFabricService.getFactoryReturnFabricByPageCount(anyval);
		Page<FactoryReturnFabric> page = new Page<FactoryReturnFabric>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionFactoryReturnFabricByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FactoryReturnFabric> findConditionFactoryReturnFabricByPage(@RequestParam Map<String, Object> anyVal) {

		List<FactoryReturnFabric> list = factoryReturnFabricService.findConditionFactoryReturnFabricByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getFactoryReturnFabricById.do", method = RequestMethod.POST)
	@ResponseBody
	public FactoryReturnFabric getFactoryReturnFabricById(Integer id) {
		FactoryReturnFabric factoryReturnFabric = factoryReturnFabricService.getFactoryReturnFabricById(id);
		return factoryReturnFabric;
	}

	/**
	 * 修改对象
	 * 
	 * @param factoryReturnFabric
	 * @return
	 */
	@RequestMapping(value = "updateFactoryReturnFabricByCompleteStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateFactoryReturnFabricByCompleteStatus(FactoryReturnFabric factoryReturnFabric,
			HttpServletRequest request) {

		int reslut = factoryReturnFabricService.updateFactoryReturnFabricByCompleteStatus(factoryReturnFabric, request);
		logger.info("成功修改了id:" + factoryReturnFabric.getId() + "波茨号为：" + factoryReturnFabric.getWave());
		return reslut;
	}

}
