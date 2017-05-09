package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.SalesNotSaleHangZhou;
import com.warehouse.service.SalesNotSaleHangZhouService;
import com.warehouse.util.PageUtil;

/**
 * 杭州未到货
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("salesNotSaleHangZhou")
public class SalesNotSaleHangZhouController {

	@Resource
	private SalesNotSaleHangZhouService notSaleHangZhouService;

	/**
	 * 模糊查询
	 * 
	 * @param inputstorage
	 * @param page
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(SalesNotSaleHangZhou notSaleHangZhou, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.notSaleHangZhouService.getCountByPage(notSaleHangZhou));// 总共有多少条数据
		// map对象中存的数据
		List<SalesNotSaleHangZhou> notSaleHangZhoulist = this.notSaleHangZhouService
				.getDataByPage(new SalesNotSaleHangZhou(page.getReqult()[0], page.getReqult()[1], notSaleHangZhou)); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", notSaleHangZhoulist);
		return map;
	}

}
