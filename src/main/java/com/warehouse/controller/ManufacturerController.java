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

import com.warehouse.entity.Manufacturer;
import com.warehouse.service.ManufacturerService;
import com.warehouse.util.Page;

/**
 * Created by Beilaile on 2017/2/24.
 */
@Controller
public class ManufacturerController {
	@Resource
	private ManufacturerService manufacturerService;

	/**
	 * 添加对象
	 *
	 * @param manufacturer
	 * @return
	 */
	@RequestMapping(value = "addManufacturer.do", method = RequestMethod.POST)
	@ResponseBody
	public int addManufacturer(Manufacturer manufacturer, HttpServletRequest request) {
		int reslut = manufacturerService.getManufacturerByFactoryName(manufacturer.getFactoryName());
		if (reslut > 0) {
			return 18;
		} else {
			int result = manufacturerService.addManufacturer(manufacturer, request);
			return result;
		}
	}

	/**
	 * 修改对象
	 *
	 * @param manufacturer
	 * @return
	 */
	@RequestMapping(value = "updateManufacturer.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateManufacturer(Manufacturer manufacturer, HttpServletRequest request) {
		int result = manufacturerService.updateManufacturer(manufacturer, request);
		return result;
	}

	/**
	 * 删除对象
	 *
	 * @param manufacturer
	 * @return
	 */
	@RequestMapping(value = "deleteManufacturer.do", method = RequestMethod.POST)
	@ResponseBody
	public int deleteManufacturer(Manufacturer manufacturer, HttpServletRequest request) {
		int result = manufacturerService.deleteManufacturer(manufacturer, request);
		return result;
	}

	/**
	 * 根据条件获取增总条数
	 *
	 * @param anyValue
	 * @return
	 */
	@RequestMapping(value = "getManufacturerByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<Manufacturer> getManufacturerByPageCount(@RequestParam Map<String, Object> anyValue) {
		int result = manufacturerService.getManufacturerByPageCount(anyValue);
		Page<Manufacturer> page = new Page<Manufacturer>(result, 1);
		return page;
	}

	/**
	 * 根据条件获取分页查询
	 *
	 * @param anyValue
	 * @return
	 */
	@RequestMapping(value = "findConditionManufacturerByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Manufacturer> findConditionManufacturerByPage(@RequestParam Map<String, Object> anyValue) {

		List<Manufacturer> list = manufacturerService.findConditionManufacturerByPage(anyValue);
		return list;
	}

	/**
	 * 根据id获取对象
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findManufacturerById.do", method = RequestMethod.POST)
	@ResponseBody
	public Manufacturer findManufacturerById(Integer id) {
		Manufacturer manufacturer = manufacturerService.findManufacturerById(id);
		return manufacturer;
	}
	
	/**
	 * 根据id获取对象
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "selectAllFactory.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Manufacturer> selectAllFactory() {
		List<Manufacturer> list= manufacturerService.selectAllFactory();
		for(int a=0;a<list.size();a++){
			list.get(a).getFactoryName();
			System.err.println(list.get(a).getFactoryName());
		}
		return list;
	}
}
