package com.warehouse.service;

import java.util.List;
import com.warehouse.entity.DistributionMakSample;

public interface DistributionMakSampleService {
	 //修改
    int updateDistributionMakSample(DistributionMakSample distributionMakSample);
    
    //添加打样工厂
    int addProofingFactory(DistributionMakSample distributionMakSample);
    
     //查询
    int getCountDistributionMakSample(DistributionMakSample distributionMakSample);
    
    List<DistributionMakSample> distributionMakSampleByLike(DistributionMakSample distributionMakSample);
    //双击修改
    int updateByText(DistributionMakSample distributionMakSample);
}
