package com.warehouse.dao;

import com.warehouse.entity.OutKu;

public interface OutKuMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(OutKu record);

    int insertSelective(OutKu record);

    OutKu selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(OutKu record);

    int updateByPrimaryKey(OutKu record);
}