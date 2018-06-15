package com.wq.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.wq.dao.LinkManDao;
import com.wq.dao.impl.LinkManDaoImpl;
import com.wq.entity.LinkMan;
import com.wq.service.LinkManService;
import com.wq.util.HibernateUtil;

public class LinkManServiceImpl implements LinkManService {
    private  LinkManDao linkManDao;
    
     

    

    public LinkManDao getLinkManDao() {
        return linkManDao;
    }

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    @Override
    public List<LinkMan> lkmListService(DetachedCriteria dc) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            return linkManDao.list(dc);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            tx.rollback();
        }
        tx.commit();
        return null;

    }

    /*
     * 添加联系人
     * 
     * @see com.wq.service.CustomerService#addLinkMan(com.wq.entity.LinkMan,
     * java.lang.Long)
     */
    @Override
    public void addLinkMan(LinkMan man, Long custId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        linkManDao.addLinkMan(man, custId);
        tx.commit();
    }

    /*
     * 根据条件查询(离线查询)
     * 
     * @see com.wq.service.CustomerService#getAll(org.hibernate.criterion.
     * DetachedCriteria)
     */

}
