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

import com.warehouse.entity.FabricStorage;
import com.warehouse.service.FabricStorageService;
import com.warehouse.util.Page;

@Controller
public class FabricStorageController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public FabricStorageService fabricStorageService;

	/**
	 * 添加 对象
	 * 
	 * @param fabricStorage
	 * @return
	 */
	@RequestMapping(value = "addFabricStorage.do", method = RequestMethod.POST)
	public String addFabricStorage(FabricStorage fabricStorage, HttpServletRequest request) {

		fabricStorageService.addFabricStorage(fabricStorage, request);
		return "redirect:" + "/fabricStorage.html";// 返回添加成功页面
	}

	/**
	 * 修改 对象
	 * 
	 * @param fabricStorage
	 * @return
	 */
	@RequestMapping(value = "modifyFabricStorage.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFabricStorage(FabricStorage fabricStorage, HttpServletRequest request) {

		int reslut = fabricStorageService.modifyFabricStorage(fabricStorage, request);
		logger.info("成功的修改了id：" + fabricStorage.getId() + "波茨号：" + fabricStorage.getWave());
		return reslut;
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delFabricStorage.do", method = RequestMethod.POST)
	@ResponseBody
	public int delFabricStorage(Integer id, HttpServletRequest request) {
		int reslut = fabricStorageService.delFabricStorage(id, request);
		logger.info("成功的修改了id：" + id);
		return reslut;
	}

	/**
	 * 带添加查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getFabricStorageByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FabricStorage> getFabricStorageByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = fabricStorageService.getFabricStorageByPageCount(anyval);
		Page<FabricStorage> page = new Page<FabricStorage>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionFabricStorageByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricStorage> findConditionFabricStorageByPage(@RequestParam Map<String, Object> anyVal) {

		List<FabricStorage> list = fabricStorageService.findConditionFabricStorageByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getFabricStorageById.do", method = RequestMethod.POST)
	@ResponseBody
	public FabricStorage getFabricStorageById(Integer id) {
		FabricStorage fabricStorage = fabricStorageService.getFabricStorageById(id);
		return fabricStorage;
	}

	@RequestMapping(value = "updateFabricStorageByTotal.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateFabricStorageByTotal(FabricStorage fabricStorage, HttpServletRequest request) {
		int result = fabricStorageService.updateFabricStorageByTotal(fabricStorage, request);
		return result;
	}

	@RequestMapping(value = "updateFabricStorageByCompleteStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateFabricStorageByCompleteStatus(FabricStorage fabricStorage, HttpServletRequest request) {
		int result = fabricStorageService.updateFabricStorageByCompleteStatus(fabricStorage, request);
		return result;
	}

}
