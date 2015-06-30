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

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails user = null;

		// �������ݿ���ƥ���û���¼��.
		// ���ǿ���ͨ��daoʹ��JDBC���������ݿ�
		UserVO user1;
		try {
			user1 = userDao.getUserByName(username);

			user = new User(user1.getName(), user1.getPassword().toLowerCase(),
					true, true, true, true, getAuthorities(user1.getAccess()));

		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// ���е��û�Ĭ��ӵ��ROLE_USERȨ��
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// �������accessΪ1.��ӵ��ROLE_ADMINȨ��
		if (access.compareTo(1) == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		return authList;
	}

}
