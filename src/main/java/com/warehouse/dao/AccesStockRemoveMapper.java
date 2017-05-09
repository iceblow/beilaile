package com.warehouse.dao;

import com.warehouse.entity.AccesStockRemove;

public interface AccesStockRemoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesStockRemove record);

    int insertSelective(AccesStockRemove record);

    AccesStockRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesStockRemove record);

    int updateByPrimaryKey(AccesStockRemove record);
}