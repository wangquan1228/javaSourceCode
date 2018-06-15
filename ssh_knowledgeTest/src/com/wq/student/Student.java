package com.wq.student;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

import com.wq.person.Person;

public class Student extends Person {
    @Test
    public void fun1() {
        Person person = new Student();
        Class clazz = this.getClass();
        System.out.println(this);
        System.out.println("clazz值:" + clazz);
        Type type = this.getClass().getGenericSuperclass();
        System.out.println("type值:" + type);
        // 强转为“参数化类型”
        // ParameterizedType参数化类型，即泛型
        ParameterizedType pt = (ParameterizedType) type; // BaseDao
        // 获取参数化类型中，实际类型的定义
        Type[] ts = pt.getActualTypeArguments();
        // 转换
        Class c = (Class) ts[0];
        System.out.println("c值:" + c);
    }
}
