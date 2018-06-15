package com.hotel.entity;

import java.io.Serializable;
import java.util.Date;

public class Employees implements Serializable {
	private int id;
	private String userName;
	private String account;
	private String password;
	private String mobile;
	private int status;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUsernName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int id, String userName, String account, String password, String mobile, int status,
			Date createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.mobile = mobile;
		this.status = status;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", usernName=" + userName + ", account=" + account + ", password=" + password
				+ ", mobile=" + mobile + ", status=" + status + ", createTime=" + createTime + "]";
	}

}
