package com.warehouse.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.Outsideproces;
import com.warehouse.service.OutsideProcesService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

@Controller
@RequestMapping("outsideproces")
public class OutsideProcesController {

	@Resource
	private OutsideProcesService procesService;
	private Logger log = LoggerFactory.getLogger(OutsideProcesController.class);

	// 添加
	@RequestMapping("addProce")
	@ResponseBody
	public int insertProce(Outsideproces outsideproces) {
		outsideproces.setDelb(0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");// 设置日期格式
		// 获取当前系统时间
		outsideproces.setBdate(df.format(new Date()));
		this.procesService.addProces(outsideproces);
		log.debug("添加加工核价信息");
		return 1;
	}

	// 修改
	@RequestMapping("uppProce")
	@ResponseBody
	public int updateProce(Outsideproces outsideproces) {
		outsideproces.setDelb(0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");// 设置日期格式
		// 获取当前系统时间
		outsideproces.setBdate(df.format(new Date()));
		this.procesService.uppProces(outsideproces);
		log.debug("修改加工核价信息");
		return 1;
	}

	// 删除
	@RequestMapping("delProce")
	@ResponseBody
	public void delProce(Integer bid) {
		log.debug("删除加工核价信息");
		this.procesService.delProces(bid);
	}

	// 模糊查询
	@RequestMapping("outsideProcesBylike")
	@ResponseBody
	public Map<String, Object> embroiderBylike(String girard, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.procesService.getCountByOutsideLike(girard));// 总共有多少条数据
		// map对象中存的数据
		List<Outsideproces> dailylist = this.procesService
				.OutsideProcesByLike((new Pagess(page.getReqult()[0], page.getReqult()[1], girard))); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", dailylist);
		log.info("查询加工核价信息");
		return map;
	}

	/**
	 * 
	 * @param outsideproces
	 * @return
	 */
	// 根据波次进行查询并修改件数的数据
	@RequestMapping("getDistinct")
	@ResponseBody
	public int getDistinct(Outsideproces outsideproces) {
		List<Outsideproces> count = this.procesService.getDistinct(outsideproces);
		if (count.size() >= 1) {
			// 数据库中的id
			int bid = count.get(0).getBid();
			// 数据库的数据数量
			int number = count.get(0).getBnumber();
			// 修改 页面的数量
			number += outsideproces.getBnumber();
			// System.out.println("bid=======" + bid + "number=====" + number);
			this.procesService.uppNum(bid, number);
		} else {
			// 添加
			this.insertProce(outsideproces);
		}
		return 0;
	}

}
