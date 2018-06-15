package com.wq.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wq.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountDemo {
    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void fun1() {
        System.out.println(accountService);
        accountService.transfer(2, 1, 200.00);
    }
}
