package com.example.util;

import com.google.gson.Gson;

/**
 * 
 * @author sdyang
 * @date 2015��6��12�� ����4:40:38
 */
public class JsonUtil {

	private static JsonUtil instance;

	public static JsonUtil getInstance() {
		if (null == JsonUtil.instance) {
			JsonUtil.instance = new JsonUtil();
		}
		return JsonUtil.instance;
	}

	private Gson gson;

	private Gson getGson() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}

	public String toJson(Object obj) {
		return getGson().toJson(obj);
	}

}
