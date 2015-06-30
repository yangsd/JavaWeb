package com.example.login;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author sdyang
 * @date 2015��6��30�� ����10:13:05
 */
public class SingleOnline {

	/**
	 * �Ƿ�ǿ�Ƶ�¼
	 */
	public static final String ENFORCE = "enforce";

	private static Map<String, String> mapOnline = new ConcurrentHashMap<String, String>();

	/**
	 * ���û���ӵ������б�
	 * 
	 * @param userCode
	 * @param sessionId
	 */
	public static void addUser(String userName, String sessionId) {
		mapOnline.put(userName, sessionId);
	}

	/**
	 * �������б�ɾ���û�
	 * 
	 * @param userName
	 */
	public static void removeUser(String userName) {
		mapOnline.remove(userName);
	}

	/**
	 * �û��Ƿ�����
	 * 
	 * @param userCode
	 * @param sessionId
	 * @return
	 */
	public static boolean isOnline(String userName) {
		if (mapOnline.containsKey(userName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * session�Ƿ���Ч
	 * 
	 * @param userName
	 * @param sessionId
	 * @return
	 */
	public static boolean isSessionValid(String sessionId) {
		boolean flag = false;
		if (mapOnline.containsValue(sessionId)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * �������session
	 */
	public static void purge() {
		mapOnline.clear();
	}
}
