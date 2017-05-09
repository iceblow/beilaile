package com.warehouse.dao;

import com.warehouse.entity.AccesOrderReady;

import java.util.List;
import java.util.Map;

public interface AccesOrderReadyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesOrderReady record);

    int insertSelective(AccesOrderReady record);

    AccesOrderReady selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesOrderReady record);

    int updateByPrimaryKey(AccesOrderReady record);

    List<AccesOrderReady> findAccesOrderReadyCndbp(Map<String, Object> param);

    int getAccesOrderReadyBpcnt(Map<String, Object> param);
}