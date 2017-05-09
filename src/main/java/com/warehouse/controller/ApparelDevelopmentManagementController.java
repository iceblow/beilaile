package com.warehouse.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ApparelDevelopmentManagement;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.service.ApparelDevelopmentManagementService;
import com.warehouse.service.FabricLibraryService;
import com.warehouse.util.ImageGenerated;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("apparelDevelopmentManagement")
public class ApparelDevelopmentManagementController {

	@Resource
	private ApparelDevelopmentManagementService apparelDevelopmentManagementService;
	@Resource
	private FabricLibraryService fabricLibraryService;

	private Logger log = LoggerFactory.getLogger(ApparelDevelopmentManagementController.class);// 生成日志

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("apparelDevelopmentManagementBylike")
	@ResponseBody
	public Map<String, Object> apparelDevelopmentManagementBylike(PageUtil page, ApparelDevelopmentManagement record) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示的数据量
		page.setTotolCount(this.apparelDevelopmentManagementService.getCountByLike(record));// 总共有多少条数据
		// map对象中存的数据
		List<ApparelDevelopmentManagement> apparelDevelopmentManagements = this.apparelDevelopmentManagementService
				.getApparelDevelopmentManagementByLike(
						new ApparelDevelopmentManagement(page.getReqult()[0], page.getReqult()[1], record.getGirard(), // record.getPlate(),
								record.getMerchantId(), record.getDesigner(), record.getModel(), record.getClothName(),
								record.getPlatewave(), record.getReferPrint(), record.getProcessImg(),
								record.getSampleImg(), record.getDesignTime())); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", apparelDevelopmentManagements);
		log.info("查看服装开发信息");
		return map;
	}

	/**
	 * 删除
	 * 
	 * @param record
	 */
	@RequestMapping("delApparelDevelopmentManagerment")
	@ResponseBody
	public void delApparelDevelopmentManagerment(ApparelDevelopmentManagement record) {
		apparelDevelopmentManagementService.delApparelDevelopmentManagement(record);
		log.debug("删除服装开发信息");
	}

	/**
	 * 添加
	 * 
	 * @param file
	 *            设计图
	 * @param file1
	 *            头样图
	 * @param record
	 *            实体
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("addApparelDevelopmentManagement")
	@ResponseBody
	public int addApparelDevelopmentManagerment(@RequestParam MultipartFile file, @RequestParam MultipartFile file1,
			@RequestParam MultipartFile file2, @RequestParam MultipartFile file3, ApparelDevelopmentManagement record,
			HttpServletRequest request) throws IOException {
		int result = 0;
		String fileName = "";// 声明一个字段来接收新名字
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		String path = rootPath + "designImg\\";// 图片上传路径
		// 设计图
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());// 文件流上传
			record.setDesignImg("designImg\\" + fileName);// 文件名
		}
		// 头样图
		if (!file1.isEmpty()) {
			fileName = this.getPath(file1.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file1.getBytes());// 文件流上传
			record.setProcessImg("designImg\\" + fileName);
		}
		// 图样工艺单
		if (!file3.isEmpty()) {
			fileName = this.getPath(file3.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file3.getBytes());// 文件流上传
			record.setProcessPatternImg("designImg\\" + fileName);
		}
		// 尺码表
		if (!file2.isEmpty()) {
			fileName = this.getPath(file2.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file2.getBytes());// 文件流上传
			record.setChildImg("designImg\\" + fileName);// 文件名
		}
		Integer code1 = record.getCode52() == null ? 0 : record.getCode52();
		Integer code2 = record.getCode59() == null ? 0 : record.getCode59();
		Integer code3 = record.getCode66() == null ? 0 : record.getCode66();
		Integer code4 = record.getCode73() == null ? 0 : record.getCode73();
		Integer code5 = record.getCode80() == null ? 0 : record.getCode80();
		Integer code6 = record.getCode90() == null ? 0 : record.getCode90();
		Integer code7 = record.getCode100() == null ? 0 : record.getCode100();
		Integer code8 = record.getCode110() == null ? 0 : record.getCode110();
		Integer code9 = record.getCode120() == null ? 0 : record.getCode120();
		Integer code10 = record.getCode130() == null ? 0 : record.getCode130();
		Integer code11 = record.getCode160() == null ? 0 : record.getCode160();
		Integer code12 = record.getCode170() == null ? 0 : record.getCode170();
		Integer total = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
				+ code12;
		record.setTotal(total);
		result = this.apparelDevelopmentManagementService.addApparelDevelopmentManagement(record);// 添加方法
		log.debug("添加服装开发信息");
		return result;// 返回添加成功页面
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getApparelDevelopmentManagementById")
	@ResponseBody
	public ApparelDevelopmentManagement getApparelDevelopmentManagementById(Integer id) {
		ApparelDevelopmentManagement record = apparelDevelopmentManagementService
				.getApparelDevelopmentManagementById(id);
		log.debug("根据id后台查询数据");
		return record;
	}

	/**
	 * 修改
	 * 
	 * @param file
	 *            设计图
	 * @param file1
	 *            头样图
	 * @param recode
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("uppApparelDevelopmentManagerment")
	@ResponseBody
	private int uppApparelDevelopmentManagerment(@RequestParam MultipartFile file, @RequestParam MultipartFile file1,
			@RequestParam MultipartFile file2, @RequestParam MultipartFile file3, ApparelDevelopmentManagement record,
			int myIndex, HttpServletRequest request) throws IOException {

		String fileName = "";
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		String path = rootPath + "designImg\\";// 图片上传路径
		// 设计图
		System.err.println(file);
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());// 文件流上传
			record.setDesignImg("designImg\\" + fileName);// 文件名
		}
		// 头样图
		if (!file1.isEmpty()) {
			fileName = this.getPath(file1.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file1.getBytes());// 文件流上传
			record.setProcessImg("designImg\\" + fileName);// 文件名
		}
		// 图样工艺单
		if (!file3.isEmpty()) {
			fileName = this.getPath(file3.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file3.getBytes());// 文件流上传
			record.setProcessPatternImg("designImg\\" + fileName);
		}
		// 尺码表
		if (!file2.isEmpty()) {
			fileName = this.getPath(file2.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file2.getBytes());// 文件流上传
			record.setChildImg("designImg\\" + fileName);// 文件名
		}
		Integer code1 = record.getCode52() == null ? 0 : record.getCode52();
		Integer code2 = record.getCode59() == null ? 0 : record.getCode59();
		Integer code3 = record.getCode66() == null ? 0 : record.getCode66();
		Integer code4 = record.getCode73() == null ? 0 : record.getCode73();
		Integer code5 = record.getCode80() == null ? 0 : record.getCode80();
		Integer code6 = record.getCode90() == null ? 0 : record.getCode90();
		Integer code7 = record.getCode100() == null ? 0 : record.getCode100();
		Integer code8 = record.getCode110() == null ? 0 : record.getCode110();
		Integer code9 = record.getCode120() == null ? 0 : record.getCode120();
		Integer code10 = record.getCode130() == null ? 0 : record.getCode130();
		Integer code11 = record.getCode160() == null ? 0 : record.getCode160();
		Integer code12 = record.getCode170() == null ? 0 : record.getCode170();
		Integer total = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
				+ code12;
		record.setTotal(total);
		log.debug("修改服装开发信息");

		this.apparelDevelopmentManagementService.updateApparelDevelopmentManagement(record);
		return myIndex;

	}

	/**
	 * 修改图片名
	 * 
	 * @param originalFilename
	 * @return
	 */
	private String getPath(String Filename) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Random rd = new Random();// 随机数生成
		String suffix = Filename.substring(Filename.lastIndexOf("."));// 获取后缀名
		String str = df.format(new Date()) + rd.nextInt(10000) + suffix;// 新图片名
		return str;
	}

	/**
	 * 生成excel表压缩包
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("excel")
	@ResponseBody
	public String Exlct(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");// 设置时间格式
		File file = new File("C:/apparel");// 文件夹存放路径
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		File files = new File(file + "/apparel");// 文件存放路径

		if (!files.exists() && !files.isDirectory()) {
			files.mkdir();
		}
		String[] sourceStrArray = ids.split(",");
		for (int i = 0; i < sourceStrArray.length; i++) {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet("服装开发表");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = sheet.createRow((int) 0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			HSSFCell cell = row.createCell((short) 0);
			cell.setCellValue("商家编号");
			cell.setCellStyle(style);
			cell = row.createCell((short) 1);
			cell.setCellValue("预期数量");
			cell.setCellStyle(style);
			cell = row.createCell((short) 2);
			cell.setCellValue("生产日期");
			cell.setCellStyle(style);
			cell = row.createCell((short) 3);
			cell.setCellValue("有效期天数");
			cell.setCellStyle(style);
			cell = row.createCell((short) 4);
			cell.setCellValue("有效期 ");
			cell.setCellStyle(style);
			cell = row.createCell((short) 5);
			cell.setCellValue("原价");
			cell.setCellStyle(style);
			cell = row.createCell((short) 6);
			cell.setCellValue("税率");
			cell.setCellStyle(style);
			cell = row.createCell((short) 7);
			cell.setCellValue("入库价格");
			cell.setCellStyle(style);
			cell = row.createCell((short) 8);
			cell.setCellValue("入库数量");
			cell.setCellStyle(style);
			cell = row.createCell((short) 9);
			cell.setCellValue("批次");
			cell.setCellStyle(style);
			cell = row.createCell((short) 10);
			cell.setCellValue("货位编号");
			cell.setCellStyle(style);
			// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
			List<ApparelDevelopmentManagement> list = apparelDevelopmentManagementService
					.queryEtrack(Integer.parseInt(sourceStrArray[i]));// 第五步，写入实体数据
			ApparelDevelopmentManagement record = (ApparelDevelopmentManagement) list.get(0);
			// 第四步，创建单元格，并设置值
			int totalCount = 0;// 个数 如果什么都没就是0
			Integer code1 = record.getCode52() == null ? 0 : record.getCode52();
			Integer code2 = record.getCode59() == null ? 0 : record.getCode59();
			Integer code3 = record.getCode66() == null ? 0 : record.getCode66();
			Integer code4 = record.getCode73() == null ? 0 : record.getCode73();
			Integer code5 = record.getCode80() == null ? 0 : record.getCode80();
			Integer code6 = record.getCode90() == null ? 0 : record.getCode90();
			Integer code7 = record.getCode100() == null ? 0 : record.getCode100();
			Integer code8 = record.getCode110() == null ? 0 : record.getCode110();
			Integer code9 = record.getCode120() == null ? 0 : record.getCode120();
			Integer code10 = record.getCode130() == null ? 0 : record.getCode130();
			Integer code11 = record.getCode160() == null ? 0 : record.getCode160();
			Integer code12 = record.getCode170() == null ? 0 : record.getCode170();
			int arr[] = { code1, code2, code3, code4, code5, code6, code7, code8, code9, code10, code11, code12 };// 数组
			for (int k : arr) {
				if (k != 0) {
					totalCount = totalCount + 1;// 循环得到个数
				}
			}
			if (totalCount > 0) {
				for (int k = 0; k < totalCount;) {
					for (int j = 0; j < 12; j++) {

						if (j == 0) {
							if (code1 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "52");
								row.createCell((short) 8).setCellValue(record.getCode52());
							}
						} else if (j == 1) {
							if (code2 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "59");
								row.createCell((short) 8).setCellValue(record.getCode59());
							}
						} else if (j == 2) {
							if (code3 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "66");
								row.createCell((short) 8).setCellValue(record.getCode66());
							}
						} else if (j == 3) {
							if (code4 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "73");
								row.createCell((short) 8).setCellValue(record.getCode73());
							}
						} else if (j == 4) {
							if (code5 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "80");
								row.createCell((short) 8).setCellValue(record.getCode80());
							}
						} else if (j == 5) {
							if (code6 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "90");
								row.createCell((short) 8).setCellValue(record.getCode90());
							}
						} else if (j == 6) {
							if (code7 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "100");
								row.createCell((short) 8).setCellValue(record.getCode100());
							}
						} else if (j == 7) {
							if (code8 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "110");
								row.createCell((short) 8).setCellValue(record.getCode110());
							}
						} else if (j == 8) {
							if (code9 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "120");
								row.createCell((short) 8).setCellValue(record.getCode120());
							}
						} else if (j == 9) {
							if (code10 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "130");
								row.createCell((short) 8).setCellValue(record.getCode130());
							}
						} else if (j == 10) {
							if (code11 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "160");
								row.createCell((short) 8).setCellValue(record.getCode160());
							}
						} else if (j == 11) {
							if (code12 != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getMerchantId() + "170");
								row.createCell((short) 8).setCellValue(record.getCode170());
							}
						}
					}
				}
			}
			// 第六步，将文件存到指定位置
			// 存放Excel表
			FileOutputStream fout;
			try {
				fout = new FileOutputStream(new File(files + "/第" + record.getGirard() + "波次-" + record.getDesigner()
						+ "-" + record.getMerchantId() + "-" + record.getClothName() + ".xls"));
				wb.write(fout);
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 压缩
		File srcdir = new File(files.toString());
		String myname = files.toString() + "-" + sdf.format(new Date()) + ".zip";
		File zipFile = new File(myname);
		Project prj = new Project();
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		zip.addFileset(fileSet);
		zip.execute();
		return myname;
	}

	/**
	 * 导出压缩包
	 * 
	 * @param request
	 * @param response
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping("excels")
	@ResponseBody
	public void excel(HttpServletRequest request, HttpServletResponse response, String file) throws Exception {
		// System.out.println("--------downloadFile---------" + file);
		if (file == null || "".equals(file)) {
			throw new Exception("文件名为空，下载文件失败！");
		}
		byte[] buffer = new byte[256];
		InputStream ism = new FileInputStream(file);
		try {
			file = file.substring(file.lastIndexOf(File.separator) + 1);
			file = URLEncoder.encode(file, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		File filename = new File(file);
		// response.setContentType("text/plain");

		response.addHeader("content-type", "application/x-msdownload");// 浏览器自己辨别文件类型
		response.addHeader("Content-Disposition", "attachment; filename=" + filename.getName());
		response.addHeader("Content-Length", String.valueOf(ism.available()));

		int nRead = 0;
		while ((nRead = ism.read(buffer)) > 0)
			response.getOutputStream().write(buffer, 0, nRead);
		ism.close();
		File file1 = new File("C:/apparel");
		// 删除文件夹
		deleteAllFilesOfDir(file1);
		log.debug("生成Excel表并压缩");
	}

	/**
	 * 删除文件夹
	 *
	 * @param path
	 */
	public static void deleteAllFilesOfDir(File path) {
		if (!path.exists())
			return;
		if (path.isFile()) {
			path.delete();
			return;
		}
		File[] file1 = path.listFiles();
		for (int i = 0; i < file1.length; i++) {
			deleteAllFilesOfDir(file1[i]);
		}
		path.delete();
	}

	/**
	 * 按时间段生成Excel
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	@RequestMapping("toExcelTest.do")
	@ResponseBody
	public List<ApparelDevelopmentManagement> toExcelTest(HttpServletRequest request, HttpServletResponse response,
			String startTime, String endTime) throws Exception {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("服装开发");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);

		// ====================== 设置单元格样式开始====================
		sheet.setColumnWidth(0, 10 * 256);
		sheet.setColumnWidth(1, 10 * 256);
		sheet.setColumnWidth(2, 10 * 256);
		sheet.setColumnWidth(3, 18 * 256);
		sheet.setColumnWidth(4, 10 * 256);
		sheet.setColumnWidth(5, 10 * 256);
		sheet.setColumnWidth(6, 35 * 256);
		sheet.setColumnWidth(7, 8 * 256);
		sheet.setColumnWidth(8, 8 * 256);
		sheet.setColumnWidth(9, 8 * 256);
		sheet.setColumnWidth(10, 8 * 256);
		sheet.setColumnWidth(11, 15 * 256);
		sheet.setColumnWidth(12, 40 * 256);
		sheet.setColumnWidth(13, 8 * 256);
		sheet.setColumnWidth(14, 17 * 256);
		sheet.setColumnWidth(15, 40 * 256);
		sheet.setColumnWidth(16, 8 * 256);
		sheet.setColumnWidth(17, 17 * 256);
		sheet.setColumnWidth(18, 40 * 256);
		sheet.setColumnWidth(19, 8 * 256);
		sheet.setColumnWidth(20, 17 * 256);
		sheet.setColumnWidth(21, 40 * 256);
		sheet.setColumnWidth(22, 8 * 256);
		sheet.setColumnWidth(23, 17 * 256);
		sheet.setColumnWidth(24, 40 * 256);
		sheet.setColumnWidth(25, 8 * 256);
		sheet.setColumnWidth(26, 17 * 256);
		// 新增F
		sheet.setColumnWidth(27, 40 * 256);
		sheet.setColumnWidth(28, 8 * 256);
		sheet.setColumnWidth(29, 17 * 256);//
		sheet.setColumnWidth(30, 30 * 256);
		sheet.setColumnWidth(31, 30 * 256);
		sheet.setColumnWidth(32, 30 * 256);
		sheet.setColumnWidth(33, 30 * 256);
		sheet.setColumnWidth(34, 30 * 256);
		sheet.setColumnWidth(35, 30 * 256);
		sheet.setColumnWidth(36, 30 * 256);
		sheet.createRow(0).setHeight((short) (30 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setWrapText(true);

		// ====================== 设置单元格样式结束====================

		// ===============设置列名开始==============
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("波次号");
		cell.setCellStyle(style);

		cell = row.createCell((short) 1);
		cell.setCellValue("商品编号");
		cell.setCellStyle(style);

		cell = row.createCell((short) 2);
		cell.setCellValue("设计师");
		cell.setCellStyle(style);

		cell = row.createCell((short) 3);
		cell.setCellValue("款号");
		cell.setCellStyle(style);

		cell = row.createCell((short) 4);
		cell.setCellValue("参考波次");
		cell.setCellStyle(style);

		cell = row.createCell((short) 5);
		cell.setCellValue("参考印花");
		cell.setCellStyle(style);

		cell = row.createCell((short) 6);
		cell.setCellValue("尺码");
		cell.setCellStyle(style);

		cell = row.createCell((short) 7);
		cell.setCellValue("总件数");
		cell.setCellStyle(style);

		cell = row.createCell((short) 8);
		cell.setCellValue("匹印");
		cell.setCellStyle(style);

		cell = row.createCell((short) 9);
		cell.setCellValue("片印");
		cell.setCellStyle(style);

		cell = row.createCell((short) 10);
		cell.setCellValue("绣花");
		cell.setCellStyle(style);

		cell = row.createCell((short) 11);
		cell.setCellValue("设计时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);

		cell.setCellValue("面料A小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);

		cell.setCellValue("面料A幅宽");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);

		cell.setCellValue("面料A成分");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);

		cell.setCellValue("面料B小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);

		cell.setCellValue("面料B宽幅");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);

		cell.setCellValue("面料B成分");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);

		cell.setCellValue("面料C小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 19);

		cell.setCellValue("面料C幅宽");
		cell.setCellStyle(style);
		cell = row.createCell((short) 20);

		cell.setCellValue("面料C成分");
		cell.setCellStyle(style);
		cell = row.createCell((short) 21);

		cell.setCellValue("面料D小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 22);

		cell.setCellValue("面料D宽幅");
		cell.setCellStyle(style);
		cell = row.createCell((short) 23);

		cell.setCellValue("面料D成分");
		cell.setCellStyle(style);
		cell = row.createCell((short) 24);

		cell.setCellValue("面料E小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 25);

		cell.setCellValue("面料E宽幅");
		cell.setCellStyle(style);
		cell = row.createCell((short) 26);

		cell.setCellValue("面料E成分");
		cell.setCellStyle(style);
		cell = row.createCell((short) 27);
		// 新加的F面料
		cell.setCellValue("面料F小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 28);

		cell.setCellValue("面料F宽幅");
		cell.setCellStyle(style);
		cell = row.createCell((short) 29);

		cell.setCellValue("面料F成分");
		cell.setCellStyle(style);
		cell = row.createCell((short) 90);
		//
		cell.setCellValue("辅料A小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 31);

		cell.setCellValue("辅料B小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 32);

		cell.setCellValue("辅料C小样");
		cell.setCellStyle(style);
		cell = row.createCell((short) 33);

		cell.setCellValue("印花位置");
		cell.setCellStyle(style);
		cell = row.createCell((short) 34);

		cell.setCellValue("绣花位置");
		cell.setCellStyle(style);
		cell = row.createCell((short) 35);

		cell.setCellValue("备注");
		cell.setCellStyle(style);
		cell = row.createCell((short) 36);

		// ===============设置列名结束==============

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<ApparelDevelopmentManagement> list = this.apparelDevelopmentManagementService.toExcelByTime(startTime,
				endTime);

		for (int i = 0; i < list.size(); i++) {
			// 新增行
			row = sheet.createRow((int) i + 1);
			// 设置行高
			row.setHeight((short) (800));
			// 取到一条数据
			ApparelDevelopmentManagement record = (ApparelDevelopmentManagement) list.get(i);
			// 第四步，创建单元格，并设置值
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

			row.createCell((short) 0).setCellValue(record.getGirard());// 第一列数据
			row.createCell((short) 1).setCellValue(record.getMerchantId());// 第二列数据
			row.createCell((short) 2).setCellValue(record.getDesigner());// 第三列数据
			row.createCell((short) 3).setCellValue(record.getModel());// 第四列数据
			row.createCell((short) 4).setCellValue(record.getPlatewave());// 第五列数据
			row.createCell((short) 5).setCellValue(record.getReferPrint());// 第六列数据
			String code1 = record.getCode52() == null ? "    " : "52/" + record.getCode52() + "    ";
			String code2 = record.getCode59() == null ? "    " : "59/" + record.getCode59() + "    ";
			String code3 = record.getCode66() == null ? "    " : "66/" + record.getCode66() + "    ";
			String code4 = record.getCode73() == null ? "\r\n" : "73/" + record.getCode73() + "\r\n";
			String code5 = record.getCode80() == null ? "    " : "80/" + record.getCode80() + "	   ";
			String code6 = record.getCode90() == null ? "    " : "90/" + record.getCode90() + "	   ";
			String code7 = record.getCode100() == null ? "    " : "100/" + record.getCode100() + "    ";
			String code8 = record.getCode110() == null ? "\r\n" : "110/" + record.getCode110() + "\r\n";
			String code9 = record.getCode120() == null ? "    " : "120/" + record.getCode120() + "    ";
			String code10 = record.getCode130() == null ? "    " : "130/" + record.getCode130() + "    ";
			String code11 = record.getCode160() == null ? "    " : "160/" + record.getCode160() + "    ";
			String code12 = record.getCode170() == null ? "    " : "170/" + record.getCode170();
			String result = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
					+ code12;
			cell = row.createCell((short) 6);
			cell.setCellStyle(style);
			cell.setCellValue(result);// 第七列数据

			row.createCell((short) 7).setCellValue(record.getTotal());// 第八列数据
			row.createCell((short) 8).setCellValue(record.getPrint());// 匹印
			row.createCell((short) 9).setCellValue(record.getFilmPrint());// 片印
			row.createCell((short) 10).setCellValue(record.getEmbroidery());// 绣花
			row.createCell((short) 11).setCellValue(record.getDesignTime());// 设计时间
			row.createCell((short) 12).setCellValue(record.getSmallsamplea());// 面料A小样
			row.createCell((short) 13).setCellValue(record.getWidtha());// 面料A宽幅
			row.createCell((short) 14).setCellValue(record.getIngredienta());// 面料A成分

			row.createCell((short) 15).setCellValue(record.getSmallsampleb());// 面料B小样
			row.createCell((short) 16).setCellValue(record.getWidthb());// 面料B宽幅
			row.createCell((short) 17).setCellValue(record.getIngredientb());// 面料B成分

			row.createCell((short) 18).setCellValue(record.getSmallsamplec());// 面料C小样
			row.createCell((short) 19).setCellValue(record.getWidthc());// 面料C宽幅
			row.createCell((short) 20).setCellValue(record.getIngredientc());// 面料C成分

			row.createCell((short) 21).setCellValue(record.getSmallsampled());// 面料D小样
			row.createCell((short) 22).setCellValue(record.getWidthd());// 面料D宽幅
			row.createCell((short) 23).setCellValue(record.getIngredientd());// 面料D成分

			row.createCell((short) 24).setCellValue(record.getSmallsamplee());// 面料E小样
			row.createCell((short) 25).setCellValue(record.getWidthe());// 面料E宽幅
			row.createCell((short) 26).setCellValue(record.getIngrediente());// 面料E成分
			// 新增的F面料
			row.createCell((short) 27).setCellValue(record.getSmallsamplef());// 面料F小样
			row.createCell((short) 28).setCellValue(record.getWidthf());// 面料F宽幅
			row.createCell((short) 29).setCellValue(record.getIngredientf());// 面料F成分

			row.createCell((short) 30).setCellValue(record.getSmallsampleaf());// 辅料A小样
			row.createCell((short) 31).setCellValue(record.getSmallsamplebf());// 辅料B小样
			row.createCell((short) 32).setCellValue(record.getSmallsamplecf());// 辅料C小样

			row.createCell((short) 33).setCellValue(record.getPrintPosition());// 印花位置
			row.createCell((short) 34).setCellValue(record.getEmbroideredPosition());// 绣花位置
			row.createCell((short) 35).setCellValue(record.getRemark());// 备注
		}

		// 选择下载路径弹出框
		String file = "服装开发.xls";// 文件名
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			InputStream ism = new FileInputStream(file);
			wb.write(fout);
			fout.close();
			// 处理乱码问题
			response.setContentType("applicationnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(file.getBytes("utf-8"), "iso-8859-1"));
			response.addHeader("Content-Length", String.valueOf(ism.available()));
			int nRead = 0;
			while ((nRead = ism.read(buffer)) > 0)
				response.getOutputStream().write(buffer, 0, nRead);
			ism.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("生成Excel表");
		return null;
	}

	/**
	 * 生成服装开发Excel
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation" })
	@RequestMapping("toExcel")
	@ResponseBody
	public List<ApparelDevelopmentManagement> toExcel(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("服装开发");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 设置行宽
		sheet.setColumnWidth(0, 18 * 256);
		sheet.setColumnWidth(1, 60 * 256);
		sheet.setColumnWidth(2, 18 * 256);
		sheet.setColumnWidth(3, 60 * 256);
		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("设计图");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("款式名称");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("编码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("码号/数量");
		cell.setCellStyle(style);
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<ApparelDevelopmentManagement> list = this.apparelDevelopmentManagementService.toExcel();
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);// 新增行
			sheet.createRow(i + 1).setHeight((short) (90 * 20));// 设置行高
			ApparelDevelopmentManagement record = (ApparelDevelopmentManagement) list.get(i);
			// 第四步，创建单元格，并设置值
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			// 判断数据库图片是否为空
			if (record.getDesignImg() != null) {
				if (record.getDesignImg().length() != 0) {
					String imgPath = rootPath + record.getDesignImg();// 获取图片路径
					File imgFile = new File(imgPath);// 把路径转换成一个流
					// 判断本地图片是否存在!
					if (imgFile.exists()) {
						// 读入图片
						// 获得图片格式
						String prefix = record.getDesignImg().substring(record.getDesignImg().lastIndexOf(".") + 1);
						bufferImg = ImageIO.read(new File(imgPath));
						ImageIO.write(bufferImg, prefix, byteArrayOut);// 写入流
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 248, (short) 0, i + 1, (short) 1,
								i + 1);// 设置图片的大小比例
						anchor.setAnchorType(3);
						// 插入图片
						patriarch.createPicture(anchor,
								wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// System.err.print("不存在");
					}
				}
			}
			row.createCell((short) 1).setCellValue("第" + record.getGirard() + "波次-" + record.getDesigner() + "-"
					+ record.getModel() + "-" + record.getClothName());// 第一列数据
			row.createCell((short) 2).setCellValue(record.getMerchantId());// 第二列数据

			String code1 = record.getCode52() == null ? "" : "52/" + record.getCode52() + "    ";
			String code2 = record.getCode59() == null ? "" : "59/" + record.getCode59() + "    ";
			String code3 = record.getCode66() == null ? "" : "66/" + record.getCode66() + "    ";
			String code4 = record.getCode73() == null ? "" : "73/" + record.getCode73() + "	   ";
			String code5 = record.getCode80() == null ? "" : "80/" + record.getCode80() + "	   ";
			String code6 = record.getCode90() == null ? "" : "90/" + record.getCode90() + "	   ";
			String code7 = record.getCode100() == null ? "" : "100/" + record.getCode100() + "    ";
			String code8 = record.getCode110() == null ? "" : "110/" + record.getCode110() + "	  ";
			String code9 = record.getCode120() == null ? "" : "120/" + record.getCode120() + "    ";
			String code10 = record.getCode130() == null ? "" : "130/" + record.getCode130() + "    ";
			String code11 = record.getCode160() == null ? "" : "160/" + record.getCode160() + "    ";
			String code12 = record.getCode170() == null ? "" : "170/" + record.getCode170();
			String result = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
					+ code12;
			row.createCell((short) 3).setCellValue(result);// 第三列数据

		}
		// 选择下载路径弹出框
		String file = "服装开发.xls";// 文件名
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			InputStream ism = new FileInputStream(file);
			wb.write(fout);
			fout.close();
			// 处理乱码问题
			response.setContentType("applicationnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(file.getBytes("utf-8"), "iso-8859-1"));
			response.addHeader("Content-Length", String.valueOf(ism.available()));
			int nRead = 0;
			while ((nRead = ism.read(buffer)) > 0)
				response.getOutputStream().write(buffer, 0, nRead);
			ism.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("生成Excel表");
		return null;
	}

	/**
	 * 检查波次号是否唯一
	 * 
	 * @param girard
	 * @return
	 */
	@RequestMapping("checkGirard")
	@ResponseBody
	public int checkGirard(String girard) {
		int flag = 0;
		int count = apparelDevelopmentManagementService.checkGirard(girard);
		if (count > 0) {
			flag = 1;
		}
		return flag;
	}

	/**
	 * 双击修改
	 * 
	 * @param record
	 */
	@RequestMapping("dbuppApparelDevelopmentManagerment")
	@ResponseBody
	private int dbuppApparelDevelopmentManagerment(ApparelDevelopmentManagement record) {
		int flag = this.apparelDevelopmentManagementService.updateApparelDevelopmentManagement(record);
		log.debug("双击修改服装开发信息");
		return flag;
	}

	/**
	 * 生成工艺单
	 * 
	 * @param record
	 * @param request
	 * @return
	 */
	@RequestMapping("toSampleImg")
	@ResponseBody
	public int toSampleImg(ApparelDevelopmentManagement developmentManagement, HttpServletRequest request, String ids) {
		int flag = 0;
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String[] sourceStrArray = ids.split(",");
		for (int i = 0; i < sourceStrArray.length; i++) {
			List<ApparelDevelopmentManagement> list = apparelDevelopmentManagementService
					.queryEtrack(Integer.parseInt(sourceStrArray[i]));
			ApparelDevelopmentManagement record = list.get(0);
			if (record.getProcessImg() != null) {
				if (record.getProcessImg().length() != 0) {
					// 判断本地图片是否存在!
					String imgPath = rootPath + record.getProcessImg();// 获取图片路径
					File imgFile = new File(imgPath);// 把路径转换成一个流
					if (imgFile.exists()) {
						ImageGenerated.exportImg(record, request);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
						record.setCompleteTime(sdf.format(new Date()));
						flag = apparelDevelopmentManagementService.updateApparelDevelopmentManagement(record);// 修改方法
						if (flag == 1) {
							flag = updateCompleteTime(record);
						}
					} else {
						flag = 2;
					}
				}
			}
		}
		log.debug("服装开发生成工艺单信息");
		return flag;
	}

	public int updateCompleteTime(ApparelDevelopmentManagement record) {
		int flag = 0;
		ApparelDevelopmentManagement management = apparelDevelopmentManagementService
				.getApparelDevelopmentManagementById(record.getId());
		// System.out.println(management.getCompleteTime() + " 获取===" +
		// record.getCompleteTime());
		if (management.getCompleteTime() != record.getCompleteTime()) {
			System.err.println("工艺单已修改！请查看");
			flag = 3;
		}
		return flag;
	}

	/**
	 * 双击修改时检查面料是否存在
	 *
	 * @param record查询
	 * @return
	 */
	@RequestMapping("checkClothName")
	@ResponseBody
	public int checkClothName(ApparelDevelopmentManagement record, String type) {
		int flag = 0;
		// 判断是否修改的是面料A
		if (type.equals("smallSampleNumA")) {
			// 判断面料A的值是否为空
			if ("".equals(record.getSmallSampleNumA())) {
				// 赋空值
				record.setSmallsamplea("");
				record.setWidtha("");
				record.setIngredienta("");
				// 调用修改的方法
				flag = dbuppApparelDevelopmentManagerment(record);
			} else {
				// 面料A修改
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumA());// 面料A
				if (fabricLibrary != null) {// 面料A在面料档案里存在
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsamplea(fabric);
					record.setWidtha(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredienta(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentManagerment(record);
				} else {
					flag = 2;// 该面料不存在
				}
			}
		} else if (type.equals("smallSampleNumB")) {
			if ("".equals(record.getSmallSampleNumB())) {
				record.setSmallsampleb("");
				record.setWidthb("");
				record.setIngredientb("");
				flag = dbuppApparelDevelopmentManagerment(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumB());// 面料B
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsampleb(fabric);
					record.setWidthb(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientb(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentManagerment(record);
				} else {
					flag = 2;
				}
			}
		} else if (type.equals("smallSampleNumC")) {
			if ("".equals(record.getSmallSampleNumC())) {
				record.setSmallsamplec("");
				record.setWidthc("");
				record.setIngredientc("");
				flag = dbuppApparelDevelopmentManagerment(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumC());// 面料C
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsamplec(fabric);
					record.setWidthc(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientc(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentManagerment(record);
				} else {
					flag = 2;
				}
			}
		} else if (type.equals("smallSampleNumD")) {
			if ("".equals(record.getSmallSampleNumD())) {
				record.setSmallsampled("");
				record.setWidthd("");
				record.setIngredientd("");
				flag = dbuppApparelDevelopmentManagerment(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumD());// 面料D
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsampled(fabric);
					record.setWidthd(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientd(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentManagerment(record);
				} else {
					flag = 2;
				}
			}
		} else if (type.equals("smallSampleNumE")) {
			if ("".equals(record.getSmallSampleNumE())) {
				record.setSmallsamplee("");
				record.setWidthe("");
				record.setIngrediente("");
				flag = dbuppApparelDevelopmentManagerment(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumE());// 面料E
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsamplee(fabric);
					record.setWidthe(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngrediente(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentManagerment(record);
				} else {
					flag = 2;
				}
			}
		} else if (type.equals("smallSampleNumF")) {//新加面料F
			if ("".equals(record.getSmallSampleNumF())) {
				record.setSmallsamplef("");
				record.setWidthf("");
				record.setIngredientf("");
				flag = dbuppApparelDevelopmentManagerment(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumF());// 面料E
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsamplef(fabric);
					record.setWidthf(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientf(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentManagerment(record);
				} else {
					flag = 2;
				}
			}
		}
		log.debug("双击修改面料信息!!");
		return flag;
	}
}
