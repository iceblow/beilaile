package com.warehouse.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ColorCard;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.entity.FabricSupplier;
import com.warehouse.service.ColorCardService;
import com.warehouse.service.FabricLibraryService;
import com.warehouse.service.FabricSupplierService;
import com.warehouse.util.Page;

@Controller
public class FabricLibraryController {
	@Resource
	public FabricLibraryService fabricLibraryService;
	@Resource
	public FabricSupplierService fabricSupplierService;
	@Resource
	public ColorCardService colorCardService;

	@SuppressWarnings("static-access")
	@RequestMapping("addFabricLibrary.do")
	@ResponseBody
	public int addFabricLibrary(MultipartFile file1, FabricLibrary fabricLibrary, HttpServletRequest request) {
		// 图片名字
		String fileName = "";

		int date = fabricLibraryService.findFabricLibraryBySupplierCode(fabricLibrary);
		if (date > 0) {
			return 18;
		} else {
			// 根据供应商编号查询供应商名称
			FabricSupplier supplier = fabricSupplierService
					.findFabricSupplierBySupplierCode(fabricLibrary.getSupplierCode());
			// 设置供应商名称
			fabricLibrary.setSupplierName(supplier.getSupplierName());
			// 根据色卡编号查询色卡名称
			ColorCard colorCard = colorCardService.getColorCardByColorCardCode(fabricLibrary.getColorCardCode());
			// 设置色卡名称
			fabricLibrary.setColorCardNmae(colorCard.getColorCardName());
			// 截取色卡编号
			String str = fabricLibrary.getColorCardCode();
			str = str.substring(str.length() - 4, str.length());
			// 设置面料名字 如： 001#泰森#0673麻棉卫衣 0001#黑色（供应商编号#面料供应商简称 色卡编号#色卡名称）
			fabricLibrary.setFabricName(fabricLibrary.getSupplierCode() + "#" + supplier.getSupplierAbbreviation() + str
					+ "#" + colorCard.getColorCardName());
			// 设置字段里没有的不知道什么东西,可能是判断重没重复
			fabricLibrary.setFabricLength(colorCard.getFabricLength());
			fabricLibrary.setGramWeight(colorCard.getGramWeight());// 克重
			fabricLibrary.setKilogramMeter(colorCard.getKilogramMeter());
			// 判断文件是否为空,不为空添加图片到文件夹
			if (!file1.isEmpty()) {
				try {
					// 获取根路径
					String contextRoot = request.getSession().getServletContext().getRealPath("/");
					String path = contextRoot + "fabricImg\\";
					// 如果这个文件夹不存在，创建一个
					isHaveFolder(path);
					// 取新的名字，并保留原来的后缀
					fileName = this.getNewName(colorCard.getColorCardCode() + fabricLibrary.getColorCode(),
							file1.getOriginalFilename());
					// 转存文件
					FileUtils.writeByteArrayToFile(new File(path, fileName), file1.getBytes());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			// 设置图片路径
			fabricLibrary.setFabricSample("/fabricImg/" + fileName);

			//
			// 放到result里
			int reslut = fabricLibraryService.addFabricLibrary(fabricLibrary, request);

			return reslut;
		}
	}

	/**
	 * 
	 * 修改图片名字
	 * 
	 * @param name
	 * @return
	 */
	public static String getNewName(String productCodes, String name) {
		String str = productCodes + name.substring(name.lastIndexOf("."));
		return str;
	}

	@SuppressWarnings("static-access")
	@RequestMapping("modifyFabricLibrary.do")
	@ResponseBody
	public int modifyFabricLibrary(MultipartFile file1, FabricLibrary fabricLibrary, HttpServletRequest request) {
		// 图片名字
		String fileName = "";
		// 判断文件是否为空,不为空添加图片到文件夹
		if (!file1.isEmpty()) {
			try {
				// 获取根路径
				String contextRoot = request.getSession().getServletContext().getRealPath("/");
				String path = contextRoot + "fabricImg\\";
				// 取新的名字，并保留原来的后缀
				fileName = this.getNewName(fabricLibrary.getColorCode(), file1.getOriginalFilename());
				// 转存文件
				FileUtils.writeByteArrayToFile(new File(path, fileName), file1.getBytes());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 设置图片路径
		fabricLibrary.setFabricSample("/fabricImg/" + fileName);

		int reslut = fabricLibraryService.modifyFabricLibrary(fabricLibrary, request);

		return reslut;
	}

	@RequestMapping("delFabricLibraryById.do")
	@ResponseBody
	public int delFabricLibraryById(FabricLibrary fabricLibrary, HttpServletRequest request) {
		int reslut = fabricLibraryService.delFabricLibraryById(fabricLibrary, request);
		return reslut;
	}

	@RequestMapping("getFabricLibraryByPageCount.do")
	@ResponseBody
	public Page<FabricLibrary> getFabricLibraryByPageCount(@RequestParam Map<String, Object> anyVal) {
		int reslut = fabricLibraryService.getFabricLibraryByPageCount(anyVal);
		Page<FabricLibrary> page = new Page<FabricLibrary>(reslut, 1);
		return page;
	}

	@RequestMapping("findConditionFabricLibraryByPage.do")
	@ResponseBody
	public List<FabricLibrary> findConditionFabricLibraryByPage(@RequestParam Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricLibrary> list = fabricLibraryService.findConditionFabricLibraryByPage(anyVal);
		return list;
	}

	@RequestMapping("findFabricLibraryById.do")
	@ResponseBody
	public FabricLibrary findFabricLibraryById(Integer id) {
		FabricLibrary FabricLibrary = fabricLibraryService.findFabricLibraryById(id);
		return FabricLibrary;
	}

	@RequestMapping("findFabricLibraryByFabricLibraryCode.do")
	@ResponseBody
	public FabricLibrary findFabricLibraryByFabricLibraryCode(String fabricCode) {
		FabricLibrary FabricLibrary = fabricLibraryService.findFabricLibraryByFabricLibraryCode(fabricCode);
		return FabricLibrary;
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
