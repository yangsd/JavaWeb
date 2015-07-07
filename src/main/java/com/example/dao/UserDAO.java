package com.example.dao;

import java.util.List;

import com.example.condition.UserQueryCondition;
import com.example.exception.BusinessException;
import com.example.vo.UserVO;

/**
 * 用户基础服务类
 * 
 * @author sdyang
 * @date 2015年6月3日 下午3:07:31
 */

public interface UserDao {

	/**
	 * 新增用户
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 上午11:43:15
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	public String addUser(UserVO user) throws BusinessException;

	/**
	 * 删除用户
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 上午11:43:26
	 * @param user
	 * @throws BusinessException
	 */
	public void deleteUser(UserVO user) throws BusinessException;

	/**
	 * 更新用户信息
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 上午11:43:37
	 * @param user
	 * @throws BusinessException
	 */
	public void updateUser(UserVO user) throws BusinessException;

	/**
	 * 根据主键查询用户信息
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 上午11:43:46
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserVO getUserById(int id) throws BusinessException;

	/**
	 * 根据登录账户查询用户信息
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 上午11:43:58
	 * @param loginId
	 * @return
	 * @throws BusinessException
	 */
	public UserVO getUserByLoginId(String loginId) throws BusinessException;

	/**
	 * 查询所有用户
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 上午11:44:10
	 * @return
	 * @throws BusinessException
	 */
	public List<UserVO> getAllUser() throws BusinessException;

	/**
	 * 查询用户总数
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 下午3:18:15
	 * @return
	 * @throws BusinessException
	 */
	public int getUserCount() throws BusinessException;

	/**
	 * 查询用户
	 * 
	 * @author sdyang
	 * @date 2015年7月7日 下午3:49:22
	 * @param currentPage
	 * @param rows
	 * @return
	 * @throws BusinessException
	 */
	public List<UserVO> getUsers(UserQueryCondition params)
			throws BusinessException;
}
