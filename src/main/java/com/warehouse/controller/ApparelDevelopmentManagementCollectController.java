package com.warehouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ApparelDevelopmentManagementCollect;
import com.warehouse.service.ApparelDevelopmentManagementCollectService;

@Controller
@RequestMapping("ApparelDevelopmentManagementCollect")
public class ApparelDevelopmentManagementCollectController {

	private Logger logger = LoggerFactory.getLogger(ApparelDevelopmentManagementCollectController.class);

	@Resource
	private ApparelDevelopmentManagementCollectService apparelDevelopmentManagementCollectService;

	@RequestMapping("getData")
	@ResponseBody
	public List<ApparelDevelopmentManagementCollect> getData() {

		List<ApparelDevelopmentManagementCollect> allList = new ArrayList<ApparelDevelopmentManagementCollect>();
		try {
			allList = this.apparelDevelopmentManagementCollectService.select();
			logger.info("查看了前一天的设计师汇总数据");
		} catch (Exception e) {
			logger.debug("查看设计师汇总数据出错");
		}
		return allList;
	}

}
