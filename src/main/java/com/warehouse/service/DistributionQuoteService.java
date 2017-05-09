package com.warehouse.service;

import java.util.List;
import com.warehouse.entity.DistributionQuote;

public interface DistributionQuoteService {

	//分页查询总条数
	int selectAllcount(DistributionQuote distributionQuote);
		
	//查询返回的list
	List<DistributionQuote > getDistributionQuotePage(DistributionQuote distributionQuote);
		
	//确认报价
	int sureDistributionQuoteById(DistributionQuote distributionQuote);
	
	//放弃报价
	int giveUpDistributionQuoteById(DistributionQuote distributionQuote);
	
	//修改数据状态
	int updateDistributionQuoteById(DistributionQuote distributionQuote);
}
