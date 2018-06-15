package com.wq.account;

public interface AccountDao {
    //存钱
     void increaseMoney(Integer id,double money);
    //取钱
     void decreaseMoney(Integer id,double money);
}
