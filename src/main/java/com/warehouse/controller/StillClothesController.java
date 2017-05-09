package com.warehouse.controller;

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

import com.warehouse.entity.StillClothes;
import com.warehouse.service.StillClothesService;
import com.warehouse.util.FileUpload;
import com.warehouse.util.Page;

@Controller
public class StillClothesController {
	private Logger logger = LoggerFactory.getLogger(StillClothesController.class);

	@Resource
	public StillClothesService stillClothesService;

	@RequestMapping(value = "addStillClothes.do", method = RequestMethod.POST)
	@ResponseBody
	public int addStillClothes(StillClothes stillClothes, @RequestParam("imageFile") MultipartFile imageFile,
			HttpServletRequest request) {
		String imageUrl = stillClothes.getSizeChart();
		String folderNmae = "StillClothesImg";
		if (!imageFile.isEmpty()) {
			imageUrl = FileUpload.addFilePath(imageFile, request, folderNmae, stillClothes.getWave());// 图片处理方法
		}
		stillClothes.setSizeChart(imageUrl);// 图片保存数据库
		int result = stillClothesService.addStillClothes(stillClothes);
		logger.info("成功的添加了一条数控" + stillClothes.getWave());
		return result;// 返回添加成功页面
	}

	@RequestMapping(value = "modifyStillClothes.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyStillClothes(StillClothes stillClothes, @RequestParam("imageFile") MultipartFile imageFile,
			HttpServletRequest request) {
		String imageUrl = stillClothes.getSizeChart();
		String folderNmae = "StillClothesImg";
		if (!imageFile.isEmpty()) {
			imageUrl = FileUpload.addFilePath(imageFile, request, folderNmae, stillClothes.getWave());// 图片处理方法
		}
		stillClothes.setSizeChart(imageUrl);// 图片保存数据库
		int result = stillClothesService.modifyStillClothes(stillClothes);
		logger.info("成功的修改了一条数控" + stillClothes.getWave());
		return result;
	}

	@RequestMapping(value = "delStillClothesById.do", method = RequestMethod.POST)
	@ResponseBody
	public int delStillClothesById(StillClothes stillClothes) {
		int result = stillClothesService.delStillClothesById(stillClothes);
		logger.info("成功的删除了一条数控" + stillClothes.getWave());
		return result;
	}

	@RequestMapping(value = "getStillClothesByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<StillClothes> getStillClothesByPageCount(Map<String, Object> anyVal) {
		int result = stillClothesService.getStillClothesByPageCount(anyVal);
		Page<StillClothes> page = new Page<StillClothes>(result, 1);
		return page;
	}

	@RequestMapping(value = "findConditionStillClothesByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<StillClothes> findConditionStillClothesByPage(@RequestParam Map<String, Object> anyVal) {
		List<StillClothes> list = stillClothesService.findConditionStillClothesByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getStillClothesById.do", method = RequestMethod.POST)
	@ResponseBody
	public StillClothes getStillClothesById(Integer id) {
		StillClothes stillClothes = stillClothesService.getStillClothesById(id);
		return stillClothes;
	}

}
