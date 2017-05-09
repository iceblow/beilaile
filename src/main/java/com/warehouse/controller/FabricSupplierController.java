package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricSupplier;
import com.warehouse.service.FabricSupplierService;
import com.warehouse.util.Page;

@Controller
public class FabricSupplierController {
	@Resource
	private FabricSupplierService fabricSupplierService;

	/**
	 * 添加供应商
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping("addFabricSupplier.do")
	@ResponseBody
	public int addFabricSupplier(FabricSupplier fabricSupplier, HttpServletRequest request) {
		int reslut = fabricSupplierService.addFabricSupplier(fabricSupplier,  request);
		return reslut;
	}

	@RequestMapping("findFabricSupplierByAll.do")
	@ResponseBody
	public List<FabricSupplier> findFabricSupplierByAll() {
		List<FabricSupplier> list = fabricSupplierService.findFabricSupplierByAll();
		return list;
	}

	/**
	 * 修改对象
	 *
	 * @param FabricSupplier
	 * @return
	 */
	@RequestMapping(value = "updateFabricSupplier.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateFabricSupplier(FabricSupplier FabricSupplier, HttpServletRequest request) {
		int result = fabricSupplierService.modifyFabricSupplier(FabricSupplier, request);
		return result;
	}

	/**
	 * 根据条件获取增总条数
	 *
	 * @param anyValue
	 * @return
	 */
	@RequestMapping(value = "getFabricSupplierByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FabricSupplier> getFabricSupplierByPageCount(@RequestParam Map<String, Object> anyValue) {
		int result = fabricSupplierService.getFabricSupplierByPageCount(anyValue);
		Page<FabricSupplier> page = new Page<FabricSupplier>(result, 1);
		return page;
	}

	/**
	 * 根据条件获取分页查询
	 *
	 * @param anyValue
	 * @return
	 */
	@RequestMapping(value = "findConditionFabricSupplierByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricSupplier> findConditionFabricSupplierByPage(@RequestParam Map<String, Object> anyValue) {
		int pageNow = Integer.parseInt(anyValue.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyValue.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyValue.put("pageNow", pageNow);
		anyValue.put("pageSize", pageSize);
		List<FabricSupplier> list = fabricSupplierService.findConditionFabricSupplierByPage(anyValue);
		return list;
	}

	/**
	 * 根据id获取对象
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findFabricSupplierById.do", method = RequestMethod.POST)
	@ResponseBody
	public FabricSupplier findFabricSupplierById(Integer id) {
		FabricSupplier FabricSupplier = fabricSupplierService.findFabricSupplierById(id);
		return FabricSupplier;
	}
}
