package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SalesNotSaleHangZhouDAO;
import com.warehouse.entity.SalesNotSaleHangZhou;

@Service
public class SalesNotSaleHangZhouServiceImpl implements SalesNotSaleHangZhouService{

	@Resource
	public SalesNotSaleHangZhouDAO notSaleHangZhouDAO;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式

	@Override
	public int getCountByPage(SalesNotSaleHangZhou notSaleHangZhou) {
		int count = this.notSaleHangZhouDAO.getCountByPage(notSaleHangZhou);
		return count;
	}

	@Override
	public List<SalesNotSaleHangZhou> getDataByPage(SalesNotSaleHangZhou notSaleHangZhou) {
		List<SalesNotSaleHangZhou> storageList = this.notSaleHangZhouDAO.getDataByPage(notSaleHangZhou);
		return storageList;
	}

}
