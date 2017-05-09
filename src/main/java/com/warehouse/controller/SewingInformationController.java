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

import com.warehouse.entity.SewingInformation;
import com.warehouse.service.SewingInformationService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("sewingInformation")
public class SewingInformationController {

	@Resource
	private SewingInformationService informationService;

	private Logger log = LoggerFactory.getLogger(SewingInformationController.class);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@RequestMapping("SewingInformationBypage")
	@ResponseBody
	public Map<String, Object> SewingInformationBypage(SewingInformation record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);
		page.setTotolCount(this.informationService.getCountBySewingInformation(record));
		List<SewingInformation> sewingInformations = this.informationService
				.selectByPrimaryKey(new SewingInformation(record.getWave(), page.getReqult()[0], page.getReqult()[1]));
		map.put("pageUtil", page);
		map.put("dataList", sewingInformations);
		log.info("查询车缝信息！");
		return map;
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uppSewingInformation")
	public int uppSewingInformation(SewingInformation record) {
		int flag = 0;
		record.setSewingStatus("0");
		flag = this.informationService.updateByPrimaryKeySelective(record);
		log.debug("修改车缝领料的状态");
		return flag;
	}

}
