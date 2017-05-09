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
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ApparelDevelopmentReturn;
import com.warehouse.entity.DistributionFinishProductPerfect;
import com.warehouse.entity.FabricSourcing;
import com.warehouse.service.DistributionFinishProductPerfectService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.StringUtil;

/**
 * 经销单后道控制器
 * @author admin
 *
 */
@Controller
@RequestMapping("distributionFinishProductPerfect")
public class DistributionFinishProductPerfectController {
	
	@Resource
	private DistributionFinishProductPerfectService distributionFinishProductPerfectService;
	
	/**
	 * 后道分页查询控制器
	 * @param pageUtil 分页信息
	 * @param record 查询参数
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,DistributionFinishProductPerfect record){
	
		return this.distributionFinishProductPerfectService.getDataByPage(pageUtil,record);
	}
	
	/**
	 * 条件修改控制器
	 * @param record
	 * @return
	 */
	@RequestMapping("dblUpdate")
	@ResponseBody
	public int dblUpdate(DistributionFinishProductPerfect record){
		return this.distributionFinishProductPerfectService.dblUpdate(record);
	}
	@RequestMapping("exportCurrentDistributionFinishData.do")
	@ResponseBody
	public List<DistributionFinishProductPerfect> exportCurrentDistributionFinishData(@RequestParam Map<String, Object> anyVal,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("经销单后道");
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
		cell.setCellValue("商品编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("服装名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("原波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("订单明细");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("订单数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("订单类型");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("经销工厂");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("计划入库日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("跟踪员");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("下单号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("下单时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("环节开始时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("工厂报告出货日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("开始出货日期");
		cell.setCellStyle(style);
		
		
		List<DistributionFinishProductPerfect> list = distributionFinishProductPerfectService.exportCurrentDistributionFinishData(anyVal);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);// 新增行
			sheet.createRow(i + 1).setHeight((short) (90 * 20));// 设置行高
			DistributionFinishProductPerfect record = (DistributionFinishProductPerfect) list.get(i);
			// 第四步，创建单元格，并设置值
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			// 判断数据库图片是否为空
			if (record.getProductImg() != null) {
				if (record.getProductImg().length() != 0) {
					String imgPath = rootPath + record.getProductImg();// 获取图片路径
					File imgFile = new File(imgPath);// 把路径转换成一个流
					// 判断本地图片是否存在!
					if (imgFile.exists()) {
						// 读入图片
						// 获得图片格式
						String prefix = record.getProductImg().substring(record.getProductImg().lastIndexOf(".") + 1);
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
					record.getProductCode() == null || record.getProductCode() == "" ? "" : record.getProductCode());

			row.createCell((short) 2)
					.setCellValue(record.getClothName() == null || record.getClothName() == "" ? "" : record.getClothName());

			row.createCell((short) 3).setCellValue(
					record.getOringinalWave() == null || record.getOringinalWave() == "" ? "" : record.getOringinalWave());

			row.createCell((short) 4).setCellValue(
					record.getWave() == null || record.getWave() == "" ? "" : record.getWave());


			row.createCell((short) 5)
					.setCellValue(record.getOrderDetails() == null || record.getOrderDetails() == "" ? ""
							: record.getOrderDetails());
			row.createCell((short) 6).setCellValue(
					(record.getOrderNum() == null || record.getOrderNum() == 0 ? "" : record.getOrderNum().toString()));

			row.createCell((short) 7).setCellValue(
					record.getOrderType() == null || record.getOrderType() == "" ? "" : record.getOrderType());
			row.createCell((short) 8)
					.setCellValue(record.getDistributtionFactory() == null || record.getDistributtionFactory() == "" ? "" : record.getDistributtionFactory());

			row.createCell((short) 9).setCellValue(record.getPlanInWarehouseTime() == null ? "" : record.getPlanInWarehouseTime());

			row.createCell((short) 10)
					.setCellValue( record.getTrackingOfficer() == null ? "" : record.getTrackingOfficer());
			row.createCell((short) 11).setCellValue( record.getRemark() == null ? "" : record.getRemark());

			row.createCell((short) 12).setCellValue((record.getOrderId() == null ? "" : record.getOrderId()));

			row.createCell((short) 13).setCellValue(record.getReleaseTime() == null ? "" : record.getReleaseTime());
			row.createCell((short) 14).setCellValue(record.getTacheStartTime() == null ? "" : record.getTacheStartTime());

			row.createCell((short) 15).setCellValue(record.getFactoryReportDeliver() == null ? "" : record.getFactoryReportDeliver());

			row.createCell((short) 16).setCellValue(record.getStartDeliverTime() == null ? "" : record.getStartDeliverTime());

			
		}
		// 选择下载路径弹出框
		String file = "经销单后道.xls";// 文件名
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
