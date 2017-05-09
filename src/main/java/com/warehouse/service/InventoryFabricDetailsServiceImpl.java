package com.warehouse.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.warehouse.controller.BuildProgressController;
import com.warehouse.dao.InventoryFabricDetailsMapper;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.InventoryFabricDetails;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

/**
 * Created by Beilaile on 2017/4/3.
 */
@Service
public class InventoryFabricDetailsServiceImpl implements InventoryFabricDetailsService {
	private Logger logger = LoggerFactory.getLogger(InventoryFabricDetailsServiceImpl.class);

	@Resource
	public InventoryFabricDetailsMapper inventoryFabricDetailsMapper;
	@Resource
	public FabricLibraryService fabricLibraryService;

	@Override
	public Integer addInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails,
			HttpServletRequest request) {

		FabricLibrary fabricLibrary = fabricLibraryService
				.findFabricLibraryByFabricLibraryCode(inventoryFabricDetails.getFabricCode());
		inventoryFabricDetails.setFabricName(fabricLibrary.getFabricName());
		inventoryFabricDetails.setSupplierName(fabricLibrary.getSupplierName());
		inventoryFabricDetails.setFabricColor(fabricLibrary.getColorName());
		inventoryFabricDetails.setDataStatus(1);
		inventoryFabricDetails.setCreateTime(DateUtils.formateDaTime(new Date()));
		// 声明,格式化
		DecimalFormat df = new DecimalFormat("00.00");
		// 类型转换
		String str = df.format(inventoryFabricDetails.getFabricWeight());
		// 组装面料条形码 面料编号+面料重量
		inventoryFabricDetails.setFabricBarcode(inventoryFabricDetails.getFabricCode() + str.replace(".", ""));
		int result = inventoryFabricDetailsMapper.addInventoryFabricDetails(inventoryFabricDetails);
		logger.debug(
				" 成功添加面料编号:" + inventoryFabricDetails.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public Integer modifyInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails,
			HttpServletRequest request) {
		inventoryFabricDetails.setModifyTime(DateUtils.formateDaTime(new Date()));
		int result = inventoryFabricDetailsMapper.modifyInventoryFabricDetails(inventoryFabricDetails);
		logger.debug(
				" 成功修改面料编号:" + inventoryFabricDetails.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public Integer delInventoryFabricDetails(InventoryFabricDetails inventoryFabricDetails,
			HttpServletRequest request) {
		inventoryFabricDetails.setDataStatus(0);
		inventoryFabricDetails.setDeleteTime(DateUtils.formateDaTime(new Date()));
		return inventoryFabricDetailsMapper.delInventoryFabricDetails(inventoryFabricDetails);
	}

	@Override
	public Integer getInventoryFabricDetailsByPageCount(Map<String, Object> anyVal) {
		int reslut = inventoryFabricDetailsMapper.getInventoryFabricDetailsByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<InventoryFabricDetails> findConditionInventoryFabricDetailsByPage(
			@RequestParam Map<String, Object> anyVal) {

		return inventoryFabricDetailsMapper.findConditionInventoryFabricDetailsByPage(anyVal);
	}

	@Override
	public InventoryFabricDetails findInventoryFabricDetailsById(Integer id) {
		return inventoryFabricDetailsMapper.findInventoryFabricDetailsById(id);
	}

	@Override
	public InventoryFabricDetails findInventoryFabricDetailsByFabricCode(String fabricCode) {
		return inventoryFabricDetailsMapper.findInventoryFabricDetailsByFabricCode(fabricCode);
	}
}
