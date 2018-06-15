package com.wq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wq.service.UserService;
import com.wq.service.impl.UserServiceImpl;

public class UserServiceProxyFactory implements InvocationHandler {
    public UserService getUserServiceProxy() {
        // 生成动态代理 this是由代理实例的调用处理程序实现的接口(InvocationHandler)
        //Proxy.newProxyInstance(动态加载代理类,代理类实现接口,使用handler);
        UserService userProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(), this);
        return userProxy;
    }

    private UserService userService;//被代理者
     
    public UserServiceProxyFactory(UserService userService) {
        super();
        this.userService = userService;//传过来的被代理者
    }

    @Override
  //调用代理类的代理方法   Object proxy 谁来代理  Method method 方法 Object[] args 参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("打开事物");
        Object invoke = method.invoke(userService, args);
        System.out.println("提交事物");
        return invoke;
    }
}
