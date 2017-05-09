package com.warehouse.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.OrderMemoDemo;
import com.warehouse.service.OrderMemoService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

@Controller
@RequestMapping("orderMemo")
public class OrderMemoController {

	@Autowired
	private OrderMemoService orderMemoService;
	private final Logger logger = LoggerFactory.getLogger(OrderMemoDemo.class);

	// 分页查询订单备忘信息
	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page) {

		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 写入每页显示的数据量
		page.setTotolCount(this.orderMemoService.getAllCount());// 查询并写入总的数据量

		List<OrderMemoDemo> orderList = this.orderMemoService
				.getAllByPage(new Pagess(page.getReqult()[0], page.getReqult()[1]));

		map.put("dataList", orderList);
		map.put("pageUtil", page);

		logger.info("分页查询订单备忘信息:-" + orderList.size());

		return map;
	}

	// 数据添加方法
	@RequestMapping("add")
	@ResponseBody
	public int add(OrderMemoDemo order) {

		try {

			this.orderMemoService.add(order);

			logger.info("添加订单备忘信息:-" + order.toString());

		} catch (Exception e) {

			logger.debug("添加订单备忘信息失败:-" + e.getMessage());

		}
		return 1;
	}

	// 数据修改方法
	@RequestMapping("update")
	@ResponseBody
	public int update(OrderMemoDemo order) {

		int num = 0;

		try {
			this.orderMemoService.update(order);
			logger.info("修改订单备忘信息:-" + order.toString());
			num = 1;

		} catch (Exception e) {

			logger.info("修改订单备忘信息失败:-" + e.getMessage());
		}

		return num;

	}

	// 数据真删除
	@RequestMapping("trueDel")
	public void trueDel(int id) {
		try {
			this.orderMemoService.trueDel(id);
			logger.info("删除订单备忘信息:-ID=" + id);
		} catch (Exception e) {

			logger.info("删除订单备忘信息失败:-" + e.getMessage());
		}
	}

	// 数据假删除
	@RequestMapping("fakeDel")
	@ResponseBody
	public int fakeDel(int id) {
		int num = 0;
		try {
			OrderMemoDemo order = new OrderMemoDemo();
			order.setId(id);
			// 获得系统时间
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			String delTime = format.format(date);
			// 写入被删除的时间
			order.setDelTime(delTime);
			// 执行假删除方法
			this.orderMemoService.fakeDel(order);
			
			logger.info("删除订单备忘信息:-ID=" + id);
			// 删除成功
			num = 1;

		} catch (Exception e) {

			logger.info("删除订单备忘信息:-ID=" + id);
			
		}
		return num;
	}

}
