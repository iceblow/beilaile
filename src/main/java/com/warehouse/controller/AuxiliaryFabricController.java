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

import com.warehouse.entity.AuxiliaryFabric;
import com.warehouse.service.AuxiliaryFabricService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("auxiliaryFabric")
public class AuxiliaryFabricController {

	@Resource
	private AuxiliaryFabricService auxiliaryFabricService;

	private Logger logger = LoggerFactory.getLogger(AuxiliaryFabricController.class);

	/**
	 * 全部数据的分页查询
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page, AuxiliaryFabric auxiliaryFabric) {

		System.err.println(auxiliaryFabric.toString());

		Map<String, Object> map = new HashMap();
		// 写入每页长度
		page.setPageSize(15);
		// 写入数据量
		page.setTotolCount(this.auxiliaryFabricService
				.getCount(new AuxiliaryFabric(page.getReqult()[0], page.getReqult()[1], auxiliaryFabric)));

		List<AuxiliaryFabric> allList = this.auxiliaryFabricService
				.getAllByPage(new AuxiliaryFabric(page.getReqult()[0], page.getReqult()[1], auxiliaryFabric));

		map.put("pageUtil", page);
		map.put("dataList", allList);

		logger.info("进行了辅料采购数据的分页查询");
		return map;
	}

	/**
	 * 根据编号得到单条数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getOne")
	@ResponseBody
	public AuxiliaryFabric getOne(Integer id) {

		logger.info("查询了编号为“" + id + "”的面料采购信息");

		return this.auxiliaryFabricService.getOne(id);
	}

	/**
	 * 普通修改方法
	 * 
	 * @param auxiliaryFabric
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(AuxiliaryFabric auxiliaryFabric) {
		String str = "0";
		try {
			this.auxiliaryFabricService.update(auxiliaryFabric);
			str = "1";
			logger.info("修改了波次号为“" + auxiliaryFabric.getGirard() + "”的面料采购信息");
		} catch (Exception e) {
			logger.debug("修改波次号为“" + auxiliaryFabric.getGirard() + "”的面料采购信息发生了错误" + e.getMessage());
		}
		return str;
	}

	/**
	 * 双击修改方法
	 * 
	 * @param auxiliaryFabric
	 * @return
	 */
	@RequestMapping("myDBupdate")
	@ResponseBody
	public String myDBupdate(AuxiliaryFabric auxiliaryFabric) {

		System.err.println(auxiliaryFabric.toString());

		String str = "0";
		try {
			this.auxiliaryFabricService.myDBupdate(auxiliaryFabric);
			str = "1";
			logger.info("修改了波次号为“" + auxiliaryFabric.getGirard() + "”的面料采购信息");
		} catch (Exception e) {
			logger.debug("修改波次号为“" + auxiliaryFabric.getGirard() + "”的面料采购信息发生了错误" + e.getMessage());
		}
		return str;
	}
}
