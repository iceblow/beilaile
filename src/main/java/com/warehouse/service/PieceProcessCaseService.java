package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.PieceProcessCase;
import com.warehouse.util.PageUtil;

public interface PieceProcessCaseService {

	/**
	 * 分页查询
	 * @param pageUtil 分页信息
	 * @param pieceProcessCase 查询条件
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil, PieceProcessCase pieceProcessCase);

	/**
	 * 片印领料
	 * @param pieceProcessCase
	 * @return
	 */
	int pieceOfPrintingOut(PieceProcessCase pieceProcessCase);

	/**
	 * 片印回料
	 * @param pieceProcessCase
	 * @return
	 */
	int pieceOfPrintingIn(PieceProcessCase pieceProcessCase);

}
