package com.wq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Update;

import com.wq.dao.SysUserDao;
import com.wq.entity.Customer;
import com.wq.entity.SysUser;
import com.wq.util.DBUtil;
import com.wq.util.HibernateUtil;

public class SysUserDaoImp implements SysUserDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * 登录验证方法实现
     */
    @Override
    public SysUser login(SysUser user) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        String hql = "from SysUser where userName=? and userPassword=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, user.getUserName());
        query.setParameter(1, user.getUserPassword());
        SysUser user1 = (SysUser) query.uniqueResult();
        return user1;
    }

    /*
     * 修改密码
     * 
     * @see com.wq.dao.SysUserDao#updatePwd(com.wq.entity.SysUser)
     */
    @Override
    public String updatePwd(SysUser user, String olduserPassword) {
        // TODO Auto-generated method stub
        Session session = HibernateUtil.getCurrentSession();
        SysUser sysUser = session.get(SysUser.class,user.getUserId());
        String pwd=sysUser.getUserPassword();
        if (pwd .equals(olduserPassword) ) {
            sysUser.setUserPassword(user.getUserPassword());
            session.update(sysUser);
            return "success";
        }
        return " error";
    }

}
