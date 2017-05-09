package com.warehouse.controller;

import com.warehouse.entity.AccessoryRation;
import com.warehouse.service.AccessoryRationService;
import com.warehouse.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Controller
public class AccessoryRationController {

	
	private Logger logger = LoggerFactory.getLogger(AccessoryRationController.class);

	@Resource
	public AccessoryRationService accessoryRationService;


	/**
	 * 带条件查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getAccessoryRationByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<AccessoryRation> getAccessoryRationByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = accessoryRationService.getAccessoryRationByPageCount(anyval);
		Page<AccessoryRation> page = new Page<AccessoryRation>(result, 1);
		logger.debug("根据分页条件查询 辅料配置总数");
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionAccessoryRationByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<AccessoryRation> findConditionAccessoryRationByPage(@RequestParam Map<String, Object> anyVal) {

		List<AccessoryRation> list = accessoryRationService.findConditionAccessoryRationByPage(anyVal);
		logger.debug("根据分页条件查询 辅料配置");
		return list;
	}

	@RequestMapping(value = "getAccessoryRationById.do", method = RequestMethod.POST)
	@ResponseBody
	public AccessoryRation getAccessoryRationById(Integer id) {
		AccessoryRation AccessoryRation = accessoryRationService.getAccessoryRationById(id);
		logger.debug("根据id查询 辅料配置");
		return AccessoryRation;
	}

	@RequestMapping(value = "rationPurchasing.do", method = RequestMethod.POST)
	@ResponseBody
	private AccessoryRation rationPurchasing(Integer amId, HttpServletRequest request) {
		AccessoryRation result = this.accessoryRationService.rationPurchasing(amId, request);
		logger.debug("修改 发放状态 为采购中");
		return result;
	}

	@RequestMapping(value = "rationPrepareComplete.do", method = RequestMethod.POST)
	@ResponseBody
	private AccessoryRation rationPrepareComplete(Integer amId, HttpServletRequest request) {
		AccessoryRation result = this.accessoryRationService.rationPrepareComplete(amId, request);
		logger.debug("修改 发放状态 为准备发放");
		return result;
	}

	@RequestMapping(value = "rationAlreadyIssue.do", method = RequestMethod.POST)
	@ResponseBody
	private AccessoryRation rationAlreadyIssue(Integer amId, HttpServletRequest request) {
		AccessoryRation result = this.accessoryRationService.rationAlreadyIssue(amId, request);
		logger.debug("修改 已经领走 为 已发放");
		return result;
	}

	@RequestMapping(value = "rejectRation.do", method = RequestMethod.POST)
	@ResponseBody
	private AccessoryRation rejectRation(Integer amId, HttpServletRequest request) {
		AccessoryRation result = this.accessoryRationService.rejectRation(amId, request);
		logger.debug("修改 发放状态 为 驳回");
		return result;
	}
}
