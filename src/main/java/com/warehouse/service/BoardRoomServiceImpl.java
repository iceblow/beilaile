package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.BoardRoomMapper;
import com.warehouse.entity.BoardRoom;
import com.warehouse.util.CharacterUtils;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class BoardRoomServiceImpl implements BoardRoomService {
	private Logger logger = LoggerFactory.getLogger(BoardRoomServiceImpl.class);
	@Resource
	public BoardRoomMapper boardRoomMapper;

	@Override
	public int addBoardRoom(BoardRoom boardRoom,HttpServletRequest request) {

		boardRoom.setCreatedTime(DateUtils.formateDaTime(new Date()));
		boardRoom.setAddDate(DateUtils.formateDate(new Date()));
		boardRoom.setWave(CharacterUtils.getUpperCase(boardRoom.getWave()));
		boardRoom.setMarkDel("1");
		int result = boardRoomMapper.addBoardRoom(boardRoom);
		logger.debug(
				" 成功添加编号:" + boardRoom.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int modifyBoardRoom(BoardRoom boardRoom,HttpServletRequest request) {
		boardRoom.setCreatedTime(DateUtils.formateDaTime(new Date()));
		boardRoom.setWave(CharacterUtils.getUpperCase(boardRoom.getWave()));
		int result = boardRoomMapper.modifyBoardRoom(boardRoom);
		logger.debug(
				" 成功修改编号:" + boardRoom.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		
		return result;
	}

	@Override
	public int delBoardRoomById(Integer id,HttpServletRequest request) {
		BoardRoom boardRoom = new BoardRoom();
		boardRoom.setMarkDel("0");
		boardRoom.setId(id);
		int result = boardRoomMapper.delBoardRoomById(boardRoom);
		logger.debug(" 成功删除编号:" + boardRoom.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		
		return result;
	}

	@Override
	public int getBoardRoomByPageCount(Map<String, Object> anyVal) {
		int result = boardRoomMapper.getBoardRoomByPageCount(anyVal);
		return result;
	}

	@Override
	public List<BoardRoom> findConditionBoardRoomByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<BoardRoom> list = boardRoomMapper.findConditionBoardRoomByPage(anyVal);
		return list;
	}

	@Override
	public BoardRoom getBoardRoomById(Integer id) {
		BoardRoom boardRoom = boardRoomMapper.getBoardRoomById(id);
		return boardRoom;
	}

	@Override
	public int getBoardRoomByWave(String wave) {
		int result = boardRoomMapper.getBoardRoomByWave(wave);
		return result;
	}

}
