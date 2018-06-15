package com.wq.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wq.bean.Student;

public class DemoTest {
    @Test
    public void fun1() throws IOException {
        // mybatis的配置文件
        String resource = "mybatis-config.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = DemoTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        // Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        // SqlSessionFactory sessionFactory = new
        // SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        /*
         * 在命名空间“com.wq.mapper.StudentMapper”中定义了一个名为“getStudentById”的映射语句，
         * 这样它就允许你使用指定的完全限定名“com.wq.mapper.StudentMapper.getStudentById”来调用映射语句，
         * 格式：命名空间名(namespace)+映射语句名(id)
         */

        String statement = "com.wq.mapper.StudentMapper.getStudentById";// 映射sql的标识字符串
        // 执行查询返回一个唯一user对象的sql
        Student student = session.selectOne(statement, 1);
        System.out.println(student);
        session.close();
    }
    
    
    
    
}