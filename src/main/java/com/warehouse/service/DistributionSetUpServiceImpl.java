package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.warehouse.dao.DistributionSetUpMapper;
import com.warehouse.entity.DistributionSetUp;

@Service
public class DistributionSetUpServiceImpl implements DistributionSetUpService {
	
@Resource
public DistributionSetUpMapper  distributionSetUpMapper;
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化

	//修改
	@Override
	public int updateDistributionSetUp(DistributionSetUp distributionSetUp) {
		distributionSetUp.setModifyTime(formatter.format(new Date()));
		distributionSetUp.setSetUpDistributionTime(formatter.format(new Date()));
		distributionSetUp.setState("1");
		int result = this.distributionSetUpMapper.updateDistributionSetUp(distributionSetUp);
		return result;
	}

	//查询
	@Override
	public int getCountDistributionSetUp(DistributionSetUp distributionSetUp) {		
		int result = this.distributionSetUpMapper.getCountDistributionSetUp(distributionSetUp);
		return result;
	}
	
	@Override
	public List<DistributionSetUp> distributionSetUpByLike(DistributionSetUp distributionSetUp) {
		List<DistributionSetUp> result = this.distributionSetUpMapper.distributionSetUpByLike(distributionSetUp);
		return result;
	}
	/**
	 * 双击修改
	 */
	@Override
	public int updateByText(DistributionSetUp distributionSetUp) {	
		distributionSetUp.setModifyTime(formatter.format(new Date()));
		return this.distributionSetUpMapper.updateDistributionSetUp(distributionSetUp);
	}
}
