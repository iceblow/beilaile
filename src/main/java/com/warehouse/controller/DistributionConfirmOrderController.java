package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.warehouse.entity.DistributionConfirmOrder;
import com.warehouse.service.DistributionConfirmOrderService;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("distributionConfirmOrder")
public class DistributionConfirmOrderController {
	private Logger logger = LoggerFactory.getLogger(DistributionConfirmOrderController.class);
	@Resource
	private DistributionConfirmOrderService distributionConfirmOrderService;
	
	// 分页查询
	@RequestMapping("getdistributionConfirmOrderPage.do")
	@ResponseBody
	public Map<String, Object> selectPageFabric(PageUtil page, DistributionConfirmOrder distributionConfirmOrder) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(10);// 每页显示数据量
		page.setTotolCount(distributionConfirmOrderService.selectAllcount(distributionConfirmOrder));// 总数据条数
		List<DistributionConfirmOrder> myList = this.distributionConfirmOrderService.getDistributionConfirmOrderPage(new DistributionConfirmOrder(page.getReqult()[0], page.getReqult()[1], distributionConfirmOrder));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}
	
	/**
	 * 点击确认下单
	 * */
	@RequestMapping("sureDistributionConfirmOrderById.do")
	@ResponseBody
	public int sureDistributionConfirmOrderById( DistributionConfirmOrder distributionConfirmOrder) {
		return distributionConfirmOrderService.sureDistributionConfirmOrderById(distributionConfirmOrder);
	}
	
	/**
	 * 点击放弃下单
	 * */
	@RequestMapping("giveUpDistributionConfirmOrderById.do")
	@ResponseBody
	public int giveUpDistributionConfirmOrderById( DistributionConfirmOrder distributionConfirmOrder,HttpServletRequest request) {
		logger.info("成功修改了波茨号为:" + distributionConfirmOrder.getWave() + "的数据"+ClientIpUtil.getIpAddress(request));
		return distributionConfirmOrderService.giveUpDistributionConfirmOrderById(distributionConfirmOrder);
	}
	/**
	 * 
	 *双击修改备注
	 * */
	@RequestMapping("updateDistributionConfirmOrderById.do")
	@ResponseBody
	public int updatedistributionConfirmOrderById( DistributionConfirmOrder distributionConfirmOrder,HttpServletRequest request) {
		logger.info("成功修改了波茨号为:" + distributionConfirmOrder.getWave() + "的数据"+ClientIpUtil.getIpAddress(request));
		return distributionConfirmOrderService.updateDistributionConfirmOrderById(distributionConfirmOrder,request);
	}
}
