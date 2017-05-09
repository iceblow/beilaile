package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ProductInfo;

public interface ProductInfoService {
	
	int getCountByPage(ProductInfo productInfo);//查询数据量

	List<ProductInfo> getDataByPage(ProductInfo productInfo);//分页查询数据

	int addData(ProductInfo productInfo);//添加数据

	ProductInfo getOne(Integer id);

	int updateData(ProductInfo productInfo);

	int deleteOne(Integer id);
	/**
	 * 根据商品编号获取商品详情
	 * @param codes
	 * @return
	 */
	ProductInfo getOneByCodes(String codes);

}