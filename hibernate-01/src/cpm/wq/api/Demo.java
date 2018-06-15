package cpm.wq.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Demo {
	@Test
	public void fun1() {
		// 1,获取cfg.xml文件,读取主配置文件
		Configuration cfg = new Configuration().configure();
		// 2创建sessionFactory 对象
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 3 获取session对象
		Session session = sessionFactory.openSession();
		/*
		 * 4 session获得事务的Transaction对象 Transaction
		 * tx=session.getTransaction();(该这种方法几乎不用) 开启事务tx ,并对其进行操作
		 */
		Transaction tx = session.beginTransaction();
		// 5 操作事务
		/*
		 * session.save(arg0);//储存
		 * session.update(arg0);//修改
		 * session.delete(arg0);//删除
		 * session.get(arg0, arg1);//获取
		 */
		tx.commit();// 提交事务 
		tx.rollback();//回滚事件
		session.close();
		sessionFactory.close();

	}
}
