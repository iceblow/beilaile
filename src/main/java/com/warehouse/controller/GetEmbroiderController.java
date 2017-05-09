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

import com.warehouse.entity.GetEmbroider;
import com.warehouse.service.GetEmbroiderService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("getEmbroider")
public class GetEmbroiderController {

	@Resource
	private GetEmbroiderService embroiderService;
	private Logger log = LoggerFactory.getLogger(GetEmbroiderController.class);

	// 添加
	@RequestMapping("addembroider")
	@ResponseBody
	public int addembroider(GetEmbroider embroider) {
		System.err.println("sddd");
		// 计算总量
		Integer count = embroider.getCode1() + embroider.getCode2() + embroider.getCode3() + embroider.getCode4()
				+ embroider.getCode5() + embroider.getCode6() + embroider.getCode110() + embroider.getCode120()
				+ embroider.getCode130() + embroider.getCode160() + embroider.getCode170()+embroider.getCode52();
		embroider.setTotal(count);
		int flag = embroiderService.insertEmbroider(embroider);
		log.debug("添加片料领料印信息");
		return flag;
	}

	// 删除
	@RequestMapping("delembroider")
	@ResponseBody
	public int delembroider(GetEmbroider embroider) {
		embroider.setEid(embroider.getEid());
		int flag = this.embroiderService.deleteEmbroider(embroider);
		log.debug("删除片料领料印信息");
		return flag;
	}

	// 修改
	@RequestMapping("uppembroider")
	@ResponseBody
	public int uppembroider(GetEmbroider embroider) {
		System.out.println("修改！！");
		// 总量
		Integer count = embroider.getCode1() + embroider.getCode2() + embroider.getCode3() + embroider.getCode4()
				+ embroider.getCode5() + embroider.getCode6() + embroider.getCode110() + embroider.getCode120()
				+ embroider.getCode130() + embroider.getCode160() + embroider.getCode170()+embroider.getCode52();
		embroider.setTotal(count);
		int flag = this.embroiderService.updateEmbroider(embroider);
		log.debug("修改片料领料印信息");
		return flag;
	}

	// 模糊查询
	@RequestMapping("embroiderBylike")
	@ResponseBody
	public Map<String, Object> embroiderBylike(GetEmbroider embroider, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.embroiderService.getCountByLike(embroider));// 总共有多少条数据
		// map对象中存的数据
		List<GetEmbroider> embroiderlist = this.embroiderService.getEmbroiderByLike(
				(new GetEmbroider(page.getReqult()[0], page.getReqult()[1], embroider.getGirard()))); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", embroiderlist);
		log.info("查看片料领料印信息");
		return map;
	}

}
