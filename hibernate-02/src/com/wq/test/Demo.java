package com.wq.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
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
	 
			Customer c = new Customer();
			c.setCustName("王全");
			session.save(c);//执行保存
			//-------------------------------------
		 
		tx.commit();
		session.close();
		sessionFactory.close();
  } 
   @Test
  public void fun2(){
	  Session session=HibernateUtil.getSession();
	  Transaction tx=session.beginTransaction();
	  Customer c2=session.get(Customer.class, 3l);
	  c2.setCustName("江兰皮革场");
	  LinkMan lk=new LinkMan();
	  lk.setLkm_name("刁德一");
	  c2.getLinkMan().add(lk);
	  lk.setCustomer(c2);
	  session.save(lk);
	  
	  tx.commit();
	  session.close(); 
  } 
   
   @Test
   public void fun3() {
       Session session=HibernateUtil.getSession();
       Transaction tx=session.beginTransaction();
       Customer c2=session.get(Customer.class, 3l);
       LinkMan lk1=session.get(LinkMan.class, 5l);
       c2.getLinkMan().remove(lk1);
       lk1.setCustomer(null);
       tx.commit();
       session.close(); 
   }
   @Test
   public  void  fun5() {
       Session session=HibernateUtil.getSession();
       Transaction tx=session.beginTransaction();
       String sql="update   LinkMan set lkm_cust_id=null  where lkm_id=3l";
       session.createQuery(sql);
       tx.commit();
       session.close();
   }
}
