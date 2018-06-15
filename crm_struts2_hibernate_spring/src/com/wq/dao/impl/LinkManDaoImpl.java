package com.wq.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;

import com.wq.dao.LinkManDao;
import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
import com.wq.util.HibernateUtil;

public class LinkManDaoImpl implements LinkManDao{
	/*
	 * 获取联系人列表
	 * @see com.wq.dao.LinkManDao#list()
	 */
	 
	@Override
	public List<LinkMan> list(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		Criteria c=dc.getExecutableCriteria(session);
		List<LinkMan> lkmList = c.list();
		return lkmList;
	}
	 
	@Override
	public void addLinkMan(LinkMan man, Long custId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		Customer customer = session.get(Customer.class, custId);
		customer.getLinkMans().add(man);
		man.setCustomer(customer);
		session.save(customer);
	}
}
