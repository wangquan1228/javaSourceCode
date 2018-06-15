package com.wq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wq.bean.User;

public class Demo {
	@Test
	public void fun1() {
		//1 创建容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 向容器中获取对象
		User user = (User) ctx.getBean("user");
		//3 打印对象
		System.out.println(user);
	}
}
