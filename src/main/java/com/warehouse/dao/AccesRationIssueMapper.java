package com.warehouse.dao;

import com.warehouse.entity.AccesOrderRation;
import com.warehouse.entity.AccesRationIssue;

import java.util.List;
import java.util.Map;

public interface AccesRationIssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccesRationIssue record);

    int insertSelective(AccesRationIssue record);

    AccesRationIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccesRationIssue record);

    int updateByPrimaryKey(AccesRationIssue record);

    //========================= 辅料配发 =========
    int getAccesOrderIssueBpcnt(Map<String, Object> param);

    List<AccesRationIssue> findAccesOrderIssueCndbp(Map<String, Object> param);
}