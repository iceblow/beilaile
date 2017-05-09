package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.DistributionQuote;
import com.warehouse.service.DistributionQuoteService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("distributionQuote")
public class DistributionQuoteController {

	@Resource
	private DistributionQuoteService distributionQuoteService;
	
	// 分页查询
	@RequestMapping("getdistributionQuotePage.do")
	@ResponseBody
	public Map<String, Object> selectPageFabric(PageUtil page, DistributionQuote distributionQuote) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(10);// 每页显示数据量
		page.setTotolCount(distributionQuoteService.selectAllcount(distributionQuote));// 总数据条数
		List<DistributionQuote> myList = this.distributionQuoteService.getDistributionQuotePage(new DistributionQuote(page.getReqult()[0], page.getReqult()[1], distributionQuote));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}
	
	/**
	 * 确认报价
	 * */
	@RequestMapping("sureDistributionQuoteById.do")
	@ResponseBody
	public int sureDistributionQuoteById(DistributionQuote distributionQuote)  {
		return distributionQuoteService.sureDistributionQuoteById(distributionQuote);
	}
	
	//取消报价
	@RequestMapping("giveUpDistributionQuoteById.do")
	@ResponseBody
	public int giveUpDistributionQuoteById(DistributionQuote distributionQuote)  {
		return distributionQuoteService.giveUpDistributionQuoteById(distributionQuote);
	}
	
	// 修改备注
	@RequestMapping("updateDistributionQuoteById.do")
	@ResponseBody
	public int updateDistributionQuoteById(DistributionQuote distributionQuote)  {
		return distributionQuoteService.updateDistributionQuoteById(distributionQuote);
	}
	
}
