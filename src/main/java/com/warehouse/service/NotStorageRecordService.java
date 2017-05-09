package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.NotStorageRecord;

public interface NotStorageRecordService {

	//分頁查詢返回數據
	int selectPage(NotStorageRecord notStorageRecord);
	//返回一个集合
	List<NotStorageRecord> getDataByPage(NotStorageRecord notStorageRecord);
	
	//双击修改
	int updateByText(NotStorageRecord notStorageRecord);
	
	//数据假删除
	int falseDelete(NotStorageRecord notStorageRecord);
	
}
