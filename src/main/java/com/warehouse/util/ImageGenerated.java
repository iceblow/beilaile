package com.warehouse.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.warehouse.entity.ApparelDevelopmentManagement;
import com.warehouse.entity.ApparelDevelopmentMissSampleimg;
import com.warehouse.entity.ApprovalApplication;

/**
 * 图片文字组合
 * 
 * @author king
 * @createDate 2016-12
 */
@SuppressWarnings("restriction")
public class ImageGenerated {

	public static void exportImg(ApparelDevelopmentManagement record, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		try {
			String path = realPath + "res/images/model.jpg";
			InputStream is = new FileInputStream(path);
			// 通过JPEG图象流创建JPEG数据流解码器
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			// 解码当前JPEG数据流，返回BufferedImage对象
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			// 得到画笔对象
			Graphics g = buffImg.getGraphics();
			// 创建你要附加的图象。
			// 小图片的路径
			ImageIcon imgIcon = new ImageIcon(realPath + record.getProcessImg());
			// 得到Image对象。
			Image img = imgIcon.getImage();
			// 将小图片绘到大图片上。
			BufferedImage bufferedImage = ImageIO.read(new File(realPath + record.getProcessImg()));
			int width = bufferedImage.getWidth();// 图片的宽
			int height = bufferedImage.getHeight();// 图片的高
			double bl = 1500.0 / (double) height;
			double bll = 2270.0 / (double) width;
			// 高比例小于宽比例
			if (bl < bll) {
				height = (int) (height * bl);
				width = (int) (width * bl);
			} else {// 宽比例小于高比例
				height = (int) (height * bll);
				width = (int) (width * bll);
			}
			int h = height <= 1488 ? height : 1500;
			int w = width <= 2270 ? width : 2270;
			// Image对象，横坐标,纵坐标，宽，高，null .表示你的小图片在大图片上的位置。
			g.drawImage(img, 200, 600, w, h, null);
			// 设置颜色。
			// g.setColor(Color.BLACK);
			// 最后一个参数用来设置字体的大小
			Font f = new Font("宋体", Font.PLAIN, 100);
			Color mycolor = Color.red;// new Color(0, 0, 255);
			g.setColor(mycolor);
			g.setFont(f);
			String girard = record.getGirard() == null ? "" : "第 " + record.getGirard() + "波";
			String platewave = record.getPlatewave() == null ? "" : "版型同波次第 " + record.getPlatewave() + "波";
			String print = record.getReferPrint() == null ? "" : "参考印花 " + record.getReferPrint();
			g.drawString(girard, 300, 600);
			g.drawString(print, 300, 2180);
			g.drawString(platewave, 1500, 2180);
			g.dispose();

			// 件数
			Graphics g2 = buffImg.getGraphics();
			Font f2 = new Font("宋体", Font.PLAIN, 80);
			Color mycolor1 = Color.black;
			g2.setColor(mycolor1);
			g2.setFont(f2);
			String code52 = (String) (record.getCode52() == null || record.getCode52() == 0 ? "" : "52/");
			String code59 = (String) (record.getCode59() == null || record.getCode59() == 0 ? "" : "59");
			String code66 = (String) (record.getCode66() == null || record.getCode66() == 0 ? "" : "/66");
			String code73 = (String) (record.getCode73() == null || record.getCode73() == 0 ? "" : "/73");
			String code80 = (String) (record.getCode80() == null || record.getCode80() == 0 ? "" : "/80");
			String code90 = (String) (record.getCode90() == null || record.getCode90() == 0 ? "" : "/90");

			String code100 = (String) (record.getCode100() == null || record.getCode100() == 0 ? "" : "/100");
			String code110 = (String) (record.getCode110() == null || record.getCode110() == 0 ? "" : "/110");
			String code120 = (String) (record.getCode120() == null || record.getCode120() == 0 ? "" : "/120");
			String code130 = (String) (record.getCode130() == null || record.getCode130() == 0 ? "" : "/130");
			String code160 = (String) (record.getCode160() == null || record.getCode160() == 0 ? "" : "/160");
			String code170 = (String) (record.getCode170() == null || record.getCode170() == 0 ? "" : "/170");
			String c1 = (String) (record.getCode52() == null || record.getCode52() == 0 ? ""
					: "-" + record.getCode52());
			String c2 = (String) (record.getCode59() == null || record.getCode59() == 0 ? ""
					: "-" + record.getCode59());
			String c3 = (String) (record.getCode66() == null || record.getCode66() == 0 ? ""
					: "-" + record.getCode66());
			String c4 = (String) (record.getCode73() == null || record.getCode73() == 0 ? ""
					: "-" + record.getCode73());
			String c5 = (String) (record.getCode80() == null || record.getCode80() == 0 ? ""
					: "-" + record.getCode80());
			String c6 = (String) (record.getCode90() == null || record.getCode90() == 0 ? ""
					: "-" + record.getCode90());

			String c7 = (String) (record.getCode100() == null || record.getCode100() == 0 ? ""
					: "-" + record.getCode100());
			String c8 = (String) (record.getCode110() == null || record.getCode110() == 0 ? ""
					: "-" + record.getCode110());
			String c9 = (String) (record.getCode120() == null || record.getCode120() == 0 ? ""
					: "-" + record.getCode120());
			String c10 = (String) (record.getCode130() == null || record.getCode130() == 0 ? ""
					: "-" + record.getCode130());
			String c11 = (String) (record.getCode160() == null || record.getCode160() == 0 ? ""
					: "-" + record.getCode160());
			String c12 = (String) (record.getCode170() == null || record.getCode170() == 0 ? ""
					: "-" + record.getCode170());
			// 前台获取
			String str = "下单数量:" + code52 + code59 + code66 + code73 + code80 + code90 + code100 + code110 + code120
					+ code130 + code160 + code170 + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12 + " 共"
					+ record.getTotal() + "件";

			g2.drawString(str, 150, 2300);
			g2.dispose();

			// 右侧
			Graphics g1 = buffImg.getGraphics();
			Font f1 = new Font("宋体", Font.PLAIN, 40);
			g1.setColor(mycolor1);
			g1.setFont(f1);
			// 判断--------------------------------------------
			String model = record.getModel() == null ? "" : record.getModel();
			String designer = record.getDesigner() == null ? "" : record.getDesigner();
			// String codenum = record.getCodeNum() == null ? "" : "" +
			// record.getCodeNum();
			// String audit = record.getAudit() == null ? "" :
			// record.getAudit();
			// String pattern = record.getPattern() == null ? "" :
			// record.getPattern();
			// String carVersion = record.getCarversion() == null ? "" :
			// record.getCarversion();
			String designTime = record.getDesignTime() == null ? "" : record.getDesignTime();
			// String releaseDate = record.getReleasedate() == null ? "" :
			// record.getReleasedate();
			// String completionDate = record.getCompletiondate() == null ? "" :
			// record.getCompletiondate();
			// String sizeConfirmation = record.getSizeconfirmation() == null ?
			// "" : record.getSizeconfirmation();
			// String Obsolete = record.getObsolete() == null ? "" :
			// record.getObsolete();
			// String merchandiser = record.getMerchandiser() == null ? "" :
			// record.getMerchandiser();
			// String supplier = record.getSupplier() == null ? "" :
			// record.getSupplier();

			String getSmallSampleA = record.getSmallsamplea() == null ? "" : record.getSmallsamplea();
			String addressA = record.getAddressa() == null ? "" : record.getAddressa();
			String widthA = record.getWidtha() == null ? "" : record.getWidtha();
			String IngredientA = record.getIngredienta() == null ? "" : record.getIngredienta();

			String getSmallSampleB = record.getSmallsampleb() == null ? "" : record.getSmallsampleb();
			String addressB = record.getAddressb() == null ? "" : record.getAddressb();
			String widthB = record.getWidthb() == null ? "" : record.getWidthb();
			String IngredientB = record.getIngredientb() == null ? "" : record.getIngredientb();

			String getSmallSampleC = record.getSmallsamplec() == null ? "" : record.getSmallsamplec();
			String addressC = record.getAddressc() == null ? "" : record.getAddressc();
			String widthC = record.getWidthc() == null ? "" : record.getWidthc();
			String IngredientC = record.getIngredientc() == null ? "" : record.getIngredientc();

			String getSmallSampleD = record.getSmallsampled() == null ? "" : record.getSmallsampled();
			String addressD = record.getAddressd() == null ? "" : record.getAddressd();
			String widthD = record.getWidthd() == null ? "" : record.getWidthd();
			String IngredientD = record.getIngredientd() == null ? "" : record.getIngredientd();

			String getSmallSampleE = record.getSmallsamplee() == null ? "" : record.getSmallsamplee();
			String addressE = record.getAddresse() == null ? "" : record.getAddresse();
			String widthE = record.getWidthe() == null ? "" : record.getWidthe();
			String IngredientE = record.getIngrediente() == null ? "" : record.getIngrediente();

			String smallSampleAF = record.getSmallsampleaf() == null ? "" : record.getSmallsampleaf();
			String addressAF = record.getAddressaf() == null ? "" : record.getAddressaf();
			String widthAF = record.getWidthaf() == null ? "" : record.getWidthaf();
			String IngredientAF = record.getIngredientaf() == null ? "" : record.getIngredientaf();

			String smallSampleBF = record.getSmallsamplebf() == null ? "" : record.getSmallsamplebf();
			String addressBF = record.getAddressbf() == null ? "" : record.getAddressbf();
			String widthBF = record.getWidthbf() == null ? "" : record.getWidthbf();
			String IngredientBF = record.getIngredientbf() == null ? "" : record.getIngredientbf();

			String smallSampleCF = record.getSmallsamplecf() == null ? "" : record.getSmallsamplecf();
			String addressCF = record.getAddresscf() == null ? "" : record.getAddresscf();
			String widthCF = record.getWidthcf() == null ? "" : record.getWidthcf();
			String IngredientCF = record.getIngredientcf() == null ? "" : record.getIngredientcf();

			String printPosition = record.getPrintPosition() == null ? "" : record.getPrintPosition();
			String embroideredPosition = record.getEmbroideredPosition() == null ? "" : record.getEmbroideredPosition();
			String remark = record.getRemark() == null ? "" : record.getRemark();
			// -----------------------------------------------------
			g1.drawString(model, 2700, 140);// 款号
			g1.drawString(designer, 3150, 140);// 设计师
			g1.drawString("73", 2700, 200);// 头版码数
			// g1.drawString(audit, 3150, 200);// 审核
			// g1.drawString(pattern, 2700, 270);// 纸样
			// g1.drawString(carVersion, 3150, 270);// 车版
			g1.drawString(designTime, 2700, 340);// 发版时间
			// g1.drawString(completionDate, 3150, 340);// 完成时间
			// g1.drawString(sizeConfirmation, 2700, 400);// 尺码确认
			// g1.drawString(Obsolete, 3150, 400);// 作废
			// g1.drawString(merchandiser, 2700, 470);// 跟单员
			// g1.drawString(supplier, 3150, 470);// 供应商
			// 面料A
			if (getSmallSampleA.length() > 6) {
				String result0 = getSmallSampleA.substring(0, 6);// 截1
				g1.drawString(result0, 2700, 600);
				// 截2
				if (getSmallSampleA.length() > 12) {
					g1.drawString(getSmallSampleA.substring(6, 12), 2700, 640);
					g1.drawString(getSmallSampleA.substring(12), 2700, 680);
				} else {
					g1.drawString(getSmallSampleA.substring(6), 2700, 640);
				}
			} else {
				g1.drawString(getSmallSampleA, 2700, 600);
			}
			g1.drawString(addressA, 2920, 650);// 地址
			g1.drawString(widthA, 3100, 650);// 幅宽
			// 成分
			if (IngredientA.length() > 6) {
				String result = IngredientA.substring(0, 6);// 截1
				g1.drawString(result, 3260, 600);
				// 截2
				if (IngredientA.length() > 12) {
					g1.drawString(IngredientA.substring(6, 12), 3260, 640);
					g1.drawString(IngredientA.substring(12), 3260, 680);
				} else {
					g1.drawString(IngredientA.substring(6), 3260, 640);
				}
			} else {
				g1.drawString(IngredientA, 3260, 620);
			}

			// 面料B
			if (getSmallSampleB.length() > 6) {
				String result0 = getSmallSampleB.substring(0, 6);// 截1
				g1.drawString(result0, 2700, 780);
				// 截2
				if (getSmallSampleB.length() > 12) {
					g1.drawString(getSmallSampleB.substring(6, 12), 2700, 830);
					g1.drawString(getSmallSampleB.substring(12), 2700, 880);
				} else {
					g1.drawString(getSmallSampleB.substring(6), 2700, 830);
				}
			} else {
				g1.drawString(getSmallSampleB, 2700, 780);
			}
			g1.drawString(addressB, 2920, 800);// 地址
			g1.drawString(widthB, 3100, 800);// 幅宽
			// 成分
			if (IngredientB.length() > 6) {
				String result = IngredientB.substring(0, 6);// 截1
				g1.drawString(result, 3260, 780);
				// 截2
				if (IngredientB.length() > 12) {
					g1.drawString(IngredientB.substring(6, 12), 3260, 830);
					g1.drawString(IngredientB.substring(12), 3260, 880);
				} else {
					g1.drawString(IngredientB.substring(6), 3260, 830);
				}
			} else {
				g1.drawString(IngredientB, 3260, 780);
			}

			// 面料C
			if (getSmallSampleC.length() > 6) {
				String result = getSmallSampleC.substring(0, 6);// 截1
				g1.drawString(result, 2700, 930);// 780
				// 截2
				if (getSmallSampleC.length() > 12) {
					g1.drawString(getSmallSampleC.substring(6, 12), 2700, 980);
					g1.drawString(getSmallSampleC.substring(12), 2700, 1030);
				} else {
					g1.drawString(getSmallSampleC.substring(6), 2700, 980);
				}
			} else {
				g1.drawString(getSmallSampleC, 2700, 930);
			}
			g1.drawString(addressC, 2920, 950);// 地址
			g1.drawString(widthC, 3100, 950);// 幅宽
			// 成分
			if (IngredientC.length() > 6) {
				String result = IngredientC.substring(0, 6);// 截1
				g1.drawString(result, 3260, 930);
				// 截2
				if (IngredientC.length() > 12) {
					g1.drawString(IngredientC.substring(6, 12), 3260, 980);
					g1.drawString(IngredientC.substring(12), 3260, 1030);
				} else {
					g1.drawString(IngredientC.substring(6), 3260, 980);
				}
			} else {
				g1.drawString(IngredientC, 3260, 930);
			}

			// 面料D
			if (getSmallSampleD.length() > 6) {
				String result = getSmallSampleD.substring(0, 6);// 截1
				g1.drawString(result, 2700, 1090);
				// 截2
				if (getSmallSampleD.length() > 12) {
					g1.drawString(getSmallSampleD.substring(6, 12), 2700, 1140);
					g1.drawString(getSmallSampleD.substring(12), 2700, 1190);
				} else {
					g1.drawString(getSmallSampleD.substring(6), 2700, 1140);
				}
			} else {
				g1.drawString(getSmallSampleD, 2700, 1090);
			}
			g1.drawString(addressD, 2920, 1100);// 地址
			g1.drawString(widthD, 3100, 1100);// 幅宽
			// 成分
			if (IngredientD.length() > 6) {
				String result = IngredientD.substring(0, 6);// 截1
				g1.drawString(result, 3260, 1090);
				// 截2
				if (IngredientD.length() > 12) {
					g1.drawString(IngredientD.substring(6, 12), 3260, 1140);
					g1.drawString(IngredientD.substring(12), 3260, 1190);
				} else {
					g1.drawString(IngredientD.substring(6), 3260, 1140);
				}
			} else {
				g1.drawString(IngredientD, 3260, 1090);
			}

			// 面料E
			if (getSmallSampleE.length() > 6) {
				String result = getSmallSampleE.substring(0, 6);// 截1
				g1.drawString(result, 2700, 1260);
				// 截2
				if (getSmallSampleE.length() > 12) {
					g1.drawString(getSmallSampleE.substring(6, 12), 2700, 1310);
					g1.drawString(getSmallSampleE.substring(12), 2700, 1360);
				} else {
					g1.drawString(getSmallSampleE.substring(6), 2700, 1310);
				}
			} else {
				g1.drawString(getSmallSampleE, 2700, 1260);
			}
			g1.drawString(addressE, 2920, 1250);// 地址
			g1.drawString(widthE, 3100, 1250);// 幅宽
			// 成分
			if (IngredientE.length() > 6) {
				String result = IngredientE.substring(0, 6);// 截1
				g1.drawString(result, 3260, 1260);
				// 截2
				if (IngredientE.length() > 12) {
					g1.drawString(IngredientE.substring(6, 12), 3260, 1310);
					g1.drawString(IngredientE.substring(12), 3260, 1360);
				} else {
					g1.drawString(IngredientE.substring(6), 3260, 1310);
				}
			} else {
				g1.drawString(IngredientE, 3260, 1260);
			}

			// 辅料A
			if (smallSampleAF.length() > 6) {
				// 截1
				g1.drawString(smallSampleAF.substring(0, 6), 2700, 1450);
				g1.drawString(smallSampleAF.substring(6), 2700, 1500);
			} else {
				g1.drawString(smallSampleAF, 2700, 1500);
			}

			g1.drawString(addressAF, 2920, 1500);// 地址
			g1.drawString(widthAF, 3100, 1500);// 幅宽
			// 成分
			if (IngredientAF.length() > 5) {
				String result = IngredientAF.substring(0, 5);// 截1
				g1.drawString(result, 3260, 1450);
				// 截2
				if (IngredientAF.length() > 10) {
					g1.drawString(IngredientAF.substring(5, 10), 3260, 1500);
					g1.drawString(IngredientAF.substring(10), 3260, 1550);
				} else {
					g1.drawString(IngredientAF.substring(5), 3260, 1500);
				}
			} else {
				g1.drawString(IngredientAF, 3260, 1500);
			}

			// 辅料B
			if (smallSampleBF.length() > 6) {
				// 截1
				g1.drawString(smallSampleBF.substring(0, 6), 2700, 1620);
				g1.drawString(smallSampleBF.substring(6), 2700, 1670);
			} else {
				g1.drawString(smallSampleBF, 2700, 1630);
			}

			g1.drawString(addressBF, 2920, 1650);// 地址
			g1.drawString(widthBF, 3100, 1650);// 幅宽
			// 成分
			if (IngredientBF.length() > 5) {
				String result = IngredientBF.substring(0, 5);// 截1
				g1.drawString(result, 3260, 1620);
				// 截2
				if (IngredientBF.length() > 10) {
					g1.drawString(IngredientBF.substring(5, 10), 3260, 1670);
					g1.drawString(IngredientBF.substring(10), 3260, 1850);
				} else {
					g1.drawString(IngredientBF.substring(5), 3260, 1670);
				}
			} else {
				g1.drawString(IngredientBF, 3260, 1620);
			}

			// 辅料C
			if (smallSampleCF.length() > 6) {
				// 截1
				g1.drawString(smallSampleCF.substring(0, 6), 2700, 1800);
				g1.drawString(smallSampleCF.substring(6), 2700, 1850);
			} else {
				g1.drawString(smallSampleCF, 2700, 1800);
			}

			g1.drawString(addressCF, 2920, 1800);// 地址
			g1.drawString(widthCF, 3100, 1800);// 幅宽
			// 成分
			if (IngredientCF.length() > 5) {
				String result = IngredientCF.substring(0, 5);// 截1
				g1.drawString(result, 3260, 1800);
				// 截2
				if (IngredientCF.length() > 10) {
					g1.drawString(IngredientCF.substring(5, 10), 3260, 1850);
					g1.drawString(IngredientCF.substring(10), 3260, 1900);
				} else {
					g1.drawString(IngredientCF.substring(5), 3260, 1850);
				}
			} else {
				g1.drawString(IngredientCF, 3260, 1800);
			}

			// 印花位置
			if (printPosition.length() > 17) {
				String result = printPosition.substring(0, 17);
				g1.drawString(result, 2700, 1950);
				g1.drawString(printPosition.substring(17), 2700, 2000);
			} else {
				g1.drawString(printPosition, 2700, 1950);
			}
			// 绣花位置
			if (embroideredPosition.length() > 17) {
				String result = embroideredPosition.substring(0, 17);
				g1.drawString(result, 2700, 2090);
				g1.drawString(embroideredPosition.substring(17), 2700, 2140);
			} else {
				g1.drawString(embroideredPosition, 2700, 2100);
			}
			// 备注
			if (remark.length() > 17) {
				String result = remark.substring(0, 17);
				g1.drawString(result, 2700, 2250);
				g1.drawString(remark.substring(17), 2700, 2300);
			} else {
				g1.drawString(remark, 2700, 2250);
			}
			g1.dispose();
			OutputStream os;
			// 图片存放路径
			File file = new File(realPath + "SampleImg");// 文件夹存放路径
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			String shareFileName = file + "/" + record.getGirard() + ".jpg";
			record.setSampleImg("SampleImg\\" + record.getGirard() + ".jpg");
			os = new FileOutputStream(shareFileName);
			// 创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 补工艺单
	 * 
	 * @param record
	 * @param request
	 */
	public static void exportImg(ApparelDevelopmentMissSampleimg record, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		try {
			String path = realPath + "res/images/model.jpg";
			InputStream is = new FileInputStream(path);
			// 通过JPEG图象流创建JPEG数据流解码器
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			// 解码当前JPEG数据流，返回BufferedImage对象
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			// 得到画笔对象
			Graphics g = buffImg.getGraphics();
			// 创建你要附加的图象。
			// 小图片的路径
			ImageIcon imgIcon = new ImageIcon(realPath + record.getProcessImg());
			// 得到Image对象。
			Image img = imgIcon.getImage();
			// 将小图片绘到大图片上。
			BufferedImage bufferedImage = ImageIO.read(new File(realPath + record.getProcessImg()));
			int width = bufferedImage.getWidth();// 图片的宽
			int height = bufferedImage.getHeight();// 图片的高
			double bl = 1500.0 / (double) height;
			double bll = 2270.0 / (double) width;
			// 高比例小于宽比例
			if (bl < bll) {
				height = (int) (height * bl);
				width = (int) (width * bl);
			} else {// 宽比例小于高比例
				height = (int) (height * bll);
				width = (int) (width * bll);
			}
			int h = height <= 1488 ? height : 1500;
			int w = width <= 2270 ? width : 2270;
			// Image对象，横坐标,纵坐标，宽，高，null .表示你的小图片在大图片上的位置。
			g.drawImage(img, 200, 600, w, h, null);
			// 最后一个参数用来设置字体的大小
			Font f = new Font("宋体", Font.PLAIN, 100);
			Color mycolor = Color.red;// new Color(0, 0, 255);
			g.setColor(mycolor);
			g.setFont(f);
			String originalWave = record.getOriginalWave() == null ||"".equals(record.getOriginalWave())? "第 " + record.getGirard() + "波" : "第 " + record.getOriginalWave() + "波";
			String platewave = record.getPlatewave() == null ? "" : "版型同波次第 " + record.getPlatewave() + "波";
			String print = record.getReferPrint() == null ? "" : "参考印花 " + record.getReferPrint();
			g.drawString(originalWave, 300, 600);
			g.drawString(print, 300, 2180);
			g.drawString(platewave, 1500, 2180);
			g.dispose();

			// 件数
			Graphics g2 = buffImg.getGraphics();
			Font f2 = new Font("宋体", Font.PLAIN, 80);
			Color mycolor1 = Color.black;
			g2.setColor(mycolor1);
			g2.setFont(f2);
			String code52 = (String) (record.getCode52() == null || record.getCode52() == 0 ? "" : "52/");
			String code59 = (String) (record.getCode59() == null || record.getCode59() == 0 ? "" : "59");
			String code66 = (String) (record.getCode66() == null || record.getCode66() == 0 ? "" : "/66");
			String code73 = (String) (record.getCode73() == null || record.getCode73() == 0 ? "" : "/73");
			String code80 = (String) (record.getCode80() == null || record.getCode80() == 0 ? "" : "/80");
			String code90 = (String) (record.getCode90() == null || record.getCode90() == 0 ? "" : "/90");

			String code100 = (String) (record.getCode100() == null || record.getCode100() == 0 ? "" : "/100");
			String code110 = (String) (record.getCode110() == null || record.getCode110() == 0 ? "" : "/110");
			String code120 = (String) (record.getCode120() == null || record.getCode120() == 0 ? "" : "/120");
			String code130 = (String) (record.getCode130() == null || record.getCode130() == 0 ? "" : "/130");
			String code160 = (String) (record.getCode160() == null || record.getCode160() == 0 ? "" : "/160");
			String code170 = (String) (record.getCode170() == null || record.getCode170() == 0 ? "" : "/170");
			String c1 = (String) (record.getCode52() == null || record.getCode52() == 0 ? ""
					: "-" + record.getCode52());
			String c2 = (String) (record.getCode59() == null || record.getCode59() == 0 ? ""
					: "-" + record.getCode59());
			String c3 = (String) (record.getCode66() == null || record.getCode66() == 0 ? ""
					: "-" + record.getCode66());
			String c4 = (String) (record.getCode73() == null || record.getCode73() == 0 ? ""
					: "-" + record.getCode73());
			String c5 = (String) (record.getCode80() == null || record.getCode80() == 0 ? ""
					: "-" + record.getCode80());
			String c6 = (String) (record.getCode90() == null || record.getCode90() == 0 ? ""
					: "-" + record.getCode90());
			String c7 = (String) (record.getCode100() == null || record.getCode100() == 0 ? ""
					: "-" + record.getCode100());
			String c8 = (String) (record.getCode110() == null || record.getCode110() == 0 ? ""
					: "-" + record.getCode110());
			String c9 = (String) (record.getCode120() == null || record.getCode120() == 0 ? ""
					: "-" + record.getCode120());
			String c10 = (String) (record.getCode130() == null || record.getCode130() == 0 ? ""
					: "-" + record.getCode130());
			String c11 = (String) (record.getCode160() == null || record.getCode160() == 0 ? ""
					: "-" + record.getCode160());
			String c12 = (String) (record.getCode170() == null || record.getCode170() == 0 ? ""
					: "-" + record.getCode170());
			// 后台计算
			String str = "下单数量:" + code52 + code59 + code66 + code73 + code80 + code90 + code100 + code110 + code120
					+ code130 + code160 + code170 + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12 + " 共"
					+ record.getTotal() + "件";

			g2.drawString(str, 150, 2300);
			g2.dispose();

			// 右侧
			Graphics g1 = buffImg.getGraphics();
			Font f1 = new Font("宋体", Font.PLAIN, 40);
			g1.setColor(mycolor1);
			g1.setFont(f1);
			// 判断--------------------------------------------
			String model = record.getModel() == null ? "" : record.getModel();
			String designer = record.getDesigner() == null ? "" : record.getDesigner();
			String designTime = record.getReleaseDate() == null ? "" : record.getReleaseDate();// 发版时间

			String getSmallSampleA = record.getSmallsamplea() == null ? "" : record.getSmallsamplea();
			String addressA = record.getAddressa() == null ? "" : record.getAddressa();
			String widthA = record.getWidtha() == null ? "" : record.getWidtha();
			String IngredientA = record.getIngredienta() == null ? "" : record.getIngredienta();

			String getSmallSampleB = record.getSmallsampleb() == null ? "" : record.getSmallsampleb();
			String addressB = record.getAddressb() == null ? "" : record.getAddressb();
			String widthB = record.getWidthb() == null ? "" : record.getWidthb();
			String IngredientB = record.getIngredientb() == null ? "" : record.getIngredientb();

			String getSmallSampleC = record.getSmallsamplec() == null ? "" : record.getSmallsamplec();
			String addressC = record.getAddressc() == null ? "" : record.getAddressc();
			String widthC = record.getWidthc() == null ? "" : record.getWidthc();
			String IngredientC = record.getIngredientc() == null ? "" : record.getIngredientc();

			String getSmallSampleD = record.getSmallsampled() == null ? "" : record.getSmallsampled();
			String addressD = record.getAddressd() == null ? "" : record.getAddressd();
			String widthD = record.getWidthd() == null ? "" : record.getWidthd();
			String IngredientD = record.getIngredientd() == null ? "" : record.getIngredientd();

			String getSmallSampleE = record.getSmallsamplee() == null ? "" : record.getSmallsamplee();
			String addressE = record.getAddresse() == null ? "" : record.getAddresse();
			String widthE = record.getWidthe() == null ? "" : record.getWidthe();
			String IngredientE = record.getIngrediente() == null ? "" : record.getIngrediente();

			String smallSampleAF = record.getSmallsampleaf() == null ? "" : record.getSmallsampleaf();
			String addressAF = record.getAddressaf() == null ? "" : record.getAddressaf();
			String widthAF = record.getWidthaf() == null ? "" : record.getWidthaf();
			String IngredientAF = record.getIngredientaf() == null ? "" : record.getIngredientaf();

			String smallSampleBF = record.getSmallsamplebf() == null ? "" : record.getSmallsamplebf();
			String addressBF = record.getAddressbf() == null ? "" : record.getAddressbf();
			String widthBF = record.getWidthbf() == null ? "" : record.getWidthbf();
			String IngredientBF = record.getIngredientbf() == null ? "" : record.getIngredientbf();

			String smallSampleCF = record.getSmallsamplecf() == null ? "" : record.getSmallsamplecf();
			String addressCF = record.getAddresscf() == null ? "" : record.getAddresscf();
			String widthCF = record.getWidthcf() == null ? "" : record.getWidthcf();
			String IngredientCF = record.getIngredientcf() == null ? "" : record.getIngredientcf();

			String printPosition = record.getPrintPosition() == null ? "" : record.getPrintPosition();
			String embroideredPosition = record.getEmbroideredPosition() == null ? "" : record.getEmbroideredPosition();
			String remark = record.getRemark() == null ? "" : record.getRemark();
			// -----------------------------------------------------
			g1.drawString(model, 2700, 140);// 款号
			g1.drawString(designer, 3150, 140);// 设计师
			g1.drawString("73", 2700, 200);// 头版码数
			g1.drawString(designTime, 2700, 340);// 发版时间
			// 面料A
			if (getSmallSampleA.length() > 6) {
				String result0 = getSmallSampleA.substring(0, 6);// 截1
				g1.drawString(result0, 2700, 600);
				// 截2
				if (getSmallSampleA.length() > 12) {
					g1.drawString(getSmallSampleA.substring(6, 12), 2700, 640);
					g1.drawString(getSmallSampleA.substring(12), 2700, 680);
				} else {
					g1.drawString(getSmallSampleA.substring(6), 2700, 640);
				}
			} else {
				g1.drawString(getSmallSampleA, 2700, 600);
			}
			g1.drawString(addressA, 2920, 650);// 地址
			g1.drawString(widthA, 3100, 650);// 幅宽
			// 成分
			if (IngredientA.length() > 6) {
				String result = IngredientA.substring(0, 6);// 截1
				g1.drawString(result, 3260, 600);
				// 截2
				if (IngredientA.length() > 12) {
					g1.drawString(IngredientA.substring(6, 12), 3260, 640);
					g1.drawString(IngredientA.substring(12), 3260, 680);
				} else {
					g1.drawString(IngredientA.substring(6), 3260, 640);
				}
			} else {
				g1.drawString(IngredientA, 3260, 620);
			}

			// 面料B
			if (getSmallSampleB.length() > 6) {
				String result0 = getSmallSampleB.substring(0, 6);// 截1
				g1.drawString(result0, 2700, 780);
				// 截2
				if (getSmallSampleB.length() > 12) {
					g1.drawString(getSmallSampleB.substring(6, 12), 2700, 830);
					g1.drawString(getSmallSampleB.substring(12), 2700, 880);
				} else {
					g1.drawString(getSmallSampleB.substring(6), 2700, 830);
				}
			} else {
				g1.drawString(getSmallSampleB, 2700, 780);
			}
			g1.drawString(addressB, 2920, 800);// 地址
			g1.drawString(widthB, 3100, 800);// 幅宽
			// 成分
			if (IngredientB.length() > 6) {
				String result = IngredientB.substring(0, 6);// 截1
				g1.drawString(result, 3260, 780);
				// 截2
				if (IngredientB.length() > 12) {
					g1.drawString(IngredientB.substring(6, 12), 3260, 830);
					g1.drawString(IngredientB.substring(12), 3260, 880);
				} else {
					g1.drawString(IngredientB.substring(6), 3260, 830);
				}
			} else {
				g1.drawString(IngredientB, 3260, 780);
			}

			// 面料C
			if (getSmallSampleC.length() > 6) {
				String result = getSmallSampleC.substring(0, 6);// 截1
				g1.drawString(result, 2700, 930);// 780
				// 截2
				if (getSmallSampleC.length() > 12) {
					g1.drawString(getSmallSampleC.substring(6, 12), 2700, 980);
					g1.drawString(getSmallSampleC.substring(12), 2700, 1030);
				} else {
					g1.drawString(getSmallSampleC.substring(6), 2700, 980);
				}
			} else {
				g1.drawString(getSmallSampleC, 2700, 930);
			}
			g1.drawString(addressC, 2920, 950);// 地址
			g1.drawString(widthC, 3100, 950);// 幅宽
			// 成分
			if (IngredientC.length() > 6) {
				String result = IngredientC.substring(0, 6);// 截1
				g1.drawString(result, 3260, 930);
				// 截2
				if (IngredientC.length() > 12) {
					g1.drawString(IngredientC.substring(6, 12), 3260, 980);
					g1.drawString(IngredientC.substring(12), 3260, 1030);
				} else {
					g1.drawString(IngredientC.substring(6), 3260, 980);
				}
			} else {
				g1.drawString(IngredientC, 3260, 930);
			}

			// 面料D
			if (getSmallSampleD.length() > 6) {
				String result = getSmallSampleD.substring(0, 6);// 截1
				g1.drawString(result, 2700, 1090);
				// 截2
				if (getSmallSampleD.length() > 12) {
					g1.drawString(getSmallSampleD.substring(6, 12), 2700, 1140);
					g1.drawString(getSmallSampleD.substring(12), 2700, 1190);
				} else {
					g1.drawString(getSmallSampleD.substring(6), 2700, 1140);
				}
			} else {
				g1.drawString(getSmallSampleD, 2700, 1090);
			}
			g1.drawString(addressD, 2920, 1100);// 地址
			g1.drawString(widthD, 3100, 1100);// 幅宽
			// 成分
			if (IngredientD.length() > 6) {
				String result = IngredientD.substring(0, 6);// 截1
				g1.drawString(result, 3260, 1090);
				// 截2
				if (IngredientD.length() > 12) {
					g1.drawString(IngredientD.substring(6, 12), 3260, 1140);
					g1.drawString(IngredientD.substring(12), 3260, 1190);
				} else {
					g1.drawString(IngredientD.substring(6), 3260, 1140);
				}
			} else {
				g1.drawString(IngredientD, 3260, 1090);
			}

			// 面料E
			if (getSmallSampleE.length() > 6) {
				String result = getSmallSampleE.substring(0, 6);// 截1
				g1.drawString(result, 2700, 1260);
				// 截2
				if (getSmallSampleE.length() > 12) {
					g1.drawString(getSmallSampleE.substring(6, 12), 2700, 1310);
					g1.drawString(getSmallSampleE.substring(12), 2700, 1360);
				} else {
					g1.drawString(getSmallSampleE.substring(6), 2700, 1310);
				}
			} else {
				g1.drawString(getSmallSampleE, 2700, 1260);
			}
			g1.drawString(addressE, 2920, 1250);// 地址
			g1.drawString(widthE, 3100, 1250);// 幅宽
			// 成分
			if (IngredientE.length() > 6) {
				String result = IngredientE.substring(0, 6);// 截1
				g1.drawString(result, 3260, 1260);
				// 截2
				if (IngredientE.length() > 12) {
					g1.drawString(IngredientE.substring(6, 12), 3260, 1310);
					g1.drawString(IngredientE.substring(12), 3260, 1360);
				} else {
					g1.drawString(IngredientE.substring(6), 3260, 1310);
				}
			} else {
				g1.drawString(IngredientE, 3260, 1260);
			}

			// 辅料A
			if (smallSampleAF.length() > 6) {
				// 截1
				g1.drawString(smallSampleAF.substring(0, 6), 2700, 1450);
				g1.drawString(smallSampleAF.substring(6), 2700, 1500);
			} else {
				g1.drawString(smallSampleAF, 2700, 1500);
			}

			g1.drawString(addressAF, 2920, 1500);// 地址
			g1.drawString(widthAF, 3100, 1500);// 幅宽
			// 成分
			if (IngredientAF.length() > 5) {
				String result = IngredientAF.substring(0, 5);// 截1
				g1.drawString(result, 3260, 1450);
				// 截2
				if (IngredientAF.length() > 10) {
					g1.drawString(IngredientAF.substring(5, 10), 3260, 1500);
					g1.drawString(IngredientAF.substring(10), 3260, 1550);
				} else {
					g1.drawString(IngredientAF.substring(5), 3260, 1500);
				}
			} else {
				g1.drawString(IngredientAF, 3260, 1500);
			}

			// 辅料B
			if (smallSampleBF.length() > 6) {
				// 截1
				g1.drawString(smallSampleBF.substring(0, 6), 2700, 1620);
				g1.drawString(smallSampleBF.substring(6), 2700, 1670);
			} else {
				g1.drawString(smallSampleBF, 2700, 1630);
			}

			g1.drawString(addressBF, 2920, 1650);// 地址
			g1.drawString(widthBF, 3100, 1650);// 幅宽
			// 成分
			if (IngredientBF.length() > 5) {
				String result = IngredientBF.substring(0, 5);// 截1
				g1.drawString(result, 3260, 1620);
				// 截2
				if (IngredientBF.length() > 10) {
					g1.drawString(IngredientBF.substring(5, 10), 3260, 1670);
					g1.drawString(IngredientBF.substring(10), 3260, 1850);
				} else {
					g1.drawString(IngredientBF.substring(5), 3260, 1670);
				}
			} else {
				g1.drawString(IngredientBF, 3260, 1620);
			}

			// 辅料C
			if (smallSampleCF.length() > 6) {
				// 截1
				g1.drawString(smallSampleCF.substring(0, 6), 2700, 1800);
				g1.drawString(smallSampleCF.substring(6), 2700, 1850);
			} else {
				g1.drawString(smallSampleCF, 2700, 1800);
			}

			g1.drawString(addressCF, 2920, 1800);// 地址
			g1.drawString(widthCF, 3100, 1800);// 幅宽
			// 成分
			if (IngredientCF.length() > 5) {
				String result = IngredientCF.substring(0, 5);// 截1
				g1.drawString(result, 3260, 1800);
				// 截2
				if (IngredientCF.length() > 10) {
					g1.drawString(IngredientCF.substring(5, 10), 3260, 1850);
					g1.drawString(IngredientCF.substring(10), 3260, 1900);
				} else {
					g1.drawString(IngredientCF.substring(5), 3260, 1850);
				}
			} else {
				g1.drawString(IngredientCF, 3260, 1800);
			}

			// 印花位置
			if (printPosition.length() > 17) {
				String result = printPosition.substring(0, 17);
				g1.drawString(result, 2700, 1950);
				g1.drawString(printPosition.substring(17), 2700, 2000);
			} else {
				g1.drawString(printPosition, 2700, 1950);
			}
			// 绣花位置
			if (embroideredPosition.length() > 17) {
				String result = embroideredPosition.substring(0, 17);
				g1.drawString(result, 2700, 2090);
				g1.drawString(embroideredPosition.substring(17), 2700, 2140);
			} else {
				g1.drawString(embroideredPosition, 2700, 2100);
			}
			// 备注
			if (remark.length() > 17) {
				String result = remark.substring(0, 17);
				g1.drawString(result, 2700, 2250);
				g1.drawString(remark.substring(17), 2700, 2300);
			} else {
				g1.drawString(remark, 2700, 2250);
			}
			g1.dispose();
			OutputStream os;
			// 图片存放路径
			File file = new File(realPath + "SampleImg");// 文件夹存放路径
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			String shareFileName = file + "/" + record.getOriginalWave() + ".jpg";
			record.setSampleImg("SampleImg\\" + record.getOriginalWave() + ".jpg");
			os = new FileOutputStream(shareFileName);
			// 创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 返单是生成新的工艺单
	 * 
	 * @param application
	 * @param request
	 */
	public static void exportImgs(ApprovalApplication application, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		try {
			String path = realPath + application.getSampleImg();// 工艺单路径
			InputStream is = new FileInputStream(path);
			// 通过JPEG图象流创建JPEG数据流解码器
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			// 解码当前JPEG数据流，返回BufferedImage对象
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			// 得到画笔对象
			Graphics g = buffImg.getGraphics();
			// 创建你要附加的图象。
			// 小图片的路径
			ImageIcon imgIcon = new ImageIcon(realPath + "res/images/wave.jpg");// 波次
			// 得到Image对象。
			Image img = imgIcon.getImage();
			// 将小图片绘到大图片上。
			g.drawImage(img, 250, 500, null);
			imgIcon = new ImageIcon(realPath + "res/images/oldwave.jpg");// 原波次
			img = imgIcon.getImage();
			g.drawImage(img, 140, 2070, null);
			imgIcon = new ImageIcon(realPath + "res/images/total.jpg");// 订单数
			img = imgIcon.getImage();
			g.drawImage(img, 510, 2200, null);
			// 设置颜色。
			// 最后一个参数用来设置字体的大小
			Font f = new Font("宋体", Font.PLAIN, 110);
			Color mycolor = Color.red;
			g.setColor(mycolor);
			g.setFont(f);
			String girard = application.getGirard() == null ? "" : "第 " + application.getGirard() + "波";
			String print = application.getOriginalWave() == null ? "" : "原 " + application.getOriginalWave() + "波";
			g.drawString(girard, 300, 600);
			g.drawString(print, 380, 2150);
			// 件数
			Font f2 = new Font("宋体", Font.BOLD, 85);
			Color mycolor1 = Color.black;
			g.setColor(mycolor1);
			g.setFont(f2);
			String code52 = (String) (application.getCode52() == 0 ? "" : "52/");
			String code59 = (String) (application.getCode59() == 0 ? "" : "59");
			String code66 = (String) (application.getCode66() == 0 ? "" : "/66");
			String code73 = (String) (application.getCode73() == 0 ? "" : "/73");
			String code80 = (String) (application.getCode80() == 0 ? "" : "/80");
			String code90 = (String) (application.getCode90() == 0 ? "" : "/90");

			String code100 = (String) (application.getCode100() == 0 ? "" : "/100");
			String code110 = (String) (application.getCode110() == 0 ? "" : "/110");
			String code120 = (String) (application.getCode120() == 0 ? "" : "/120");
			String code130 = (String) (application.getCode130() == 0 ? "" : "/130");
			String code160 = (String) (application.getCode160() == 0 ? "" : "/160");
			String code170 = (String) (application.getCode170() == 0 ? "" : "/170");

			String c1 = (String) (application.getCode52() == 0 ? "" : "-" + application.getCode52());
			String c2 = (String) (application.getCode59() == 0 ? "" : "-" + application.getCode59());
			String c3 = (String) (application.getCode66() == 0 ? "" : "-" + application.getCode66());
			String c4 = (String) (application.getCode73() == 0 ? "" : "-" + application.getCode73());
			String c5 = (String) (application.getCode80() == 0 ? "" : "-" + application.getCode80());
			String c6 = (String) (application.getCode90() == 0 ? "" : "-" + application.getCode90());

			String c7 = (String) (application.getCode100() == 0 ? "" : "-" + application.getCode100());
			String c8 = (String) (application.getCode110() == 0 ? "" : "-" + application.getCode110());
			String c9 = (String) (application.getCode120() == 0 ? "" : "-" + application.getCode120());
			String c10 = (String) (application.getCode130() == 0 ? "" : "-" + application.getCode130());
			String c11 = (String) (application.getCode160() == 0 ? "" : "-" + application.getCode160());
			String c12 = (String) (application.getCode170() == 0 ? "" : "-" + application.getCode170());
			// 前台获取
			String str = code52 + code59 + code66 + code73 + code80 + code90 + code100 + code110 + code120 + code130
					+ code160 + code170 + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12 + " 共"
					+ application.getCount() + "件";
			g.drawString(str, 520, 2320);
			g.dispose();
			OutputStream os;
			// 图片存放路径
			File file = new File(realPath + "SampleImg");// 文件夹存放路径
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			String shareFileName = file + "/" + application.getGirard() + ".jpg";
			application.setSampleImg("SampleImg\\" + application.getGirard() + ".jpg");
			os = new FileOutputStream(shareFileName);
			// 创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}