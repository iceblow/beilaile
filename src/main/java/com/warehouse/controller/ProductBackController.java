package com.warehouse.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ProductBack;
//import com.warehouse.entity.SalesSkuOfWdt;
import com.warehouse.service.ProductBackService;
import com.warehouse.service.SalesReportOfWdtService;
import com.warehouse.service.SalesSkuOfWdtService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.StringUtil;

@Controller
@RequestMapping("productBack")
public class ProductBackController {

	private Logger log = LoggerFactory.getLogger(ProductBackController.class);
	@Resource
	private ProductBackService productBackService;
	@Resource
	private SalesSkuOfWdtService salesSkuOfWdtService;
	@Resource
	private SalesReportOfWdtService salesReportOfWdtService;

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param productBack
	 * @return
	 */
	@RequestMapping("selProductBack")
	@ResponseBody
	public Map<String, Object> selProductBack(PageUtil page, ProductBack productBack) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示数量
		page.setTotolCount(this.productBackService.getCountByPage(productBack));// 获取总数据数量
		List<ProductBack> productBacks = this.productBackService
				.getDataByPage(new ProductBack(page.getReqult()[0], page.getReqult()[1], productBack.getGirardOld(),
						productBack.getProductcodes(), productBack.getProductname(), productBack.getProductshortname(),
						productBack.getExclefile(), productBack.getProductoldname()));
		map.put("dataList", productBacks);
		map.put("pageUtil", page);
		log.info("查询所有的申请信息！");
		return map;
	}

	/**
	 * 根据id查询
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("toProductBack")
	@ResponseBody
	public ProductBack toProductBack(Integer id, Integer delb) {
		ProductBack productBack = productBackService.getOne(id);
		productBack.setDelb(delb);
		this.productBackService.uppProduct(productBack);
		return productBack;
	}

	/**
	 * 导入销售数据
	 *
	 * @param request
	 * @param response
	 * @param fileStream
	 * @return
	 */
	@RequestMapping(value = "inputSalesSkuOfWdt")
	@ResponseBody
	public Object inputSalesSkuOfWdt(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("importSalesSkuData") MultipartFile fileStream) {
		// 实体
		// SalesSkuOfWdt salesSkuOfWdt = new SalesSkuOfWdt();
		String flag = "0";
		// 判断文件
		if (fileStream.getSize() != 0) {
			this.salesSkuOfWdtService.delSelective();
			try {
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
					String longString = "";
					for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
						HSSFRow hssRow = sheet.getRow(rowNum);
						// 商家编码
						String aliaeCode = (hssRow.getCell(0) != null) && !"".equals(hssRow.getCell(0))
								? hssRow.getCell(0).toString() : null;
						// 实际销售量
						int totalNum = (hssRow.getCell(1) != null) ? StringUtil.toInteger(hssRow.getCell(1)) : 0;
						// salesSkuOfWdt.setAliaeCode(aliaeCode);
						// salesSkuOfWdt.setTotalNum(totalNum);
						// if (aliaeCode == null) {
						// break;
						// } else {
						String str = "insert into sales_sku_of_wdt values('" + aliaeCode + "','" + totalNum + "');";
						longString = longString + str;
						if (rowNum % 2000 == 0 || rowNum == sheet.getLastRowNum()) {
							// System.err.println("rowNum=====" + rowNum);
							salesSkuOfWdtService.insertSelective(longString);
							longString = "";
						}
						// }
					}
					flag = "1";
				} else if (fileExt.equals(".xlsx")) {
					System.err.println("xlsx");
					// XSSFWorkbook workbook = new XSSFWorkbook(is);
					// XSSFSheet sheet = workbook.getSheetAt(0);
					// for (int rowNum = 1; rowNum <= sheet.getLastRowNum();
					// rowNum++) {
					// XSSFRow xssRow = sheet.getRow(rowNum);
					// }
					System.err.println("格式暂不支持");
					flag = "2";
				}
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		log.debug("导入销售数据");
		return flag;
	}

	/**
	 * 导入库存数据
	 *
	 * @param request
	 * @param response
	 * @param fileStream
	 * @return
	 */
	@RequestMapping(value = "inputSalesReportOfWdt")
	@ResponseBody
	public Object inputSalesReportOfWdt(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("importSalesReportData") MultipartFile fileStream) {
		// long startTime = System.currentTimeMillis(); // 获取开始时间
		// 实体 SalesReportOfWdt salesReportOfWdt = new SalesReportOfWdt();
		String flag = "0";
		// 判断文件
		if (fileStream.getSize() != 0) {
			salesReportOfWdtService.delSelective();
			try {
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
					String longString = "";
					// 循环行数
					for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
						HSSFRow hssRow = sheet.getRow(rowNum);
						String aLIAE_CODE = (hssRow.getCell(0) != null) && !"".equals(hssRow.getCell(0))
								? hssRow.getCell(0).toString() : null;
						String pRODUCT_CODE = (hssRow.getCell(1) != null) && !"".equals(hssRow.getCell(1))
								? hssRow.getCell(1).toString() : null;
						String pRODUCT_NAME = (hssRow.getCell(2) != null) && !"".equals(hssRow.getCell(2))
								? hssRow.getCell(2).toString() : null;
						int sTOCK_NUM = (hssRow.getCell(3) != null) ? StringUtil.toInteger(hssRow.getCell(3)) : 0;
						int sALES_7DAYS = (hssRow.getCell(4) != null) ? StringUtil.toInteger(hssRow.getCell(4)) : 0;
						int sALES_14DAYS = (hssRow.getCell(5) != null) ? StringUtil.toInteger(hssRow.getCell(5)) : 0;
						int sALES_30DAYS = (hssRow.getCell(6) != null) ? StringUtil.toInteger(hssRow.getCell(6)) : 0;
						int sALES_TATOAL = (hssRow.getCell(7) != null) ? StringUtil.toInteger(hssRow.getCell(7)) : 0;
						// salesReportOfWdt.setALIAE_CODE(aLIAE_CODE);
						// salesReportOfWdt.setPRODUCT_CODE(pRODUCT_CODE);
						// salesReportOfWdt.setPRODUCT_NAME(pRODUCT_NAME);
						// salesReportOfWdt.setSTOCK_NUM(sTOCK_NUM);
						// salesReportOfWdt.setSALES_7DAYS(sALES_7DAYS);
						// salesReportOfWdt.setSALES_14DAYS(sALES_14DAYS);
						// salesReportOfWdt.setSALES_30DAYS(sALES_30DAYS);
						// salesReportOfWdt.setSALES_TATOAL(sALES_TATOAL);
						if (aLIAE_CODE == null) {
							continue;
						} else {
							// salesReportOfWdtService.insertSelective(salesReportOfWdt);
							String str = "INSERT INTO sales_report_of_wdt VALUES ('" + aLIAE_CODE + "', '"
									+ pRODUCT_CODE + "', '" + pRODUCT_NAME + "', '" + sTOCK_NUM + "', '0' ,'"
									+ sALES_7DAYS + "', '" + sALES_14DAYS + "', '" + sALES_30DAYS + "', '"
									+ sALES_TATOAL + "', '0', '0', '0', null, null, null, null);";
							longString = longString + str;
							if (rowNum % 2000 == 0 || rowNum == sheet.getLastRowNum()) {
								// System.err.println("rowNum=====" + rowNum);
								salesReportOfWdtService.insertSelectives(longString);
								longString = "";
							}
						}
					}
					flag = "1";
				} else if (fileExt.equals(".xlsx")) {
					System.err.println("xlsx");
					// XSSFWorkbook workbook = new XSSFWorkbook(is);
					// XSSFSheet sheet = workbook.getSheetAt(0);
					// for (int rowNum = 1; rowNum <= sheet.getLastRowNum();
					// rowNum++) {
					// XSSFRow xssRow = sheet.getRow(rowNum);
					// }
					System.err.println("格式暂不支持");
					flag = "2";
				}
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		log.debug("导入库存数据");
		// long endTime = System.currentTimeMillis(); // 获取结束时间
		// System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //
		// 输出程序运行时间
		return flag;
	}

	@RequestMapping(value = "analysis")
	@ResponseBody
	private Integer analysis() {
		Integer flag = 0;
		try {
			this.productBackService.analysis();
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}
	/**
	 * 添加
	 *
	 * @param productBack
	 * @return
	 */
	/*
	 * @RequestMapping("addProductBack")
	 * 
	 * @ResponseBody public int addProductBack(ProductBack productBack) { int
	 * flag = 0; Integer code1 = productBack.getCode52() == null ? 0 :
	 * productBack.getCode52(); Integer code2 = productBack.getCode59() == null
	 * ? 0 : productBack.getCode59(); Integer code3 = productBack.getCode66() ==
	 * null ? 0 : productBack.getCode66(); Integer code4 =
	 * productBack.getCode73() == null ? 0 : productBack.getCode73(); Integer
	 * code5 = productBack.getCode80() == null ? 0 : productBack.getCode80();
	 * Integer code6 = productBack.getCode90() == null ? 0 :
	 * productBack.getCode90(); Integer code7 = productBack.getCode100() == null
	 * ? 0 : productBack.getCode100(); Integer code8 = productBack.getCode110()
	 * == null ? 0 : productBack.getCode110(); Integer code9 =
	 * productBack.getCode120() == null ? 0 : productBack.getCode120(); Integer
	 * code10 = productBack.getCode130() == null ? 0 : productBack.getCode130();
	 * Integer code11 = productBack.getCode160() == null ? 0 :
	 * productBack.getCode160(); Integer code12 = productBack.getCode170() ==
	 * null ? 0 : productBack.getCode170(); Integer total = code1 + code2 +
	 * code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11 +
	 * code12;
	 * 
	 * productBack.setTotal(total); flag =
	 * productBackService.addProduct(productBack); return flag; }
	 * 
	 */
	/**
	 * 删除
	 *
	 * @param productBack
	 * @return
	 */
	/*
	 * @RequestMapping("delProductBack")
	 * 
	 * @ResponseBody public int delProductBack(ProductBack productBack) { int
	 * flag = 0; flag = productBackService.delProduct(productBack);
	 * log.debug("删除申请信息！"); return flag; }
	 * 
	 *//**
		 * 修改
		 *
		 * @param productBack
		 * @return
		 *//*
		 * @RequestMapping("uppProductBack")
		 * 
		 * @ResponseBody public int uppProductBack(ProductBack productBack) {
		 * int flag = 0; Integer code1 = productBack.getCode52() == null ? 0 :
		 * productBack.getCode52(); Integer code2 = productBack.getCode59() ==
		 * null ? 0 : productBack.getCode59(); Integer code3 =
		 * productBack.getCode66() == null ? 0 : productBack.getCode66();
		 * Integer code4 = productBack.getCode73() == null ? 0 :
		 * productBack.getCode73(); Integer code5 = productBack.getCode80() ==
		 * null ? 0 : productBack.getCode80(); Integer code6 =
		 * productBack.getCode90() == null ? 0 : productBack.getCode90();
		 * Integer code7 = productBack.getCode100() == null ? 0 :
		 * productBack.getCode100(); Integer code8 = productBack.getCode110() ==
		 * null ? 0 : productBack.getCode110(); Integer code9 =
		 * productBack.getCode120() == null ? 0 : productBack.getCode120();
		 * Integer code10 = productBack.getCode130() == null ? 0 :
		 * productBack.getCode130(); Integer code11 = productBack.getCode160()
		 * == null ? 0 : productBack.getCode160(); Integer code12 =
		 * productBack.getCode170() == null ? 0 : productBack.getCode170();
		 * Integer total = code1 + code2 + code3 + code4 + code5 + code6 + code7
		 * + code8 + code9 + code10 + code11 + code12;
		 * productBack.setTotal(total); flag =
		 * productBackService.uppProduct(productBack); log.debug("修改申请信息！");
		 * return flag; }
		 */
}
