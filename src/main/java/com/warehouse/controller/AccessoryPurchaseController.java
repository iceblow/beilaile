package com.warehouse.controller;

import com.warehouse.entity.AccessoryPurchase;
import com.warehouse.service.AccessoryPurchaseService;
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
public class AccessoryPurchaseController {

	
	private Logger logger = LoggerFactory.getLogger(AccessoryPurchaseController.class);

	@Resource
	public AccessoryPurchaseService accessoryPurchaseService;


	/**
	 * 带条件查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getAccessoryPurchaseByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<AccessoryPurchase> getAccessoryPurchaseByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = accessoryPurchaseService.getAccessoryPurchaseByPageCount(anyval);
		Page<AccessoryPurchase> page = new Page<AccessoryPurchase>(result, 1);
		logger.debug("查询配置发放（采购）总条数");
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionAccessoryPurchaseByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<AccessoryPurchase> findConditionAccessoryPurchaseByPage(@RequestParam Map<String, Object> anyVal) {

		List<AccessoryPurchase> list = accessoryPurchaseService.findConditionAccessoryPurchaseByPage(anyVal);
		logger.debug("分页条件查询 辅料发放（采购） ");
		return list;
	}

	@RequestMapping(value = "getAccessoryPurchaseById.do", method = RequestMethod.POST)
	@ResponseBody
	public AccessoryPurchase getAccessoryPurchaseById(Integer id) {
		AccessoryPurchase AccessoryPurchase = accessoryPurchaseService.getAccessoryPurchaseById(id);
		logger.debug("根据id查询辅料");
		return AccessoryPurchase;
	}

	@RequestMapping(value = "alreadyIssuePurchase.do", method = RequestMethod.POST)
	@ResponseBody
	private AccessoryPurchase alreadyIssuePurchase(Integer amId, HttpServletRequest request) {
		AccessoryPurchase result = this.accessoryPurchaseService.alreadyIssuePurchase(amId, request);
		logger.debug("修改 发放状态 为准备就绪");
		return result;
	}

	@RequestMapping(value = "rejectPurchase.do", method = RequestMethod.POST)
	@ResponseBody
	private AccessoryPurchase rejectPurchase(Integer amId, HttpServletRequest request) {
		AccessoryPurchase result = this.accessoryPurchaseService.rejectPurchase(amId, request);
		logger.debug("修改 发放状态 为驳回");
		return result;
	}
}
