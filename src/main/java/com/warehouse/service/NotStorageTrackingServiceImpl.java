package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.NotStorageTrackingMapper;
import com.warehouse.entity.NotStorageTracking;

@Service
public class NotStorageTrackingServiceImpl implements NotStorageTrackingService{

	@Resource
	private NotStorageTrackingMapper notStorageTrackingMapper;
	
	
	@Override
	public int selectAllcount(NotStorageTracking notStorageTracking) {
		
		return notStorageTrackingMapper.selectAllcount(notStorageTracking);
	}

	@Override
	public List<NotStorageTracking> getnotStorageTrackingPage(NotStorageTracking notStorageTracking) {
		
		return notStorageTrackingMapper.getnotStorageTrackingPage(notStorageTracking);
	}

	@Override
	public int deleteById(NotStorageTracking notStorageTracking) {
		
		return notStorageTrackingMapper.deleteById(notStorageTracking);
	}

	@Override
	public int updateByText(NotStorageTracking notStorageTracking) {
		System.err.println(notStorageTracking.getEstimatedDeliveryTime());
		return notStorageTrackingMapper.updateByText(notStorageTracking);
	}

}
