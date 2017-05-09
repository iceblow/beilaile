package com.warehouse.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SalesSkuOfWdtMapper;
//import com.warehouse.entity.SalesSkuOfWdt;

@Service
public class SalesSkuOfWdtServiceImpl implements SalesSkuOfWdtService {

	@Resource
	private SalesSkuOfWdtMapper salesSkuOfWdtmapper;

	/**
	 * 导入
	 */
	// @Override
	// public int insertSelective(SalesSkuOfWdt record) { int result =
	// salesSkuOfWdtmapper.insertSelective(record); return result; }

	/**
	 * 清空
	 */
	@Override
	public int delSelective() {
		int result = salesSkuOfWdtmapper.delSelective();
		return result;
	}

	@Override
	public int insertSelective(String insert) {
		int result = salesSkuOfWdtmapper.insertSelective(insert);
		return result;
	}

}
