package com.warehouse.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.DistributionBuyMaterial;
import com.warehouse.entity.DistributionReceiveFabric;
import com.warehouse.service.DistributionBuyMaterialService;
import com.warehouse.util.Page;

@Controller
@RequestMapping("/DistributionBuyMaterial")
public class DistributionBuyMaterialController {

	@Autowired
	private DistributionBuyMaterialService DistributionBuyMaterialService;

	/**
	 * 查询总条数
	 */
	@RequestMapping("/getPageCount.do")
	@ResponseBody
	public Page<DistributionBuyMaterial> getAccessoryMaterialByPageCount(@RequestParam Map<String, Object> param) {
		int result = DistributionBuyMaterialService.getPageCount(param);
		Page<DistributionBuyMaterial> page = new Page<DistributionBuyMaterial>(result, 1);
		return page;
	}

	/**
	 * 查询
	 */
	@RequestMapping("/select.do")
	@ResponseBody
	public List<DistributionBuyMaterial> select(@RequestParam Map<String, Object> map) {
		// 转换分页数据格式
		int pageNow = Integer.parseInt(map.get("pageNow").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		map.put("pageNow", pageNow);
		map.put("pageSize", pageSize);
		return DistributionBuyMaterialService.select(map);
	}

	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public int addDistributionBuyMaterial(MultipartFile productImgFile, DistributionBuyMaterial DistributionBuyMaterial,
			HttpServletRequest request) {
		return DistributionBuyMaterialService.addDistributionBuyMaterial(productImgFile, DistributionBuyMaterial,
				request);
	}
	
	/**
	 * 修改(有文件的表单提交的修改)
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public int updateDistributionBuyMaterial(MultipartFile file1, DistributionBuyMaterial DistributionBuyMaterial,
			HttpServletRequest request) {
		return DistributionBuyMaterialService.updateDistributionBuyMaterial(file1, DistributionBuyMaterial, request);
	}

	/**
	 * 修改（普通的修改，不提交文件，之所以分开写两个修改，是因为有的修改不是提交表单那种， 如果不分开就报
	 * org.springframework.web.multipart.MultipartException: The current request
	 * is not a multipart request] with root cause这个错误）
	 */
	@RequestMapping("/updateform.do")
	@ResponseBody
	public int updateDistributionBuyMaterialForm(DistributionBuyMaterial DistributionBuyMaterial) {
		return DistributionBuyMaterialService.updateDistributionBuyMaterialForm(DistributionBuyMaterial);
	}

	/**
	 * 经销单原料采购Excel表格导出
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/downDistributionBuyMaterial.do")
	@ResponseBody
	@SuppressWarnings("deprecation")
	public void downDistributionBuyMaterial(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, Object> param) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("经销单原料采购单");
		// 设置字体
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);// HSSFColor.VIOLET.index //字体颜色
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体增粗

		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		for (int i = 0; i < 17; i++) {
			// 设置单元格宽度
			sheet.setColumnWidth(i, 12 * 259);
		}
		sheet.setColumnWidth(0, 16 * 259);
		sheet.setColumnWidth(3, 16 * 259);
		sheet.setColumnWidth(4, 30 * 259);
		sheet.setColumnWidth(5, 30 * 259);
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);// 把字体应用到当前的样式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("商品编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("原波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("设计图");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("服装名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("订单明细");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("订单数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("预计入库日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("订单类型");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("经销工厂");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("跟单员	");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("下单号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("下单时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("环节开始时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("面料到厂时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("辅料到厂时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		// 加载查询数据
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		int length = DistributionBuyMaterialService.getPageCount(param);
		int pageNow = 1;
		int pageSize = length;
		pageNow = (pageNow - 1) * pageSize;
		param.put("pageNow", pageNow);
		param.put("pageSize", pageSize);
		for (int i = 0; i < length; i++) {
			List<DistributionBuyMaterial> returns = DistributionBuyMaterialService.select(param);
			DistributionBuyMaterial record = returns.get(i);
			row = sheet.createRow((int) i + 1);// 新增行
			sheet.createRow(i + 1).setHeight((short) (90 * 20));// 设置行高
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
						// 获得图片格式
						String prefix = record.getProductImg().substring(record.getProductImg().lastIndexOf(".") + 1);
						try {
							bufferImg = ImageIO.read(new File(imgPath));
							ImageIO.write(bufferImg, prefix, byteArrayOut);// 写入流
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 248, (short) 3, i + 1, (short) 4,
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
			row.createCell((short) 0).setCellValue(record.getProductCode());
			row.createCell((short) 1).setCellValue(record.getOringinalWave());
			row.createCell((short) 2).setCellValue(record.getWave());
			row.createCell((short) 4).setCellValue(record.getClothName());
			// // 图片
			// row.createCell((short) 4).setCellValue(record.getProductImg());
			row.createCell((short) 5).setCellValue(record.getOrderDetails());
			row.createCell((short) 6).setCellValue(record.getOrderNum());
			row.createCell((short) 7).setCellValue(record.getPlanInWarehouseTime());
			row.createCell((short) 8).setCellValue(record.getOrderType());
			row.createCell((short) 9).setCellValue(record.getDistributtionFactory());
			row.createCell((short) 10).setCellValue(record.getTrackingOfficer());
			row.createCell((short) 11).setCellValue(record.getOrderId());
			row.createCell((short) 12).setCellValue(record.getReleaseTime());

			row.createCell((short) 13).setCellValue(record.getTacheStartTime());
			row.createCell((short) 14).setCellValue(record.getFabricArriveFactoryTime());
			row.createCell((short) 15).setCellValue(record.getAccesArriveFactoryTime());
			row.createCell((short) 16).setCellValue(record.getRemark());
		}

		// 选择下载路径弹出框
		String file = "经销单原料采购单.xls";// 文件名
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

}
