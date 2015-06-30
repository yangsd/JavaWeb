package com.example.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.util.StringUtils;

import com.example.constants.User;
import com.example.vo.AuthenticationTokenVO;

/**
 * 
 * @author sdyang
 * @date 2015��6��18�� ����10:07:49
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {

		String username = request.getParameter(User.USERNAME);
		String password = request.getParameter(User.PASSWORD);
		String verificationCode = request.getParameter(User.VERIFICATIONCODE);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		AuthenticationTokenVO authRequest = new AuthenticationTokenVO(username,
				password, verificationCode, request.getSession());

		HttpSession session = request.getSession(false);

		if (session != null || getAllowSessionCreation()) {
			request.getSession().setAttribute(User.USERINFO,
					TextEscapeUtils.escapeEntities(username));

		}

		setDetails(request, authRequest);

		// �����֤��
		checkValidateCode(request);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015��6��18�� ����11:38:08
	 * @param request
	 */
	private void checkValidateCode(HttpServletRequest request) {

		String validateCodeParameter = request.getParameter(User.VERIFICATIONCODE);

		String sessionValidateCode = (String) request.getSession()
				.getAttribute(User.SESSION_VERIFICATIONCODE);

		if (StringUtils.isEmpty(validateCodeParameter)
				|| !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
			throw new AuthenticationServiceException("��֤��������������룡");
		}
	}
}