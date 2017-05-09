package com.warehouse.dao;

import com.warehouse.entity.AccesStorageIn;

public interface AccesStorageInMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesStorageIn record);

    int insertSelective(AccesStorageIn record);

    AccesStorageIn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesStorageIn record);

    int updateByPrimaryKey(AccesStorageIn record);
}