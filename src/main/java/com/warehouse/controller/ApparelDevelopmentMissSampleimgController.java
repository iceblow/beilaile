package com.warehouse.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

import com.warehouse.entity.ApparelDevelopmentMissSampleimg;
import com.warehouse.entity.FabricLibrary;
import com.warehouse.service.ApparelDevelopmentMissSampleimgService;
import com.warehouse.service.FabricLibraryService;
import com.warehouse.util.ImageGenerated;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("apparelDevelopmentMissSampleimg")
public class ApparelDevelopmentMissSampleimgController {

	@Resource
	private ApparelDevelopmentMissSampleimgService apparelDevelopmentMissSampleimgService;
	@Resource
	private FabricLibraryService fabricLibraryService;
	private Logger log = LoggerFactory.getLogger(ApparelDevelopmentMissSampleimgController.class);// 生成日志

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("apparelDevelopmentMissSampleimgBylike")
	@ResponseBody
	public Map<String, Object> apparelDevelopmentMissSampleimgBylike(PageUtil page,
			ApparelDevelopmentMissSampleimg record) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示的数据量
		page.setTotolCount(this.apparelDevelopmentMissSampleimgService.getCountByLike(record));// 总共有多少条数据
		// map对象中存的数据
		List<ApparelDevelopmentMissSampleimg> apparelDevelopmentManagements = this.apparelDevelopmentMissSampleimgService
				.getApparelDevelopmentMissSampleimgByLike(new ApparelDevelopmentMissSampleimg(page.getReqult()[0],
						page.getReqult()[1], record.getGirard(), record.getMerchantId(), record.getDesigner(),
						record.getModel(), record.getClothName(), record.getPlatewave(), record.getReferPrint(),
						record.getProcessImg(), record.getSampleImg())); // 在map中写入分页对象
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", apparelDevelopmentManagements);
		log.info("查看补工艺单信息");
		return map;
	}

	/**
	 * 添加
	 * 
	 * @param file
	 *            设计图
	 * @param file1
	 *            头样图
	 * @param record
	 *            实体
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("addApparelDevelopmentMissSampleimg")
	@ResponseBody
	public int addApparelDevelopmentMissSampleimg(@RequestParam MultipartFile file, @RequestParam MultipartFile file1,
			@RequestParam MultipartFile file2, ApparelDevelopmentMissSampleimg record, HttpServletRequest request)
			throws IOException {
		int result = 0;
		String fileName = "";// 声明一个字段来接收新名字
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		String path = rootPath + "designImg\\";// 图片上传路径
		// 设计图
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());// 文件流上传
			record.setDesignImg("designImg\\" + fileName);// 文件名
		}
		// 头样图
		if (!file1.isEmpty()) {
			fileName = this.getPath(file1.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file1.getBytes());// 文件流上传
			record.setProcessImg("designImg\\" + fileName);
		}
		// 尺码表
		if (!file2.isEmpty()) {
			fileName = this.getPath(file2.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file2.getBytes());// 文件流上传
			record.setChildImg("designImg\\" + fileName);// 文件名
		}
		/*
		 * // 图样工艺单 if (!file3.isEmpty()){ fileName =
		 * this.getPath(file3.getOriginalFilename()); // 文件重命名
		 * FileUtils.writeByteArrayToFile(new File(path, fileName),
		 * file3.getBytes());// 文件流上传 record.setProcessPatternImg("designImg\\"
		 * + fileName); }
		 */
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
		record.setTotal(total);
		result = this.apparelDevelopmentMissSampleimgService.addApparelDevelopmentMissSampleimg(record);// 添加方法
		log.info("添加补工艺单信息");
		return result;// 返回添加成功页面
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getApparelDevelopmentMissSampleimgById")
	@ResponseBody
	public ApparelDevelopmentMissSampleimg getApparelDevelopmentMissSampleimgById(Integer id) {
		ApparelDevelopmentMissSampleimg record = apparelDevelopmentMissSampleimgService
				.getApparelDevelopmentMissSampleimgById(id);
		log.debug("根据id后台查询数据");
		return record;
	}

	/**
	 * 修改
	 * 
	 * @param file
	 *            设计图
	 * @param file1
	 *            头样图
	 * @param recode
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("uppApparelDevelopmentMissSampleimg")
	@ResponseBody
	private int uppApparelDevelopmentMissSampleimg(@RequestParam MultipartFile file, @RequestParam MultipartFile file1,
			@RequestParam MultipartFile file2, ApparelDevelopmentMissSampleimg record, int myIndex,
			HttpServletRequest request) throws IOException {

		String fileName = "";
		String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
		String path = rootPath + "designImg\\";// 图片上传路径
		// 设计图
		System.err.println(file);
		if (!file.isEmpty()) {
			fileName = this.getPath(file.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());// 文件流上传
			record.setDesignImg("designImg\\" + fileName);// 文件名
		}
		// 头样图
		if (!file1.isEmpty()) {
			fileName = this.getPath(file1.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file1.getBytes());// 文件流上传
			record.setProcessImg("designImg\\" + fileName);// 文件名
		}
		// 尺码表
		if (!file2.isEmpty()) {
			fileName = this.getPath(file2.getOriginalFilename()); // 文件重命名
			FileUtils.writeByteArrayToFile(new File(path, fileName), file2.getBytes());// 文件流上传
			record.setChildImg("designImg\\" + fileName);// 文件名
		}

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
		record.setTotal(total);

		log.debug("修改补工艺单信息");

		this.apparelDevelopmentMissSampleimgService.updateApparelDevelopmentMissSampleimg(record);
		return myIndex;

	}

	/**
	 * 修改图片名
	 * 
	 * @param originalFilename
	 * @return
	 */
	private String getPath(String Filename) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Random rd = new Random();// 随机数生成
		String suffix = Filename.substring(Filename.lastIndexOf("."));// 获取后缀名
		String str = df.format(new Date()) + rd.nextInt(10000) + suffix;// 新图片名
		return str;
	}

	/**
	 * 双击修改
	 * 
	 * @param record
	 */
	@RequestMapping("dbuppApparelDevelopmentMissSampleimg")
	@ResponseBody
	private int dbuppApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record) {
		int flag = this.apparelDevelopmentMissSampleimgService.updateApparelDevelopmentMissSampleimg(record);
		log.debug("双击修改补工艺单信息");
		return flag;
	}

	/**
	 * 生成工艺单
	 * 
	 * @param record
	 * @param request
	 * @return
	 */

	@RequestMapping("toSampleImg")
	@ResponseBody
	public int toSampleImg(HttpServletRequest request, String ids) {
		int flag = 0;
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String[] sourceStrArray = ids.split(",");
		for (int i = 0; i < sourceStrArray.length; i++) {
			ApparelDevelopmentMissSampleimg record = apparelDevelopmentMissSampleimgService
					.queryEtrack(Integer.parseInt(sourceStrArray[i]));
			if (record.getProcessImg() != null) {
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				if (record.getProcessImg().length() != 0) { // 判断本地图片是否存在!
					String imgPath = rootPath + record.getProcessImg();//
					// 获取图片路径
					File imgFile = new File(imgPath);// 把路径转换成一个流
					if (imgFile.exists()) {
						record.setReleaseDate(sd.format(new Date()));// 发版事件
						ImageGenerated.exportImg(record, request);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
						record.setCompleteTime(sdf.format(new Date()));
						record.setDelb(2);
						flag = apparelDevelopmentMissSampleimgService.updateApparelDevelopmentMissSampleimg(record);
						// 修改方法
						if (flag == 1) {
							flag = updateCompleteTime(record);
						}
					} else {
						flag = 2;
					}
				}
			}
		}
		log.info("生成工艺单信息");
		return flag;

	}

	public int updateCompleteTime(ApparelDevelopmentMissSampleimg record) {
		int flag = 0;
		ApparelDevelopmentMissSampleimg management = apparelDevelopmentMissSampleimgService
				.getApparelDevelopmentMissSampleimgById(record.getId()); //
		if (management.getCompleteTime() != record.getCompleteTime()) {
			flag = 3;
		}
		return flag;
	}

	/**
	 * 双击修改时检查面料是否存在
	 *
	 * @param record查询
	 * @return
	 */
	@RequestMapping("checkClothName")
	@ResponseBody
	public int checkClothName(ApparelDevelopmentMissSampleimg record, String type) {
		int flag = 0;
		// 判断修改的是否为面料A
		if (type.equals("smallSampleNumA")) {
			if ("".equals(record.getSmallSampleNumA())) {// 判断值是否为空
				// 赋空值
				record.setSmallsamplea("");
				record.setWidtha("");
				record.setIngredienta("");
				flag = dbuppApparelDevelopmentMissSampleimg(record);
			} else {
				// 面料A有值
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumA());// 面料A
				// 判断面料A是否已录入
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					// 给面料幅宽成分赋值
					record.setSmallsamplea(fabric);
					record.setWidtha(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredienta(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentMissSampleimg(record);
				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("smallSampleNumB")) {
			if ("".equals(record.getSmallSampleNumB())) {
				record.setSmallsampleb("");
				record.setWidthb("");
				record.setIngredientb("");
				flag = dbuppApparelDevelopmentMissSampleimg(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumB());// 面料B
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsampleb(fabric);
					record.setWidthb(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientb(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentMissSampleimg(record);
				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("smallSampleNumC")) {
			if ("".equals(record.getSmallSampleNumC())) {
				record.setSmallsamplec("");
				record.setWidthc("");
				record.setIngredientc("");
				flag = dbuppApparelDevelopmentMissSampleimg(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumC());// 面料C
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsamplec(fabric);
					record.setWidthc(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientc(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentMissSampleimg(record);
				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("smallSampleNumD")) {
			if ("".equals(record.getSmallSampleNumD())) {
				record.setSmallsampled("");
				record.setWidthd("");
				record.setIngredientd("");
				flag = dbuppApparelDevelopmentMissSampleimg(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumD());// 面料D
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsampled(fabric);
					record.setWidthd(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngredientd(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentMissSampleimg(record);
				} else {
					flag = 2;
				}
			}
		}
		if (type.equals("smallSampleNumE")) {
			if ("".equals(record.getSmallSampleNumE())) {
				record.setSmallsamplee("");
				record.setWidthe("");
				record.setIngrediente("");
				flag = dbuppApparelDevelopmentMissSampleimg(record);
			} else {
				FabricLibrary fabricLibrary = this.fabricLibraryService
						.findFabricLibraryByFabricLibraryCode(record.getSmallSampleNumE());// 面料E
				if (fabricLibrary != null) {
					String fabric = fabricLibrary.getSupplierName().substring(0,
							fabricLibrary.getSupplierName().length() - 2) + "#" + fabricLibrary.getColorCardNmae() + "#"
							+ fabricLibrary.getColorCode() + fabricLibrary.getColorName();
					record.setSmallsamplee(fabric);
					record.setWidthe(String.valueOf(fabricLibrary.getFabricLength()));
					record.setIngrediente(fabricLibrary.getFabricIngredient());
					flag = dbuppApparelDevelopmentMissSampleimg(record);
				} else {
					flag = 2;
				}
			}
		}
		log.info("双击修改时检查面料是否存在");
		return flag;
	}

}
