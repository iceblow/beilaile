package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricReturnBack;
import com.warehouse.service.FabricReturnBackService;
import com.warehouse.util.Page;

@Controller
public class FabricReturnBackController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);
	@Resource
	public FabricReturnBackService fabricReturnBackService;

	/**
	 * 添加一个对象
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "addFabricReturnBack.do", method =RequestMethod.POST)
	@ResponseBody
	public int addFabricReturnBack(FabricReturnBack fabricReturnBack) {
		return fabricReturnBackService.addFabricReturnBack(fabricReturnBack); 
	}

	/**
	 * 修改一个对象
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "modifyFabricReturnBack.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFabricOutflow(FabricReturnBack fabricReturnBack) {
		int result = fabricReturnBackService.modifyFabricOutflow(fabricReturnBack);
		logger.info("成功修改了id：" + fabricReturnBack.getId() + "波茨号为：" + fabricReturnBack.getWave());
		return result;
	}

	/**
	 * 修改一个对象
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "updateColourById.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateColourById(FabricReturnBack fabricReturnBack) {
		int result = fabricReturnBackService.updateColourById(fabricReturnBack);
		return result;
	}

	
	/**
	 * 删除一个数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delFabricReturnBack.do", method = RequestMethod.POST)
	@ResponseBody
	public int delFabricOutflow(Integer id) {
		int result = fabricReturnBackService.delFabricOutflow(id);
		logger.info("成功删除了id：" + id);
		return result;
	}

	/**
	 * 带条件查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getFabricReturnBackByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FabricReturnBack> getFabricOutflowByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = fabricReturnBackService.getFabricOutflowByPageCount(anyval);
		Page<FabricReturnBack> page = new Page<FabricReturnBack>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return @throws
	 */
	@RequestMapping(value = "findConditionFabricReturnBackByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricReturnBack> findConditionFabricOutflowByPage(@RequestParam Map<String, Object> anyVal) {
		List<FabricReturnBack> list = fabricReturnBackService.findConditionFabricOutflowByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getFabricReturnBackById.do", method = RequestMethod.POST)
	@ResponseBody
	public FabricReturnBack getFabricOutflowById(Integer id) {
		FabricReturnBack fabricReturnBack = fabricReturnBackService.getFabricOutflowById(id);
		return fabricReturnBack;
	}

}
