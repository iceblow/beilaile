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

import com.warehouse.dao.InventoryFabricStorageMapper;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.InventoryFabricStorage;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class InventoryFabricStorageServiceImpl implements InventoryFabricStorageService {
	private Logger logger = LoggerFactory.getLogger(InventoryFabricSingleDetailsServiceImpl.class);

	@Resource
	public InventoryFabricStorageMapper inventoryFabricStorageMapper;
	@Resource
	public FabricLibraryService fabricLibraryService;

	@Override
	public InventoryFabricStorage findInventoryFabricStorageById(Integer id) {
		return inventoryFabricStorageMapper.findInventoryFabricStorageById(id);
	}

	@Override
	public List<InventoryFabricStorage> findInventoryFabricStorageByFabricCode(String fabricCode) {
		return inventoryFabricStorageMapper.findInventoryFabricStorageByFabricCode(fabricCode);
	}

	@Override
	public int addInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request) {

		FabricLibrary fabricLibrary = fabricLibraryService
				.findFabricLibraryByFabricLibraryCode(inventoryFabricStorage.getFabricCode());
		inventoryFabricStorage.setFabricName(fabricLibrary.getFabricName());
		inventoryFabricStorage.setSupplierName(fabricLibrary.getSupplierName());
		inventoryFabricStorage.setFabricColor(fabricLibrary.getColorName());
		inventoryFabricStorage.setCreateTime(DateUtils.formateDaTime(new Date()));
		inventoryFabricStorage.setDelStatus(1);
		inventoryFabricStorage.setSid(DateUtils.formateYearAndMonthAndSecond(new Date()));
		// 声明,格式化
		DecimalFormat df = new DecimalFormat("00.00");
		// 类型转换
		String str = df.format(inventoryFabricStorage.getFabricWeight());
		// 组装面料条形码 面料编号+面料重量
		inventoryFabricStorage.setFabricBarcode(inventoryFabricStorage.getFabricCode() + str.replace(".", ""));

		int result = inventoryFabricStorageMapper.addInventoryFabricStorage(inventoryFabricStorage);
		logger.debug(
				" 成功添加编号:" + inventoryFabricStorage.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int modifyInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request) {
		inventoryFabricStorage.setModifyTime(DateUtils.formateDaTime(new Date()));
		int result = inventoryFabricStorageMapper.modifyInventoryFabricStorage(inventoryFabricStorage);
		logger.debug(
				" 成功添加编号:" + inventoryFabricStorage.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int delInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request) {
		int result = inventoryFabricStorageMapper.delInventoryFabricStorage(inventoryFabricStorage);
		logger.debug(
				" 成功添加编号:" + inventoryFabricStorage.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int getInventoryFabricStorageByPageCount(Map<String, Object> anyVal) {
		return inventoryFabricStorageMapper.getInventoryFabricStorageByPageCount(anyVal);
	}

	@Override
	public List<InventoryFabricStorage> findConditionInventoryFabricStorageByPage(Map<String, Object> anyVal) {
		return inventoryFabricStorageMapper.findConditionInventoryFabricStorageByPage(anyVal);
	}

	@Override
	public int updateInventoryFabricStorageDataStatusById(Integer id, HttpServletRequest request) {
		int result = inventoryFabricStorageMapper.updateInventoryFabricStorageDataStatusById(id);
		logger.debug(" 成功添加编号:" + id + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

}
