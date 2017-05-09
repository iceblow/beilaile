package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.Tracking;
import com.warehouse.util.Pagess;

public interface TrackingService {
	
	/**
	 * 查詢數據量
	 * @return
	 */
	int getAllCount();
	/**
	 * 分頁查詢
	 * @param pagess
	 * @return
	 */
	List<Tracking> getAllByPage(Pagess pagess);
	/**
	 * 添加理單跟蹤表
	 * @param track
	 */
	void addTrack(Tracking track);
	/**
	 * 刪除信息
	 * @param id
	 */
	void del(Integer id);
	/**
	 * 修改方法
	 * @param track
	 */
	void updateTrack(Tracking track);
	/**
	 * 根据id查询理单跟踪数据
	 * @param id
	 * @return
	 */
	Tracking getOne(int id);
	/**
	 * 带条件的分页查询数据量
	 * @param tracking
	 * @return
	 */
	int getConditionCountByPage(Tracking tracking);
	/**
	 * 带条件的分页查询
	 * @param tracking
	 * @return
	 */
	List<Tracking> getConditionAllByPage(Tracking tracking);
	/**
	 * 双击修改方法
	 * @param tracking
	 */
	void dbUpdateTrack(Tracking tracking);
	/**
	 * 查询订单总数
	 * @param tracking
	 * @return
	 */
	Integer getOrderNum(Tracking tracking);

}
