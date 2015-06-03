package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理类
 * 
 * @author sdyang
 * @date 2015年6月3日 上午9:42:43
 */
public class BaseController {

	@ExceptionHandler
	public String exp(HttpServletRequest request,Exception exception) {

		request.setAttribute("exception", exception);

		// 根据不同错误转向不同页面
		if (exception instanceof BusinessException) {
			return "error-business";
		} else {
			return "error";
		}
	}
}
