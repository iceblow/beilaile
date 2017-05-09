package com.warehouse.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.BoardRoom;
import com.warehouse.entity.StillClothes;
import com.warehouse.service.BoardRoomService;
import com.warehouse.util.CharacterUtils;
import com.warehouse.util.FileUpload;
import com.warehouse.util.Page;

@Controller
public class BoardRoomController {

	@Resource
	public BoardRoomService boardRoomService;

	private Logger logger = LoggerFactory.getLogger(BoardRoomController.class);

	@RequestMapping(value = "addBoardRoom.do", method = RequestMethod.POST)
	@ResponseBody
	public int addBoardRoom(@RequestParam MultipartFile imageFile, @RequestParam MultipartFile emfFile,
			@RequestParam MultipartFile prjFile, BoardRoom boardRoom, HttpServletRequest request) throws IOException {
		String folderNmae = "BoardRoomImg";
		String paperpatternImg = "paperpatternImg";
		String imageUrl = "";
		String graphEmf = "";
		String graphPrj = "";
		int reslut = boardRoomService.getBoardRoomByWave(boardRoom.getWave());
		if (reslut > 0) {
			return 18;
		} else {
			// 添加图片
			if (!imageFile.isEmpty()) {
				imageUrl = FileUpload.addFilePath(imageFile, request, folderNmae,
						CharacterUtils.getUpperCase(boardRoom.getWave()));
			}
			// 添加emfFile
			if (!emfFile.isEmpty()) {
				graphEmf = FileUpload.addFilePath(emfFile, request, paperpatternImg,
						CharacterUtils.getUpperCase(boardRoom.getWave()));
			}
			// 添加pfjFile
			if (!prjFile.isEmpty()) {

				graphPrj = FileUpload.addFilePath(prjFile, request, paperpatternImg,
						CharacterUtils.getUpperCase(boardRoom.getWave()));
			}
			boardRoom.setSizeChart(imageUrl);
			boardRoom.setGraphEmf(graphEmf);
			boardRoom.setGraphPrj(graphPrj);
			int result = boardRoomService.addBoardRoom(boardRoom,request);
			logger.info("成功的添加了一条数控" + boardRoom.getWave());
			return result;
		}
	}

	@RequestMapping(value = "modifyBoardRoom.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyBoardRoom(BoardRoom boardRoom, @RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam MultipartFile emfFile, @RequestParam MultipartFile prjFile, HttpServletRequest request) {
		String folderNmae = "BoardRoomImg";
		String paperpatternImg = "paperpatternImg";
		String imageUrl = "";
		String graphEmf = "";
		String graphPrj = "";

		// 添加图片
		if (!imageFile.isEmpty()) {
			imageUrl = FileUpload.addFilePath(imageFile, request, folderNmae,
					CharacterUtils.getUpperCase(boardRoom.getWave()));
		}
		// 添加emfFile
		if (!emfFile.isEmpty()) {
			graphEmf = FileUpload.addFilePath(emfFile, request, paperpatternImg,
					CharacterUtils.getUpperCase(boardRoom.getWave()));
		}
		// 添加pfjFile
		if (!prjFile.isEmpty()) {

			graphPrj = FileUpload.addFilePath(prjFile, request, paperpatternImg,
					CharacterUtils.getUpperCase(boardRoom.getWave()));
		}
		boardRoom.setSizeChart(imageUrl);
		boardRoom.setGraphEmf(graphEmf);
		boardRoom.setGraphPrj(graphPrj);
		int result = boardRoomService.modifyBoardRoom(boardRoom,request);
		logger.info("成功的修改了一条数控" + boardRoom.getWave());
		return result;
	}

	@RequestMapping(value = "delBoardRoomById.do", method = RequestMethod.POST)
	@ResponseBody
	public int delBoardRoomById(Integer id, HttpServletRequest request) {
		int result = boardRoomService.delBoardRoomById(id,request);
		logger.info("成功的了删除一条数控" + id);
		return result;
	}

	@RequestMapping(value = "getBoardRoomByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<StillClothes> getBoardRoomByPageCount(@RequestParam Map<String, Object> anyVal) {
		int result = boardRoomService.getBoardRoomByPageCount(anyVal);
		Page<StillClothes> page = new Page<StillClothes>(result, 1);
		return page;
	}

	@RequestMapping(value = "findConditionBoardRoomByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<BoardRoom> findConditionBoardRoomByPage(@RequestParam Map<String, Object> anyVal) {
		List<BoardRoom> list = boardRoomService.findConditionBoardRoomByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getBoardRoomById.do", method = RequestMethod.POST)
	@ResponseBody
	public BoardRoom getBoardRoomById(Integer id) {
		BoardRoom boardRoom = boardRoomService.getBoardRoomById(id);
		return boardRoom;
	}
}
