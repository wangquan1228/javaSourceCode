package com.wq.bean;

import java.util.Date;

public class User {
    private Integer id;
    
    private String name;
    
    private String password;

    private Integer age;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User(Integer id, String name, String password, Integer age, Date createTime) {
        
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.createTime = createTime;
    }

    public User() {
       
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", createTime=" + createTime + "]";
    }
    
    

}
