package com.example.vo;


/**
 * 用户
 * 
 * @author sdyang
 * @date 2015年6月3日 下午5:34:39
 */

public class UserVO {

	private int id;

	private String name;

	private String password;

	private Integer access;
	
	public UserVO(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAccess() {
		return access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

}
