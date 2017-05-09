package com.warehouse.service;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.MobileVerify;

public interface MobileVerifyService {
	// 添加对象
	int addMobileVerify(MobileVerify mobileVerify, HttpServletRequest request);
}
