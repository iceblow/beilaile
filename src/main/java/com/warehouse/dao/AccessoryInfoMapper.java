package com.warehouse.dao;

import com.warehouse.entity.AccessoryInfo;

import java.util.List;
import java.util.Map;

public interface AccessoryInfoMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(AccessoryInfo record);

    int insertSelective(AccessoryInfo record);

    AccessoryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccessoryInfo record);

    int updateByPrimaryKey(AccessoryInfo record);

    //===================================
    int getAccesInfoBpcnt(Map<String, Object> param);

    List<AccessoryInfo> findAccesInfoCndbp(Map<String, Object> param);
}