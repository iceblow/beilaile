package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.QCDAO;
import com.warehouse.entity.QCTrack;
import com.warehouse.util.CaoUtil;
import com.warehouse.util.Pagess;

@Service
public class QCServiceImpl implements QCService {

	@Autowired
	private QCDAO qcDAO;
	//得到总的数据量
	@Override
	public int getAllCount() {
		return this.qcDAO.getAllCount();
	}
	//分页查询
	@Override
	public List<QCTrack> getAllByPage(Pagess pagess) {
		
		List<QCTrack> ar=this.qcDAO.getAllByPage(pagess);
		
		return ar;
	}
	//添加数据
	@Override
	public void addQCTrack(QCTrack qcTrack) {
		this.qcDAO.addQCTrack(qcTrack);
	}
	//修改数据
	@Override
	public void updateQCTrack(QCTrack qcTrack) {
		this.qcDAO.updateQCTrack(qcTrack);
	}
	//模糊查询时查询数据量
	@Override
	public int getCondationCount(QCTrack qcTrack) {
		return this.qcDAO.getCondationCount(qcTrack);
	}
	//模糊查询
	@Override
	public List<QCTrack> getCondationByPage(CaoUtil caoUtil) {
		
		return this.qcDAO.getCondationByPage(caoUtil);
	}
	@Override
	public QCTrack getOne(int id) {
		return this.qcDAO.getOne(id);
	}
	
}
