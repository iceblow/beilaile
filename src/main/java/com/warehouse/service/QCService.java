package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.QCTrack;
import com.warehouse.util.CaoUtil;
import com.warehouse.util.Pagess;

public interface QCService {

	// 查询数据量
	int getAllCount();

	// 分页查询
	List<QCTrack> getAllByPage(Pagess pagess);

	// 添加方法
	void addQCTrack(QCTrack qcTrack);

	// 修改方法
	void updateQCTrack(QCTrack qcTrack);

	// 模糊查询查询数据量
	int getCondationCount(QCTrack qcTrack);

	// 模糊查询分页
	List<QCTrack> getCondationByPage(CaoUtil caoUtil);

	QCTrack getOne(int id);

}
