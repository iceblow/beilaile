package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.warehouse.entity.OrderTracking;
import com.warehouse.service.OrderTrackingService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("orderTracking")
public class OrderTrackingController {
	@Resource
	private OrderTrackingService orderTrackingService;

	// 分页查询
	@RequestMapping("getorderTrackingPage.do")
	@ResponseBody
	public Map<String, Object> selectPageFabric(PageUtil page, OrderTracking orderTracking) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(10);// 每页显示数据量
		page.setTotolCount(orderTrackingService.selectAllcount(orderTracking));// 总数据条数
		List<OrderTracking> myList = this.orderTrackingService.getOrderTrackingPage(new OrderTracking(page.getReqult()[0], page.getReqult()[1], orderTracking));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}
	
	@RequestMapping("deleteOrderTrackingById.do")
	@ResponseBody
	public int deleteOrderTrackingById(OrderTracking orderTracking){
		
		return orderTrackingService.deleteOrderTrackingById(orderTracking);
	}
	
	@RequestMapping("updateByText.do")
	@ResponseBody
	public int updateByText(OrderTracking orderTracking){
		
		return orderTrackingService.updateByText(orderTracking);
	}
}
