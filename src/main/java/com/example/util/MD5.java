package com.example.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5��ϢժҪ�㷨
 * 
 * @author sdyang
 * @date 2014-11-1 ����2:22:30
 */
public class MD5 {
	/**
	 * ɢ��ֵΪ128λ
	 * 
	 * @param rawData
	 * @return
	 * @author sdyang
	 * @date 2015��4��26�� ����11:23:05
	 */
	public static String sign(String rawData) {
		return DigestUtils.md5Hex(rawData).toLowerCase();

	}
	
	/**
	 * MD5У��
	 * @author sdyang
	 * @date 2015��6��3�� ����5:37:29
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
