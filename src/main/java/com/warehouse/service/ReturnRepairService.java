package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ReturnRepair;

public interface ReturnRepairService {
	//删除信息
    int deleteByPrimaryKey(ReturnRepair record);
    //增加新的返修开单
    int insert(ReturnRepair record);
    //修改前查询
    ReturnRepair selectByPrimaryKey(Integer sid);
    //模糊查询
    int getCountByOutsideLike(ReturnRepair record);
    
    List<ReturnRepair> ReturnRepairDoucumentsbylike(ReturnRepair record);
    //修改
    int updateByPrimaryKeySelective(ReturnRepair record);
    //查询波次号是否重复
	int girardcount(String girard);

}
