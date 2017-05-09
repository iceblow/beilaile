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

import com.warehouse.entity.Fabricmanagement;
import com.warehouse.service.FabricmanagementService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

@Controller
@RequestMapping("fabricmanagement")
public class FabricmanagementController {

	@Resource
	private FabricmanagementService fabricmanagementService;
	private Logger log = LoggerFactory.getLogger(FabricmanagementController.class);// 生成日志

	/**
	 * 分页加模糊查询
	 * 
	 * @param page
	 * @param flag
	 * @return
	 */
	@RequestMapping("allfabricmanagement")
	@ResponseBody
	public Map<String, Object> allfabricmanagement(PageUtil page, Fabricmanagement flag) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.fabricmanagementService.getCountByFabricmanagement(flag));// 总共有多少条数据
		// map对象中存的数据
		List<Fabricmanagement> fabricmanagements = this.fabricmanagementService
				.getPageByFabricmanagement(new Pagess(page.getReqult()[0], page.getReqult()[1], flag.getWave(),
						flag.getFabricMaterial(), flag.getInputAmount(), flag.getOutputAmount())); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", fabricmanagements);
		log.info("查询面料进度信息");
		return map;
	}

	/**
	 * 根据波次精确查询
	 * 
	 * @param wave
	 * @return
	 */
	@RequestMapping("selFabricmanagementBywave")
	@ResponseBody
	public Map<String, Object> selFabricmanagementBywave(PageUtil page, Fabricmanagement fabric) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.fabricmanagementService.getCountByFabricmanagement(fabric));// 总共有多少条数据
		// map对象中存的数据
		List<Fabricmanagement> fabricmanagements = this.fabricmanagementService.selFabricManagementBywave(
				new Fabricmanagement(page.getReqult()[0], page.getReqult()[1], fabric.getWave())); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", fabricmanagements);
		log.info("跳转查询");
		return map;
	}

}
