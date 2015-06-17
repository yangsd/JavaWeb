package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.vo.UserVO;

public class UserDAO {

	public UserVO getDatabase(String username) {

		List<UserVO> users = internalDatabase();

		for (UserVO User : users) {
			if (User.getName().equals(username) == true) {
				return User;
			}
		}
		throw new RuntimeException("User does not exist!");

	}

	/**
	 * 初始化数据
	 */
	private List<UserVO> internalDatabase() {

		List<UserVO> users = new ArrayList<UserVO>();
		UserVO user = null;

		user = new UserVO();
		user.setName("admin");

		// "admin"经过MD5加密后
		user.setPassword("21232f297a57a5a743894a0e4a801fc3");
		user.setAccess(1);

		users.add(user);

		user = new UserVO();
		user.setName("user");

		// "user"经过MD5加密后
		user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		user.setAccess(2);

		users.add(user);

		return users;

	}
}
