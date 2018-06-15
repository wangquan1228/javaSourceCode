package com.wq.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import com.wq.bean.Student;
import com.wq.dao.StudentDao;
import com.wq.dao.impl.StudentDaoImpl;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        String resource = "mybatis-config.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = DemoTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void getStudentByIdTest() {
        StudentDao dao = new StudentDaoImpl(sqlSessionFactory);
        System.out.println(dao.getStudentById(1));
    }

    @Test
    public void getStudentListTest() {
        StudentDao dao = new StudentDaoImpl(sqlSessionFactory);
        List<Student> list = dao.getStudentlist();
        System.out.println(list);

    }

    @Test
    public void addStudent() {
        StudentDao dao = new StudentDaoImpl(sqlSessionFactory);
        Student student = new Student();
        student.setName("小南");
        student.setAge(12);
        student.setCreateTime(new Date());
        dao.addStudent(student);
    }
    
    @Test
    public void deleteStudentTest() {
        StudentDao dao=new StudentDaoImpl(sqlSessionFactory);
        dao.deleteStudent(2);
    }
    
    @Test
    public void updateStudent() {
        StudentDao dao = new StudentDaoImpl(sqlSessionFactory);
        Student student = new Student();
        student.setId(2);
        student.setName("小江");
        student.setAge(18);
        student.setCreateTime(new Date());
        dao.updateStudent(student);
    }
}
