package com.wq.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
import com.wq.util.HibernateUtil;

public class DemoTest {
		@Test
		public void fun1(){
			Session session=HibernateUtil.getSession();
			Transaction tx=session.beginTransaction();
			Customer customer = session.get(Customer.class, 2l);
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("蔡俊岭");
			customer.getLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			session.save(customer);
			tx.commit();
			session.close();
		}
		@Test
		public void fun2(){
			Session session=HibernateUtil.getSession();
			Transaction tx=session.beginTransaction();
			Customer customer = session.get(Customer.class, 2l);
			LinkMan linkMan = session.get(LinkMan.class, 3l); 
			linkMan.setCustomer(customer);
			session.save(customer);
			tx.commit();
			session.close();
		}
		
}

