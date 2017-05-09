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

import com.warehouse.entity.OutEmbroider;
import com.warehouse.service.OutEmbroiderService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("outEmbroider")
public class OutEmbroiderController {

	@Resource
	private OutEmbroiderService embroiderService;

	private Logger log = LoggerFactory.getLogger(OutEmbroiderController.class);

	// 添加
	@RequestMapping("addEmbroider")
	@ResponseBody
	public int addembroider(OutEmbroider embroider) {
		// 总量
		Integer count = embroider.getCode1() + embroider.getCode2() + embroider.getCode3() + embroider.getCode4()
				+ embroider.getCode5() + embroider.getCode6() + embroider.getCode110() + embroider.getCode120()
				+ embroider.getCode130() + embroider.getCode160() + embroider.getCode170() + embroider.getCode52();
		embroider.setTotal(count);
		this.embroiderService.insertOutEmbroider(embroider);
		log.debug("添加片料回印信息");
		return 1;
	}

	// 删除
	@RequestMapping("delEmbroider")
	@ResponseBody
	public int delembroider(OutEmbroider embroider) {
		embroider.setOid(embroider.getOid());
		this.embroiderService.deleteOutEmbroider(embroider);
		log.debug("删除片料回印信息");
		return 1;
	}

	/**
	 * 根据id查询
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping("touppEmbroider")
	@ResponseBody
	public OutEmbroider touppEmbroider(Integer oid) {
		OutEmbroider embroider = embroiderService.selectByPrimaryKey(oid);
		return embroider;
	}

	// 修改
	@RequestMapping("uppEmbroider")
	@ResponseBody
	public int uppembroider(OutEmbroider embroider) {
		// 总量
		Integer count = embroider.getCode1() + embroider.getCode2() + embroider.getCode3() + embroider.getCode4()
				+ embroider.getCode5() + embroider.getCode6() + embroider.getCode110() + embroider.getCode120()
				+ embroider.getCode130() + embroider.getCode160() + embroider.getCode170() + embroider.getCode52();
		embroider.setTotal(count);
		this.embroiderService.updateOutEmbroider(embroider);
		log.debug("修改片料回印信息");
		return 1;
	}

	// 模糊查询
	@RequestMapping("embroiderBylike")
	@ResponseBody
	public Map<String, Object> embroiderBylike(String girard, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.embroiderService.getCountByOutLike(girard));// 总共有多少条数据
		// map对象中存的数据
		List<OutEmbroider> embroiderlist = this.embroiderService
				.outEmbroiderByLike((new OutEmbroider(page.getReqult()[0], page.getReqult()[1], girard))); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", embroiderlist);
		log.info("全查询片料回印信息");
		return map;
	}

}
