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

import com.warehouse.entity.SewingFactoryPickingOrder;
import com.warehouse.service.SewingFactoryPickingOrderService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("SewingFactoryPickingOrder")
public class SewingFactoryPickingOrderController {
	@Resource
	private SewingFactoryPickingOrderService factoryPickingOrderService;

	private Logger log = LoggerFactory.getLogger(SewingFactoryPickingOrderController.class);

	/**
	 * 分页查询裁床详单
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@RequestMapping("selSewingFactoryPickingOrderBypage")
	@ResponseBody
	public Map<String, Object> selSewingFactoryPickingOrderBypage(SewingFactoryPickingOrder record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);
		page.setTotolCount(this.factoryPickingOrderService.getCountBySewingFactory(record));
		List<SewingFactoryPickingOrder> factoryPickingOrders = this.factoryPickingOrderService.selectByPrimaryKey(
				new SewingFactoryPickingOrder(record.getOrderId(), page.getReqult()[0], page.getReqult()[1]));
		map.put("dataList", factoryPickingOrders);
		map.put("pageUtil", page);
		log.info("查询裁床详单表");
		return map;
	}

	/**
	 * 删除裁床信息
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppStatus")
	@ResponseBody
	public int uppStatus(SewingFactoryPickingOrder record) {
		int flag = 0;
		record.setSewingStatus("0");
		flag = this.factoryPickingOrderService.updateByPrimaryKeySelective(record);
		return flag;
	}

}
