package com.wq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sFactory = null;
	static {
		Configuration cfg = new Configuration().configure();
		sFactory = cfg.buildSessionFactory();
	}

	//
	public static Session openSession() {
		Session session = sFactory.openSession();
		return session;
	}

	// 获取与现场绑定的Session
	public static Session getCurrentSession() {
		Session session = sFactory.getCurrentSession();
		return session;
	}

	// 关闭资源
	 
	 

	 
}
