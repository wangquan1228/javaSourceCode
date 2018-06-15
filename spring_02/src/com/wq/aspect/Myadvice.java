package com.wq.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Myadvice {
    // 前置通知==>目标方法执行之前调用
    public void before() {
        System.out.println("我是前置通知");
    }

    // 后置通知===>目标方法执行之后调用(出现异常不会调用)
    public void afterReturning() {
        System.out.println("我是后置通知(如果出现异常不会执行)");
    }

    // 环绕通知===>目标方法执行之前和之后都执行
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分！！");
        Object proceed = pjp.proceed();// 调用目标方法
        System.out.println("这是环绕通知之后的部分！！");
        return proceed;
    }

    // 异常通知===>出现异常进行调用
    public void afterExcepiton() {
        System.out.println("出现异常后的通知");
    }

    // 后置通知===>无论是否出现异常都调用
    public void after() {
        System.out.println("我是后置通知");
    }
}
