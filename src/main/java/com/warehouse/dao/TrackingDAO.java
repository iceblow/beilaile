package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.Tracking;
import com.warehouse.util.Pagess;

public interface TrackingDAO {
	// 查询数据量
	int getAllCount();

	// 分页查询
	List<Tracking> getAllByPage(Pagess page);

	// 添加数据
	void addTrack(Tracking track);

	// 修改数据
	void updateFile(Tracking track);
	
	// 根据id单查询
	Tracking getOne(int id);
	
	//带条件的分页查询数据量
	int getConditionCountByPage(Tracking tracking);
	
	//带条件的分页查询
	List<Tracking> getConditionAllByPage(Tracking tracking);
	
	//删除信息(假删除)
	void del(Integer id);
	
	//双击修改方法
	void dbUpdateTrack(Tracking tracking);
	
	//查询所有订单数量
	Integer getOrderNum(Tracking tracking);

}
