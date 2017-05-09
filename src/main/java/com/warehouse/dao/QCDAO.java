package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.QCTrack;
import com.warehouse.util.CaoUtil;
import com.warehouse.util.Pagess;

public interface QCDAO {
	
	//查询总的数据量
	int getAllCount();
	//分页查询
	List<QCTrack> getAllByPage(Pagess pagess);
	//添加数据
	void addQCTrack(QCTrack qcTrack);
	//修改数据
	void updateQCTrack(QCTrack qcTrack);
	//模糊查询时得到数据量
	int getCondationCount(QCTrack qcTrack);
	//模糊查询+分页
	List<QCTrack> getCondationByPage(CaoUtil caoUtil);
	//根据编号叉车查出需要的对象
	QCTrack getOne(int id);

}
