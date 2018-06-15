package com.wq.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

 
import com.wq.bean.User;
import com.wq.dao.UserDao;
import com.wq.util.MyBatisUtils;

public class UserDaoImpl implements UserDao {
    
    @Override
    public User getByUserId(Integer id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        String statement = "com.wq.mapper.UserMapper.getUserById";// 映射sql的标识字符串
        // 执行查询返回一个唯一user对象的sql
        User user = sqlSession.selectOne(statement, id);
        sqlSession.close();
        return user;
    }

}
