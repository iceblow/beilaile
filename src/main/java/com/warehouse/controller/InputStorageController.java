package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.InputStorage;
import com.warehouse.service.InputstorageService;
import com.warehouse.service.ProductInfoService;
import com.warehouse.util.BarCodeUtils;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("inputstorage")
public class InputStorageController {

	@Resource
	private InputstorageService inputstorageService;
	@Resource
	private ProductInfoService productInfoService;

	private Logger log = LoggerFactory.getLogger(InputStorageController.class);

	/**
	 * 添加
	 * 
	 * @param inputstorage
	 * @return
	 */
	@RequestMapping("addInputstorage")
	@ResponseBody
	public int addembroider(InputStorage inputstorage) {
		int flag = 0;
		// 总量
		Integer count = inputstorage.getCode59() + inputstorage.getCode66() + inputstorage.getCode73()
				+ inputstorage.getCode80() + inputstorage.getCode90() + inputstorage.getCode100()
				+ inputstorage.getCode110() + inputstorage.getCode120() + inputstorage.getCode130()
				+ inputstorage.getCode160() + inputstorage.getCode170();
		inputstorage.setTotal(count);
		flag = this.inputstorageService.insertInputstorage(inputstorage);
		log.debug("添加成品入库信息");
		return flag;
	}

	/**
	 * 删除
	 * 
	 * @param inputstorage
	 * @return
	 */
	@RequestMapping("delInputstorage")
	@ResponseBody
	public int delembroider(InputStorage inputstorage) {
		int flag = 0;
		flag = this.inputstorageService.deleteInputstorage(inputstorage);
		log.debug("删除成品入库信息");
		return flag;
	}

	/**
	 * 修改前查询
	 * 
	 * @param sid
	 * @return
	 */
	@RequestMapping("touppInputstorageById")
	@ResponseBody
	public InputStorage touppInputStorage(Integer sid) {
		InputStorage storage = this.inputstorageService.selectByPrimaryKey(sid);
		return storage;
	}

	/**
	 * 修改
	 * 
	 * @param inputstorage
	 * @return
	 */
	@RequestMapping("uppInputstorage")
	@ResponseBody
	public int uppembroider(InputStorage inputstorage) {
		int flag = 0;
		// 总量
		int count = inputstorage.getCode59() + inputstorage.getCode66() + inputstorage.getCode73()
				+ inputstorage.getCode80() + inputstorage.getCode90() + inputstorage.getCode100()
				+ inputstorage.getCode110() + inputstorage.getCode120() + inputstorage.getCode130()
				+ inputstorage.getCode160() + inputstorage.getCode170();
		inputstorage.setTotal(count);
		flag = this.inputstorageService.updateInputstorage(inputstorage);
		log.debug("修改成品入库信息");
		return flag;
	}

	/**
	 * 模糊查询
	 * 
	 * @param inputstorage
	 * @param page
	 * @return
	 */
	@RequestMapping("InputstorageBylike")
	@ResponseBody
	public Map<String, Object> embroiderBylike(InputStorage inputstorage, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.inputstorageService.getCountByOutsideLike(inputstorage));// 总共有多少条数据
		// map对象中存的数据
		List<InputStorage> inputstoragelist = this.inputstorageService
				.InputstorageByLike((new InputStorage(page.getReqult()[0], page.getReqult()[1],
						inputstorage.getGirard(), inputstorage.getFactory(), inputstorage.getCommoditycCode()))); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", inputstoragelist);
		log.info("查看成品入库信息");
		return map;
	}

	/**
	 * 查询打印次数
	 * 
	 * @param inputstorage
	 * @param sid
	 * @param girard
	 * @param sdate
	 * @param factory
	 * @param commoditycCode
	 * @param productShortName
	 * @param code
	 * @param num
	 * @param request
	 * @param num
	 * @return
	 */
	@RequestMapping("selTotalById")
	@ResponseBody
	public int selTotalById(InputStorage inputstorage, Integer sid, String girard, String sdate, String factory,
			String commoditycCode, String productShortName, String code, int num, HttpServletRequest request) {
		int flag = 0;
		// 查询该编码的个数
		if (num == 0) {
			flag = this.inputstorageService.selectTotalByPrimaryKey(sid, "code" + code) + 5;
		} else {
			flag = num;
		}
		// 生成条码图片的方法
		BarCodeUtils.barCode(inputstorage, girard, sdate, factory, commoditycCode, productShortName, code, request);
		inputstorageService.updateInputstorage(inputstorage);// 修改
		log.debug("打印条码！！");
		return flag;
	}

}
