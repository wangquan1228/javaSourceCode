package com.wq.dao.impl;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wq.bean.Student;
import com.wq.dao.StudentDao;

/*
 * studentDao 的实现类
 */
public class StudentDaoImpl implements StudentDao {
    // 注入
    private SqlSessionFactory sqlSessionFactory;

    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Student getStudentById(int id) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.wq.mapper.StudentMapper.getStudentById";// 映射sql的标识字符串
        // 执行查询返回一个唯一user对象的sql
        Student student = sqlSession.selectOne(statement, id);
        sqlSession.close();
        return student;
    }

    @Override
    public void addStudent(Student stu) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        String statement = "com.wq.mapper.StudentMapper.addStudent";// 映射sql的标识字符串
        int rows=sqlSession.insert(statement, stu);
        System.out.println("行数:"+rows);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void deleteStudent(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.wq.mapper.StudentMapper.deleteStudent";// 映射sql的标识字符串
        int rows=sqlSession.delete(statement, id);//删除的行数
        System.out.println("删除的个数:"+rows);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateStudent(Student stu) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.wq.mapper.StudentMapper.updateStudent";// 映射sql的标识字符串
       int rows= sqlSession.update(statement, stu);
        System.out.println("修改成功"+rows);
        sqlSession.commit();
        sqlSession.close();

    }
         
    @Override
    public List<Student> getStudentlist() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.wq.mapper.StudentMapper.getStudentList";// 映射sql的标识字符串
        // 执行查询返回一个唯一user对象的sql
        List<Student> list = sqlSession.selectList(statement);
        sqlSession.close();
        return list;
    }

}
