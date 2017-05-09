package com.warehouse.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.warehouse.entity.ProductInfo;
import com.warehouse.entity.QCTrack;
import com.warehouse.service.QCService;

@Controller
public class MyDemo {

	public static void main(String[] args) {
		MyDemo demo = new MyDemo();
		demo.getFileName("C:\\Users\\admin\\Desktop\\工艺单正式");
		System.err.println(demo.process.size());
		for (int i = 0; i < demo.process.size(); i++) {
			//System.err.println(demo.process.get(i).getWave());
			System.err.println(demo.process.get(i).getProcessImg());
			//System.err.println("波次号:"+demo.process.get(i).getWave()+"    工艺单:"+demo.process.get(i).getProcessImg());
		}
	}

	@Resource
	private QCService service;

	private int num = 0;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<ProductInfo> process = new ArrayList();

	public List<ProductInfo> getProcess() {
		return process;
	}

	public void setProcess(List<ProductInfo> process) {
		this.process = process;
	}

	/**
	 * 删除某个名字的文件
	 */
	public void deleteFile() {
		File file1 = new File("E:\\123");
		File[] list = file1.listFiles();
		for (File file : list) {
			if (file.getName().equals("myDemo.txt")) {
				file.delete();
			}
		}

	}

	/**
	 * 根据波次号修改文件名称
	 */
	@RequestMapping("upDateMyDemo")
	public String updateFileName() {
		List<QCTrack> list = new ArrayList();
		Pagess pagess = new Pagess();
		pagess.setBegin(1);
		pagess.setEnd(10);
		list = service.getAllByPage(pagess);
		// ---------------查询结束-----------------
		for (int i = 0; i < list.size(); i++) {

			File file = new File(
					"D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\warehouse\\"
							+ list.get(i).getImg()); // 指定文件名及路径
			String name = list.get(i).getB_id();
			String filename = file.getAbsolutePath();
			String lastName = "";
			if (filename.indexOf(".") >= 0) {
				System.err.println("这是个文件");
				lastName = filename.substring(filename.lastIndexOf("."));
				System.err.println("文件的名字是" + filename);
			} else {
				System.err.println("这是个目录");
			}
			String rootPath = file.getParent();
			// file.renameTo(new File(rootPath + "\\" + name + lastName));

		}
		return "修改成功";
	}

	/**
	 * 去掉文件名字中括弧及其中的内容
	 * 
	 * @param path
	 */
	public void updateFileNameByZhengZe(String path) {
		File file = new File(path); // 指定文件名及路径
		String name = file.getName().replaceAll("\\(.+\\)", "");// 去除名字中的(*)
		boolean b = file.renameTo(new File(
				"D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\工艺单"
						+ "\\" + name));
		if (b) {
			System.err.println("修改文件名称为"
					+ "D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\工艺单"
					+ "\\" + name);
		} else {
			System.err.println("重命名失败");
		}

	}

	/**
	 * 更改名字中有汉字的
	 * 
	 * @param path
	 */
	public void updateFileNameByHanZi(String path) {
		File file = new File(path); // 指定文件名及路径
		String name = file.getName().replaceAll("\\(.+\\)", "");// 去除名字中的(*)
		name = name.replaceAll("\\第", "");
		name = name.replaceAll("\\波", "");
		boolean b = file.renameTo(new File(
				"D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\工艺单"
						+ "\\" + name));
		if (b) {
			System.err.println("修改文件名称为"
					+ "D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\工艺单"
					+ "\\" + name);
		} else {
			System.err.println("重命名失败");
		}

	}

	/**
	 * 只修改路径
	 * 
	 * @param path
	 */
	public void updateFileParentName(String path) {
		File file = new File(path); // 指定文件名及路径
		String name = file.getName();// 得到文件名字
		boolean b = file.renameTo(new File(
				"D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\工艺单"
						+ "\\" + name));
		if (b) {
			System.err.println("修改文件名称为"
					+ "D:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\工艺单"
					+ "\\" + name);
		} else {
			System.err.println("重命名失败");
		}

	}

	/**
	 * 遍历文件夹,得到所有的文件并更改成正式的名称并且传送到指定的文件夹
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("getFileNameAndUpdate")
	public void getFileNameAndUpdate(String rootPath) {
		File file = new File(rootPath);
		if (file.isDirectory()) {
			File next[] = file.listFiles();
			if (next.length > 0) {
				for (int i = 0; i < next.length; i++) {
					getFileNameAndUpdate(next[i].getPath());
				}
			} else {
				System.err.println("这是个空文件夹------->");
				boolean s = file.delete();
				if (s) {
					System.err.println("空文件夹删除成功");
				} else {
					System.err.println("空文件夹删除失败");
				}
			}
		} else {
			num++;
			// 得到文件的后缀名
			String lastName = file.getName().substring(file.getName().lastIndexOf("."));
			// 如果文件的后缀名是图片的话将图片输出
			if (lastName.equals(".jpg") || lastName.equals(".png") || lastName.equals(".gif")
					|| lastName.equals(".JPG")) {
				// 1.判断名字中是否有括弧
				Pattern pattern1 = Pattern.compile("\\(.+\\)");
				Matcher matcher1 = pattern1.matcher(file.getName());
				boolean b1 = matcher1.find();
				// 1.判断名字中是否有第和波
				Pattern pattern2 = Pattern.compile("\\第");
				Matcher matcher2 = pattern2.matcher(file.getName());
				boolean b2 = matcher2.find();
				Pattern pattern3 = Pattern.compile("\\波");
				Matcher matcher3 = pattern3.matcher(file.getName());
				boolean b3 = matcher3.find();
				if (b1 && !b2 && !b3) {
					System.err.println("没有汉字有括弧--------------------------------------------->");
					updateFileNameByZhengZe(rootPath);
				} else if (!b1 && !b2 && !b3) {
					System.err.println("正常状态--------------------------------------------->");
					updateFileParentName(rootPath);
				} else {
					System.err.println("需要去掉汉字及括弧--------------------------------------------->");
					updateFileNameByHanZi(rootPath);
				}

			} else if (lastName.equals(".xlsx") || lastName.equals(".xls")) {
				System.err.println("这是个表格------->");
				boolean s = file.delete();
				if (s) {
					System.err.println("表格删除成功");
				} else {
					System.err.println("表格删除失败");
				}
			}
			try {
				// 方法睡眠时间
				Thread.currentThread().sleep(100);// 毫秒
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 得到文件名称
	 * 
	 * @param rootPath
	 */
	public void getFileName(String rootPath) {
		File file = new File(rootPath);
		if (file.isDirectory()) {
			File next[] = file.listFiles();
			for (int i = 0; i < next.length; i++) {
				getFileName(next[i].getPath());
			}
		} else {
			num++;
			// 得到文件前面的名称
			String firstName = file.getName().substring(0, file.getName().length() - 4);
			ProductInfo productInfo = new ProductInfo();
			productInfo.setWave(firstName);
			productInfo.setProcessImg("prodessImg\\" + file.getName());
			process.add(productInfo);
			try {
				// 方法睡眠时间
				Thread.currentThread().sleep(0);// 毫秒
			} catch (Exception e) {
			}
		}
	}
}
