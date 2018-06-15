package com.wq.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.wq.dao.CustomerDao;
import com.wq.dao.impl.CustomerDaoImpl;
import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
import com.wq.service.CustomerService;
import com.wq.util.HibernateUtil;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 调用保存方法
     */
    @Override
    public void addCustomer(Customer c) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            customerDao.addCustomer(c);
        } catch (Exception e) {
            tx.rollback();
        }
        tx.commit();
    }

    /*
     * 根据条件查询(离线查询)
     * 
     * @see com.wq.service.CustomerService#getAll(org.hibernate.criterion.
     * DetachedCriteria)
     */
    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            return customerDao.getAll(dc);
        } catch (Exception e) {
            tx.rollback();
        }
        tx.commit();
        return null;
    }

    @Override
    public void delete(Long custId) {
        // TODO Auto-generated method stub
        Session session=HibernateUtil.getCurrentSession();
        Transaction tx=session.beginTransaction();
        customerDao.delete(custId);
        tx.commit();
        
    }

}
