package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ApparelDevelopmentManagementCollectDAO;
import com.warehouse.entity.ApparelDevelopmentManagementCollect;

@Service
public class ApparelDevelopmentManagementCollectServiceImpl implements ApparelDevelopmentManagementCollectService {

	@Resource
	private ApparelDevelopmentManagementCollectDAO dao;
	
	@Override
	public List<ApparelDevelopmentManagementCollect> select() {
		return this.dao.select();
	}

}
