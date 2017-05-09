package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.warehouse.constant.StateConstant;
import com.warehouse.dao.FactoryBacklogMapper;
import com.warehouse.entity.FactoryBacklog;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

/**
 * Created by admin on 2017/1/17.
 */

/**
 * Created by chiayich on 2016/12/30.
 */
@Service
public class FactoryBacklogServiceImpl implements FactoryBacklogService {

	@Resource
	private FactoryBacklogMapper factoryBacklogMapper;

	@Override
	public int getFactoryBacklogByPageCount(Map<String, Object> anyVal) {
		int reslut = factoryBacklogMapper.getFactoryBacklogByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<FactoryBacklog> findConditionFactoryBacklogByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FactoryBacklog> list = factoryBacklogMapper.findConditionFactoryBacklogByPage(anyVal);
		return list;
	}

	@Override
	public FactoryBacklog getFactoryBacklogById(@Param("id") Integer id) {
		FactoryBacklog factoryBacklog = factoryBacklogMapper.getFactoryBacklogById(id);
		return factoryBacklog;
	}

	@Override
	public FactoryBacklog confirmBacklogCompleted(Integer amId, HttpServletRequest request) {
		FactoryBacklog factoryBacklog = updateISCommon(amId, request);
		factoryBacklog.setCompletionState(StateConstant._FACTOYR_BACKLOG_COMPLETED);
		factoryBacklogMapper.updateBacklogCompletionStatus(factoryBacklog);
		return factoryBacklog;
	}

	// 修改状态的通用部分
	private FactoryBacklog updateISCommon(int amId, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		FactoryBacklog accessoryMaterial = factoryBacklogMapper.getFactoryBacklogById(amId);
		accessoryMaterial.setOperatorIp(operatorIp);
		accessoryMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));
		return accessoryMaterial;
	}
}
