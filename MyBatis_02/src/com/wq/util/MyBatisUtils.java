package com.wq.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

 

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
  
    static {
        String resource = "mybatis-config.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyBatisUtils.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        //sqlSessionFactory的build(reader, environment, props) read指的是加载的config.xml文件，environment指配置的环境，props指的是参数
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    
    public static SqlSession getSession() {
        return  sqlSessionFactory.openSession();
    }
}
