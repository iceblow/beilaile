package com.warehouse.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.warehouse.entity.ApprovalApplication;
import com.warehouse.service.ApprovalApplicationService;
import com.warehouse.util.ImageGenerated;
import com.warehouse.util.PageUtil;
import com.warehouse.util.StringUtil;

@Controller
@RequestMapping("approvalApplication")
public class ApprovalApplicationController {

	@Resource
	private ApprovalApplicationService applicationService;

	private Logger log = LoggerFactory.getLogger(ApprovalApplicationController.class);

	/***
	 * 分页查询
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@RequestMapping("approvalApplicationByLike")
	@ResponseBody
	public Map<String, Object> approvalApplicationByLike(ApprovalApplication record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示的数据量
		page.setTotolCount(this.applicationService.selApprovalApplicationCount(record));
		List<ApprovalApplication> applications = this.applicationService
				.ApprovalApplicationReturns(new ApprovalApplication(page.getReqult()[0], page.getReqult()[1],
						record.getGirard(), record.getDesigner(), record.getOriginalWave(), record.getReferWave(),
						record.getPrintWave(), record.getModel(), record.getProductId(), record.getVendorCode(),
						record.getClothName(), record.getSizeChart()));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", applications);
		log.info("查询申请审批信息");
		return map;
	}

	/**
	 * 添加
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("addapprovalApplication")
	@ResponseBody
	public int addapprovalApplication(ApprovalApplication record) {
		int flag = 0;
		Integer code1 = record.getCode52() == null ? 0 : record.getCode52();
		Integer code2 = record.getCode59() == null ? 0 : record.getCode59();
		Integer code3 = record.getCode66() == null ? 0 : record.getCode66();
		Integer code4 = record.getCode73() == null ? 0 : record.getCode73();
		Integer code5 = record.getCode80() == null ? 0 : record.getCode80();
		Integer code6 = record.getCode90() == null ? 0 : record.getCode90();
		Integer code7 = record.getCode100() == null ? 0 : record.getCode100();
		Integer code8 = record.getCode110() == null ? 0 : record.getCode110();
		Integer code9 = record.getCode120() == null ? 0 : record.getCode120();
		Integer code10 = record.getCode130() == null ? 0 : record.getCode130();
		Integer code11 = record.getCode160() == null ? 0 : record.getCode160();
		Integer code12 = record.getCode170() == null ? 0 : record.getCode170();
		Integer total = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
				+ code12;
		record.setCount(total);
		flag = this.applicationService.insertSelective(record);
		log.debug("添加申请信息！");
		return flag;
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("selapprovalApplicationById")
	@ResponseBody
	public ApprovalApplication selapprovalApplicationById(Integer id, Integer status) {
		ApprovalApplication application = this.applicationService.selectByPrimaryKey(id);
		if (status == 3) {
			application.setDelb(status);
			applicationService.updateByPrimaryKeySelective(application);
		}
		log.info("根据ID查询！");
		return application;
	}

	/**
	 * 删除
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("delapprovalApplication")
	@ResponseBody
	public int delapprovalApplication(ApprovalApplication record) {
		int flag = this.applicationService.deleteByPrimaryKey(record);
		log.debug("删除审批信息");
		return flag;
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppapprovalApplication")
	@ResponseBody
	public int uppapprovalApplication(ApprovalApplication record) {
		int flag = 0;
		Integer code1 = record.getCode52() == null ? 0 : record.getCode52();
		Integer code2 = record.getCode59() == null ? 0 : record.getCode59();
		Integer code3 = record.getCode66() == null ? 0 : record.getCode66();
		Integer code4 = record.getCode73() == null ? 0 : record.getCode73();
		Integer code5 = record.getCode80() == null ? 0 : record.getCode80();
		Integer code6 = record.getCode90() == null ? 0 : record.getCode90();
		Integer code7 = record.getCode100() == null ? 0 : record.getCode100();
		Integer code8 = record.getCode110() == null ? 0 : record.getCode110();
		Integer code9 = record.getCode120() == null ? 0 : record.getCode120();
		Integer code10 = record.getCode130() == null ? 0 : record.getCode130();
		Integer code11 = record.getCode160() == null ? 0 : record.getCode160();
		Integer code12 = record.getCode170() == null ? 0 : record.getCode170();
		Integer total = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
				+ code12;
		record.setCount(total);
		flag = this.applicationService.updateByPrimaryKeySelective(record);
		log.debug("修改申请信息");
		return flag;
	}

	/**
	 * 导入
	 *
	 * @param request
	 * @param response
	 * @param fileStream
	 * @return
	 */
	@RequestMapping(value = "inputapprovalApplication")
	@ResponseBody
	public Object inputapprovalApplication(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("importFile") MultipartFile fileStream) {
		String flag = "0";
		// 实体 ApprovalApplication appeovalApplication = new
		// ApprovalApplication();
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
						String clothName = (hssRow.getCell(2) != null) && !"".equals(hssRow.getCell(2))
								? hssRow.getCell(2).toString() : null;
						String girard = (hssRow.getCell(3) != null) && !"".equals(hssRow.getCell(3))
								? hssRow.getCell(3).toString() : null;
						String originalWave = (hssRow.getCell(4) != null) && !"".equals(hssRow.getCell(4))
								? hssRow.getCell(4).toString() : null;
						String vendorCode = (hssRow.getCell(5) != null) && (!"".equals(hssRow.getCell(5)))
								? StringUtil.toString(hssRow.getCell(5)).toString() : "";
						String productId = "";
						String bd = (hssRow.getCell(6) != null) && (!"".equals(hssRow.getCell(6)))
								? hssRow.getCell(6).toString() : "";
						if (!bd.equals("")) {
							BigDecimal bd4 = new BigDecimal(bd);
							productId = bd4.toPlainString();
						}
						String remark = (hssRow.getCell(17) != null) && (!"".equals(hssRow.getCell(17)))
								? hssRow.getCell(17).toString() : "";
						int code59 = (hssRow.getCell(8) != null) ? StringUtil.toInteger(hssRow.getCell(8)) : 0;
						int code66 = (hssRow.getCell(9) != null) ? StringUtil.toInteger(hssRow.getCell(9)) : 0;
						int code73 = (hssRow.getCell(10) != null) ? StringUtil.toInteger(hssRow.getCell(10)) : 0;
						int code80 = (hssRow.getCell(11) != null) ? StringUtil.toInteger(hssRow.getCell(11)) : 0;
						int code90 = (hssRow.getCell(12) != null) ? StringUtil.toInteger(hssRow.getCell(12)) : 0;
						int code100 = (hssRow.getCell(13) != null) ? StringUtil.toInteger(hssRow.getCell(13)) : 0;
						String expectTime = "";
						// if (DateUtil.isCellDateFormatted(hssRow.getCell(15)))
						// {
						// 判断单元格是否属于日期格式
						if (!"".equals(hssRow.getCell(15).getDateCellValue())
								&& hssRow.getCell(15).getDateCellValue() != null) {
							Date date = hssRow.getCell(15).getDateCellValue();
							SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
							expectTime = dff.format(date); // 日期转化
						}
						// }
						// String expectTime = (hssRow.getCell(15) != null) &&
						// !"".equals(hssRow.getCell(15))
						// ? hssRow.getCell(15).toString() : null;
						////////////////////////// 数据/////////////////////////////
						// appeovalApplication.setGirard(girard);
						// appeovalApplication.setOriginalWave(originalWave);
						// appeovalApplication.setVendorCode(vendorCode);
						// appeovalApplication.setProductId(productId);
						// appeovalApplication.setCode52(0);
						// appeovalApplication.setCode59(code59);
						// appeovalApplication.setCode66(code66);
						// appeovalApplication.setCode73(code73);
						// appeovalApplication.setCode80(code80);
						// appeovalApplication.setCode90(code90);
						// appeovalApplication.setCode100(code100);
						// appeovalApplication.setCode110(0);
						// appeovalApplication.setCode120(0);
						// appeovalApplication.setCode130(0);
						// appeovalApplication.setCode160(0);
						// appeovalApplication.setCode170(0);
						// appeovalApplication.setCount(code59 + code66 + code73
						// + code80 + code90 + code100);
						// appeovalApplication.setClothName(clothName);
						// appeovalApplication.setExpectTime(expectTime);
						// appeovalApplication.setRemark(remark);
						int count = code59 + code66 + code73 + code80 + code90 + code100;
						if (girard == null) {
							break;
						} else {
							// applicationService.insertSelective(appeovalApplication);
							String sql = "INSERT INTO `approval_application`(`girard`,`original_wave`,`cloth_name`, `product_id`, `vendor_code`,  `code52`, `code59`, `code66`, `code73`,`code80`,`code90`,`code100`,`code110`,`code120`,`code130`,`code160`,`code170`,`count`,`expect_time`,`remark`,`delb`,`ADD_TIME`,`UPDATE_TIME`,`DEL_TIME`)VALUES('"
									+ girard + "', '" + originalWave + "','" + clothName + "', '" + productId + "', '"
									+ vendorCode + "', 	'0', '" + code59 + "', '" + code66 + "', '" + code73 + "','"
									+ code80 + "','" + code90 + "','" + code100 + "','0','0','0','0','0' ,'" + count
									+ "','" + expectTime + "','" + remark + "','1', NOW(),NULL,NULL);";
							sqls = sqls + sql;
						}
					}
					applicationService.insertSelectives(sqls);
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
		log.debug("导入Excel表");
		return flag;
	}

	/**
	 * 双击修改
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("dbluppapprovalApplication")
	@ResponseBody
	public int dbluppapprovalApplication(ApprovalApplication application) {
		int falg = 0;
		falg = this.applicationService.updateByPrimaryKeySelective(application);
		log.debug("双击修改文本信息");
		return falg;
	}

	/**
	 * 双击修改数值
	 * 
	 * @param application
	 * @return
	 */
	@RequestMapping("dbluppapprovalApplicationCode")
	@ResponseBody
	public int dbluppapprovalApplicationCode(ApprovalApplication application) {
		int flag = 0;
		this.applicationService.updateByPrimaryKeySelective(application);
		flag = calculation(application.getId());
		log.debug("双击修改数字信息");
		return flag;
	}

	/**
	 * 计算修改后的总件数
	 * 
	 * @param id
	 * @return
	 */
	private int calculation(Integer id) {
		int flag = 0;
		ApprovalApplication application = this.applicationService.selectByPrimaryKey(id);
		Integer code1 = application.getCode52();
		Integer code2 = application.getCode59();
		Integer code3 = application.getCode66();
		Integer code4 = application.getCode73();
		Integer code5 = application.getCode80();
		Integer code6 = application.getCode90();
		Integer code7 = application.getCode100();
		Integer code8 = application.getCode110();
		Integer code9 = application.getCode120();
		Integer code10 = application.getCode130();
		Integer code11 = application.getCode160();
		Integer code12 = application.getCode170();
		Integer total = code1 + code2 + code3 + code4 + code5 + code6 + code7 + code8 + code9 + code10 + code11
				+ code12;
		application.setCount(total);
		flag = this.applicationService.updateByPrimaryKeySelective(application);
		log.debug("双击修改后数值重新计算");
		return flag;
	}

	/**
	 * 生成新的图片工艺单
	 *
	 * @param application
	 * @param request
	 * @return
	 */
	@RequestMapping("generateSampleImg")
	@ResponseBody
	public int generateSampleImg(ApprovalApplication application, HttpServletRequest request) {
		int flag = 0;
		if (!"".equals(application.getSampleImg()) && application.getSampleImg() != null) {
			ImageGenerated.exportImgs(application, request);
		}
		application.setDelb(3);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");// 设置时间格式
		application.setReturnTime(sd.format(new Date()));// 返单时间
		flag = this.applicationService.updateByPrimaryKeySelective(application);
		log.debug("审批通过生成新工艺单！");
		return flag;
	}

	/**
	 * 一键通过
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("approvalApplicationThrough")
	@ResponseBody
	public int approvalApplicationThrough(String ids, HttpServletRequest request) {
		int flag = 0;
		String[] source = ids.split(",");
		for (int i = 0; i < source.length; i++) {
			ApprovalApplication application = this.applicationService.selectByPrimaryKey(Integer.parseInt(source[i]));
			flag = generateSampleImg(application, request);
		}
		log.debug("一键通过");
		return flag;
	}

	/**
	 * 计算订单数
	 * 
	 * @param girard
	 * @return
	 */
	@RequestMapping("calculations")
	@ResponseBody
	public int calculations(String girard) {
		int flag = 0;
		flag = this.applicationService.calculations(girard);
		log.info("计算订单数");
		return flag;
	}
}
