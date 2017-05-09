package com.warehouse.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ApparelDevelopmentReturn;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.FabricSourcing;
import com.warehouse.service.FabricLibraryService;
import com.warehouse.service.FabricSourcingService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;
import com.warehouse.util.StringUtil;

@Controller
public class FabricSourcingController {
	private Logger logger = LoggerFactory.getLogger(FabricSourcingController.class);

	@Resource
	public FabricSourcingService fabricSourcingService;
	@Resource
	public FabricLibraryService fabricLibraryService;

	/**
	 * 添加
	 * 
	 * @param fabricSourcing
	 * @return
	 */
	@RequestMapping(value = "addFabricSourcing.do", method = RequestMethod.POST)
	public String addFabricSourcing(FabricSourcing fabricSourcing, HttpServletRequest request) {
		Date date = new Date();// 当前时间
		double fp1 = fabricSourcing.getParameter1() == null ? 0 : fabricSourcing.getParameter1();// 数据1
		double fp2 = fabricSourcing.getParameter2() == null ? 0 : fabricSourcing.getParameter2();// 数据2
		double fp3 = fabricSourcing.getParameter3() == null ? 0 : fabricSourcing.getParameter3();// 数据3
		double fp4 = fabricSourcing.getParameter4() == null ? 0 : fabricSourcing.getParameter4();// 数据4
		double fp5 = fabricSourcing.getParameter5() == null ? 0 : fabricSourcing.getParameter5();// 数据5
		double fp6 = fabricSourcing.getParameter6() == null ? 0 : fabricSourcing.getParameter6();// 数据6
		double fp7 = fabricSourcing.getParameter7() == null ? 0 : fabricSourcing.getParameter7();// 数据7
		double fp8 = fabricSourcing.getParameter8() == null ? 0 : fabricSourcing.getParameter8();// 数据8
		double fp9 = fabricSourcing.getParameter9() == null ? 0 : fabricSourcing.getParameter9();// 数据9
		double fp10 = fabricSourcing.getParameter10() == null ? 0 : fabricSourcing.getParameter10();// 数据10
		double fp11 = fabricSourcing.getParameter11() == null ? 0 : fabricSourcing.getParameter11();// 数据11
		double fp12 = fabricSourcing.getParameter12() == null ? 0 : fabricSourcing.getParameter12();// 数据12
		double fp13 = fabricSourcing.getParameter13() == null ? 0 : fabricSourcing.getParameter13();// 数据13
		double fp14 = fabricSourcing.getParameter14() == null ? 0 : fabricSourcing.getParameter14();// 数据14
		double fp15 = fabricSourcing.getParameter15() == null ? 0 : fabricSourcing.getParameter15();// 数据15
		double fp16 = fabricSourcing.getParameter16() == null ? 0 : fabricSourcing.getParameter16();// 数据16
		double fp17 = fabricSourcing.getParameter17() == null ? 0 : fabricSourcing.getParameter17();// 数据17
		double fp18 = fabricSourcing.getParameter18() == null ? 0 : fabricSourcing.getParameter18();// 数据18
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		fabricSourcing.setTotalCount(totalCount);
		fabricSourcing.setAddTime(DateUtils.formateDaTime(new Date()));
		fabricSourcing.setState("1");// 状态
		logger.info("添加了一个。。。。。。。。。。。。");
		fabricSourcingService.addFabricSourcing(fabricSourcing, request);
		return "redirect:" + "/fabricSourcing.html";// 返回添加成功页面
	}

	/**
	 * 修改
	 * 
	 * @param fabricSourcing
	 * @return
	 */
	@RequestMapping(value = "modifyFabricSourcing.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFabricSourcing(FabricSourcing fabricSourcing ,HttpServletRequest request) {
		
		if ("".equals(fabricSourcing.getFabricCode())) {
			// 赋空值
			fabricSourcing.setFabricCode("");
		    }else{
		    	FabricLibrary fabricLibrary = fabricLibraryService.findFabricLibraryByFabricLibraryCode(fabricSourcing.getFabricCode());// 面料
			if (fabricLibrary != null) {
				fabricSourcing.setFabricMaterial(fabricLibrary.getFabricName());
				String str = fabricLibrary.getColorCode();
				str = str.substring(str.length() - 3, str.length());
				fabricSourcing.setColour(str + "#" + fabricLibrary.getColorName());
				
				}
		    }
		int reslut = fabricSourcingService.modifyFabricSourcing(fabricSourcing, request);
		
		if (reslut > 0) {
			//
			FabricSourcing fabric = fabricSourcingService.getFabricSourcingById(fabricSourcing.getId());
			double fp1 = fabric.getParameter1() == null ? 0 : fabric.getParameter1();// 数据1
			double fp2 = fabric.getParameter2() == null ? 0 : fabric.getParameter2();// 数据2
			double fp3 = fabric.getParameter3() == null ? 0 : fabric.getParameter3();// 数据3
			double fp4 = fabric.getParameter4() == null ? 0 : fabric.getParameter4();// 数据4
			double fp5 = fabric.getParameter5() == null ? 0 : fabric.getParameter5();// 数据5
			double fp6 = fabric.getParameter6() == null ? 0 : fabric.getParameter6();// 数据6
			double fp7 = fabric.getParameter7() == null ? 0 : fabric.getParameter7();// 数据7
			double fp8 = fabric.getParameter8() == null ? 0 : fabric.getParameter8();// 数据8
			double fp9 = fabric.getParameter9() == null ? 0 : fabric.getParameter9();// 数据9
			double fp10 = fabric.getParameter10() == null ? 0 : fabric.getParameter10();// 数据10
			double fp11 = fabric.getParameter11() == null ? 0 : fabric.getParameter11();// 数据11
			double fp12 = fabric.getParameter12() == null ? 0 : fabric.getParameter12();// 数据12
			double fp13 = fabric.getParameter13() == null ? 0 : fabric.getParameter13();// 数据13
			double fp14 = fabric.getParameter14() == null ? 0 : fabric.getParameter14();// 数据14
			double fp15 = fabric.getParameter15() == null ? 0 : fabric.getParameter15();// 数据15
			double fp16 = fabric.getParameter16() == null ? 0 : fabric.getParameter16();// 数据16
			double fp17 = fabric.getParameter17() == null ? 0 : fabric.getParameter17();// 数据17
			double fp18 = fabric.getParameter18() == null ? 0 : fabric.getParameter18();// 数据18
			int totalCount = 0;// 个数 如果什么都没就是0
			// Map criticalMap = new HashMap<>(); // 好
			double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16,
					fp17, fp18 };// 数组
			for (double i : arr) {
				if (i != 0) {
					totalCount = totalCount + 1;// 循环得到个数
				}
			}
			// 求和
			double totalWeight = fp1 + fp2 + fp3 + fp4 + fp5 + fp6 + fp7 + fp8 + fp9 + fp10 + fp11 + fp12 + fp13 + fp14
					+ fp15 + fp16 + fp17 + fp18;
			// 值差

			// 总金额
			BigDecimal t = new BigDecimal(totalWeight - (fabric.getDifference() == null ? 0 : fabric.getDifference()));
			BigDecimal totalmount = new BigDecimal(0);
			if (fabric.getFabricPrices() != null) {
				totalmount = fabric.getFabricPrices().multiply(t);
			}
			// 邮费
			BigDecimal fabricFreight = new BigDecimal(0);
			if (fabric.getFabricFreight() != null) {
				fabricFreight = fabric.getFabricFreight();
			}
			BigDecimal totalmount1 = totalmount.add(fabricFreight);
			fabricSourcing.setTotalCount(totalCount);
			fabricSourcing.setTotalMount(totalmount1);
			fabricSourcing.setTotalWeight(totalWeight);
			fabricSourcing.setUpdateTime(DateUtils.formateDaTime(new Date()));
			int reslut1 = fabricSourcingService.modifyFabricSourcing(fabricSourcing, request);
			return reslut1;
		} else {
			return reslut;
		}
		

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delFabricSourcing.do", method = RequestMethod.POST)
	@ResponseBody
	public int delFabricSourcing(Integer id, HttpServletRequest request) {
		Date date = new Date();// 当前时间
		int reslut = fabricSourcingService.delFabricSourcing(id, DateUtils.formateDaTime(new Date()), request);
		return reslut;
	}

	/**
	 * 修改状态
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "modifyFabricSourcingPurchasingStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFabricSourcingPurchasingStatus(FabricSourcing fabricSourcing, HttpServletRequest request) {
		int reslut = fabricSourcingService.modifyFabricSourcingPurchasingStatus(fabricSourcing, request);
		return reslut;
	}

	/**
	 * 分页查询
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getFabricSourcingByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FabricSourcing> getFabricSourcingByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = fabricSourcingService.getFabricSourcingByPageCount(anyval);
		Page<FabricSourcing> page = new Page<FabricSourcing>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionFabricSourcingByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricSourcing> findConditionFabricSourcingByPage(@RequestParam Map<String, Object> anyVal) {
		// 当前页
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		// 每页条数
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricSourcing> list = fabricSourcingService.findConditionFabricSourcingByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getFabricSourcingById.do", method = RequestMethod.POST)
	@ResponseBody
	public FabricSourcing getFabricSourcingById(Integer id) {
		FabricSourcing fabricSourcing = fabricSourcingService.getFabricSourcingById(id);
		return fabricSourcing;
	}

	/**
	 * 生成Excel
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("exportCurrentFabricData.do")
	@ResponseBody
	public List<ApparelDevelopmentReturn> exportCurrentFabricData(@RequestParam Map<String, Object> anyVal,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("服装返单");
		HSSFRow row = sheet.createRow((int) 0);
		sheet.setColumnWidth(2, 17 * 256);
		sheet.setColumnWidth(5, 15 * 256);
		sheet.setColumnWidth(6, 15 * 256);
		sheet.setColumnWidth(14, 14 * 256);
		sheet.setColumnWidth(16, 16 * 256);
		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("设计图");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("波次号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("订单数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("供应商");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("合用波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("面料材质");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("颜色");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("预购条数");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("收件人");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("收件地址");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("用料");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("米");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("重量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("价格");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("面料1");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("面料2");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("面料3");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("面料4");
		cell.setCellStyle(style);
		cell = row.createCell((short) 19);
		cell.setCellValue("面料5");
		cell.setCellStyle(style);
		cell = row.createCell((short) 20);
		cell.setCellValue("面料6");
		cell.setCellStyle(style);
		cell = row.createCell((short) 21);
		cell.setCellValue("面料7");
		cell.setCellStyle(style);
		cell = row.createCell((short) 22);
		cell.setCellValue("面料8");
		cell.setCellStyle(style);
		cell = row.createCell((short) 23);
		cell.setCellValue("面料9");
		cell.setCellStyle(style);
		cell = row.createCell((short) 24);
		cell.setCellValue("面料10");
		cell.setCellStyle(style);
		cell = row.createCell((short) 25);
		cell.setCellValue("面料11");
		cell.setCellStyle(style);
		cell = row.createCell((short) 26);
		cell.setCellValue("面料12");
		cell.setCellStyle(style);
		cell = row.createCell((short) 27);
		cell.setCellValue("面料13");
		cell.setCellStyle(style);
		cell = row.createCell((short) 28);
		cell.setCellValue("面料14");
		cell.setCellStyle(style);
		cell = row.createCell((short) 29);
		cell.setCellValue("面料15");
		cell.setCellStyle(style);
		cell = row.createCell((short) 30);
		cell.setCellValue("面料16");
		cell.setCellStyle(style);
		cell = row.createCell((short) 31);
		cell.setCellValue("面料17");
		cell.setCellStyle(style);
		cell = row.createCell((short) 32);
		cell.setCellValue("面料18");
		cell.setCellStyle(style);
		cell = row.createCell((short) 33);
		cell.setCellValue("单位");
		cell.setCellStyle(style);
		cell = row.createCell((short) 34);
		cell.setCellValue("总条数");
		cell.setCellStyle(style);
		cell = row.createCell((short) 35);
		cell.setCellValue("差值");
		cell.setCellStyle(style);
		cell = row.createCell((short) 36);
		cell.setCellValue("求和");
		cell.setCellStyle(style);
		cell = row.createCell((short) 37);
		cell.setCellValue("总金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 38);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		cell = row.createCell((short) 39);
		cell.setCellValue("添加时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 40);
		cell.setCellValue("采购状态");
		cell.setCellStyle(style);
		cell = row.createCell((short) 41);
		cell.setCellValue("邮费");
		cell.setCellStyle(style);
		List<FabricSourcing> list = fabricSourcingService.exportCurrentFabricData(anyVal);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);// 新增行
			sheet.createRow(i + 1).setHeight((short) (90 * 20));// 设置行高
			FabricSourcing record = (FabricSourcing) list.get(i);
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
			row.createCell((short) 1).setCellValue(
					record.getAdditionTime() == null || record.getAdditionTime() == "" ? "" : record.getAdditionTime());

			row.createCell((short) 2)
					.setCellValue(record.getWave() == null || record.getWave() == "" ? "" : record.getWave());

			row.createCell((short) 3).setCellValue(
					record.getNumberOrder() == null || record.getNumberOrder() == "" ? "" : record.getNumberOrder());

			row.createCell((short) 4).setCellValue(
					record.getSupplier() == null || record.getSupplier() == "" ? "" : record.getSupplier());

			row.createCell((short) 5).setCellValue(
					record.getCombinedWave() == null || record.getCombinedWave() == "" ? "" : record.getCombinedWave());
			row.createCell((short) 6)
					.setCellValue(record.getFabricMaterial() == null || record.getFabricMaterial() == "" ? ""
							: record.getFabricMaterial());

			row.createCell((short) 7)
					.setCellValue(record.getColour() == null || record.getColour() == "" ? "" : record.getColour());

			row.createCell((short) 8)
					.setCellValue(record.getScheduledNumber() == null || record.getScheduledNumber() == "" ? ""
							: record.getScheduledNumber());
			row.createCell((short) 9).setCellValue(
					record.getRecipient() == null || record.getRecipient() == "" ? "" : record.getRecipient());

			row.createCell((short) 10)
					.setCellValue(record.getRecipientAddress() == null || record.getRecipientAddress() == "" ? ""
							: record.getRecipientAddress());

			row.createCell((short) 11).setCellValue(
					record.getMaterials() == null || record.getMaterials() == "" ? "" : record.getMaterials());
			row.createCell((short) 12)
					.setCellValue(StringUtil.toDouble(record.getActualDosage() == null || record.getActualDosage() == 0
							? "" : (record.getActualDosage())));

			row.createCell((short) 13).setCellValue(StringUtil
					.toDouble(record.getWeight() == null || record.getWeight() == 0 ? "" : record.getWeight()));

			row.createCell((short) 14)
					.setCellValue(StringUtil.toDouble(record.getFabricPrices() == null ? 0 : record.getFabricPrices()));
			row.createCell((short) 15).setCellValue(StringUtil.toDouble(
					record.getParameter1() == null || record.getParameter1() == 0 ? "" : record.getParameter1()));

			row.createCell((short) 16).setCellValue(StringUtil.toDouble(
					record.getParameter2() == null || record.getParameter2() == 0 ? "" : record.getParameter2()));

			row.createCell((short) 17).setCellValue(StringUtil.toDouble(
					record.getParameter3() == null || record.getParameter3() == 0 ? "" : record.getParameter3()));
			row.createCell((short) 18).setCellValue(StringUtil.toDouble(
					record.getParameter4() == null || record.getParameter4() == 0 ? "" : record.getParameter4()));

			row.createCell((short) 19).setCellValue(StringUtil.toDouble(
					record.getParameter5() == null || record.getParameter5() == 0 ? "" : record.getParameter5()));

			row.createCell((short) 20).setCellValue(StringUtil.toDouble(
					record.getParameter6() == null || record.getParameter6() == 0 ? "" : record.getParameter6()));

			row.createCell((short) 21).setCellValue(StringUtil.toDouble(
					record.getParameter7() == null || record.getParameter7() == 0 ? "" : record.getParameter7()));

			row.createCell((short) 22).setCellValue(StringUtil.toDouble(
					record.getParameter8() == null || record.getParameter8() == 0 ? "" : record.getParameter8()));
			row.createCell((short) 23).setCellValue(StringUtil.toDouble(
					record.getParameter9() == null || record.getParameter9() == 0 ? "" : record.getParameter9()));

			row.createCell((short) 24).setCellValue(StringUtil.toDouble(
					record.getParameter10() == null || record.getParameter10() == 0 ? "" : record.getParameter10()));

			row.createCell((short) 25).setCellValue(StringUtil.toDouble(
					record.getParameter11() == null || record.getParameter11() == 0 ? "" : record.getParameter11()));
			row.createCell((short) 26).setCellValue(StringUtil.toDouble(
					record.getParameter12() == null || record.getParameter12() == 0 ? "" : record.getParameter12()));

			row.createCell((short) 27).setCellValue(StringUtil.toDouble(
					record.getParameter13() == null || record.getParameter13() == 0 ? "" : record.getParameter13()));

			row.createCell((short) 28).setCellValue(StringUtil.toDouble(
					record.getParameter14() == null || record.getParameter14() == 0 ? "" : record.getParameter14()));
			row.createCell((short) 29).setCellValue(StringUtil.toDouble(
					record.getParameter15() == null || record.getParameter15() == 0 ? "" : record.getParameter15()));

			row.createCell((short) 30).setCellValue(StringUtil.toDouble(
					record.getParameter16() == null || record.getParameter16() == 0 ? "" : record.getParameter16()));

			row.createCell((short) 31).setCellValue(StringUtil.toDouble(
					record.getParameter17() == null || record.getParameter17() == 0 ? "" : record.getParameter17()));
			row.createCell((short) 32).setCellValue(StringUtil.toDouble(
					record.getParameter18() == null || record.getParameter18() == 0 ? "" : record.getParameter18()));

			row.createCell((short) 33)
					.setCellValue(record.getKgM() == null || record.getKgM() == "" ? "" : record.getKgM());

			row.createCell((short) 34).setCellValue(StringUtil.toDouble(
					record.getTotalCount() == null || record.getTotalCount() == 0 ? "" : record.getTotalCount()));
			row.createCell((short) 35).setCellValue(StringUtil.toDouble(
					record.getDifference() == null || record.getDifference() == 0 ? "" : record.getDifference()));

			row.createCell((short) 36).setCellValue(StringUtil.toDouble(
					record.getTotalWeight() == null || record.getTotalWeight() == 0 ? "" : record.getTotalWeight()));

			row.createCell((short) 37)
					.setCellValue(StringUtil.toDouble(record.getTotalMount() == null ? "" : record.getTotalMount()));
			row.createCell((short) 38)
					.setCellValue(record.getRemarks() == null || record.getRemarks() == "" ? "" : record.getRemarks());

			row.createCell((short) 39)
					.setCellValue(record.getAddTime() == null || record.getAddTime() == "" ? "" : record.getAddTime());

			row.createCell((short) 40)
					.setCellValue(record.getPurchasingStatus() == null || record.getPurchasingStatus() == "" ? ""
							: record.getPurchasingStatus());
			row.createCell((short) 41).setCellValue(
					StringUtil.toDouble((record.getFabricFreight() == null ? "" : record.getFabricFreight())));

		}
		// 选择下载路径弹出框
		String file = "采购数据.xls";// 文件名
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

		// log.debug("生成Excel表");
		return null;
	}

}
