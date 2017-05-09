/******************************************************************************
 * Copyright (C) YYYY ChangSha San Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为XXXXX开发研制。未经本公司正式书面同意，其他任何个人、团体
 * 不得使用、复制、修改或发布本软件.
 *****************************************************************************/

package com.warehouse.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;

/**
 * POI导出Excel工具类
 *
 * @author yang
 * @history 2015-12-07
 * @since JDK1.7
 */
@SuppressWarnings("deprecation")
public class PoiUtils {
	private PoiUtils() {

	}

	/**
	 * 创建字体
	 *
	 * @param workbook
	 *            excel对象
	 * @param fontName
	 *            字体名
	 * @param fontHeight
	 *            字体大小
	 * @param boldWeight
	 *            字体粗细
	 * @param color
	 *            字体颜色
	 * @return 字体对象
	 */
	public static HSSFFont createFont(HSSFWorkbook workbook, String fontName, int fontHeight, short boldWeight,
			short color) {
		HSSFFont fontStyle = workbook.createFont();
		fontStyle.setFontHeight((short) fontHeight);
		fontStyle.setFontName(fontName);
		if (boldWeight > 0) {
			fontStyle.setBoldweight(boldWeight);
		}
		if (color > 0) {
			fontStyle.setColor(color);
		}
		return fontStyle;
	}

	/**
	 * 创建单元格样式
	 *
	 * @param workbook
	 *            excel对象
	 * @param font
	 *            字体
	 * @return 单元格样式
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, HSSFFont font) {
		HSSFCellStyle objCellStyle = workbook.createCellStyle();
		objCellStyle.setFont(font);
		objCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		objCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		objCellStyle.setWrapText(true);
		return objCellStyle;
	}

	/**
	 * 创建单元格样式，可以从另一样式中继承设置
	 *
	 * @param workbook
	 *            excel对象
	 * @param cellStyle
	 *            另一样式
	 * @param font
	 *            字体
	 * @param alignment
	 *            对齐
	 * @return 新样式
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, HSSFCellStyle cellStyle, HSSFFont font,
			short alignment) {
		HSSFCellStyle objNewCellStyle = workbook.createCellStyle();
		objNewCellStyle.setFont(font == null ? workbook.getFontAt(cellStyle.getFontIndex()) : font);
		objNewCellStyle.setAlignment(alignment < 0 ? cellStyle.getAlignment() : alignment);
		objNewCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		objNewCellStyle.setWrapText(true);
		objNewCellStyle.setBorderBottom(cellStyle.getBorderBottom()); // 下边框
		objNewCellStyle.setBorderLeft(cellStyle.getBorderLeft()); // 左边框
		objNewCellStyle.setBorderRight(cellStyle.getBorderRight()); // 右边框
		objNewCellStyle.setBorderTop(cellStyle.getBorderTop()); // 上边框
		return objNewCellStyle;
	}

	/**
	 * 创建行
	 *
	 * @param sheet
	 *            所在工作簿
	 * @param rowId
	 *            行号
	 * @param height
	 *            行高
	 * @return 行对象
	 */
	public static HSSFRow createRow(HSSFSheet sheet, int rowId, int height) {
		HSSFRow objRow = sheet.createRow(rowId);
		if (height > 0) {
			objRow.setHeightInPoints(height);
		}
		return objRow;
	}

	/**
	 * 创建文本类型的单元格
	 *
	 * @param row
	 *            行对象
	 * @param colFrom
	 *            单元格开始列号
	 * @param value
	 *            单元格的值
	 * @param cellStyle
	 *            单元格的样式
	 */
	public static void createStringCell(HSSFRow row, int colFrom, String value, HSSFCellStyle cellStyle) {
		HSSFCell objCell = row.createCell((short) colFrom);
		objCell.setCellValue(new HSSFRichTextString(value));
		objCell.setCellStyle(cellStyle);
		objCell.setCellType(HSSFCell.ENCODING_UTF_16);
	}

	/**
	 * 创建数值类型的单元格
	 *
	 * @param row
	 *            行对象
	 * @param colFrom
	 *            单元格开始列号
	 * @param value
	 *            单元格的值
	 * @param cellStyle
	 *            单元格的样式
	 */
	public static void createNumericCell(HSSFRow row, int colFrom, double value, HSSFCellStyle cellStyle) {
		HSSFCell objCell = row.createCell((short) colFrom);
		objCell.setCellValue(value);
		objCell.setCellStyle(cellStyle);
		objCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
	}

	/**
	 * 合并单元格
	 *
	 * @param sheet
	 *            所在工作簿
	 * @param cellStyle
	 *            合并后单元格的样式
	 * @param rowFrom
	 *            开始行号
	 * @param colFrom
	 *            开始列号
	 * @param rowTo
	 *            结束行号
	 * @param colTo
	 *            结束列号
	 */
	public static void mergeCells(HSSFSheet sheet, HSSFCellStyle cellStyle, int rowFrom, int colFrom, int rowTo,
			int colTo) {
		HSSFRow objRow = null;
		HSSFCell objCell = null;
		for (int i = rowFrom; i <= rowTo; i++) {
			objRow = sheet.getRow(i);
			if (objRow == null) {
				objRow = sheet.createRow(i);
			}
			for (int j = colFrom; j <= colTo; j++) {
				// 主要是为了设置合并单元格的线条，如果不创建则合并单元格的线条会出现问题
				objCell = objRow.getCell((short) j);
				if (objCell == null) {
					objCell = objRow.createCell((short) j);
					objCell.setCellValue(new HSSFRichTextString(""));
					objCell.setCellStyle(cellStyle);
				}
			}
		}
		Region objRegion = new Region(rowFrom, (short) colFrom, rowTo, (short) colTo);
		sheet.addMergedRegion(objRegion);
	}

	/**
	 * 画斜线
	 *
	 * @param patriarch
	 *            工作簿
	 * @param rowFrom
	 *            起点所在行
	 * @param colFrom
	 *            起点所在列
	 * @param rowTo
	 *            终点所在行
	 * @param colTo
	 *            终点所在列
	 */
	public static void drawLine(HSSFPatriarch patriarch, int rowFrom, int colFrom, int rowTo, int colTo) {
		HSSFClientAnchor anchor = new HSSFClientAnchor();
		anchor.setAnchor((short) colFrom, rowFrom, 0, 0, (short) colTo, rowTo, 0, 0);
		patriarch.createSimpleShape(anchor);
	}

	/**
	 * 创建文本类型的单元格
	 *
	 * @param row
	 *            行对象
	 * @param colFrom
	 *            单元格开始列号
	 * @param value
	 *            单元格的值
	 * @param cellStyle
	 *            单元格的样式
	 * @param objWb
	 *            当前工作薄对象
	 */
	public static void createTextStringCell(HSSFRow row, int colFrom, String value, HSSFCellStyle cellStyle,
			HSSFWorkbook objWb) {
		HSSFCell cell = row.createCell((short) colFrom);
		if (cell.getCellType() != 1) {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		}
		HSSFDataFormat format = objWb.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("@"));
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString(value));
	}
}
