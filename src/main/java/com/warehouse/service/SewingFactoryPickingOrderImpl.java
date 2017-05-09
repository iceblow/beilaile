package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SewingFactoryPickingOrderMapper;
import com.warehouse.entity.SewingFactoryPickingOrder;

@Service
public class SewingFactoryPickingOrderImpl implements SewingFactoryPickingOrderService {

	@Resource
	private SewingFactoryPickingOrderMapper sewingFactoryPickingOrdermapper;
	// 设置时间格式
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");

	/**
	 * 分页查询
	 */
	@Override
	public int getCountBySewingFactory(SewingFactoryPickingOrder record) {
		int count = this.sewingFactoryPickingOrdermapper.getCountBySewingFactory(record);
		return count;
	}

	@Override
	public List<SewingFactoryPickingOrder> selectByPrimaryKey(SewingFactoryPickingOrder record) {
		List<SewingFactoryPickingOrder> orders = this.sewingFactoryPickingOrdermapper.selectByPrimaryKey(record);
		return orders;
	}

	/**
	 * 删除
	 */
	@Override
	public int updateByPrimaryKeySelective(SewingFactoryPickingOrder record) {
		record.setDelTime(sdf.format(new Date()));
		int result = this.sewingFactoryPickingOrdermapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 根据订单号查询
	 */
	@Override
	public List<SewingFactoryPickingOrder> factoryPickingOrders(Integer orderId) {
		List<SewingFactoryPickingOrder> orders = this.sewingFactoryPickingOrdermapper.selSewingFactory(orderId);
		return orders;
	}

}
