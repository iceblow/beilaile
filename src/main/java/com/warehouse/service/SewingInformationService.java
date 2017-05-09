package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.SewingInformation;

public interface SewingInformationService {

	// 分页查询
	int getCountBySewingInformation(SewingInformation record);

	List<SewingInformation> selectByPrimaryKey(SewingInformation record);

	// 修改
	int updateByPrimaryKeySelective(SewingInformation record);

	// 根据订单号查询
	List<SewingInformation> selInformation(Integer OrderId);
}
