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
import com.warehouse.entity.OutsideDaily;
import com.warehouse.service.OutsideDailyService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("outsideDialy")
public class OutsideDailyController {

	@Resource
	private OutsideDailyService dailyService;
	private Logger log = LoggerFactory.getLogger(OutsideDailyController.class);

	/**
	 * 添加
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("addOutsideDaily")
	@ResponseBody
	public int addembroider(OutsideDaily daily) {
		// 总量
		Integer count = daily.getCode52() + daily.getCode1() + daily.getCode2() + daily.getCode3() + daily.getCode4()
				+ daily.getCode5() + daily.getCode6() + daily.getCode110() + daily.getCode120() + daily.getCode130()
				+ daily.getCode160() + daily.getCode170();
		daily.setTotal(count);
		this.dailyService.insertOutsideDaily(daily);
		log.debug("添加车缝领料信息");
		return 1;
	}

	/**
	 * 删除
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("delOutsideDaily")
	@ResponseBody
	public int delembroider(OutsideDaily daily) {
		this.dailyService.deleteOutsideDaily(daily);
		log.debug("删除车缝领料信息");
		return 1;
	}

	/**
	 * 根据id查询
	 * 
	 * @param odid
	 * @return
	 */
	@RequestMapping("touppOutsideDaily")
	@ResponseBody
	public OutsideDaily toupOutsideDaily(OutsideDaily outsideDaily) {
		OutsideDaily daily = this.dailyService.selectByPrimaryKey(outsideDaily);
		return daily;
	}

	/**
	 * 修改
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("uppOutsideDaily")
	@ResponseBody
	public int uppembroider(OutsideDaily daily) {
		// 总量
		int count = daily.getCode52() + daily.getCode1() + daily.getCode2() + daily.getCode3() + daily.getCode4()
				+ daily.getCode5() + daily.getCode6() + daily.getCode110() + daily.getCode120() + daily.getCode130()
				+ daily.getCode160() + daily.getCode170();
		daily.setTotal(count);
		this.dailyService.updateOutsideDaily(daily);
		log.debug("修改车缝领料信息");
		return 1;
	}

	/**
	 * 模糊查询
	 * 
	 * @param outsideDaily
	 * @param page
	 * @return
	 */
	@RequestMapping("outsideDailyBylike")
	@ResponseBody
	public Map<String, Object> embroiderBylike(OutsideDaily outsideDaily, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.dailyService.getCountByOutsideLike(outsideDaily));// 总共有多少条数据
		// map对象中存的数据
		List<OutsideDaily> dailylist = this.dailyService.OutsideDailyByLike(new OutsideDaily(page.getReqult()[0],
				page.getReqult()[1], outsideDaily.getGirard(), outsideDaily.getCompany())); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", dailylist);
		log.info("查看车缝领料信息");
		return map;
	}

}
