package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.BusinessException;
import com.example.model.User;
import com.example.service.itf.IUserService;
import com.example.util.BaseDAO;

@Service("userService")
public class UserServiceImpl extends BaseDAO implements IUserService {

	public void saveUser(User user) throws BusinessException {
		getSession().save(user);
	}

	public void delUser(User user) throws BusinessException {
		getSession().delete(user);
	}

	public void editUsre(User user) throws BusinessException {
		getSession().merge(user);
	}

	public User getUserById(int id) throws BusinessException {

		return (User) getSession().get(User.class, id);
	}

	public List<User> getAllUser() throws BusinessException {
		List<User> userList = null;
		userList = getSession().createQuery("from user").list();
		return userList;
	}

}
