package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.warehouse.entity.NotStorageTracking;
import com.warehouse.service.NotStorageTrackingService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("notStorageTracking")
public class NotStorageTrackingController {
	@Resource
	private NotStorageTrackingService notStorageTrackingService;

	// 分页查询
	@RequestMapping("getnotStorageTrackingPage.do")
	@ResponseBody
	public Map<String, Object> selectPageFabric(PageUtil page, NotStorageTracking notStorageTracking) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(10);// 每页显示数据量
		page.setTotolCount(notStorageTrackingService.selectAllcount(notStorageTracking));// 总数据条数
		List<NotStorageTracking> myList = this.notStorageTrackingService.getnotStorageTrackingPage(new NotStorageTracking(page.getReqult()[0], page.getReqult()[1], notStorageTracking));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}
	
	// 分页查询
	@RequestMapping("deleteById.do")
	@ResponseBody
	public int deleteById(NotStorageTracking notStorageTracking){
		return notStorageTrackingService.deleteById(notStorageTracking);
	}
	
	@RequestMapping("updateByText.do")
	@ResponseBody
	public int updateByText(NotStorageTracking notStorageTracking){
		return notStorageTrackingService.updateByText(notStorageTracking);
	}
}
