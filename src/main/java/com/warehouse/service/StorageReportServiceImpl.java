package com.warehouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.StorageReportDAO;
import com.warehouse.entity.MyStorage;

@Service
public class StorageReportServiceImpl implements StorageReportService {

	@Autowired
	private StorageReportDAO storageReportDAO;

	@Override
	public List<String> getDate() {
		
		List<String> zheng=this.storageReportDAO.getDate();
		List<String> dao=new ArrayList<String>();
		for (int i = zheng.size()-1; i >= 0; i--) {
			String tt=new String();
			tt=zheng.get(i);
			dao.add(tt);
		}
		return dao;
	}

	@Override
	public List<String> getFactory() {
		return this.storageReportDAO.getFactory();
	}

	@Override
	public int getSumTotal(String factory, String date) {

		Integer t = this.storageReportDAO.getSumTotal(factory, date);
		if (t == null) {
			return 0;
		}
		return t;
	}
	
	
	//得到所有的数据
	@Override
	public List<MyStorage> getAll(String date) {
		List<MyStorage> arList=this.storageReportDAO.getAll(date);
		return arList;
	}

}
