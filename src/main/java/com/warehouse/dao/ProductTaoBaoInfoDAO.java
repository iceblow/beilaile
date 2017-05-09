package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ProductTaoBaoInfo;

public interface ProductTaoBaoInfoDAO {
	/**
	 * 获取数据量
	 * 
	 * @param taoBaoInfo
	 * @return
	 */
	int getCountByPage(ProductTaoBaoInfo taoBaoInfo);

	/**
	 * 获取分页数据
	 * 
	 * @param taoBaoInfo
	 * @return
	 */
	List<ProductTaoBaoInfo> getDataByPage(ProductTaoBaoInfo taoBaoInfo);

}
