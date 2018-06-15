package com.wq.bean;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("user") // 建议采用分层的方法
// @Service("user") // service层
// @Controller("user") // web层
/// @Repository("user") // dao层
public class User {
    // @Value("wq")
    private String name;
    // @Value("18")
    private Integer age;
    // @Autowired//自动 装配
    // 问题：如果匹配到多个类型一致的对象，将无法选择具体注入哪一个对象
    // @Qualifier("car2")//使用@Qualifier注解告诉Spirng容器自动装配那个名称的对象
    @Resource(name = "car") // 手动注入，指定注入那个名称的对象
    private Car car;

    public Car getCar() {
        return car;
    }

   
    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    @Value("王全") // 配置第一个参数时,只需要填入值
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Value(value = "18") // 配置第二个参数时,需要填写value
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
    }

}
