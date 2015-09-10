package com.pfa.app.test;

import java.security.MessageDigest;

import org.junit.Test;
/**
 * 
 * @author hicham-pc
 *
 */
public class Md5ToString {

	@Test
	public void test() throws Exception {
		String password = "123456";

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		System.out.println("Digest(in hex format):: " + sb.toString());
		System.out.println(sb.toString().length());

	}

}
