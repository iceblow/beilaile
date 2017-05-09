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

import com.warehouse.entity.Tracking;
import com.warehouse.service.TrackingService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

@Controller
@RequestMapping("tracking")
public class TrackingController {

	@Autowired
	private TrackingService trackingService;

	private final Logger logger = LoggerFactory.getLogger(TrackingController.class);

	// 所有数据的分页查询
	@RequestMapping("getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page) {

		Map<String, Object> map = new HashMap<String, Object>();
		// 寫入每頁數據量
		page.setPageSize(10);
		// 寫入數據量
		page.setTotolCount(this.trackingService.getAllCount());

		List<Tracking> ar = new ArrayList<Tracking>();
		// 得到显示数据
		ar = this.trackingService.getAllByPage(new Pagess(page.getReqult()[0], page.getReqult()[1]));

		map.put("dataList", ar);
		map.put("pageUtil", page);

		logger.info("理单跟踪表:查询-" + ar.size());

		return map;
	}

	/**
	 * 
	 * 添加
	 * @param file 上传的文件
	 * @param track 添加的信息
	 * @param request
	 * @return
	 */
	@RequestMapping("addTrack")
	@ResponseBody
	public String addTrack(@RequestParam("file") MultipartFile file, Tracking track, HttpServletRequest request) {

		// 1--上傳成功,2--上傳失敗
		String flag = "0";
		// 文件的新名字
		String fileName = "";

		// 获取根路径
		String contextRoot = request.getSession().getServletContext().getRealPath("/");
		// 獲取圖片上傳的路徑
		String path = contextRoot + "trackingImg\\";
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename());

			// FileUtils.writeByteArrayToFile以文件字節數組創建文件
			// file.getBytes返回字節數組類型
			try {

				FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());

				flag = "1";

				track.setImg("/trackingImg/" + fileName);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// 添加對象
		this.trackingService.addTrack(track);

		logger.info("理单跟踪表:添加-" + track.toString());

		return flag;
	}

	// 删除数据(暂未使用)
	@RequestMapping("del")
	@ResponseBody
	public String del(Integer id) {

		this.trackingService.del(id);

		return "1";
	}

	// 修改方法
	@RequestMapping("updateTrack")
	@ResponseBody
	public String update(@RequestParam("file") MultipartFile file, Tracking track, String myname,
			HttpServletRequest request) {

		String flag = "0";

		// 文件的新名字
		String fileName = "";

		// 获取根路径
		String contextRoot = request.getSession().getServletContext().getRealPath("/");

		// 獲取圖片上傳的路徑
		String path = contextRoot + "trackingImg\\";

		// 判断是否上传了文件:如果上传了文件,得到新的文件并重命名;如果没有上传新的文件就使用之前的文件名
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename());

			// FileUtils.writeByteArrayToFile以文件字節數組創建文件
			// file.getBytes返回字節數組類型
			try {

				FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());

				flag = "1";

				track.setImg("/trackingImg/" + fileName);

			} catch (IOException e) {

				e.printStackTrace();
			}

		} else {
			track.setImg(myname);
		}

		this.trackingService.updateTrack(track);

		logger.info("理单跟踪表:修改-" + track.toString());

		flag = "1";

		return flag;
	}

	@RequestMapping("getOne")
	@ResponseBody
	public Tracking getOne(int id) {

		Tracking tracking = this.trackingService.getOne(id);

		return tracking;
	}

	// 所有数据的分页查询
	@RequestMapping("getConditionByPage")
	@ResponseBody
	public Map<String, Object> getConditionByPage(PageUtil page, Tracking tracking) {
		if(tracking.getDeleteType()==null){
			tracking.setDeleteType(1);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 寫入每頁數據量
		page.setPageSize(10);
		// 寫入數據量
		page.setTotolCount(this.trackingService.getConditionCountByPage(tracking));

		List<Tracking> ar = new ArrayList<Tracking>();
		// 得到显示数据
		ar = this.trackingService
				.getConditionAllByPage(new Tracking(page.getReqult()[0], page.getReqult()[1], tracking));

		// 得到总的订单数量
		Integer orderSum = this.trackingService.getOrderNum(tracking);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", ar);
		data.put("orderSum", orderSum);
		data.put("styleSum", page.getTotolCount());

		map.put("dataList", data);
		map.put("pageUtil", page);

		logger.info("理单跟踪表:查询-" + ar.size());

		return map;
	}

	// 修改方法
	@RequestMapping("dbUpdateTrack")
	@ResponseBody
	public String dbUpdateTrack(Tracking tracking) {
		this.trackingService.dbUpdateTrack(tracking);
		return "1";
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
		// 日期+随机数(5位)+文件后缀名
		String str = df.format(date) + ran.nextInt(10000) + name.substring(name.lastIndexOf("."));
		return str;
	}

}
