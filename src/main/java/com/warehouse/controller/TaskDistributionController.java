package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.TaskDistribution;
import com.warehouse.service.TaskDistributionService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("taskDistribution")
public class TaskDistributionController {

	@Resource
	private TaskDistributionService taskDistributionService;

	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil page, TaskDistribution taskDistribution) {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(15);// 每页显示数据量
		page.setTotolCount(taskDistributionService.getAllCount(taskDistribution));// 总数据条数
		List<TaskDistribution> myList = this.taskDistributionService
				.getDataByPage(new TaskDistribution(page.getReqult()[0], page.getReqult()[1], taskDistribution));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}
	
	@RequestMapping("getOneByid")
	@ResponseBody
	public TaskDistribution getOneById(Integer id){
		return this.taskDistributionService.getOneByid(id);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public int update(TaskDistribution taskDistribution){
		return this.taskDistributionService.update(taskDistribution);
	}
	
	@RequestMapping("dbUpdateTask")
	@ResponseBody
	public int dbUpdateTask(TaskDistribution taskDistribution){
		return this.taskDistributionService.dbUpdateTask(taskDistribution);
	}
}
