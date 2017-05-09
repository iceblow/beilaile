package com.warehouse.dao;

import com.warehouse.entity.UserInfo;

public interface UserInfoMapper {

	// 登录
	UserInfo queryObject(String uname);

	// 注册
	void insertUser(UserInfo userInfo);
	
	//修改个人信息
	void updateUser(UserInfo user);

}
