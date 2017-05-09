package com.warehouse.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.warehouse.dao.MobileVerifyMapper;
import com.warehouse.entity.MobileVerify;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class MobileVerifyServiceImpl implements MobileVerifyService {

	@Resource
	public MobileVerifyMapper mobileVerifyMapper;

	@Override
	public int addMobileVerify(MobileVerify mobileVerify, HttpServletRequest request) {
		mobileVerify.setCreatedTime(DateUtils.formateDate(new Date()));
		mobileVerify.setSenderIp(ClientIpUtil.getIpAddress(request));
		int result = mobileVerifyMapper.addMobileVerify(mobileVerify);
		return result;
	}

}
