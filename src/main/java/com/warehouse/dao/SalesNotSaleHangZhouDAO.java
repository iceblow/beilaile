package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.SalesNotSaleHangZhou;

public interface SalesNotSaleHangZhouDAO {

	int getCountByPage(SalesNotSaleHangZhou notSaleHangZhou);

	List<SalesNotSaleHangZhou> getDataByPage(SalesNotSaleHangZhou notSaleHangZhou);

}