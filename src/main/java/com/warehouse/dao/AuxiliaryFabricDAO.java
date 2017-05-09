package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.AuxiliaryFabric;

public interface AuxiliaryFabricDAO {

	/**
	 * 得到数据量
	 * 
	 * @return
	 */
	public int getCount(AuxiliaryFabric auxiliaryFabric);

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public List<AuxiliaryFabric> getAllByPage(AuxiliaryFabric auxiliaryFabric);

	/**
	 * 查询单个辅料采购
	 * 
	 * @param id
	 * @return
	 */
	public AuxiliaryFabric getOneById(int id);

	/**
	 * 修改信息
	 * 
	 * @param auxiliaryFabric
	 */
	public void update(AuxiliaryFabric auxiliaryFabric);

	/**
	 * 双击修改方法
	 * 
	 * @param auxiliaryFabric
	 */
	public void myDBupdate(AuxiliaryFabric auxiliaryFabric);

}
