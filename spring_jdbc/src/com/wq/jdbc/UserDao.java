package com.wq.jdbc;

import java.util.List;

import com.wq.bean.User;

 

public interface UserDao {
    void save(User user);

    void delete(Integer id);

    void update(User user);

       List<User> getAll( );

    User findById(Integer id);

    int getTotalCount();
}
