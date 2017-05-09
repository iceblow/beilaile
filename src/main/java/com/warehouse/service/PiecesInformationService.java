package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.PiecesInformation;

public interface PiecesInformationService {

	// 分页
	int selectByCount(PiecesInformation record);

	List<PiecesInformation> selectByPage(PiecesInformation record);

	// 添加到订单
	int uppPiecesInformation(PiecesInformation record);

	// 根据订单号查询
	List<PiecesInformation> selInformation(Integer orderId);
}
