package com.example.service.itf;

import java.util.List;

import com.example.exception.BusinessException;
import com.example.model.User;

/**
 * 用户基础服务类
 * @author sdyang
 * @date 2015年6月3日 下午3:07:31
 */
public interface IUserService {

	public void saveUser(User user) throws BusinessException;

	public void delUser(User user) throws BusinessException;

	public void editUsre(User user) throws BusinessException;

	public User getUserById(int id) throws BusinessException;
	
	public List<User> getAllUser() throws BusinessException;
}
