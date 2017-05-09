package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.InputStorageMapper;
import com.warehouse.entity.InputStorage;

@Service
public class InputstorageServiceImpl implements InputstorageService {

	@Resource
	public InputStorageMapper inputstorageMapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式

	/**
	 * 添加
	 */
	@Override
	public int insertInputstorage(InputStorage inputstorage) {
		// 默认删除标识(0---存在)
		inputstorage.setDelb(0);
		inputstorage.setAddTime(sdf.format(new Date()));
		int result = this.inputstorageMapper.insertSelective(inputstorage);
		return result;
	}

	/**
	 * 假删除
	 */
	@Override
	public int deleteInputstorage(InputStorage inputstorage) {
		// 获取当前系统时间
		inputstorage.setDelTime(sdf.format(new Date()));
		inputstorage.setSid(inputstorage.getSid());
		int result = this.inputstorageMapper.delByPrimaryKey(inputstorage);
		return result;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateInputstorage(InputStorage inputstorage) {
		// 权限
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
		inputstorage.setUpdateTime(sdf.format(new Date()));
		int result = this.inputstorageMapper.updateByPrimaryKeySelective(inputstorage);
		return result;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByOutsideLike(InputStorage inputstorage) {
		int count = this.inputstorageMapper.getCountByOutsideLike(inputstorage);
		return count;
	}

	@Override
	public List<InputStorage> InputstorageByLike(InputStorage storage) {
		List<InputStorage> storageList = this.inputstorageMapper.InputstorageByLike(storage);
		return storageList;
	}

	/**
	 * 修改前获取值
	 */
	@Override
	public InputStorage selectByPrimaryKey(Integer sid) {
		InputStorage storage = this.inputstorageMapper.selectByPrimaryKey(sid);
		return storage;
	}

	/**
	 * 查询打印次数
	 */
	@Override
	public int selectTotalByPrimaryKey(int sid, String code) {
		int result = this.inputstorageMapper.selectTotalByPrimaryKey(sid, code);
		return result;
	}

}
