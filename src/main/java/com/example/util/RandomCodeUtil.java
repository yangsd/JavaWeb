package com.example.util;

import java.util.Random;

/**
 * 
 * @author sdyang
 * @date 2015��6��15�� ����5:30:49
 */
public class RandomCodeUtil {

	// ���������ʱ������Դ
	private static char[] codeSequence = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 't', 'u', 'v', 'w',
			'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static String genNumPassword(int length) {
		// ����һ���������������
		Random random = new Random();
		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		for (int i = 0; i < length; i++) {
			// �õ������������֤�����֡�
			String strRand = String.valueOf(codeSequence[random.nextInt(32)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}
}
