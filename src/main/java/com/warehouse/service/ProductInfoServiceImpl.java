package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProductInfoDAO;
import com.warehouse.entity.ProductInfo;

@Service
public class ProductInfoServiceImpl implements ProductInfoService, ProductOrderService {

	@Resource
	private ProductInfoDAO productInfoDAO;

	@Override
	public int getCountByPage(ProductInfo productInfo) {
		return this.productInfoDAO.getCountByPage(productInfo);
	}

	@Override
	public List<ProductInfo> getDataByPage(ProductInfo productInfo) {
		return this.productInfoDAO.getDataByPage(productInfo);
	}

	@Override
	public int addData(ProductInfo productInfo) {
		return this.productInfoDAO.addProductData(productInfo);
	}

	@Override
	public ProductInfo getOne(Integer id) {
		return this.productInfoDAO.getOne(id);
	}

	@Override
	public int updateData(ProductInfo productInfo) {
		return this.productInfoDAO.updateData(productInfo);
	}

	@Override
	public int deleteOne(Integer id) {
		return this.productInfoDAO.deleteOne(id);
	}

	@Override
	public ProductInfo getOneByCodes(String codes) {
		return this.productInfoDAO.getOneByCodes(codes);
	}

}
