package com.wq.manytest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wq.entity.Role;
import com.wq.entity.User;
import com.wq.util.HibernateUtil;

public class Demo {
	/*
	 * 添加一个用户
	 */
	@Test
	public void fun1(){
		//创建session 对象,获取hibernate配置文件
		Session session=HibernateUtil.getSession();
		//创建事务操作对象
		Transaction tx=session.beginTransaction();
		User user=new User();
		user.setUser_name("王全");
		Role role=new Role();
		role.setRole_name("工程师");
		user.getRoles().add(role);
		session.save(user);
		tx.commit();//提交事务
		session.close();//关闭session
	}
	/**
	 * 为已知的用户添加一个角色
	 */
	@Test
	public void fun2(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		User user=session.get(User.class, 1l);
		Role role=new Role();
		role.setRole_name("公关");
		user.getRoles().add(role);
		tx.commit();
		session.close();
	}
	/*
	 * 解除角色
	 */
	@Test
	public void fun3(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		User user=session.get(User.class, 1l);
		Role role=session.get(Role.class, 1l);
		user.getRoles().remove(role);
		tx.commit();
		session.close();
	}
}
