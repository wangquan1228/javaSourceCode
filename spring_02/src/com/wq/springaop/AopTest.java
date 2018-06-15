package com.wq.springaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wq.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:com/wq/springaop/applicationContext.xml")//为容器选择配置文件
public class AopTest {
    @Resource(name = "userService")
    private UserService userService;

    @Test
   public void fun1() {
        userService.save();
    }

}
