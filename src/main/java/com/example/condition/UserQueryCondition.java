package com.example.condition;

import com.example.page.PageCondition;

/**
 * �û���ѯ����
 * 
 * @author sdyang
 * @date 2015��7��7�� ����4:07:11
 */
public class UserQueryCondition extends PageCondition {

	private String loginid;

	private String name;

	private String access;

	private String beginTime;

	private String endTime;

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
