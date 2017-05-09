package com.warehouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ZXingCode {
	public static void main(String[] args) throws Exception {

		String srcPath = "D:/1.png";
		File parentDir = new File("//192.168.0.171/htdocs/designImg");
		File targetPath = new File(parentDir, "22.jpg");
		InputStream in = new FileInputStream(srcPath);
		OutputStream out = new FileOutputStream(targetPath);
		try {
			byte[] bs = new byte[1024];
			int len = -1;
			while ((len = in.read(bs)) != -1) {
				out.write(bs, 0, len);
			}
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("上传成功！！");
	}
}
