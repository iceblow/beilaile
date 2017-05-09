package com.warehouse.controller;

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

import com.warehouse.entity.DistributionCompletedOrder;
import com.warehouse.service.DistributionCompletedOrderService;
import com.warehouse.util.Page;

@Controller
public class DistributionCompletedOrderController {
	private Logger logger = LoggerFactory.getLogger(BoardRoomController.class);

	@Resource
	private DistributionCompletedOrderService distributionCompletedOrderService;

	@RequestMapping(value = "addDistributionCompletedOrder.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer addDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder,
			HttpServletRequest request) {
		Integer result = distributionCompletedOrderService.addDistributionCompletedOrder(distributionCompletedOrder);
		logger.info("成功添加了" + distributionCompletedOrder.getWave());
		return result;
	}

	@RequestMapping(value = "modifyDistributionCompletedOrder.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer modifyDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder,
			HttpServletRequest request) {
		System.out.println(distributionCompletedOrder.getRemarks());
		Integer result = distributionCompletedOrderService.modifyDistributionCompletedOrder(distributionCompletedOrder);
		
		logger.info("成功修改了" + distributionCompletedOrder.getWave());
		return result;
	}

	@RequestMapping(value = "delDistributionCompletedOrder.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer delDistributionCompletedOrder(DistributionCompletedOrder distributionCompletedOrder,
			HttpServletRequest request) {
		Integer result = distributionCompletedOrderService.delDistributionCompletedOrder(distributionCompletedOrder);
		logger.info("成功删除了" + distributionCompletedOrder.getWave());
		return result;
	}

	@RequestMapping(value = "getDistributionCompletedOrderByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<DistributionCompletedOrder> getDistributionCompletedOrderByPageCount(
			@RequestParam Map<String, Object> anyVal) {
		Integer result = distributionCompletedOrderService.getDistributionCompletedOrderByPageCount(anyVal);
		Page<DistributionCompletedOrder> page = new Page<DistributionCompletedOrder>(result, 1);
		return page;
	}

	@RequestMapping(value = "findConditionDistributionCompletedOrderByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<DistributionCompletedOrder> findConditionDistributionCompletedOrderByPage(
			@RequestParam Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<DistributionCompletedOrder> list = distributionCompletedOrderService
				.findConditionDistributionCompletedOrderByPage(anyVal);
		return list;

	}

	@RequestMapping(value = "findDistributionCompletedOrderById.do", method = RequestMethod.POST)
	@ResponseBody
	public DistributionCompletedOrder findDistributionCompletedOrderById(Integer id) {
		DistributionCompletedOrder distributionCompletedOrder = distributionCompletedOrderService
				.findDistributionCompletedOrderById(id);
		return distributionCompletedOrder;
	}

	@RequestMapping(value = "updateDistributionCompletedOrderByStorage.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer updateDistributionCompletedOrderByStorage(Integer id) {
		Integer result = distributionCompletedOrderService.updateDistributionCompletedOrderByStorage(id);
		return result;
	}
}
