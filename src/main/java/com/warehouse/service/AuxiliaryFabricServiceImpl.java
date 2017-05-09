package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.AuxiliaryFabricDAO;
import com.warehouse.entity.AuxiliaryFabric;
@Service
public class AuxiliaryFabricServiceImpl implements AuxiliaryFabricService {

	@Resource
	private AuxiliaryFabricDAO auxDAO;
	
	@Override
	public int getCount(AuxiliaryFabric auxiliaryFabric) {
		return this.auxDAO.getCount(auxiliaryFabric);
	}

	@Override
	public List<AuxiliaryFabric> getAllByPage(AuxiliaryFabric auxiliaryFabric) {
		return auxDAO.getAllByPage(auxiliaryFabric);
	}

	@Override
	public AuxiliaryFabric getOne(Integer id) {
		return this.auxDAO.getOneById(id);
	}

	@Override
	public void update(AuxiliaryFabric auxiliaryFabric) {
		this.auxDAO.update(auxiliaryFabric);
	}

	@Override
	public void myDBupdate(AuxiliaryFabric auxiliaryFabric) {
		this.auxDAO.myDBupdate(auxiliaryFabric);
	}

}
