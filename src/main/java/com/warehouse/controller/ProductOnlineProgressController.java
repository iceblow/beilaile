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

import com.warehouse.entity.ProductOnlineProgress;
import com.warehouse.service.ProductOnlineProgressService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("productOnlineProgress")
public class ProductOnlineProgressController {

	private Logger log = LoggerFactory.getLogger(ProductOnlineProgressController.class);
	@Resource
	private ProductOnlineProgressService onlineProgressService;

	@RequestMapping("selProductOnlineProgressBypage")
	@ResponseBody
	public Map<String, Object> selProductOnlineProgressBypage(PageUtil page, ProductOnlineProgress record) {
		/*
		 * System.err.println("wave====" + record.getWave() + "  name===" +
		 * record.getProductName() + " code==" + record.getProductCode());
		 */
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(15);
		page.setTotolCount(onlineProgressService.selectCountByPrimaryKey(record));
		List<ProductOnlineProgress> onlineProgressList = this.onlineProgressService
				.selectByPrimaryKey(new ProductOnlineProgress(page.getReqult()[0], page.getReqult()[1],
						record.getWave(), record.getProductName(), record.getProductCode()));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", onlineProgressList);
		log.info("查询产品上新进度");
		return map;
	}

	/**
	 * 添加
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("insertProductOnline")
	@ResponseBody
	public int insertProductOnline(ProductOnlineProgress record) {
		int flag = 0;
		flag = this.onlineProgressService.insertSelective(record);
		return flag;
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("updateProductOnline")
	@ResponseBody
	public int updateProductOnline(ProductOnlineProgress record) {
		int flag = 0;
		flag = this.onlineProgressService.updateByPrimaryKeySelective(record);
		return flag;
	}
}
