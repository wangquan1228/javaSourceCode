package com.wq.Hibernate.hql;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.util.HibernateUtil;

public class HqlTest {
	/*
	 * hql基本查询 获得多个对象
	 */
	@Test
	public void fun1(){
		//1 获取session对象
		Session  session=HibernateUtil.getSession();
		//2 session获取开启事务
		Transaction tx=session.beginTransaction();
		//3 书写 hql 语句
		String hql="from Customer";
		//4 处理事务
		Query query=session.createQuery(hql);//持久状态
		 List<Customer>list= query.list();//获得多个对象
		System.out.println(list );
		//5 提交事务
		tx.commit();
		//关闭缓存session  变为游离状态
		session.clear();
	}
	/**
	 * 查询主键为1 的Cutomer对象
	 */
	@Test
	public void fun2(){
		//1 获取session对象
		Session session =HibernateUtil.getSession();
		//2 获得session的事务操作对象,开启事务
	    Transaction tx=session.beginTransaction();
		//处理事务
		String hql="from Customer where custId=1";
		//执行hql 语句
		Query query=session.createQuery(hql);
		//接收查询的对象
		Customer customer=(Customer) query.uniqueResult();
		System.out.println(customer);
		//3 提交事务
		tx.commit();
		session.close();
	}
	/*
	 * 根据占位符? 条件查询
	 */
	@Test
	public void fun3(){
		//获取sesion对象
		Session session=HibernateUtil.getSession();
		//获取事务操作对象
		Transaction tx=session.beginTransaction();
		//hql语句
    	String hql="from Customer where custId=:id";//命名占位符方法的查询
		//String hql="from Customer where custId=?";
		Query query=session.createQuery(hql);
		//query.setParameter(0, 2l);
		//query .setLong(0, 2l);
		query.setParameter("id", 3l);//避免了因为索引混乱而出错
		Customer customer=(Customer)query.uniqueResult();
		System.out.println(customer);
		tx.commit();
		session.close();
	}
	/*
	 * 分页查询
	 */
	@Test
	public void fun4(){
		Session  session =HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from Customer";
		Query query=session.createQuery(hql);
		query.setFirstResult(2);//索引从0开始的
		query.setMaxResults(1);//查询的条数
		List<Customer> customers=query.list();
		System.out.println(customers);
		tx.commit();
		session.close();
	}
	
	
	 
}
