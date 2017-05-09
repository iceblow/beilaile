package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.ProductTaoBaoInfo;
import com.warehouse.util.PageUtil;

public interface ProductTaoBaoInfoService {

	/**
	 * 查看淘宝平台信息(分页)
	 * @param page(分页信息)
	 * @param taoBaoInfo(查询条件信息)
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil page, ProductTaoBaoInfo taoBaoInfo);

}
