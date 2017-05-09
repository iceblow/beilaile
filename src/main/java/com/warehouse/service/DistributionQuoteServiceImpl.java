package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.DistributionQuoteMapper;
import com.warehouse.entity.DistributionQuote;

@Service
public class DistributionQuoteServiceImpl implements DistributionQuoteService{

	@Resource
	private DistributionQuoteMapper distributionQuoteMapper;
	
	//查询总条数
	@Override
	public int selectAllcount(DistributionQuote distributionQuote) {
		return distributionQuoteMapper.selectAllcount(distributionQuote);
	}

	//分页查询返回的结果
	@Override
	public List<DistributionQuote> getDistributionQuotePage(DistributionQuote distributionQuote) {
		return distributionQuoteMapper.getDistributionQuotePage(distributionQuote);
	}

	//确认报价
	@Override
	public int sureDistributionQuoteById(DistributionQuote distributionQuote) {
		return distributionQuoteMapper.sureDistributionQuoteById(distributionQuote);
	}

	//双击修改备足和单价
	@Override
	public int updateDistributionQuoteById(DistributionQuote distributionQuote) {
		return distributionQuoteMapper.updateDistributionQuoteById(distributionQuote);
	}

	//放弃报价
	@Override
	public int giveUpDistributionQuoteById(DistributionQuote distributionQuote) {
		return distributionQuoteMapper.giveUpDistributionQuoteById(distributionQuote);
	}

}
