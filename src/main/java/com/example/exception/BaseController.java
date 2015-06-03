package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * �쳣������
 * 
 * @author sdyang
 * @date 2015��6��3�� ����9:42:43
 */
public class BaseController {

	@ExceptionHandler
	public String exp(HttpServletRequest request,Exception exception) {

		request.setAttribute("exception", exception);

		// ���ݲ�ͬ����ת��ͬҳ��
		if (exception instanceof BusinessException) {
			return "error-business";
		} else {
			return "error";
		}
	}
}
