package com.wq.dao;

import java.util.List;

import com.wq.bean.Student;

import sun.security.util.UntrustedCertificates;

public interface StudentDao {
    public Student getStudentById(int id);
    
    public List<Student> getStudentlist();
    
    public void addStudent(Student stu);
    
    public void deleteStudent(int id);
    
    public void updateStudent(Student stu);
}
