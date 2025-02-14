package com.wq.entity;

public class Student {
	private int id;
	private String name;
	private String pwd;
	private String sex;
	private String address;
	
	public Student(int id, String name, String pwd,String sex, String address) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.address = address;
	}
	
	public Student( String name, String pwd,String sex, String address) {
		
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.address = address;
	}

	public Student() {
		// TODO Auto-generated constructor stub
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", address=" + address + "]";
	}
	
	
	
}
