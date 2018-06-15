package com.wq.Hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.util.HibernateUtil;

public class CriteriaTest {
	/*
	 * 简单查询
	 */
	@Test
	public void fun1(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);
		List<Customer>customers=criteria.list();
		System.out.println(customers);
		tx.commit();
		session.close();
	}
	/*
	 * 条件查询
	 */
	@Test
	public  void fun2(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("custId", 3l));//restriction
		Customer customer=(Customer) criteria.uniqueResult();
		System.out.println(customer);
		tx.commit();
		session.close();
	}
	/*
	 * 分页查询
	 */
	@Test
	public  void fun3(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.setFirstResult(0);//索引从0开始
		criteria.setMaxResults(10);//查询的条数
		List<Customer>customers=criteria.list();
		System.out.println(customers);
		tx.commit();
		session.close();
	}
	/*
	 * 查询总条数
	 */
	@Test
	public void fun4(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);//criteria 标准
		criteria.setProjection(Projections.rowCount());//projection 推算
		Long count=(Long) criteria.uniqueResult();//unique 唯一
		System.out.println(count);
		tx.commit();
		session.close();
	}
}
