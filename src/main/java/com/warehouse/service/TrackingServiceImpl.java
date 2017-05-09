package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.TrackingDAO;
import com.warehouse.entity.Tracking;
import com.warehouse.util.Pagess;

@Service
public class TrackingServiceImpl implements TrackingService {

	@Autowired
	private TrackingDAO trackingDAO;
	
	//得到总的数据量
	@Override
	public int getAllCount() {
		return trackingDAO.getAllCount();
	}
	//分页查询
	@Override
	public List<Tracking> getAllByPage(Pagess page) {
		return this.trackingDAO.getAllByPage(page);
	}
	//添加数据
	@Override
	public void addTrack(Tracking track) {
		this.trackingDAO.addTrack(track);
	}
	//删除数据(暂未使用)
	@Override
	public void del(Integer id) {
		this.trackingDAO.del(id);
	}
	//修改数据
	@Override
	public void updateTrack(Tracking track) {
		this.trackingDAO.updateFile(track);
	}
	//根据id单查询
	@Override
	public Tracking getOne(int id) {
		return this.trackingDAO.getOne(id);
	}
	@Override
	public int getConditionCountByPage(Tracking tracking) {
		return this.trackingDAO.getConditionCountByPage(tracking);
	}
	@Override
	public List<Tracking> getConditionAllByPage(Tracking tracking) {
		return this.trackingDAO.getConditionAllByPage(tracking);
	}
	@Override
	public void dbUpdateTrack(Tracking tracking) {
		this.trackingDAO.dbUpdateTrack(tracking);
	}
	@Override
	public Integer getOrderNum(Tracking tracking) {
		return this.trackingDAO.getOrderNum(tracking);
	}

}
