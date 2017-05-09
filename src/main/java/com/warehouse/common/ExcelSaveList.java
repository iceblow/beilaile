package com.warehouse.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelSaveList {

	private static List<List<Object>> list = new ArrayList<List<Object>>();

	public static void main(String[] args) throws Exception {
		excelReader();
		// addlist(args);
	}

	/**
	 * 读取本地表格
	 * 
	 * @throws Exception
	 */
	public static void excelReader() throws Exception {
		// 创建一个新的excel
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("D:\\123.xls"));
		// 创建一个新的excel
		HSSFSheet sheet = wb.getSheetAt(0);
		Object value = "";
		// DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
		// DecimalFormat nf = new DecimalFormat("0");// 格式化数字
		// 迭代行
		for (Iterator<Row> iter = (Iterator<Row>) sheet.rowIterator(); iter.hasNext();) {
			Row row = iter.next();
			// 迭代老列
			List<Object> linked = new ArrayList<Object>();
			for (Iterator<Cell> iter2 = (Iterator<Cell>) row.cellIterator(); iter2.hasNext();) {
				Cell cell = iter2.next();
				switch (cell.getCellType()) {

				case HSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = cell.getNumericCellValue();
					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = cell.getNumericCellValue();
					}
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue();
					break;

				/*
				 * case HSSFCell.CELL_TYPE_NUMERIC: value =
				 * String.valueOf(cell.getNumericCellValue()); break; case
				 * HSSFCell.CELL_TYPE_STRING: value =
				 * cell.getRichStringCellValue().getString(); break; case
				 * HSSFCell.CELL_TYPE_FORMULA: value = cell.getCellFormula();
				 * break;
				 */

				}
				// System.out.println("===========结果集==========" + value);
				linked.add(value);

				// System.err.println("==========dfgffff集==========" + linked);

			}
			list.add(linked);
			System.out.println("=========sdass===========" + list);
		}
		// excelSort();
	}

	public static void excelSort() {
		/*
		 * // 根据价格排序 降序 for (int i = 1; i < list.size(); i++) { for (int j = 0;
		 * j < list.get(i).size(); j++) { for (int k = 2; k < list.get(i).size()
		 * - j; k++) { if (String.valueOf(list.get(k -
		 * 1).get(2)).compareTo(String.valueOf(list.get(k).get(2))) < 0) { //
		 * 比较两个整数的大小 List<Object> temp = (List<Object>) list.get(k - 1);
		 * list.set(k - 1, list.get(k)); list.set(k, temp); } } } }
		 */
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出表格
	 * 
	 * @throws IOException
	 */
	private static void output() throws IOException {
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("sheet1");

		// 设置excel每列宽度

		// 创建字体样式
		HSSFFont font = wb.createFont();
		font.setBoldweight((short) 100);
		font.setFontHeight((short) 300);

		// 创建单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		// 设置边框
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		style.setFont(font);// 设置字体

		// 创建Excel的sheet的一行

		// 给Excel的单元格设置样式和赋值
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			row.setHeight((short) 500);// 设定行的高度
			System.err.println("=======LIST=======" + list.get(i));
			for (int j = 0; j < list.get(i).size(); j++) {

				System.out.println("=======LIST=======" + list.get(i));
				// 创建一个Excel的单元格
				if (true) {
					if (j == 1 && i != 0) {
						// DecimalFormat nf = new DecimalFormat("0");
						HSSFCell cell = row.createCell(j);
						cell.setCellStyle(style);
						String num[] = String.valueOf(list.get(i).get(j)).split("\\.");
						cell.setCellValue(num[0]);
					} else {
						HSSFCell cell = row.createCell(j);
						cell.setCellStyle(style);
						cell.setCellValue(String.valueOf(list.get(i).get(j)));
					}
				}
				if (j == 1 && i != 0) {
					HSSFCell cell = row.createCell(0);
					cell.setCellStyle(style);
					cell.setCellValue(String.valueOf(i));
				}
			}
		}

		FileOutputStream os = new FileOutputStream("D:\\排序(new).xls");
		wb.write(os);
		os.close();
	}

}
