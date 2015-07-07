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

	public String addUser(UserVO user) throws BusinessException {

		int result = sqlSession.insert(NAMESPACE + "addUser", user);

		if (result <= 0) {
			throw new BusinessException("failure to insert a new user !");
		} else {
			// �����û��ɹ��򷵻��û�����
			return getUserByLoginId(user.getLoginid()).getPk_user() + "";
		}
	}

	public void deleteUser(UserVO user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	public void updateUser(UserVO user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	public UserVO getUserById(int id) throws BusinessException {
		UserVO user = sqlSession.selectOne(NAMESPACE + "selectUserById", id);
		return user;
	}

	public List<UserVO> getAllUser() throws BusinessException {
		List<UserVO> users = null;
		users = sqlSession.selectList(NAMESPACE + "selectAllUser");
		return users;
	}

	public UserVO getUserByLoginId(String loginId) throws BusinessException {

		UserVO user = sqlSession.selectOne(NAMESPACE + "selectUserByLoginId",
				loginId);

		if (user != null) {
			return user;
		} else {
			// ������ݿ���û���û������ݣ���ʹ�ó�ʼ�����û�����
			List<UserVO> users = initUsers();

			for (UserVO User : users) {
				if (User.getLoginid().equals(loginId) == true) {
					return User;
				}
			}
		}
		throw new BusinessException("User does not exist!");
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
		int result = sqlSession.selectOne(NAMESPACE + "selectUserCount");
		return result;
	}

	public List<UserVO> getUsers(UserQueryCondition params)
			throws BusinessException {
		
		return null;
	}

	

}
