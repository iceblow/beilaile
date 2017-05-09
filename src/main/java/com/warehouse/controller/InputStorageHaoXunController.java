package com.warehouse.controller;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.InputStorageHaoXun;
import com.warehouse.service.InputStorageHaoXunService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.StringUtil;

/**
 * 浩讯入库详情表
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("inputStorageHaoXun")
public class InputStorageHaoXunController {
	@Resource
	private InputStorageHaoXunService inputStorgaeHaoXunService;

	/**
	 * 数据分页查询(可以模糊查询)
	 * 
	 * @param page
	 * @param inputStorageHaoXun
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil page, InputStorageHaoXun inputStorageHaoXun) {
		return this.inputStorgaeHaoXunService.getDataByPage(page, inputStorageHaoXun);
	}

	@RequestMapping("importExcle")
	@ResponseBody
	public String importExcle(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("haoXunFile") MultipartFile haoXunFile) {
		// 实例化对象
		InputStorageHaoXun haoXun = new InputStorageHaoXun();
		// 判断是否上传了文件
		if (haoXunFile.getSize() != 0) {
			try {
				// 文件名称
				String fileName = haoXunFile.getOriginalFilename();
				// 文件后缀名
				String lastName = fileName.substring(fileName.indexOf("."));
				// 得到文件流
				InputStream is = haoXunFile.getInputStream();
				if (lastName.equals(".xls")) {
					// 操作excle表
					HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
					// 设定表头
					HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
					for (int rownum = 1; rownum <= sheet.getLastRowNum(); rownum++) {
						HSSFRow hssfRow = sheet.getRow(rownum);// 获取行
						String deliveryDate = hssfRow.getCell(0) != null
								? hssfRow.getCell(0).toString() : null;// 发货日期
						String artNo = hssfRow.getCell(1).toString();// 货号
						String season = hssfRow.getCell(2).toString();// 季节
						String series = hssfRow.getCell(3).toString();// 系列
						String wave = hssfRow.getCell(4).toString();// 波次号
						// Integer
						// num=StringUtil.toInteger(hssfRow.getCell(4).toString());//数量
						Integer code52 = (hssfRow.getCell(6) != null)
								? StringUtil.toInteger(hssfRow.getCell(6).toString()) : null;// 尺码52
						Integer code59 = (hssfRow.getCell(7) != null)
								? StringUtil.toInteger(hssfRow.getCell(7).toString()) : null;// 尺码59
						Integer code66 = (hssfRow.getCell(8) != null)
								? StringUtil.toInteger(hssfRow.getCell(8).toString()) : null;// 尺码66
						Integer code73 = (hssfRow.getCell(9) != null)
								? StringUtil.toInteger(hssfRow.getCell(9).toString()) : null;// 尺码73
						Integer code80 = (hssfRow.getCell(10) != null)
								? StringUtil.toInteger(hssfRow.getCell(10).toString()) : null;// 尺码80
						Integer code90 = (hssfRow.getCell(11) != null)
								? StringUtil.toInteger(hssfRow.getCell(11).toString()) : null;// 尺码90
						Integer code100 = (hssfRow.getCell(12) != null)
								? StringUtil.toInteger(hssfRow.getCell(12).toString()) : null;// 尺码100
						Integer code110 = (hssfRow.getCell(13) != null)
								? StringUtil.toInteger(hssfRow.getCell(13).toString()) : null;// 尺码110
						Integer code120 = (hssfRow.getCell(14) != null)
								? StringUtil.toInteger(hssfRow.getCell(14).toString()) : null;// 尺码120
						Integer code130 = (hssfRow.getCell(15) != null)
								? StringUtil.toInteger(hssfRow.getCell(15).toString()) : null;// 尺码130
						Integer code160 = (hssfRow.getCell(16) != null)
								? StringUtil.toInteger(hssfRow.getCell(16).toString()) : null;// 尺码160
						Integer code170 = (hssfRow.getCell(17) != null)
								? StringUtil.toInteger(hssfRow.getCell(17).toString()) : null;// 尺码170

						haoXun.setDeliveryDate(deliveryDate);
						haoXun.setArtNo(artNo);
						haoXun.setSeason(season);
						haoXun.setSeries(series);
						haoXun.setWave(wave);
						haoXun.setCode52(code52);
						haoXun.setCode59(code59);
						haoXun.setCode66(code66);
						haoXun.setCode73(code73);
						haoXun.setCode80(code80);
						haoXun.setCode90(code90);
						haoXun.setCode100(code100);
						haoXun.setCode110(code110);
						haoXun.setCode120(code120);
						haoXun.setCode130(code130);
						haoXun.setCode160(code160);
						haoXun.setCode170(code170);

						this.inputStorgaeHaoXunService.addData(haoXun);
					}

				} else {
					// 如果文件格式不是.xls的要提示对方暂时不支持导入
					return lastName;
				}
				is.close();
			} catch (Exception e) {
				// 导入失败记录导入信息并返回0
				e.printStackTrace();
				return "0";
			}
		}
		// 正常导入返回1
		return "1";
	}

	private String updateDate(String str) throws ParseException {
		System.err.println(str);
		Date myDate = new SimpleDateFormat("dd-MM-yyyy").parse(str);
		System.err.println(myDate+"-----------------------------------");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(myDate);
	}
}
