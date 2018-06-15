package com.wq.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wq.bean.User;
import com.wq.dao.UserDao;

//HibernateDaoSupport 为dao注入sessionFactory
public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao {
      
    @Override
    public User getUserByCode (String code) {
        // TODO Auto-generated method stub
       return  getHibernateTemplate().execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session session) throws HibernateException {
                //hql语句
                String hql="from User where user_code = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, code);
                User user = (User) query.uniqueResult();
                return user;
                
                
              /*  ////Criteria
               DetachedCriteria dc = DetachedCriteria.forClass(User.class);
              dc.add(Restrictions.eq("user_code", usercode));
               List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
               
               if(list !=null &&list.size()>0){
                   return list.get(0);
               }else{
                   return null;
               }
                   */            }
        });
    }



     


     

}
