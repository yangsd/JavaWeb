package com.example.dao;

import java.util.List;

import com.example.exception.BusinessException;
import com.example.vo.UserVO;

/**
 * �û�����������
 * @author sdyang
 * @date 2015��6��3�� ����3:07:31
 */

public interface UserDao {

	public void saveUser(UserVO user) throws BusinessException;

	public void delUser(UserVO user) throws BusinessException;

	public void editUsre(UserVO user) throws BusinessException;

	public UserVO getUserById(int id) throws BusinessException;
	
	public UserVO getUserByName(String username) throws BusinessException;
	
	public List<UserVO> getAllUser() throws BusinessException;
}