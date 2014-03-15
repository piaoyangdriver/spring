package com.test.md5;

import java.security.MessageDigest;

public class Test_MD5 {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			// ʹ��MD5����MessageDigest����
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// System.out.println((int)b);
				// ��ÿ����(int)b����˫�ֽڼ���
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	// ����
	public static void main(String[] args) {
		System.out.println("caidao��MD5���ܺ�\n" + Test_MD5.MD5("caidao"));
		System.out.println("http://www.baidu.com/��MD5���ܺ�\n"
				+ Test_MD5.MD5("http://www.baidu.com/"));
	}
}