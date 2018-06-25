package com.wq.test;

import org.junit.Test;

import com.wq.dao.StudentDao;
import com.wq.dao.Imp.StudentDaoImp;
import com.wq.entity.Student;

public class StudentTest {
	@Test
	public void addTest() {
		// 实例化StudentImp对象
		StudentDao dao = new StudentDaoImp();
		// 创建一个对象
		Student s = new Student("我的天", "wq023", "男", "湖南长沙");
		dao.addStudent(s);
	}

	@Test
	public void removeTest() {
		StudentDao dao = new StudentDaoImp();
		dao.removeStudent("我的天");
	}

	@Test
	public void removeTest2() {
		StudentDao dao = new StudentDaoImp();
		dao.removeStudent(5);
	}
	
	@Test
	public void updateTest() {
		StudentDao dao = new StudentDaoImp();
		Student s=new Student(4,"窝的天","wqss","女","上海");
		dao.updateStudent(s);
	}
	
	@Test 
	public void findTest(){
		StudentDao dao =new StudentDaoImp();
		Student s=dao.findById(2);
		System.out.println(s);
		  
	}
}
