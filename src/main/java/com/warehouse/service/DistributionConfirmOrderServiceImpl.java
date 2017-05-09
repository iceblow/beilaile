package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.warehouse.dao.DistributionConfirmOrderMapper;
import com.warehouse.entity.DistributionConfirmOrder;
import com.warehouse.util.ClientIpUtil;

@Service
public class DistributionConfirmOrderServiceImpl implements DistributionConfirmOrderService {
	private Logger logger = LoggerFactory.getLogger(DistributionConfirmOrderServiceImpl.class);

	@Resource
	private DistributionConfirmOrderMapper DistributionConfirmOrderMapper;

	//查询所有的条数
	@Override
	public int selectAllcount(DistributionConfirmOrder distributionConfirmOrder) {
		return DistributionConfirmOrderMapper.selectAllcount(distributionConfirmOrder);
	}

	//分页查询返回结果
	@Override
	public List<DistributionConfirmOrder> getDistributionConfirmOrderPage(DistributionConfirmOrder distributionConfirmOrder) {
		return DistributionConfirmOrderMapper.getDistributionConfirmOrderPage(distributionConfirmOrder);
	}

	//确认下单
	@Override
	public int sureDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder) {
		return DistributionConfirmOrderMapper.sureDistributionConfirmOrderById(distributionConfirmOrder);
	}

	//双击修改数据
	@Override
	public int updateDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder,HttpServletRequest request) {
		logger.debug("成功修改了波茨号为:" + distributionConfirmOrder.getWave() + "的数据" + ClientIpUtil.getIpAddress(request));
		return DistributionConfirmOrderMapper.updateDistributionConfirmOrderById(distributionConfirmOrder);
	}

	//取消下单
	@Override
	public int giveUpDistributionConfirmOrderById(DistributionConfirmOrder distributionConfirmOrder) {
		return DistributionConfirmOrderMapper.giveUpDistributionConfirmOrderById(distributionConfirmOrder);
	}

}
