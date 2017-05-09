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

import com.warehouse.entity.SalesNotSaleHaoXun;
import com.warehouse.service.SalesNotSaleHaoXunService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.StringUtil;

/**
 * 浩讯入库详情表
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("SalesNotSaleHaoXun")
public class SalesNotSaleHaoXunController {
	@Resource
	private SalesNotSaleHaoXunService notSaleHaoXunService;

	/**
	 * 数据分页查询(可以模糊查询)
	 * 
	 * @param page
	 * @param SalesNotSaleHaoXun
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil page, SalesNotSaleHaoXun SalesNotSaleHaoXun) {
		return this.notSaleHaoXunService.getDataByPage(page, SalesNotSaleHaoXun);
	}

	private String updateDate(String str) throws ParseException {
		System.err.println(str);
		Date myDate = new SimpleDateFormat("dd-MM-yyyy").parse(str);
		System.err.println(myDate+"-----------------------------------");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(myDate);
	}
}
