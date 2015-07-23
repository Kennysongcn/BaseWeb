package com.kenny.app.provider.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author kennysong
 * 
 */
public class DateUtil {
	public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 格式化日期类型
	 * 
	 * @param d
	 * @return
	 */
	public static String formatDate(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		return simpleDateFormat.format(d);
	}

	/**
	 * 格式化日期时间
	 * 
	 * @param d
	 * @return
	 */
	public static String formatDateTime(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		return simpleDateFormat.format(d);
	}

	/**
	 * 格式化日期时间
	 * 
	 * @param d
	 * @return
	 */
	public static String formatDateTime(Date d, String parse) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parse);
		return simpleDateFormat.format(d);
	}

	/**
	 * 得到日期对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date getDate(String str) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		try {
			return simpleDateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 得到日期时间对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date getTime(String str) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		try {
			return simpleDateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * 得到日期时间对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date getTime(String str, String parse) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parse);
		try {
			return simpleDateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * 根据格式化信息得到日期对象
	 * 
	 * @param str
	 * @param parse
	 * @return
	 */
	public static Date getDate(String str, String parse) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parse);
		try {
			return simpleDateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public static String second2HHmmss(int second) {
		int h = 0;
		int d = 0;
		int s = 0;
		int temp = second % 3600;
		if (second > 3600) {
			h = second / 3600;
			if (temp != 0) {
				if (temp > 60) {
					d = temp / 60;
					if (temp % 60 != 0) {
						s = temp % 60;
					}
				} else {
					s = temp;
				}
			}
		} else {
			d = second / 60;
			if (second % 60 != 0) {
				s = second % 60;
			}
		}

		return h + "时" + d + "分" + s + "秒";
	}
	
}
