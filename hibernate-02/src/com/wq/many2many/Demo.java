package com.wq.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.entity.Role;
import com.wq.entity.User;
import com.wq.util.HibernateUtil;

public class Demo {
	/*
	 *添加一个用户
	 */
	@Test
	public void fun1(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		User user=new User();
		user.setUser_name("王全");
		Role role=new Role();
		role.setRole_name("工程师");
		user.getRoles().add(role);
		session.save(user);
		tx.commit();
		session.close();	
	}

}
