package com.wq.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.wq.bean.LinkMan;
import com.wq.bean.User;
import com.wq.dao.LinkManDao;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

    @Override
    public void updateLinkMan(Long cust_id) {
        // TODO Auto-generated method stub
        getHibernateTemplate().execute(new HibernateCallback<List<LinkMan> >() {
            @Override
            public List<LinkMan> doInHibernate(Session session) throws HibernateException {
                String hql = "from LinkMan  where lkm_cust_id=?";
                Query query = session.createQuery(hql);
                query.setParameter(0, cust_id);
                List<LinkMan> list = query.list();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setCustomer(null);
                    }
                }
                return list;
            }

        });

    }

}
