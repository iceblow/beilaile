package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.DistributionMakSampleMapper;
import com.warehouse.entity.DistributionMakSample;

@Service
public class DistributionMakSampleServiceImpl implements DistributionMakSampleService {
	@Resource
	public DistributionMakSampleMapper distributionMakSampleMapper;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化
	SimpleDateFormat simptime= new SimpleDateFormat("yyyy-MM-dd ", Locale.CHINESE);// 时间格式化
 
	//修改
	@Override
	public int updateDistributionMakSample(DistributionMakSample distributionMakSample) {
		distributionMakSample.setModifyTime(formatter.format(new Date()));
		int result = this.distributionMakSampleMapper.updateDistributionMakSample(distributionMakSample);
		return result;
	}

	//查询
	@Override
	public int getCountDistributionMakSample(DistributionMakSample distributionMakSample) {
		int result = this.distributionMakSampleMapper.getCountDistributionMakSample(distributionMakSample);
		return result;
	}

	@Override
	public List<DistributionMakSample> distributionMakSampleByLike(DistributionMakSample distributionMakSample) {
		List<DistributionMakSample> result = this.distributionMakSampleMapper.distributionMakSampleByLike(distributionMakSample);
		return result;
	}

	@Override
	public int updateByText(DistributionMakSample distributionMakSample) {
		distributionMakSample.setModifyTime(formatter.format(new Date()));
		return this.distributionMakSampleMapper.updateByText(distributionMakSample);
	}

	//添加打样工厂
	@Override
	public int addProofingFactory(DistributionMakSample distributionMakSample) {
		
		return distributionMakSampleMapper.addProofingFactory(distributionMakSample);
	}

}
