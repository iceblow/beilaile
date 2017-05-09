package com.warehouse.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.util.StringUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.warehouse.entity.InputStorage;

/**
 * 条形码工具类
 *
 * @author king
 * @createDate 2017年1月
 *
 */
@SuppressWarnings("restriction")
public class BarCodeUtils {
	/**
	 * 生成条形码组合图
	 * 
	 * @param inputstorage
	 * 
	 * @param girard
	 * @param date
	 * @param factory
	 * @param commoditycCode
	 * @param productShortName
	 * @param code
	 * @param request
	 */
	static int i = 0;

	public static void barCode(InputStorage inputstorage, String girard, String date, String factory,
			String commoditycCode, String productShortName, String code, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");// 项目的根目录路径
		String newcode = code.substring(0, 2);
		String msg = commoditycCode + newcode;// 条码
		// 图片存放路径
		File file = new File(realPath + "/temp");
		// 创建新文件夹来存放生成的条形码的临时图片
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		i++;
		String path = realPath + "/temp/" + girard + i + ".jpg";// 图片名
		generateFile(msg, path);
		/*
		 * 传入要进行图片组合的参数
		 */
		BarImg(inputstorage, girard, date, code, factory, productShortName, request);
		// 删除条码临时文件夹
		File imgFile = new File(realPath + "/temp");// 文件夹存放路径 //
		deleteAllFilesOfDir(imgFile);// 删除文件夹
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 生成文件
	 *
	 * @param msg
	 * @param path
	 * @return
	 */
	public static File generateFile(String msg, String path) {
		File file = new File(path);
		try {
			generate(msg, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return file;
	}

	/**
	 * 生成字节
	 *
	 * @param msg
	 * @return
	 */
	public static byte[] generate(String msg) {
		ByteArrayOutputStream ous = new ByteArrayOutputStream();
		generate(msg, ous);
		return ous.toByteArray();
	}

	/**
	 * 生成到流
	 *
	 * @param msg
	 * @param ous
	 */
	public static void generate(String msg, OutputStream ous) {
		if (StringUtils.isEmpty(msg) || ous == null) {
			return;
		}
		Code128Bean bean = new Code128Bean();

		// 精细度
		final int dpi = 96;// 默认打印dpi
		// module宽度
		final double moduleWidth = UnitConv.in2mm(1.0f / dpi);
		// 配置对象
		bean.setModuleWidth(moduleWidth);
		bean.doQuietZone(true);
		bean.doQuietZone(false);
		String format = "image/jpeg";
		try {
			// bean.setPattern(factory);
			// 输出到流
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi, BufferedImage.TYPE_BYTE_BINARY,
					false, 0);
			// 生成条形码
			bean.generateBarcode(canvas, msg);
			// 结束绘制
			canvas.finish();
			ous.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 组合图片
	 * 
	 * @param inputstorage
	 * @param girard
	 * @param date
	 * @param factory
	 * @param productShortName
	 * @param request
	 */
	public static void BarImg(InputStorage inputstorage, String girard, String sdate, String code, String factory,
			String productShortName, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		try {
			System.err.println(realPath + "/temp/" + girard + i + ".jpg" + "///////////////");
			String path = realPath + "res\\images\\bars.jpg";// 大图片路径
			InputStream is = new FileInputStream(path);
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);// 通过JPEG图象流创建JPEG数据流解码器
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();// 解码当前JPEG数据流，返回BufferedImage对象
			ImageIcon imgIcon = new ImageIcon(realPath + "/temp/" + girard + i + ".jpg");// 小图片路径(临时图片)
			Image img = imgIcon.getImage();// 得到Image对象。
			Graphics g = buffImg.getGraphics(); // 得到画笔对象
			// 将小图片绘到大图片上
			g.drawImage(img, 10, 18, null);// 小图片在大图片的位置（x，y，宽，长）
			// 设置画笔的样式
			Font f = new Font("宋体", Font.PLAIN, 12);
			g.setFont(f);
			// 设置字体颜色
			Color mycolor = Color.black;
			g.setColor(mycolor);
			// 上边的波次，时间，工厂
			String time = sdate.substring(2, sdate.length()).replace("-", "");// 去除字符串中的“-”
			g.drawString(girard, 8, 12);
			g.drawString(time, 50, 12);
			g.drawString(factory, 100, 12);
			// 下边商品名称+码号
			// Font f1 = new Font("宋体", Font.PLAIN, 12);// 设置画笔的样式
			// g.setColor(mycolor);
			// g.setFont(f1);
			// 设置字体间距
			String font = productShortName;// 传入的参数
			String tempStr = new String();
			int tempx = 5;// 起始位置的x坐标
			double orgStringWight = g.getFontMetrics().stringWidth(font);// 获取传入的字符串的长度
			double orgStringLength = font.length();// 获取传入的字符串的个数
			while (font.length() > 0) {
				tempStr = font.substring(0, 1);// 切割字符串
				font = font.substring(1, font.length());
				g.drawString(tempStr, tempx, 98);// 写入(切割后的值，x，y)
				///// 调节字间距/////
				tempx = (int) (tempx + orgStringWight / orgStringLength * 0.9);
				// 切割到最后的值，在最后追加码号
				if (font.length() == 0) {
					g.drawString(code, tempx, 98);
				}
			}

			// 图片存放路径来存放组合好的图片
			OutputStream os;
			File file = new File(realPath + "/bar");// 文件夹的存放路径
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();// 创建新文件夹
			}
			String shareFileName = file + "/" + girard + ".jpg";// 给图片命名
			inputstorage.setTempBar("bar/" + girard + ".jpg");// 得到图片路径并将图片路径存入数据库
			os = new FileOutputStream(shareFileName);
			// 创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);
			// 关闭流
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除条码图片的临时文件夹
	 * 
	 * @param path
	 */
	public static void deleteAllFilesOfDir(File path) {
		if (!path.exists())
			return;
		if (path.isFile()) {
			path.delete();
			return;
		}
		File[] file1 = path.listFiles();
		for (int i = 0; i < file1.length; i++) {
			deleteAllFilesOfDir(file1[i]);
		}
		path.delete();
	}
}
