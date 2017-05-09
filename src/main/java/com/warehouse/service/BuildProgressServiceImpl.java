package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.BuildProgressMapper;
import com.warehouse.entity.BuildProgress;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

/**
 * Created by MQ on 2016/10/10.
 */
@Service
public class BuildProgressServiceImpl implements BuildProgressService {
	private Logger logger = LoggerFactory.getLogger(BuildProgressServiceImpl.class);

	@Resource
	public BuildProgressMapper buildProgressMapper;

	public int insert(BuildProgress buildProgress, HttpServletRequest request) {
		buildProgress.setState("1");
		int result = buildProgressMapper.insertSelective(buildProgress);
		logger.debug(" 成功添加编号:" + buildProgress.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	public int modifyByBuildProgress(BuildProgress buildProgress, HttpServletRequest request) {
		buildProgress.setModifyTime(DateUtils.formateDaTime(new Date()));// 修改操作时间

		int result = buildProgressMapper.modifyByBuildProgress(buildProgress);
		logger.debug(" 成功修改编号:" + buildProgress.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int delByPrimaryKey(String wave, HttpServletRequest request) {
		int result = buildProgressMapper.delByPrimaryKey(wave, DateUtils.formateDaTime(new Date()));
		logger.debug(" 成功删除编号:" + wave + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public List<BuildProgress> findByAnyValPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<BuildProgress> list = buildProgressMapper.findByAnyValPage(anyVal);
		return list;
	}

	@Override
	public int getAnyVaTotalPageCount(Map<String, Object> anyval) {
		int result = buildProgressMapper.getAnyVaTotalPageCount(anyval);
		return result;
	}

	@Override
	public BuildProgress getModifyBuildProgressByWave(String wave) {
		BuildProgress buildProgress = buildProgressMapper.getModifyBuildProgressByWave(wave);
		return buildProgress;
	}

	@Override
	public Integer getAnyValSumOrderNumber(Map<String, Object> anyval) {
		Integer result = buildProgressMapper.getAnyValSumOrderNumber(anyval);
		return result;
	}
}
