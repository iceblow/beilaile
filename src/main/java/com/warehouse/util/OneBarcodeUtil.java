package com.warehouse.util;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

public class OneBarcodeUtil {

	public static void main(String[] paramArrayOfString) {
		try {
			JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());
			// 生成. 欧洲商品条码(=European Article Number)
			// 这里我们用作图书条码
			String str = "788515004012";
			String str1 = "1620204007266";
			BufferedImage localBufferedImage = localJBarcode.createBarcode(str1);
			/*
			 * saveToGIF(localBufferedImage, "EAN13.gif");
			 * localJBarcode.setEncoder(Code39Encoder.getInstance());
			 * localJBarcode.setPainter(WideRatioCodedPainter.getInstance());
			 * localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
			 * localJBarcode.setShowCheckDigit(false);
			 */
			// xx
			str = "1622220802159";
			localBufferedImage = localJBarcode.createBarcode(str);
			saveToPNG(localBufferedImage, "Code128.png");

		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "jpeg");
	}

	static void saveToPNG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "png");
	}

	static void saveToGIF(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "gif");
	}

	static void saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2) {
		try {
			FileOutputStream localFileOutputStream = new FileOutputStream("D://" + paramString1);
			System.out.println(paramString1 + "===============");
			ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);
			localFileOutputStream.close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

}
