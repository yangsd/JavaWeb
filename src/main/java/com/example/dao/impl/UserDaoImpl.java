package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.exception.BusinessException;
import com.example.util.BaseDAO;
import com.example.vo.UserVO;

/**
 * 
 * @author sdyang
 * @date 2015年6月3日 下午5:34:29
 */
@Transactional
@Service("userDao")
public class UserDaoImpl extends BaseDAO implements UserDao {

	private static String NAMESPACE = "com.example.service.itf.IUserService.";
	
	public void saveUser(UserVO user) throws BusinessException {
		
	}

	public void delUser(UserVO user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	public void editUsre(UserVO user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	public UserVO getUserById(int id) throws BusinessException {
		UserVO user = sqlSession.selectOne(NAMESPACE+"selectUserByID", "1");  
		return user; 
	}

	public List<UserVO> getAllUser() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVO getUserByName(String username) throws BusinessException {
		List<UserVO> users = initUsers();

		for (UserVO User : users) {
			if (User.getName().equals(username) == true) {
				return User;
			}
		}
		throw new BusinessException("User does not exist!");
	}

	private List<UserVO> initUsers() {

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
