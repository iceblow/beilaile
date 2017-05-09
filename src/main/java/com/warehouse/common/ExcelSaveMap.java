package com.warehouse.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 读取本地excel到map
 * 
 * @author MQ
 *
 */
public class ExcelSaveMap {
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;

	/**
	 *
	 * * 读取Excel数据内容
	 *
	 * * @param InputStream
	 *
	 * * @return Map 包含单元格数据内容的Map对象
	 *
	 */

	public Map<Integer, String> readExcelContent(InputStream is) {
		Map<Integer, String> content = new HashMap<Integer, String>();
		String str = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				// 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
				// 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
				// str += getStringCellValue(row.getCell((short) j)).trim() +
				// "-";
				// str += getCellFormatValue(row.getCell((short) j)).trim() +
				// "";
				System.err.println("读取内容========" + str);
				System.out.println("读取内容========" + j);
				j++;
			}
			content.put(i, str);
			str = "";
		}
		return content;
	}

	public static void main(String[] args) {
		try {

			// 对读取Excel表格内容测试
			InputStream is = new FileInputStream("D:\\排序.xls");
			ExcelSaveMap saveMap = new ExcelSaveMap();

			Map<Integer, String> map = saveMap.readExcelContent(is);

			System.out.println("获得Excel表格的内容:");
			for (int i = 1; i <= map.size(); i++) {
				System.out.println(map.get(i));
			}
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}
	}
}
