package com.wq.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wq.dao.SysUserDao;
import com.wq.dao.impl.SysUserDaoImp;
import com.wq.entity.SysUser;
import com.wq.service.SysUserService;
import com.wq.util.HibernateUtil;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysUserDao;

    public SysUserDao getSysUserDao() {
        return sysUserDao;
    }

    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public SysUser login(SysUser user) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
          try {
            // SysUser user2 =sysUserDao.login(user);
            return sysUserDao.login(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
           tx.rollback();
        }
          tx.commit();
          return null;
    }

    @Override
    public String upatePwd(SysUser user, String olduserPassword) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        String str = sysUserDao.updatePwd(user, olduserPassword);

        tx.commit();
        return str;
    }

}
