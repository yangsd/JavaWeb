package com.example.vo;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/**
 * 
 * @author sdyang
 * @date 2015年6月18日 上午9:50:47
 */
public class AuthenticationTokenVO extends UsernamePasswordAuthenticationToken {

	private String verificationCode;

	private HttpSession session;

	public AuthenticationTokenVO(Object principal, Object credentials,
			String verificationCode, HttpSession session) {
		super(principal, credentials);
		this.verificationCode = verificationCode;
		this.session = session;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
