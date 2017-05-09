package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SewingPickingOrderMapper;
import com.warehouse.entity.SewingPickingOrder;

@Service
public class SewingPickingOrderImpl implements SewingPickingOrderService {

	@Resource
	private SewingPickingOrderMapper sewimgPickingOrdermapper;
	// 设置时间格式
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");

	/**
	 * 新增车缝工厂
	 */
	@Override
	public int insertSelective(SewingPickingOrder record) {
		record.setAddTime(sdf.format(new Date()));
		record.setOrderStatus("1");
		int flag = this.sewimgPickingOrdermapper.insertSelective(record);
		return flag;
	}

	/**
	 * 分页查询
	 */
	@Override
	public int getCountBySewing(SewingPickingOrder record) {
		int count = this.sewimgPickingOrdermapper.getCountBySewing(record);
		return count;
	}

	@Override
	public List<SewingPickingOrder> selectByPrimaryKey(SewingPickingOrder record) {
		List<SewingPickingOrder> lists = this.sewimgPickingOrdermapper.selectByPrimaryKey(record);
		return lists;
	}

	/**
	 * 修改信息
	 */
	@Override
	public int updateByPrimaryKeySelective(SewingPickingOrder record) {
		int result = this.sewimgPickingOrdermapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 根据订单号查询
	 */
	@Override
	public SewingPickingOrder selSewingByOrderId(Integer orderId) {
		SewingPickingOrder order = this.sewimgPickingOrdermapper.selSewingByOrderId(orderId);
		return order;
	}

	@Override
	public List<SewingPickingOrder> listSewingPickingOrderAll() {
		List<SewingPickingOrder> order = sewimgPickingOrdermapper.listSewingPickingOrderAll();
		return order;
	}

}
