package com.wq.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
import com.wq.util.HibernateUtil;

public class OneToManyTest {
	@Test
	public void fun1() {
		// 1、获得session
		Session session = HibernateUtil.getSession();
		// 2、开启事务
		Transaction tx = session.beginTransaction();
		// 3、操作
		// ----------------------------------
		Customer c = new Customer();
		c.setCustName("潭州教育");
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("梁辰");
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("array");
		// 表达一对多，客户下有多个联系人
		c.getLinkMan().add(lm1);
		c.getLinkMan().add(lm2);
		/*// 表达多对一，联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);*/
		session.save(c);
		/*session.save(lm1);
		session.save(lm2);*/
		// ---------------------------------
		// 4、提交事务
		tx.commit();
		// 5、关闭资源
		session.close();
	}

	@Test
	public void fun2() {
		// 1、获得session
		Session session = HibernateUtil.getSession();
		// 2、开启事务
		Transaction tx = session.beginTransaction();
		// 3、操作
		// ----------------------------------
		// 1、获得操作的客户对象
		Customer c = session.get(Customer.class, 10l);
		// 2、创建联系
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("沙奶奶");
		// 3、将联系人添加到客户，讲客户设置到联系人
		c.getLinkMan().add(lm1);
		lm1.setCustomer(c);
		// 4、执行操作
		session.save(lm1);
		// ----------------------------------
		// 4、提交事务
		tx.commit();
		// 5、关闭资源
		session.close();
	}

	// 为客户删除联系人
	@Test
	public void fun3() {
		// 1、获得session
		Session session = HibernateUtil.getSession();

		// 2、开启事务
		Transaction tx = session.beginTransaction();

		// 3、操作

		// ----------------------------------

		Customer c = session.get(Customer.class, 10l);
		 
		LinkMan lm = session.get(LinkMan.class, 11L);
		 
		c.getLinkMan().remove(lm);
		lm.setCustomer(null);
	
		 
		// ----------------------------------

		tx.commit();

		// 5、关闭资源
		session.close();
	}
	@Test
	public void fun5() {
	 // 1、获得session
        Session session = HibernateUtil.getSession();

        // 2、开启事务
        Transaction tx = session.beginTransaction();
        LinkMan lm = session.get(LinkMan.class, 11L);
        System.out.println(lm);
        

	}
	/*
	 *级联删除
	 */
	@Test
	public void fun4() {
		// 1、获得session
		Session session = HibernateUtil.getSession();

		// 2、开启事务
		Transaction tx = session.beginTransaction();

		// 3、操作

		// ----------------------------------

		Customer c = session.get(Customer.class, 1l);

		session.delete(c);

		// ----------------------------------

		tx.commit();

		// 5、关闭资源
		session.close();
	}
	
	@Test
    //操作删除客户
    //测试cascade:save-update
    public void fun6(){
        //1、获得session
        Session session =HibernateUtil.getSession();
        
        //2、开启事务
        Transaction tx = session.beginTransaction();
        
        //----------------------------------
        //3、操作
        Customer customer = session.get(Customer.class, 6l);
        session.delete(customer);
        
        //----------------------------------
        
        //4、提交事务
        tx.commit();
        
        //5、关闭资源
        session.close();
    }
}
