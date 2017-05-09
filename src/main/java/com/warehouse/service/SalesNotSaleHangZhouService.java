package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.SalesNotSaleHangZhou;

public interface SalesNotSaleHangZhouService {

	// 模糊查询
	int getCountByPage(SalesNotSaleHangZhou notSaleHangZhou);

	List<SalesNotSaleHangZhou> getDataByPage(SalesNotSaleHangZhou notSaleHangZhou);

}
