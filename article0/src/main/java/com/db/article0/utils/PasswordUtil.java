package com.db.article0.utils;

import java.security.MessageDigest;
import java.util.UUID;

public class PasswordUtil {

	// 十六进制下数字到字符的映射数�?
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/** */
	/** 把inputString加密 */
	public static String createPassword(String inputString) {
		return encodeByMD5(inputString);
	}

	/** */
	/**
	 * 验证输入的密码是否正�?
	 * 
	 * @param password
	 *            真正的密码（加密后的真密码）
	 * @param inputString
	 *            输入的字符串
	 * @return 验证结果，boolean类型
	 */
	public static boolean authenticatePassword(String password, String inputString) {
		if (password.equals(encodeByMD5(inputString))) {
			return true;
		} else {
			return false;
		}
	}

	/** */
	/** 对字符串进行MD5加密 */
	private static String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				// 创建具有指定算法名称的信息摘�?
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 使用指定的字节数组对摘要进行�?后更新，然后完成摘要计算
				byte[] results = md.digest(originString.getBytes());
				// 将得到的字节数组变成字符串返�?
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/** */
	/**
	 * 转换字节数组为十六进制字符串
	 * 
	 * @param b
	 *            字节数组
	 * @return 十六进制字符�?
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/** */
	/** 将一个字节转化成十六进制形式的字符串 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void mainxxx(String[] args) {
		//96E79218965EB72C92A549DD5A330112
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		String password = PasswordUtil.createPassword("11111111");
		System.out.println("对admin1用MD5摘要后的字符串：" + password);
		String inputString = "g8uy6h9psx";
		System.out.println("8888与密码匹配？" + PasswordUtil.authenticatePassword(password, inputString));
		inputString = "888888";
		System.out.println("888888与密码匹配？" + PasswordUtil.authenticatePassword(password, inputString));
	}

}
