package com.example.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sdyang
 * @date 2015年6月30日 上午11:06:20
 */
public interface RoleConstant {

	/**
	 * 管理员
	 */
	public static String ROLE_ADMIN = "ROLE_ADMIN";

	/**
	 * 用户
	 */
	public static String ROLE_USER = "ROLE_USER";

	/**
	 * 访问权限
	 */
	public static Map<Integer, String> ACCESS = new HashMap<Integer, String>() {
		{
			put(1, "admin");
			put(2, "user");
		}
	};

}
