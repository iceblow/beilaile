package com.warehouse.controller;

import java.io.FileNotFoundException;
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

import com.warehouse.entity.AccessoryPrepared;
import com.warehouse.service.AccessoryPreparedService;
import com.warehouse.util.Page;

@Controller
public class AccessoryPreparedController {

	
	private Logger logger = LoggerFactory.getLogger(AccessoryPreparedController.class);

	@Resource
	public AccessoryPreparedService accessoryPreparedService;

	/**
	 * 添加 辅料
	 * 
	 * @param accessoryPrepared
	 * @return
	 */
	@RequestMapping(value = "addAccessoryPrepared.do", method = RequestMethod.POST)
	public String addAccessoryPrepared(AccessoryPrepared accessoryPrepared) {

		accessoryPreparedService.addAccessoryPrepared(accessoryPrepared);
		return "redirect:" + "/accessoryPrepared.html";// 返回添加成功页面
	}
	
	/**
	 * 修改 对象
	 * 
	 * @param accessoryPrepared
	 * @return
	 */
	@RequestMapping(value = "modifyAccessoryPrepared.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyAccessoryPrepared(AccessoryPrepared accessoryPrepared) {

		int reslut = accessoryPreparedService.modifyAccessoryPrepared(accessoryPrepared);
		logger.info("成功的修改了id：" + accessoryPrepared.getId() + "波茨号：" + accessoryPrepared.getWave());
		return reslut;
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delAccessoryPrepared.do", method = RequestMethod.POST)
	@ResponseBody
	public int delAccessoryPrepared(Integer id) {
		int reslut = accessoryPreparedService.delAccessoryPrepared(id);
		logger.info("成功的修改了id：" + id);
		return reslut;
	}

	/**
	 * 带添加查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getAccessoryPreparedByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<AccessoryPrepared> getAccessoryPreparedByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = accessoryPreparedService.getAccessoryPreparedByPageCount(anyval);
		Page<AccessoryPrepared> page = new Page<AccessoryPrepared>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionAccessoryPreparedByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<AccessoryPrepared> findConditionAccessoryPreparedByPage(@RequestParam Map<String, Object> anyVal) {

		List<AccessoryPrepared> list = accessoryPreparedService.findConditionAccessoryPreparedByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getAccessoryPreparedById.do", method = RequestMethod.POST)
	@ResponseBody
	public AccessoryPrepared getFabricSourcingById(Integer id) {
		AccessoryPrepared accessoryPrepared = accessoryPreparedService.getAccessoryPreparedById(id);
		return accessoryPrepared;
	}
	
}
