package com.xll.dt.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {

	// 自定义
	public static String md5(String source, Object salt, int hashIterations) {
		//使用MD5加密 (加盐)
		SimpleHash simpleHash = new Md5Hash(source, salt, hashIterations);
		String md5 = simpleHash.toString();
		return md5;
	}

	// 散列次数为1024的加密
	public static String md5(String source, Object salt) {
		return md5(source, salt, 1024);
	}

}
