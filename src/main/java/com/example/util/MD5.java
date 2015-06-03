package com.example.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5消息摘要算法
 * 
 * @author sdyang
 * @date 2014-11-1 下午2:22:30
 */
public class MD5 {
	/**
	 * 散列值为128位
	 * 
	 * @param rawData
	 * @return
	 * @author sdyang
	 * @date 2015年4月26日 下午11:23:05
	 */
	public static String sign(String rawData) {
		return DigestUtils.md5Hex(rawData).toLowerCase();

	}
	
	/**
	 * MD5校验
	 * @author sdyang
	 * @date 2015年6月3日 下午5:37:29
	 * @param rawData
	 * @param sign
	 * @return
	 */
	public Boolean validate(String rawData, String sign) {
		Boolean result = false;
		String mysign = DigestUtils.md5Hex(rawData).toLowerCase();
		if (mysign.equals(sign.toLowerCase())) {
			result = true;
		}
		return result;
	}
}
