package com.warehouse.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.List;
import java.util.Map;

/**
 * 2016年9月8日14:06:38
 */
public class ExcelUtil {
	public static Workbook createWorkBook(List<Map<String, Object>> list, String[] keys, String columnNames[],
			String sheetName) {

		// 创建excel工作簿
		Workbook wb = new HSSFWorkbook(); // 后缀名 xls
		// Workbook wb=new XSSFWorkbook(); //后缀名xlsx
		// 创建第一个sheet（页），并命名
		Sheet sheet = wb.createSheet(sheetName);
		System.out.println(sheet);
		// 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
		for (int i = 0; i < keys.length; i++) {
			sheet.setColumnWidth((short) i, (short) (35.7 * 150));
		}
		// 创建第一行
		Row row = sheet.createRow((short) 0);
		// 创建两种单元格格式
		CellStyle cs = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		// 创建两种字体
		Font f = wb.createFont();
		Font f2 = wb.createFont();
		/**
		 * 样式开始
		 */
		// 创建第一种字体样式（用于列名）
		f.setFontHeightInPoints((short) 10);
		f.setColor(IndexedColors.BLACK.getIndex());
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		// 创建第二种字体样式（用于值）
		f2.setFontHeightInPoints((short) 10);
		f2.setColor(IndexedColors.BLACK.getIndex());
		// 设置第一种单元格的样式（用于列名）
		cs.setFont(f);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setAlignment(CellStyle.ALIGN_CENTER);
		// 设置第二种单元格的样式（用于值）
		cs2.setFont(f2);
		cs2.setBorderLeft(CellStyle.BORDER_THIN);
		cs2.setBorderRight(CellStyle.BORDER_THIN);
		cs2.setBorderTop(CellStyle.BORDER_THIN);
		cs2.setBorderBottom(CellStyle.BORDER_THIN);
		cs2.setAlignment(CellStyle.ALIGN_CENTER);
		/**
		 * 样式结束
		 */
		// 设置列名
		for (int i = 0; i < columnNames.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columnNames[i]);
			cell.setCellStyle(cs);
		}

		// 设置每行每列的值
		if (sheetName.equals("服装设计")) {
			for (short i = 0; i < list.size(); i++) { // 从0开始 因为没有加 sheetname
				// Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
				// 创建一行，在页sheet上
				Row row1 = sheet.createRow((short) i + 1); // 要从
															// i+1行开始输出，因为第一行打印了列名
				// 在row行上创建一个方格
				for (short j = 0; j < keys.length; j++) {
					System.err.println("结果集======" + list.get(i));
					// 当为第四列和第十列的时候,要进行转换
					System.out.println("name=============" + list.get(i).get(keys[j]));
					String name = list.get(i).get(keys[j]).toString();
					Cell cell = (row1.createCell(j) != null) && !"".equals(row1.createCell(j)) ? row1.createCell(j)
							: null;
					cell.setCellValue(name);
					cell.setCellStyle(cs2);
				}
			}
		} else if (sheetName.equals("月销售")) {
			for (short i = 0; i < list.size(); i++) { // 从0开始 因为没有加 sheetname
				// Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
				// 创建一行，在页sheet上
				Row row1 = sheet.createRow((short) i + 1); // 要从
															// i+1行开始输出，因为第一行打印了列名
				// 在row行上创建一个方格
				for (short j = 0; j < list.get(i).size(); j++) {
					// 当为第四列和第十列的时候,要进行转换
					String name = list.get(i).get(keys[j]).toString();
					Cell cell = (row1.createCell(j) != null) && !"".equals(row1.createCell(j)) ? row1.createCell(j)
							: null;
					cell.setCellValue(name);
					cell.setCellStyle(cs2);
				}
			}
		}
		return wb;
	}
}