package com.wq.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wq.bean.User;
import com.wq.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 模型驱动
    User user = new User();

    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }

    // 属性驱动
    // 原来的密码
    private String olduserPassword;

    public String getOlduserPassword() {
        return olduserPassword;
    }

    public void setOlduserPassword(String olduserPassword) {
        this.olduserPassword = olduserPassword;
    }

    public String login() {
        // 1 调用service 的业务逻辑
        User user1 = userService.getUSerByCodePassword(user);
        // 2 将返回的user对象放在session域中
        ActionContext.getContext().getSession().put("user", user1);
        // 3 重定向你想要得页面
        return "toHome";
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
     * 
     */
     public String updatePwd() throws Exception{
       
         User  user1 = userService.getById(user.getUser_id());
         String pwd=user1.getUser_password();
         if(pwd.equals(olduserPassword)) {
             user1.setUser_password(user.getUser_password());
             userService.updateUserPwd(user1);
             return "login";
         }
         ActionContext.getContext().put("msg", "你输入的原密码有误...");
         return "toupdate"; 
         
     }
}
