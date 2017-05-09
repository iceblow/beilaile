package com.warehouse;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jbarcode.JBarcode;
import org.jbarcode.JBarcodeFactory;
import org.jbarcode.paint.TextPainter;
import org.jbarcode.util.ImageUtil;

/**
 * 条形码
 * 
 * @author Beilaile
 *
 */
public class BarcodeUtils {
	private static final int BARCODE_HEIGHT = 20;//
	private static final int BARCODE_DPI = ImageUtil.DEFAULT_DPI;
	private static final String FONT_FAMILY = "微软雅黑";
	private static final int FONT_SIZE = 16;

	private static JBarcode jbc = null;

	static JBarcode getJBarcode() {
		if (jbc == null) {
			jbc = JBarcodeFactory.getInstance().createCode128();// 类型
			jbc.setTextPainter(CustomTextPainter.getInstance());// 字体样式
			jbc.setBarHeight(BARCODE_HEIGHT);// 高度
		}
		return jbc;
	}

	/**
	 * 条形码生成信息 生成路径
	 * 
	 * @param message
	 * @param file
	 */
	public static void createBarcode(String message, File file) {
		try {
			// 意为文件输出流，是用于将数据写入File或 FileDescriptor的输出流。
			FileOutputStream fos = new FileOutputStream(file);
			// 调用方法
			createBarcode(message, fos);
			fos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * OutputStream是流的形式,具体可以表现为FileOutputStream的形式进行整行的写入
	 * 
	 * @param message
	 * @param os
	 */

	public static void createBarcode(String message, OutputStream os) {
		try {
			BufferedImage image = getJBarcode().createBarcode(message);
			ImageUtil.encodeAndWrite(image, ImageUtil.PNG, os, BARCODE_DPI, BARCODE_DPI);
			os.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 自定义的 TextPainter， 允许定义字体，大小等等。
	 */
	public static class CustomTextPainter implements TextPainter {
		public static CustomTextPainter instance = new CustomTextPainter();

		public static CustomTextPainter getInstance() {
			return instance;
		}

		@Override
		public void paintText(BufferedImage barCodeImage, String text, int width) {
			Graphics g2d = barCodeImage.getGraphics();

			Font font = new Font(FONT_FAMILY, Font.PLAIN, FONT_SIZE * width);
			g2d.setFont(font);
			FontMetrics fm = g2d.getFontMetrics();
			int height = fm.getHeight();
			int center = (barCodeImage.getWidth() - fm.stringWidth(text)) / 2;
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, barCodeImage.getWidth(), barCodeImage.getHeight() * 1 / 20);
			g2d.fillRect(0, barCodeImage.getHeight() - (height * 9 / 10), barCodeImage.getWidth(), (height * 9 / 10));
			g2d.setColor(Color.BLACK);
			g2d.drawString(text, center, barCodeImage.getHeight() - (height / 10) - 2);
		}
	}

	public static void main(String[] args) {
		System.err.println(new File("d:\\IMG\\55.png") + "---------------------");
		BarcodeUtils.createBarcode("20170307152418041", new File("d:\\IMG\\55.png"));
		BarcodeUtils.createBarcode("000220013001", new File("d:\\IMG\\66.png"));
	}

}
