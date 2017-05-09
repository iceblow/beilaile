package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.NotStorageRecordMapper;
import com.warehouse.entity.NotStorageRecord;

@Service
public class NotStorageRecordServiceImpl implements NotStorageRecordService {

	@Resource
	private NotStorageRecordMapper notStorageRecordMapper;

	@Override
	public int selectPage(NotStorageRecord notStorageRecord) {

		return this.notStorageRecordMapper.selectPage(notStorageRecord);

	}

	@Override
	public List<NotStorageRecord> getDataByPage(NotStorageRecord notStorageRecord) {
		return this.notStorageRecordMapper.getAllByPage(notStorageRecord);

	}

	@Override
	/**
	 * 双击修改
	 */
	public int updateByText(NotStorageRecord notStorageRecord) {
		return notStorageRecordMapper.updateByText(notStorageRecord);
	}

	// 假删除
	@Override
	public int falseDelete(NotStorageRecord notStorageRecord) {

		return notStorageRecordMapper.falseDelete(notStorageRecord);
	}

}
