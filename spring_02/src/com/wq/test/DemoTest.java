package com.wq.test;

import java.lang.reflect.InvocationHandler;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wq.bean.User;
import com.wq.proxy.UserServiceProxyFactory;
import com.wq.proxy.UserServiceProxyFactory2;
import com.wq.service.UserService;
import com.wq.service.impl.UserServiceImpl;

public class DemoTest {
    @Test
    public void fun1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }

    /*
     * 动态代理测试
     */
    @Test
    public void fun2() {
        UserService userService = new UserServiceImpl();
        UserServiceProxyFactory userServiceProxyFactory = new UserServiceProxyFactory(userService);
        UserService userServiceProxy = userServiceProxyFactory.getUserServiceProxy();
        userServiceProxy.save();
    }
    /*
     * eglib代理测试
     */
    @Test
    public void fun3() {
       UserServiceProxyFactory2 userServiceProxyFactory2 = new  UserServiceProxyFactory2(); 
       UserService userServiceProxy = userServiceProxyFactory2.getUserServiceProxy();
       userServiceProxy.save();
    }
}
