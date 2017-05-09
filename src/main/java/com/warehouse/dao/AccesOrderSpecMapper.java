package com.warehouse.dao;

import com.warehouse.entity.AccesOrderSpec;

import java.util.List;
import java.util.Map;

public interface AccesOrderSpecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesOrderSpec record);

    int insertSelective(AccesOrderSpec record);

    AccesOrderSpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesOrderSpec record);

    int updateByPrimaryKey(AccesOrderSpec record);

    int getAccesOrderSpecBpcnt(Map<String, Object> param);

    List<AccesOrderSpec> findAccesOrderSpecCndbp(Map<String, Object> param);
}