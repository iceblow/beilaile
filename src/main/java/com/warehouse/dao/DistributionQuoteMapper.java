package com.warehouse.dao;

import java.util.List;
import com.warehouse.entity.DistributionQuote;
import com.warehouse.entity.OrderTracking;

public interface DistributionQuoteMapper {
	//查询总条数
	int selectAllcount(DistributionQuote distributionQuote);
		
	//返回的结果
	List<DistributionQuote> getDistributionQuotePage(DistributionQuote distributionQuote);
		
	//查询总条数
	int sureDistributionQuoteById(DistributionQuote distributionQuote);
	
	//查询总条数
	int giveUpDistributionQuoteById(DistributionQuote distributionQuote);
	
	//查询总条数
	int updateDistributionQuoteById(DistributionQuote distributionQuote);
	
}