package com.warehouse.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.FinanceAccountReconciliation;
import com.warehouse.service.FinanceAccountReconciliationService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.StringUtil;

@Controller
@RequestMapping("financeAccountReconciliation")
public class FinanceAccountReconciliationController {

	@Resource
	private FinanceAccountReconciliationService financeAccountReconciliationService;
	private Logger log = LoggerFactory.getLogger(FinanceAccountReconciliationController.class);

	/**
	 * 对账单分页查询
	 * 
	 * @param page
	 * @param record
	 * @return
	 */
	@RequestMapping("selfinanceAccountReconciliationbyPage")
	@ResponseBody
	public Map<String, Object> selfinanceAccountReconciliationbyPage(PageUtil page,
			FinanceAccountReconciliation record) {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(15);
		page.setTotolCount(financeAccountReconciliationService.getCountByPrimaryKey(record));
		List<FinanceAccountReconciliation> financeAccountReconciliations = financeAccountReconciliationService
				.selectByPrimaryKeyPage(new FinanceAccountReconciliation(page.getReqult()[0], page.getReqult()[1],
						record.getFactory(), record.getWave(), record.getProductCode(), record.getProductName(),
						record.getOrderType(), record.getReconciliationTime()));
		map.put("pageUtil", page);
		map.put("dataList", financeAccountReconciliations);
		log.info("对账单分页查询");
		return map;
	}

	/**
	 * 导入
	 *
	 * @param request
	 * @param response
	 * @param fileStream
	 * @return
	 */
	@RequestMapping("inFinanceAccountReconciliation")
	@ResponseBody
	public Object inFinanceAccountReconciliation(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("importFile") MultipartFile fileStream) {
		String flag = "0";
		// 判断文件
		if (fileStream.getSize() != 0) {
			try {
				String sqls = "";
				// 上传文件名字
				String fileName = fileStream.getOriginalFilename();
				// 文件类型
				String fileExt = fileName.substring(fileName.indexOf("."));
				InputStream is = fileStream.getInputStream();
				// 判断后缀名
				if (fileExt.equals(".xls")) {
					HSSFWorkbook workbook = new HSSFWorkbook(is);
					// 工作表
					HSSFSheet sheet = workbook.getSheetAt(0);
					// hssrow 行 hssrow.getCell 代表的是获取这一行的第几列
					// 循环行数
					for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
						HSSFRow hssRow = sheet.getRow(rowNum);
						String wave = (hssRow.getCell(1) != null) && !"".equals(hssRow.getCell(1))
								? hssRow.getCell(1).toString() : null;
						String factory = (hssRow.getCell(2) != null) && !"".equals(hssRow.getCell(2))
								? hssRow.getCell(2).toString() : null;
						String orderType = (hssRow.getCell(6) != null) && !"".equals(hssRow.getCell(6))
								? hssRow.getCell(6).toString() : null;// 订单类型
						String reconciliationUtil = (hssRow.getCell(7) != null) && !"".equals(hssRow.getCell(7))
								? hssRow.getCell(7).toString() : null;// 单位
						int cropNumber = (hssRow.getCell(8) != null) ? StringUtil.toInteger(hssRow.getCell(8)) : 0;// 裁剪数
						double reconciliationUnitPrice = (hssRow.getCell(9) != null)
								? StringUtil.toDouble(hssRow.getCell(9)) : 0;// 单价
						int shipmentNum = (hssRow.getCell(10) != null) ? StringUtil.toInteger(hssRow.getCell(10)) : 0;// 出货数
						double deliveryTotal = shipmentNum * reconciliationUnitPrice;// 应付款数
						String deviationNum = (hssRow.getCell(12) != null) && !"".equals(hssRow.getCell(12))
								? hssRow.getCell(12).toString() : null;// 误差
						String remark = (hssRow.getCell(15) != null) && !"".equals(hssRow.getCell(15))
								? hssRow.getCell(15).toString() : null;// 备注
						int actualDeliveryNum = (hssRow.getCell(13) != null) ? StringUtil.toInteger(hssRow.getCell(13))
								: 0;// 实际到货数
						String factoryFeedback = (hssRow.getCell(14) != null) && !"".equals(hssRow.getCell(14))
								? hssRow.getCell(14).toString() : null;// 工厂反馈
						String reconciliationTime = "";// 时间
						// 判断单元格是否属于日期格式
						if (!"".equals(hssRow.getCell(0).getDateCellValue())
								&& hssRow.getCell(0).getDateCellValue() != null) {
							Date date = hssRow.getCell(0).getDateCellValue();
							SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
							reconciliationTime = dff.format(date); // 日期转化
						}
						if (wave == null) {
							break;
						} else {
							// financeAccountReconciliationService.insertSelective(record);
							String sql = "INSERT INTO `finance_account_reconciliation` VALUES (null, '" + wave + "', '"
									+ factory + "', null,null,null,'" + orderType + "', '" + reconciliationUtil + "', '"
									+ cropNumber + "', '" + shipmentNum + "', '" + reconciliationUnitPrice + "', '"
									+ deliveryTotal + "', '" + deviationNum + "', '" + reconciliationTime + "', '"
									+ actualDeliveryNum + "', '" + factoryFeedback + "', '" + remark
									+ "', now(), null, null, '1'); ";
							sqls = sqls + sql;
						}
					}
					financeAccountReconciliationService.insertSelectiveByExcle(sqls);
					flag = "1";
				} else if (fileExt.equals(".xlsx")) {
					// System.err.println("xlsx");
					// XSSFWorkbook workbook = new XSSFWorkbook(is);
					// XSSFSheet sheet = workbook.getSheetAt(0);
					// for (int rowNum = 1; rowNum <= sheet.getLastRowNum();
					// rowNum++) {
					// XSSFRow xssRow = sheet.getRow(rowNum);
					// }
					flag = "2";
					System.err.println("格式暂不支持");
				}
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		log.info("导入Excel表");
		return flag;
	}

	/**
	 * 双击修改
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("dbuppFinanceAccountReconciliation")
	@ResponseBody
	public int dbuppFinanceAccountReconciliation(FinanceAccountReconciliation record) {
		log.info("双击修改");
		return financeAccountReconciliationService.updateByPrimaryKeySelective(record);
	}

	/**
	 * 财务对账单模板下载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("downFinanceModel")
	@ResponseBody
	@SuppressWarnings("deprecation")
	public void downFinanceModel(HttpServletRequest request, HttpServletResponse response) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("财务对账单");
		// 设置字体
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);// HSSFColor.VIOLET.index //字体颜色
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体增粗

		sheet.createRow(0).setHeight((short) (20 * 20));// 设置表头行高
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);// 把字体应用到当前的样式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("出货时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("波次");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("工厂");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("商品编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("商品名称");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("商品图片");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("订单类型");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("单位");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("裁剪数");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("价格");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("出货数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("应付款数");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("误差数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("实际到货数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("工厂反馈");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		// 选择下载路径弹出框
		String file = "财务对账单.xls";// 文件名
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
