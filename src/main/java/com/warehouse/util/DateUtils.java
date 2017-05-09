package com.warehouse.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 说明:日期工具类
 * 
 * @version 1.0
 */
public class DateUtils {

	/**
	 * @param yyyy-MM-dd
	 * @return
	 */
	public static final String patternA = "yyyy-MM-dd";
	/**
	 * @param yyyyMMdd
	 * @return
	 */
	public static final String patternB = "yyyyMMdd";
	/**
	 * @param yyyy-MM-dd
	 *            HH-mm-ss
	 * @return
	 */
	public static final String patternC = "yyyy-MM-dd HH-mm-ss";
	/**
	 * @param yyyy:MM:dd
	 *            HH:mm:ss
	 * @return
	 */
	public static final String patternD = "yyyy-MM-dd HH:mm:ss";
	/**
	 * @param yyyy-MM-dd
	 *            HH:mm:ss
	 * @return
	 */
	public static final String patternE = "yyyy-MM-dd HH:mm";

	/**
	 * @param yyyyMMddHHmmss
	 * @return
	 */
	public static final String patternF = "yyyyMMddHHmmss";

	public static final String patternG = "yyyy年MM月dd日";

	/**
	 * @param yyyy-MM
	 * @return
	 */
	public static final String patternH = "yyyy-MM";

	public static final String patternI = "yyyyMM";
	public static final String patternM = "yyyyMMddHHmmssSSS";

	/**
	 * 格式化日期为yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formateDate(Date date) {
		return dateToString(date, patternA);
	}

	/**
	 * 格式化日期为yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formateDaTime(Date date) {
		return dateToString(date, patternD);
	}

	/**
	 * 格式化日期为yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String formateDaHHmm(Date date) {
		return dateToString(date, patternE);
	}
	public static String formateDaTime1(Date date) {
		return dateToString(date, patternC);
	}

	/**
	 * 格式化日期为yyyy-MM
	 * 
	 * @param date
	 * @return
	 */
	public static String formateYearAndMonth(Date date) {
		return dateToString(date, patternH);
	}

	/**
	 * 格式化日期为yyyyMMddHHmmssSSS
	 * 
	 * @param date
	 * @return
	 */
	public static String formateYearAndMonthAndSecond(Date date) {
		return dateToString(date, patternM);
	}

	/**
	 * @param 取当天日期
	 * @return
	 */
	public static Date getDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 获取当前系统前一天日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * @param 取指定年月日的日期,格式为yyyy-MM-dd,HH-mm-ss
	 *            00-00-00
	 * @return
	 */
	public static Date getDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day, 0, 0, 0);
		return cal.getTime();

	}

	/**
	 * @param 取指定年,月,日,小时,分,秒的时间
	 * @return
	 */
	public static Date getDate(int year, int month, int date, int hour, int mintue, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, date);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, mintue);
		cal.set(Calendar.SECOND, second);
		return cal.getTime();
	}

	/**
	 * @param days=n
	 *            n为-,则取n天前,n为+,则取n天后的日期
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getSomeDaysBeforeAfter(Date date, int days) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(5, days);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		return gc.getTime();
	}

	/**
	 * @param 取指定日期年份
	 * @return
	 */
	public static int getDateYear(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * @param 取指定日期月份
	 * @return
	 */
	public static int getDateMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * @param 取指定日期日份
	 * @return
	 */
	public static int getDateDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);
	}

	/**
	 * @param 取指定日期小时
	 * @return
	 */
	public static int getDateHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * @param 取指定日期分钟
	 * @return
	 */
	public static int getDateMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 功能描述：取得指定月份的第一天
	 *
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		return strdate;
		/*
		 * date = parseDate(strdate); return format(date, "yyyy-MM") + "-01";
		 */
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 *
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		return strdate;
		/*
		 * date = parseDate(getMonthBegin(strdate)); calendar =
		 * Calendar.getInstance(); calendar.setTime(date);
		 * calendar.add(Calendar.MONTH, 1); calendar.add(Calendar.DAY_OF_YEAR,
		 * -1); return formatDate(calendar.getTime());
		 */
	}

	/**
	 * 某一个月第一天和最后一天
	 * 
	 * @param date
	 * @return
	 */
	private static Map<String, String> getFirstday_Lastday_Month(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();

		// 上个月第一天
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
		day_first = str.toString();

		// 上个月最后一天
		calendar.add(Calendar.MONTH, 1); // 加一个月
		calendar.set(Calendar.DATE, 1); // 设置为该月第一天
		calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
		String day_last = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
		day_last = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("first", day_first);
		map.put("last", day_last);
		return map;
	}

	/**
	 * 当月第一天
	 * 
	 * @return
	 */
	private static String getFirstDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
		return str.toString();

	}

	/**
	 * 当月最后一天
	 * 
	 * @return
	 */
	private static String getLastDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();
		String s = df.format(theDate);
		StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
		return str.toString();

	}

	/**
	 * @param 取指定日期的第二天的开始时间,小时,分,秒为00:00:00
	 * @return
	 */
	public static Date getNextDayStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return getNextDayStart(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
	}

	/**
	 * @param 取指定年,月,日的下一日的开始时间,小时,分,秒为00:00:00
	 * @param 主要是用来取跨月份的日期
	 * @return
	 */
	public static Date getNextDayStart(int year, int monthIn, int date) {
		int month = monthIn - 1;
		boolean lastDayOfMonth = false;
		boolean lastDayOfYear = false;

		Calendar time = Calendar.getInstance();
		time.set(year, month, date, 0, 0, 0);
		Calendar nextMonthFirstDay = Calendar.getInstance();
		nextMonthFirstDay.set(year, month + 1, 1, 0, 0, 0);

		if (time.get(Calendar.DAY_OF_YEAR) + 1 == nextMonthFirstDay.get(Calendar.DAY_OF_YEAR))
			lastDayOfMonth = true;

		if (time.get(Calendar.DAY_OF_YEAR) == time.getMaximum(Calendar.DATE))
			lastDayOfYear = true;

		time.roll(Calendar.DATE, 1);

		if (lastDayOfMonth)
			time.roll(Calendar.MONTH, 1);

		if (lastDayOfYear)
			time.roll(Calendar.YEAR, 1);

		return time.getTime();
	}

	/**
	 * @param 取指定日期的下一日的时间
	 * @return
	 */
	public static Date nextDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * @param 指定日期的下一日的开始时间,小时,分,秒为00:00:00
	 * @return
	 */
	public static Date getStartDateNext(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * @param 指定日期的开始时间,小时,分,秒为00:00:00
	 * @return
	 */
	public static Date getStartDateDay(Date date) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * @param 指定日期的结束时间,小时,分,秒为23:59:59
	 * @return
	 */
	public static Date getEndDateDay(Date date) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * @param 将指定日期,以指定pattern格式,输出String值
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.format(date);
		}
	}

	public static String dateToString1(Date date, String formatIn) {
		String format = formatIn;
		if (date == null) {
			return "";
		}
		if (format == null) {
			format = patternD;
		}
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * @param 将指定年,月,日的日期转为字符型,格式为yyyy-MM-dd
	 * @return
	 */
	public static String dateToString(int year, int month, int day, String pattern) {
		return dateToString(getDate(year, month, day), pattern);
	}

	/**
	 * @param 将指定字符型日期转为日期型,,格式为指定的pattern
	 * @return
	 */
	public static Date stringToDate(String string, String pattern) {
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance();
		format.applyPattern(pattern);
		try {
			return format.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @param 将指定字符型日期转为日期型,指定格式为yyyy-MM-dd
	 * @return
	 */
	public static Date stringToDate(String string) {
		return stringToDate(string, patternA);
	}

	/**
	 * 获得两个日期之间间隔的天数
	 * 
	 * @param startDate
	 *            起始年月日
	 * @param endDate
	 *            结束年月日
	 * @return int
	 */
	public static int getDays(Date startDate, Date endDate) {
		int elapsed = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		Date d1 = cal.getTime();

		cal.setTime(endDate);
		Date d2 = cal.getTime();

		long daterange = d2.getTime() - d1.getTime();
		long time = 1000 * 3600 * 24; // 一天的毫秒数
		elapsed = (int) (daterange / time);
		return elapsed;
	}

	/**
	 * @param date
	 * @param startTime
	 *            格式为0800，表示上午8点00分
	 * @param endTime格式为2200
	 * @return
	 */
	public static boolean isWorkHour(Date date, String startTimeIn, String endTimeIn) {// 是否是工作时间
		String startTime = startTimeIn;
		String endTime = endTimeIn;
		if (StringUtils.isEmpty(startTime))
			startTime = "0800";
		if (StringUtils.isEmpty(endTime))
			endTime = "2200";
		int start = Integer.parseInt(startTime);
		int end = Integer.parseInt(endTime);
		int hour = getDateHour(date);
		int m = getDateMinute(date);
		String hstr = hour <= 9 ? "0" + hour : hour + "";
		String mstr = m <= 9 ? "0" + m : m + "";
		int dateInt = Integer.parseInt(hstr + mstr);
		if (dateInt >= start && dateInt <= end) {
			return true;
		}
		return false;
	}

	/**
	 * @param 根据传入日期，返回此月有多少天
	 *            格式为 201408
	 * @param date
	 *            格式为 201408
	 * @return
	 */
	public static int getDayOfMonth(String date) {
		int year = Integer.parseInt(date.substring(0, 3));
		int month = Integer.parseInt(date.substring(date.length() - 1, date.length()));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);// Java月份才0开始算 6代表上一个月7月
		int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		return dateOfMonth;
	}

	/**
	 * @param 取指定日期月份前一月
	 * @return
	 */
	public static int getLastDateMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}

	// 取日期的当前月第一天
	public static Date getMonthFirstDay(Date date) {
		return getDate(getDateYear(date), getDateMonth(date), 1);
	}

	// 前月第一天
	public static Date getLastDateMonthDay(Date date) {
		return getDate(getDateYear(date), getLastDateMonth(date), 1);
	}

	public static void main(String[] args) {
		System.out.println("格式化日期为yyyy-MM-dd====" + formateDate(new Date()));
		System.err.println("格式化日期为yyyy-MM====" + formateYearAndMonth(new Date()));
		System.out.println("取当天日期====" + getDate());
		System.err.println(
				"取指定年月日的日期,格式为yyyy-MM-dd,HH-mm-ss 00-00-00 ====" + getDate(2016 - 11 - 24, 9 - 11 - 58, 00 - 00 - 00));
		System.out.println("取指定年,月,日,小时,分,秒的时间====" + getDate(2016, 11, 23, 16, 59, 23));
		System.err.println("days=n n为-,则取n天前,n为+,则取n天后的日期====" + getSomeDaysBeforeAfter(new Date(), 29));
		System.out.println("取指定日期年份====" + getDateYear(new Date()));
		System.err.println("取指定日期月份====" + getDateMonth(new Date()));
		System.out.println("取指定日期日====" + getDateDay(new Date()));
		System.err.println("取指定日期小时====" + getDateHour(new Date()));
		System.out.println("取指定日期分钟====" + getDateMinute(new Date()));
		System.err.println("取指定日期的第二天的开始时间,小时,分,秒为00:00:00====" + getNextDayStartTime(new Date()));
		System.out.println("取指定年,月,日的下一日的开始时间,小时,分,秒为00:00:00====" + getNextDayStart(2016, 10, 24));
		System.err.println("取指定日期的下一日的时间====" + nextDate(new Date()));
		System.out.println("指定日期的下一日的开始时间,小时,分,秒为00:00:00====" + getStartDateNext(new Date()));
		System.err.println("指定日期的开始时间,小时,分,秒为00:00:00====" + getStartDateDay(new Date()));
		System.out.println("指定日期的结束时间,小时,分,秒为23:59:59====" + getEndDateDay(new Date()));
		System.err.println("将指定日期,以指定pattern格式,输出String值====" + dateToString(new Date(), "yyyy-MM-dd"));
		System.out.println("添加====" + dateToString1(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.err.println("将指定日期,以指定pattern格式,输出String值====" + dateToString(new Date(), "yyyy-MM-dd"));
		System.out.println("将指定字符型日期转为日期型,,格式为指定的pattern====================================" + stringToDate("2016-3-15", "yyyy-MM-dd"));
		System.err.println("将指定字符型日期转为日期型,指定格式为yyyy-MM-dd=================" + stringToDate("2016-3-15"));
		System.out.println("startDate起始年月日 -结束年月日====" + getDays(new Date(), new Date()));
		System.err.println("格式为0800，表示上午8点00分====" + isWorkHour(new Date(), "09", "00"));
		System.out.println("根据传入日期，返回此月有多少天   格式为 201408====" + getDayOfMonth("201611"));
		System.err.println("取指定日期月份前一月====" + getLastDateMonth(new Date()));
		System.out.println("取日期的当前月第一天====" + getMonthFirstDay(new Date()));
		System.err.println("前月第一天====" + getLastDateMonthDay(new Date()));

		System.err.println("2016年11月24日09:36:30====" + formateDaTime(new Date()));

		System.err.println("====" + formateYearAndMonthAndSecond(new Date()));

	}

}
