package com.warehouse.dao;


import java.util.List;
import java.util.Map;

import com.warehouse.entity.UserInfoEntity;

public interface UserInfoEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoEntity record);

    int insertSelective(UserInfoEntity record);

    UserInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    int updateByPrimaryKey(UserInfoEntity record);
    
    public List<UserInfoEntity> findAll(Map<String, Object> param);
    
    int findCount(Map<String, Object> param);
    
    int findCount();
    
    void update(Map<String, Object> param);
    
    List<UserInfoEntity> findByNameEmployeeNo(Map<String, Object> param);
}