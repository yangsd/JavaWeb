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
 * @date 2015年6月29日 下午5:39:27
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}

		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();

		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();

			// 访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();

			System.out.println("需要的角色：" + needPermission);

			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needPermission.equals(ga.getAuthority())) {
					return;
				}
			}
		}

		// 没有权限
		throw new AccessDeniedException(" No Access Dendied ");

	}

	public boolean supports(ConfigAttribute configAttribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {

		return true;
	}

}
