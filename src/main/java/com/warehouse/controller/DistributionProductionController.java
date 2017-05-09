package com.warehouse.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.warehouse.entity.DistributionProduction;
import com.warehouse.service.DistributionProductionService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("/DistributionProduction")
public class DistributionProductionController {

	private Logger log = LoggerFactory.getLogger(ApparelDevelopmenReturnControll.class);
	@Autowired
	private DistributionProductionService DistributionProductionService;
	
	//分页查询
	@RequestMapping("/getDistributionProductionPage.do")
	@ResponseBody
	public Map<String,Object> selectPageFabric(PageUtil page,DistributionProduction distributionProduction){
		Map<String,Object> map=new HashMap<>();
		page.setPageSize(10);
		page.setTotolCount(DistributionProductionService.selectAllCount(distributionProduction));
		List<DistributionProduction> myList = this.DistributionProductionService.getDistributionProductionPage(new DistributionProduction(page.getReqult()[0], page.getReqult()[1], distributionProduction));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息   
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}

	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public int addDistributionProduction(MultipartFile productImgFile, DistributionProduction distributionProduction,
			HttpServletRequest request) {
		return DistributionProductionService.addDistributionProduction(productImgFile, distributionProduction, request);
	}
	
	/**
	 * 修改(有文件的表单提交的修改)
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public int updateDistributionProduction(MultipartFile file1, DistributionProduction distributionProduction,HttpServletRequest request) {
		return DistributionProductionService.updateDistributionProduction(file1, distributionProduction, request);
	}

	/**
	 * 修改（普通的修改，不提交文件，之所以分开写两个修改，是因为有的修改不是提交表单那种， 如果不分开就报
	 * org.springframework.web.multipart.MultipartException: The current request
	 * is not a multipart request] with root cause这个错误）
	 */
	@RequestMapping("updateform")
	@ResponseBody
	public int updateDistributionProductionForm(DistributionProduction distributionProduction) {
		return DistributionProductionService.updateDistributionProductionForm(distributionProduction);
	}

	/**
	 * 根据id查询
	 */
	@RequestMapping("/selectById.do")
	@ResponseBody
	public DistributionProduction selectById(Integer id) {
		return DistributionProductionService.selectById(id);
	}
	
	
	/**
	 * 生成Excel表
	 *
	 * @param request
	 * @param response
	 * @return 
	 * */
	@SuppressWarnings("deprecation")
	@RequestMapping("/downDistributionProduction.do")
	@ResponseBody
	
	public List<DistributionProduction> downDistributionProduction(DistributionProduction distributionProduction,HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("经销单生产");
		HSSFRow row = sheet.createRow((int) 0);
		sheet.setColumnWidth(0, 18 * 256);
		sheet.setColumnWidth(1, 18 * 256);
		sheet.setColumnWidth(2, 17 * 256);
		sheet.setColumnWidth(5, 15 * 256);
		sheet.setColumnWidth(6, 15 * 256);
		sheet.setColumnWidth(20, 14 * 256);
		sheet.setColumnWidth(21, 14 * 256);
		sheet.setColumnWidth(22, 16 * 256);
		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("设计图");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("商品编码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("订单号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("原波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("服装名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("订单明细");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("订单数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("订单类型");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("经销工厂");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("52裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("59裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("66裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("73裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("80裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("90裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("100裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("110裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("120裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 19);
		cell.setCellValue("130裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 20);
		cell.setCellValue("160裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 21);
		cell.setCellValue("170裁");
		cell.setCellStyle(style);
		cell = row.createCell((short) 22);
		cell.setCellValue("跟单员	");
		cell.setCellStyle(style);
		cell = row.createCell((short) 23);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		cell = row.createCell((short) 24);
		cell.setCellValue("要求到货日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 25);
		cell.setCellValue("环节开始时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 26);
		cell.setCellValue("下单时间");
		cell.setCellStyle(style);
		// 选择下载路径弹出框
		
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到
		int length = this.DistributionProductionService.toExcelNum(distributionProduction);
		for (int i = 0; i < length; i++) {
			
			List<DistributionProduction> returns = DistributionProductionService.toExcel(distributionProduction);
			DistributionProduction record = returns.get(i);
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
					//row.createCell((short) 0).setCellValue(record.getProductImg());
					row.createCell((short) 1).setCellValue( record.getProductCode());
					row.createCell((short) 2).setCellValue(record.getOrderId());
					row.createCell((short) 3).setCellValue(record.getOringinalWave());
					row.createCell((short) 4).setCellValue(record.getWave());
					row.createCell((short) 5).setCellValue(record.getClothName());
					row.createCell((short) 6).setCellValue(record.getOrderDetails());
					row.createCell((short) 7).setCellValue(record.getOrderNum());
					row.createCell((short) 8).setCellValue(record.getOrderType());
					row.createCell((short) 9).setCellValue(record.getDistributtionFactory());
					row.createCell((short) 10).setCellValue(record.getS52());
					row.createCell((short) 11).setCellValue(record.getS59());
					row.createCell((short) 12).setCellValue(record.getS66());
					row.createCell((short) 13).setCellValue(record.getS73());
					row.createCell((short) 14).setCellValue(record.getS80());
					row.createCell((short) 15).setCellValue(record.getS90());
					row.createCell((short) 16).setCellValue(record.getS100());
					row.createCell((short) 17).setCellValue(record.getS110());
					row.createCell((short) 18).setCellValue(record.getS120());
					row.createCell((short) 19).setCellValue(record.getS130());
					row.createCell((short) 20).setCellValue(record.getS160());
					row.createCell((short) 21).setCellValue(record.getS170());
					row.createCell((short) 22).setCellValue(record.getTrackingOfficer());
					row.createCell((short) 23).setCellValue(record.getRemark());
					row.createCell((short) 24).setCellValue(record.getPlanInWarehouseTime());
					row.createCell((short) 25).setCellValue(record.getTacheStartTime());
					row.createCell((short) 26).setCellValue(record.getReleaseTime());
				}
				// 选择下载路径弹出框
				String file = "经销单生产.xls";// 文件名
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
				log.debug("生成Excel表");
				return null;
			}

}
