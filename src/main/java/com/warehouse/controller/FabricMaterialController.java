package com.warehouse.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.FabricMaterial;
import com.warehouse.service.FabricLibraryService;
import com.warehouse.service.FabricMaterialService;
import com.warehouse.util.Page;
import com.warehouse.util.StringUtil;

/**
 * 
 * @author Beilaile 2016年12月12日18:12:12
 *
 */
@Controller
public class FabricMaterialController {

	@Resource
	public FabricMaterialService fabricMaterialService;
	@Resource
	public FabricLibraryService fabricLibraryService;

	@RequestMapping("addFabricMaterial.do")
	@ResponseBody
	public int addFabricMaterial(FabricMaterial fabricMaterial, HttpServletRequest request) {
		int result = fabricMaterialService.addFabricMaterial(fabricMaterial, request);
		return result;
	}

	@RequestMapping("modifyFabricMaterial.do")
	@ResponseBody
	public int modifyFabricMaterial(FabricMaterial fabricMaterial, HttpServletRequest request) {
		int result = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
		return result;
	}

	@RequestMapping("delFabricMaterialById.do")
	@ResponseBody
	public int delFabricMaterialById(FabricMaterial fabricMaterial, HttpServletRequest request) {
		int result = fabricMaterialService.delFabricMaterialById(fabricMaterial, request);
		return result;
	}

	@RequestMapping("getFabricMaterialByPageCount.do")
	@ResponseBody
	public Page<FabricMaterial> getFabricMaterialByPageCount(@RequestParam Map<String, Object> anyVal) {
		int result = fabricMaterialService.getFabricMaterialByPageCount(anyVal);
		Page<FabricMaterial> page = new Page<FabricMaterial>(result, 1);
		return page;
	}

	@RequestMapping("findConditionFabricMaterialByPage.do")
	@ResponseBody
	public List<FabricMaterial> findConditionFabricMaterialByPage(@RequestParam Map<String, Object> anyVal) {
		List<FabricMaterial> list = fabricMaterialService.findConditionFabricMaterialByPage(anyVal);
		return list;
	}

	@RequestMapping("selectFabricMaterialByPageCount.do")
	@ResponseBody
	public Page<FabricMaterial> selectFabricMaterialByPageCount(@RequestParam Map<String, Object> anyVal) {
		int result = fabricMaterialService.selectFabricMaterialByPageCount(anyVal);
		Page<FabricMaterial> page = new Page<FabricMaterial>(result, 1);
		return page;
	}

	@RequestMapping("selectConditionFabricMaterialByPage.do")
	@ResponseBody
	public List<FabricMaterial> selectConditionFabricMaterialByPage(@RequestParam Map<String, Object> anyVal) {
		List<FabricMaterial> list = fabricMaterialService.selectConditionFabricMaterialByPage(anyVal);
		return list;
	}

	@RequestMapping("getFabricMaterialById.do")
	@ResponseBody
	public FabricMaterial getFabricMaterialById(Integer id) {
		FabricMaterial fabricMaterial = fabricMaterialService.getFabricMaterialById(id);
		return fabricMaterial;
	}

	@RequestMapping("updateFabricMaterialByStatus.do")
	@ResponseBody
	public int updateFabricMaterialByStatus(FabricMaterial fabricMaterial, HttpServletRequest request) {
		int result = fabricMaterialService.updateFabricMaterialByStatus(fabricMaterial, request);
		return result;
	}

	@RequestMapping("updateFabricMaterialByPurchase.do")
	@ResponseBody
	public int updateFabricMaterialByPurchase(FabricMaterial fabricMaterial, HttpServletRequest request) {
		int result = fabricMaterialService.updateFabricMaterialByPurchase(fabricMaterial, request);
		return result;
	}

	/**
	 * 生成Excel
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation") // 去掉黄色提醒
	@RequestMapping("findFabricMaterialByExcel.do")
	@ResponseBody
	public List<FabricMaterial> toExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("未采购数据");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 设置行宽
		sheet.setColumnWidth(6, 18 * 256);
		/*
		 * sheet.setColumnWidth(1, 60 * 256); sheet.setColumnWidth(2, 18 * 256);
		 */
		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("设计师");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("原波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("款号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("设计图");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("订单数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("订单明细");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("供应商");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("面料A");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("色号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("门封");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("单间用料");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("米/重量");
		cell.setCellStyle(style);

		cell = row.createCell((short) 15);
		cell.setCellValue("面料B");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("色号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("门封");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("单间用料");
		cell.setCellStyle(style);
		cell = row.createCell((short) 19);
		cell.setCellValue("米/重量");
		cell.setCellStyle(style);

		cell = row.createCell((short) 20);
		cell.setCellValue("面料C");
		cell.setCellStyle(style);
		cell = row.createCell((short) 21);
		cell.setCellValue("色号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 22);
		cell.setCellValue("门封");
		cell.setCellStyle(style);
		cell = row.createCell((short) 23);
		cell.setCellValue("单间用料");
		cell.setCellStyle(style);
		cell = row.createCell((short) 24);
		cell.setCellValue("米/重量");
		cell.setCellStyle(style);

		cell = row.createCell((short) 25);
		cell.setCellValue("面料D");
		cell.setCellStyle(style);
		cell = row.createCell((short) 26);
		cell.setCellValue("色号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 27);
		cell.setCellValue("门封");
		cell.setCellStyle(style);
		cell = row.createCell((short) 28);
		cell.setCellValue("单间用料");
		cell.setCellStyle(style);
		cell = row.createCell((short) 29);
		cell.setCellValue("米/重量");
		cell.setCellStyle(style);

		cell = row.createCell((short) 30);
		cell.setCellValue("面料E");
		cell.setCellStyle(style);
		cell = row.createCell((short) 31);
		cell.setCellValue("色号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 32);
		cell.setCellValue("门封");
		cell.setCellStyle(style);
		cell = row.createCell((short) 33);
		cell.setCellValue("单间用料");
		cell.setCellStyle(style);
		cell = row.createCell((short) 34);
		cell.setCellValue("米/重量");
		cell.setCellStyle(style);

		cell = row.createCell((short) 35);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		cell = row.createCell((short) 36);
		cell.setCellValue("创建时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 37);
		cell.setCellValue("创建人");
		cell.setCellStyle(style);
		cell = row.createCell((short) 38);
		cell.setCellValue("确认采购时间");
		cell.setCellStyle(style);
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<FabricMaterial> list = fabricMaterialService.findFabricMaterialByExcel();
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);// 新增行

			sheet.createRow(i + 1).setHeight((short) (90 * 20));// 设置行高
			FabricMaterial fabricMaterial = (FabricMaterial) list.get(i);
			// 第四步，创建单元格，并设置值
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

			row.createCell((short) 0).setCellValue(fabricMaterial.getId());// 第二列数据
			row.createCell((short) 1)
					.setCellValue(fabricMaterial.getDesigners() == null || fabricMaterial.getDesigners() == "" ? ""
							: fabricMaterial.getDesigners());// 第四列数据
			row.createCell((short) 2)
					.setCellValue(fabricMaterial.getAddDate() == null || fabricMaterial.getAddDate() == "" ? ""
							: fabricMaterial.getAddDate());// 第三列数据
			row.createCell((short) 3)
					.setCellValue(fabricMaterial.getOringinalWave() == null || fabricMaterial.getOringinalWave() == ""
							? "" : fabricMaterial.getOringinalWave());// 第六列数据
			row.createCell((short) 4).setCellValue(
					fabricMaterial.getWave() == null || fabricMaterial.getWave() == "" ? "" : fabricMaterial.getWave());// 第五列数据

			row.createCell((short) 5)
					.setCellValue(fabricMaterial.getClothesStyle() == null || fabricMaterial.getClothesStyle() == ""
							? "" : fabricMaterial.getClothesStyle());// 第七列数据

			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			// 判断数据库图片是否为空
			if (fabricMaterial.getDesignChart() != null) {
				if (fabricMaterial.getDesignChart().length() != 0) {

					String imgPath = rootPath + fabricMaterial.getDesignChart();// 获取图片路径
					File imgFile = new File(imgPath);// 把路径转换成一个流
					// 判断本地图片是否存在!
					if (imgFile.exists()) {// 读入图片
						// 获得图片格式
						String prefix = fabricMaterial.getDesignChart()
								.substring(fabricMaterial.getDesignChart().lastIndexOf(".") + 1);
						bufferImg = ImageIO.read(new File(imgPath));
						ImageIO.write(bufferImg, prefix, byteArrayOut);// 写入流
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 248, (short) 6, i + 1, (short) 7,
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

			/**
			 * 
			 */
			row.createCell((short) 7).setCellValue(
					StringUtil.toDouble((fabricMaterial.getNumberOrder() == null || fabricMaterial.getNumberOrder() == 0
							? "" : fabricMaterial.getNumberOrder())));// 第九列数据
			row.createCell((short) 8)
					.setCellValue(fabricMaterial.getOrderDetails() == null || fabricMaterial.getOrderDetails() == ""
							? "" : fabricMaterial.getOrderDetails());// 第十列数据
			row.createCell((short) 9)
					.setCellValue(fabricMaterial.getSupplier() == null || fabricMaterial.getSupplier() == "" ? ""
							: fabricMaterial.getSupplier());// 第十一列数据
			// a
			row.createCell((short) 10)
					.setCellValue(fabricMaterial.getFabricA() == null || fabricMaterial.getFabricA() == "" ? ""
							: fabricMaterial.getFabricA());// 第十二列数据
			row.createCell((short) 11)
					.setCellValue(fabricMaterial.getFabricAColor() == null || fabricMaterial.getFabricAColor() == ""
							? "" : fabricMaterial.getFabricAColor());// 第三列数据
			row.createCell((short) 12)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricALength() == null || fabricMaterial.getFabricALength() == 0 ? ""
									: fabricMaterial.getFabricALength()));// 第二列数据
			row.createCell((short) 13)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricASingleUse() == null || fabricMaterial.getFabricASingleUse() == 0
									? "" : fabricMaterial.getFabricASingleUse()));// 第三列数据
			row.createCell((short) 14)
					.setCellValue(StringUtil.toDouble(fabricMaterial.getFabricAActualConsumption() == null
							|| fabricMaterial.getFabricAActualConsumption() == 0 ? ""
									: fabricMaterial.getFabricAActualConsumption()));// 第二列数据
			// b
			row.createCell((short) 15)
					.setCellValue(fabricMaterial.getFabricB() == null || fabricMaterial.getFabricB() == "" ? ""
							: fabricMaterial.getFabricB());// 第三列数据
			row.createCell((short) 16)
					.setCellValue(fabricMaterial.getFabricBColor() == null || fabricMaterial.getFabricBColor() == ""
							? "" : fabricMaterial.getFabricBColor());// 第二列数据
			row.createCell((short) 17)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricBLength() == null || fabricMaterial.getFabricBLength() == 0 ? ""
									: fabricMaterial.getFabricBLength()));// 第三列数据
			row.createCell((short) 18)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricBSingleUse() == null || fabricMaterial.getFabricBSingleUse() == 0
									? "" : fabricMaterial.getFabricBSingleUse()));// 第二列数据
			row.createCell((short) 19)
					.setCellValue(StringUtil.toDouble(fabricMaterial.getFabricBActualConsumption() == null
							|| fabricMaterial.getFabricBActualConsumption() == 0 ? ""
									: fabricMaterial.getFabricBActualConsumption()));// 第三列数据
			// c
			row.createCell((short) 20)
					.setCellValue(fabricMaterial.getFabricC() == null || fabricMaterial.getFabricC() == "" ? ""
							: fabricMaterial.getFabricC());// 第三列数据
			row.createCell((short) 21)
					.setCellValue(fabricMaterial.getFabricCColor() == null || fabricMaterial.getFabricCColor() == ""
							? "" : fabricMaterial.getFabricCColor());// 第二列数据
			row.createCell((short) 22)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricCLength() == null || fabricMaterial.getFabricCLength() == 0 ? ""
									: fabricMaterial.getFabricCLength()));// 第三列数据
			row.createCell((short) 23)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricCSingleUse() == null || fabricMaterial.getFabricCSingleUse() == 0
									? "" : fabricMaterial.getFabricCSingleUse()));// 第二列数据
			row.createCell((short) 24)
					.setCellValue(StringUtil.toDouble(fabricMaterial.getFabricCActualConsumption() == null
							|| fabricMaterial.getFabricCActualConsumption() == 0 ? ""
									: fabricMaterial.getFabricCActualConsumption()));// 第三列数据
			// d
			row.createCell((short) 25)
					.setCellValue(fabricMaterial.getFabricD() == null || fabricMaterial.getFabricD() == "" ? ""
							: fabricMaterial.getFabricD());// 第三列数据
			row.createCell((short) 26)
					.setCellValue(fabricMaterial.getFabricDColor() == null || fabricMaterial.getFabricDColor() == ""
							? "" : fabricMaterial.getFabricDColor());// 第二列数据
			row.createCell((short) 27)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricDLength() == null || fabricMaterial.getFabricDLength() == 0 ? ""
									: fabricMaterial.getFabricDLength()));// 第三列数据
			row.createCell((short) 28)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricDSingleUse() == null || fabricMaterial.getFabricDSingleUse() == 0
									? "" : fabricMaterial.getFabricDSingleUse()));// 第二列数据
			row.createCell((short) 29)
					.setCellValue(StringUtil.toDouble(fabricMaterial.getFabricDActualConsumption() == null
							|| fabricMaterial.getFabricDActualConsumption() == 0 ? ""
									: fabricMaterial.getFabricDActualConsumption()));// 第三列数据
			// e
			row.createCell((short) 30)
					.setCellValue(fabricMaterial.getFabricE() == null || fabricMaterial.getFabricE() == "" ? ""
							: fabricMaterial.getFabricE());// 第三列数据
			row.createCell((short) 31)
					.setCellValue(fabricMaterial.getFabricEColor() == null || fabricMaterial.getFabricEColor() == ""
							? "" : fabricMaterial.getFabricEColor());// 第二列数据
			row.createCell((short) 32)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricELength() == null || fabricMaterial.getFabricELength() == 0 ? ""
									: fabricMaterial.getFabricELength()));// 第三列数据
			row.createCell((short) 33)
					.setCellValue(StringUtil.toDouble(
							fabricMaterial.getFabricESingleUse() == null || fabricMaterial.getFabricESingleUse() == 0
									? "" : fabricMaterial.getFabricESingleUse()));// 第二列数据
			row.createCell((short) 34)
					.setCellValue(StringUtil.toDouble(fabricMaterial.getFabricEActualConsumption() == null
							|| fabricMaterial.getFabricEActualConsumption() == 0 ? ""
									: fabricMaterial.getFabricEActualConsumption()));// 第三列数据

			row.createCell((short) 35)
					.setCellValue(fabricMaterial.getRemarks() == null || fabricMaterial.getRemarks() == "" ? ""
							: fabricMaterial.getRemarks());// 第三列数据
			row.createCell((short) 36)
					.setCellValue(fabricMaterial.getCreatedTime() == null || fabricMaterial.getCreatedTime() == "" ? ""
							: fabricMaterial.getCreatedTime());// 第二列数据
			row.createCell((short) 37)
					.setCellValue(fabricMaterial.getFounder() == null || fabricMaterial.getFounder() == "" ? ""
							: fabricMaterial.getFounder());// 第三列数据
			row.createCell((short) 38)
					.setCellValue(fabricMaterial.getModifyTime() == null || fabricMaterial.getModifyTime() == "" ? ""
							: fabricMaterial.getModifyTime());// 第二列数据
		}
		// 选择下载路径弹出框
		String file = "未完成订单数据.xls";// 文件名
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
		return null;
	}

	@RequestMapping("updateFabricMaterialByOverrule.do")
	@ResponseBody
	public int updateFabricMaterialByOverrule(FabricMaterial fabricMaterial, HttpServletRequest request) {
		int result = fabricMaterialService.updateFabricMaterialByOverrule(fabricMaterial, request);
		return result;
	}

	/**
	 * 双击修改时检查面料是否存在
	 *
	 * @param fabricMaterial查询
	 * @return
	 */
	@RequestMapping("findFabricNameByCode.do")
	@ResponseBody
	public int findFabricNameByCode(FabricMaterial fabricMaterial, String type, HttpServletRequest request) {
		int flag = 0;
		if (type.equals("fabricACode")) {
			// 判断面料A的值是否为空
			if ("".equals(fabricMaterial.getFabricACode())) {
				// 赋空值
				fabricMaterial.setFabricA("");
				fabricMaterial.setFabricALength(0.0);
				fabricMaterial.setFabricAColor("");
				// 调用修改的方法
				flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
			} else {
				FabricLibrary fabricLibrary = fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(fabricMaterial.getFabricACode());// 面料A
				if (fabricLibrary != null) {
					fabricMaterial.setFabricA(fabricLibrary.getFabricName());
					String str = fabricLibrary.getColorCode();
					str = str.substring(str.length() - 3, str.length());
					fabricMaterial.setFabricAColor(str + "#" + fabricLibrary.getColorName());
					fabricMaterial.setFabricALength(fabricLibrary.getFabricLength());
					flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("fabricBCode")) {
			// 判断面料A的值是否为空
			if ("".equals(fabricMaterial.getFabricBCode())) {
				// 赋空值
				fabricMaterial.setFabricB("");
				fabricMaterial.setFabricBLength(0.0);
				fabricMaterial.setFabricBColor("");
				// 调用修改的方法
				flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
			} else {
				FabricLibrary fabricLibrary = fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(fabricMaterial.getFabricBCode());// 面料A
				if (fabricLibrary != null) {
					fabricMaterial.setFabricB(fabricLibrary.getFabricName());
					String str = fabricLibrary.getColorCode();
					str = str.substring(str.length() - 3, str.length());
					fabricMaterial.setFabricBColor(str + "#" + fabricLibrary.getColorName());
					fabricMaterial.setFabricBLength(fabricLibrary.getFabricLength());
					flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);

				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("fabricCCode")) {
			// 判断面料A的值是否为空
			if ("".equals(fabricMaterial.getFabricCCode())) {
				// 赋空值
				fabricMaterial.setFabricC("");
				fabricMaterial.setFabricCLength(0.0);
				fabricMaterial.setFabricCColor("");
				// 调用修改的方法
				flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
			} else {
				FabricLibrary fabricLibrary = fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(fabricMaterial.getFabricCCode());// 面料A
				if (fabricLibrary != null) {
					fabricMaterial.setFabricC(fabricLibrary.getFabricName());
					String str = fabricLibrary.getColorCode();
					str = str.substring(str.length() - 3, str.length());
					fabricMaterial.setFabricCColor(str + "#" + fabricLibrary.getColorName());
					fabricMaterial.setFabricCLength(fabricLibrary.getFabricLength());
					flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);

				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("fabricDCode")) {
			// 判断面料A的值是否为空
			if ("".equals(fabricMaterial.getFabricDCode())) {
				// 赋空值
				fabricMaterial.setFabricD("");
				fabricMaterial.setFabricDLength(0.0);
				fabricMaterial.setFabricDColor("");
				// 调用修改的方法
				flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
			} else {
				FabricLibrary fabricLibrary = fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(fabricMaterial.getFabricDCode());// 面料A
				if (fabricLibrary != null) {
					fabricMaterial.setFabricD(fabricLibrary.getFabricName());
					String str = fabricLibrary.getColorCode();
					str = str.substring(str.length() - 3, str.length());
					fabricMaterial.setFabricDColor(str + "#" + fabricLibrary.getColorName());
					fabricMaterial.setFabricDLength(fabricLibrary.getFabricLength());
					flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);

				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("fabricECode")) {
			// 判断面料A的值是否为空
			if ("".equals(fabricMaterial.getFabricECode())) {
				// 赋空值
				fabricMaterial.setFabricE("");
				fabricMaterial.setFabricELength(0.0);
				fabricMaterial.setFabricEColor("");
				// 调用修改的方法
				flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
			} else {
				FabricLibrary fabricLibrary = fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(fabricMaterial.getFabricECode());// 面料A
				if (fabricLibrary != null) {
					fabricMaterial.setFabricE(fabricLibrary.getFabricName());
					String str = fabricLibrary.getColorCode();
					str = str.substring(str.length() - 3, str.length());
					fabricMaterial.setFabricEColor(str + "#" + fabricLibrary.getColorName());
					fabricMaterial.setFabricELength(fabricLibrary.getFabricLength());
					flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);

				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("fabricFCode")) {
			// 判断面料A的值是否为空
			if ("".equals(fabricMaterial.getFabricFCode())) {
				// 赋空值
				fabricMaterial.setFabricF("");
				fabricMaterial.setFabricFLength(0.0);
				fabricMaterial.setFabricFColor("");
				// 调用修改的方法
				flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);
			} else {
				FabricLibrary fabricLibrary = fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(fabricMaterial.getFabricFCode());// 面料A
				if (fabricLibrary != null) {
					fabricMaterial.setFabricF(fabricLibrary.getFabricName());
					String str = fabricLibrary.getColorCode();
					str = str.substring(str.length() - 3, str.length());
					fabricMaterial.setFabricFColor(str + "#" + fabricLibrary.getColorName());
					fabricMaterial.setFabricFLength(fabricLibrary.getFabricLength());

					flag = fabricMaterialService.modifyFabricMaterial(fabricMaterial, request);

				} else {
					flag = 2;
				}
			}
		}

		return flag;
	}

}
