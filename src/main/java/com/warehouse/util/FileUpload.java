package com.warehouse.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

//import net.coobird.thumbnailator.Thumbnails;

/**
 * Created by Beilaile on 2016/12/7.
 */
public class FileUpload {
	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 创建图片文件路径
	 * 
	 * @param file:文件流
	 * @param request:获得请求中的参数
	 * @param folderNmae:文件夹名称
	 * @param ImageName:图片名称
	 * @return
	 */
	public static String addFilePath(MultipartFile file, HttpServletRequest request, String folderNmae,
			String ImageName) {
		String defaultName = formatter.format(new Date());// 默认名称
		try {
			// 创建空路径
			String fileUrl = null;
			// 取得当前上传文件的文件名称
			String fileName = file.getOriginalFilename();
			// 获取文件类型
			String ext = fileName.substring(fileName.indexOf("."), fileName.length());

			//
			byte[] data = file.getBytes();
			// 获取根路径
			String contextRoot = request.getSession().getServletContext().getRealPath("/");

			if (folderNmae.equals("") || folderNmae.trim().length() == 0) {
				folderNmae = defaultName;
			}
			if (ImageName.equals("") || ImageName.trim().length() == 0) {
				ImageName = defaultName;
			}
			// 地址图片保存
			String fileNameImg = contextRoot + folderNmae + "\\";
			// System.out.println("打印地址方法===============" + fileNameImg);
			// 判断是否存在这个地址 调用判断方法
			isHaveFolder(contextRoot + folderNmae);
			// 类型
			if (ext.equals(ext)) {
				// 路径
				FileOutputStream out = new FileOutputStream(fileNameImg + ImageName + ext);
				//
				out.write(data);
				// 关闭
				out.close();
				// 地址栏
				fileUrl = "/" + folderNmae + "/" + ImageName + ext;
			}
			return fileUrl;
		} catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
	}

	/**
	 * http://www.cnblogs.com/miskis/p/5500822.html
	 * 
	 * @Description:保存图片并且生成缩略图
	 * @param imageFile
	 *            图片文件
	 * @param request
	 *            请求对象
	 * @param uploadPath
	 *            上传目录
	 * @return
	 */
	public static String uploadFileAndCreateThumbnail(MultipartFile imageFile, HttpServletRequest request,
			String uploadPath) {
		if (imageFile == null) {
			return "imageFile不能为空";
		}

		if (imageFile.getSize() >= 10 * 1024 * 1024) {
			return "文件不能大于10M";
		}
		String uuid = UUID.randomUUID().toString();

		String fileDirectory = formatter.format(new Date());//

		// 拼接后台文件名称
		String pathName = fileDirectory + File.separator + uuid + "."
				+ FilenameUtils.getExtension(imageFile.getOriginalFilename());
		// 构建保存文件路劲
		// 2016-5-6 yangkang 修改上传路径为服务器上
		String realPath = request.getServletContext().getRealPath("uploadPath");
		// 获取服务器绝对路径 linux 服务器地址 获取当前使用的配置文件配置
		// String
		// urlString=PropertiesUtil.getInstance().getSysPro("uploadPath");
		// 拼接文件路劲
		String filePathName = realPath + File.separator + pathName;
		// log.info("图片上传路径：" + filePathName);
		// 判断文件保存是否存在
		File file = new File(filePathName);
		if (file.getParentFile() != null || !file.getParentFile().isDirectory()) {
			// 创建文件
			file.getParentFile().mkdirs();
		}

		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			inputStream = imageFile.getInputStream();
			fileOutputStream = new FileOutputStream(file);
			// 写出文件
			// 2016-05-12 yangkang 改为增加缓存
			// IOUtils.copy(inputStream, fileOutputStream);
			byte[] buffer = new byte[2048];
			IOUtils.copyLarge(inputStream, fileOutputStream, buffer);
			buffer = null;

		} catch (IOException e) {
			filePathName = null;
			return "操作失败";
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (fileOutputStream != null) {
					fileOutputStream.flush();
					fileOutputStream.close();
				}
			} catch (IOException e) {
				filePathName = null;
				return "操作失败";
			}
		}

		// String fileId = FastDFSClient.uploadFile(file, filePathName);

		/**
		 * 缩略图begin
		 */

		// 拼接后台文件名称
		String thumbnailPathName = fileDirectory + File.separator + uuid + "small."
				+ FilenameUtils.getExtension(imageFile.getOriginalFilename());
		// added by yangkang 2016-3-30 去掉后缀中包含的.png字符串
		if (thumbnailPathName.contains(".png")) {
			thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
		}
		long size = imageFile.getSize();
		double scale = 1.0d;
		if (size >= 200 * 1024) {
			if (size > 0) {
				scale = (200 * 1024f) / size;
			}
		}

		// // 拼接文件路劲
		// String thumbnailFilePathName = realPath + File.separator +
		// thumbnailPathName;
		// try {
		// // added by chenshun 2016-3-22 注释掉之前长宽的方式，改用大小
		// // Thumbnails.of(filePathName).size(width,
		// // height).toFile(thumbnailFilePathName);
		// if (size < 200 * 1024) {
		// Thumbnails.of(filePathName).scale(1f).outputFormat("jpg").toFile(thumbnailFilePathName);
		// } else {
		// Thumbnails.of(filePathName).scale(1f).outputQuality(scale).outputFormat("jpg")
		// .toFile(thumbnailFilePathName);
		// }
		//
		// } catch (Exception e1) {
		// return "操作失败";
		// }
		/**
		 * 缩略图end
		 */

		Map<String, Object> map = new HashMap<String, Object>();
		// 原图地址
		map.put("originalUrl", pathName);
		// 缩略图地址
		map.put("thumbnailUrl", thumbnailPathName);
		return "操作成功";
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
