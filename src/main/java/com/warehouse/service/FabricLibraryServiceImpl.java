package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricLibraryMapper;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class FabricLibraryServiceImpl implements FabricLibraryService {
	private Logger logger = LoggerFactory.getLogger(FabricLibraryServiceImpl.class);
	
	@Resource
	public FabricLibraryMapper fabricLibraryMapper;

	@Override
	public int addFabricLibrary(FabricLibrary fabricLibrary, HttpServletRequest request) {
		fabricLibrary.setSupplierCode(fabricLibrary.getSupplierCode());
		fabricLibrary.setColorCardCode(fabricLibrary.getColorCardCode());
		fabricLibrary.setFabricCode(fabricLibrary.getColorCardCode() + fabricLibrary.getColorCode());
		fabricLibrary.setAddNumber(DateUtils.formateYearAndMonthAndSecond(new Date()));
		fabricLibrary.setCreateTime(DateUtils.formateDaTime(new Date()));

		fabricLibrary.setFabricStatus(1);
		int reslut = fabricLibraryMapper.addFabricLibrary(fabricLibrary);
		logger.debug(
				" 成功添加面料编号:" + fabricLibrary.getFabricCode()+ "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		
		return reslut;
	}

	@Override
	public int modifyFabricLibrary(FabricLibrary fabricLibrary, HttpServletRequest request) {
		fabricLibrary.setModifyTime(DateUtils.formateDaTime(new Date()));
		int reslut = fabricLibraryMapper.modifyFabricLibrary(fabricLibrary);
		logger.debug(
				" 成功修改面料编号:" + fabricLibrary.getFabricCode()+ "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		System.out.println("=================");
		return reslut;
	}

	@Override
	public int delFabricLibraryById(FabricLibrary fabricLibrary, HttpServletRequest request) {
		fabricLibrary.setDeleteTime(DateUtils.formateDaTime(new Date()));
		fabricLibrary.setFabricStatus(0);
		int reslut = fabricLibraryMapper.delFabricLibraryById(fabricLibrary);
		logger.debug(
				" 成功删除面料编号:" + fabricLibrary.getFabricCode()+ "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		
		return reslut;
	}

	@Override
	public int getFabricLibraryByPageCount(Map<String, Object> anyVal) {
		int reslut = fabricLibraryMapper.getFabricLibraryByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<FabricLibrary> findConditionFabricLibraryByPage(Map<String, Object> anyVal) {
		List<FabricLibrary> list = fabricLibraryMapper.findConditionFabricLibraryByPage(anyVal);
		return list;
	}

	@Override
	public List<FabricLibrary> findFabricLibraryByAll() {
		List<FabricLibrary> list = fabricLibraryMapper.findFabricLibraryByAll();
		return list;
	}

	@Override
	public int findFabricLibraryBySupplierCode(FabricLibrary fabricLibrary) {
		fabricLibrary.setFabricCode(fabricLibrary.getColorCardCode() + fabricLibrary.getColorCode());
		int reslut = fabricLibraryMapper.findFabricLibraryBySupplierCode(fabricLibrary);
		return reslut;
	}

	@Override
	public FabricLibrary findFabricLibraryById(Integer id) {
		FabricLibrary FabricLibrary = fabricLibraryMapper.findFabricLibraryById(id);
		return FabricLibrary;
	}

	@Override
	public FabricLibrary findFabricLibraryByFabricLibraryCode(String fabricCode) {
		FabricLibrary FabricLibrary = fabricLibraryMapper.findFabricLibraryByFabricLibraryCode(fabricCode);
		return FabricLibrary;
	}
}
