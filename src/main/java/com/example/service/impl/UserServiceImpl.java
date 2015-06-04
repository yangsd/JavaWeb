package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.BusinessException;
import com.example.service.itf.IUserService;
import com.example.util.BaseDAO;
import com.example.vo.User;

/**
 * 
 * @author sdyang
 * @date 2015年6月3日 下午5:34:29
 */
@Transactional
@Service("userService")
public class UserServiceImpl extends BaseDAO implements IUserService {

	private static String NAMESPACE = "com.example.service.itf.IUserService.";
	
	public void saveUser(User user) throws BusinessException {
		
	}

	public void delUser(User user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	public void editUsre(User user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	public User getUserById(int id) throws BusinessException {
		User user = sqlSession.selectOne(NAMESPACE+"selectUserByID", "1");  
		return user; 
	}

	public List<User> getAllUser() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
