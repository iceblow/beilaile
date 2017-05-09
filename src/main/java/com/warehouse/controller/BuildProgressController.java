package com.warehouse.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
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

import com.warehouse.entity.BuildProgress;
import com.warehouse.service.BuildProgressService;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.Page;

/**
 * 裁片外发生产进度表 Created by MQ on 2016/10/10.
 */
@Controller
public class BuildProgressController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	private BuildProgressService buildProgressService;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 添加一条件数据
	 *
	 * @param buildProgress
	 *            对象
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "addBuildProgress.do", method = RequestMethod.POST)
	public String addBuildProgress(BuildProgress buildProgress, @RequestParam("imageFile") MultipartFile imageFile,
			HttpServletRequest request) throws FileNotFoundException {
		String imageUrl = buildProgress.getImage();
		if (!imageFile.isEmpty()) {
			imageUrl = getImage(imageFile, request, buildProgress.getWave());// 图片处理方法
		}
		buildProgress.setImage(imageUrl);// 图片保存数据库
		buildProgressService.insert(buildProgress, request);// 添加操作
		return "redirect:" + "/buildProgress.html";// 返回添加成功页面
	}

	/**
	 * 查询一个数据的结果 根据
	 *
	 * @return
	 */
	@RequestMapping(value = "getModifyBuildProgressByWave.do", method = RequestMethod.POST)
	@ResponseBody
	public BuildProgress getModifyBuildProgressByWave(String wave) {
		BuildProgress buildProgress = buildProgressService.getModifyBuildProgressByWave(wave);
		return buildProgress;
	}

	/**
	 * 修改一条件数据
	 *
	 * @param buildProgress
	 *            对象
	 * @return
	 */
	@RequestMapping(value = "modifyByBuildProgress.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyByBuildProgress(BuildProgress buildProgress, @RequestParam("imageFile") MultipartFile imageFile,
			HttpServletRequest request) {
		String imageUrl = buildProgress.getImage();
		if (!imageFile.isEmpty()) {
			imageUrl = getImage(imageFile, request, buildProgress.getWave());// 图片处理方法
		}
		buildProgress.setImage(imageUrl);// 图片保存数据库
		int reslut = buildProgressService.modifyByBuildProgress(buildProgress, request);// 修改操作
		// 返回数据页面（刷新当前页面）
		logger.info("成功修改了波茨号为:" + buildProgress.getWave() + "的数据"+ClientIpUtil.getIpAddress(request));
		return reslut;// 返回结果集

	}

	/**
	 * 删除
	 *
	 * @return
	 */
	@RequestMapping(value = "delByPrimaryKey.do", method = RequestMethod.POST)
	@ResponseBody
	public int delByPrimaryKey(String wave, HttpServletRequest request) {
		int result = buildProgressService.delByPrimaryKey(wave, request);
		logger.info("成功删除了" + wave + "数据 ");
		return result;
	}

	/**
	 * 查询根据条件
	 *
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findByAnyValPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<BuildProgress> findByAnyValPage(@RequestParam Map<String, Object> anyVal) throws FileNotFoundException {
		List<BuildProgress> list = buildProgressService.findByAnyValPage(anyVal);
		return list;
	}

	/**
	 * 查询帶條件总条数
	 *
	 * @return
	 */
	@RequestMapping(value = "getAnyVaTotalPageCount.do")
	@ResponseBody
	public Page<BuildProgress> getAnyVaTotalPageCount(@RequestParam Map<String, Object> anyVal) {
		int result = buildProgressService.getAnyVaTotalPageCount(anyVal);// 这个查询总数据
		Page<BuildProgress> page = new Page<BuildProgress>(result, 1);
		return page;
	}

	/**
	 * 查询帶條件总订单数
	 *
	 * @return
	 */
	@RequestMapping(value = "getAnyValSumOrderNumber.do")
	@ResponseBody
	public Integer getAnyValSumOrderNumber(@RequestParam Map<String, Object> anyVal) {
		Integer result = buildProgressService.getAnyValSumOrderNumber(anyVal);
		return result;
	}

	/**
	 * 保存圖片地址
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	public String getImage(MultipartFile file, HttpServletRequest request, String date) {
		try {
			String imageUrl = null;
			// 取得当前上传文件的文件名称
			String fileName = file.getOriginalFilename();
			// 获取文件类型
			String ext = fileName.substring(fileName.indexOf("."), fileName.length());
			byte[] data = file.getBytes();
			// 获取根路径
			String contextRoot = request.getSession().getServletContext().getRealPath("/");
			// 地址图片保存
			String fileNameImg = contextRoot + "userImg\\";
			// System.out.println("打印地址方法===============" + fileNameImg);
			// 判断是否存在这个地址 调用判断方法
			isHaveFolder(contextRoot + "userImg");
			// 类型
			if (ext.equals(".jpeg") || ext.equals(".jpg")) {
				FileOutputStream out = new FileOutputStream(fileNameImg + date + ".jpg");
				out.write(data);
				out.close();
				imageUrl = "/userImg/" + date + ".jpg";
			} else if (ext.equals(".png")) {
				FileOutputStream out = new FileOutputStream(fileNameImg + date + ".png");
				out.write(data);
				out.close();
				imageUrl = "/userImg/" + date + ".png";
			}
			return imageUrl;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.toString());
		}
	}

	/**
	 * 判断是否存在该文件
	 * 
	 * @param fileName
	 */
	public void isHaveFolder(String fileName) {
		File file = new File(fileName);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {// 不存在
			file.mkdir(); // 创建
		}
	}
}
