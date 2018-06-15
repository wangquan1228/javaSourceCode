package com.wq.service;

public interface AccountService {
    //转账
    void transfer(Integer from, Integer to, Double money);

}
