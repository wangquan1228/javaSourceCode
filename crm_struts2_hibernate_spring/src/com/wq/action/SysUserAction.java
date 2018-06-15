package com.wq.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wq.entity.SysUser;
import com.wq.service.SysUserService;

public class SysUserAction extends ActionSupport {
    // 获得Sping容器=》从Application获取

    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    SysUserService sysUserService = (SysUserService) ac.getBean("sysUserService");

    private SysUser user;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    private String olduserPassword;

    public String getOlduserPassword() {
        return olduserPassword;
    }

    public void setOlduserPassword(String olduserPassword) {
        this.olduserPassword = olduserPassword;
    }

    /*
     * 登录
     */
    public String login() {

        SysUser user1 = sysUserService.login(user);
        if (user1 != null) {
            // 将对象存储到session域中
            ActionContext.getContext().getSession().put("user1", user1);
            return "success";
        } else {
            ServletActionContext.getRequest().setAttribute("err", "密码或者用户有误,请重新输入!");
            return "login";
        }
    }

    /*
     * 安全退出
     */
    public String logout() {
        // 通过ServletActionContext获取session域中
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.invalidate();// 销毁session
        return "logout";
    }

    /*
     * 修改密码
     */
    public String updatePwd() {
        System.out.println(user);
        String str = sysUserService.upatePwd(user, olduserPassword);
        if (str.equals("success")) {
            return "login";
        } else {
            return "error";
        }
    }
}
