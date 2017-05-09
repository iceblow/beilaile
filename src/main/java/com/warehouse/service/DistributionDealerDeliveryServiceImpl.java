package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.controller.BoardRoomController;
import com.warehouse.dao.DistributionDealerDeliveryMapper;
import com.warehouse.entity.AccessoryInfo;
import com.warehouse.entity.DistributionDealerDelivery;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class DistributionDealerDeliveryServiceImpl implements DistributionDealerDeliveryService {
	private Logger logger = LoggerFactory.getLogger(DistributionDealerDeliveryServiceImpl.class);
	@Resource
	private DistributionDealerDeliveryMapper distributionDealerDeliverymapper;

	/**
	 * 获取经销单出库信息总数
	 * 
	 * @param param
	 *            页面显示数量 筛查条件
	 * @return 查询到符合筛查条件的总数
	 */
	@Override
	public int getDistributionInfoBpcnt(Map<String, Object> param) {
		return distributionDealerDeliverymapper.getDistributionInfoBpcnt(param);
	}

	/**
	 * 查询经销单出库信息一览
	 * 
	 * @param param
	 *            页面显示数 当前页 查询条件
	 * @return 返回信息一览
	 */
	@Override
	public List<DistributionDealerDelivery> findDistributionInfoCndbp(Map<String, Object> param) {
		int pageNow = Integer.parseInt(param.get("pageNow").toString());
		int pageSize = Integer.parseInt(param.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		param.put("pageNow", pageNow);
		param.put("pageSize", pageSize);
		return distributionDealerDeliverymapper.findDistributionInfoCndbp(param);
	}

	/**
	 * 跟据ID 获取指定经销单出库信息
	 * 
	 * @param id
	 *            经销单出库id
	 * @param request
	 *            查询者ip
	 * @return 经销单出库信息
	 */
	@Override
	public DistributionDealerDelivery getDistributionInfoBid(Integer id) {

		return distributionDealerDeliverymapper.selectByPrimaryKey(id);
	}

	@Override
	public int confirmShipment(Integer id) {

		return distributionDealerDeliverymapper.confirmShipment(id);
	}

	@Override
	public int modifyDistributionInfo(Map<String, Object> param, HttpServletRequest request) {
		System.out.println("=========================="+"成功的了修改序列号为：" + param.get("sid")+""+ClientIpUtil.getIpAddress(request));
		int result = distributionDealerDeliverymapper.modifyDistributionInfo(param);
		logger.info("成功的了修改序列号为：" + param.get("sid")+""+ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public DistributionDealerDelivery selectById(Map<String, Object> param) {
		DistributionDealerDelivery distributionDealerDelivery = distributionDealerDeliverymapper.selectById(param);
		return distributionDealerDelivery;
	}

	@Override
	public int updateReportAndReal(Integer id, Integer actual, Integer report) {

		return distributionDealerDeliverymapper.updateReportAndReal(id, actual, report);
	}

}
