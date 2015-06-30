package com.example.login;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author sdyang
 * @date 2015��6��29�� ����5:39:27
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}

		// ���������Դӵ�е�Ȩ��(һ����Դ�Զ��Ȩ��)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();

		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();

			// ������������Դ����Ҫ��Ȩ��
			String needPermission = configAttribute.getAttribute();

			System.out.println("needPermission is " + needPermission);

			// �û���ӵ�е�Ȩ��authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needPermission.equals(ga.getAuthority())) {
					return;
				}
			}
		}

		// û��Ȩ��
		throw new AccessDeniedException(" No Access Dendied ");

	}

	public boolean supports(ConfigAttribute configAttribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {

		return true;
	}

}