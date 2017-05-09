package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.InventoryFabricSingleDetailsMapper;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.InventoryFabricSingleDetails;
import com.warehouse.util.ClientIpUtil;

@Service
public class InventoryFabricSingleDetailsServiceImpl implements InventoryFabricSingleDetailsService {
	private Logger logger = LoggerFactory.getLogger(InventoryFabricSingleDetailsServiceImpl.class);

	@Resource
	private InventoryFabricSingleDetailsMapper inventoryFabricSingleDetailsMapper;
	@Resource
	public FabricLibraryService fabricLibraryService;

	@Override
	public int getInventoryFabricSingleDetailsByPageCount(Map<String, Object> anyVal) {
		return inventoryFabricSingleDetailsMapper.getInventoryFabricSingleDetailsByPageCount(anyVal);
	}

	@Override
	public List<InventoryFabricSingleDetails> findConditionInventoryFabricSingleDetailsByPage(
			Map<String, Object> anyVal) {
		return inventoryFabricSingleDetailsMapper.findConditionInventoryFabricSingleDetailsByPage(anyVal);
	}

	@Override
	public int addInventoryFabricSingleDetails(InventoryFabricSingleDetails inventoryFabricSingleDetails,
			HttpServletRequest request) {
		FabricLibrary fabricLibrary = fabricLibraryService
				.findFabricLibraryByFabricLibraryCode(inventoryFabricSingleDetails.getFabricCode());
		inventoryFabricSingleDetails.setFabricName(fabricLibrary.getFabricName());
		inventoryFabricSingleDetails.setSupplierName(fabricLibrary.getSupplierName());
		inventoryFabricSingleDetails.setFabricColor(fabricLibrary.getColorName());
		inventoryFabricSingleDetails.setDataStatus(1);
		int result = inventoryFabricSingleDetailsMapper.addInventoryFabricSingleDetails(inventoryFabricSingleDetails);
		logger.debug(" 成功添加编号:" + inventoryFabricSingleDetails.getFabricCode() + "操作者ip为:"
				+ ClientIpUtil.getIpAddress(request));
		return result;
	}

}
