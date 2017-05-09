package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.InputStorage;

public interface InputstorageService {

	// 添加
	int insertInputstorage(InputStorage inputstorage);

	// 删除
	int deleteInputstorage(InputStorage inputstorage);

	// 修改前查询
	InputStorage selectByPrimaryKey(Integer sid);

	// 修改
	int updateInputstorage(InputStorage inputstorage);

	// 模糊查询
	int getCountByOutsideLike(InputStorage inputstorage);

	List<InputStorage> InputstorageByLike(InputStorage storage);

	// 查询个数
	int selectTotalByPrimaryKey(int id, String code);

}
