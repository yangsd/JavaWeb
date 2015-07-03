package com.example.login;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * @author sdyang
 * @date 2015��7��2�� ����6:24:43
 */
public class LoginConfig {

	private static LoginConfig instance;

	private static Map<String, Object> configs = null;

	public static LoginConfig getInstance() {
		if (null == LoginConfig.instance) {
			LoginConfig.instance = new LoginConfig();
		}
		loadConfig();
		return LoginConfig.instance;
	}

	/**
	 * ���������ļ�
	 * @author sdyang
	 * @date 2015��7��3�� ����9:15:07
	 */
	private static void loadConfig() {
		Map<String, Object> config = new HashMap<String, Object>();
		try {
			Resource resource = new ClassPathResource("login.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			Iterator<String> it = props.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				config.put(key, props.getProperty(key));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		setConfigs(config);
	}

	public static Map<String, Object> getConfigs() {
		return configs;
	}

	public static void setConfigs(Map<String, Object> configs) {
		LoginConfig.configs = configs;
	}

}
