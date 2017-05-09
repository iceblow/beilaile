package com.warehouse.service;

import com.warehouse.dao.ManufacturerMapper;
import com.warehouse.entity.Manufacturer;
import com.warehouse.util.DateUtils;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Beilaile on 2017/2/24.
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	@Resource
	private ManufacturerMapper manufacturerMapper;

	@Override
	public int addManufacturer(Manufacturer manufacturer, HttpServletRequest request) {
		manufacturer.setFactoryCode(DateUtils.formateYearAndMonthAndSecond(new Date()));
		manufacturer.setCreateTime(DateUtils.formateDaTime(new Date()));
		manufacturer.setFactoryStatus(1);
		int result = manufacturerMapper.addManufacturer(manufacturer);
		return result;
	}

	@Override
	public int updateManufacturer(Manufacturer manufacturer, HttpServletRequest request) {
		manufacturer.setModifyTime(DateUtils.formateDaTime(new Date()));
		int result = manufacturerMapper.updateManufacturer(manufacturer);
		return result;
	}

	@Override
	public int deleteManufacturer(Manufacturer manufacturer, HttpServletRequest request) {
		manufacturer.setDeleteTime(DateUtils.formateDaTime(new Date()));
		manufacturer.setFactoryStatus(0);
		int result = manufacturerMapper.deleteManufacturer(manufacturer);
		return result;
	}

	@Override
	public int getManufacturerByPageCount(Map<String, Object> anyValue) {
		int result = manufacturerMapper.getManufacturerByPageCount(anyValue);
		return result;
	}

	@Override
	public List<Manufacturer> findConditionManufacturerByPage(Map<String, Object> anyValue) {
		// 当前页
		int pageNow = Integer.parseInt(anyValue.get("pageNow").toString());
		// 每页条数
		int pageSize = Integer.parseInt(anyValue.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyValue.put("pageNow", pageNow);
		anyValue.put("pageSize", pageSize);
		List<Manufacturer> list = manufacturerMapper.findConditionManufacturerByPage(anyValue);
		return list;
	}

	@Override
	public Manufacturer findManufacturerById(@Param("id") Integer id) {
		Manufacturer manufacturer = manufacturerMapper.findManufacturerById(id);
		return manufacturer;
	}

	@Override
	public int getManufacturerByFactoryName(String factoryName) {
		int result = manufacturerMapper.getManufacturerByFactoryName(factoryName);
		return result;
	}

	@Override
	public List<Manufacturer> findManufacturerByAllFactory() {
		List<Manufacturer> list = manufacturerMapper.findManufacturerByAllFactory();
		return list;
	}

	@Override
	public List<Manufacturer> selectAllFactory() {
		List<Manufacturer> list = manufacturerMapper.findManufacturerByAllFactory();
		return list;
	}
}
