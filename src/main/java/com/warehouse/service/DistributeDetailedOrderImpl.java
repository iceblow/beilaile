package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.DistributeDetailedOrderMapper;
import com.warehouse.entity.DistributeDetailedOrder;

@Service
public class DistributeDetailedOrderImpl implements DistributeDetailedOrderService {

	@Resource
	private DistributeDetailedOrderMapper distributeDetailedOrdermapper;

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

	/**
	 * 分页
	 */
	@Override
	public int selectByCount(DistributeDetailedOrder record) {
		int count = this.distributeDetailedOrdermapper.selectByCount(record);
		return count;
	}

	@Override
	public List<DistributeDetailedOrder> selectByPage(DistributeDetailedOrder record) {
		List<DistributeDetailedOrder> distributeDetailedOrders = this.distributeDetailedOrdermapper
				.selectByPage(record);
		return distributeDetailedOrders;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(DistributeDetailedOrder record) {
		record.setUpdateTime(sdf.format(new Date()));
		int flag = this.distributeDetailedOrdermapper.updateByPrimaryKeySelective(record);
		return flag;
	}

	/**
	 * 添加
	 */
	@Override
	public int insertSelective(DistributeDetailedOrder record) {
		record.setAddTime(sdf.format(new Date()));
		int flag = this.distributeDetailedOrdermapper.insertSelective(record);
		return flag;
	}

	/**
	 * 删除
	 */
	@Override
	public int delDistributeDetailedOrder(DistributeDetailedOrder record) {
		int flag = this.distributeDetailedOrdermapper.delDistributeDetailedOrder(record);
		return flag;
	}

	@Override
	public List<DistributeDetailedOrder> selectByorderId(Integer orderId) {
		List<DistributeDetailedOrder> orders = this.distributeDetailedOrdermapper.selectByorderId(orderId);
		return orders;
	}

}
