package com.warehouse.dao;

import com.warehouse.entity.InKu;

public interface InKuMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(InKu record);

    int insertSelective(InKu record);

    InKu selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(InKu record);

    int updateByPrimaryKey(InKu record);
}