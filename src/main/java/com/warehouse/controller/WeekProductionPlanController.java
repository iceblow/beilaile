package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.WeekProductionPlan;
import com.warehouse.service.WeekProductionPlanService;
import com.warehouse.util.PageUtil;

//本周出货计划
@Controller
@RequestMapping("weekProductionPlan")
public class WeekProductionPlanController {

	@Resource
	private WeekProductionPlanService weekProductionPlanService;

	@RequestMapping("weekPlan.do")
	@ResponseBody
	public List<WeekProductionPlan> weekPlan(WeekProductionPlan weekProductionPlan) {
		List<WeekProductionPlan> list = weekProductionPlanService.selectAllData(weekProductionPlan);
		return list;
	}

	@RequestMapping("weekPlanTwo.do")
	@ResponseBody
	public List<WeekProductionPlan> weekPlanTwo(WeekProductionPlan weekProductionPlan) {
		List<WeekProductionPlan> list = weekProductionPlanService.selectAllDataTwo(weekProductionPlan);
		return list;
	}

	@RequestMapping("insertData.do")
	@ResponseBody
	public int insertData(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanService.insertData(weekProductionPlan);

	}

	@RequestMapping("insertFactoryData.do")
	@ResponseBody
	public int insertFactoryData(WeekProductionPlan weekProductionPlan) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		weekProductionPlan.setDate(df.format(new Date()));
		return weekProductionPlanService.insertFactoryData(weekProductionPlan);
	}
	
	//填写下周出货计划
	@RequestMapping("insertNextFactoryData.do")
	@ResponseBody
	public int insertNextFactoryData(WeekProductionPlan weekProductionPlan) {
		
		return weekProductionPlanService.insertNextFactoryData(weekProductionPlan);
	}

	@RequestMapping("updateData.do")
	@ResponseBody
	public int updateData(WeekProductionPlan weekProductionPlan) {

		return weekProductionPlanService.updateData(weekProductionPlan);

	}

	// 修改本周出货目标值
	@RequestMapping("updateTarger.do")
	@ResponseBody
	public int updateTarger(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanService.updateTarger(weekProductionPlan);

	}
	
	// 修改本周出货目标值
	@RequestMapping("updateFactory.do")
	@ResponseBody
	public int updateFactory(String date,String factory,String factoryNow) {
		return weekProductionPlanService.updateFactory(date,factory,factoryNow);

	}
	
	// 修改本周是否有这个工厂名
	@RequestMapping("selectFactory.do")
	@ResponseBody
	public List<String> selectFactory(String date,String factory,String factoryNow) {
		List<String> list=weekProductionPlanService.selectFactory(date,factory,factoryNow);
		return list;
	}
	
	// 删除数据
	@RequestMapping("deleteFactory.do")
	@ResponseBody
	public int deleteByFactory(WeekProductionPlan weekProductionPlan) {
		return weekProductionPlanService.deleteByFactory(weekProductionPlan);
	}

	// 查询所有的报表时间为星期一的
	@RequestMapping("selectAllDate.do")
	@ResponseBody
	public Map<String, Object> selectSunday(PageUtil page, WeekProductionPlan weekProductionPlan) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(15);               // 每页显示数据量
		page.setTotolCount(weekProductionPlanService.selectAllPage(weekProductionPlan));      // 总数据条数
		List<WeekProductionPlan> myList = this.weekProductionPlanService.selectAllSundayDate(new WeekProductionPlan(page.getReqult()[0], page.getReqult()[1], weekProductionPlan));// 得到分页查询的数据
		map.put("pageUtil", page);             //  前台接收的分页信息
		map.put("dataList", myList);          //  显示数据详细信息
		return map;
	}	
}
