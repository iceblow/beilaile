package com.warehouse.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.QCTrack;
import com.warehouse.service.QCService;
import com.warehouse.util.CaoUtil;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

@Controller
@RequestMapping("qcTrack")
public class QCTrackController {

	@Autowired
	private QCService qcService;

	private final Logger logger = LoggerFactory.getLogger(QCTrackController.class);

	// 分页查询
	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page) {

		Map<String, Object> map = new HashMap<String, Object>();
		// 寫入每頁數據量
		page.setPageSize(10);
		// 寫入數據量
		page.setTotolCount(this.qcService.getAllCount());

		List<QCTrack> ar = new ArrayList<QCTrack>();

		ar = this.qcService.getAllByPage(new Pagess(page.getReqult()[0], page.getReqult()[1]));

		map.put("dataList", ar);
		map.put("pageUtil", page);
		return map;
	}

	// 测试模糊查询+分页
	@RequestMapping("getCondationByPage")
	@ResponseBody
	public Map<String, Object> getCondationByPage(PageUtil page, QCTrack qcTrack) {

		Map<String, Object> map = new HashMap<String, Object>();

		page.setPageSize(10);
		// 寫入數據量
		page.setTotolCount(this.qcService.getCondationCount(qcTrack));

		List<QCTrack> ar = this.qcService
				.getCondationByPage(new CaoUtil(qcTrack, page.getReqult()[0], page.getReqult()[1]));

		map.put("dataList", ar);
		map.put("pageUtil", page);
		logger.info("查询QC追踪表" + ar.size());
		return map;
	}

	// 添加方法(涉及到文件上傳)
	@RequestMapping("addQCTrack")
	@ResponseBody
	public String addQCTrack(@RequestParam("file") MultipartFile file, QCTrack qcTrack, HttpServletRequest request) {

		// 1--上傳成功,2--上傳失敗
		String flag = "0";
		// 文件的新名字
		String fileName = "";

		// 获取根路径
		String contextRoot = request.getSession().getServletContext().getRealPath("/");
		// 獲取圖片上傳的路徑
		String path = contextRoot + "upload\\";
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename());

			// FileUtils.writeByteArrayToFile以文件字節數組創建文件
			// file.getBytes返回字節數組類型
			try {

				FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());

				flag = "1";

				qcTrack.setImg("/upload/" + fileName);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// 添加對象
		this.qcService.addQCTrack(qcTrack);
		logger.info("添加QC追踪表" + qcTrack.toString());
		return flag;
	}

	@RequestMapping("updateQCTrack")
	@ResponseBody
	public String updateQCTrack(@RequestParam("file") MultipartFile file, QCTrack qcTrack, String myimg,
			HttpServletRequest request) {

		String flag = "0";

		// 文件的新名字
		String fileName = "";

		// 获取根路径
		String contextRoot = request.getSession().getServletContext().getRealPath("/");
		// 獲取圖片上傳的路徑
		String path = contextRoot + "upload\\";

		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename());

			// FileUtils.writeByteArrayToFile以文件字節數組創建文件
			// file.getBytes返回字節數組類型
			try {

				FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());

				flag = "1";

				qcTrack.setImg("/upload/" + fileName);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			qcTrack.setImg(myimg);
		}

		this.qcService.updateQCTrack(qcTrack);
		logger.info("修改QC追踪表" + qcTrack.toString());
		flag = "1";

		return flag;
	}

	@RequestMapping("getOne")
	@ResponseBody
	public final QCTrack getOne(int id) {

		QCTrack qcTrack = this.qcService.getOne(id);

		return qcTrack;
	}

	/**
	 * 
	 * 修改图片名字
	 * 
	 * @param name
	 * @return
	 */
	public static String getPath(String name) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Random ran = new Random();
		String str = df.format(date) + ran.nextInt(10000) + name.substring(name.lastIndexOf("."));
		return str;
	}

}
