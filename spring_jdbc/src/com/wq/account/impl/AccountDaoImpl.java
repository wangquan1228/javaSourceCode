package com.wq.account.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wq.account.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void increaseMoney(Integer id, double money) {
        // TODO Auto-generated method stub
        getJdbcTemplate().update("update   account set money=money+? where id=?", money, id);
    }

    @Override
    public void decreaseMoney(Integer id, double money) {
        // TODO Auto-generated method stub
        getJdbcTemplate().update("update account  set money=money-? where id=?", money, id);
    }

}
