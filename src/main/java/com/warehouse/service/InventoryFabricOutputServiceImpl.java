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

import com.warehouse.dao.InventoryFabricOutputMapper;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.InventoryFabricOutput;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class InventoryFabricOutputServiceImpl implements InventoryFabricOutputService {
	private Logger logger = LoggerFactory.getLogger(InventoryFabricOutputServiceImpl.class);

	@Resource
	public InventoryFabricOutputMapper inventoryFabricOutputMapper;
	@Resource
	public FabricLibraryService fabricLibraryService;

	@Override
	public InventoryFabricOutput findInventoryFabricOutputById(Integer id) {
		return inventoryFabricOutputMapper.findInventoryFabricOutputById(id);
	}

	@Override
	public List<InventoryFabricOutput> findInventoryFabricOutputByFabricCode(String fabricCode) {
		return inventoryFabricOutputMapper.findInventoryFabricOutputByFabricCode(fabricCode);
	}

	@Override
	public int addInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request) {
		FabricLibrary fabricLibrary = fabricLibraryService
				.findFabricLibraryByFabricLibraryCode(inventoryFabricOutput.getFabricCode());
		inventoryFabricOutput.setFabricName(fabricLibrary.getFabricName());
		inventoryFabricOutput.setSupplierName(fabricLibrary.getSupplierName());
		inventoryFabricOutput.setFabricColor(fabricLibrary.getColorName());
		inventoryFabricOutput.setDelStatus(1);
		inventoryFabricOutput.setSid(DateUtils.formateYearAndMonthAndSecond(new Date()));
		inventoryFabricOutput.setCreateTime(DateUtils.formateDaTime(new Date()));
		// 声明,格式化
		DecimalFormat df = new DecimalFormat("00.00");
		// 类型转换
		String str = df.format(inventoryFabricOutput.getFabricWeight());
		// 组装面料条形码 面料编号+面料重量
		inventoryFabricOutput.setFabricBarcode(inventoryFabricOutput.getFabricCode() + str.replace(".", ""));
		int result = inventoryFabricOutputMapper.addInventoryFabricOutput(inventoryFabricOutput);
		logger.debug(
				" 成功添加编号:" + inventoryFabricOutput.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int modifyInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request) {
		int result = inventoryFabricOutputMapper.modifyInventoryFabricOutput(inventoryFabricOutput);
		logger.debug(
				" 成功添加编号:" + inventoryFabricOutput.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int delInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request) {
		int result = inventoryFabricOutputMapper.delInventoryFabricOutput(inventoryFabricOutput);
		logger.debug(
				" 成功添加编号:" + inventoryFabricOutput.getFabricCode() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int getInventoryFabricOutputByPageCount(Map<String, Object> anyVal) {
		return inventoryFabricOutputMapper.getInventoryFabricOutputByPageCount(anyVal);
	}

	@Override
	public List<InventoryFabricOutput> findConditionInventoryFabricOutputByPage(Map<String, Object> anyVal) {
		return inventoryFabricOutputMapper.findConditionInventoryFabricOutputByPage(anyVal);
	}

	@Override
	public int updateInventoryFabricOutputDataStatusById(Integer id, HttpServletRequest request) {
		int result = inventoryFabricOutputMapper.updateInventoryFabricOutputDataStatusById(id);
		logger.debug(" 成功添加编号:" + id + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

}
