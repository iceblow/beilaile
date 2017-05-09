package com.warehouse.dao;

import com.warehouse.entity.AccesOrderSort;

import java.util.List;
import java.util.Map;

public interface AccesOrderSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesOrderSort record);

    int insertSelective(AccesOrderSort record);

    AccesOrderSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesOrderSort record);

    int updateByPrimaryKey(AccesOrderSort record);


    List<AccesOrderSort> findAccesOrderSortCndbp(Map<String, Object> param);

    int getAccesOrderSortBpcnt(Map<String, Object> param);

    int orderRationWaitBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderRationWait(Map<String, Object> param);

    int orderRationReadyBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderRationReady(Map<String, Object> param);

    int orderRationSpecBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderRationSpec(Map<String, Object> param);

    int orderFollowBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderFollowList(Map<String, Object> param);

}