package com.wq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.wq.service.UserService;
import com.wq.service.impl.UserServiceImpl;

public class UserServiceProxyFactory2 implements MethodInterceptor {
    private UserService userService;

    // cglib代理
    public UserService getUserServiceProxy() {
        Enhancer en = new Enhancer();// 生成代理对象
        en.setSuperclass(UserServiceImpl.class);// 设置对谁进行代理
        en.setCallback(this);// 代理对象需要做啥
        UserService userservice = (UserService) en.create();// 创建代理对象
        return userservice;

    }

    @Override
    public Object intercept(Object proxyObj, Method method, Object[] arg2, MethodProxy methodProxy) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("打开事物");
        Object invokeSuper = methodProxy.invokeSuper(proxyObj, arg2);
        System.out.println("提交事物");
        return invokeSuper;
    }

}
