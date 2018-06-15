package com.wq.service.impl;

import com.wq.bean.User;
import com.wq.dao.UserDao;
import com.wq.dao.impl.UserDaoImpl;
import com.wq.service.UserService;

public class UserServiceImpl  implements UserService{
     
    private UserDao dao=new UserDaoImpl();
    @Override
    public User getByUserId(Integer id) {
        // TODO Auto-generated method stub
        return dao.getByUserId(id);
    }

    

}
