package com.wq.injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wq.bean.User;

public class DemoTest {
	/*
	 * set注入
	 */
	@Test
	public void fun1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		User user = (User) ctx.getBean("user");
		System.out.println(user);
	}

	/*
	 * 构造方法注入User(String name,Car car)
	 */
	@Test
	public void fun2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		User user = (User) ctx.getBean("user1");
		System.out.println(user);
	}

	/*
	 * 构造方法注入User(Car car,String name)
	 */
	@Test
	public void fun3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		User user = (User) ctx.getBean("user2");
		System.out.println(user);
	}

	/*
	 * 构造方法注入User(Integer name,Car car)
	 */
	@Test
	public void fun4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		User user = (User) ctx.getBean("user3");
		System.out.println(user);
	}

	/*
	 * p空间注入
	 */
	@Test
	public void fun5() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		User user = (User) ctx.getBean("user4");
		System.out.println(user);

	}

	/*
	 * sqel注入
	 */
	@Test
	public void fun6() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		User user = (User) ctx.getBean("user5");
		System.out.println(user);
	}

	/*
	 * 复杂类型注入
	 */
	@Test
	public void fun7() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/injection/applicationContext.xml");
		CollectionBean cb = (CollectionBean) ctx.getBean("cb");
		System.out.println(cb);
	}
}
