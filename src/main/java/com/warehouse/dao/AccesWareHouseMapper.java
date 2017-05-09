package com.warehouse.dao;

import com.warehouse.entity.AccesWareHouse;

import java.util.List;
import java.util.Map;

public interface AccesWareHouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesWareHouse record);

    int insertSelective(AccesWareHouse record);

    AccesWareHouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesWareHouse record);

    int updateByPrimaryKey(AccesWareHouse record);


    List<AccesWareHouse> findAccesWareHouseCndbp(Map<String, Object> param);

    int getAccesWareHouseBpcnt(Map<String, Object> param);
}