package com.warehouse.dao;

import com.warehouse.entity.AccesOrderFollow;
import com.warehouse.entity.AccesOrderFollow;

import java.util.List;
import java.util.Map;

public interface AccesOrderFollowMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AccesOrderFollow record);

    int insertSelective(AccesOrderFollow record);

    AccesOrderFollow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesOrderFollow record);

    int updateByPrimaryKey(AccesOrderFollow record);

    List<AccesOrderFollow> findAccesOrderFollowCndbp(Map<String, Object> param);

    int getAccesOrderFollowBpcnt(Map<String, Object> param);

    int orderRationWaitBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderRationWait(Map<String, Object> param);

    int orderRationReadyBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderRationReady(Map<String, Object> param);

    int orderRationSpecBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderRationSpec(Map<String, Object> param);

    int orderFollowBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderFollowList(Map<String, Object> param);
}