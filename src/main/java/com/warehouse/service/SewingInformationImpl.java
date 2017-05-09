package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SewingInformationMapper;
import com.warehouse.entity.SewingInformation;

@Service
public class SewingInformationImpl implements SewingInformationService {

	@Resource
	private SewingInformationMapper sewingInformationmapper;
	// 设置时间格式
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

	/**
	 * 分页查询
	 */
	@Override
	public int getCountBySewingInformation(SewingInformation record) {
		int count = this.sewingInformationmapper.getCountBySewingInformation(record);
		return count;
	}

	@Override
	public List<SewingInformation> selectByPrimaryKey(SewingInformation record) {
		List<SewingInformation> informations = this.sewingInformationmapper.selectByPrimaryKey(record);
		return informations;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(SewingInformation record) {
		record.setDeliveryTime(sdf.format(new Date()));
		int result = this.sewingInformationmapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 根据定单号查询
	 */
	@Override
	public List<SewingInformation> selInformation(Integer OrderId) {
		List<SewingInformation> informations = this.sewingInformationmapper.selInformation(OrderId);
		return informations;
	}

}
