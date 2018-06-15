package com.wq.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionSupport;
import com.wq.entity.SysUser;
import com.wq.service.SysUserService;
import com.wq.service.impl.SysUserServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DemoTestAction extends ActionSupport {
     @Resource( name="sysUserService")
     private SysUserService sysUserService;
     private SysUser user;

     public SysUser getUser() {
         return user;
     }

     public void setUser(SysUser user) {
         this.user = user;
     }
    @Test
    public void fun1() {
        System.out.println(user);
        System.out.println(sysUserService);
    }
    
    @Test
    public  void fun4() {
          SysUserService  sysuserservice=new SysUserServiceImpl();
          SysUser user=new SysUser();
         user.setUserId(1L);
          user.setUserName("wq");
          user.setUserPassword("123");
         
          String str = sysUserService.upatePwd(user, "123");
          System.out.println(user);
          if (str.equals("success")) {
             System.out.println(1);
          } else {
             System.out.println(2);
          } 
    }
}
