package com.wq.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.util.HibernateUtil;

public class Demo {
  @Test
  public void fun1(){
	    //1,创建配置类Configuration的实例,加载Hibernate配置文件
		Configuration conf = new Configuration().configure();
		//2, 创建会话工厂接口SessionFactory类型的实例
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction  tx = session.beginTransaction();
		//-------------------------------------
		for(int i=0;i<10;i++){ 
			Customer c = new Customer();
			c.setCustName("TT"+i);
			session.save(c);//执行保存
			//-------------------------------------
		}	
		tx.commit();
		session.close();
		sessionFactory.close();
  } 
   @Test
  public void fun2(){
	  Session session=HibernateUtil.getSession();
	  Transaction tx=session.beginTransaction();
	  Customer c2=session.get(Customer.class, 3l);
	  Customer c1=new Customer();
	  c1.setCustId(3l);
	  session.update(c1);
	  c1.setCustName("TT");
	  c1.setCustName("江兰皮革场");
	  tx.commit();
	  session.close(); 
  } 
   
   @Test
   public void fun3() {
       Session session=HibernateUtil.getSession();
       Transaction tx=session.beginTransaction();
       Customer c2=session.get(Customer.class, 3l);
       System.out.println(c2);
       c2.setCustName("阿庆嫂"); 
       session.update(c2);
       tx.commit();
       
   }
}
