package com.wq.service.impl;

import com.wq.service.UserService;
/**
 *service 的实现类
 * @author Administrator
 *
 */
public class UserServiceImpl  implements UserService{

    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("保存用户");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        System.out.println("修改用户");
    }

    @Override
    public void find() {
        // TODO Auto-generated method stub
        System.out.println("查找用户");
    }

}
