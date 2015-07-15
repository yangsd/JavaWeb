package com.example.itf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.condition.UserQueryCondition;
import com.example.exception.BusinessException;
import com.example.vo.UserVO;

/**
 * 用户服务层接口
 * 
 * @author sdyang
 * @date 2015年7月13日 上午10:23:32
 */
public interface UserService {

	public String addUser(UserVO user) throws BusinessException;

	public Boolean deleteUser(UserVO pk_user) throws BusinessException;

	public String updateUser(UserVO user) throws BusinessException;

	public UserVO getUserById(int id) throws BusinessException;

	public UserVO getUserByLoginId(String loginId) throws BusinessException;

	public List<UserVO> getAllUser() throws BusinessException;

	public int getUserCount() throws BusinessException;

	public List<UserVO> getUsers(UserQueryCondition params)
			throws BusinessException;

	public void downLoadFile(HttpServletResponse response)
			throws BusinessException;

	public String upLoadFile(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException;

}
