package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ProductInfo;

public interface ProductOrderService {
	
	/**
	 * 查询数据量
	 * @param productInfo
	 * @return
	 */
	int getCountByPage(ProductInfo productInfo);

	/**
	 * 数据分页查询
	 * @param productInfo
	 * @return
	 */
	List<ProductInfo> getDataByPage(ProductInfo productInfo);
	
	/**
	 * 根据编号查询某个商品信息
	 * @param id
	 * @return
	 */
	ProductInfo getOne(Integer id);

}
