package com.warehouse.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.http.HTTPException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @Description 手机短信验证码工具类
 * @package com.milan.utils
 * @author fanpengju
 * @Date 2016年10月2日 下午8:50:13
 */
public class SmsCheckCodeUtils {
	private static String phone;
	private static String Key;
	private static String Uid;
	private static String smsMob;
	private static String smsText;

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		SmsCheckCodeUtils.phone = phone;
	}

	public static String getKey() {
		return Key;
	}

	public static void setKey(String key) {
		Key = key;
	}

	public static String getUid() {
		return Uid;
	}

	public static void setUid(String uid) {
		Uid = uid;
	}

	public static String getSmsMob() {
		return smsMob;
	}

	public static void setSmsMob(String smsMob) {
		SmsCheckCodeUtils.smsMob = smsMob;
	}

	public static String getSmsText() {
		return smsText;
	}

	public static void setSmsText(String smsText) {
		SmsCheckCodeUtils.smsText = smsText;
	}

	/**
	 * 需要传入 1.用户手机号 2.用户需要输入的随机数 3.生成的验证码 返回的是用户手机收到的 短信验证码 字符串型
	 * 这里是用的网建的短信接口需要配置 用户名 接口密钥 短信内容
	 * 
	 * @param phone
	 * @param checkcode
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String smsCheckCode(String phone) throws HTTPException, IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		// 调用随机数工具类
		NumberUtils numberUtils = new NumberUtils();
		int i = numberUtils.outNumber();
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "GoldFu"),
				new NameValuePair("Key", "D632AC3034B350A2CACF631459946177"), new NameValuePair("smsMob", phone),
				new NameValuePair("smsText", "波段号：W789  供应商：李红梅   领料时间：12/22下午或者上午：" + i) };
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
		System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*短信商返回的状态码是：" + result); // 打印返回消息状态
		post.releaseConnection();
		// 判断状态码
		if (result.equals("1")) {
			String s = String.valueOf(i);
			// System.out.println("手机验证码是："+s);
			return s;
		} else {
			String s = "gunforcheckcode";
			// System.out.println("验证码发送失败:"+s);
			return s;
		}
	}

	public static Map<String, Object> smsRemind(String phone, String wave, String expectedReceiveMaterialDate,
			String factoryPicking) throws HTTPException, IOException {
		// map保存数据
		Map<String, Object> map = new HashMap<String, Object>();
		// 客户端编程工具包，并且它支持 HTTP 协议最新的版本和建议
		HttpClient client = new HttpClient();
		// post请求
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		// 设置格式化
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		// 调用接口
		NameValuePair[] data = { new NameValuePair("Uid", "GoldFu"),
				new NameValuePair("Key", "D632AC3034B350A2CACF631459946177"), new NameValuePair("smsMob", phone),
				new NameValuePair("smsText",
						"温馨提示:波段号:" + wave + "  供应商:" + factoryPicking + " 预计领料时间:" + expectedReceiveMaterialDate) };
		// 送一个xml字符串或流文件
		post.setRequestBody(data);
		// httpClient的executeMethod方法来执行getMethod。由于是执行在网络上的程序，在运行executeMethod方法的时候，需要处理两个异常，分别是HttpException和IOException
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		// 发送状态是否成功
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
		post.releaseConnection();
		map.put("smsText", smsText);
		map.put("phone", phone);
		map.put("result", result);
		return map;
	}

	/**
	 * 测试短信验证码功能
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SmsCheckCodeUtils smsCheckCodeUtils = new SmsCheckCodeUtils();
		String phone = "17685231015";
		try {
			smsCheckCodeUtils.smsCheckCode(phone);
		} catch (HTTPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
