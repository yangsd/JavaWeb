package com.example.exception;

/**
 * �Զ����쳣��
 * 
 * @author sdyang
 * @date 2015��6��3�� ����8:48:07
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
