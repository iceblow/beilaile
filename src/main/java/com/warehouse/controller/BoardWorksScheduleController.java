package com.warehouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.AuxiliaryFabric;
import com.warehouse.entity.BoardWorksSchedule;
import com.warehouse.entity.Tracking;
import com.warehouse.service.BoardWorksScheduleService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("boardWorksSchedule")
public class BoardWorksScheduleController {

	@Resource
	private BoardWorksScheduleService boardWorksScheduleService;

	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page, BoardWorksSchedule boardWorksSchedule) {
		Map<String, Object> map = new HashMap<>();

		// 写入每页长度
		page.setPageSize(15);
		
		boardWorksSchedule.setBegin(page.getReqult()[0]);
		boardWorksSchedule.setEnd(page.getReqult()[1]);
		
		
		// 写入数据量
		page.setTotolCount(this.boardWorksScheduleService.getCount(boardWorksSchedule));

		List<BoardWorksSchedule> allList = this.boardWorksScheduleService.getAllByPage(boardWorksSchedule);
		
		map.put("pageUtil", page);
		map.put("dataList", allList);
		
		System.err.println(map.get("dataList"));

		return map;
	}

}
