package com.wq.service.impl;

import com.wq.account.AccountDao;
import com.wq.service.AccountService;

public class AccountServiceImpl  implements AccountService{
    private AccountDao dao;
    

    public AccountDao getDao() {
        return dao;
    }


    public void setDao(AccountDao dao) {
        this.dao = dao;
    }


    @Override
    public void transfer(Integer from, Integer to, Double money) {
        // TODO Auto-generated method stub
        dao.increaseMoney(to, money);
        dao.decreaseMoney(from, money);
    }

    

}
