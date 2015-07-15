package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.condition.UserQueryCondition;
import com.example.dao.UserDao;
import com.example.exception.BusinessException;
import com.example.util.BaseDAO;
import com.example.vo.UserVO;

/**
 * 
 * @author sdyang
 * @date 2015��6��3�� ����5:34:29
 */
@Transactional
@Service("userDao")
public class UserDaoImpl extends BaseDAO implements UserDao {

	private static String NAMESPACE = "com.example.service.itf.IUserService.";

	public int addUser(UserVO user) throws BusinessException {
		return sqlSession.insert(NAMESPACE + "addUser", user);
	}

	public int deleteUser(UserVO user) throws BusinessException {
		return sqlSession.update(NAMESPACE + "updateUserById", user);
	}

	public int updateUser(UserVO user) throws BusinessException {
		return sqlSession.update(NAMESPACE + "updateUserById", user);
	}

	public UserVO getUserById(int id) throws BusinessException {
		return sqlSession.selectOne(NAMESPACE + "selectUserById", id);
	}

	public List<UserVO> getAllUser() throws BusinessException {
		return sqlSession.selectList(NAMESPACE + "selectAllUser");
	}

	public UserVO getUserByLoginId(String loginId) throws BusinessException {

		return sqlSession.selectOne(NAMESPACE + "selectUserByLoginId", loginId);
		/*
		 * if (user != null) { return user; } else { //
		 * ������ݿ���û���û������ݣ���ʹ�ó�ʼ�����û����� List<UserVO> users = initUsers();
		 * 
		 * for (UserVO User : users) { if (User.getLoginid().equals(loginId) ==
		 * true) { return User; } } } throw new
		 * BusinessException("User does not exist!");
		 */
	}

	private List<UserVO> initUsers() {

		List<UserVO> users = new ArrayList<UserVO>();
		UserVO user = null;

		user = new UserVO();
		user.setLoginid("admin");

		// "admin"����MD5���ܺ�
		user.setPassword("21232f297a57a5a743894a0e4a801fc3");
		user.setAccess(1);

		users.add(user);

		user = new UserVO();
		user.setLoginid("user");

		// "user"����MD5���ܺ�
		user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		user.setAccess(2);

		users.add(user);

		return users;

	}

	public int getUserCount() throws BusinessException {
		return sqlSession.selectOne(NAMESPACE + "selectUserCount");
	}

	public List<UserVO> getUsers(UserQueryCondition params)
			throws BusinessException {
		return sqlSession.selectList(NAMESPACE + "queryUser", params);
	}

}
