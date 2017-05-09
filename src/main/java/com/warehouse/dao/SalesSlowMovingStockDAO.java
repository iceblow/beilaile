package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.SalesSlowMovingStock;

public interface SalesSlowMovingStockDAO {

	public int getCountByPage(SalesSlowMovingStock salesSlowMovingStock);

	public List<SalesSlowMovingStock> getDataByPage(SalesSlowMovingStock salesSlowMovingStock);

}
