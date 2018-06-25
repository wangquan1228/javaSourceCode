package com.wq.dao;

import com.wq.entity.Student;
//定义接口
public interface StudentDao {
	//添加学生
	void addStudent(Student s);
	//删除一个学生
	void removeStudent(String name);
	void removeStudent(int id);
	
	//修改信息
	Student updateStudent(Student s);
	//查找学生
	Student findById(int id);
	

}
