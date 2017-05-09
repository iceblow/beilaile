package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.ReceiveMaterialNotice;

public interface ReceiveMaterialNoticeSerivce {
	// 修改对象
	int modifyReceiveMaterialNotice(ReceiveMaterialNotice receiveMaterialNotice, HttpServletRequest request);

	// 删除对象
	int delReceiveMaterialNoticeById(ReceiveMaterialNotice receiveMaterialNotice, HttpServletRequest request);

	// 带条件查询总条数
	int getReceiveMaterialNoticeByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<ReceiveMaterialNotice> findConditionReceiveMaterialNoticeByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	ReceiveMaterialNotice getReceiveMaterialNoticeById(@Param("id") Integer id);
	
}
