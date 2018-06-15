package com.wq.dao;

import com.wq.bean.User;

public interface UserDao {
    User getByUserId(Integer id);
}
