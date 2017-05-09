package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.BoardRoom;

public interface BoardRoomService {
	// 添加对象
	int addBoardRoom(BoardRoom boardRoom,HttpServletRequest request);

	// 修改对象
	int modifyBoardRoom(BoardRoom boardRoom,HttpServletRequest request);

	// 删除对象
	int delBoardRoomById(Integer id,HttpServletRequest request);

	// 带条件查询总条数
	int getBoardRoomByPageCount(Map<String, Object> anyVal);
	

	// 带条件分页查询
	List<BoardRoom> findConditionBoardRoomByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	BoardRoom getBoardRoomById(@Param("id") Integer id);

	// 修改获取数据根据id
	int getBoardRoomByWave(@Param("wave")String wave);
}
