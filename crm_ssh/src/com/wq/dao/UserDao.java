package com.wq.dao;

import com.wq.bean.User;

public interface UserDao extends BaseDao<User>{
   
   User getUserByCode(String code);

    
}
