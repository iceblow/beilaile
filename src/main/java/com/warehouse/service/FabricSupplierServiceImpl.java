package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricSupplierMapper;
import com.warehouse.entity.FabricSupplier;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class FabricSupplierServiceImpl implements FabricSupplierService {
	private Logger logger = LoggerFactory.getLogger(FabricSupplierServiceImpl.class);

	@Resource
	public FabricSupplierMapper fabricSupplierMapper;

	@Override
	public int addFabricSupplier(FabricSupplier fabricSupplier, HttpServletRequest request) {
		fabricSupplier.setAddNumber(DateUtils.formateYearAndMonthAndSecond(new Date()));
		Integer Code = fabricSupplierMapper.findFabricSupplierByMaxCode() == null ? 0
				: fabricSupplierMapper.findFabricSupplierByMaxCode();
		String supplierCode = "0000" + (Code + 1);
		// supplierCode＝supplierCode.substring(x);截取掉supplierCode从首字母起长度为x的字符串，将剩余字符串赋值给supplierCode
		supplierCode = supplierCode.substring(supplierCode.length() - 4);
		fabricSupplier.setSupplierCode(supplierCode);
		fabricSupplier.setCreateTime(DateUtils.formateDaTime(new Date()));
		fabricSupplier.setSupplierStatus(1);
		int reslut = fabricSupplierMapper.addFabricSupplier(fabricSupplier);
		logger.debug(" 成功添加编号:" + fabricSupplier.getSupplierName() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	@Override
	public List<FabricSupplier> findFabricSupplierByAll() {
		List<FabricSupplier> list = fabricSupplierMapper.findFabricSupplierByAll();
		return list;
	}

	@Override
	public List<FabricSupplier> findFabricSupplierBySupplierName(FabricSupplier fabricSupplier) {
		List<FabricSupplier> list = fabricSupplierMapper.findFabricSupplierBySupplierName(fabricSupplier);
		return list;
	}

	@Override
	public int modifyFabricSupplier(FabricSupplier fabricSupplier, HttpServletRequest request) {
		int reslut = fabricSupplierMapper.modifyFabricSupplier(fabricSupplier);
		logger.debug(" 成功添加编号:" + fabricSupplier.getSupplierName() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	@Override
	public int getFabricSupplierByPageCount(Map<String, Object> anyVal) {
		int reslut = fabricSupplierMapper.getFabricSupplierByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<FabricSupplier> findConditionFabricSupplierByPage(Map<String, Object> anyVal) {
		List<FabricSupplier> list = fabricSupplierMapper.findConditionFabricSupplierByPage(anyVal);
		return list;
	}

	@Override
	public FabricSupplier findFabricSupplierById(Integer id) {
		FabricSupplier fabricSupplier = fabricSupplierMapper.findFabricSupplierById(id);
		return fabricSupplier;
	}

	@Override
	public FabricSupplier findFabricSupplierBySupplierCode(String supplierCode) {
		FabricSupplier fabricSupplier = fabricSupplierMapper.findFabricSupplierBySupplierCode(supplierCode);
		return fabricSupplier;
	}

}
