package com.warehouse.dao;

import java.util.List;
import com.warehouse.entity.DistributionSetUp;

public interface DistributionSetUpMapper {
	//修改
    int updateDistributionSetUp(DistributionSetUp distributionSetUp);
    //查询
    int getCountDistributionSetUp(DistributionSetUp distributionSetUp);
    
    List<DistributionSetUp> distributionSetUpByLike(DistributionSetUp distributionSetUp);
}