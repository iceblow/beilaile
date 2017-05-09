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

public class ExcelSaveListSort {

	// public static List list;
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
		// 迭代行
		String content = "";
		// int a = 1;

		for (Iterator<Row> iter = (Iterator<Row>) sheet.rowIterator(); iter.hasNext();) {
			Row row = iter.next();
			// 迭代老列
			List<Object> linked = new ArrayList<Object>();
			for (Iterator<Cell> iter2 = (Iterator<Cell>) row.cellIterator(); iter2.hasNext();) {
				Cell cell = iter2.next();
				// content = cell.getStringCellValue();//
				// 除非是sring类型，否则这样迭代读取会有错误
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC:
					content = String.valueOf(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING:
					content = cell.getRichStringCellValue().getString();
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					content = cell.getCellFormula();
					break;
				}
				linked.add(content);
				System.out.println(linked);
			}
			list.add(linked);
			System.err.println(list);
		}

		excelSort(1, 0); // //index 需要排序的字段位置 必须为number ， sort 0为升序 1为降序
	}

	public static void excelSort(int index, int sort) { // index 需要排序的字段位置
		// 必须为number ， sort 0为升序
		// 1为降序
		// 根据价格排序 降序
		if (sort == 0)
			for (int i = 1; i < list.size(); i++) {
				int min = i; /* 将当前下标定义为最小值下标 */

				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(min).get(index) != null
							&& Double.parseDouble(list.get(min).get(index).toString()) > Double
									.parseDouble(list.get(j).get(index).toString())) { /* 如果有小于当前最小值的关键字 */
						min = j; /* 将此关键字的下标赋值给min */
					}
				}
				if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
					List<Object> tmp = list.get(min);
					list.set(min, list.get(i));
					list.set(i, tmp);
				}
			}
		if (sort == 1)
			for (int i = 1; i < list.size(); i++) {
				int max = i; /* 将当前下标定义为最小值下标 */

				for (int j = i + 1; j < list.size(); j++) {

					if (list.get(max).get(index) != null
							&& Double.parseDouble(list.get(max).get(index).toString()) < Double
									.parseDouble(list.get(j).get(index).toString())) { /* 如果有小于当前最小值的关键字 */
						max = j; /* 将此关键字的下标赋值给min */
					}
				}
				if (i != max) {/* 若min不等于i，说明找到最小值，交换 */
					List<Object> tmp = list.get(max);
					list.set(max, list.get(i));
					list.set(i, tmp);
				}
			}
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
			for (int j = 0; j < list.get(i).size(); j++) {

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
		FileOutputStream os = new FileOutputStream("D:\\123(new).xls");
		wb.write(os);
		os.close();
	}
}
