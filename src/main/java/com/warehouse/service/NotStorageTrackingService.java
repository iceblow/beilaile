package com.warehouse.service;

import java.util.List;
import com.warehouse.entity.NotStorageTracking;

public interface NotStorageTrackingService {

	//分页查询总条数
	int selectAllcount(NotStorageTracking notStorageTracking);
	
	//查询返回的list
	List<NotStorageTracking> getnotStorageTrackingPage(NotStorageTracking notStorageTracking);
	
	//修改数据状态
	int deleteById(NotStorageTracking notStorageTracking);
	
	//修改时间
	int updateByText(NotStorageTracking notStorageTracking);
}
