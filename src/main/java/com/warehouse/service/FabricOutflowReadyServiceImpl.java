package com.warehouse.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricOutflowReadyMapper;
import com.warehouse.entity.FabricOutflowReady;
import com.warehouse.util.PageUtil;

@Service
public class FabricOutflowReadyServiceImpl implements FabricOutflowReadyService {

	@Resource
	private FabricOutflowReadyMapper mapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, FabricOutflowReady ready) {

		pageUtil.setPageSize(10);

		pageUtil.setTotolCount(this.mapper.getCountByPage(ready));

		List<FabricOutflowReady> dataList = this.mapper
				.getDataByPage(new FabricOutflowReady(pageUtil.getReqult()[0], pageUtil.getReqult()[1], ready));

		Map<String, Object> map = new HashMap<>();

		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		return map;
	}

	@Override
	public int completeReady(int id) {
		return this.mapper.completeReady(id);
	}

	@Override
	public int dbUpdateData(FabricOutflowReady ready) {
		return this.mapper.dbUpdateData(ready);
	}

	@Override
	public void toExcle(HttpServletRequest request, HttpServletResponse response, String ids) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("面料配备");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 设置行宽
		for (int i = 0; i < 21; i++) {
			sheet.setColumnWidth(i, 9 * 256);
		}
		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("波次号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("面料材质");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("颜色");
		cell.setCellStyle(style);
		for (int i = 1; i <= 18; i++) {
			cell = row.createCell((short) (i + 2));
			cell.setCellValue("面料" + i);
			cell.setCellStyle(style);
		}
		// 得到id的集合
		String idList = "(" + ids + ")";
		List<FabricOutflowReady> toExcleList = this.mapper.toExcle(idList);
		for (int i = 0; i < toExcleList.size(); i++) {
			row = sheet.createRow((int) i + 1);// 新增行
			FabricOutflowReady ready = toExcleList.get(i);
			row.createCell((short) 0).setCellValue(ready.getWave() == null ? "" : ready.getWave());
			row.createCell((short) 1).setCellValue(ready.getFabricMaterial() == null ? "" : ready.getFabricMaterial());
			row.createCell((short) 2).setCellValue(ready.getColour() == null ? "" : ready.getColour());
			row.createCell((short) 3)
					.setCellValue((String) (ready.getParameter1() == null ? "" : ready.getParameter1()).toString());
			row.createCell((short) 4)
					.setCellValue((String) (ready.getParameter2() == null ? "" : ready.getParameter2()).toString());
			row.createCell((short) 5)
					.setCellValue((String) (ready.getParameter3() == null ? "" : ready.getParameter3()).toString());
			row.createCell((short) 6)
					.setCellValue((String) (ready.getParameter4() == null ? "" : ready.getParameter4()).toString());
			row.createCell((short) 7)
					.setCellValue((String) (ready.getParameter5() == null ? "" : ready.getParameter5()).toString());
			row.createCell((short) 8)
					.setCellValue((String) (ready.getParameter6() == null ? "" : ready.getParameter6()).toString());
			row.createCell((short) 9)
					.setCellValue((String) (ready.getParameter7() == null ? "" : ready.getParameter7()).toString());
			row.createCell((short) 10)
					.setCellValue((String) (ready.getParameter8() == null ? "" : ready.getParameter8()).toString());
			row.createCell((short) 11)
					.setCellValue((String) (ready.getParameter9() == null ? "" : ready.getParameter9()).toString());
			row.createCell((short) 12)
					.setCellValue((String) (ready.getParameter10() == null ? "" : ready.getParameter10()).toString());
			row.createCell((short) 13)
					.setCellValue((String) (ready.getParameter11() == null ? "" : ready.getParameter11()).toString());
			row.createCell((short) 14)
					.setCellValue((String) (ready.getParameter12() == null ? "" : ready.getParameter12()).toString());
			row.createCell((short) 15)
					.setCellValue((String) (ready.getParameter13() == null ? "" : ready.getParameter13()).toString());
			row.createCell((short) 16)
					.setCellValue((String) (ready.getParameter14() == null ? "" : ready.getParameter14()).toString());
			row.createCell((short) 17)
					.setCellValue((String) (ready.getParameter15() == null ? "" : ready.getParameter15()).toString());
			row.createCell((short) 18)
					.setCellValue((String) (ready.getParameter16() == null ? "" : ready.getParameter16()).toString());
			row.createCell((short) 19)
					.setCellValue((String) (ready.getParameter17() == null ? "" : ready.getParameter17()).toString());
			row.createCell((short) 20)
					.setCellValue((String) (ready.getParameter18() == null ? "" : ready.getParameter18()).toString());
		}
		// 选择下载路径弹出框
		String file = "面料配备.xls";// 文件名
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
	}

	@Override
	public int completeSuccess(int id) {
		return this.mapper.completeSuccess(id);
	}

}
