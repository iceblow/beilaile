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

import com.warehouse.entity.CancelOrder;
import com.warehouse.service.CancelOrderService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("cancelOrder")
public class CancelOrderController {

	@Resource
	private CancelOrderService cancelOrderService;

	private Logger log = LoggerFactory.getLogger(CancelOrderController.class);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@RequestMapping("CancelOrderByPage")
	@ResponseBody
	public Map<String, Object> CancelOrderByPage(CancelOrder record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);
		page.setTotolCount(this.cancelOrderService.selByPrimaryKeyCount(record));
		List<CancelOrder> cancelOrders = this.cancelOrderService
				.selByPrimaryKeyPage(new CancelOrder(record.getGirard(), page.getReqult()[0], page.getReqult()[1]));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", cancelOrders);
		log.info("查询所有撤销的订单信息！");
		return map;
	}

	/**
	 * 删单
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("addCancelOrder")
	@ResponseBody
	public int addCancelOrder(CancelOrder record) {
		int flag = 0;
		flag = this.cancelOrderService.insertSelective(record);
		log.debug("添加要撤销的订单信息");
		return flag;
	}

	/**
	 * 撤单
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppCancelOrder")
	@ResponseBody
	public int uppCancelOrder(CancelOrder record) {
		int flag = 0;
		flag = this.cancelOrderService.deleteByPrimaryKey(record);
		log.debug("撤回要撤销的订单信息");
		return flag;
	}
}
