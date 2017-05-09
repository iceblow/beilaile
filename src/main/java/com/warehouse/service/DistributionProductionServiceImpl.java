package com.warehouse.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.warehouse.dao.DistributionProductionMapper;
import com.warehouse.entity.DistributionProduction;
import com.warehouse.util.CharacterUtils;

@Service
public class DistributionProductionServiceImpl implements DistributionProductionService {

	@Autowired
	private DistributionProductionMapper DistributionProductionMapper;

	// 查询总条数
	@Override
	public int selectAllCount(DistributionProduction distributionProduction) {

		return DistributionProductionMapper.selectAllCount(distributionProduction);
	}

	// 查询分页返回的结果
	@Override
	public List<DistributionProduction> getDistributionProductionPage(DistributionProduction distributionProduction) {
		
		return DistributionProductionMapper.getDistributionProductionPage(distributionProduction);
	}

	/**
	 * 删除
	 */
	public int deleteById(Integer id) {
		return DistributionProductionMapper.deleteById(id);
	}

	/**
	 * 添加
	 */
	public int addDistributionProduction(MultipartFile productImgFile, DistributionProduction distributionProduction,
			HttpServletRequest request) {
		// 文件部位空才添加
		if (!productImgFile.isEmpty()) {
			// 得到图片路径,并保存图片
			String imgPath = saveImg(productImgFile, this.getStringImgName(), "distributionProduction", request);
			// 设置图片路径
			distributionProduction.setProductImg(imgPath);
		}
		// 设置总件数
		// distributionProduction.setTotalPiece(this.totalPiece(distributionProduction));
		// 设置添加时间
		// distributionProduction.setAddTime(this.getStringTime());
		// 把波次号的字母全变成大写
		distributionProduction.setWave(CharacterUtils.getUpperCase(distributionProduction.getWave()));
		return DistributionProductionMapper.addDistributionProduction(distributionProduction);
	}

	/**
	 * 修改
	 */
	public int updateDistributionProduction(MultipartFile productImgFile, DistributionProduction distributionProduction,HttpServletRequest request) {
		// 生成个随机数
		// 文件不为空才可以修改，不然修改别的字段时，没有修改图片，图片修改时没有加载进页面，那么点提交就会把图片设为空
		if (!productImgFile.isEmpty()) {
			// 得到图片路径,并保存图片
			String imgPath = saveImg(productImgFile, this.getStringImgName(), "buyerdistributionProduction", request);
			// 设置图片路径
			distributionProduction.setProductImg(imgPath);
		}
		// 设置总件数
		// distributionProduction.setTotalPiece(this.totalPiece(distributionProduction));
		return DistributionProductionMapper.updateDistributionProduction(distributionProduction);
	}

	/**
	 * 修改（前段不是提交表单的那种修改，之所以分开写两个修改，是因为有的修改不是提交表单那种， 如果不分开就报
	 * org.springframework.web.multipart.MultipartException: The current request
	 * is not a multipart request] with root cause这个错误）
	 */
	public int updateDistributionProductionForm(DistributionProduction distributionProduction) {
		// 如果点击的是 确定采购,在这里生成采购时间
		if ("1".equals(distributionProduction.getStartMake())) {
			// 改变状态
			distributionProduction.setStartMake("1");
			// 设置上线日期
			distributionProduction.setStartMakeTime(this.getStringTime());
		}
		return DistributionProductionMapper.updateDistributionProduction(distributionProduction);
	}

	/**
	 * 根据id查询
	 */
	public DistributionProduction selectById(Integer id) {
		return DistributionProductionMapper.selectById(id);
	}

	// ====================================下面是工具类=================================================

	/**
	 * 放回一个String类型的时间格式(当前时间)
	 * 
	 * @return
	 */
	public String getStringTime() {
		// 生成当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		return sdf.format(date);
	}

	/**
	 * 放回一个String类型的时间格式(当前时间)
	 * 
	 * @return
	 */
	public String getStringImgName() {
		// 生成当前时间
		/*
		 * SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss"); Date
		 * date = new Date(System.currentTimeMillis());
		 */
		long time = System.currentTimeMillis();
		long times = time + (int) (Math.random() * 100);
		String imgName = Long.toString(times);
		return imgName;
	}

	/**
	 * 保存图片到指定路径 并返回存到数据库的路径 params(图片文件,文件夹名称,图片名称,HttpServletRequest获取根目录用的)
	 * return 图片路径(存到数据库里的)
	 */
	public String saveImg(MultipartFile file, String imgName, String folderName, HttpServletRequest request) {
		// 图片名字(存到文件下的图片的名称)
		String fileName = "";
		try {
			// 获取根路径
			String contextRoot = request.getSession().getServletContext().getRealPath("/");
			String path = contextRoot + folderName + "\\";
			// 如果这个文件夹不存在，创建一个
			isHaveFolder(path);
			// 取新的名字，并保留原来的后缀
			fileName = this.getNewName(imgName, file.getOriginalFilename());
			// 转存文件
			FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 设置图片路径
		imgName = "/" + folderName + "/" + fileName;
		return imgName;
	}

	/**
	 * 
	 * 修改图片名字
	 * 
	 * @param name
	 * @return
	 */
	public String getNewName(String goodsId, String name) {
		String str = goodsId + name.substring(name.lastIndexOf("."));
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

	//导出Excel表
	@Override
	public int toExcelNum(DistributionProduction distributionProduction) {
		
		return DistributionProductionMapper.toExcelNum(distributionProduction);
	}

	@Override
	public List<DistributionProduction> toExcel(DistributionProduction distributionProduction) {
		
		return DistributionProductionMapper.toExcel(distributionProduction);
	}

}
