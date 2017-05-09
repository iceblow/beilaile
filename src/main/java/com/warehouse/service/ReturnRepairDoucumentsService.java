package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ReturnRepairDoucuments;

public interface ReturnRepairDoucumentsService {
	//删除信息
    int deleteByPrimaryKey(ReturnRepairDoucuments record);
    //增加新的返修开单
    int insert(ReturnRepairDoucuments record);
    //修改前查询
    ReturnRepairDoucuments selectByPrimaryKey(Integer sid);
    //模糊查询
    int getCountByOutsideLike(ReturnRepairDoucuments record);
    
    List<ReturnRepairDoucuments> ReturnRepairDoucumentsbylike(ReturnRepairDoucuments record);
    //修改
    int updateByPrimaryKeySelective(ReturnRepairDoucuments record);
    //查询波次号是为重复
    int girardcount(String girard); 
}
