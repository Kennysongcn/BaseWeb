package com.kenny.app.web.system.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 字符串 工具类
 * @author kennysong
 *
 */
public class StringUtil {
	public static Integer toInteger(String i) {
		Integer integer = null;
		try {
			integer = new Integer(i);
		} catch (Exception e) {

		}
		return integer;
	}

	public static BigDecimal toBigDecimal(String b) {
		BigDecimal bigDecimal = null;
		try {
			bigDecimal = new BigDecimal(b);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return bigDecimal;
	}

	public static Boolean toBoolean(String str) {
		Boolean bool = null;
		try {
			bool = new Boolean(str);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return bool;
	}

	public static String filterNull(String s) {

		if (s == null || s.trim().length() == 0) {
			s = null;
		}

		return s;
	}

	/**
	 * 如果字符串为null,则返回空字符串""
	 * */
	public static String null2Empty(String s) {
		if (s == null) {
			return "";
		} else {
			return s;
		}
	}

	/**
	 * 如果字符串为null,则返回默认字符串defaultValue
	 * */
	public static String null2Empty(String s, String defaultValue) {
		if (s == null) {
			return defaultValue;
		} else {
			return s;
		}
	}

	public static String integerToString(Integer i) {
		if (i == null) {
			return "";
		}
		return i.toString();
	}

	public static String doubleToString(BigDecimal i) {
		if (i == null) {
			return "";
		}

		return i.toString();
	}

	public static String bigDecimalToString(BigDecimal i) {
		if (i == null) {
			return "";
		}

		return i.toString();
	}

	public static String bigDecimalToMoney(BigDecimal i) {
		if (i == null) {
			return "0.00";
		}

		DecimalFormat df2 = new DecimalFormat("##0.00");
		return df2.format(i);
	}

	public static String empty2null(String str) {
		if (str != null && str.trim().length() == 0) {
			return null;
		}
		return str;
	}

	public static void main(String args[]) {
		System.out.println(StringUtil.bigDecimalToMoney(new BigDecimal("2")));
	}

	// double转换不精确
	public static String changeToBig(double value) {
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
		}
		// 对于以角结尾的整理加上整如 1.50 为壹圆伍角整
		else if (rail.substring(1, 2).equals("0")) {
			suffix = digit[rail.charAt(0) - '0'] + "角" + "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}

		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			/*
			 * System.out.println("idx:" + idx + "|vidx:" + vidx + "|i:" + i +
			 * "|chDig[i]:" + chDig[i]);
			 */
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; // 连续0次数递增
				if (zero == '0') { // 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				if (idx == 0 && vidx > 0) {
					prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
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

	public static String changeToBig(BigDecimal value) {
		if (value.equals(BigDecimal.ZERO)) {
			return "零圆整";
		}
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		long midVal = value.multiply(new BigDecimal(100)).longValue(); // 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串
		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果

		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		}
		// 对于以角结尾的整理加上整如 1.50 为壹圆伍角整
		else if (rail.substring(1, 2).equals("0")) {
			suffix = digit[rail.charAt(0) - '0'] + "角" + "整";
		}

		else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}

		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			/*
			 * System.out.println("idx:" + idx + "|vidx:" + vidx + "|i:" + i +
			 * "|chDig[i]:" + chDig[i]);
			 */
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; // 连续0次数递增
				if (zero == '0') { // 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				if (idx == 0 && vidx > 0) {
					prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
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

	public static String generateCode(int length, int type) {
		StringBuffer vCode = new StringBuffer();

		char[] codeSequence = new char[] {};

		switch (type) {
		case 0:// 纯数字
			codeSequence = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
					'8', '9' };
			break;
		case 1:// 纯小写字母
			codeSequence = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
					'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
					'u', 'v', 'w', 'x', 'y', 'z' };
			break;
		case 2:// 纯大写字母
			codeSequence = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
					'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y', 'Z' };
			break;
		case 3:// 数字和大写字母
			codeSequence = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
					'8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z' };
			break;
		case 4:// 数字和小写字母
			codeSequence = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
					'8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
					'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
					'w', 'x', 'y', 'z' };
			break;
		case 5:// 数字、大小写字母
		default:
			codeSequence = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
					'8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
					'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
					'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
					'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y', 'Z' };
			break;
		}

		Random random = new Random();

		for (int i = 0; i < length; i++) {
			String randomStr = String.valueOf(codeSequence[random
					.nextInt(codeSequence.length)]);
			vCode.append(randomStr);
		}

		return vCode.toString();
	}

	/**
	 * 判断字符串不为空
	 * 
	 * @author freddy
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		boolean isNotEmpty = false;
		if (null != str && !"".equals(str.trim())
				&& !"NULL".equalsIgnoreCase(str.trim())) {
			isNotEmpty = true;
		}
		return isNotEmpty;
	}

	/**
	 * 判断字符串为空
	 * 
	 * @author freddy
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}

	/**
	 * 判断字符串是否是整数
	 * 
	 * @author freddy
	 * @param number
	 * @return
	 */
	public static boolean isInteger(String number) {
		boolean isNumber = false;
		if (StringUtil.isNotEmpty(number)) {
			isNumber = number.matches("^([1-9]\\d*)|(0)$");
		}
		return isNumber;
	}

	/**
	 * 得到MD5
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

}
