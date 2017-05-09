package com.warehouse.constant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Test {
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		exportImg2("波次", "S1710013484", "D:/project/warehouse/src/main/webapp/res/images/design.jpg");

		// exportImg1();
	}

	public static void exportImg1() {
		int width = 100;
		int height = 100;
		String s = "你好";

		File file = new File("D:/project/warehouse/src/main/webapp/res/images/design.jpg");

		Font font = new Font("Serif", Font.BOLD, 10);
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setPaint(Color.RED);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(s, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;

		g2.drawString(s, (int) x, (int) baseY);

		try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void exportImg2(String username, String model, String headImg) {
		try {
			// 1.jpg是你的 主图片的路径
			InputStream is = new FileInputStream("D:/project/warehouse/src/main/webapp/res/images/model.jpg");

			// 通过JPEG图象流创建JPEG数据流解码器
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			// 解码当前JPEG数据流，返回BufferedImage对象
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			// 得到画笔对象
			Graphics g = buffImg.getGraphics();

			// 创建你要附加的图象。
			// 小图片的路径
			ImageIcon imgIcon = new ImageIcon(headImg);
			// 得到Image对象。
			Image img = imgIcon.getImage();
			// 将小图片绘到大图片上。
			// 5,300 .表示你的小图片在大图片上的位置。
			g.drawImage(img, 200, 600, null);
			// 设置颜色。
			g.setColor(Color.BLACK);
			// 最后一个参数用来设置字体的大小
			Font f = new Font("宋体", Font.PLAIN, 80);
			Color mycolor = Color.black;// new Color(0, 0, 255);
			g.setColor(mycolor);
			g.setFont(f);

			// 10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
			g.drawString(username, 300, 700);
			Font f1 = new Font("宋体", Font.PLAIN, 20);
			g.setFont(f1);
			g.drawString(model, 1000, 200);
			g.dispose();
			OutputStream os;

			// os = new FileOutputStream("d:/union.jpg");
			String shareFileName = "D:/" + System.currentTimeMillis() + ".jpg";
			os = new FileOutputStream(shareFileName);
			// 创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);

			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImageFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getIp2(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (!ip.equals("") && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (!ip.equals("") && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
