package com.wq.entity;

 

public class SysUser {
   
	 private Long userId;
	 private String userCode;
	 private String userName;
	 private String userPassword;
	 private char userState;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public char getUserState() {
		return userState;
	}
	public void setUserState(char userState) {
		this.userState = userState;
	}
	public SysUser(Long userId, String userCode, String userName, String userPassword, char userState) {
		super();
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
	}
	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sys_user [userId=" + userId + ", userCode=" + userCode + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userState=" + userState + "]";
	}
	 
	 
}
