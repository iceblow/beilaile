package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.NotStorageRecord;

public interface NotStorageRecordMapper {

	//查询�?有的条数
	int selectPage(NotStorageRecord notStorageRecord);
	
	//返回分页的数�?
	List<NotStorageRecord> getAllByPage(NotStorageRecord notStorageRecord);
	
	//双击修改
	int updateByText(NotStorageRecord notStorageRecord);
	
	//数据假删�?
	int falseDelete(NotStorageRecord notStorageRecord);
}