package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.ReceiveMaterialNoticeMapper;
import com.warehouse.entity.ReceiveMaterialNotice;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class ReceiveMaterialNoticeSerivceImpl implements ReceiveMaterialNoticeSerivce {
	private Logger logger = LoggerFactory.getLogger(BoardRoomServiceImpl.class);
	
	@Resource
	public ReceiveMaterialNoticeMapper receiveMaterialNoticeMapper;

	@Override
	public int modifyReceiveMaterialNotice(ReceiveMaterialNotice receiveMaterialNotice, HttpServletRequest request) {
		int reslut = receiveMaterialNoticeMapper.modifyReceiveMaterialNotice(receiveMaterialNotice);
		logger.debug(
				" 成功修改面料编号:" + receiveMaterialNotice.getWave()+ "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		
		return reslut;
	}

	@Override
	public int delReceiveMaterialNoticeById(ReceiveMaterialNotice receiveMaterialNotice, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		receiveMaterialNotice.setOperatorIp(operatorIp);
		receiveMaterialNotice.setDeleteTime(DateUtils.formateDaTime(new Date()));
		receiveMaterialNotice.setMarkStatus("0");
		int reslut = receiveMaterialNoticeMapper.delReceiveMaterialNoticeById(receiveMaterialNotice);
		logger.debug(
				" 成功修改面料编号:" + receiveMaterialNotice.getWave()+ "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		
		return reslut;
	}

	@Override
	public int getReceiveMaterialNoticeByPageCount(Map<String, Object> anyVal) {
		int reslut = receiveMaterialNoticeMapper.getReceiveMaterialNoticeByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<ReceiveMaterialNotice> findConditionReceiveMaterialNoticeByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<ReceiveMaterialNotice> list = receiveMaterialNoticeMapper.findConditionReceiveMaterialNoticeByPage(anyVal);
		
		return list;
	}

	@Override
	public ReceiveMaterialNotice getReceiveMaterialNoticeById(Integer id) {
		ReceiveMaterialNotice receiveMaterialNotice = receiveMaterialNoticeMapper.getReceiveMaterialNoticeById(id);
		
		return receiveMaterialNotice;
	}

}
