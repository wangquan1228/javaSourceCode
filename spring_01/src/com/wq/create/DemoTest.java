package com.wq.create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wq.bean.User;

public class DemoTest {
	/*
	 * 创建方法一:空参构造 空参构造 每次容器启动时就会创建容器中配置的所有对象.并提供更多功能
	 */

	@Test
	public void fun1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/create/applicationContext.xml");
	}

	/*
	 * 创建方法2: 静态工厂创建
	 */
	@Test
	public void fun2() {
		// 创建容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/create/applicationContext.xml");
		// 获取对象
		User user = (User) ctx.getBean("user2");
		// 打印
		System.out.println(user);

	}

	/*
	 * 创建方法3: 实例工厂创建
	 */
	@Test
	public void fun3() {
		// 创建容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/create/applicationContext.xml");
		// 获取对象
		User user = (User) ctx.getBean("user3");
		// 打印
		System.out.println(user);

	}

	/*
	 * 单例模式
	 * scope
	 */
	@Test
	public void fun4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/create/applicationContext.xml");
		User user1 = (User) ctx.getBean("user4");
		User user2 = (User) ctx.getBean("user4");
		User user3 = (User) ctx.getBean("user4");
		User user5 = (User) ctx.getBean("user4");
		System.out.println(user5 == user1);//单例 ture 多例 false
	}
	
	/*
	 * 生命周期
	 * 初始化到销毁
	 */
	@Test
	public void fun5() {
		// 创建容器
		  ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/wq/create/applicationContext.xml");
		// 获取对象
		User user = (User) ctx.getBean("user5");
		// 打印
		System.out.println(user);
		//手动关闭ctx,当打印完user对象时,线程已经结束,所以无法执行销毁方法,当手动关闭时,线程需要执行所有的方法
		ctx.close();
	}
}
