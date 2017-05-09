package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.DistributeDetailedOrder;
import com.warehouse.service.DistributeDetailedOrderService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("distributeDetailedOrder")
public class DistributeDetailedOrderController {
	@Resource
	private DistributeDetailedOrderService distributeDetailedOrderService;

	private Logger log=LoggerFactory.getLogger(DistributeDetailedOrderController.class);
	/**
	 * 分页查询
	 * 
	 * @param detailedOrder
	 * @param page
	 * @return
	 */
	@RequestMapping("distributeDetailedOrderBypage")
	@ResponseBody
	public Map<String, Object> distributeDetailedOrderByPage(DistributeDetailedOrder detailedOrder, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);
		page.setTotolCount(this.distributeDetailedOrderService.selectByCount(detailedOrder));
		List<DistributeDetailedOrder> detailedOrders = this.distributeDetailedOrderService.selectByPage(
				new DistributeDetailedOrder(detailedOrder.getOrderId(), page.getReqult()[0], page.getReqult()[1]));
		map.put("pageUtil", page);
		map.put("dataList", detailedOrders);
		log.info("查询所有的片印领料订单详情");
		return map;
	}

	/**
	 * 撤销
	 * 
	 * @param detailedOrder
	 * @return
	 */
	@RequestMapping("delDistributeDatailedOrder")
	@ResponseBody
	public int delDistributeDatailedOrder(DistributeDetailedOrder detailedOrder) {
		int flag = 0;
		flag = this.distributeDetailedOrderService.delDistributeDetailedOrder(detailedOrder);
		log.info("删除片印领料订单信息");
		return flag;
	}
}
