package com.wq.Hibernate.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.util.HibernateUtil;

public class SqlTest {
	/*
	 * 基本查询
	 */
	@Test
	public void fun1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String sql = "select * from cus_customer";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		List<Object[]> customers = sqlQuery.list();// 返回数组
		for (Object[] objects : customers) {
			System.out.println(Arrays.toString(objects));
		}
		tx.commit();
		session.close();
	}

	@Test
	public void fun2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String sql = "select * from cus_customer";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		//指定将结果集封装到对象中
		sqlQuery.addEntity(Customer.class);
		List<Customer> customers = sqlQuery.list();// 返回数组
		System.out.println(customers);
		tx.commit();
		session.close();
	}
	/*
	 * 条件查询
	 */
	@Test
	public void fun3(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		String sql = "select custName from cus_customer where custId=?";
		SQLQuery query=session.createSQLQuery(sql);
		 query.setLong(0, 1);
		//指定将结果集封装到对象中
		query.addEntity(Customer.class);
		List<Customer> list=query.list();
		System.out.println(list);
		
	}
	/*
	 * 分页查询
	 */
	@Test
	public void fun4(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		String sql = "select custName from cus_customer limit ?,?";
		SQLQuery query=session.createSQLQuery(sql);
		 query.setParameter(0, 0);
		 query.setParameter(1, 10);
		//指定将结果集封装到对象中
		query.addEntity(Customer.class);
		List<Customer>customers=query.list();
		System.out.println(customers);
	}
}
