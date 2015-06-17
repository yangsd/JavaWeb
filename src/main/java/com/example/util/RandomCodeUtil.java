package com.example.util;

import java.util.Random;

/**
 * 
 * @author sdyang
 * @date 2015年6月15日 下午5:30:49
 */
public class RandomCodeUtil {

	// 生成随机数时的数据源
	private static char[] codeSequence = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 't', 'u', 'v', 'w',
			'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static String genNumPassword(int length) {
		// 创建一个随机数生成器类
		Random random = new Random();
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		for (int i = 0; i < length; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(32)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}
}
