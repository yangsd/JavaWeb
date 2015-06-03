package com.example.exception;

/**
 * 自定义异常类
 * 
 * @author sdyang
 * @date 2015年6月3日 上午8:48:07
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException() {

	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
