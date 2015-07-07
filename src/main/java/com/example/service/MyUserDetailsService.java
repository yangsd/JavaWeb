package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.constants.RoleConstant;
import com.example.dao.UserDao;
import com.example.exception.BusinessException;
import com.example.vo.UserVO;

/**
 * 
 * @author sdyang
 * @date 2015��6��15�� ����11:41:39
 */

public class MyUserDetailsService implements UserDetailsService {

	@Resource
	UserDao userDao;

	public UserDetails loadUserByUsername(String loginId)
			throws UsernameNotFoundException {
		UserDetails user = null;

		// �������ݿ���ƥ���û���¼��.
		// ���ǿ���ͨ��daoʹ��JDBC���������ݿ�
		UserVO userVO;
		try {
			userVO = userDao.getUserByLoginId(loginId);

			user = new User(userVO.getLoginid(), userVO.getPassword().toLowerCase(),
					true, true, true, true, getAuthorities(userVO.getAccess()));

		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// ���е��û�Ĭ��ӵ��ROLE_USERȨ��
		authList.add(new SimpleGrantedAuthority(RoleConstant.ROLE_USER));

		// �������accessΪ1.��ӵ��ROLE_ADMINȨ��
		if (access.compareTo(1) == 0) {
			authList.add(new SimpleGrantedAuthority(RoleConstant.ROLE_ADMIN));
		}

		return authList;
	}

}
