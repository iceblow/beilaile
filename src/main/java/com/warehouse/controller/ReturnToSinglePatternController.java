package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.warehouse.entity.ReturnToSinglePattern;
import com.warehouse.service.ReturnToSinglePatternService;
import com.warehouse.util.PageUtil;

/**
 * 返单样衣控制器
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("returnToSinglePattern")
public class ReturnToSinglePatternController {

	@Resource
	private ReturnToSinglePatternService returnToSinglePatternService;

	/**
	 * 分页查询控制器
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil, ReturnToSinglePattern returnToSinglePattern) {
		// 写入每页显示数据量
		pageUtil.setPageSize(15);
		// 写入数据总条数(计算分页信息)
		pageUtil.setTotolCount(this.returnToSinglePatternService.getCount(returnToSinglePattern));
		// 得到分页显示的数据
		List<ReturnToSinglePattern> dataList = this.returnToSinglePatternService.getDataByPage(
				new ReturnToSinglePattern(pageUtil.getReqult()[0], pageUtil.getReqult()[1], returnToSinglePattern));
		//前台接收数据
		Map<String, Object> map=new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		return map;
	}

	/**
	 * 需要样衣控制器
	 */
	@RequestMapping("needToBeSampleCloth")
	@ResponseBody
	public int needToBeSampleCloth(int id){
		return this.returnToSinglePatternService.needToBeSampleCloth(id);
	}
	
	/**
	 * 纸样完成控制器
	 */
	@RequestMapping("pieceSampleComplete")
	@ResponseBody
	public int pieceSampleComplete(int id){
		return this.returnToSinglePatternService.pieceSampleComplete(id);
	}
}
