package com.wq.dao.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.wq.dao.CustomerDao;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
import com.wq.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void addCustomer(Customer c) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        session.save(c);

    }

    /*
     * 根据条件获取对象
     */
    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        Criteria c = dc.getExecutableCriteria(session);
        List<Customer> custList = c.list();
        return custList;
    }
    /*
     * 当所删表数据中的主键是另外一个表的外键时,先要移除外键(将外键设为null),然后再删除你想删除的表数据
     * 当数据为一对多关系时,要用list集合来接受,然后依次将外键设为null
     * @see com.wq.dao.CustomerDao#delete(java.lang.Long)
     */
    @Override
    public void delete(Long custId) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        String hql = "from LinkMan  where lkm_cust_id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, custId);
        List<LinkMan> list = query.list();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCustomer(null);
            }
        }
        Customer customer = session.get(Customer.class, custId);
       /* if(customer==null) {
           
           PrintWriter dao;
        try {
            dao = ServletActionContext.getResponse().getWriter(); 
            dao.println("<script> alert('该用户不存在,请 ')</script>");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        }*/
        session.delete(customer);
    }

}
