package com.wq.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HolleWorld {
    @RequestMapping("/hello")
    public String hello() {
        return "login";
    }

    @RequestMapping("mv")
    public ModelAndView mv() {
        System.out.println("ModelAndView");
        ModelAndView view = new ModelAndView();
        view.setViewName("success");
        return view;
    }

    @RequestMapping("login")
    public String login(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd, Model model) {

        //表单第一次提交时<input>中的value值为是空字符串不是null
        if (userName != ""  && userPwd != "") {
            if (userName.equals("admin") && userPwd.equals("123")) {
                return "success";
            } else {
                model.addAttribute("msg", "你输入的用户名和密码不正确!,请重新输入!");
                return "login";
            }

        } else {
            model.addAttribute("msg", "用户名和密码不能为空!");
            return "login";
        }

    }
}
