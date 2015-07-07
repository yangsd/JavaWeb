package com.example.dao;

import java.util.List;

import com.example.condition.UserQueryCondition;
import com.example.exception.BusinessException;
import com.example.vo.UserVO;

/**
 * �û�����������
 * 
 * @author sdyang
 * @date 2015��6��3�� ����3:07:31
 */

public interface UserDao {

	/**
	 * �����û�
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����11:43:15
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	public String addUser(UserVO user) throws BusinessException;

	/**
	 * ɾ���û�
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����11:43:26
	 * @param user
	 * @throws BusinessException
	 */
	public void deleteUser(UserVO user) throws BusinessException;

	/**
	 * �����û���Ϣ
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����11:43:37
	 * @param user
	 * @throws BusinessException
	 */
	public void updateUser(UserVO user) throws BusinessException;

	/**
	 * ����������ѯ�û���Ϣ
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����11:43:46
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserVO getUserById(int id) throws BusinessException;

	/**
	 * ���ݵ�¼�˻���ѯ�û���Ϣ
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����11:43:58
	 * @param loginId
	 * @return
	 * @throws BusinessException
	 */
	public UserVO getUserByLoginId(String loginId) throws BusinessException;

	/**
	 * ��ѯ�����û�
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����11:44:10
	 * @return
	 * @throws BusinessException
	 */
	public List<UserVO> getAllUser() throws BusinessException;

	/**
	 * ��ѯ�û�����
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����3:18:15
	 * @return
	 * @throws BusinessException
	 */
	public int getUserCount() throws BusinessException;

	/**
	 * ��ѯ�û�
	 * 
	 * @author sdyang
	 * @date 2015��7��7�� ����3:49:22
	 * @param currentPage
	 * @param rows
	 * @return
	 * @throws BusinessException
	 */
	public List<UserVO> getUsers(UserQueryCondition params)
			throws BusinessException;
}
