package com.warehouse.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ProductInfo;
import com.warehouse.service.ProductInfoService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("productInfo")
public class ProductInfoController {

	private Logger logger = LoggerFactory.getLogger(ProductInfoController.class);
	@Resource
	private ProductInfoService productInfoService;

	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil page, ProductInfo productInfo) {

		Map<String, Object> map = new HashMap<String, Object>();
		// 寫入每頁數據量
		page.setPageSize(10);
		// 寫入數據量
		page.setTotolCount(this.productInfoService.getCountByPage(productInfo));

		List<ProductInfo> ar = new ArrayList<ProductInfo>();
		// 得到显示数据
		ar = this.productInfoService
				.getDataByPage(new ProductInfo(page.getReqult()[0], page.getReqult()[1], productInfo));

		map.put("dataList", ar);
		map.put("pageUtil", page);

		logger.info("理单跟踪表:查询-" + ar.size());

		return map;
	}

	@RequestMapping("addData.do")
	@ResponseBody
	public int addData(@RequestParam MultipartFile productImgFile, ProductInfo productInfo, HttpServletRequest request)
			throws IOException {
		// 文件的新名字
		String fileName = "";
		// 获取根路径
		String contextRoot = request.getSession().getServletContext().getRealPath("/");

		String path = contextRoot + "productImg\\";

		isHaveFolder(path);

		if (!productImgFile.isEmpty()) {

			fileName = this.getNewName(productInfo.getProductCodes(), productImgFile.getOriginalFilename());

			FileUtils.writeByteArrayToFile(new File(path, fileName), productImgFile.getBytes());

			productInfo.setProductImg("/productImg/" + fileName);
			// // 路径
			// FileOutputStream out = new FileOutputStream(path + fileName);
			// //
			// out.write(productImgFile.getBytes());
			// // 关闭
			// out.close();
			return this.productInfoService.addData(productInfo);
		} else {
			return this.productInfoService.addData(productInfo);
		}
		// return this.productInfoService.addData(productInfo);
	}
	
	@RequestMapping("getOne")
	@ResponseBody
	public ProductInfo getOne(Integer id){
		return this.productInfoService.getOne(id);
	}

	@RequestMapping("updateData.do")
	@ResponseBody
	public int updateData(@RequestParam MultipartFile productImgFile, ProductInfo productInfo, HttpServletRequest request)
			throws IOException {
		long startTime = System.currentTimeMillis();
		// 文件的新名字
		String fileName = "";
		// 获取根路径
		String contextRoot = request.getSession().getServletContext().getRealPath("/");

		String path = contextRoot + "productImg\\";

		isHaveFolder(path);

		if (!productImgFile.isEmpty()) {

			fileName = this.getNewName(productInfo.getProductCodes(), productImgFile.getOriginalFilename());

			FileUtils.writeByteArrayToFile(new File(path, fileName), productImgFile.getBytes());

			productInfo.setProductImg("/productImg/" + fileName);
			// // 路径
			// FileOutputStream out = new FileOutputStream(path + fileName);
			// //
			// out.write(productImgFile.getBytes());
			// // 关闭
			// out.close();
			System.err.println(new Date());
			return this.productInfoService.updateData(productInfo);
		} else {
			return this.productInfoService.updateData(productInfo);
		}
		// return this.productInfoService.addData(productInfo);
	}
	@RequestMapping("deleteOne")
	@ResponseBody
	public int deleteOne(Integer id){
		return this.productInfoService.deleteOne(id);
	}
	
	/**
	 * 
	 * 修改图片名字
	 * 
	 * @param name
	 * @return
	 */
	public static String getNewName(String productCodes, String name) {
		Random ran = new Random();
		String str = productCodes +"+"+ran.nextInt(100000)+ name.substring(name.lastIndexOf("."));
		return str;
	}

	/**
	 * 判断是否存在该文件
	 *
	 * @param fileName
	 */
	public static void isHaveFolder(String fileName) {
		File file = new File(fileName);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {// 不存在
			file.mkdir(); // 创建
		}
	}

}
