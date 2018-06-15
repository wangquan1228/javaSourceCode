package com.wq.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wq.bean.User;
import com.wq.dto.UserDto;
import com.wq.mapper.UserMapper;
import com.wq.service.UserService;
import com.wq.service.impl.UserServiceImpl;
import com.wq.util.MyBatisUtils;

public class MyBatisTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void getUserByIdTest() {
        User user = userService.getByUserId(1);
        System.out.println(user);

    }

    /*
     * mapper 动态代理测试
     */
    @Test
    public void getUserByIdTest1() {
        SqlSession session = MyBatisUtils.getSession();
        // 获取mapper接口代理对象
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        User user = userMapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void getUserListTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserList();
        System.out.println(list);
    }

    @Test
    public void addUserTest() {
        User user = new User();
        user.setName("海草");
        user.setAge(20);
        user.setPassword("234");
        user.setCreateTime(new Date());
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        userMapper.addUser(user);
        session.commit();
        session.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        userMapper.deleteUser(1);
        session.commit();
        session.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setName("wq");
        user.setAge(20);
        user.setPassword("234");
        user.setCreateTime(new Date());
        userMapper.updateUser(user);
        session.commit();
        session.close();
    }

    @Test
    public void getUserByNameAndPwd() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        User user = userMapper.getUserByNameAndPwd("wq", "234");
        System.err.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void getUserByUserDtoTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        UserDto userDto = new UserDto();
        User user = new User();
        user.setName("海草");
        userDto.setUser(user);
        List<User> list = userMapper.getUserByUserDto(userDto);
        System.out.println(list);
    }

    @Test
    public void getUserCountTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        int a = userMapper.getUserCount();
        System.out.println(a);
    }

    /*
     * 查询结果以hashmap返回
     */
    @Test
    public void getUserListMapTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        List<Map<Object, Object>> userListMap = userMapper.getUserListMap();
        for (Map<Object, Object> u : userListMap) {
            System.out.println(u);
        }
    }

    /*
     * 输出resultMap集
     */
    @Test
    public void getUserListByResultMapTest() {
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = (UserMapper) session.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserListByResultMap();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
}
