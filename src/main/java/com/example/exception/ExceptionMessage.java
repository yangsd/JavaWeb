package com.example.exception;


/**
 * 
 * @author sdyang
 * @date 2015年6月3日 上午8:41:45
 */
public class ExceptionMessage {

	private String message;

	private String detail;

	public ExceptionMessage(String message, String detail) {
		super();
		this.message = message;
		this.detail = detail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
