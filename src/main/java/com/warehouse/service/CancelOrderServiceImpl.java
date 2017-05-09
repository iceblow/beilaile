package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.CancelOrderMapper;
import com.warehouse.entity.CancelOrder;

@Service
public class CancelOrderServiceImpl implements CancelOrderService {

	@Resource
	private CancelOrderMapper cancelOrderMapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");// 设置时间格式

	/***
	 * 恢复订单
	 */
	@Override
	public int deleteByPrimaryKey(CancelOrder record) {
		record.setRestoreOrder(sd.format(new Date()));
		record.setRestoreTime(sdf.format(new Date()));
		record.setStatus("1");
		int flag = this.cancelOrderMapper.deleteByPrimaryKey(record);
		return flag;
	}

	/**
	 * 删除订单
	 */
	@Override
	public int insertSelective(CancelOrder record) {
		record.setDelOrder(sd.format(new Date()));
		record.setAddTime(sdf.format(new Date()));
		record.setStatus("0");
		int flag = this.cancelOrderMapper.insertSelective(record);
		return flag;
	}

	/**
	 * 分页查询
	 */
	@Override
	public int selByPrimaryKeyCount(CancelOrder record) {
		int count = this.cancelOrderMapper.selByPrimaryKeyCount(record);
		return count;
	}

	@Override
	public List<CancelOrder> selByPrimaryKeyPage(CancelOrder record) {
		List<CancelOrder> cancelOrders = this.cancelOrderMapper.selByPrimaryKeyPage(record);
		return cancelOrders;
	}
}
