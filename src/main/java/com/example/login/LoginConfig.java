package com.example.login;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * 
 * @author sdyang
 * @date 2015年7月2日 下午6:24:43
 */
public class LoginConfig {

	private boolean verificationCode;

	public void loadConfig() {
		Properties prop = new Properties();
		try {
			// 读取属性文件a.properties
			InputStream in = new FileInputStream("login.properties ");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.println(key + ":" + prop.getProperty(key));
			}
			in.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean getVerificationCode() {
		loadConfig();
		return verificationCode;
	}

	public void setVerificationCode(boolean verificationCode) {
		this.verificationCode = verificationCode;
	}

}
