package com.wq.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wq.util.HibernateUtil;

public class Mydao {
	/*
	 * 插入
	 */
	public static <T> void add(T t) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
	}

	/*
	 * 修改
	 */
	public static <T> void update(T t) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}

	}

	/*
	 * 删除
	 */
	public static <T> void delete(T t) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
	}

	/*
	 * 根据对象的主键查询指定记录------泛型方法queryOne()
	 * 
	 * @param serializable:对象的主键@param clazz:对象的泛型
	 * 
	 */
	public static <T> T queryOne(Class<T> clazz, Serializable serializable) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			T t = session.get(clazz, serializable);
			// User user=session.get(clazz, serializable);
			return t;
		} finally {
			HibernateUtil.close(session);
		}
	}

	/*
	 * 根据查询条件查询一条记录:@param hql
	 */
	public static <T> T queryOne(String hql, Object... obj) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery(hql);
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					query.setParameter(i, obj[i]);
				}
			}
			Object result = query.uniqueResult();
			return obj != null ? (T) result : null;
		} finally {
			HibernateUtil.close(session);
		}
	}

	/*
	 * 根据实体类名,查询所有的记录@param calzz
	 */
	public static <T> List<T> queryAll(Class<?> clazz) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			List<T> list = session.createQuery("from" + clazz.getName()).list();
			return list;
		} finally {
			HibernateUtil.close(session);
		}
	}

	/*
	 * 根据hql语句查询所有的记录
	 */
	public static <T> List<T> queryAll(String hql, Object... obj) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery(hql);
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					query.setParameter(i, obj[i]);
				}
			}
			return query.list();
		} finally {
			HibernateUtil.close(session);
		}
	}
}
