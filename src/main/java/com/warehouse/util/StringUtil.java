package com.warehouse.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.collect.Lists;

/**
 * 功能描述：关于字符串的一些实用操作
 *
 * @author Administrator
 * @version 1.0
 * @Date Jul 18, 2008
 * @Time 2:19:47 PM
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {
	/**
	 * 功能描述：分割字符串
	 *
	 * @param str
	 *            String 原始字符串
	 * @param splitsign
	 *            String 分隔符
	 * @return String[] 分割后的字符串数组
	 */
	@SuppressWarnings("unchecked")
	public static String[] split(String str, String splitsign) {
		int index;
		if (str == null || splitsign == null) {
			return null;
		}
		ArrayList al = new ArrayList();
		while ((index = str.indexOf(splitsign)) != -1) {
			al.add(str.substring(0, index));
			str = str.substring(index + splitsign.length());
		}
		al.add(str);
		return (String[]) al.toArray(new String[0]);
	}

	/**
	 * 功能描述：替换字符串
	 *
	 * @param from
	 *            String 原始字符串
	 * @param to
	 *            String 目标字符串
	 * @param source
	 *            String 母字符串
	 * @return String 替换后的字符串
	 */
	public static String replace(String from, String to, String source) {
		if (source == null || from == null || to == null)
			return null;
		StringBuffer str = new StringBuffer("");
		int index = -1;
		while ((index = source.indexOf(from)) != -1) {
			str.append(source.substring(0, index) + to);
			source = source.substring(index + from.length());
			index = source.indexOf(from);
		}
		str.append(source);
		return str.toString();
	}

	/**
	 * 替换字符串，能能够在HTML页面上直接显示(替换双引号和小于号)
	 *
	 * @param str
	 *            String 原始字符串
	 * @return String 替换后的字符串
	 */
	public static String htmlencode(String str) {
		if (str == null) {
			return null;
		}
		return replace("\"", "&quot;", replace("<", "&lt;", str));
	}

	/**
	 * 替换字符串，将被编码的转换成原始码（替换成双引号和小于号）
	 *
	 * @param str
	 *            String
	 * @return String
	 */
	public static String htmldecode(String str) {
		if (str == null) {
			return null;
		}

		return replace("&quot;", "\"", replace("&lt;", "<", str));
	}

	private static final String _BR = "<br/>";

	/**
	 * 功能描述：在页面上直接显示文本内容，替换小于号，空格，回车，TAB
	 *
	 * @param str
	 *            String 原始字符串
	 * @return String 替换后的字符串
	 */
	public static String htmlshow(String str) {
		if (str == null) {
			return null;
		}

		str = replace("<", "&lt;", str);
		str = replace(" ", "&nbsp;", str);
		str = replace("\r\n", _BR, str);
		str = replace("\n", _BR, str);
		str = replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;", str);
		return str;
	}

	/**
	 * 功能描述：返回指定字节长度的字符串
	 *
	 * @param str
	 *            String 字符串
	 * @param length
	 *            int 指定长度
	 * @return String 返回的字符串
	 */
	public static String toLength(String str, int length) {
		if (str == null) {
			return null;
		}
		if (length <= 0) {
			return "";
		}
		try {
			if (str.getBytes("GBK").length <= length) {
				return str;
			}
		} catch (Exception e) {
		}
		StringBuffer buff = new StringBuffer();

		int index = 0;
		char c;
		length -= 3;
		while (length > 0) {
			c = str.charAt(index);
			if (c < 128) {
				length--;
			} else {
				length--;
				length--;
			}
			buff.append(c);
			index++;
		}
		buff.append("...");
		return buff.toString();
	}

	/**
	 * 功能描述：判断是否为整数
	 *
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true, 否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 *
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true, 否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是不是合法字符 c 要判断的字符
	 */
	public static boolean isLetter(String str) {
		if (str == null || str.length() < 0) {
			return false;
		}
		Pattern pattern = Pattern.compile("[\\w\\.-_]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 从指定的字符串中提取Email content 指定的字符串
	 *
	 * @param content
	 * @return
	 */
	public static String parse(String content) {
		String email = null;
		if (content == null || content.length() < 1) {
			return email;
		}
		// 找出含有@
		int beginPos;
		int i;
		String token = "@";
		String preHalf = "";
		String sufHalf = "";

		beginPos = content.indexOf(token);
		if (beginPos > -1) {
			// 前项扫描
			String s = null;
			i = beginPos;
			while (i > 0) {
				s = content.substring(i - 1, i);
				if (isLetter(s))
					preHalf = s + preHalf;
				else
					break;
				i--;
			}
			// 后项扫描
			i = beginPos + 1;
			while (i < content.length()) {
				s = content.substring(i, i + 1);
				if (isLetter(s))
					sufHalf = sufHalf + s;
				else
					break;
				i++;
			}
			// 判断合法性
			email = preHalf + "@" + sufHalf;
			if (isEmail(email)) {
				return email;
			}
		}
		return null;
	}

	/**
	 * 功能描述：判断输入的字符串是否符合Email样式.
	 * <p/>
	 * 传入的字符串
	 *
	 * @return 是Email样式返回true, 否则返回false
	 */
	public static boolean isEmail(String email) {
		if (email == null || email.length() < 1 || email.length() > 256) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(email).matches();
	}

	/**
	 * 功能描述：判断输入的字符串是否为纯汉字
	 *
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true, 否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 功能描述：是否为空白,包括null和""
	 *
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 功能描述：判断是否为质数
	 *
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 7) {
			if (x == 2 || x == 3 || x == 5 || x == 7)
				return true;
		}
		int c = 7;
		if (x % 2 == 0)
			return false;
		if (x % 3 == 0)
			return false;
		if (x % 5 == 0)
			return false;
		int end = (int) Math.sqrt(x);
		while (c <= end) {
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 6;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 6;
		}
		return true;
	}

	/**
	 * 功能描述：人民币转成大写
	 *
	 * @param str
	 *            数字字符串
	 * @return String 人民币转换成大写后的字符串
	 */
	public static String hangeToBig(String str) {
		double value;
		try {
			value = Double.parseDouble(str.trim());
		} catch (Exception e) {
			return null;
		}
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		long midVal = (long) (value * 100); // 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串

		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; // 连续0次数递增
				if (zero == '0') { // 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0; // 连续0次数清零
			if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0']; // 转化该数字表示
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
			}
		}

		if (prefix.length() > 0)
			prefix += '圆'; // 如果整数部分存在,则有圆的字样
		return prefix + suffix; // 返回正确表示
	}

	/**
	 * 功能描述：去掉字符串中重复的子字符串
	 *
	 * @param str
	 *            原字符串，如果有子字符串则用空格隔开以表示子字符串
	 * @return String 返回去掉重复子字符串后的字符串
	 */
	@SuppressWarnings("unused")
	private static String removeSameString(String str) {
		Set<String> mLinkedSet = new LinkedHashSet<String>();// set集合的特征：其子集不可以重复
		String[] strArray = str.split(" ");// 根据空格(正则表达式)分割字符串
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < strArray.length; i++) {
			if (!mLinkedSet.contains(strArray[i])) {
				mLinkedSet.add(strArray[i]);
				sb.append(strArray[i] + " ");
			}
		}
		System.out.println(mLinkedSet);
		return sb.toString();
	}

	/**
	 * 功能描述：过滤特殊字符
	 *
	 * @param src
	 * @return
	 */
	public static String encoding(String src) {
		if (src == null)
			return "";
		StringBuilder result = new StringBuilder();
		if (src != null) {
			src = src.trim();
			for (int pos = 0; pos < src.length(); pos++) {
				switch (src.charAt(pos)) {
				case '\"':
					result.append("&quot;");
					break;
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				case '\'':
					result.append("&apos;");
					break;
				case '&':
					result.append("&amp;");
					break;
				case '%':
					result.append("&pc;");
					break;
				case '_':
					result.append("&ul;");
					break;
				case '#':
					result.append("&shap;");
					break;
				case '?':
					result.append("&ques;");
					break;
				default:
					result.append(src.charAt(pos));
					break;
				}
			}
		}
		return result.toString();
	}

	/**
	 * 功能描述：判断是不是合法的手机号码
	 *
	 * @param handset
	 * @return boolean
	 */
	public static boolean isHandset(String handset) {
		try {
			String regex = "^1[\\d]{10}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(handset);
			return matcher.matches();

		} catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * 功能描述：反过滤特殊字符
	 *
	 * @param src
	 * @return
	 */
	public static String decoding(String src) {
		if (src == null)
			return "";
		String result = src;
		result = result.replace("&quot;", "\"").replace("&apos;", "\'");
		result = result.replace("&lt;", "<").replace("&gt;", ">");
		result = result.replace("&amp;", "&");
		result = result.replace("&pc;", "%").replace("&ul", "_");
		result = result.replace("&shap;", "#").replace("&ques", "?");
		return result;
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 字符处理：去除空格和全角转半角
	 *
	 * @param input
	 *            输入字符串
	 * @return 字符串
	 */
	public static String strHandle(String input) {
		if (isBlank(input)) {
			return "";
		}
		// String value = input.replaceAll("\\s*", "");
		String value = input.replaceAll("　| ", "");
		value = ToDBC(value);
		return value;
	}

	/**
	 * 全角转半角
	 *
	 * @param input
	 *            String.
	 * @return 半角字符串
	 */
	public static String ToDBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);

			}
		}
		return new String(c);
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为BigDecimal类型
	 */
	public static BigDecimal toBigDecimal(Object val) {
		BigDecimal bd = new BigDecimal(0);
		if (null != val) {
			try {
				if (val instanceof String) {
					String sval = (String) val;
					sval = ((String) val).replaceAll(" ", "");
					bd = new BigDecimal(sval);
				}
				if (val instanceof Double) {
					Double dval = (Double) val;
					bd = new BigDecimal(dval);
				}
				if (val instanceof Float) {
					Float dval = (Float) val;
					bd = new BigDecimal(dval);
				}
				if (val instanceof Integer) {
					Integer dval = (Integer) val;
					bd = new BigDecimal(dval);
				}
				if (val instanceof Long) {
					Long dval = (Long) val;
					bd = new BigDecimal(dval);
				}
				if (val instanceof Short) {
					Short dval = (Short) val;
					bd = new BigDecimal(dval);
				}
				if (val instanceof Byte) {
					Byte dval = (Byte) val;
					bd = new BigDecimal(dval);
				}
			} catch (Exception e) {
				return bd;
			}
		}
		return bd;
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 获取当前请求对象
	 *
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		try {
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 以逗号隔开的String字符 转换为list
	 *
	 * @param string
	 *            字符名称
	 * @return list<String>
	 */
	public static List<String> stringConvertList(String string) {
		List<String> list = Lists.newArrayList();
		if (StringUtil.isNotBlank(string)) {
			String[] str = string.split(",");
			for (int i = 0; i < str.length; i++) {
				list.add(str[i].trim());
			}
		}
		return list;
	}

	/**
	 * 以逗号隔开的String字符 添加引号 123,456,789 变成 '123','456','789'
	 *
	 * @param
	 * @return
	 */
	public static String stringAddComma(List<String> lstString) {
		if (lstString != null && lstString.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0, iSize = lstString.size(); i < iSize; i++) {
				String id = lstString.get(i);
				if (i == (iSize - 1)) {
					sb.append("'").append(id).append("'");
					break;
				}
				sb.append("'").append(id).append("',");
			}
			return sb.toString();
		} else {
			return null;
		}
	}

	/**
	 * 替换所有的标点符号
	 *
	 * @return
	 */
	public static String replaceP(String text, String replacement) {
		if (StringUtil.isNotBlank(text) && replacement != null) {
			return text.replaceAll("\\pP", replacement);
		}
		return text;
	}

	/**
	 * 替换所有的空白
	 *
	 * @return
	 */
	public static String replaceZ(String text, String replacement) {
		if (StringUtil.isNotBlank(text) && replacement != null) {
			return text.replaceAll("\\pZ", replacement);
		}
		return text;
	}

	/**
	 * 替换所有的空白
	 *
	 * @return
	 */
	public static String replaceAllSpace(String text) {
		if (StringUtil.isNotBlank(text)) {
			return text.replaceAll("\\s", "");
		}
		return text;
	}

	/**
	 * 去掉BOM字符
	 *
	 * @return
	 */
	public static String removeBom(String text) {
		if (StringUtil.isNotBlank(text)) {
			return StringUtil.trim(StringUtil.replaceChars(text, (char) 65279, ' '));
		}
		return text;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 *
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : str.toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 缩略字符串（不区分中英文字符） --- 先去掉html的格式
	 *
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbrHtml(String str, int length) {
		String html = str;
		if (StringUtil.isNotBlank(html)) {
			html = StringUtil.replaceHtml(html);
			html = StringUtil.remove(html, "&nbsp;");
			html = StringUtil.replaceAllSpace(html);
		}
		return abbr(html, length);
	}

	/**
	 * StringBuffer .. append
	 */
	public static StringBuilder appendTo(Object... parts) {
		return appendTo(new StringBuilder(), Arrays.asList(parts));
	}

	/**
	 * StringBuffer .. append
	 */
	public static StringBuilder appendTo(StringBuilder appendable, Iterable<?> parts) {
		return appendTo(appendable, parts.iterator());
	}

	/**
	 * StringBuffer .. append
	 */
	public static StringBuilder appendTo(StringBuilder appendable, Object... parts) {
		return appendTo(appendable, Arrays.asList(parts));
	}

	/**
	 * StringBuffer .. append
	 */
	public static StringBuilder appendTo(StringBuilder appendable, String first, String second, Object... rest) {
		return appendTo(appendable, iterable(first, second, rest));
	}

	/**
	 * StringBuffer .. append
	 */
	public static StringBuilder appendTo(StringBuilder appendable, Iterator<?> parts) {
		if (parts.hasNext()) {
			appendable.append(toString(parts.next()));
			while (parts.hasNext()) {
				appendable.append(toString(parts.next()));
			}
		}
		return appendable;
	}

	public static CharSequence toString(Object part) {
		return (part instanceof CharSequence) ? (CharSequence) part : part.toString();
	}

	private static Iterable<Object> iterable(final Object first, final Object second, final Object[] rest) {
		return new AbstractList<Object>() {
			@Override
			public int size() {
				return rest.length + 2;
			}

			@Override
			public Object get(int index) {
				switch (index) {
				case 0:
					return first;
				case 1:
					return second;
				default:
					return rest[index - 2];
				}
			}
		};
	}

	/**
	 * 信息格式化
	 *
	 * @param template
	 * @param args
	 * @return
	 */
	public static String format(String template, Object... args) {
		template = String.valueOf(template); // null -> "null"
		StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
		int templateStart = 0;
		int i = 0;
		while (i < args.length) {
			int placeholderStart = template.indexOf("%s", templateStart);
			if (placeholderStart == -1) {
				break;
			}
			builder.append(template.substring(templateStart, placeholderStart));
			builder.append(args[i++]);
			templateStart = placeholderStart + 2;
		}
		builder.append(template.substring(templateStart));

		if (i < args.length) {
			builder.append(" [");
			builder.append(args[i++]);
			while (i < args.length) {
				builder.append(", ");
				builder.append(args[i++]);
			}
			builder.append(']');
		}
		return builder.toString();
	}

	/**
	 * 在固定位置插入指定字符
	 *
	 * @param postion
	 * @param insert
	 * @return
	 */
	public static String insert(String src, int postion, String insert) {
		if (StringUtil.isBlank(src) || StringUtil.isEmpty(insert) || postion < 0) {
			return src;
		}
		if (postion > StringUtil.length(src)) {
			postion = StringUtil.length(src);
		}
		return new StringBuilder(src).insert(postion, insert).toString();
	}

	/**
	 * 在每固定位置插入指定字符
	 *
	 * @param postion
	 * @param insert
	 * @return
	 */
	public static String insertEach(String src, int postion, String insert) {
		if (StringUtil.isBlank(src) || StringUtil.isEmpty(insert)) {
			return src;
		}
		if (postion > StringUtil.length(src)) {
			postion = StringUtil.length(src);
		}
		if (postion == 0) {
			return insert(src, postion, insert);
		}
		int each = StringUtil.length(src) / postion;
		StringBuffer sbSrc = new StringBuffer(src);
		for (int i = 1, j = each; i <= j; i++) {
			sbSrc.insert(i * postion + (i - 1), insert);
		}
		return sbSrc.toString();
	}

	// 字符串转义
	public static boolean containsKeyString(String str) {
		if (StringUtil.isBlank(str)) {
			return false;
		}
		if (str.contains("'") || str.contains("\"") || str.contains("\r") || str.contains("\n") || str.contains("\t")
				|| str.contains("\b") || str.contains("\f")) {
			return true;
		}
		return false;
	}

	// 将""和'转义
	public static String replaceKeyString(String str) {
		if (containsKeyString(str)) {
			return str.replace("'", "\\'").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n")
					.replace("\t", "\\t").replace("\b", "\\b").replace("\f", "\\f");
		} else {
			return str;
		}
	}

	// 单引号转化成双引号
	public static String replaceString(String str) {
		if (containsKeyString(str)) {
			return str.replace("'", "\"").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n")
					.replace("\t", "\\t").replace("\b", "\\b").replace("\f", "\\f");
		} else {
			return str;
		}
	}

	/**
	 * 首字母转小写
	 *
	 * @param s
	 * @return
	 */
	public static String lowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 首字母转大写
	 *
	 * @param s
	 * @return
	 */
	public static String upperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 约定大于配置： userName --> USER_NAME
	 *
	 * @param property
	 * @return
	 */
	public static String convertProperty2Column(String property) {
		StringBuilder column = new StringBuilder();
		for (int i = 0; i < property.length(); i++) {
			char c = property.charAt(i);
			if (Character.isUpperCase(c)) {
				column.append("_");
			}
			column.append(Character.toUpperCase(c));
		}
		return StringUtil.upperCase(column.toString());
	}

	/**
	 * 删除： utf-8 无法显示的字符(有问题)，直接将数据库的相关字段改为 NAME VARCHAR(100) CHARACTER SET
	 * UTF8MB4 COLLATE UTF8MB4_GENERAL_CI DEFAULT NULL COMMENT '昵称';
	 * 貌似不能解决所有问题，很多地方需要改，还不如把不能插入的字符过滤掉
	 *
	 * @param src
	 * @param replace
	 * @return
	 */
	public static String mb4Replace(String src, String replace) {
		replace = replace == null ? "" : replace;
		if (StringUtil.isNotBlank(src)) {
			return src.replaceAll("[\\x{10000}-\\x{10FFFF}]", replace);
		}
		return src;
	}

	/**
	 * 转义数据库的特殊字符 --- 数据库的转义
	 *
	 * @param value
	 * @return
	 */
	public static Object escapeDb(String value) {
		if (value != null && value instanceof String && StringUtil.containsAny((String) value, '\\', '\'')) {
			return StringUtil.replaceEach(value, new String[] { "\\", "\'" }, new String[] { "\\\\\\\\", "\\'" });
		}
		return value;
	}

}
