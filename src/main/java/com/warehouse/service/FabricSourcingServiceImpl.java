package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricSourcingMapper;
import com.warehouse.entity.FabricSourcing;
import com.warehouse.util.ClientIpUtil;

@Service
public class FabricSourcingServiceImpl implements FabricSourcingService {
	private Logger logger = LoggerFactory.getLogger(FabricSourcingServiceImpl.class);

	@Resource
	public FabricSourcingMapper fabricSourcingMapper;

	// 添加采购数据
	@Override
	public int addFabricSourcing(FabricSourcing fabricSourcing,HttpServletRequest request) {
		int reslut = fabricSourcingMapper.addFabricSourcing(fabricSourcing);
		logger.debug(" 成功添加编号:" + fabricSourcing.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	// 修改采购数据
	@Override
	public int modifyFabricSourcing(FabricSourcing fabricSourcing, HttpServletRequest request) {
		int reslut = fabricSourcingMapper.modifyFabricSourcing(fabricSourcing);
		logger.debug(" 成功修改编号:" + fabricSourcing.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	// 删除(假)
	@Override
	public int delFabricSourcing(Integer id, String delTime, HttpServletRequest request) {
		int reslut = fabricSourcingMapper.delFabricSourcing(id, delTime);
		logger.debug(" 成功删除编号:" + id + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return reslut;
	}

	/**
	 * 分页查询
	 */
	// 页数
	@Override
	public int getFabricSourcingByPageCount(Map<String, Object> anyval) {
		int reslut = fabricSourcingMapper.getFabricSourcingByPageCount(anyval);
		return reslut;
	}

	// 总数据
	@Override
	public List<FabricSourcing> findConditionFabricSourcingByPage(Map<String, Object> anyval) {
		List<FabricSourcing> list = fabricSourcingMapper.findConditionFabricSourcingByPage(anyval);

		return list;
	}

	@Override
	public FabricSourcing getFabricSourcingById(Integer id) {
		FabricSourcing fabricSourcing = fabricSourcingMapper.getFabricSourcingById(id);
		return fabricSourcing;
	}

	@Override
	public int modifyFabricSourcingPurchasingStatus(FabricSourcing fabricSourcing, HttpServletRequest request) {
		int reslut = fabricSourcingMapper.modifyFabricSourcingPurchasingStatus(fabricSourcing);
		return reslut;
	}

	@Override
	public List<FabricSourcing> exportCurrentFabricData(Map<String, Object> anyval) {
		List<FabricSourcing> list = fabricSourcingMapper.exportCurrentFabricData(anyval);
		return list;
	}

}
