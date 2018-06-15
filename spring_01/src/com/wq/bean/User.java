package com.wq.bean;

public class User {
	private String name;

	private Integer age;

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User() {
		System.out.println("User空参构造");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void init() {
		System.out.println("初始化方法");
	}

	public void destroy() {
		System.out.println("销毁方法");
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

	// 构造方法
	public User(String name, Car car) {
		this.name = name;
		this.car = car;
	}
	public User(Car car, String name) {
		this.car = car;
		this.name = name;
	}
	public User(Integer name,Car car) {
		this.car = car;
		this.name = name+"";//数字加空字符串变成string类型
	}
}
