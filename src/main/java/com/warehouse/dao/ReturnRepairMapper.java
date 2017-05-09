package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.ReturnRepair;

public interface ReturnRepairMapper {
	// 删除信息
	int deleteByPrimaryKey(ReturnRepair record);

	// 增加新的返修开单
	int insert(ReturnRepair record);
    //查询波次号是否为空
	int girardcount(String girard);

	// 修改前查询
	ReturnRepair selectByPrimaryKey(@Param("sid") Integer sid);

	// 模糊查询
	int getCountByOutsideLike(ReturnRepair record);

	List<ReturnRepair> ReturnRepairDoucumentsbylike(ReturnRepair record);

	// 修改
	int updateByPrimaryKeySelective(ReturnRepair record);

}