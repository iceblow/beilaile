package com.warehouse.dao;

import java.util.List;
import com.warehouse.entity.NotStorageTracking;

public interface NotStorageTrackingMapper {
	//查询总条数
	int selectAllcount(NotStorageTracking notStorageTracking);
		
	//返回的结果
	List<NotStorageTracking> getnotStorageTrackingPage(NotStorageTracking notStorageTracking);
	
	//查询总条数
	int deleteById(NotStorageTracking notStorageTracking);
	
	//查询总条数
	int updateByText(NotStorageTracking notStorageTracking);
}