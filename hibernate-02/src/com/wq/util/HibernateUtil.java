package com.wq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory FACTORY=getSessionFactory();
	private static SessionFactory getSessionFactory(){
	 
		Configuration cfg=new Configuration().configure();
		//Configuration cfg=new Configuration().configure("hibernate.cfg.xml")
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		return sessionFactory;
		
	}
	
	public static Session getSession(){
		return FACTORY.openSession();
	}
    
	public static void close(Session session){
		if(session !=null){
			session.close();
		}
	}
}
