package com.example.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sdyang
 * @date 2015��6��30�� ����11:06:20
 */
public interface RoleConstant {

	/**
	 * ����Ա
	 */
	public static String ROLE_ADMIN = "ROLE_ADMIN";

	/**
	 * �û�
	 */
	public static String ROLE_USER = "ROLE_USER";

	/**
	 * ����Ȩ��
	 */
	public static Map<Integer, String> ACCESS = new HashMap<Integer, String>() {
		{
			put(1, "admin");
			put(2, "user");
		}
	};

}
