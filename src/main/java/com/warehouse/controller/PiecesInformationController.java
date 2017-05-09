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

import com.warehouse.entity.PiecesInformation;
import com.warehouse.service.PiecesInformationService;
import com.warehouse.util.PageUtil;

@RequestMapping("piecesInformation")
@Controller
public class PiecesInformationController {

	@Resource
	private PiecesInformationService piecesInformationService;

	private Logger log = LoggerFactory.getLogger(PiecesInformationController.class);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("piecesInformationBypage")
	public Map<String, Object> piecesInformationBypage(PiecesInformation record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);
		page.setTotolCount(this.piecesInformationService.selectByCount(record));
		List<PiecesInformation> piecesInformations = this.piecesInformationService.selectByPage(
				new PiecesInformation(record.getOrderId(), record.getWave(), page.getReqult()[0], page.getReqult()[1]));
		map.put("dataList", piecesInformations);
		map.put("pageUtil", page);
		log.info("查询片印信息");
		return map;
	}

	/**
	 * 修改状态
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppPiecesInformation")
	@ResponseBody
	public int uppPiecesInformation(PiecesInformation record) {
		int flag = 0;
		record.setStatus("0");
		flag = this.piecesInformationService.uppPiecesInformation(record);
		log.debug("更改片印信息");
		return flag;
	}

}
