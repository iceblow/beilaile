package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PiecesInformation;

public interface PiecesInformationMapper {

	// 分页查询
	int selectByCount(PiecesInformation record);

	List<PiecesInformation> selectBypage(PiecesInformation record);

	// 添加到订单
	int updateByPrimaryKeySelective(PiecesInformation record);

	// 根据定单号查询
	List<PiecesInformation> selInformation(Integer orderId);
}