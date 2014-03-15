package com.test.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;

public class Md5Test extends TestCase {
	
	char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f' };
	
	public void testMd5(){
		try {
			String input = "111";
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] digest = md.digest(input.getBytes("utf-8"));
			char[] str = new char[digest.length * 2];
			int k = 0;
			for(int i = 0; i < digest.length; i++){
				byte b = digest[i];
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			
			System.out.println(new String(str));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
