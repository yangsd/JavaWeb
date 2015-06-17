package com.example.service.itf;

import java.util.List;

import com.example.exception.BusinessException;
import com.example.vo.UserVO;

/**
 * 用户基础服务类
 * @author sdyang
 * @date 2015年6月3日 下午3:07:31
 */

public interface IUserService {

	public void saveUser(UserVO user) throws BusinessException;

	public void delUser(UserVO user) throws BusinessException;

	public void editUsre(UserVO user) throws BusinessException;

	public UserVO getUserById(int id) throws BusinessException;
	
	public List<UserVO> getAllUser() throws BusinessException;
}
