package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.DistributionSetUp;

public interface DistributionSetUpService {
	//修改
    int updateDistributionSetUp(DistributionSetUp distributionSetUp);
    //查询
    int getCountDistributionSetUp(DistributionSetUp distributionSetUp);
    
    List<DistributionSetUp> distributionSetUpByLike(DistributionSetUp distributionSetUp);
    //双击修改
    int updateByText(DistributionSetUp distributionSetUp);
}
