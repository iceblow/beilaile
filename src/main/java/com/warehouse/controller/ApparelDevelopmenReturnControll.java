package com.warehouse.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ApparelDevelopmentReturn;
import com.warehouse.service.ApparelDevelopmenReturnService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("apparelDevelopmentReturn")
public class ApparelDevelopmenReturnControll {

	private Logger log = LoggerFactory.getLogger(ApparelDevelopmenReturnControll.class);
	@Resource
	private ApparelDevelopmenReturnService developmenReturnService;

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param record
	 * @return
	 */
	@RequestMapping("apparelDevelopmentReturnBylike")
	@ResponseBody
	public Map<String, Object> apparelDevelopmentReturnBylike(PageUtil page, ApparelDevelopmentReturn record) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每一页多少条数据
		page.setTotolCount(developmenReturnService.selApparelDevelopmentReturnCount(record));// 一共多少条数据
		List<ApparelDevelopmentReturn> developmentReturns = developmenReturnService
				.developmentReturns(new ApparelDevelopmentReturn(record.getGirard(), record.getDesigner(),
						record.getOriginalWave(), record.getReferWave(), record.getPrintWave(), record.getModel(),
						record.getProductId(), record.getVendorCode(), record.getClothName(), record.getSizeChart(),
						page.getReqult()[0], page.getReqult()[1]));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", developmentReturns);
		log.info("查询返单信息");
		return map;
	}

	/**
	 * 导出Excel并压缩
	 * 
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("selApparelReturnById")
	@ResponseBody
	public String selApparelReturnById(String ids) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");// 设置时间格式
		File file = new File("C:/apparel");// 文件夹存放路径
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		File files = new File(file + "/return");// 文件存放路径

		if (!files.exists() && !files.isDirectory()) {
			files.mkdir();
		}
		String[] source = ids.split(",");
		for (int i = 0; i < source.length; i++) {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet("服装返单表");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = sheet.createRow((int) 0);
			// 设置行宽
			sheet.setColumnWidth(0, 18 * 256);
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
			List<ApparelDevelopmentReturn> list = developmenReturnService.queryEtrack(Integer.parseInt(source[i]));
			ApparelDevelopmentReturn record = (ApparelDevelopmentReturn) list.get(0);
			// 第四步，创建单元格，并设置值
			int totalCount = 0;// 个数 如果什么都没就是0
			int arr[] = { record.getCode52(), record.getCode59(), record.getCode66(), record.getCode73(),
					record.getCode80(), record.getCode90(), record.getCode100(), record.getCode110(),
					record.getCode120(), record.getCode130(), record.getCode160(), record.getCode170() };// 数组
			for (int k : arr) {
				if (k != 0) {
					totalCount = totalCount + 1;// 循环得到个数
				}
			}
			if (totalCount > 0) {
				for (int k = 0; k < totalCount;) {
					for (int j = 0; j < 12; j++) {

						if (j == 0) {
							if (record.getCode52() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "52");
								row.createCell((short) 8).setCellValue(record.getCode52());
							}
						} else if (j == 1) {
							if (record.getCode59() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "59");
								row.createCell((short) 8).setCellValue(record.getCode59());
							}
						} else if (j == 2) {
							if (record.getCode66() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "66");
								row.createCell((short) 8).setCellValue(record.getCode66());
							}
						} else if (j == 3) {
							if (record.getCode73() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "73");
								row.createCell((short) 8).setCellValue(record.getCode73());
							}
						} else if (j == 4) {
							if (record.getCode80() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "80");
								row.createCell((short) 8).setCellValue(record.getCode80());
							}
						} else if (j == 5) {
							if (record.getCode90() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "90");
								row.createCell((short) 8).setCellValue(record.getCode90());
							}
						} else if (j == 6) {
							if (record.getCode100() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "100");
								row.createCell((short) 8).setCellValue(record.getCode100());
							}
						} else if (j == 7) {
							if (record.getCode110() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "110");
								row.createCell((short) 8).setCellValue(record.getCode110());
							}
						} else if (j == 8) {
							if (record.getCode120() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "120");
								row.createCell((short) 8).setCellValue(record.getCode120());
							}
						} else if (j == 9) {
							if (record.getCode130() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "130");
								row.createCell((short) 8).setCellValue(record.getCode130());
							}
						} else if (j == 10) {
							if (record.getCode160() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "160");
								row.createCell((short) 8).setCellValue(record.getCode160());
							}
						} else if (j == 11) {
							if (record.getCode170() != 0) {
								k += 1;
								row = sheet.createRow((int) k);
								row.createCell((short) 0).setCellValue(record.getProductId() + "170");
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
						+ "-" + record.getProductId() + "-" + record.getClothName() + ".xls"));
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
	@RequestMapping("tozip")
	@ResponseBody
	public void tozip(HttpServletRequest request, HttpServletResponse response, String file) throws Exception {
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
		// log.debug("生成Excel表并压缩");
	}

	/**
	 * 删除临时文件夹
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
	 * 生成Excel
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("toExcel")
	@ResponseBody
	public List<ApparelDevelopmentReturn> toExcel(ApparelDevelopmentReturn developmentReturn,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("服装返单");
		HSSFRow row = sheet.createRow((int) 0);
		sheet.setColumnWidth(0, 18 * 256);
		sheet.setColumnWidth(1, 18 * 256);
		sheet.setColumnWidth(2, 17 * 256);
		sheet.setColumnWidth(5, 15 * 256);
		sheet.setColumnWidth(6, 15 * 256);
		sheet.setColumnWidth(20, 14 * 256);
		sheet.setColumnWidth(21, 14 * 256);
		sheet.setColumnWidth(22, 16 * 256);
		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("图片");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("链接");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("款式类型名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("原波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("供应商编码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("编码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("52码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("59码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("66码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("73码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("80码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("90码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("100码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("110码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("120码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("130码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("160码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 19);
		cell.setCellValue("170");
		cell.setCellStyle(style);
		cell = row.createCell((short) 20);
		cell.setCellValue("工厂");
		cell.setCellStyle(style);
		cell = row.createCell((short) 21);
		cell.setCellValue("预计出货日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 22);
		cell.setCellValue("销售预计");
		cell.setCellStyle(style);
		cell = row.createCell((short) 23);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到
		int length = this.developmenReturnService.toExcelNum(developmentReturn);
		for (int i = 0; i < length; i++) {
			List<ApparelDevelopmentReturn> returns = developmenReturnService.toExcel(developmentReturn);
			ApparelDevelopmentReturn record = returns.get(i);
			row = sheet.createRow((int) i + 1);// 新增行
			sheet.createRow(i + 1).setHeight((short) (90 * 20));// 设置行高
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
			row.createCell((short) 1).setCellValue("https://item.taobao.com/item.htm?id=" + record.getGoodsId());
			row.createCell((short) 2).setCellValue(record.getClothName());
			row.createCell((short) 3).setCellValue(record.getGirard());
			row.createCell((short) 4).setCellValue(record.getOriginalWave());
			row.createCell((short) 5).setCellValue(record.getVendorCode());
			row.createCell((short) 6).setCellValue(record.getProductId());
			row.createCell((short) 7).setCellValue(record.getCount());
			row.createCell((short) 8).setCellValue(record.getCode52());
			row.createCell((short) 9).setCellValue(record.getCode59());
			row.createCell((short) 10).setCellValue(record.getCode66());
			row.createCell((short) 11).setCellValue(record.getCode73());
			row.createCell((short) 12).setCellValue(record.getCode80());
			row.createCell((short) 13).setCellValue(record.getCode90());
			row.createCell((short) 14).setCellValue(record.getCode100());
			row.createCell((short) 15).setCellValue(record.getCode110());
			row.createCell((short) 16).setCellValue(record.getCode120());
			row.createCell((short) 17).setCellValue(record.getCode130());
			row.createCell((short) 18).setCellValue(record.getCode160());
			row.createCell((short) 19).setCellValue(record.getCode170());

			row.createCell((short) 21).setCellValue(record.getExpectTime());
			row.createCell((short) 23).setCellValue(record.getRemark());
		}
		// 选择下载路径弹出框
		String file = "服装返单表.xls";// 文件名
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
	 * 根据id查询数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("selApparelDevelopmentReturnById")
	@ResponseBody
	public ApparelDevelopmentReturn selApparelDevelopmentReturnById(Integer id) {
		ApparelDevelopmentReturn result = this.developmenReturnService.selApparelDevelopmenReturnById(id);
		return result;
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppApparelDevelopmentReturn")
	@ResponseBody
	public int uppApparelDevelopmentReturn(ApparelDevelopmentReturn record) {
		int flag = 0;
		flag = this.developmenReturnService.uppApparelDevelopmenReturn(record);
		return flag;
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param record
	 * @return
	 */
	@RequestMapping("apparelDevelopmentReturnBystate")
	@ResponseBody
	public Map<String, Object> apparelDevelopmentReturnBystate(PageUtil page, ApparelDevelopmentReturn record,
			Integer type) {
		System.err.println(type);
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每一页多少条数据
		// 已完成
		if (type == 0) {
			page.setTotolCount(developmenReturnService.selApparelDevelopmentReturnCountover(record));// 一共多少条数据
			List<ApparelDevelopmentReturn> developmentReturns = developmenReturnService
					.developmentReturnsover(new ApparelDevelopmentReturn(record.getGirard(), record.getDesigner(),
							record.getOriginalWave(), record.getReferWave(), record.getPrintWave(), record.getModel(),
							record.getProductId(), record.getVendorCode(), record.getClothName(), record.getSizeChart(),
							page.getReqult()[0], page.getReqult()[1]));
			map.put("pageUtil", page); // 在map中写入数据对象
			map.put("dataList", developmentReturns);
			return map;
		} else {
			// 采购中
			page.setTotolCount(developmenReturnService.selApparelDevelopmentReturnCounting(record));// 一共多少条数据
			List<ApparelDevelopmentReturn> developmentReturns = developmenReturnService
					.developmentReturnsing(new ApparelDevelopmentReturn(record.getGirard(), record.getDesigner(),
							record.getOriginalWave(), record.getReferWave(), record.getPrintWave(), record.getModel(),
							record.getProductId(), record.getVendorCode(), record.getClothName(), record.getSizeChart(),
							page.getReqult()[0], page.getReqult()[1]));
			map.put("pageUtil", page); // 在map中写入数据对象
			map.put("dataList", developmentReturns);
			log.info("查询返单信息");
			return map;
		}
	}

}
