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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.DistributionDealerDelivery;
import com.warehouse.entity.FabricCodeProcessInformation;
import com.warehouse.entity.FabricSourcing;
import com.warehouse.service.FabricCodeProcessInformationService;
import com.warehouse.util.Page;
import com.warehouse.util.StringUtil;
@Controller
public class FabricCodeProcessInformationController {
	@Resource
	FabricCodeProcessInformationService  fabricCodeProcessInformationService;
	
	@RequestMapping(value = "getFabricCodeProcessInfoBpcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FabricCodeProcessInformation> getFabricCodeProcessInfoBpcnt(@RequestParam Map<String, Object> param) {
		
		int result = fabricCodeProcessInformationService.getFabricCodeProcessInfoBpcnt(param);
	
		Page<FabricCodeProcessInformation> page = new Page<>(result,1);

		
		return page;

	}

	/**
	 * 带条件分页查询 ConditiontByPage Cndbp 查询辅料信息列表
	 */
	@RequestMapping(value = "findFabricCodeProcessInfoCndbp.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricCodeProcessInformation> findFabricCodeProcessInfoCndbp(@RequestParam Map<String, Object> param) {
		
		
		
		List<FabricCodeProcessInformation> list = fabricCodeProcessInformationService.findFabricCodeProcessInfoCndbp(param);
	
		return list;
	}
	/**
	 * excel
	 */
	@RequestMapping(value = "exportCurrentFabricCodeData.do", method = RequestMethod.GET)
	@ResponseBody
	public List<FabricCodeProcessInformation> exportCurrentFabricCodeData(@RequestParam Map<String, Object> anyVal,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("面料编号入库信息");
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
		cell.setCellValue("时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("面料商");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("面料类型");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("颜色");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("单价");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("重量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("生成条码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("商家编码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("条码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("供应商货品编码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("最小采购量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("采购量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("采购单位");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("单价");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("折扣");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("税率");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("税后价");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
	
		List<FabricCodeProcessInformation> list = fabricCodeProcessInformationService.exportCurrentFabricCodeProcessData(anyVal);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);// 新增行
			sheet.createRow(i + 1).setHeight((short) (30 * 20));// 设置行高
			FabricCodeProcessInformation record = (FabricCodeProcessInformation) list.get(i);
			// 第四步，创建单元格，并设置值
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			BufferedImage bufferImg = null;
		
			row.createCell((short) 0).setCellValue(
					record.getAdditionTime() == null || record.getAdditionTime() == "" ? "" : record.getAdditionTime());

			row.createCell((short) 1).setCellValue(
					record.getSupplierCode() == null || record.getSupplierCode() == "" ? "" : record.getSupplierCode());

			row.createCell((short) 2)
					.setCellValue(record.getFabricType() == null || record.getFabricType() == "" ? "" : record.getFabricType());

			row.createCell((short) 3).setCellValue(
					record.getFabricColour() == null || record.getFabricColour() == "" ? "" : record.getFabricColour());

			row.createCell((short) 4).setCellValue(
					StringUtil.toDouble (record.getFabricPrices() == null  ? "" : record.getFabricPrices()));

			row.createCell((short) 5).setCellValue(
					StringUtil.toDouble (record.getWeight() == 0 ? "" : record.getWeight()));
			row.createCell((short) 6)
					.setCellValue(record.getProductCode() == null || record.getProductCode() == "" ? ""
							: record.getProductCode());

			row.createCell((short) 7)
					.setCellValue(record.getFabricCode() == null || record.getFabricCode() == "" ? "" : record.getFabricCode());

			row.createCell((short) 8)
					.setCellValue(record.getGenerateBarcode() == null || record.getGenerateBarcode() == "" ? ""
							: record.getGenerateBarcode());
			row.createCell((short) 9).setCellValue(
					record.getSupplierGoodsCode() == null || record.getSupplierGoodsCode() == "" ? "" : record.getSupplierGoodsCode());

			row.createCell((short) 10)
					.setCellValue(record.getMinimumPurchaseAmount() == null || record.getMinimumPurchaseAmount() == "" ? ""
							: record.getMinimumPurchaseAmount());

			row.createCell((short) 11).setCellValue(
					StringUtil.toDouble (record.getTotalCount() == 0 ? "" : record.getTotalCount()));
			row.createCell((short) 12)
					.setCellValue(record.getKgM() == null 
							? "" : (record.getKgM()));

			row.createCell((short) 13).setCellValue(StringUtil.toDouble(record.getFabricPrices() == null  ? "" : record.getFabricPrices()));

			row.createCell((short) 14)
					.setCellValue(StringUtil.toDouble(record.getPurchaseDiscount() == null ? 0 : record.getPurchaseDiscount()));
			row.createCell((short) 15).setCellValue(StringUtil.toDouble(
					record.getTotalMoney() == null ? "" : record.getTotalMoney()));

			row.createCell((short) 16).setCellValue(StringUtil.toDouble(
					record.getTaxRate() == null  ? "" : record.getTaxRate()));

			row.createCell((short) 17).setCellValue(StringUtil.toDouble(
					record.getAfterTaxPrice() == null ? "" : record.getAfterTaxPrice()));
			row.createCell((short) 18).setCellValue(StringUtil.toDouble(
					record.getRemarks() == null  ? "" : record.getRemarks()));

		

		}
		// 选择下载路径弹出框
		String file = "面料编码入库流程信息表.xls";// 文件名
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
