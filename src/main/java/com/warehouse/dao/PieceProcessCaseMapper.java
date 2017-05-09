package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PieceProcessCase;

public interface PieceProcessCaseMapper {

	/**
	 * 获取数据量
	 * @param pieceProcessCase
	 * @return
	 */
	int getCount(PieceProcessCase pieceProcessCase);

	/**
	 * 获取分页数据
	 * @param pieceProcessCase
	 * @return
	 */
	List<PieceProcessCase> getDataByPage(PieceProcessCase pieceProcessCase);

	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	PieceProcessCase selectByPrimaryKey(Integer id);

	/**
	 * 按传入条件修改
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(PieceProcessCase record);

	/**
	 * 修改所有字段
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(PieceProcessCase record);
	
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