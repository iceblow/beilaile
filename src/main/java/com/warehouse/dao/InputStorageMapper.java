package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.InputStorage;

public interface InputStorageMapper {

	int delByPrimaryKey(InputStorage inputstorage);

	int insertSelective(InputStorage record);

	InputStorage selectByPrimaryKey(Integer sid);

	int updateByPrimaryKeySelective(InputStorage record);

	// 模糊查询
	int getCountByOutsideLike(InputStorage inputstorage);

	List<InputStorage> InputstorageByLike(InputStorage page);

	// 查询打印次数
	int selectTotalByPrimaryKey(@Param(value = "sid") int sid, @Param(value = "code") String code);

}