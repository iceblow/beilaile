package com.warehouse.dao;

import com.warehouse.entity.AccesOrderRation;

import java.util.List;
import java.util.Map;

public interface AccesOrderRationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesOrderRation record);

    int insertSelective(AccesOrderRation record);

    AccesOrderRation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesOrderRation record);

    int updateByPrimaryKey(AccesOrderRation record);


    List<AccesOrderRation> findAccesOrderRationCndbp(Map<String, Object> param);

    int getAccesOrderRationBpcnt(Map<String, Object> param);



}