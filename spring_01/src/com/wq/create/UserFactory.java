package com.wq.create;

import com.wq.bean.User;

public class UserFactory {
	//静态工厂创建user
	public static User createUser(){
		System.out.println("静态工厂创建user");
		
		return new User();
	}
	//实例工厂创建user
	public  User createUser2(){
		System.out.println("实例工厂创建user");
		
		return new User();
	}
}
