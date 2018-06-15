package com.wq.mapper;

import java.util.List;
import java.util.Map;

import com.wq.bean.User;
import com.wq.dto.UserDto;

public interface UserMapper {

    public User getUserById(Integer id);

    public List<User> getUserList();

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);

    public User getUserByNameAndPwd(String name, String password);

    // 通过包装类查询
    public List<User> getUserByUserDto(UserDto userDto);

    // 计算数据条数
    public Integer getUserCount();

    // 返回一个HashMap
    public List<Map<Object, Object>> getUserListMap();

    // 查询部分字段,以resultMap返回
    public List<User> getUserListByResultMap();
}
