package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PurchaseOrdersDetail;

public interface PurchaseOrdersDetailDAO {

	/**
	 * 得到数据量
	 * 
	 * @param purchaseOrdersDetail
	 * @return
	 */
	public int getCountByPage(PurchaseOrdersDetail purchaseOrdersDetail);

	/**
	 * 得到分页数据
	 * 
	 * @param purchaseOrdersDetail
	 * @return
	 */
	public List<PurchaseOrdersDetail> getDataByPage(PurchaseOrdersDetail purchaseOrdersDetail);

	/**
	 * 根据编码得到数据
	 * 
	 * @param orderCode
	 * @return
	 */
	public PurchaseOrdersDetail getDataById(Integer orderCode);

}
