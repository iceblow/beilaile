package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ProductInfo;

public interface ProductInfoDAO {

	public int getCountByPage(ProductInfo productInfo);
	
	public List<ProductInfo> getDataByPage(ProductInfo productInfo);
	
	public ProductInfo getOne(int id);
	
	public int addProductData(ProductInfo productInfo);

	public int updateData(ProductInfo productInfo);

	public int deleteOne(Integer id);

	public ProductInfo getOneByCodes(String codes);
}
